/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nekoperudo.IHM;

/**
 *
 * @author Pascal
 */
public class ChoixAction extends javax.swing.JDialog {

    String pseudo;
    
    
    /**
     * Creates new form ChoixAction
     */
    public ChoixAction(String pseudo) {
        
        initComponents();
        
        
        
        
    }
    
    public void popLancerDice(){
        PopupLancerDice d1 = new PopupLancerDice();
        d1.setTitle("Nekorudo : " + pseudo);
        d1.setLocationRelativeTo(null);  
        d1.setVisible(true);        
    }
    
    
    
    public void lancerDice(){
        System.out.println("les dés sont jetés");        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlSurencherir = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstJoueurs = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        txaNosDes = new javax.swing.JTextArea();
        pnlJouer = new javax.swing.JPanel();
        btnSurencherir = new javax.swing.JButton();
        btnMenteur = new javax.swing.JButton();
        btnToutPile = new javax.swing.JButton();
        lblAVotreTour = new javax.swing.JLabel();
        lblEnchere = new javax.swing.JLabel();
        lblNosDes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaEnchereEnCours = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Partie de ---------");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout pnlSurencherirLayout = new javax.swing.GroupLayout(pnlSurencherir);
        pnlSurencherir.setLayout(pnlSurencherirLayout);
        pnlSurencherirLayout.setHorizontalGroup(
            pnlSurencherirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSurencherirLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel2)
                .addContainerGap(619, Short.MAX_VALUE))
        );
        pnlSurencherirLayout.setVerticalGroup(
            pnlSurencherirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSurencherirLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel2)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        lstJoueurs.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lstJoueurs.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstJoueurs);

        txaNosDes.setEditable(false);
        txaNosDes.setColumns(20);
        txaNosDes.setRows(5);
        jScrollPane3.setViewportView(txaNosDes);

        pnlJouer.setForeground(new java.awt.Color(153, 153, 153));

        btnSurencherir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnSurencherir.setText("Surencherir");

        btnMenteur.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnMenteur.setText("Annoncer 'Menteur!'");

        btnToutPile.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnToutPile.setText("Annoncer tout pile");

        lblAVotreTour.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAVotreTour.setText("A vous de jouer :");

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
        );
        pnlJouerLayout.setVerticalGroup(
            pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJouerLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblAVotreTour)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlJouerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSurencherir)
                    .addComponent(btnMenteur)
                    .addComponent(btnToutPile))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblEnchere.setText("Enchère en cours :");

        lblNosDes.setText("Vos dés :");

        txaEnchereEnCours.setEditable(false);
        txaEnchereEnCours.setColumns(20);
        txaEnchereEnCours.setFont(new java.awt.Font("Monospaced", 0, 18)); // NOI18N
        txaEnchereEnCours.setRows(5);
        jScrollPane2.setViewportView(txaEnchereEnCours);

        jButton1.setText("simuler lancer dés");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlSurencherir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(76, 76, 76))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEnchere))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNosDes))
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(311, 311, 311))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addGap(124, 124, 124)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblEnchere)
                            .addComponent(lblNosDes))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(pnlJouer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(pnlSurencherir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        popLancerDice();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChoixAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChoixAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChoixAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChoixAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }    
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenteur;
    private javax.swing.JButton btnSurencherir;
    private javax.swing.JButton btnToutPile;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAVotreTour;
    private javax.swing.JLabel lblEnchere;
    private javax.swing.JLabel lblNosDes;
    private javax.swing.JList<String> lstJoueurs;
    private javax.swing.JPanel pnlJouer;
    private javax.swing.JPanel pnlSurencherir;
    private javax.swing.JTextArea txaEnchereEnCours;
    private javax.swing.JTextArea txaNosDes;
    // End of variables declaration//GEN-END:variables
}
