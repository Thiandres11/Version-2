    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Daniel Mesa
 */
public abstract class PersonajeBuilder {
    protected Personaje personaje;

    public Personaje getPersonaje() {
        return personaje;
    }
     public void crearPersonaje(){
         personaje = new Personaje();
         
     }
    public abstract void buildArma();
    public abstract void buildEscudo();
    public abstract void buildCuerpo();
}
