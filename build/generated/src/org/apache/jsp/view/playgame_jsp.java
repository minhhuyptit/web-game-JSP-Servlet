package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class playgame_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath());
      out.write("/template/css/style.css\">\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print( request.getContextPath());
      out.write("/template/wowslider/jquery.js\"></script>\n");
      out.write("        <link rel=\"stylesheet prefetch\" href=\"https://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css\" />\n");
      out.write("        <title>Document</title>\n");
      out.write("        <script type=\"text/javascript\" src=\"");
      out.print( request.getContextPath() );
      out.write("/template/js/custom.js\"></script>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var paramID = GetURLParameter('id');\n");
      out.write("            if (paramID === '' || paramID === false) {\n");
      out.write("                window.location = \"404.html\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                //Phần Ajax Rating\n");
      out.write("                var count = 0;\n");
      out.write("                var id_game = GetURLParameter('id');\n");
      out.write("                $(\"#star\").click(function () {\n");
      out.write("                    count++;\n");
      out.write("                    $.post('");
      out.print( request.getContextPath());
      out.write("/RatingServlet', {'count': count, 'id_game': id_game}, function(data){\n");
      out.write("                        console.log(data);\n");
      out.write("                        $(\"#luotyeuthich\").html(data);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                //Phần phóng to thu nhỏ\n");
      out.write("                var count_1 = 0;\n");
      out.write("                $(\"#fullscreen\").click(function(){\n");
      out.write("                    count_1++;\n");
      out.write("                    if(count_1 % 2 == 1){\n");
      out.write("                        $('aside.content-right').hide();\n");
      out.write("                        $('section.wrapper').attr('style','width:80%');\n");
      out.write("                        $('section.content-left').attr('style','width:100%');\n");
      out.write("                        $('section.box-playgame object').attr('style','height:700px');                       \n");
      out.write("                    }else{\n");
      out.write("                        $('aside.content-right').show();\n");
      out.write("                        $('section.wrapper').removeAttr('style');\n");
      out.write("                        $('section.content-left').removeAttr('style');\n");
      out.write("                        $('section.box-playgame object').removeAttr('style');\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                //Phần Ajax Load Game\n");
      out.write("                var startAtQuantity  = 8;\n");
      out.write("                var jumpStep        = 12;\n");
      out.write("                var position        = startAtQuantity;\n");
      out.write("                $(\"section.list-game\").load(\"");
      out.print( request.getContextPath());
      out.write("/LoadGameServlet?id=\" + id_game + \"&position=0&item=\" + startAtQuantity);\n");
      out.write("                \n");
      out.write("                $(\"button.box-game-xemthem\").click(function(){\n");
      out.write("                    $.get(\"");
      out.print( request.getContextPath());
      out.write("/LoadGameServlet\", {'id': id_game, 'position': position, 'item': jumpStep}, function(data){\n");
      out.write("                        if(data.length > 0){\n");
      out.write("                            $(\"section.list-game .box-game-last:last\").after(data);\n");
      out.write("                        }else{\n");
      out.write("                            $(\"button.box-game-xemthem\").remove();\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                    position += jumpStep;\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("            <!-- Start Wrapper  -->\n");
      out.write("            <section class=\"wrapper\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "inc_playgame.jsp", out, false);
      out.write("\n");
      out.write("            </section>\n");
      out.write("            <!-- End Wrapper -->\n");
      out.write("\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
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
