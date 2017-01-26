/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;

import nekoperudo.IfJoueur.InterfaceJoueur;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import nekoperudo.IfJoueur.Joueur;
import nekoperudo.IfJoueur.Mise;

/**
 *
 * @author Pascal
 */
public class MainServeurCentral {

    public static void main(String[] argv) {
        int i;
        int k;
        int nbDice = 5;
        int nbJoueur = 3;
        String nomJoueur;
        String test;
        int gobelet[] = new int[5];
        Mise m = new Mise(0, 2);
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        Joueur j = new Joueur(5, "MJ",gobelet);
        boolean finManche = false;



        // test = (listeJoueurs.get(1).couleurJoueur);
        // System.out.print(test);
        listeJoueurs = j.initialiserPartie(nbJoueur);
        // test = (listeJoueurs.get(1).couleurJoueur);
        // System.out.print(test);

        j.jetterDes(listeJoueurs);

        do {
            for (i = 0; i < nbJoueur; i++) {
                
                listeJoueurs.get(i).jouerTour(listeJoueurs, m,i);
                // Joueur valide fin de son tour
                // listeJoueurs.get(i).terminerTour(choixJoueur);
               
            }
        } while (finManche == false);

    }
}
