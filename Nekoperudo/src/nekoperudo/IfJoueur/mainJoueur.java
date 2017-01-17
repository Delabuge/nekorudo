/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.util.Random;

/**
 *
 * @author stri
 */
public class mainJoueur {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here        
        int nbrDice;
        String couleurJoueur;
        
        nbrDice=5;
        couleurJoueur="orange";
        
        for (int i=0; i<nbrDice ;i++){
            Dice d1 = new Dice(1,couleurJoueur);
            System.out.println(d1.getResultat());
        }
    }
            
}