/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IHM;

import javax.swing.SwingUtilities;

/**
 *
 * @author Pascal
 */
public class AaRun {
    
	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre JDialog
				Bienvenue bvn = new Bienvenue();                                
                                bvn.setTitle("Nekorudo");                        
                                bvn.setLocationRelativeTo(null);                               
				bvn.setVisible(true);
			}
		});
	}

}
