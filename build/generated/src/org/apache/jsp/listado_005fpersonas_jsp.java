package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import edu.curso.java.javadb.Persona;

public final class listado_005fpersonas_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template_superior.jsp", out, false);
      out.write("\n");
      out.write("<script>\n");
      out.write("   \n");
      out.write("    $(document).ready(function() {\n");
      out.write("        $.blockUI();\n");
      out.write("      \n");
      out.write("        peticionBuscar();\n");
      out.write("            \n");
      out.write("           \n");
      out.write("            $('#btn_buscar').on('click', function() {\n");
      out.write("                 peticionBuscar();\n");
      out.write("             });\n");
      out.write("\n");
      out.write("           $('#buscar_nom').keypress(function(e) {\n");
      out.write("             if (e.which == 13) {\n");
      out.write("                peticionBuscar();\n");
      out.write("             }\n");
      out.write("             });\n");
      out.write("           $('#buscar_ap').keypress(function(e) {\n");
      out.write("             if (e.which == 13) {\n");
      out.write("                peticionBuscar();\n");
      out.write("             }\n");
      out.write("             });\n");
      out.write("        \n");
      out.write("        function peticionBuscar() {\n");
      out.write("          var buscar_nom = $('#buscar_nom').val();\n");
      out.write("          var buscar_ap = $('#buscar_ap').val();\n");
      out.write("            $.post('listadoPersonasServlet', { buscar_nom : buscar_nom,buscar_ap : buscar_ap  }, function(resultado) {\n");
      out.write("                $('#resultadoAjax').html(resultado);\n");
      out.write("                 $.unblockUI(); \n");
      out.write("            });\n");
      out.write("        }\n");
      out.write("       \n");
      out.write("        \n");
      out.write("       \n");
      out.write("    });\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <h1>Listado de Personas</h1>\n");
      out.write("    <div class contenedorPrincipal>\n");
      out.write("    <div class=\"buscador\" >\n");
      out.write("   <div class=\"form-inline\" >   \n");
      out.write("    <div class=\"form-group\">\n");
      out.write("    <input type=\"text\" class=\"form-control\" name=\"buscar_nom\" id=\"buscar_nom\" value=\"\">\n");
      out.write("    </div>\n");
      out.write("     <div class=\"form-group\">\n");
      out.write("    <input type=\"text\" class=\"form-control\" name=\"buscar_ap\" id=\"buscar_ap\" value=\"\">\n");
      out.write("     </div>\n");
      out.write("    <div class=\"form-group\">\n");
      out.write("    <button type=\"button\" class=\"btn btn-success\" id=\"btn_buscar\" name=\"btn_buscar\">Buscar </button>\n");
      out.write("    </div>\n");
      out.write("   </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div id=\"resultadoAjax\"class=\"resultadoAjax\">\n");
      out.write("\n");
      out.write("    </div>\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template_inferior.jsp", out, false);
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
