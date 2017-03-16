/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Builder.ElfoBuilder;
import Builder.HumanoBuilder;
import Builder.MagoBuilder;
import Builder.Personaje;
import Builder.PersonajeDirector;
import Builder.TrolBuilder;
import Fabricas.FabricaElfo;
import Fabricas.FabricaHumano;
import Fabricas.FabricaMago;
import Fabricas.FabricaTrol;
import armasAtaque.ArmaAtaque;
import armasDefensa.ArmaDefensa;
import cuerpos.Cuerpo;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Daniel Mesa
 */
@WebServlet(name = "PersonajesController", urlPatterns = {"/PersonajesController"})
public class PersonajesController extends HttpServlet {
    
    PersonajeDirector director = new PersonajeDirector();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            String personaje=request.getParameter("personaje");
            System.out.println("personaje :"+personaje);
            out.println(llamarPersonaje(personaje));
        }
    }
    
     public String llamarPersonaje(String datos) 
     {
       String result="";
       Fabricas.FabricaPersonajes fabrica = null;
       Cuerpo cuerpo;
       ArmaAtaque armaA;
       ArmaDefensa armaD;
       
       switch (datos) {
            case "Humano":
                fabrica = new FabricaHumano();
                director.setPersonajeBuilder(new HumanoBuilder());
                break;
            case "Elfo":
                fabrica = new FabricaElfo();
                director.setPersonajeBuilder(new ElfoBuilder());
                break;
            case "Hechicero":
                fabrica = new FabricaMago();
                director.setPersonajeBuilder(new MagoBuilder());
                break;
           case "Enano":
                fabrica = new FabricaTrol();
                director.setPersonajeBuilder(new TrolBuilder());
                break;
        }
        
        director.construirPersonaje();
        cuerpo = fabrica.darCuerpo();
        armaA = fabrica.darArmaAtaque();
        armaD = fabrica.darArmaDefensa();
        Personaje per = director.getPersonaje();
        
        
        /*System.out.println(cuerpo.imagenCuerpo());
        System.out.println(armaA.imagenArmaAtaque());
        System.out.println(armaD.imagenArmaDefensa());*/
        System.out.println("Builder arma"+per.getArma());
        System.out.println("Builder Cuerpo"+per.getCuerpo());
        System.out.println("Builder Escudo"+per.getEscudo());
        
        StringBuilder str=new StringBuilder();
            str.append("[{");
            str.append("\"imageName\": \"imagenCuerpo\",");
            str.append("\"enlace\": \""+cuerpo.imagenCuerpo()+"\"");
            str.append("}, {");
            str.append("\"imageName\": \"imagenArmaAtaque\",");
            str.append("\"enlace\": \""+armaA.imagenArmaAtaque()+"\"");
            str.append("}, {");
            str.append("\"imageName\": \"imagenArmaDefensa\",");
            str.append("\"enlace\": \""+armaD.imagenArmaDefensa()+"\"");
            str.append("}]");
            
            System.out.println(str.toString());
       return str.toString();
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
