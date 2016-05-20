/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import accesAuxDonnees.DaoEvenement;
import accesAuxDonnees.DaoPays;
import modele.ModeleJTableVIP;
import ihm.FenetreIdentification;
import ihm.FenetreApplication;
import accesAuxDonnees.DaoVIP;
import accesAuxDonnees.SourceMySql;
import java.net.PasswordAuthentication;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import metier.VIP;
import modele.ModeleJComboBoxPays;
import modele.ModeleJTableEvenement;

/**
 *
 * @author Alain
 */
public class Appli {

    private static DataSource laSourceDeDonnees;
    private static Connection laConnexion;
    private static DaoVIP daoVIP;
    private static DaoEvenement daoEvenement;

    public static void main(String[] args) throws Exception {

        // Look and Feel windows
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.print(e.getMessage());
        }

        // Etablissement de la connexion à la base MySql avec affichage de la fenetre d'identification 
        /*boolean etat = false;
        do {
            FenetreIdentification fi = new FenetreIdentification(null);
            PasswordAuthentication login = fi.identifier();
            try {
                laSourceDeDonnees = SourceMySql.getSource(login);
                laConnexion = laSourceDeDonnees.getConnection();
                etat = true;
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "login incorrect : " + ex.getMessage(),
                        "avertissement", JOptionPane.WARNING_MESSAGE);
            }
        } while (etat == false);*/

        // Instanciation des objets nécessaires à l'application
        try {
            laSourceDeDonnees=SourceMySql.getSource();
            laConnexion = laSourceDeDonnees.getConnection();
            // les DAO nécessaires
            daoVIP = new DaoVIP(laConnexion);
            daoEvenement = new DaoEvenement(laConnexion);
            
            // les modèles de données avec le DAO à partir duquel se feront les échanges de données
            final ModeleJTableVIP leModeleVIP = new ModeleJTableVIP(daoVIP);
            final ModeleJTableEvenement leModeleEvenement = new ModeleJTableEvenement(daoEvenement);
            // la fenetre principale de l'application qui tourne dans l'EDT
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FenetreApplication(leModeleVIP, leModeleEvenement).setVisible(true);
                }
            });
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problème dans la création des objets nécessaires" + ex.getMessage(),
                    "avertissement", JOptionPane.WARNING_MESSAGE);
        }
    }
}
