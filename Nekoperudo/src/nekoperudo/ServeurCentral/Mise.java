
package nekoperudo.ServeurCentral;

public class Mise {

    public int nbDiceParier;
    public int valDice;

    public Mise(Mise pM) {
        this.nbDiceParier = pM.nbDiceParier;
        this.valDice = pM.valDice;
    }
 
    public Mise(int pNbDiceParier, int pValDice) {
        nbDiceParier = pNbDiceParier;
        valDice = pValDice;
    }

   
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
