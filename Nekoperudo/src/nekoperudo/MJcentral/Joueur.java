
package nekoperudo.MJcentral;

import java.util.List;
import nekoperudo.IfJoueur.Nekoperudo.JoueurNotification;


/**
 * La classe Joueur contient l'implémentation des méthodes du Joueur
 */
public class Joueur {

    public int nbDice;

    public String couleurJoueur;
    int gobelet[] = new int[5];
    String pseudo;
    boolean JoueurPret = false;
    int nbDiceParier = 0;
    int valDiceParier = 0;
    int numJoueur = 0;

    public JoueurNotification notif;
    Mise miseJ = new Mise(0, 2);
    boolean AToiDeJouer = false;

    public Joueur() {

    }

    /**
     * Initialise le joueur
     * @param pNbDice
     * @param pCouleurJoueur
     * @param pGobelet
     * @param pPseudo
     * @param pJoueurPret
     * @param pNotif
     * @param pMiseJ
     * @param pAToiDeJouer
     */
    public Joueur(int pNbDice, String pCouleurJoueur, int[] pGobelet, String pPseudo, boolean pJoueurPret, JoueurNotification pNotif, Mise pMiseJ, boolean pAToiDeJouer) {
        nbDice = pNbDice;
        couleurJoueur = pCouleurJoueur;
        gobelet = pGobelet;
        pseudo = pPseudo;
        JoueurPret = pJoueurPret;
        notif = pNotif;
        miseJ = pMiseJ;
        AToiDeJouer = pAToiDeJouer;
    }

    /**
     * Génère aléatoirement des valeurs pour nombre de dés
     * @param NbDice
     * @return
     */
    public int[] lancerDice(int NbDice) {
        
        int i;
        int monGobelet[] = new int[5];

        Dice d1 = new Dice(couleurJoueur);

        for (i = 0; i < NbDice; i++) {
            System.out.println("i="+i);
            monGobelet[i] = d1.rollTheDice(); //Génère aléatoirement une valeur
            System.out.println("gobelet="+monGobelet[i]);
        }
        this.setGobelet();
        return monGobelet;
    }

   

    /*    public List<Joueur> initialiserPartie(int pNbJoueur) {
        String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};
        int gob[] = new int[5];
        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        int i = 0;
        for (i = 0; i < pNbJoueur; i++) {
            listeJoueurs.add(new Joueur(5, couleurJoueur[i], gob,pseudo,false));
        }
        return listeJoueurs;
    }
     */

    /**
     * Jette les dés de tous les joueurs
     * @param listeJoueurs
     */

    public void jetterDes(List<Joueur> listeJoueurs) {
        int i;

        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i < listeJoueurs.size(); i++) {
            listeJoueurs.get(i).gobelet = listeJoueurs.get(i).lancerDice(listeJoueurs.get(i).nbDice);
            System.out.println(listeJoueurs.get(i).gobelet);
        }

    }

    /*    public Mise jouerManche(List<Joueur> listeJoueurs, Mise pMise) {
        int i;
        int nbJoueur = listeJoueurs.size();

        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i < nbJoueur; i++) {
            listeJoueurs.get(i).lancerDice(listeJoueurs.get(i).nbDice);
        }

        return m;
    }*/

    
    /*Affichage du joueur dans la liste de joueurs*/
    public String toString(){
        return (pseudo + " Dé(" +miseJ.getValDice()+ ") x" + miseJ.getNbDiceParier());
    }

    /**
     * Récupère le gobelet
     * @return
     */
    public int[] getGobelet() {
        return gobelet;
    }

    public void setGobelet() {
        this.gobelet = gobelet;
    }

    public int getNbdice() {
        return nbDice;
    }

    public void setNbDice() {
        this.nbDice = nbDice;
    }

    public void setNotification(JoueurNotification notif) {
        this.notif = notif;
    }

}
