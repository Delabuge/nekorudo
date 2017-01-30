package nekoperudo.IHM;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;

public class Bienvenue extends javax.swing.JDialog {

    String pseudo;
    String serveur;

    public Bienvenue() {
        initComponents();

        /*Image*/
        ImageIcon icone = new ImageIcon("C:/Firefox_baby.png");
        JLabel image = new JLabel(icone);
        image.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        jPanel1.add(image);
        jPanel1.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu1 = new java.awt.PopupMenu();
        popupMenu2 = new java.awt.PopupMenu();
        lblPseudo = new javax.swing.JLabel();
        txfPseudo = new javax.swing.JTextField();
        lblNekorudo = new javax.swing.JLabel();
        btnCreerPartie = new javax.swing.JButton();
        btnRejoindre = new javax.swing.JButton();
        btnQuitter = new javax.swing.JButton();
        btnRegles = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txfServeur = new javax.swing.JTextField();
        lblNomServeur = new javax.swing.JLabel();

        popupMenu1.setLabel("popupMenu1");

        popupMenu2.setLabel("popupMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));

        lblPseudo.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        lblPseudo.setText("Votre Pseudo :");

        txfPseudo.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        txfPseudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPseudoActionPerformed(evt);
            }
        });

        lblNekorudo.setFont(new java.awt.Font("Cambria", 0, 48)); // NOI18N
        lblNekorudo.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblNekorudo.setText("NEKORUDO");

        btnCreerPartie.setText("Créer une partie ( non dispo dans la version 1 )");

        btnRejoindre.setText("Rejoindre une partie");
        btnRejoindre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRejoindreActionPerformed(evt);
            }
        });

        btnQuitter.setText("Quitter la partie");
        btnQuitter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnQuitterMouseClicked(evt);
            }
        });

        btnRegles.setText("Règles du jeu");
        btnRegles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReglesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );

        txfServeur.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        txfServeur.setText("localhost");

        lblNomServeur.setFont(new java.awt.Font("Cambria", 0, 24)); // NOI18N
        lblNomServeur.setText("Nom du serveur :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(btnCreerPartie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnQuitter)
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNekorudo)
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnRejoindre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(396, 396, 396))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNomServeur)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txfServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPseudo)
                                .addGap(48, 48, 48)
                                .addComponent(txfPseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(362, 362, 362))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblNekorudo)
                        .addGap(84, 84, 84))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPseudo, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfPseudo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfServeur, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNomServeur))
                .addGap(29, 29, 29)
                .addComponent(btnRejoindre)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreerPartie)
                    .addComponent(btnRegles)
                    .addComponent(btnQuitter))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfPseudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPseudoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPseudoActionPerformed

    /*  Récupère le pseudo et se connecte au serveur central    */
    private void btnRejoindreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRejoindreActionPerformed

        Nekoperudo proxy;
        try {
            proxy = (Nekoperudo) Naming.lookup("MJ");

            JoueurNotificationImpl notif = new JoueurNotificationImpl("Bob");
            proxy.enregistrerNotification("Bob", notif);
            
            proxy.rejoindrePartie(this.getPseudo(),notif);

            FileAttente fa = new FileAttente(this.getPseudo(), this.getServeur(), this.getRMIObject(proxy), this.getNotif(notif));
            fa.setTitle("Nekorudo : " + getPseudo());
            fa.setLocationRelativeTo(null);
            fa.setVisible(true);
            this.setVisible(false);

        } catch (NotBoundException ex) {
            Logger.getLogger(Bienvenue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Bienvenue.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Bienvenue.class.getName()).log(Level.SEVERE, null, ex);
        }

        /**
         * **Connexion au serveur local
         */
        //nom du serveur : getServeur()

    }//GEN-LAST:event_btnRejoindreActionPerformed

    /*  Quitte l'application    */
    private void btnQuitterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnQuitterMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnQuitterMouseClicked

    /*  Affiche la page des règles  */
    private void btnReglesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReglesActionPerformed
        ReglesJeu rj = new ReglesJeu();
        rj.setTitle("Nekorudo : " + getPseudo());
        rj.setLocationRelativeTo(null);
        rj.setVisible(true);
    }//GEN-LAST:event_btnReglesActionPerformed

    public String getPseudo() {
        pseudo = txfPseudo.getText();
        return pseudo;
    }

    public String getServeur() {
        serveur = txfServeur.getText();
        return serveur;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreerPartie;
    private javax.swing.JButton btnQuitter;
    private javax.swing.JButton btnRegles;
    private javax.swing.JButton btnRejoindre;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblNekorudo;
    private javax.swing.JLabel lblNomServeur;
    private javax.swing.JLabel lblPseudo;
    private java.awt.PopupMenu popupMenu1;
    private java.awt.PopupMenu popupMenu2;
    private javax.swing.JTextField txfPseudo;
    private javax.swing.JTextField txfServeur;
    // End of variables declaration//GEN-END:variables

    public Nekoperudo getRMIObject(Nekoperudo pProxy) {
        return pProxy;
    }

    public JoueurNotificationImpl getNotif(JoueurNotificationImpl pNotif) {
        return pNotif;
    }

}
