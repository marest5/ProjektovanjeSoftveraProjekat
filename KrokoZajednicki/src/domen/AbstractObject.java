/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author KOMP
 */
public abstract class AbstractObject implements Serializable{
    
        public abstract String vratiImeTabele();
    
        public abstract String vratiParametre();
    
        public abstract String vratiPK();
    
        public abstract Integer vratiVrednostPK();
    
        public abstract String vratiSlozenPK();
        
        public abstract String vratiUslov();
    
        public abstract List<AbstractObject> RSuTabelu(ResultSet rs);
    
        public abstract String vratiUpdate();
    
        public abstract void postaviVrednostPK(int pk);
        
}
