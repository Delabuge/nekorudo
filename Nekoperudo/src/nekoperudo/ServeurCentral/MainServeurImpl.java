package nekoperudo.ServeurCentral;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import nekoperudo.Interface.Nekoperudo;

public class MainServeurImpl extends UnicastRemoteObject implements Nekoperudo {

    /*    List<String> indexPseudoJoueurs = new ArrayList<String>();
    Map<String, JoueurNotification> listeCoJoueurs = new HashMap<String, JoueurNotification>(6);
    Map<String, Joueur> listeJoueurs = new HashMap<String, Joueur>(6);
    int nbrJoueurPret = 0;
    int numAToiDeJouer = 0;
    int numTour = 0;
    int nbDice = 0;
    int valDiceParier = 0;*/
    Mise miseMax = new Mise(0, 2);

    String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};
    int gob[] = new int[5];

    List<String> indexListePartie = new ArrayList<String>();
    Map<String, Partie> listePartie = new HashMap<String, Partie>(6);
    Partie partie2 = new Partie("Partie 2 joueurs", 2);
    Partie partie3 = new Partie("Partie 3 joueurs", 3);
    Partie partie4 = new Partie("Partie 4 joueurs", 4);
    Partie partie5 = new Partie("Partie 5 joueurs", 5);
    Partie partie6 = new Partie("Partie 6 joueurs", 6);

    public MainServeurImpl() throws RemoteException {
        super();
    }

    public static void main(String[] argv) throws Exception {

        LocateRegistry.createRegistry(1099);
        Naming.rebind("MJ", new MainServeurImpl());
        System.out.println("Registre RMI OK");

    }

    public synchronized void enregistrerNotification(String id, JoueurNotification b) throws RemoteException {
        Joueur cpt = new Joueur();
        cpt.setNotification(b);
    }

    public boolean selectionnerPartie(String pPseudo, int pChoixPartie, JoueurNotification pNotif) throws RemoteException {
        boolean joueurAjouteOk = false;
        Mise miseJ = new Mise(0, 2);
        int choixPartie = pChoixPartie;

        if (listePartie.get(pChoixPartie).nbrJoueurPret < listePartie.get(pChoixPartie).nbrJoueurMax) {
            listePartie.get(pChoixPartie).listeJoueurs.put(pPseudo, listePartie.get(pChoixPartie).listeJoueurs.get(pPseudo));
            listePartie.get(pChoixPartie).indexPseudoJoueurs.add(pPseudo);
            listePartie.get(pChoixPartie).listeCoJoueurs.put(pPseudo, pNotif);
            listePartie.get(pChoixPartie).nbrJoueurPret = listePartie.get(pChoixPartie).nbrJoueurPret + 1;
            System.out.println("Joueur " + pPseudo + " ajouter à la partie " + listePartie.get(pChoixPartie).nomPartie);
        } else {
            pNotif.notifTropDeJoueur(listePartie.get(pChoixPartie).nomPartie);
            System.out.println("Joueur " + pPseudo + " a tenté de rejoindre une partie complete");
        }

        return joueurAjouteOk;
    }

    public boolean rejoindrePartie(String pPseudo, JoueurNotification pNotif, int ppChoixPartie) throws RemoteException {
        boolean joueurAjouteOk = false;
        Mise miseJ = new Mise(0, 2);
        String pChoixPartie = Integer.toString(ppChoixPartie);

        if (listePartie.isEmpty()) {
            listePartie.put("2", partie2);
            listePartie.put("3", partie3);
            listePartie.put("4", partie4);
            listePartie.put("5", partie5);
            listePartie.put("6", partie6);
            System.out.println("Parties initialisées");
        }

        if (listePartie.get(pChoixPartie).listeJoueurs.size() < 6) {
            if (listePartie.get(pChoixPartie).listeJoueurs.isEmpty()) {
                listePartie.get(pChoixPartie).listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[1], gob, pPseudo, false, pNotif, miseJ, false));
                listePartie.get(pChoixPartie).listeCoJoueurs.put(pPseudo, pNotif);
                listePartie.get(pChoixPartie).indexPseudoJoueurs.add(pPseudo);
                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            } else {
                listePartie.get(pChoixPartie).listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[listePartie.get(pChoixPartie).listeJoueurs.size() + 1], gob, pPseudo, false, pNotif, miseJ, false));
                listePartie.get(pChoixPartie).listeCoJoueurs.put(pPseudo, pNotif);
                listePartie.get(pChoixPartie).indexPseudoJoueurs.add(pPseudo);

                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            }
        }
        return joueurAjouteOk;
    }

    public boolean JoueurPret(String pPseudo, JoueurNotification pNotif, int ppChoixPartie) throws RemoteException {
        boolean JoueurPretOk = false;
        int i;
        int j;
        int k;
        String notifAtoiJouerGobelet;
        String pChoixPartie = Integer.toString(ppChoixPartie);

        if (listePartie.get(pChoixPartie).listeJoueurs.containsKey(pPseudo)) {
            listePartie.get(pChoixPartie).listeJoueurs.get(pPseudo).JoueurPret = true;

            JoueurPretOk = true;
        }

        if (listePartie.get(pChoixPartie).nbrJoueurMax == 2) {
            k = 0;
        } else {
            k = 1;
        }
        for (i = k; i < listePartie.get(pChoixPartie).nbrJoueurMax; i++) {

            if (listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).JoueurPret == true) {
                listePartie.get(pChoixPartie).nbrJoueurPret = listePartie.get(pChoixPartie).nbrJoueurPret + 1;
                System.out.println("Partie " + pChoixPartie + " nbrJoueurPret=" + listePartie.get(pChoixPartie).nbrJoueurPret + "listeJoueurs.size()=" + listePartie.get(pChoixPartie).listeJoueurs.size());
                if (listePartie.get(pChoixPartie).nbrJoueurPret == listePartie.get(pChoixPartie).nbrJoueurMax) {
                    break;
                }
            }

        }

        if (listePartie.get(pChoixPartie).nbrJoueurPret == listePartie.get(pChoixPartie).nbrJoueurMax) {

            Random joueurRandom = new Random();
            int num1erJoueurRandom = joueurRandom.nextInt(listePartie.get(pChoixPartie).listeJoueurs.size());
            listePartie.get(pChoixPartie).numAToiDeJouer = num1erJoueurRandom;

            listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(num1erJoueurRandom)).AToiDeJouer = true;
            System.out.println(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(num1erJoueurRandom) + " est le premier a jouer");
            //Pour de prochaines parties, on réinitialise la var nbrJoueurPret
            int nbrJoueurPret = 0;

            for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
                listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).gobelet = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).lancerDice(listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nbDice);
                notifAtoiJouerGobelet = "";
                for (j = 0; j < listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nbDice; j++) {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).gobelet[j];
                }

                if (i != listePartie.get(pChoixPartie).numAToiDeJouer) {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",false";
                    listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).initialiserPartie(notifAtoiJouerGobelet);
                } else {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",true";
                    listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).initialiserPartie(notifAtoiJouerGobelet);
                }
            }
        }

        return JoueurPretOk;
    }

    public void actionJoueur(int pChoixJoueur, String pPseudo, int ppChoixPartie) throws RemoteException {
        int i;
        System.out.println("Action Joueur :");
        int actionReussit = 0;
        int numprecedent = 0;
        String retourResultat = " ";
        String pChoixPartie = Integer.toString(ppChoixPartie);

        switch (pChoixJoueur) {

            // Annonce Menteur
            case 1:
                System.out.println(pPseudo + " annonce menteur");

                actionReussit = comparerMiseDes(ppChoixPartie);

                if (actionReussit == 2) {
                    if (listePartie.get(pChoixPartie).numAToiDeJouer == 0) {
                        numprecedent = listePartie.get(pChoixPartie).indexPseudoJoueurs.size() - 1;
                    } else {
                        numprecedent = listePartie.get(pChoixPartie).numAToiDeJouer - 1;
                    }
                    System.out.println("numAToiDeJouer " + listePartie.get(pChoixPartie).numAToiDeJouer);
                    retourResultat = "A cause de " + listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).pseudo + ", " + listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numprecedent)).pseudo + " perd 1d";
                    listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numprecedent)).nbDice = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numprecedent)).nbDice - 1;
                } else {
                    listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).nbDice = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).nbDice - 1;
                    retourResultat = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).pseudo + " s'est trompé! il perd 1d";
                }

                for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
                    listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).resultatManche(retourResultat);
                }
                finManche(ppChoixPartie);
                finTour(ppChoixPartie);

                break;

            // Annonce Tout-pile
            case 2:
                System.out.println(pPseudo + " annonce tout-pile");
                actionReussit = comparerMiseDes(ppChoixPartie);

                if (actionReussit == 1) {
                    if (listePartie.get(pChoixPartie).listeJoueurs.get(pPseudo).nbDice < 5) {
                        listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).nbDice = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).nbDice + 1;
                    }
                } else {
                    listePartie.get(pChoixPartie).listeJoueurs.get(pPseudo).nbDice = listePartie.get(pChoixPartie).listeJoueurs.get(pPseudo).nbDice - 1;
                    retourResultat = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer)).pseudo + " s'est trompé en annoncant tout pile! il perd 1d";
                }

            
                for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
                    listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).resultatManche(retourResultat);
                }

                finManche(ppChoixPartie);
                finTour(ppChoixPartie);

                break;

            // Annonce surenchère
            case 3:
                System.out.println(pPseudo + " fait une Surenchere");
                finTour(ppChoixPartie);

                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
    }

    public int comparerMiseDes(int ppChoixPartie) {
        int nbr = 0;
        int nbr1 = 0;
        int nbr2 = 0;
        int nbr3 = 0;
        int nbr4 = 0;
        int nbr5 = 0;
        int nbr6 = 0;
        int i;
        int k;
        int leGobelet[];
        int miseVrai = 0;
        String pChoixPartie = Integer.toString(ppChoixPartie);

        for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
            leGobelet = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).getGobelet();

            for (k = 0; k < 5; k++) {

                switch (leGobelet[k]) {
                    case 1:
                        nbr1 = nbr1 + 1;
                        break;

                    case 2:
                        nbr2 = nbr2 + 1;
                        break;

                    case 3:
                        nbr3 = nbr3 + 1;
                        break;

                    case 4:
                        nbr4 = nbr4 + 1;
                        break;

                    case 5:
                        nbr5 = nbr5 + 1;
                        break;

                    case 6:
                        nbr6 = nbr6 + 1;
                        break;

                    default:
                        System.out.println("Erreur de valeur de dés");
                }
            }
            // Compter les 1 comme le valeur de dé de la mise
            switch (listePartie.get(pChoixPartie).miseMax.getValDice()) {
                case 2:
                    nbr = nbr2 + nbr1;
                    break;
                case 3:
                    nbr = nbr3 + nbr1;
                    break;
                case 4:
                    nbr = nbr4 + nbr1;
                    break;
                case 5:
                    nbr = nbr5 + nbr1;
                    break;
                case 6:
                    nbr = nbr6 + nbr1;
                    break;
                default:
                    System.out.println("Erreur de valeur de dés");
            }
        }

        // Tout-pile validé
        if (listePartie.get(pChoixPartie).miseMax.nbDiceParier == nbr) {
            miseVrai = 1;
        }
        // Menteur validé
        if (listePartie.get(pChoixPartie).miseMax.nbDiceParier > nbr) {
            miseVrai = 2;
        }

        System.out.println("Misevrai est a " + miseVrai);
        return miseVrai;
    }

    public void finTour(int ppChoixPartie) throws RemoteException {
        int i;
        System.out.println("fin tour");
        String pChoixPartie = Integer.toString(ppChoixPartie);

        System.out.println("numAToiDeJouer " + listePartie.get(pChoixPartie).numAToiDeJouer);
        if (listePartie.get(pChoixPartie).numAToiDeJouer + 1 < listePartie.get(pChoixPartie).nbrJoueurPret) {
            listePartie.get(pChoixPartie).numAToiDeJouer = listePartie.get(pChoixPartie).numAToiDeJouer + 1;
        } else {
            listePartie.get(pChoixPartie).numAToiDeJouer = 0;
        }
        System.out.println("numAToiDeJouer " + listePartie.get(pChoixPartie).numAToiDeJouer);
        System.out.println("ca va être a " + listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer));
        listePartie.get(pChoixPartie).numTour = listePartie.get(pChoixPartie).numTour + 1;

        for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
            if (i != listePartie.get(pChoixPartie).numAToiDeJouer) {
                listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nouveauTour(false);
                System.out.println(i + " ");
            } else {
                listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nouveauTour(true);
                System.out.println(i + " ");
            }
        }
    }

    public void surencherJoueur(int chiffre, int quantite, int ppChoixPartie) throws RemoteException {
        int i;
        String miseRenvoyer;
        String pChoixPartie = Integer.toString(ppChoixPartie);

        listePartie.get(pChoixPartie).miseMax.valDice = chiffre;
        listePartie.get(pChoixPartie).miseMax.nbDiceParier = quantite;
        miseRenvoyer = (quantite + " " + chiffre);
        System.out.println("Mise max mis à jour");

        for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
            listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).notifSurencherNbr(miseRenvoyer);
            // listeCoJoueurs.get(indexPseudoJoueurs.get(i)).notifSurencherNbr(miseMax.valDice);
            System.out.println("Mise max envoyé à " + listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i));
        }
    }

    public void finManche(int ppChoixPartie) throws RemoteException {
        int i;
        int numJoueurPerdu = -1;
        int numJoueurGagnant;
        int j;
        String notifAtoiJouerGobelet;
        boolean gagnant = false;
        String emploieFictif = "d";

        System.out.println("FinManche in");

        miseMax.nbDiceParier = 0;
        miseMax.valDice = 2;

        String pChoixPartie = Integer.toString(ppChoixPartie);

        // Permet de connaitre le numero du joueur qui aurait perdu à la fin de cette manche
        for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
            if (listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nbDice == 0) {
                numJoueurPerdu = i;
                if (listePartie.get(pChoixPartie).listeJoueurs.size() == 2) {
                    gagnant = true;
                    System.out.println("On a un gagnant!");
                }
            }
        }

        if (gagnant == false) {
            System.out.println("numAToiDeJouer " + listePartie.get(pChoixPartie).numAToiDeJouer);

            if (numJoueurPerdu == listePartie.get(pChoixPartie).numAToiDeJouer) {
                if (listePartie.get(pChoixPartie).indexPseudoJoueurs.size() > 2) {
                    if (listePartie.get(pChoixPartie).numAToiDeJouer + 1 < listePartie.get(pChoixPartie).indexPseudoJoueurs.size()) {
                        listePartie.get(pChoixPartie).numAToiDeJouer = listePartie.get(pChoixPartie).numAToiDeJouer + 1;
                    } else {
                        listePartie.get(pChoixPartie).numAToiDeJouer = 0;
                    }
                } else {
                    if (listePartie.get(pChoixPartie).numAToiDeJouer + 1 < listePartie.get(pChoixPartie).indexPseudoJoueurs.size()) {
                        listePartie.get(pChoixPartie).numAToiDeJouer = listePartie.get(pChoixPartie).numAToiDeJouer + 1;
                    } else {
                        listePartie.get(pChoixPartie).numAToiDeJouer = 0;
                    }
                }
            }

            System.out.println("ca va être a " + listePartie.get(pChoixPartie).indexPseudoJoueurs.get(listePartie.get(pChoixPartie).numAToiDeJouer));

            for (i = 0; i < listePartie.get(pChoixPartie).listeJoueurs.size(); i++) {
                if (numJoueurPerdu != i) {
                    System.out.println("numJoueurPerdu ! = i");
                    listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).gobelet = listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).lancerDice(listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nbDice);
                    notifAtoiJouerGobelet = "";
                    for (j = 0; j < listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nbDice; j++) {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + listePartie.get(pChoixPartie).listeJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).gobelet[j];
                    }

                    if (i != listePartie.get(pChoixPartie).numAToiDeJouer) {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",false";
                        listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nouvelleManche(notifAtoiJouerGobelet);
                    } else {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",true";
                        listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(i)).nouvelleManche(notifAtoiJouerGobelet);
                    }
                } else {
                    //Envoie tu as perdu!
                }
            }
        } else {
            if (numJoueurPerdu + 1 == 2) {
                numJoueurGagnant = 0;
            } else {
                numJoueurGagnant = 1;
            }

            System.out.println("pré envoie notif victoire a " + numJoueurGagnant);
            listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numJoueurGagnant)).notifVictoire(emploieFictif);
        }

        if (numJoueurPerdu != -1) {
            System.out.println("pré envoie notif loose a " + numJoueurPerdu);
            listePartie.get(pChoixPartie).listeCoJoueurs.get(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numJoueurPerdu)).notifLoose(emploieFictif);

            listePartie.get(pChoixPartie).listeJoueurs.remove(listePartie.get(pChoixPartie).indexPseudoJoueurs.get(numJoueurPerdu));
            listePartie.get(pChoixPartie).indexPseudoJoueurs.remove(numJoueurPerdu);
        }
        System.out.println("FinManche out");
    }

}
