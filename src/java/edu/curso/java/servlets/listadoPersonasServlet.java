/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curso.java.servlets;

import edu.curso.java.javadb.GestorDePersonas;
import edu.curso.java.javadb.Persona;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class listadoPersonasServlet extends HttpServlet {

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
       
        String btn_borrar = request.getParameter("btn_borrar");
        String buscar_nom = request.getParameter("buscar_nom");
        String buscar_ap = request.getParameter("buscar_ap");
       
        ArrayList<Persona> personas; 
        
        if (btn_borrar !=null){
       
        long long_borrar = Long.parseLong(btn_borrar);
       
        gestorDePersonas.borrarPersona(long_borrar);
        
       }
       
        if ((buscar_nom !=null) || (buscar_ap !=null)){
         
            personas = gestorDePersonas.buscarPersonas(buscar_nom, buscar_ap);

       }else{
            personas = gestorDePersonas.recuperarPersonas();

        }
        
             
         
    
     
             
       
       request.setAttribute("personas", personas);
       
       RequestDispatcher rd = request.getRequestDispatcher("resultado_listado_personas.jsp");
       rd.forward(request,response);


       
       
        
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
