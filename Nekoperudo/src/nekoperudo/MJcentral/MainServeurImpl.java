/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Rémi
 */
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

        /*  
        int i;
        int nbJoueur = 3;
        int gobelet[] = new int[5];
        Mise m = new Mise(0, 2);
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        Joueur j = new Joueur(5, "MJ", gobelet);
        boolean finManche = false;

        listeJoueurs = proxy.initialiserPartie(nbJoueur);

        proxy.jetterDes(listeJoueurs);

        do {
            for (i = 0; i < nbJoueur; i++) {

                finManche = listeJoueurs.get(i).jouerTour(listeJoueurs, m, i);
                // Joueur valide fin de son tour

                if (finManche = true) {
                    break;
                }
            }
        } while (finManche == false);
    }*/
    }

    public synchronized void afficherMsg(String id, int somme) throws RemoteException {

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

        NotifInitialisation ntfI = new NotifInitialisation("", false);

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
                if (i != numAToiDeJouer) {
                    listeCoJoueurs.get(indexPseudoJoueurs.get(i)).initialiserPartie(false);
                } else {
                    listeCoJoueurs.get(indexPseudoJoueurs.get(i)).initialiserPartie(true);
                }

            }
        }

        return JoueurPretOk;
    }

    public void actionJoueur(int pChoixJoueur, String pPseudo) {
        boolean actionReussit = false;
        switch (pChoixJoueur) {

            // Annonce Menteur
            case 1:
                actionReussit = comparerMiseDes();

                if (actionReussit == true) {
                    listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer - 1)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer - 1)).nbDice - 1;
                    System.out.println("A cause de " + listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + ", " + listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer - 1)).pseudo + " perd 1d");
                } else {
                    listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice - 1;
                    System.out.println(listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + " s'est trompé! il perd 1d");
                }
                break;
            // Annonce Tout-pile
            case 2:
                actionReussit = comparerMiseDes();

                if (actionReussit == true) {
                    this.nbDice = this.nbDice + 1;
                } else {
                    listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice = listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).nbDice - 1;
                    System.out.println(listeJoueurs.get(indexPseudoJoueurs.get(numAToiDeJouer)).pseudo + " s'est trompé! il perd 1d");
                }
                break;

            // Annonce surenchère
            case 3:
                surencherir(miseMax);
                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
    }

    public boolean comparerMiseDes() {
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
        boolean miseVrai = false;

        //   indexPseudoJoueurs = new ArrayList<String>();
        //   Map<String, Joueur> listeJoueurs = new HashMap<String, Joueur>(6);
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
        System.out.println("nbr1 " + nbr1 + " nbr2 " + nbr2 + " nbr3 " + nbr3 + " nbr4 " + nbr4 + " nbr5 " + nbr5 + " nbr6 " + nbr6 + " nbr " + nbr);

        System.out.println("Mise " + miseMax.nbDiceParier + " " + miseMax.valDice);
        if (miseMax.nbDiceParier == nbr) {
            miseVrai = true;
        }
        System.out.println("Misevrai est a " + miseVrai);
        return miseVrai;
    }

    public void surencherir(Mise m) {
        // Saisie des valeurs de l'utilisateur
        int nbDiceParier = 4;
        int valDice = 5;

        // Condition ok pour la surenchere :  soit en augmentant le nombre de dés, soit en augmentant la valeur ou bien les deux
        if (nbDiceParier > m.getNbDiceParier() || valDice > m.getValDice()) {
            m.setNbDiceParier(nbDiceParier);
            m.setValDice(valDice);
            terminerTour(3);
        } else {
            // Erreur : recommencer la saisie ou retourner à la selection de choix
        }
    }

    public void terminerTour(int choixJoueur) {

        switch (choixJoueur) {

            // Annonce Menteur
            case 1:

                break;

            // Annonce Tout-pile
            case 2:

                break;

            // Annonce Surenchere
            case 3:

                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }

    }

    public void leMain() {
        int nbDice = 5;
        int choixJoueur = 0;
        int nbJoueur = 2;
        String nomJoueur;
        String test;

        List<Joueur> listeJoueurs = new ArrayList<Joueur>();

        // test = (listeJoueurs.get(1).couleurJoueur);
        // System.out.print(test);
        //   initialiserPartie(nbJoueur);
        // test = (listeJoueurs.get(1).couleurJoueur);
        // System.out.print(test);
        //m = jouerManche(listeJoueurs);
    }

    /*   public boolean jouerTour(List<Joueur> listeJoueurs, Mise m, int numJoueur) {
        boolean finManche = false;
        int choixJoueur = 1;
        // Joueur choisie son action
        actionJoueur(choixJoueur, m, listeJoueurs, numJoueur);

        if (choixJoueur == 1 || choixJoueur == 2) {
            finManche = true;
        }

        return finManche;
    }*/
}
