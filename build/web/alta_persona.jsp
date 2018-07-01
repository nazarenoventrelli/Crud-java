<jsp:include page="template_superior.jsp"></jsp:include>
            
            <form method="post" action="AltaPersonaServlet">
                   <h1 id="tituloForm">Formulario de inscripción</h1>
                <div class="formularioAlta">
                    <div class="inputs">
                <div class="form-group">
                    <label>Nombre:</label>
                    <input type="text" class="form-control" name="nombre">
                </div>
                <div class="form-group">
                    <label>Apellido</label>
                    <input type="text" class="form-control" name="apellido">
                </div>
                <div class="form-group">
                    <label>Edad</label>
                    <input type="text" class="form-control" name="edad">
                </div>
          
                <button type="submit" id="btnAlta" class="btn btn-primary">Enviar datos</button>
                    </div>
                    </div>

            </form>

<jsp:include page="template_inferior.jsp"></jsp:include>