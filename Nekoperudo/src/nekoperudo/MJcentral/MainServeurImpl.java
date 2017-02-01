package nekoperudo.MJcentral;

import static java.lang.Thread.sleep;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;


public class MainServeurImpl extends UnicastRemoteObject implements Nekoperudo {

    List<String> indexPseudoJoueurs = new ArrayList<String>();
    Map<String, JoueurNotification> listeCoJoueurs = new HashMap<String, JoueurNotification>(6);
    Map<String, Joueur> listeJoueurs = new HashMap<String, Joueur>(6);
    int nbrJoueurPret = 0;
    int numAToiDeJouer = 0;
    int numTour = 0;
    int nbDice = 0;
    int valDiceParier = 0;
    Mise miseMax = new Mise(0, 2);

    String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};
    int gob[] = new int[5];

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

    public boolean rejoindrePartie(String pPseudo, JoueurNotification pNotif) throws RemoteException {
        boolean joueurAjouteOk = false;
        Mise miseJ = new Mise(0, 2);

        if (listeJoueurs.size() < 6) {
            if (listeJoueurs.isEmpty()) {
                listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[1], gob, pPseudo, false, pNotif, miseJ, false));
                listeCoJoueurs.put(pPseudo, pNotif);
                indexPseudoJoueurs.add(pPseudo);
                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            } else {
                listeJoueurs.put(pPseudo, new Joueur(5, couleurJoueur[listeJoueurs.size() + 1], gob, pPseudo, false, pNotif, miseJ, false));
                listeCoJoueurs.put(pPseudo, pNotif);
                indexPseudoJoueurs.add(pPseudo);

                System.out.println("Joueur " + pPseudo + " créé");
                joueurAjouteOk = true;
            }
        }
        return joueurAjouteOk;
    }

    public boolean JoueurPret(String pPseudo, JoueurNotification pNotif) throws RemoteException {
        boolean JoueurPretOk = false;
        int i;
        int j;
        String notifAtoiJouerGobelet;

        if (listeJoueurs.containsKey(pPseudo)) {
            listeJoueurs.get(pPseudo).JoueurPret = true;

            JoueurPretOk = true;
        }

        for (i = 1; i < listeJoueurs.size(); i++) {

            if (listeJoueurs.get(indexPseudoJoueurs.get(i)).JoueurPret == true) {
                nbrJoueurPret = nbrJoueurPret + 1;
                System.out.println("nbrJoueurPret=" + nbrJoueurPret + "listeJoueurs.size()=" + listeJoueurs.size());
                if (nbrJoueurPret == listeJoueurs.size()) {
                    break;
                }
            }
        }

        if (nbrJoueurPret == listeJoueurs.size()) {

            Random joueurRandom = new Random();
            int num1erJoueurRandom = joueurRandom.nextInt(listeJoueurs.size());
            numAToiDeJouer = num1erJoueurRandom;

            listeJoueurs.get(indexPseudoJoueurs.get(num1erJoueurRandom)).AToiDeJouer = true;
            System.out.println(indexPseudoJoueurs.get(num1erJoueurRandom) + " est le premier a jouer");
            //Pour de prochaines parties, on réinitialise la var nbrJoueurPret
            int nbrJoueurPret = 0;

            for (i = 0; i < listeJoueurs.size(); i++) {
                listeJoueurs.get(indexPseudoJoueurs.get(i)).gobelet = listeJoueurs.get(indexPseudoJoueurs.get(i)).lancerDice(listeJoueurs.get(indexPseudoJoueurs.get(i)).nbDice);
                notifAtoiJouerGobelet = "";
                for (j = 0; j < listeJoueurs.get(indexPseudoJoueurs.get(i)).nbDice; j++) {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + listeJoueurs.get(indexPseudoJoueurs.get(i)).gobelet[j];
                }
                notifAtoiJouerGobelet = notifAtoiJouerGobelet.substring(0, notifAtoiJouerGobelet.length() - 1);

                if (i != numAToiDeJouer) {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",false";
                    listeCoJoueurs.get(indexPseudoJoueurs.get(i)).initialiserPartie(notifAtoiJouerGobelet);
                } else {
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",true";
                    listeCoJoueurs.get(indexPseudoJoueurs.get(i)).initialiserPartie(notifAtoiJouerGobelet);
                }

            }
        }

        return JoueurPretOk;
    }

    public void actionJoueur(int pChoixJoueur, String pPseudo) throws RemoteException {
        System.out.println("Action Joueur :");
        int actionReussit = 0;
        int numprecedent = 0;

        switch (pChoixJoueur) {

            // Annonce Menteur
            case 1:
                System.out.println(pPseudo + " annonce menteur");

                actionReussit = comparerMiseDes();

                if (actionReussit == 2) {
                    if (numAToiDeJouer == 0) {
                        numprecedent = indexPseudoJoueurs.size() - 1;
                    } else {
                        numprecedent = numAToiDeJouer - 1;
                    }
                    System.out.println("numAToiDeJouer " + numAToiDeJouer);
                    System.out.println("A cause de " + listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + ", " + listeJoueurs.get(indexPseudoJoueurs.get(numprecedent)).pseudo + " perd 1d");
                    listeJoueurs.get(indexPseudoJoueurs.get(numprecedent)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numprecedent)).nbDice - 1;
                } else {
                    System.out.println(listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + " s'est trompé! il perd 1d");
                    listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice - 1;
                }

                
                finManche();
                finTour();

                break;

            // Annonce Tout-pile
            case 2:
                System.out.println(pPseudo + " annonce tout-pile");
                actionReussit = comparerMiseDes();

                if (actionReussit == 1) {
                    if (listeJoueurs.get(pPseudo).nbDice < 5) {
                        //     listeJoueurs.get(pPseudo).nbDice = listeJoueurs.get(pPseudo).nbDice + 1;
                        listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice + 1;
                        System.out.println("111111111111");
                    }
                } else {
                    listeJoueurs.get(pPseudo).nbDice = listeJoueurs.get(pPseudo).nbDice - 1;
                    System.out.println(listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + " s'est trompé! il perd 1d");
                    System.out.println("222222222222");
                }
              
                finManche();
                finTour();

                break;

            // Annonce surenchère
            case 3:
                System.out.println(pPseudo + " fait une Surenchere");
                finTour();

                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
    }

    public int comparerMiseDes() {
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

        for (i = 0; i < listeJoueurs.size(); i++) {
            leGobelet = listeJoueurs.get(indexPseudoJoueurs.get(i)).getGobelet();

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
            switch (miseMax.getValDice()) {
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
        //    System.out.println("nbr1 " + nbr1 + " nbr2 " + nbr2 + " nbr3 " + nbr3 + " nbr4 " + nbr4 + " nbr5 " + nbr5 + " nbr6 " + nbr6 + " nbr " + nbr);

        // System.out.println("Mise " + miseMax.nbDiceParier + " " + miseMax.valDice);
        // Tout-pile validé
        if (miseMax.nbDiceParier == nbr) {
            miseVrai = 1;
        }
        // Menteur validé
        if (miseMax.nbDiceParier > nbr) {
            miseVrai = 2;
        }

        System.out.println("Misevrai est a " + miseVrai);
        return miseVrai;
    }

    public void finTour() throws RemoteException {
        int i;
        System.out.println("fin tour");

        System.out.println("numAToiDeJouer " + numAToiDeJouer);
        if (numAToiDeJouer + 1 < indexPseudoJoueurs.size()) {
            numAToiDeJouer = numAToiDeJouer + 1;
        } else {
            numAToiDeJouer = 0;
        }
        System.out.println("numAToiDeJouer " + numAToiDeJouer);
        System.out.println("ca va être a " + indexPseudoJoueurs.get(numAToiDeJouer));
        numTour = numTour + 1;

        for (i = 0; i < listeJoueurs.size(); i++) {
            if (i != numAToiDeJouer) {
                listeCoJoueurs.get(indexPseudoJoueurs.get(i)).nouveauTour(false);
            } else {
                listeCoJoueurs.get(indexPseudoJoueurs.get(i)).nouveauTour(true);
            }

        }
    }

    public void surencherJoueur(int chiffre, int quantite) throws RemoteException {
        int i;
        String miseRenvoyer;

        miseMax.valDice = chiffre;
        miseMax.nbDiceParier = quantite;
        miseRenvoyer = (quantite + " " + chiffre);
        System.out.println("Mise max mis à jour");

        for (i = 0; i < listeJoueurs.size(); i++) {
            listeCoJoueurs.get(indexPseudoJoueurs.get(i)).notifSurencherNbr(miseRenvoyer);
            // listeCoJoueurs.get(indexPseudoJoueurs.get(i)).notifSurencherNbr(miseMax.valDice);
            System.out.println("Mise max envoyé à " + indexPseudoJoueurs.get(i));
        }

    }

    public void finManche() throws RemoteException {
        int i;
        int numJoueurPerdu = -1;
        int numJoueurGagnant;
        int j;
        String notifAtoiJouerGobelet;
        boolean gagnant = false;
        String emploieFictif = "d";

        miseMax.nbDiceParier = 0;
        miseMax.valDice = 2;

        // Permet de connaitre le numero du joueur qui aurait perdu à la fin de cette manche
        for (i = 0; i < listeJoueurs.size(); i++) {
            if (listeJoueurs.get(indexPseudoJoueurs.get(i)).nbDice == 0) {
                numJoueurPerdu = i;
                if (listeJoueurs.size() == 2) {
                    gagnant = true;
                    System.out.println("On a un gagnant!");
                }
            }
        }

        if (gagnant == false) {
            System.out.println("numAToiDeJouer " + numAToiDeJouer);

            if (numJoueurPerdu == numAToiDeJouer) {
                if (indexPseudoJoueurs.size() > 2) {
                    if (numAToiDeJouer + 1 < indexPseudoJoueurs.size()) {
                        numAToiDeJouer = numAToiDeJouer + 1;
                    } else {
                        numAToiDeJouer = 0;
                    }
                } else {
                    if (numAToiDeJouer + 1 < indexPseudoJoueurs.size()) {
                        numAToiDeJouer = numAToiDeJouer + 1;
                    } else {
                        numAToiDeJouer = 0;
                    }
                }
            }

            System.out.println("ca va être a " + indexPseudoJoueurs.get(numAToiDeJouer));

            for (i = 0; i < listeJoueurs.size(); i++) {
                if (numJoueurPerdu != i) {
                    System.out.println("numJoueurPerdu ! = i");
                    listeJoueurs.get(indexPseudoJoueurs.get(i)).gobelet = listeJoueurs.get(indexPseudoJoueurs.get(i)).lancerDice(listeJoueurs.get(indexPseudoJoueurs.get(i)).nbDice);
                    notifAtoiJouerGobelet = "";
                    for (j = 0; j < listeJoueurs.get(indexPseudoJoueurs.get(i)).nbDice; j++) {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + listeJoueurs.get(indexPseudoJoueurs.get(i)).gobelet[j];
                    }
                    notifAtoiJouerGobelet = notifAtoiJouerGobelet.substring(0, notifAtoiJouerGobelet.length() - 1);

                    if (i != numAToiDeJouer) {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",false";
                        listeCoJoueurs.get(indexPseudoJoueurs.get(i)).nouvelleManche(notifAtoiJouerGobelet);
                    } else {
                        notifAtoiJouerGobelet = notifAtoiJouerGobelet + ",true";
                        listeCoJoueurs.get(indexPseudoJoueurs.get(i)).nouvelleManche(notifAtoiJouerGobelet);
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
            listeCoJoueurs.get(indexPseudoJoueurs.get(numJoueurGagnant)).notifVictoire(emploieFictif);

        }

        if (numJoueurPerdu != -1) {
            listeJoueurs.remove(indexPseudoJoueurs.get(numJoueurPerdu));
            indexPseudoJoueurs.remove(numJoueurPerdu);
        }

    }
}
