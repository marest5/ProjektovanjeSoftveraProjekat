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
import java.util.Objects;

/**
 *
 * @author KOMP
 */
public class Zaposleni extends AbstractObject{
    private int zaposleniID;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String korisnickaSifra;
    private boolean ulogovan;

    public Zaposleni() {
    }
    
    public Zaposleni(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public Zaposleni(int zaposleniID, String ime, String prezime, String korisnickoIme, String korisnickaSifra, boolean ulogovan) {
        this.zaposleniID = zaposleniID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.korisnickaSifra = korisnickaSifra;
        this.ulogovan = ulogovan;
    }

    public int getZaposleniID() {
        return zaposleniID;
    }

    public void setZaposleniID(int zaposleniID) {
        this.zaposleniID = zaposleniID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getKorisnickaSifra() {
        return korisnickaSifra;
    }

    public void setKorisnickaSifra(String korisnickaSifra) {
        this.korisnickaSifra = korisnickaSifra;
    }

    public boolean isUlogovan() {
        return ulogovan;
    }

    public void setUlogovan(boolean ulogovan) {
        this.ulogovan = ulogovan;
    }
    
     @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public String vratiImeTabele() {

        return "zaposleni";
        
    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s', '%s', '%s', '%s'", zaposleniID, ime, prezime, korisnickoIme, korisnickaSifra);

    }

    @Override
    public String vratiPK() {

        return "zaposleniID";
    }

    @Override
    public Integer vratiVrednostPK() {


        return zaposleniID;
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

        List<AbstractObject> sviZaposleni = new ArrayList<>();
        try {
            while (rs.next()) {
                boolean logovanje = false;
                int idZap = rs.getInt("zaposleniID");
                String imeZap = rs.getString("ime");
                String prezimeZap = rs.getString("prezime");
                String korImeZap = rs.getString("korisnickoIme");
                String sifraZap = rs.getString("korisnickaSifra");
                
                Zaposleni z = new Zaposleni(idZap, imeZap, prezimeZap, korImeZap, sifraZap, logovanje);
              
                sviZaposleni.add(z);
            }
        } catch (SQLException ex) {
            System.out.println("Greska u Zaposleni.Class ResultSet-u");
        }
        return sviZaposleni;
        
    }

    @Override
    public String vratiUpdate() {

         return String.format("zaposleniID='%s', ime='%s', prezime='%s', korisnickoIme='%s', korisnickaSifra='%s'", zaposleniID, ime, prezime, korisnickoIme, korisnickaSifra);
    }

    @Override
    public void postaviVrednostPK(int zaposleniID) {

        this.zaposleniID = zaposleniID;
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
        final Zaposleni other = (Zaposleni) obj;
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.korisnickaSifra, other.korisnickaSifra)) {
            return false;
        }
        return true;
    }
}
