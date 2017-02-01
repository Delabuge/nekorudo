
package nekoperudo.MJcentral;

import java.util.Random;

public class Dice {

    public String couleurJoueur;
    public int resultat;

    public Dice(String pCouleurJoueur) {
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
     * @return le resultat du dé
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
