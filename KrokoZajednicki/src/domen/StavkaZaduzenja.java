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
public class StavkaZaduzenja extends AbstractObject{
    private int stavkaID;
    private Zaduzenje zaduzenje;
    private boolean dodatnaBaterija;
    private boolean dodatnaSvetla;
    private double vrednost;
    private Trotinet trotinet;
    
    public StavkaZaduzenja() {
    }

    public StavkaZaduzenja(int stavkaID, Zaduzenje zaduzenje, boolean dodatnaBaterija, boolean dodatnaSvetla, double vrednost, Trotinet trotinet) {
        this.stavkaID = stavkaID;
        this.zaduzenje = zaduzenje;
        this.dodatnaBaterija = dodatnaBaterija;
        this.dodatnaSvetla = dodatnaSvetla;
        this.vrednost = vrednost;
        this.trotinet = trotinet;
    }

    public int getStavkaID() {
        return stavkaID;
    }

    public void setStavkaID(int stavkaID) {
        this.stavkaID = stavkaID;
    }
    
    public Zaduzenje getZaduzenje() {
        return zaduzenje;
    }

    public void setZaduzenje(Zaduzenje zaduzenje) {
        this.zaduzenje = zaduzenje;
    }

    public boolean isDodatnaBaterija() {
        return dodatnaBaterija;
    }

    public void setDodatnaBaterija(boolean dodatnaBaterija) {
        this.dodatnaBaterija = dodatnaBaterija;
    }

    public boolean isDodatnaSvetla() {
        return dodatnaSvetla;
    }

    public void setDodatnaSvetla(boolean dodatnaSvetla) {
        this.dodatnaSvetla = dodatnaSvetla;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public Trotinet getTrotinet() {
        return trotinet;
    }

    public void setTrotinet(Trotinet trotinet) {
        this.trotinet = trotinet;
    }

    @Override
    public String vratiImeTabele() {

        return "stavkaZaduzenja";
    }

    @Override
    public String vratiParametre() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s'", stavkaID, zaduzenje.getZaduzenjeID(), (int) (dodatnaBaterija? 1:0), (int) (dodatnaSvetla? 1:0), vrednost,  trotinet.getTrotinetID());
    }

    @Override
    public String vratiPK() {

        return null;
    }

    @Override
    public Integer vratiVrednostPK() {
        return null;
    }

    @Override
    public String vratiSlozenPK() {

        return String.format(" stavkaID='%s' AND zaduzenjeID='%s' ",  stavkaID, zaduzenje.getZaduzenjeID());
    }

    @Override
    public List<AbstractObject> RSuTabelu(ResultSet rs) {

           List<AbstractObject> stavke = new ArrayList<>();
        try {
            while (rs.next()) {
                int stavkaSifra = rs.getInt("stavkaID");
                int zaduznjeSifra = rs.getInt("zaduzenjeID");
                boolean baterija = rs.getBoolean("dodatnaBaterija");
                boolean svetla = rs.getBoolean("dodatnaSvetla");
                double cena = rs.getDouble("vrednost");
                int trotinetSifra = rs.getInt("trotinetID");
                Zaduzenje zad = new Zaduzenje(zaduznjeSifra);
                Trotinet trot = new Trotinet(trotinetSifra);
                stavke.add(new StavkaZaduzenja(stavkaSifra, zad, baterija, svetla, cena, trot));
            }
        } catch (SQLException ex) {
            System.out.println("Greska kod RSuTabelu za StavkaZaduzenja");
        }
        return stavke;
    }

    @Override
    public String vratiUpdate() {

        return String.format("stavkaID='%s',zaduzenjeID='%s', dodatnaBaterija='%s', dodatnaSvetla='%s', vrednost='%s', trotinetID='%s'", stavkaID, zaduzenje.getZaduzenjeID(), (int) (dodatnaBaterija? 1:0), (int) (dodatnaSvetla? 1:0), vrednost,  trotinet.getTrotinetID());
    }

    @Override
    public String vratiUslov() {
        return "zaduzenjeID";
    }

    @Override
    public void postaviVrednostPK(int stavkaID) {
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
        final StavkaZaduzenja other = (StavkaZaduzenja) obj;
        if (this.stavkaID != other.stavkaID) {
            return false;
        }
        if (!Objects.equals(this.zaduzenje, other.zaduzenje)) {
            return false;
        }
        return true;
    }
}
