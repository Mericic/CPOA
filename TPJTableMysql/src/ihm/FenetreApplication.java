/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm;

import accesAuxDonnees.DaoPays;
import accesAuxDonnees.SourceMySql;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import metier.VIP;
import modele.ModeleJComboBoxPays;
import modele.ModeleJTableEvenement;
import modele.ModeleJTableVIP;

/**
 *
 * @author Alain
 */
public class FenetreApplication extends javax.swing.JFrame {

    private ModeleJTableVIP leModeleVIP;
    private ModeleJTableEvenement leModeleEvenement;
    private static DaoPays daoPays;
    private static DataSource laSourceDeDonnees;
    private static Connection laConnexion;

    public FenetreApplication(ModeleJTableVIP leModeleVIP, ModeleJTableEvenement leModeleEvenement) {
        this.leModeleVIP = leModeleVIP;
        this.leModeleEvenement = leModeleEvenement;
        // initialisation
        initComponents();
        // affichage
        try {
            leModeleVIP.chargerLesVIP();
            leModeleEvenement.chargerLesEvenements();
        } catch (Exception ex) {
            Logger.getLogger(FenetreApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        btSupprimerVIP = new javax.swing.JButton();
        btInsererVIP = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        laTableVIP = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        laTableEvenement = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Administration Base de Données Voicela");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btSupprimerVIP.setText("Supprimer");
        btSupprimerVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSupprimerVIPActionPerformed(evt);
            }
        });

        btInsererVIP.setText("Inserer");
        btInsererVIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInsererVIPActionPerformed(evt);
            }
        });

        laTableVIP.setModel(leModeleVIP);
        jScrollPane1.setViewportView(laTableVIP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btSupprimerVIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 259, Short.MAX_VALUE)
                .addComponent(btInsererVIP, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSupprimerVIP)
                    .addComponent(btInsererVIP))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("tab3", jPanel1);

        laTableEvenement.setModel(leModeleEvenement);
        jScrollPane2.setViewportView(laTableEvenement);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSupprimerVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSupprimerVIPActionPerformed
        // TODO add your handling code here:
        try {
            int ligne = laTableVIP.getSelectedRow();
            leModeleVIP.supprimerVIP(ligne);
        } catch (Exception e) {
            System.out.println("Exception à la suppression : " + e.getMessage());
        }
    }//GEN-LAST:event_btSupprimerVIPActionPerformed

    private void btInsererVIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInsererVIPActionPerformed
        // TODO add your handling code here:
        try {
            laSourceDeDonnees=SourceMySql.getSource();
            laConnexion = laSourceDeDonnees.getConnection();
            daoPays= new DaoPays(laConnexion);
            final ModeleJComboBoxPays leModeleJComboBox= new ModeleJComboBoxPays(daoPays);
            VIP vip = new VIP();
            FenetreSaisieVIP laSaisie = new FenetreSaisieVIP(this, vip, leModeleJComboBox);
            if (laSaisie.doModal() == true) {
                leModeleVIP.insererVIP(vip);
            }
        } catch (Exception e) {
            System.out.println("Exception à l'insertion : " + e.getMessage());
        }
    }//GEN-LAST:event_btInsererVIPActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int reponse = JOptionPane.showConfirmDialog(this, "Voulez vraiment sortir ?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (reponse == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btInsererVIP;
    private javax.swing.JButton btSupprimerVIP;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable laTableEvenement;
    private javax.swing.JTable laTableVIP;
    // End of variables declaration//GEN-END:variables
}
