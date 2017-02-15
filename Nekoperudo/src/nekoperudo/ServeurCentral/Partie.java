/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.ServeurCentral;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nekoperudo.Interface.Nekoperudo;

/**
 *
 * @author stri
 */
public class Partie {

    List<String> indexPseudoJoueurs = new ArrayList<String>();
    Map<String, Nekoperudo.JoueurNotification> listeCoJoueurs = new HashMap<String, Nekoperudo.JoueurNotification>(6);
    Map<String, Joueur> listeJoueurs = new HashMap<String, Joueur>(6);

    int nbrJoueurPret = 0;
    int nbrJoueurMax = 0;
    int numAToiDeJouer = 0;
    int numTour = 0;
    int nbDice = 0;
    int valDiceParier = 0; 
    String nomPartie = "";

    public Partie(String pNomPartie, int pNbrJoueurMax) {
        nomPartie = pNomPartie;
        nbrJoueurMax = pNbrJoueurMax;
    }

    public List<String> getIndexPseudoJoueurs() {
        return indexPseudoJoueurs;
    }

    public void setIndexPseudoJoueurs(List<String> indexPseudoJoueurs) {
        this.indexPseudoJoueurs = indexPseudoJoueurs;
    }

    public void addIndexPseudoJoueurs(String pPseudo) {
        indexPseudoJoueurs.add(pPseudo);
    }

    public int getNbrJoueurPret() {
        return nbrJoueurPret;
    }

    public void setNbrJoueurPret(int nbrJoueurPret) {
        this.nbrJoueurPret = nbrJoueurPret;
    }

    public int getNumAToiDeJouer() {
        return numAToiDeJouer;
    }

    public void setNumAToiDeJouer(int numAToiDeJouer) {
        this.numAToiDeJouer = numAToiDeJouer;
    }

    public int getNumTour() {
        return numTour;
    }

    public void setNumTour(int numTour) {
        this.numTour = numTour;
    }

    public int getNbDice() {
        return nbDice;
    }

    public void setNbDice(int nbDice) {
        this.nbDice = nbDice;
    }

    public int getValDiceParier() {
        return valDiceParier;
    }

    public void setValDiceParier(int valDiceParier) {
        this.valDiceParier = valDiceParier;
    }

    public Mise getMiseMax() {
        return miseMax;
    }

    public void setMiseMax(Mise miseMax) {
        this.miseMax = miseMax;
    }
    Mise miseMax = new Mise(0, 2);

    
    public Map<String, Nekoperudo.JoueurNotification> getListeCoJoueurs() {
        return listeCoJoueurs;
    }

    public void setListeCoJoueurs(Map<String, Nekoperudo.JoueurNotification> listeCoJoueurs) {
        this.listeCoJoueurs = listeCoJoueurs;
    }

    public Map<String, Joueur> getListeJoueurs() {
        return listeJoueurs;
    }

    public void setListeJoueurs(Map<String, Joueur> listeJoueurs) {
        this.listeJoueurs = listeJoueurs;
    }

    public int getNbrJoueurMax() {
        return nbrJoueurMax;
    }

    public void setNbrJoueurMax(int nbrJoueurMax) {
        this.nbrJoueurMax = nbrJoueurMax;
    }

    public String getNomPartie() {
        return nomPartie;
    }

    public void setNomPartie(String nomPartie) {
        this.nomPartie = nomPartie;
    }
    
    
}
