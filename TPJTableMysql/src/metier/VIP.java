/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Date;

/**
 *
 * @author Pierre
 */
public class VIP {
    private int numVIP;
    private String nomVIP;
    private String prenomVIP;
    private String civilite;
    private Date dateNaissance;
    private String codeRole;
    private String pays;
    private String codeStatut;
    private String lieuNaissance;

    public VIP(int numVIP, String nomVIP, String prenomVIP, String civilite, Date dateNaissance, String lieuNaissance, String codeRole, String pays, String codeStatut) {
        this.numVIP = numVIP;
        this.nomVIP = nomVIP;
        this.prenomVIP = prenomVIP;
        this.civilite = civilite;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance=lieuNaissance;
        this.codeRole = codeRole;
        this.pays = pays;
        this.codeStatut = codeStatut;
    }
    
    public VIP(){
        
    }

    public int getNumVIP() {
        return numVIP;
    }

    public String getNomVIP() {
        return nomVIP;
    }

    public String getPrenomVIP() {
        return prenomVIP;
    }

    public String getCivilite() {
        return civilite;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getCodeRole() {
        return codeRole;
    }

    public String getPays() {
        return pays;
    }

    public String getCodeStatut() {
        return codeStatut;
    }

    public void setNumVIP(int numVIP) {
        this.numVIP = numVIP;
    }

    public void setNomVIP(String nomVIP) {
        this.nomVIP = nomVIP;
    }

    public void setPrenomVIP(String prenomVIP) {
        this.prenomVIP = prenomVIP;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setCodeRole(String codeRole) {
        this.codeRole = codeRole;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setCodeStatut(String codeStatut) {
        this.codeStatut = codeStatut;
    }

    @Override
    public String toString() {
        return "VIP{" + "numVIP=" + numVIP + ", nomVIP=" + nomVIP + ", prenomVIP=" + prenomVIP + ", civilite=" + civilite + ", dateNaissance=" + dateNaissance + ", codeRole=" + codeRole + ", pays=" + pays + ", codeStatut=" + codeStatut + '}';
    }
    
    
}
