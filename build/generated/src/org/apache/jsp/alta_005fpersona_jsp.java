package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class alta_005fpersona_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "template_superior.jsp", out, false);
      out.write("\n");
      out.write("            \n");
      out.write("            <form method=\"post\" action=\"AltaPersonaServlet\">\n");
      out.write("                   <h1 id=\"tituloForm\">Formulario de inscripción</h1>\n");
      out.write("                <div class=\"formularioAlta\">\n");
      out.write("                    <div class=\"inputs\">\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Nombre:</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"nombre\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Apellido</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"apellido\">\n");
      out.write("                </div>\n");
      out.write("                <div class=\"form-group\">\n");
      out.write("                    <label>Edad</label>\n");
      out.write("                    <input type=\"text\" class=\"form-control\" name=\"edad\">\n");
      out.write("                </div>\n");
      out.write("          \n");
      out.write("                <button type=\"submit\" id=\"btnAlta\" class=\"btn btn-primary\">Enviar datos</button>\n");
      out.write("                    </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("\n");
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
