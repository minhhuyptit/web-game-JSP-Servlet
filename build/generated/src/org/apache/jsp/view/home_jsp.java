package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import snow.model.Category;
import snow.dao.CategoryDAO;
import snow.model.Advertising;
import snow.dao.AdvertisingDAO;
import snow.tool.Helper;
import snow.model.Game;
import java.util.ArrayList;
import snow.dao.GameDAO;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

    GameDAO gameDAO = new GameDAO();
    AdvertisingDAO advertisingDAO = new AdvertisingDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    ArrayList<Game> listGameHot = gameDAO.getListGameHot();
    ArrayList<Game> listGameChoiNhieuNhat = gameDAO.getListGameChoiNhieuNhat();
    ArrayList<Game> listGameYeuThichNhat = gameDAO.getListGameYeuThichNhat();

      out.write("\n");
      out.write("<section class=\"content-left\">\n");
      out.write("    <section class=\"game-hot\">\n");
      out.write("        <section class=\"slider\">\n");
      out.write("            <div id=\"wowslider-container1\">\n");
      out.write("                <div class=\"ws_images\">\n");
      out.write("                    <ul>\n");
      out.write("                        ");
 for (int i = 0; i < 5; i++) {
      out.write("\n");
      out.write("                        <li><a href=\"playgame.jsp?id=");
      out.print( listGameHot.get(i).getGameID());
      out.write("\" target=\"_self\">\n");
      out.write("                                <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/games/img/");
      out.print( listGameHot.get(i).getGameImage());
      out.write("\" \n");
      out.write("                                     alt=\"");
      out.print( listGameHot.get(i).getGameName());
      out.write("\" title=\"");
      out.print( listGameHot.get(i).getGameName());
      out.write("\" />\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"ws_bullets\">\n");
      out.write("                    <div>\n");
      out.write("                        ");
 for (int i = 0; i < 5; i++) {
      out.write("\n");
      out.write("                        <a href=\"#\" title=\"");
      out.print( listGameHot.get(i).getGameName());
      out.write('"');
      out.write('>');
      out.print( (i + 1));
      out.write("</a>\n");
      out.write("                        ");
 }
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </section>\n");
      out.write("        <aside class=\"sidebar\">\n");
      out.write("            <header class=\"title-gamehot\">Game hay</header>\n");
      out.write("            <section class=\"content-gamehot\">\n");
      out.write("                ");

                    int count_1 = 0;
                    for (int i = 5; i < 11; i++) {
                        count_1++;
                        String className = (count_1 % 3 == 0) ? "box-gamehot-last" : "box-gamehot";
                
      out.write("\n");
      out.write("                <article class=\"");
      out.print( className);
      out.write("\">\n");
      out.write("                    <a href=\"playgame.jsp?id=");
      out.print( listGameHot.get(i).getGameID());
      out.write("\">\n");
      out.write("                        <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/games/img/");
      out.print( listGameHot.get(i).getGameImage());
      out.write("\" \n");
      out.write("                             alt=\"");
      out.print( listGameHot.get(i).getGameName());
      out.write("\"></a>\n");
      out.write("                    <h3><a href=\"playgame.jsp?id=");
      out.print( listGameHot.get(i).getGameID());
      out.write('"');
      out.write('>');
      out.print( listGameHot.get(i).getGameName());
      out.write("</a></h3>\n");
      out.write("                </article>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </section>\n");
      out.write("        </aside>\n");
      out.write("    </section>\n");
      out.write("    ");
 for (Category itemMaster : categoryDAO.getListCategoryByAmount(5)) {
      out.write("\n");
      out.write("    <section class=\"theloai-game\">\n");
      out.write("        <header><a href=\"theloaigame.jsp?id=");
      out.print( itemMaster.getCategoryID());
      out.write('"');
      out.write('>');
      out.print( itemMaster.getCategoryName());
      out.write("</a></header>\n");
      out.write("        <p class=\"xthem\">\n");
      out.write("            <a href=\"theloaigame.jsp?id=");
      out.print( itemMaster.getCategoryID());
      out.write("\">\n");
      out.write("                <input name=\"xemthem\" type=\"button\" value=\"Xem Thêm &gt;&gt;\">\n");
      out.write("            </a></p>\n");
      out.write("            ");
 for (Game item : gameDAO.getListGameDetail(itemMaster.getCategoryID())) {
      out.write("\n");
      out.write("        <article class=\"game-theloai-game\">\n");
      out.write("            <a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\">\n");
      out.write("                <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/games/img/");
      out.print( item.getGameImage());
      out.write("\" \n");
      out.write("                     alt=\"");
      out.print( item.getGameName());
      out.write("\">\n");
      out.write("            </a>\n");
      out.write("            <h3><a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\">\n");
      out.write("                    ");
      out.print( Helper.cutString(item.getGameName(), 20));
      out.write("\n");
      out.write("                </a>\n");
      out.write("            </h3>\n");
      out.write("        </article>\n");
      out.write("        ");
 } 
      out.write("\n");
      out.write("        <div class=\"overflow\"></div>\n");
      out.write("    </section>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("</section>\n");
      out.write("<aside class=\"content-right\">\n");
      out.write("    <section class=\"quangcao\">\n");
      out.write("        ");
 for (Advertising item : advertisingDAO.getListAds(2)) {
      out.write("\n");
      out.write("        <a href=\"");
      out.print( item.getAdsURL());
      out.write("\" target=\"");
      out.print( item.getAdsTarget());
      out.write("\"> \n");
      out.write("            <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/images/quangcao/");
      out.print( item.getAdsFile());
      out.write("\" alt=\"");
      out.print( item.getAdsTitle());
      out.write("\"></a>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("    </section>\n");
      out.write("    <section class=\"game-choinhieunhat\">\n");
      out.write("        <header class=\"title-game-choinhieunhat\">Game chơi nhiều nhất</header>\n");
      out.write("        <section class=\"content-game-choinhieunhat\">\n");
      out.write("            ");

                int count_2 = 0;
                int size_2 = listGameChoiNhieuNhat.size();
                for (Game item : listGameChoiNhieuNhat) {
                    count_2++;
                    String className = (count_2 % size_2 == 0) ? "box-game-choinhieunhat-last" : "box-game-choinhieunhat";
            
      out.write("\n");
      out.write("            <article class=\"");
      out.print( className);
      out.write("\">\n");
      out.write("                <a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\">\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/games/img/");
      out.print( item.getGameImage());
      out.write("\" \n");
      out.write("                         alt=\"");
      out.print( item.getGameName());
      out.write("\"></a>\n");
      out.write("                <section>\n");
      out.write("                    <a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\"><h5>");
      out.print( Helper.cutString(item.getGameName(), 20));
      out.write("</h5></a>\n");
      out.write("                    <p>Lượt chơi: ");
      out.print( Helper.formatNumber(item.getGameLuotChoi()));
      out.write("</p>\n");
      out.write("                </section> \n");
      out.write("            </article> \n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </section>\n");
      out.write("    </section>\n");
      out.write("    <section class=\"game-choinhieunhat\">\n");
      out.write("        <header class=\"title-game-choinhieunhat\">Game yêu thích nhiều nhất</header>\n");
      out.write("        <section class=\"content-game-choinhieunhat\">\n");
      out.write("            ");

                int count_3 = 0;
                int size_3 = listGameYeuThichNhat.size();
                for (Game item : listGameYeuThichNhat) {
                    count_3++;
                    String className = (count_3 % size_3 == 0) ? "box-game-choinhieunhat-last" : "box-game-choinhieunhat";
            
      out.write("\n");
      out.write("            <article class=\"");
      out.print( className);
      out.write("\">\n");
      out.write("                <a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\">\n");
      out.write("                    <img src=\"");
      out.print( request.getContextPath());
      out.write("/template/games/img/");
      out.print( item.getGameImage());
      out.write("\" \n");
      out.write("                         alt=\"");
      out.print( item.getGameName());
      out.write("\"></a>\n");
      out.write("                <section>\n");
      out.write("                    <a href=\"playgame.jsp?id=");
      out.print( item.getGameID());
      out.write("\"><h5>");
      out.print( Helper.cutString(item.getGameName(), 20));
      out.write("</h5></a>\n");
      out.write("                    <p>Lượt yêu thích: ");
      out.print( Helper.formatNumber(item.getGameLuotYeuThich()));
      out.write("</p>\n");
      out.write("                </section>\n");
      out.write("            </article>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("        </section>\n");
      out.write("    </section>\n");
      out.write("</aside>\n");
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
