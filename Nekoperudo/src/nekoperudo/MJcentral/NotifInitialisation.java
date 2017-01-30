/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;

/**
 *
 * @author Rémi
 */
public class NotifInitialisation {

    public String couleurJoueur;
    public boolean AToiDeJouer;

    public NotifInitialisation(String pCouleurJoueur, boolean pAToiDeJouer) {
        couleurJoueur = pCouleurJoueur;
        AToiDeJouer = pAToiDeJouer;
    }

    public String getCouleurJoueur() {
        return couleurJoueur;
    }

    public void setCouleurJoueur(String couleurJoueur) {
        this.couleurJoueur = couleurJoueur;
    }

    public boolean isAToiDeJouer() {
        return AToiDeJouer;
    }

    public void setAToiDeJouer(boolean AToiDeJouer) {
        this.AToiDeJouer = AToiDeJouer;
    }

}
