/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;


import Fabricas.FabricaPersonajes;
import Fabricas.FabricaTrol;

/**
 *
 * @author Daniel Mesa
 */
public class TrolBuilder extends PersonajeBuilder {

   FabricaPersonajes F = new FabricaTrol();
   
    public void buildArma(){
        personaje.setArma(F.darArmaAtaque());
    }
    
     public void buildEscudo() {
        personaje.setEscudo(F.darArmaDefensa());
    }
     
    public void buildCuerpo() {
        personaje.setCuerpo(F.darCuerpo());
   
 
}
}

