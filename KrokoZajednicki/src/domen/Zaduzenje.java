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
public class Zaduzenje extends AbstractObject{
    private int zaduzenjeID;
    private Date datumZaduzenja;
    private Date datumRazduzenja;
    private int brojDana;
    private double iznos;
    private Clan clan;
    private Zaposleni zaduzio;
    private Zaposleni razduzio;
    private List<AbstractObject> listaStavki;

    public Zaduzenje() {
    }
    
    public Zaduzenje(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }
    
    public Zaduzenje(int zaduzenjeID, Date datumZaduzenja, Date datumRazduzenja, int brojDana, double iznos, Clan clan, Zaposleni zaduzio, Zaposleni razduzio) {
        this.zaduzenjeID = zaduzenjeID;
        this.datumZaduzenja = datumZaduzenja;
        this.datumRazduzenja = datumRazduzenja;
        this.brojDana = brojDana;
        this.iznos = iznos;
        this.clan = clan;
        this.zaduzio = zaduzio;
        this.razduzio = razduzio;
        this.listaStavki = new ArrayList<>();
    }

    public int getZaduzenjeID() {
        return zaduzenjeID;
    }

    public void setZaduzenjeID(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
    }

    public Date getDatumZaduzenja() {
        return datumZaduzenja;
    }

    public void setDatumZaduzenja(Date datumZaduzenja) {
        this.datumZaduzenja = datumZaduzenja;
    }

    public Date getDatumRazduzenja() {
        return datumRazduzenja;
    }

    public void setDatumRazduzenja(Date datumRazduzenja) {
        this.datumRazduzenja = datumRazduzenja;
    }

    public int getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(int brojDana) {
        this.brojDana = brojDana;
    }

    public double getIznos() {
        return iznos;
    }

    public void setIznos(double iznos) {
        this.iznos = iznos;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Zaposleni getZaduzio() {
        return zaduzio;
    }

    public void setZaduzio(Zaposleni zaduzio) {
        this.zaduzio = zaduzio;
    }

    public Zaposleni getRazduzio() {
        return razduzio;
    }

    public void setRazduzio(Zaposleni razduzio) {
        this.razduzio = razduzio;
    }
    
    public List<AbstractObject> getListaStavki() {
        return listaStavki;
    }
    public void setListaStavki(List<AbstractObject> listaStavki) {
        this.listaStavki = listaStavki;
    }

    @Override
    public String toString() {
        return "Zaduzenje:" + zaduzenjeID + ", datum zaduzenja:" + datumZaduzenja + ", clan:" + clan;
    }
    
     

    @Override
    public String vratiImeTabele() {

        return "zaduzenje";
        
    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s', "+ null +", '%s', '%s', '%s', '%s', "+ null, zaduzenjeID, datumZaduzenja, brojDana, iznos, clan.getClanID(), zaduzio.getZaposleniID());

    }

    @Override
    public String vratiPK() {

        return "zaduzenjeID";
    }

    @Override
    public Integer vratiVrednostPK() {


        return zaduzenjeID;
    }
    
    @Override
    public String vratiUslov() {
        return null;
    }

    @Override
    public String vratiSlozenPK() {
        return null;
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {

        List<AbstractObject> zaduzenja = new ArrayList<>();
        try {
            while (rs.next()) {
                int zaduzenjeSifra = rs.getInt("zaduzenjeID");
                Date datZad = rs.getDate("datumZaduzenja");
                Date datRaz = rs.getDate("datumRazduzenja");
                int dani = rs.getInt("brojDana");
                double izn = rs.getDouble("iznos");
                int clanSifra = rs.getInt("clanID");
                int zad = rs.getInt("zaduzioID");
                int raz = rs.getInt("razduzioID");
                Clan cl = new Clan(clanSifra);
                Zaposleni zapZad = new Zaposleni(zad);
                Zaposleni zapRaz = new Zaposleni(raz);
                
                Zaduzenje z = new Zaduzenje(zaduzenjeSifra, datZad, datRaz, dani, izn, cl, zapZad, zapRaz);
              
                zaduzenja.add(z);
            }
        } catch (SQLException ex) {
            System.out.println("Greska u Zaduzenje.Class ResultSet-u");
        }
        return zaduzenja;
    }

    @Override
    public String vratiUpdate() {

         return String.format("zaduzenjeID='%s', datumZaduzenja='%s', datumRazduzenja='%s', brojDana='%s', iznos='%s', clanID='%s', zaduzioID='%s', razduzioID='%s'", zaduzenjeID, datumZaduzenja, datumRazduzenja, brojDana, iznos, clan.getClanID(), zaduzio.getZaposleniID(), razduzio.getZaposleniID());
    }

    @Override
    public void postaviVrednostPK(int zaduzenjeID) {
        this.zaduzenjeID = zaduzenjeID;
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
        final Zaduzenje other = (Zaduzenje) obj;
        if (this.zaduzenjeID != other.zaduzenjeID) {
            return false;
        }
        return true;
    }

}
