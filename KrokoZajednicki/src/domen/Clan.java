/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author KOMP
 */
public class Clan extends AbstractObject{
    private int clanID;
    private String ime;
    private String prezime;
    private String JMBG;
    private String kontakt;
    private String email;
    private String adresa;
    private Status status;
    private Date clanarina;
    private int godine;
    private Opstina opstina;

    public Clan() {
    }
    
    public Clan(int clanID) {
        this.clanID = clanID;
    }
    
    public Clan(int clanID, String ime, String prezime, String JMBG, String kontakt, String email, String adresa, Status status, Date clanarina, int godine, Opstina opstina) {
        this.clanID = clanID;
        this.ime = ime;
        this.prezime = prezime;
        this.JMBG = JMBG;
        this.kontakt = kontakt;
        this.email = email;
        this.adresa = adresa;
        this.status = status;
        this.clanarina = clanarina;
        this.godine = godine;
        this.opstina = opstina;
    }

    public int getClanID() {
        return clanID;
    }

    public void setClanID(int clanID) {
        this.clanID = clanID;
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

    public String getJMBG() {
        return JMBG;
    }

    public void setJMBG(String JMBG) {
        this.JMBG = JMBG;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    public Date getClanarina() {
        return clanarina;
    }

    public void setClanarina(Date clanarina) {
        this.clanarina = clanarina;
    }
    
    public int getGodine() {
        return godine;
    }

    public void setGodine(int godine) {
        this.godine = godine;
    }

    public Opstina getOpstina() {
        return opstina;
    }

    public void setOpstina(Opstina opstina) {
        this.opstina = opstina;
    }
    
    
    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String vratiImeTabele() {
        return "clan";
        
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s'", clanID, ime, prezime, JMBG, kontakt, email, adresa, status, clanarina, godine, opstina.getpostanskiBroj());
    }

    @Override
    public String vratiPK() {
        return "clanID";
    }

    @Override
    public Integer vratiVrednostPK() {
        return clanID;
    }
    
    @Override
    public String vratiUslov() {
        return JMBG;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {

        List<AbstractObject> clanovi = new ArrayList<>();
        try {
            while (rs.next()) {
                int clanSifra = rs.getInt("clanID");
                String imeClan = rs.getString("ime");
                String prezimeClan = rs.getString("prezime");
                String JMBGClan = rs.getString("JMBG");
                String kontaktClan = rs.getString("kontakt");
                String emailClan = rs.getString("email");
                String adresaClan = rs.getString("adresa");
                String statusClan = rs.getString("status");
                Date clanarinaClan = rs.getDate("clanarina");
                int godineClan = rs.getInt("godine");
                int postanskiBroj = rs.getInt("postanskiBroj");
                Opstina opst = new Opstina(postanskiBroj);
                
                Clan c = new Clan(clanSifra, imeClan, prezimeClan, JMBGClan, kontaktClan, emailClan, adresaClan, Status.getName(statusClan), clanarinaClan, godineClan, opst);
              
                clanovi.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Greska u Clan.Class ResultSet-u");
        }
        return clanovi;
        
    }

    @Override
    public String vratiUpdate() {

         return String.format("clanID='%s', ime='%s', prezime='%s', JMBG='%s', kontakt='%s', email='%s', adresa='%s', status='%s', clanarina='%s', godine='%s', postanskiBroj='%s'", clanID, ime, prezime, JMBG, kontakt, email, adresa, status, clanarina, godine, opstina.getpostanskiBroj());
    }

    @Override
    public void postaviVrednostPK(int clanID) {

        this.clanID = clanID;
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
        final Clan other = (Clan) obj;
        if (this.clanID != other.clanID) {
            return false;
        }
        return true;
    }
}
