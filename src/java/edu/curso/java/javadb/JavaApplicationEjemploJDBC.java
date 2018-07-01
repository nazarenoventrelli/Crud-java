/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curso.java.javadb;

import java.util.ArrayList;


public class JavaApplicationEjemploJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        Persona persona = new Persona();
        /*
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setEdad(34);
        persona.setId(27);
        persona.setNombre("nombre_modificado");
         */
        GestorDePersonas gestorDePersonas = new  GestorDePersonas();
        /*
        gestorDePersonas.altaPersona(persona);
        gestorDePersonas.actualizarPersona(persona);
        
        long id = 3;
        gestorDePersonas.borrarPersona(id);
        */
        
        persona = gestorDePersonas.buscarPersonaId(9);
        System.out.println("Id: " + persona.getId());
        System.out.println(": " + persona.getNombre());
        System.out.println(": " + persona.getApellido());
        System.out.println(": " + persona.getFechaAlta());
        System.out.println(": " + persona.getEdad());
        /*
       ArrayList<Persona> personas = gestorDePersonas.recuperarPersonas("", "");
        
        
        for (Persona p : personas) {
            System.out.println("Id: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
        }
        */
        
    }
    
}
