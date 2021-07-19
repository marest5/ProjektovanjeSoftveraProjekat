/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KOMP
 */
public class Trotinet extends AbstractObject{
    private int trotinetID;
    private String naziv;
    private double cena;
    private boolean zauzet;

    public Trotinet() {
    }
    
    public Trotinet(int trotinetID) {
        this.trotinetID = trotinetID;
    }

    public Trotinet(int trotinetID, String naziv, double cena, boolean zauzet) {
        this.trotinetID = trotinetID;
        this.naziv = naziv;
        this.cena = cena;
        this.zauzet = zauzet;
    }

    public int getTrotinetID() {
        return trotinetID;
    }

    public void setTrotinetID(int trotinetID) {
        this.trotinetID = trotinetID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
    
    public boolean isZauzet() {
        return zauzet;
    }

    public void setZauzet(boolean zauzet) {
        this.zauzet = zauzet;
    }

     @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeTabele() {

        return "trotinet";
        
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s'", trotinetID, naziv, cena, (int) (zauzet? 1:0));
    }

    @Override
    public String vratiPK() {

        return "trotinetID";
    }

    @Override
    public Integer vratiVrednostPK() {


        return trotinetID;
    }
    
    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiSlozenPK() {

        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {

        List<AbstractObject> trotineti = new ArrayList<>();
        try {
            while (rs.next()) {
                int trotinetSifra = rs.getInt("trotinetID");
                String nazivTrot = rs.getString("naziv");
                double cenaTrot = rs.getDouble("cena");
                boolean zauzetTrot = rs.getBoolean("zauzet");
                
                Trotinet t = new Trotinet(trotinetSifra, nazivTrot, cenaTrot, zauzetTrot);
              
                trotineti.add(t);
            }
        } catch (SQLException ex) {
            System.out.println("Greska u Trotinet.Class ResultSet-u");
        }
        return trotineti;
        
    }

    @Override
    public String vratiUpdate() {

         return String.format("trotinetID='%s', naziv='%s', cena='%s', zauzet='%s'", trotinetID, naziv, cena, (int) (zauzet? 1:0));
    }

    @Override
    public void postaviVrednostPK(int trotinetID) {

        this.trotinetID = trotinetID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trotinet other = (Trotinet) obj;
        if (this.trotinetID != other.trotinetID) {
            return false;
        }
        return true;
    }

}
