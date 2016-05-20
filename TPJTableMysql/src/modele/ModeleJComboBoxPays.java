/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import accesAuxDonnees.DaoPays;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import metier.Pays;

/**
 *
 * @author Pierre
 */
public class ModeleJComboBoxPays extends DefaultComboBoxModel {
    private List<Pays> listeItems;
    private DaoPays leDaoPays;

    public ModeleJComboBoxPays(DaoPays leDaoPays) {
        super();
        this.listeItems = new ArrayList<>();
        this.leDaoPays = leDaoPays;
    }
    public void chargerLesPays() throws SQLException {
        leDaoPays.lireLesPays(listeItems);
    }
    
    @Override
    public Object getElementAt(int index){
        return listeItems.get(index);
    }
    
    @Override
    public int getSize(){
        return listeItems.size();
    }
   
    public void addElement(String uneChaine) {
        super.addElement(uneChaine);
    }
    
    public void afficherPays() throws SQLException{
       leDaoPays.lireLesPays(listeItems);
        for(Pays i : listeItems){
            System.out.println(i);
        }
    }

}
