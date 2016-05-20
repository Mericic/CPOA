/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

/**
 *
 * @author Pierre
 */
public class Pays {
    private String nomPays;

    public Pays(String nomPays) {
        this.nomPays = nomPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }

    @Override
    public String toString() {
        return nomPays;
    }
    
    
    
    
}
