
<%@page import="edu.curso.java.javadb.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
  
    Persona persona = (Persona) request.getAttribute("persona");
    
    %>
    <script>
        $(document).ready(function(){
          
         
          $('.btn_update').on('click', function() {
          
             $.blockUI();
            
            peticionUpdate();
        });
        
          function peticionUpdate(){
              var update = "update";
              var id = $('#id').val();
              var nombre = $('#nombre').val();
              var apellido = $('#apellido').val();
              var edad = $('#edad').val();
              $.post('modificarPersona',{ update : update,id : id,nombre : nombre,apellido : apellido,edad:edad },function(resultado){
                 $('.contenedor').html(resultado);
                  $('.buscador').show();
                 $.unblockUI();
              });
         };
         
         $('#id').keypress(function(e){
             if (e.which == 13) {
              peticionUpdate();
                }
         });
         $('#nombre').keypress(function(e){
              if (e.which == 13) {
              peticionUpdate();
                } 
         });
         $('#apellido').keypress(function(e){
             if (e.which == 13) {
              peticionUpdate();
                }
         });
         $('#edad').keypress(function(e){
            if (e.which == 13) {
              peticionUpdate();
                }
         });
         $('#fecha_alta').keypress(function(e){
             if (e.which == 13) {
              peticionUpdate();
                }
         });
         
    });
        
        </script>
        
        <div class="contenedor">
	<label> id : </label>
	<input type="text" id="id" class="form-control" name="id" value ="<%= persona.getId()  %>">
	
        <label> Nombre : </label>
	<input type="text" id="nombre" class="form-control" name="nombre"value ="<%= persona.getNombre()%>">
	
        <label> Apellido : </label>
	<input type="text" id="apellido" class="form-control" name="apellido"value ="<%= persona.getApellido() %>">
	
        <label>Edad</label>
        <input type="text" id="edad" class="form-control" name="edad"value ="<%= persona.getEdad()%>">
        
        <label>Fecha Alta</label>
        <input type="text" id="fecha_alta" class="form-control" name="fecha_alta"value ="<%= persona.getFechaAlta()%>">
        
        <button name="update" class ="btn_update btn btn-success" type="button">Modificar</button>
        
        </div>
