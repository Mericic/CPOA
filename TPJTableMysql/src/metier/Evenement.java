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
public class Evenement {
    private int numVIP;
    private Date dateMariage;
    private int numVIPConjoint;
    private String lieuMariage;
    private Date dateDivorce;

    public Evenement(int numVIP, Date dateMariage, int numVIPConjoint,String lieuMariage, Date dateDivorce) {
        this.numVIP = numVIP;
        this.dateMariage = dateMariage;
        this.numVIPConjoint = numVIPConjoint;
        this.lieuMariage = lieuMariage;
        this.dateDivorce = dateDivorce;
    }

    public int getNumVIP() {
        return numVIP;
    }

    public Date getDateMariage() {
        return dateMariage;
    }

    public int getNumVIPConjoint() {
        return numVIPConjoint;
    }

    public String getLieuMariage() {
        return lieuMariage;
    }

    public Date getDateDivorce() {
        return dateDivorce;
    }

    public void setNumVIP(int numVIP) {
        this.numVIP = numVIP;
    }

    public void setDateMariage(Date dateMariage) {
        this.dateMariage = dateMariage;
    }

    public void setNumVIPConjoint(int numVIPConjoint) {
        this.numVIPConjoint = numVIPConjoint;
    }

    public void setLieuMariage(String lieuMariage) {
        this.lieuMariage = lieuMariage;
    }

    public void setDateDivorce(Date dateDivorce) {
        this.dateDivorce = dateDivorce;
    }
    
}
