/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.util.Random;

/**
 *
 * @author Rémi
 */
public class mainJoueur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Joueur J1 = new Joueur(5, "orange");
        J1.lancerDice(5);
        // Dice d1 = new Dice(J1.couleurJoueur);
    }

}
