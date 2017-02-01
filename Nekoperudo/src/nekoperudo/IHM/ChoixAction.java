package nekoperudo.IHM;

import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nekoperudo.IfJoueur.JoueurNotificationImpl;
import nekoperudo.IfJoueur.Nekoperudo;
import nekoperudo.MJcentral.Mise;

public class ChoixAction extends javax.swing.JDialog {

    String pseudo;
    String serveur;
    String mesDice; //Dés du joueur
    Nekoperudo proxy;
    JoueurNotificationImpl notif;
    boolean aToiDeJouer;
    boolean premierTour = true;

    public int nbDiceParier = 0;

    public int valDice = 2;

    public int[] gobeletJoueur;

    /**
     * Constructeur, initialise et appelle mainDuJoueur()
     * 
     * @param pPseudo
     * @param pServeur
     * @param pProxy
     * @param pNotif
     * @param pAToiDeJouer
     * @param pGobeletJoueur
     * @throws RemoteException
     * @throws InterruptedException
     */
    public ChoixAction(String pPseudo, String pServeur, Nekoperudo pProxy, JoueurNotificationImpl pNotif, boolean pAToiDeJouer, int[] pGobeletJoueur) throws RemoteException, InterruptedException {

        initComponents();

        /*Image*/
        ImageIcon icone = new ImageIcon("C:/Firefox_baby.png");
        JLabel image = new JLabel(icone);
        image.setSize(jPanel1.getWidth(), jPanel1.getHeight());
        jPanel1.add(image);
        jPanel1.repaint();

        this.pseudo = pPseudo;
        this.serveur = pServeur;
        this.proxy = pProxy;
        this.notif = pNotif;
        this.aToiDeJouer = pAToiDeJouer;
        this.gobeletJoueur = pGobeletJoueur;

        pnlJouer.setVisible(false); //Masque le panel "a toi de jouer"

        lblPartieDe.setText("Partie de " + serveur);//initialise le titre

        mainDuJoueur();
    }

    /**
     * Permet à un joueur de jouer (ou non) et actualise la mise et les nos dés
     */
    public void mainDuJoueur() {
        actualiserMise();
        actualiserNosDes();

        if (aToiDeJouer == false) {
            lblAVotreTour.setText("Un autre joueur joue...");
            lblAVotreTour.setEnabled(true);
        }
        if (aToiDeJouer == true) {
            pnlJouer.setVisible(true);
            btnMenteur.setVisible(true);
            btnToutPile.setVisible(true);
            lblAVotreTour.setText("A toi de jouer!");

            System.out.println("C'est a moi de jouer!");
            if (premierTour == true) {
                btnMenteur.setVisible(false);
                btnToutPile.setVisible(false);
            }
        }
    }

    /**
     * Popup de fin de manche avec résultats 
     * A implémenter
     */

    public void popFinManche() {
        PopFinManche pf = new PopFinManche();
        pf.setTitle("Nekorudo : " + pseudo);
        pf.setLocationRelativeTo(null);
        pf.setVisible(true);
    }

    /**
     * Autorise un joueur à jouer son tour
     * @param paToiDeJouer
     */
    public void setaToiDeJouer(boolean paToiDeJouer) {
        this.aToiDeJouer = paToiDeJouer;
        premierTour = false;
        mainDuJoueur();
    }

    /**
     * Définit le 1er tour (on ne peut qu'enchérir)
     * @param ppremierTour
     */
    public void setpremierTour(boolean ppremierTour) {
        this.premierTour = ppremierTour;
    }

   

    /**
     * Actualise le champ nos dés
     */
    public void actualiserNosDes() {
        
        mesDice = "";
        int i;
        
        //Met chaque dé du gobelet dans un String pour affichage
        for (i = 0; i < gobeletJoueur.length; i++) {
            mesDice = mesDice + gobeletJoueur[i] + " ";
        }
        // mesDice = mesDice.substring(0, mesDice.length() - 3);////////////////////////////////////////////////////////////////////////////////
        txaNosDes.setText(mesDice);
        btnLancerDice.setVisible(false); //Masque le bouton "lancer les dés"
    }

    /**
     * Actualise la mise en cours
     */
    public void actualiserMise() {
        lblEnchere.setText("Mise en cours : " + nbDiceParier + "d" + valDice);
    }

    

    /**
     * Effectue l'action choisie et masque le pannel
     * @param choix choix 1 : annoncer menteur  // choix 2 : annoncer tout pile // choix 3 : surenchere
     * @throws RemoteException
     */

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
        txfNombreDes = new javax.swing.JTextField();
        lblNombreDes = new javax.swing.JLabel();
        cbxChiffreMise = new javax.swing.JComboBox<>();
        lblEnchere = new javax.swing.JLabel();
        lblNosDes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaEnchereEnCours = new javax.swing.JTextArea();
        btnLancerDice = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();

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
        txaNosDes.setRows(15);
        txaNosDes.setTabSize(15);
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

        txfNombreDes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txfNombreDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreDesActionPerformed(evt);
            }
        });

        lblNombreDes.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombreDes.setText("Nombre de dés :");

        cbxChiffreMise.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4", "5", "6" }));

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
                        .addComponent(btnMenteur)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                .addComponent(btnToutPile)
                .addGap(21, 21, 21))
            .addGroup(pnlJouerLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(lblNombreDes)
                .addGap(18, 18, 18)
                .addComponent(txfNombreDes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(150, 150, 150)
                .addComponent(lvlChiffre)
                .addGap(18, 18, 18)
                .addComponent(cbxChiffreMise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlJouerLayout.setVerticalGroup(
            pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJouerLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblAVotreTour)
                .addGap(33, 33, 33)
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSurencherir)
                    .addComponent(btnMenteur)
                    .addComponent(btnToutPile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombreDes)
                    .addComponent(txfNombreDes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lvlChiffre)
                    .addComponent(cbxChiffreMise, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
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

        btnLancerDice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLancerDice.setText("Lancer les dés");
        btnLancerDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLancerDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 191, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLancerDice)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEnchere))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNosDes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPartieDe)
                .addGap(329, 329, 329))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lblPartieDe)
                        .addGap(123, 123, 123)
                        .addComponent(lblEnchere)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(lblNosDes))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(btnLancerDice)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 255, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNombreDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreDesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreDesActionPerformed

    /*  Récupère la mise    */ 
    private void btnSurencherirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSurencherirActionPerformed
        
        int chiffre;
        int quantite;
        
        try {
            /*Récupère la mise et conversion char->int*/
            chiffre = (cbxChiffreMise.getSelectedIndex() + 2);
            quantite = Integer.parseInt(txfNombreDes.getText());
            
            //Si le nombre de dés misé est nul : on prend pas en compte
            if (quantite == 0) { 
                throw new NullException();
            }
            
            //On ne peut pas miser moins ou pareil que la mise actuelle
            if (!((valDice < chiffre && nbDiceParier <= quantite) || (valDice <= chiffre && nbDiceParier < quantite))) {
                throw new PetiteMiseException();
            }         

            if (premierTour == true) {////////////////////////////////////////////////////////////////////////////////// Je ne vois la la différence entre le true et le false                
                try {
                    proxy.surencherJoueur(chiffre, quantite);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }

            if (premierTour == false) {
                try {
                    proxy.surencherJoueur(chiffre, quantite);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("chiffre " + chiffre);
            System.out.println("quantite " + quantite);
            try {
                proxy.actionJoueur(3, pseudo);
            } catch (RemoteException ex) {
                Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            pnlJouer.setVisible(false);//Masque le panel jouer

        } catch (NullException ex) {
            Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PetiteMiseException ex) {
            JOptionPane.showMessageDialog(this, "Veuillez entrer une mise suppérieure à la mise actuelle.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }


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

    /**
     *
     * @param pmiseNbr
     * @return String 
     * @throws RemoteException
     * @throws InterruptedException
     */
    public String frameNotifSurencherNbr(String pmiseNbr) throws RemoteException, InterruptedException {

        String[] decoupe = pmiseNbr.split(" ");

        this.nbDiceParier = Integer.parseInt(decoupe[0]);
        this.valDice = Integer.parseInt(decoupe[1]);
        return "";
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnLancerDice;
    private javax.swing.JButton btnMenteur;
    private javax.swing.JButton btnSurencherir;
    private javax.swing.JButton btnToutPile;
    private javax.swing.JComboBox<String> cbxChiffreMise;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField txfNombreDes;
    // End of variables declaration//GEN-END:variables

    /**
     * Lance une nouvelle manche
     * @param pAToiDeJouer
     * @return
     */
    public String frameNouvelleManche(String pAToiDeJouer) {
        int i;

        nbDiceParier = 0;
        valDice = 2;

        actualiserMise();

        try {
            sleep(250);
        } catch (InterruptedException ex) {
            Logger.getLogger(FileAttente.class.getName()).log(Level.SEVERE, null, ex);
        }

        String[] stringDecoupepAToiDeJouer = pAToiDeJouer.split(",");
        boolean baToiDeJouer = Boolean.parseBoolean(stringDecoupepAToiDeJouer[1]);

        pAToiDeJouer = pAToiDeJouer.replace(",false", "");
        pAToiDeJouer = pAToiDeJouer.replace(",true", "");
        String[] stringDecoupeGobelet = pAToiDeJouer.split(" ");
        int[] intDecoupeGobelet = new int[stringDecoupeGobelet.length];

        for (i = 0; i < stringDecoupeGobelet.length; i++) {
            intDecoupeGobelet[i] = Integer.parseInt(stringDecoupeGobelet[i]);
        }

        gobeletJoueur = intDecoupeGobelet;

        mainDuJoueur();

        return "";
    }

    /**
     * Pas implémenté
     * @param fddds Paramètre inutile
     */
    public void frameNotifVictoire(String fddds) {
        lblPartieDe.setText("VICTOIRE!!!!");
    }

    /**
     * Pas implémenté
     * @param dsg
     */
    public void frameNotifLoose(String dsg) {
        lblPartieDe.setText("Vous avez PERDU");
    }
}
