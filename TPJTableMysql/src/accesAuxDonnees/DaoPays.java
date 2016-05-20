/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.Pays;

/**
 *
 * @author Pierre
 */
public class DaoPays {
    private final Connection connexion;

    public DaoPays(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesPays(List<Pays> lesPays) throws SQLException {    
        String requete = "select * from Pays";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            String nomPays = rset.getString(1);
            Pays temp = new Pays(nomPays);
            lesPays.add(temp);
        }
        rset.close();
        pstmt.close();     
    }
}
