/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;

import java.util.Random;

/**
 *
 * @author Remi
 */
public class Dice {

    //public int numDice;
    public String couleurJoueur;
    public int resultat;

//public Dice(int pNumDice, String pCouleurJoueur)  
    public Dice(String pCouleurJoueur) {
        // numDice = pNumDice;
        couleurJoueur = pCouleurJoueur;
        resultat = rollTheDice();
    }

    /**
     * @return un chiffre aleatoire entre 1 et 6
     * @throws java.rmi.RemoteException
     */
    public int rollTheDice() {
        Random resultatD = new Random();
        int resultatRoll = resultatD.nextInt(6) + 1;
        return resultatRoll;
    }

    /**
     * @return the couleurJoueur
     */
    public String getCouleurJoueur() {
        return couleurJoueur;
    }

    /**
     * @param couleurJoueur the couleurJoueur to set
     */
    public void setCouleurJoueur(String couleurJoueur) {
        this.couleurJoueur = couleurJoueur;
    }

    /**
     * @return le resultat du de
     */
    public int getResultat() {
        return resultat;
    }

    /**
     * @param resultat the resultat to set
     */
    public void setResultat(int resultat) {
        this.resultat = resultat;
    }

}
