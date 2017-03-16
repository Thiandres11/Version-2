/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import armasAtaque.ArmaAtaque;
import armasDefensa.ArmaDefensa;
import cuerpos.Cuerpo;

/**
 *
 * @author Daniel Mesa
 */
public class Personaje {
    private ArmaAtaque arma;
    private ArmaDefensa escudo;
    private Cuerpo cuerpo;

    public ArmaAtaque getArma() {
        return arma;
    }

    public void setArma(ArmaAtaque arma) {
        this.arma = arma;
    }

    public ArmaDefensa getEscudo() {
        return escudo;
    }

    public void setEscudo(ArmaDefensa escudo) {
        this.escudo = escudo;
    }

    public Cuerpo getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(Cuerpo cuerpo) {
        this.cuerpo = cuerpo;
    }
    
    
}
