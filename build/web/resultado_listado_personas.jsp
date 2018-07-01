


<%@page import="java.util.ArrayList"%>
<%@page import="edu.curso.java.javadb.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList <Persona> personas;
    
    personas = (ArrayList<Persona>) request.getAttribute("personas");
   
    
    %>
    <script>
         $(document).ready(function() {
            
            $('.btn_modificar').on('click',function(){
                $.blockUI();
                var modId = $(this).attr('value');
                peticionModificar(modId);
                 $('.buscador').hide();
                 
            });
             
            $('.btn_borrar').on('click', function() {
                   $.blockUI();
                   var nro_boton = $(this).attr('value');
                   peticionBorrar(nro_boton);
                 
                });
                
                  function peticionModificar(modId){
                     
                      $.post('modificarPersona',{ modId : modId },function(resultado){
                          $('#resultadoAjax').html(resultado);
                          
                          $.unblockUI();
                      });
                      
                  }
                    
                  function peticionBorrar(nro_boton) {
                   
                    $.post('listadoPersonasServlet', { btn_borrar : nro_boton  }, function(resultado) {
                    $('#resultadoAjax').html(resultado);
                    $.unblockUI(); 
               });
           }
        });
        </script>
        
    <div class="form-inline">
        <table class="table table-bordered">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Edad</th>
			<th>Fecha alta</th>
                        <th>Modificar</th>
		</tr>
                                   
                <%  for (Persona p : personas)  {                     %>
		<tr>
			<td> <%= p.getId()  %></td>
			<td><%= p.getNombre()%></td>
			<td><%= p.getApellido()%></td>
			<td><%= p.getEdad()%></td>
			<td><%= p.getFechaAlta()%></td>
                        
                        <td> <button type="button" class="btn_borrar btn btn-danger" 
                       name="btn_borrar"  value="<%= p.getId()%>"
                                    >Borrar </button> 
                                   
                       <button type="button" value ="<%= p.getId()%>" class=" btn_modificar btn btn-success" >Modificar</a>

		</tr>    
                    <%  }  %>
	</table>
    </div>
    