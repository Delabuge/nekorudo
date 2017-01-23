/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IfJoueur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rémi
 */
public class MainJoueur {

    public static void main(String[] argv) {
    /*    try {
            // 10000 est le port sur lequel sera publié le service. Nous devons le préciser à la fois sur le registry et à la fois à la création du stub.
            InterfaceJoueur skeleton = (InterfaceJoueur) UnicastRemoteObject.exportObject(new Joueur(), 12345); // Génère un stub vers notre service.
            Registry registry = LocateRegistry.createRegistry(12345);
            registry.rebind("lancerDice", skeleton); // publie notre instance sous le nom "Add"
        } catch (Exception e) {
            e.printStackTrace();
        }
*/
        int nbDice = 5;
        int choixJoueur = 0;
        int nbJoueur = 2;
        String nomJoueur;

        Mise m = new Mise(0, 2);

        String[] couleurJoueur = {"Blanc", "Bleu", "Jaune", "Noir", "Rouge", "Vert"};

        List<Joueur> listeJoueurs = new ArrayList<Joueur>();
        int i = 0;
        for (i = 0; i < nbJoueur; i++) {
            listeJoueurs.add(new Joueur(5, couleurJoueur[i]));
        }

        for (i = 0; i<nbJoueur;i++){
            System.out.println(listeJoueurs.get(i).couleurJoueur);
        }
        


        
        // Début du tour, tout les joueurs jette leurs des
        for (i = 0; i<nbJoueur;i++) {
                listeJoueurs.get(i).lancerDice(nbDice);
            }

        // Joueur choisie son action
        choixJoueur = listeJoueurs.get(i).actionJoueur(nbDice, m);


        // Joueur valide fin de son tour
        listeJoueurs.get(i).terminerManche(choixJoueur);

    }
}
