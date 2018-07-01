/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curso.java.servlets;

import edu.curso.java.javadb.GestorDePersonas;
import edu.curso.java.javadb.Persona;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class modificarPersona extends HttpServlet {

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
      
        GestorDePersonas gestorDePersonas = new GestorDePersonas();
       
         //parametro por url
        String id = request.getParameter("modId");
        String update = request.getParameter("update");
        
       Persona persona = new Persona();
       
        if (id !=null){
        
       
        persona = gestorDePersonas.buscarPersonaId(Long.parseLong(id));
        request.setAttribute("persona", persona );
      
        
       RequestDispatcher rd = request.getRequestDispatcher("resultado_formularioModificar.jsp");
        rd.forward(request, response);
        
        }else{
          
            if (update !=null){
                
             persona.setId( Long.parseLong(request.getParameter("id")));
             persona.setNombre(request.getParameter("nombre"));
             persona.setApellido(request.getParameter("apellido"));
             persona.setEdad(Integer.parseInt(request.getParameter("edad")));
             //new Date(new java.util.Date().getTime())  
             
            gestorDePersonas.actualizarPersona(persona);
            RequestDispatcher rd = request.getRequestDispatcher("listadoPersonasServlet");
            rd.forward(request,response);

         }
        }
    
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
