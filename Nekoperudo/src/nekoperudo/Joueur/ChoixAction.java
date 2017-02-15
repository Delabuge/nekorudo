package nekoperudo.Joueur;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import nekoperudo.Interface.Nekoperudo;

public class ChoixAction extends javax.swing.JDialog {

    String pseudo;
    String serveur;
    String mesDice; //Dés du joueur
    Nekoperudo proxy;
    JoueurNotificationImpl notif;
    boolean aToiDeJouer;
    //   boolean premierTour = true;

    public int nbDiceParier = 0;

    public int valDice = 2;

    public int[] gobeletJoueur;
    int choixPartie;
    boolean miseEnPageOk = false;
    String nomPartie;

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
    public ChoixAction(String pPseudo, String pServeur, Nekoperudo pProxy, JoueurNotificationImpl pNotif, boolean pAToiDeJouer, int[] pGobeletJoueur, int pChoixPartie, String pNomPartie) throws RemoteException, InterruptedException {

        initComponents();

        this.pseudo = pPseudo;
        this.serveur = pServeur;
        this.proxy = pProxy;
        this.notif = pNotif;
        this.aToiDeJouer = pAToiDeJouer;
        this.gobeletJoueur = pGobeletJoueur;
        this.choixPartie = pChoixPartie;
        this.nomPartie = pNomPartie;

        lblPartieDe.setText("Partie de " + serveur);//initialise le titre

        pnlJouer.setVisible(true);
        lblAVotreTour.setVisible(true);
        btnSurencherir.setVisible(true);
        btnMenteur.setVisible(true);
        btnToutPile.setVisible(true);
        jLabelNomDePartie.setText("Vous êtes dans la partie : " + nomPartie);
        mainDuJoueur();
    }

    /**
     * Permet à un joueur de jouer (ou non) et actualise la mise et les nos dés
     */
    public void mainDuJoueur() {

        actualiserMise();
        actualiserNosDes();

        pnlJouer.setVisible(true);
        lblAVotreTour.setVisible(true);
        btnSurencherir.setVisible(true);
        btnMenteur.setVisible(true);
        btnToutPile.setVisible(true);

        if (aToiDeJouer == false) {
            imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attenteTour.png")));
            lblAVotreTour.setText("Un autre joueur joue...");

            btnSurencherir.setEnabled(false);
            btnMenteur.setEnabled(false);
            btnToutPile.setEnabled(false);
        }
        if (aToiDeJouer == true) {
            imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cat-bienvenue.png")));
            lblAVotreTour.setText("A toi de jouer!");

            btnSurencherir.setEnabled(true);
            btnMenteur.setEnabled(true);
            btnToutPile.setEnabled(true);

            if (nbDiceParier == 0) {
                btnSurencherir.setEnabled(true);
                btnMenteur.setEnabled(false);
                btnToutPile.setEnabled(false);
            }
        }
    }

    /**
     * Popup de fin de manche avec résultats A implémenter
     */
    public void popFinManche() {
        PopFinManche pf = new PopFinManche();
        pf.setTitle("Nekorudo : " + pseudo);
        pf.setLocationRelativeTo(null);
        pf.setVisible(true);
    }

    /**
     * Autorise un joueur à jouer son tour
     *
     * @param paToiDeJouer
     */
    public void setaToiDeJouer(boolean paToiDeJouer) {
        this.aToiDeJouer = paToiDeJouer;
        //   premierTour = false;
        mainDuJoueur();
    }

    /**
     * Définit le 1er tour (on ne peut qu'enchérir)
     *
     * @param ppremierTour
     */
    public void setpremierTour(boolean ppremierTour) {
        //    this.premierTour = ppremierTour;
    }

    /**
     * Actualise le champ nos dés
     */
    public void actualiserNosDes() {
        int i;
        int stock = gobeletJoueur[0];
        int[] gobeletDuJoueur = new int[5];

        //Met chaque dé du gobelet dans un String pour affichage
        gobeletDuJoueur[0] = (stock / 10000) % 10;
        gobeletDuJoueur[1] = (stock / 1000) % 10;
        gobeletDuJoueur[2] = (stock / 100) % 10;
        gobeletDuJoueur[3] = (stock / 10) % 10;
        gobeletDuJoueur[4] = stock % 10;

        for (i = 0; i < gobeletDuJoueur.length; i++) {
            affichageDe(i, gobeletDuJoueur[i]);
        }
    }

    /**
     * Actualise la mise en cours
     */
    public void actualiserMise() {
        lblEnchere.setText("Mise en cours : " + nbDiceParier + "d" + valDice);
    }

    /**
     * Effectue l'action choisie et masque le pannel
     *
     * @param choix choix 1 : annoncer menteur // choix 2 : annoncer tout pile
     * // choix 3 : surenchere
     * @throws RemoteException
     */
    public void annoncer(int choix) throws RemoteException {
        //pnlJouer.setVisible(false);//Masque le panel jouer
        proxy.actionJoueur(choix, pseudo, choixPartie);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtRetourManche = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabelNomDePartie = new javax.swing.JLabel();
        lblPartieDe = new javax.swing.JLabel();
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
        imageChat = new javax.swing.JLabel();
        jPanelDice = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        txtRetourManche.setFocusable(false);
        txtRetourManche.setWheelScrollingEnabled(false);

        jTextArea1.setColumns(15);
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(3);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jTextArea1.setFocusable(false);
        txtRetourManche.setViewportView(jTextArea1);

        jLabelNomDePartie.setText("Vous êtes dans la partie : ");

        lblPartieDe.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lblPartieDe.setText("Partie de ---------");

        pnlJouer.setBackground(new java.awt.Color(255, 255, 255));
        pnlJouer.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
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

        imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cat-bienvenue.png"))); // NOI18N
        imageChat.setFocusable(false);

        jPanelDice.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDice.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jPanelDice.setOpaque(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png"))); // NOI18N

        javax.swing.GroupLayout jPanelDiceLayout = new javax.swing.GroupLayout(jPanelDice);
        jPanelDice.setLayout(jPanelDiceLayout);
        jPanelDiceLayout.setHorizontalGroup(
            jPanelDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDiceLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanelDiceLayout.setVerticalGroup(
            jPanelDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDiceLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDiceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background-game.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        jLabel6.setMaximumSize(new java.awt.Dimension(800, 600));
        jLabel6.setMinimumSize(new java.awt.Dimension(800, 600));
        jLabel6.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(lblPartieDe))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNosDes)
                        .addGap(416, 416, 416)
                        .addComponent(imageChat))
                    .addComponent(lblEnchere)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jPanelDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(txtRetourManche, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(jLabelNomDePartie))
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(lblPartieDe)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblNosDes))
                    .addComponent(imageChat)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(lblEnchere))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jPanelDice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabelNomDePartie)
                .addGap(51, 51, 51)
                .addComponent(txtRetourManche, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
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

            if (nbDiceParier == 0) {////////////////////////////////////////////////////////////////////////////////// Je ne vois la la différence entre le true et le false                
                try {
                    proxy.surencherJoueur(chiffre, quantite, choixPartie);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            if (nbDiceParier != 0) {
                try {
                    proxy.surencherJoueur(chiffre, quantite, choixPartie);
                } catch (RemoteException ex) {
                    Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("chiffre " + chiffre);
            System.out.println("quantite " + quantite);
            try {
                proxy.actionJoueur(3, pseudo, choixPartie);
            } catch (RemoteException ex) {
                Logger.getLogger(ChoixAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            //  pnlJouer.setVisible(false);//Masque le panel jouer
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

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JButton btnMenteur;
    private javax.swing.JButton btnSurencherir;
    private javax.swing.JButton btnToutPile;
    private javax.swing.JComboBox<String> cbxChiffreMise;
    private javax.swing.JLabel imageChat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNomDePartie;
    private javax.swing.JPanel jPanelDice;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAVotreTour;
    private javax.swing.JLabel lblEnchere;
    private javax.swing.JLabel lblNombreDes;
    private javax.swing.JLabel lblNosDes;
    private javax.swing.JLabel lblPartieDe;
    private javax.swing.JLabel lvlChiffre;
    private javax.swing.JPanel pnlJouer;
    private javax.swing.JTextField txfNombreDes;
    private javax.swing.JScrollPane txtRetourManche;
    // End of variables declaration//GEN-END:variables

    /**
     * Lance une nouvelle manche
     *
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

        System.out.println("intDecoupeGobelet.length " + intDecoupeGobelet.length + " gobeletJoueur.length " + gobeletJoueur.length);
        if (intDecoupeGobelet.length < gobeletJoueur.length) {
            imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PerdDe.png")));
            JOptionPane.showConfirmDialog(this, "Vous avez perdu un dé", "Echec", JOptionPane.ERROR_MESSAGE);
        }

        if (intDecoupeGobelet.length > gobeletJoueur.length) {
            imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GagneDe.png")));
            JOptionPane.showConfirmDialog(this, "Vous avez gagné un dé", "Réussite", JOptionPane.ERROR_MESSAGE);
        }

        gobeletJoueur = intDecoupeGobelet;

        mainDuJoueur();

        return "";
    }

    /**
     * Pas implémenté
     *
     * @param fddds Paramètre "fictif" pour RMI
     */
    public void frameNotifVictoire(String fddds) {
        lblPartieDe.setText("VICTOIRE!!!!");
        imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GagneDe.png")));
    }

    /**
     * Pas implémenté
     *
     * @param dsg Paramètre "fictif" pour RMI
     */
    public void frameNotifLoose(String dsg) {
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
        imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
        lblAVotreTour.setText("Partie perdu");
        lblPartieDe.setText("DEFAITE");
        imageChat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/PerdDe.png")));
    }

    public void affichageDe(int pNumDe, int pValDe) {
        int numDe = pNumDe + 1;
        switch (numDe) {
            case 1:
                switch (pValDe) {
                    case 0:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
                        break;
                    case 1:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png")));
                        break;
                    case 2:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                        break;
                    case 3:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                        break;
                    case 4:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                        break;
                    case 5:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                        break;
                    case 6:
                        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                        break;
                }
                break;
            case 2:
                switch (pValDe) {
                    case 0:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
                        break;
                    case 1:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png")));
                        break;
                    case 2:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                        break;
                    case 3:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                        break;
                    case 4:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                        break;
                    case 5:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                        break;
                    case 6:
                        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                        break;
                }
                break;

            case 3:
                switch (pValDe) {
                    case 0:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
                        break;
                    case 1:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png")));
                        break;
                    case 2:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                        break;
                    case 3:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                        break;
                    case 4:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                        break;
                    case 5:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                        break;
                    case 6:
                        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                        break;
                }
                break;

            case 4:
                switch (pValDe) {
                    case 0:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
                        break;
                    case 1:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png")));
                        break;
                    case 2:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                        break;
                    case 3:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                        break;
                    case 4:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                        break;
                    case 5:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                        break;
                    case 6:
                        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                        break;
                }
                break;

            case 5:
                switch (pValDe) {
                    case 0:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/vide.png")));
                        break;
                    case 1:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/1.png")));
                        break;
                    case 2:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/2.png")));
                        break;
                    case 3:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/3.png")));
                        break;
                    case 4:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/4.png")));
                        break;
                    case 5:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/5.png")));
                        break;
                    case 6:
                        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/6.png")));
                        break;
                }
                break;
        }
    }

    public void frameNotifManche(String pNotifResultatManche) {
        jTextArea1.setText(pNotifResultatManche);
    }
}
