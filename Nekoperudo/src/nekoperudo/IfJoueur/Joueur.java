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

    public Joueur(int pNbDice, String pCouleurJoueur) {
        nbDice = pNbDice;
        couleurJoueur = pCouleurJoueur;
    }

    public int lancerDice(int NbDice) {
        int i;

        Dice d1 = new Dice(couleurJoueur);

        for (i = 0; i < NbDice; i++) {
            gobelet[i] = d1.rollTheDice();
        }
        return 0;
    }

    public int actionJoueur(int choixJoueur, Mise m) {

        switch (choixJoueur) {

            // Annonce Menteur
            case 1:
                terminerTour(choixJoueur);
                
                break;

            // Annonce Tout-pile
            case 2:
                terminerTour(choixJoueur);
                break;
                
            // Annonce surenchère
            case 3:
                surencherir(m);
                break;

            default:
                System.out.println("Erreur dans le choix de l'action du joueur");
        }
        return choixJoueur;
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

        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        int i = 0;
        for (i = 0; i < pNbJoueur; i++) {
            listeJoueurs.add(new Joueur(5, couleurJoueur[i]));
        }
        return listeJoueurs;
    }

    public void jetterDes(List<Joueur> listeJoueurs) {
        int i;

        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i < listeJoueurs.size(); i++) {
            listeJoueurs.get(i).lancerDice(listeJoueurs.get(i).nbDice);
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
    public Mise jouerTour(List<Joueur> listeJoueurs, Mise m, int numJoueur) {
        int i;
        int choixJoueur;
        // Joueur choisie son action
        choixJoueur = listeJoueurs.get(numJoueur).actionJoueur(listeJoueurs.get(numJoueur).nbDice, m);

        // Joueur valide fin de son tour
        listeJoueurs.get(numJoueur).terminerTour(choixJoueur);

        return m;
    }

}
