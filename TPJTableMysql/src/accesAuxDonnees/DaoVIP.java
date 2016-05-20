/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package accesAuxDonnees;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import metier.VIP;

/**
 *
 * @author Alain
 */
public class DaoVIP {

    private final Connection connexion;

    public DaoVIP(Connection connexion) throws SQLException {
        this.connexion = connexion;     
    }

    public void lireLesVIP(List<VIP> lesVIP) throws SQLException {    
        String requete = "select * from VIP";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        ResultSet rset = pstmt.executeQuery(requete);
        while (rset.next()) {       // traitement du résulat
            int num = rset.getInt(1);
            String nom = rset.getString(2);
            String prenom = rset.getString(3);
            String civilite = rset.getString(4);
            Date date=rset.getDate(5);
            java.sql.Date dateNaissance  = new java.sql.Date(date.getTime());
            String lieuNaissance=rset.getString(6);
            String codeRole=rset.getString(7);
            String pays=rset.getString(8);
            String codeStatut=rset.getString(9);
            VIP temp = new VIP(num, nom, prenom, civilite, dateNaissance,lieuNaissance, codeRole, pays, codeStatut);
            lesVIP.add(temp);
        }
        rset.close();
        pstmt.close();     
    }

    public void supprimerVIP(int numVIP) throws SQLException {
        String requete = "delete from VIP where numVIP = ?";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        pstmt.setInt(1, numVIP);
        pstmt.executeUpdate();
        pstmt.close();
    }

    public void insererVIP(VIP vip) throws SQLException {
        String requete = "insert into VIP (nomVIP, prenomVIP, civilite, dateNaissance,lieuNaissance, codeRole, pays, codeStatut) values(?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt = connexion.prepareStatement(requete);
        //pstmt.setInt(1, vip.getNumVIP());
        pstmt.setString(1, vip.getNomVIP());
        pstmt.setString(2, vip.getPrenomVIP());
        pstmt.setString(3,vip.getCivilite());
        pstmt.setDate(4,vip.getDateNaissance());
        pstmt.setString(5,vip.getLieuNaissance());
        pstmt.setString(6,vip.getCodeRole());
        pstmt.setString(7,vip.getPays());
        pstmt.setString(8, vip.getCodeStatut());
        pstmt.executeUpdate();
        pstmt.close();
    }
}
