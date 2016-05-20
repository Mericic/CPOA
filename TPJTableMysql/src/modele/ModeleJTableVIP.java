/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoVIP;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import metier.VIP;

/**
 *
 * @author Alain
 */
public class ModeleJTableVIP extends AbstractTableModel {
    // le conteneur de données

    private List<VIP> leConteneur;
    // le titre des champs du conteneur
    private String[] titre;
    // l'objet DAO pour mettre à jour le conteneur
    private DaoVIP leDaoVIP;

    public ModeleJTableVIP(DaoVIP leDaoVIP) {
        // définition du conteneur d'étudiants
        this.leConteneur = new ArrayList<>();
        // définition des noms du champ
        this.titre = new String[]{"Numéro", "Nom", "prenom", "civilite", "dateNaissance","lieuNaissance", "codeRole", "pays", "codeStatut"};
        // l'objet DAO utilisé
        this.leDaoVIP = leDaoVIP;
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
        VIP vip = leConteneur.get(row);
        if (column == 0) {
            return vip.getNumVIP();
        } else if (column == 1) {
            return vip.getNomVIP();
        } else if(column==2) {
            return vip.getPrenomVIP();
        }
        else if(column==3) {
            return vip.getCivilite();
        }
        else if(column==4) {
            return vip.getDateNaissance();
        }
        else if(column==5) {
            return vip.getLieuNaissance();
        }
        else if(column==6) {
            return vip.getCodeRole();
        }
        else if(column==7) {
            return vip.getPays();
        }
        else {
            return vip.getCodeStatut();
        }
    }

    @Override
    public String getColumnName(int column) {
        return titre[column];
    }

    public void insererVIP(VIP vip) throws SQLException {
        leDaoVIP.insererVIP(vip);
        leConteneur.clear();
        leDaoVIP.lireLesVIP(leConteneur);
        this.fireTableDataChanged();
    }

    public void supprimerVIP(int ligne) throws SQLException {
        int numVIP = (int) getValueAt(ligne, 0);
        leDaoVIP.supprimerVIP(numVIP);
        leConteneur.remove(ligne);
        this.fireTableDataChanged();
    }

    public void chargerLesVIP() throws SQLException {
        leDaoVIP.lireLesVIP(leConteneur);
        fireTableDataChanged();  // notification de modification des données à la vue
    }
    
    public void afficherVIP() throws SQLException{
       leDaoVIP.lireLesVIP(leConteneur);
        for(VIP i : leConteneur){
            System.out.println(i);
        }
    }
}
