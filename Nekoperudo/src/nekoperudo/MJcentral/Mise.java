/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.MJcentral;

/**
 *
 * @author stri
 */
public class Mise {

    public int nbDiceParier;
    public int valDice;

    public Mise(Mise pM) {
        this.nbDiceParier = pM.nbDiceParier;
        this.valDice = pM.valDice;
    }

//public Dice(int pNumDice, String pCouleurJoueur)  
    public Mise(int pNbDiceParier, int pValDice) {
        nbDiceParier = pNbDiceParier;
        valDice = pValDice;
    }

    /**
     *
     * @param pM
     */
    public int getNbDiceParier() {
        return nbDiceParier;
    }

    public void setNbDiceParier(int nbDiceParier) {
        this.nbDiceParier = nbDiceParier;
    }

    public int getValDice() {
        return valDice;
    }

    public void setValDice(int valDice) {
        this.valDice = valDice;
    }

}
