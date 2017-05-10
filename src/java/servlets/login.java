/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.AgendaEJB;
import entities.Contactos;
import entities.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xaviv
 */
public class login extends HttpServlet {

    @EJB
    AgendaEJB miEjb;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("nombre");
            String password = request.getParameter("password");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mi Agenda APP</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">");
            out.println("<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<script>function getContact(obj)   {alert(\"hey \"+obj+\"!!\");  window.location = \"Contacto?id=\"+obj+\"\";}</script>");
            out.println("</head>");
            out.println("<body>");
            String phone = "";
            if (miEjb.existeUsuario(nombre, password) != null) {
                Usuario current = miEjb.existeUsuario(nombre, password);
                List<Contactos> contactosX = new ArrayList();
                contactosX.addAll(current.getContactosCollection());
                int s = contactosX.size();
                out.println("<div class=\"menu-btn\" onclick=\"changeClass()\">☰</div>");
                out.println("<nav class=\"pushy\" id=\"pushy-left\">");
                out.println("<div class=\"profile\">");
                out.println("<div class=\"avatar\">");
                out.println("<img src=\"img/no-profile.jpg\" alt=\"\"/>");
                out.println("<span>"+s+"</span>");
                out.println("</div>");
                out.println("<h3>");
                out.println("<a href=\"#\">"+ nombre +"</a>");
                out.println("</h3>");
                out.println("<a class=\"log_btn\" href=\"index.html\">Log Out</a>");
                out.println("</div>");                
                out.println("</nav>");
                out.println("<div class=\"add_place\" id=\"pl\">");
                out.println("<div class=\"place_form\">");
                out.println("<i class=\"fa fa-times close_window\" id=\"close\"></i>");
                out.println("<h3>Nuevo Contacto<span></span></h3>");
                out.println("<form action='newContact' method=\"POST\">");
                out.println("<label>Nombre:<input type=\"text\" name=\"reg_name\"></label>");
                out.println("<label>Apellido:<input type=\"text\" name=\"reg_surname\"></label>");
                out.println("<label>Mail:<input type=\"text\" name=\"reg_mail\"></label>");
                out.println("<label>Móvil:<input type=\"text\" name=\"reg_mobile\"></label>");
                out.println("<label>Casa:<input type=\"text\" name=\"reg_house\"></label>");
                out.println("<label>Dirección:<input type=\"text\" name=\"reg_location\"></label>  ");
                out.println("<input type='hidden' name='reg_user' value='"+nombre+"'>");
                out.println("<input type='hidden' name='reg_password' value='"+password+"'>");
                out.println("<button type=\"submit\" class=\"green_btn_header\" id=\"add\">Añadir</button>");
                out.println("</form>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"container contant\">");
                out.println("<div class=\"row\">");
                out.println("<div class=\"col-md-12 basic\">");
                out.println("<div class=\"head\">");
                out.println("<a href=\"index.html\" class=\"logo\"><h1>Mi Agenda</h1></a>");
                out.println("<a href=\"#\" class=\"green_btn_header\" id=\"addContact\">");
                out.println("<i class=\"fa fa-plus\"></i>");
                out.println("</a>");
                out.println("</div>");
                out.println("<div class=\"contactos\">");
                out.println("<h4>"+s+" contactos</h4>");
                for (Contactos x : contactosX) {
                    if(x.getTmovil()== null){ phone = "none";} else{ phone = x.getTmovil(); }
                out.println("<div class=\"contacto\">");
                out.println("<div class=\"user\">");
                out.println("<a class=\"user_avatars\" href=\"Contacto?id="+x.getId()+"&current="+current.getNick()+"\">");
                out.println("<div class=\"user_go\">");
                out.println("<i class=\"fa fa-link\"></i>");
                out.println("</div>");
                out.println("<img src=\"img/no-profile.jpg\" alt=\"\"/>");
                out.println("</a>");
                out.println("</div>");
                out.println("<div class=\"info\">");
                out.println("<div class=\"head_contact\">");
                out.println("<a href=\"Contacto?id="+x.getId()+"&current="+current.getNick()+"\">"+x.getNombre()+" "+x.getApellidos()+"</a>");
                out.println("<span>"+x.getTmovil()+"</span>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                }
                out.println("</div>");
                out.println("<a class=\"more_btn\" href=\"#\">Mostras más</a>");
                out.println("</div>");
                out.println("</div>");
                out.println("</div>");
                out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>");
                out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
                out.println("<script src=\"js/custom.js\" type=\"text/javascript\"></script>");
                
            } else {
                out.println("<p>Error, no existe este usuario</p>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
