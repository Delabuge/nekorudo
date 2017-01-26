/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import nekoperudo.IfJoueur.Mise;

/**
 *
 * @author Remi
 */
/**
 * La classe Joueur contient l'implémentation des méthodes du Joueur
 */
public class Joueur {

    public int nbDice;
    public String couleurJoueur;
    int gobelet[] = new int[5];
    int nbDiceParier = 0;
    int valDiceParier = 0;

    public Joueur() {

    }

    public Joueur(int pNbDice, String pCouleurJoueur, int[] pGobelet) {
        nbDice = pNbDice;
        couleurJoueur = pCouleurJoueur;
        gobelet = pGobelet;
    }

    public int[] lancerDice(int NbDice) {
        int i;
        int monGobelet[] = new int[5];

        Dice d1 = new Dice(couleurJoueur);

        for (i = 0; i < NbDice; i++) {
            monGobelet[i] = d1.rollTheDice();
        }
        this.setGobelet();
        return monGobelet;
    }

    public void actionJoueur(int choixJoueur, Mise m, List<Joueur> listeJoueurs, int numJoueur) {
        boolean actionReussit = false;
        switch (choixJoueur) {

            // Annonce Menteur
            case 1:
                actionReussit = comparerMiseDes(listeJoueurs, m);

                if (actionReussit == true) {
                    listeJoueurs.get(numJoueur-1).nbDice = listeJoueurs.get(numJoueur-1).nbDice-1;
                } else {
                    this.nbDice = this.nbDice - 1;
                }
                break;
            // Annonce Tout-pile
            case 2:
                comparerMiseDes(listeJoueurs, m);

                if (actionReussit == true) {
                    this.nbDice = this.nbDice + 1;
                } else {
                    this.nbDice = this.nbDice - 1;
                }
                break;

            // Annonce surenchère
            case 3:
                surencherir(m);
                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
    }

    public boolean comparerMiseDes(List<Joueur> listeJoueurs, Mise m) {
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

        for (i = 0; i < listeJoueurs.size(); i++) {
            leGobelet = listeJoueurs.get(i).getGobelet();

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
            switch (m.getValDice()) {
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

        System.out.println("Mise " + m.nbDiceParier + " " + m.valDice);
        if (m.nbDiceParier == nbr) {
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
        initialiserPartie(nbJoueur);
        // test = (listeJoueurs.get(1).couleurJoueur);
        // System.out.print(test);

        Mise m = new Mise(0, 2);
        //m = jouerManche(listeJoueurs);
    }

    public List<Joueur> initialiserPartie(int pNbJoueur) {
        String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};
        int gob[] = new int[5];
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        int i = 0;
        for (i = 0; i < pNbJoueur; i++) {
            listeJoueurs.add(new Joueur(5, couleurJoueur[i], gob));
        }
        return listeJoueurs;
    }

    public void jetterDes(List<Joueur> listeJoueurs) {
        int i;

        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i < listeJoueurs.size(); i++) {
            listeJoueurs.get(i).gobelet = listeJoueurs.get(i).lancerDice(listeJoueurs.get(i).nbDice);
            System.out.println(listeJoueurs.get(i).gobelet);
        }

    }

    /*    public Mise jouerManche(List<Joueur> listeJoueurs, Mise pMise) {
        int i;
        int nbJoueur = listeJoueurs.size();

        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i < nbJoueur; i++) {
            listeJoueurs.get(i).lancerDice(listeJoueurs.get(i).nbDice);
        }

        return m;
    }*/
    public boolean jouerTour(List<Joueur> listeJoueurs, Mise m, int numJoueur) {
        boolean finManche = false;
        int choixJoueur = 1;
        // Joueur choisie son action
        actionJoueur(choixJoueur, m, listeJoueurs, numJoueur);

        if (choixJoueur == 1 || choixJoueur == 2){
            finManche = true;
        }
        
        return finManche;
    }

    public int[] getGobelet() {
        return gobelet;
    }

    public void setGobelet() {
        this.gobelet = gobelet;
    }
    
        public int getNbdice() {
        return nbDice;
    }

    public void setNbDice() {
        this.nbDice = nbDice;
    }
    

}
