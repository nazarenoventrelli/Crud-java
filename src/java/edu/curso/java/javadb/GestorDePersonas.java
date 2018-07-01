/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.curso.java.javadb;

import java.util.ArrayList;
import java.sql.*;



public class GestorDePersonas {
    
    private Connection recuperarConnection() throws Exception {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost/ejemplojdbc";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root", "");
    }
    
    public void altaPersona(Persona persona) {
        String sql = "INSERT INTO personas (nombre, apellido, edad, fecha_alta) VALUES  (?, ?, ?, ?)";
        Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
            preparedStatement.setInt(3, persona.getEdad());
            preparedStatement.setDate(4, new Date(new java.util.Date().getTime()));
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
    }
    
    public void actualizarPersona(Persona persona) {
      
    String sql = "update personas "
            + "set nombre = ?,"
            + "  apellido =?,"
            + " edad =?"
            + " where id=?;";
    
    //update personas set nombre="asd",apellido="asd",edad=0 where id=22;

         Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellido());
             preparedStatement.setInt(3, persona.getEdad());
            preparedStatement.setLong(4, persona.getId());
            preparedStatement.execute();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
    
    }
    
    public void borrarPersona(long id) {
        
        
        
         String sql ="delete from personas where id=?";
    
       //update clientes set apellido ='Fuentes' where nombre='Maria';
         Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
        
    }
    
    public ArrayList<Persona> recuperarPersonas() {
        ArrayList<Persona> personas = new ArrayList<>();
        
        String sql = "SELECT id, nombre, apellido, edad, fecha_alta FROM personas";
        Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next() == true) {
                Persona persona = new Persona();
                persona.setId(resultSet.getLong("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setEdad(resultSet.getInt("edad"));
                persona.setFechaAlta(resultSet.getDate("fecha_alta"));
                personas.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
        
        return personas;
    }
    
    public ArrayList<Persona> buscarPersona(String Nombre,String Apellido) {
        ArrayList<Persona> personas = new ArrayList<>();
        
         String sql = "SELECT id, nombre, apellido, edad, fecha_alta FROM personas where nombre = ? and apellido=?;";
        Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, Nombre);
            preparedStatement.setString(2, Apellido);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next() == true) {
                Persona persona = new Persona();
                persona.setId(resultSet.getLong("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setEdad(resultSet.getInt("edad"));
                persona.setFechaAlta(resultSet.getDate("fecha_alta"));
                personas.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
        
        return personas;
    }
    
    public ArrayList<Persona> buscarPersonas(String nombre,String apellido) {
        ArrayList<Persona> personas = new ArrayList<>();
        
        String sql = "SELECT id, nombre, apellido, edad, fecha_alta FROM personas " + 
                " where nombre like ? and apellido like ?";
        Connection connection = null;
        
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setString(1, "%" + nombre + "%");
            preparedStatement.setString(2, "%" + apellido + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next() == true) {
                Persona persona = new Persona();
                persona.setId(resultSet.getLong("id"));
                persona.setNombre(resultSet.getString("nombre"));
                persona.setApellido(resultSet.getString("apellido"));
                persona.setEdad(resultSet.getInt("edad"));
                persona.setFechaAlta(resultSet.getDate("fecha_alta"));
                personas.add(persona);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
        
        return personas;
    }
    
    public Persona buscarPersonaId(long id) {
      
        
        String sql = "SELECT id, nombre, apellido, edad, fecha_alta FROM personas where id = ?";
        Connection connection = null;
        Persona persona = new Persona();
        try {
            connection = this.recuperarConnection();
            PreparedStatement preparedStatement = connection.prepareCall(sql);
            preparedStatement.setLong(1, id);
        
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next() == true){
            persona.setId(id);
            persona.setNombre(resultSet.getString("nombre"));
            persona.setApellido(resultSet.getString("apellido"));
            persona.setEdad(resultSet.getInt("edad"));
            persona.setFechaAlta(resultSet.getDate("fecha_alta"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection!=null) 
                    connection.close();                
            } catch (Exception e) {}
        }
        
        return persona;
    }
    
}
