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
public class PersonajeDirector {

    private PersonajeBuilder personajeBuilder;

    public void construirPersonaje() {
        personajeBuilder.crearPersonaje();
        personajeBuilder.buildArma();
        personajeBuilder.buildEscudo();
        personajeBuilder.buildCuerpo();
    }

    public void setPersonajeBuilder(PersonajeBuilder pb) {
        personajeBuilder = pb;
    }

    public Personaje getPersonaje() {
        return personajeBuilder.getPersonaje();
    }

}
