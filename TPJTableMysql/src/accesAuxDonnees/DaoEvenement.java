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
import metier.Evenement;

/**
 *
 * @author Pierre
 */
public class DaoEvenement {
    private final Connection connexion;

    public DaoEvenement(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesEvenements(List<Evenement> lesEvenement) throws SQLException {    
        String requete = "select * from Evenement";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int numVip = rset.getInt(1);
            Date dateMariage = rset.getDate(2);
            int numVipConjoint = rset.getInt(3);
            String lieuMariage = rset.getString(4);
            Date dateDivorce=rset.getDate(5);
            Evenement temp = new Evenement(numVip, dateMariage, numVipConjoint, lieuMariage, dateDivorce);
            lesEvenement.add(temp);
        }
        rset.close();
        pstmt.close();     
    }

    public void supprimerEvenement(int numVIP) throws SQLException {
        String requete = "delete from Evenement where numVIP = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVIP);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void insererEvenement(Evenement evenement) throws SQLException {
        String requete = "insert into Evenement (numVIP, dateMariage, numVIPConjoint, lieuMariage,DateDivorce) values(?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, evenement.getNumVIP());
        pstmt.setDate(2, evenement.getDateMariage());
        pstmt.setInt(3, evenement.getNumVIPConjoint());
        pstmt.setString(4,evenement.getLieuMariage());
        pstmt.setDate(5,evenement.getDateDivorce());
        pstmt.executeUpdate();
        pstmt.close();
    }
}
