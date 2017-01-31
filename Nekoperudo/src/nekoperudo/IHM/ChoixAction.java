package nekoperudo.IHM;

import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;

public class ChoixAction extends javax.swing.JDialog {

    String pseudo;
    String serveur;
    String mesDice; //Dés du joueur
    Nekoperudo proxy;
    JoueurNotificationImpl notif;
    boolean aToiDeJouer;
    boolean premierTour = true;

    /**
     * Creates new form ChoixAction
     */
    public ChoixAction(String pPseudo, String pServeur, Nekoperudo pProxy, JoueurNotificationImpl pNotif, boolean pAToiDeJouer) throws RemoteException, InterruptedException {

        initComponents();
        this.pseudo = pPseudo;
        this.serveur = pServeur;
        this.proxy = pProxy;
        this.notif = pNotif;
        this.aToiDeJouer = pAToiDeJouer;

        pnlJouer.setVisible(false); //Masque le panel "a toi de jouer"

        // popLancerDice(); //Ouvre la popup pour lancer les dés
        lblPartieDe.setText("Partie de " + serveur);//initialise le titre
        /*try {            
            notif.test(pseudo+"ohohohoh!");
        } catch (RemoteException ex) {
            Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
        }
         */

        if (aToiDeJouer == false) {
           // pNotif.actualiserJoueur();
            lblAVotreTour.setText("Un autre joueur joue...");
            lblAVotreTour.setEnabled(true);
          /*  while (aToiDeJouer == false) {
                sleep(5000);
            }*/
        }
        if (aToiDeJouer == true) {
            pnlJouer.setVisible(true);
            lblAVotreTour.setText("A toi de jouer !");
            if (premierTour == true) {
                btnMenteur.setVisible(false);
                btnToutPile.setVisible(false);
            }
        }

        /*    if (premierTour == true) {
            premierTour = proxy.testPremierTour();
        }*/
    }

    public void setaToiDeJouer(boolean paToiDeJouer) {
        this.aToiDeJouer = paToiDeJouer;
    }
    
        public void setpremierTour(boolean ppremierTour) {
        this.premierTour = ppremierTour;
    }

    /*  Actualise la mise et le joueur en cours*/
    public void actualiser() {
        String enchere = "";
        //  txaEnchereEnCours.setText(enchere);
        lblEnchere.setText("Enchère :");
    }

    /*Actualise le champ nos dés */
    public void actualiserNosDes() {
        mesDice = "5 | 5 | 6 | 2 | 1";
        txaNosDes.setText(mesDice);
        btnLancerDice.setVisible(false); //Masque le bouton "lancer les dés"
    }

    public void actualiserMise() {
        String mise = "5 | 5 ";
        txaEnchereEnCours.setText("mise");
    }

    /*  choix 1 : annoncer menteur  // choix 2 : annoncer tout pile */
    public void annoncer(int choix) throws RemoteException {
        pnlJouer.setVisible(false);//Masque le panel jouer
        proxy.actionJoueur(choix, pseudo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPartieDe = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstJoueurs = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaNosDes = new javax.swing.JTextArea();
        pnlJouer = new javax.swing.JPanel();
        btnSurencherir = new javax.swing.JButton();
        btnMenteur = new javax.swing.JButton();
        btnToutPile = new javax.swing.JButton();
        lblAVotreTour = new javax.swing.JLabel();
        lvlChiffre = new javax.swing.JLabel();
        txfChiffeMise = new javax.swing.JTextField();
        lblNombreDes = new javax.swing.JLabel();
        txfNombreDes = new javax.swing.JTextField();
        lblEnchere = new javax.swing.JLabel();
        lblNosDes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaEnchereEnCours = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnLancerDice = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblPartieDe.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblPartieDe.setText("Partie de ---------");

        lstJoueurs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstJoueurs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstJoueurs);

        txaNosDes.setEditable(false);
        txaNosDes.setColumns(20);
        txaNosDes.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txaNosDes.setRows(5);
        jScrollPane3.setViewportView(txaNosDes);

        pnlJouer.setForeground(new java.awt.Color(153, 153, 153));

        btnSurencherir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSurencherir.setText("Surencherir");
        btnSurencherir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSurencherirActionPerformed(evt);
            }
        });

        btnMenteur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMenteur.setText("Annoncer 'Menteur!'");
        btnMenteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenteurActionPerformed(evt);
            }
        });

        btnToutPile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnToutPile.setText("Annoncer tout pile");
        btnToutPile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToutPileActionPerformed(evt);
            }
        });

        lblAVotreTour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAVotreTour.setText("A vous de jouer :");

        lvlChiffre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lvlChiffre.setText("Chiffre misé :");

        txfChiffeMise.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        lblNombreDes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreDes.setText("Nombre de dés :");

        txfNombreDes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txfNombreDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreDesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlJouerLayout = new javax.swing.GroupLayout(pnlJouer);
        pnlJouer.setLayout(pnlJouerLayout);
        pnlJouerLayout.setHorizontalGroup(
            pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJouerLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblAVotreTour)
                    .addGroup(pnlJouerLayout.createSequentialGroup()
                        .addComponent(btnSurencherir)
                        .addGap(94, 94, 94)
                        .addComponent(btnMenteur))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlJouerLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lvlChiffre)
                        .addGap(18, 18, 18)
                        .addComponent(txfChiffeMise, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJouerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(btnToutPile)
                        .addGap(21, 21, 21))
                    .addGroup(pnlJouerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreDes)
                        .addGap(18, 18, 18)
                        .addComponent(txfNombreDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlJouerLayout.setVerticalGroup(
            pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJouerLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblAVotreTour)
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJouerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lvlChiffre)
                            .addComponent(txfChiffeMise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreDes)
                            .addComponent(txfNombreDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(pnlJouerLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSurencherir)
                            .addComponent(btnMenteur)
                            .addComponent(btnToutPile))
                        .addContainerGap(99, Short.MAX_VALUE))))
        );

        lblEnchere.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEnchere.setText("Enchère en cours :");

        lblNosDes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNosDes.setText("Vos dés :");

        txaEnchereEnCours.setEditable(false);
        txaEnchereEnCours.setColumns(20);
        txaEnchereEnCours.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txaEnchereEnCours.setRows(5);
        jScrollPane2.setViewportView(txaEnchereEnCours);

        jButton1.setText("pop lancer dés + a toi de jouer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnLancerDice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLancerDice.setText("Lancer les dés");
        btnLancerDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancerDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLancerDice)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEnchere))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNosDes)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblPartieDe)
                        .addGap(206, 206, 206)))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lblPartieDe)
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNosDes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEnchere)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton1)
                        .addGap(26, 26, 26)
                        .addComponent(btnLancerDice)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*BOUTON DE TESSSSSTTTT!!!!! */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        btnLancerDice.setVisible(true);
        pnlJouer.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txfNombreDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreDesActionPerformed

    /*  Récupère la mise    */
    private void btnSurencherirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurencherirActionPerformed
        int chiffre;
        int quantite;

        /*Conversion char->int*/
        chiffre = Integer.parseInt(txfChiffeMise.getText());
        quantite = Integer.parseInt(txfNombreDes.getText());

        System.out.println("chiffre " + chiffre);
        System.out.println("quantite " + quantite);

        pnlJouer.setVisible(false);//Masque le panel jouer
        
        
    }//GEN-LAST:event_btnSurencherirActionPerformed

    /*  Annoncer menteur    */
    private void btnMenteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenteurActionPerformed
        try {
            annoncer(1);
        } catch (RemoteException ex) {
            Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenteurActionPerformed

    /*  Annoncer tout pile  */
    private void btnToutPileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToutPileActionPerformed
        try {
            annoncer(2);
        } catch (RemoteException ex) {
            Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnToutPileActionPerformed

    private void btnLancerDiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLancerDiceActionPerformed
        actualiserNosDes();
    }//GEN-LAST:event_btnLancerDiceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLancerDice;
    private javax.swing.JButton btnMenteur;
    private javax.swing.JButton btnSurencherir;
    private javax.swing.JButton btnToutPile;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAVotreTour;
    private javax.swing.JLabel lblEnchere;
    private javax.swing.JLabel lblNombreDes;
    private javax.swing.JLabel lblNosDes;
    private javax.swing.JLabel lblPartieDe;
    private javax.swing.JList<String> lstJoueurs;
    private javax.swing.JLabel lvlChiffre;
    private javax.swing.JPanel pnlJouer;
    private javax.swing.JTextArea txaEnchereEnCours;
    private javax.swing.JTextArea txaNosDes;
    private javax.swing.JTextField txfChiffeMise;
    private javax.swing.JTextField txfNombreDes;
    // End of variables declaration//GEN-END:variables
}