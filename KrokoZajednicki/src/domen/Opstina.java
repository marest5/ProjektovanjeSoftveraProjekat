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
public class Opstina extends AbstractObject{
    private int postanskiBroj;
    private String naziv;

    public Opstina() {
    }

    public Opstina(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }
    
    public Opstina(int postanskiBroj, String naziv) {
        this.postanskiBroj = postanskiBroj;
        this.naziv = naziv;
    }


    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getpostanskiBroj() {
        return postanskiBroj;
    }

    public void setpostanskiBroj(int postanskiBroj) {
        this.postanskiBroj = postanskiBroj;
    }

     @Override
    public String toString() {
        return naziv;
    }

    @Override
    public String vratiImeTabele() {

        return "opstina";
        
    }

    @Override
    public String vratiParametre() {

        return String.format("'%s', '%s'", postanskiBroj, naziv);

    }

    @Override
    public String vratiPK() {

        return "postanskiBroj";
    }

    @Override
    public Integer vratiVrednostPK() {


        return postanskiBroj;
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

        List<AbstractObject> opstine = new ArrayList<>();
        try {
            while (rs.next()) {
                int postanskiBrojOpstine = rs.getInt("postanskiBroj");
                String nazivOpstine = rs.getString("naziv");
                
                Opstina o = new Opstina(postanskiBrojOpstine, nazivOpstine);
              
                opstine.add(o);
            }
        } catch (SQLException ex) {
            System.out.println("Greska u Opstina.Class ResultSet-u");
        }
        return opstine;
        
    }

    @Override
    public String vratiUpdate() {

         return String.format("postanskiBroj='%s', naziv='%s'", postanskiBroj, naziv);
    }

    @Override
    public void postaviVrednostPK(int postanskiBroj) {

        this.postanskiBroj = postanskiBroj;
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
        final Opstina other = (Opstina) obj;
        if (this.postanskiBroj != other.postanskiBroj) {
            return false;
        }
        return true;
    }

}
