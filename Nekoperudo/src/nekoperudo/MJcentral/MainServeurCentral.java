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
 * @author Rémi
 */
public class MainServeurCentral {

    public static void main(String[] argv) {
        int i;
        int nbJoueur = 3;
        int gobelet[] = new int[5];
        Mise m = new Mise(0, 2);
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        Joueur j = new Joueur(5, "MJ", gobelet);
        boolean finManche = false;

        listeJoueurs = j.initialiserPartie(nbJoueur);

        j.jetterDes(listeJoueurs);

        do {
            for (i = 0; i < nbJoueur; i++) {

                finManche = listeJoueurs.get(i).jouerTour(listeJoueurs, m, i);
                // Joueur valide fin de son tour

                if (finManche = true) {
                    break;
                }
            }
        } while (finManche == false);
    }
}
