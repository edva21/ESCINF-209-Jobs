package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EmpresaLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/Header.jsp");
  }

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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/master.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>    \n");
      out.write("        <title>EmpresaLogin</title>    \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/master.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">  \n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\" >\n");
      out.write("            <div id=\"banner\"\n");
      out.write("                 background-image:<img src=\"images/imag1.jpg\" alt=\"\"> \n");
      out.write("             </div>\n");
      out.write("            <div class=\"banner\"><a href=\"main \" style=\"color:#ffffff\"><H1></H1>\n");
      out.write("                <H1>Tico </H1>\n");
      out.write("                <H1>Empleos</H1></a>\n");
      out.write("             </div>\n");
      out.write("            <div class=\"menus\">\n");
      out.write("            <ul class=\"menu\">\n");
      out.write("                <li><a href=\"OfferentLogin.jsp\">ACCESO OFERENTE </a></li>\n");
      out.write("                <li><a href=\"EmpresaLogin.jsp\">ACCESO EMPRESA </a></li>\n");
      out.write("                <li><a href=\"EmpresaLogin.jsp\">ACCESO ALMINISTRADOR </a></li>\n");
      out.write("            </ul>      \n");
      out.write("        </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <script>     \n");
      out.write("        </script> \n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1>Hello World!</h1>\n");
      out.write("        <div id=\"body\" style=\"margin: 0 auto; width:85%; \">\n");
      out.write("            <div id=\"formularioDiv\" style=\"display: block;vertical-align:top;\">\n");
      out.write("                <form method=\"POST\" name=\"formulario\" id=\"formulario\" action=\"javascript:login();\">\n");
      out.write("                <table border=0 cellpadding=3 cellspacing=4 >\n");
      out.write("\t\t   <tr><td colspan=\"2\" class=\"titulo\">Cuenta Empresarial</td></tr>\n");
      out.write("\t\t   <tr><td class=\"etiqueta\">Correo</td><td><input type=\"text\" name=\"correo\" id=\"correo\"></td></tr>\n");
      out.write("\t\t   <tr><td class=\"etiqueta\">Nombre</td><td><input type=\"password\" name=\"clave\" id=\"clave\"></td></tr>\n");
      out.write("                    <tr><td class=\"titulo\" colspan=\"2\"><input class=\"boton\" type=\"submit\" value=\"Login\"></td></tr>\t   \n");
      out.write("                    </table>\n");
      out.write("                </form>\n");
      out.write("            </div>     \n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            \n");
      out.write("            function login(empresaEmail,empresaClave){\n");
      out.write("                empresa = {empresaEmail:empresaEmail, empresaClave:empresaClave};\n");
      out.write("                \n");
      out.write("                 $.ajax({type: \"POST\", \n");
      out.write("                  url:\"EmpresaLogin\", \n");
      out.write("                  data: JSON.stringify(empresa), \n");
      out.write("                  dataType:\"json\",\n");
      out.write("                  success: \n");
      out.write("                    function(obj){\n");
      out.write("                        show(obj); \n");
      out.write("                    },\n");
      out.write("                  error: function(status){\n");
      out.write("                         window.alert(\"Error\");\n");
      out.write("                    }                    \n");
      out.write("                });   \n");
      out.write("                 \n");
      out.write("            }\n");
      out.write("        function show(per){\n");
      out.write("\twindow.alert(\"si\");\n");
      out.write("        }     \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
