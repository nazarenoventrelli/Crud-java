

<%@page import="java.util.ArrayList"%>
<%@page import="edu.curso.java.javadb.Persona"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="template_superior.jsp"></jsp:include>
<script>
   
    $(document).ready(function() {
        $.blockUI();
      
        peticionBuscar();
            
           
            $('#btn_buscar').on('click', function() {
                 peticionBuscar();
             });

           $('#buscar_nom').keypress(function(e) {
             if (e.which == 13) {
                peticionBuscar();
             }
             });
           $('#buscar_ap').keypress(function(e) {
             if (e.which == 13) {
                peticionBuscar();
             }
             });
        
        function peticionBuscar() {
          var buscar_nom = $('#buscar_nom').val();
          var buscar_ap = $('#buscar_ap').val();
            $.post('listadoPersonasServlet', { buscar_nom : buscar_nom,buscar_ap : buscar_ap  }, function(resultado) {
                $('#resultadoAjax').html(resultado);
                 $.unblockUI(); 
            });
        }
       
        
       
    });
</script>


    <h1>Listado de Personas</h1>
    <div class contenedorPrincipal>
    <div class="buscador" >
   <div class="form-inline" >   
    <div class="form-group">
    <input type="text" class="form-control" name="buscar_nom" id="buscar_nom" value="">
    </div>
     <div class="form-group">
    <input type="text" class="form-control" name="buscar_ap" id="buscar_ap" value="">
     </div>
    <div class="form-group">
    <button type="button" class="btn btn-success" id="btn_buscar" name="btn_buscar">Buscar </button>
    </div>
   </div>
    </div>


    <div id="resultadoAjax"class="resultadoAjax">

    </div>
<jsp:include page="template_inferior.jsp"></jsp:include>