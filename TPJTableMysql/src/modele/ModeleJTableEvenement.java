/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoEvenement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.Evenement;

/**
 *
 * @author Pierre
 */
public class ModeleJTableEvenement extends AbstractTableModel {
    private List<Evenement> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoEvenement leDaoEvenement;

    public ModeleJTableEvenement(DaoEvenement leDaoEvenement) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"NuméroVIP", "DateMariage", "NuméroVIPConjoint", "LieuMariage", "DateDivorce"};
        // l'objet DAO utilisé
        this.leDaoEvenement = leDaoEvenement;
    }

    @Override
    public int getRowCount() {
        return leConteneur.size();
    }

    @Override
    public int getColumnCount() {
        return titre.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Evenement evenement = leConteneur.get(row);
        if (column == 0) {
            return evenement.getNumVIP();
        } else if (column == 1) {
            return evenement.getDateMariage();
        } else if(column==2) {
            return evenement.getNumVIPConjoint();
        }
        else if(column==3) {
            return evenement.getLieuMariage();
        }
        else {
            return evenement.getDateDivorce();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererEvenement(Evenement evenement) throws SQLException {
        leDaoEvenement.insererEvenement(evenement);
        leConteneur.add(evenement);
        this.fireTableDataChanged();
    }

    public void supprimerEvenement(int ligne) throws SQLException {
        int numVIP = (int) getValueAt(ligne, 0);
        leDaoEvenement.supprimerEvenement(numVIP);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }

    public void chargerLesEvenements() throws SQLException {
        leDaoEvenement.lireLesEvenements(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
    public void afficherEvenement() throws SQLException{
       leDaoEvenement.lireLesEvenements(leConteneur);
        for(Evenement i : leConteneur){
            System.out.println(i);
        }
    }
}
