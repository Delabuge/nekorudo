
package nekoperudo.IHM;

import javax.swing.SwingUtilities;

//Lance un nouveau joueur
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
