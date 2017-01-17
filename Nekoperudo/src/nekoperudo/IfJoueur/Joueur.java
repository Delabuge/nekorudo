/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.util.Random;

/**
 *
 * @author Remi
 */
public class Joueur {
 
  public int nbrDice;
  public String couleurJoueur;
    
  public Joueur(int pNbrDice, String pCouleurJoueur)
  {
    nbrDice = pNbrDice;
    couleurJoueur = pCouleurJoueur;
  }
  
}