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
            out.println("<title>Servlet login</title>");
            out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
            out.println("<script>function getContact(obj)   {alert(\"hey \"+obj+\"!!\");  window.location = \"Contacto?id=\"+obj+\"\";}</script>");
            out.println("</head>");
            out.println("<body>");
            String phone = "";
            if (miEjb.existeUsuario(nombre, password) != null) {
                out.println("<div class=\"row\">");
                out.println("<div class=\"jumbotron text-center\">");
                out.println("<h2>Agenda</h2>");
                out.println("<h5>Java project created in STUCOM -2017-</h5>");
                out.print("</div>");//JUMBOTRON
                out.print("<div class=\"container\">");
                out.print("<div class=\"row\">");
                out.print("<div class=\"col-md-4\">");
                out.print("<div class=\"row\">");
                out.println("<h3 class=\"text-center\">Bienvenido " + nombre + "</h3>");
                out.print("</div>");
                out.print("<br />");
                out.print("<div class=\"row text-center\">");
                out.println("<button onclick=\"window.location.href='newContact'\" class=\"btn btn-lg btn-primary\">Añadir usuario </button>");
                out.print("</div>");
                out.print("</div>");//COL1->Bienvenido LEFT
                out.print("<div class=\"col-md-offset-1 col-md-6\">");
                Usuario current = miEjb.existeUsuario(nombre, password);
                List<Contactos> contactosX = new ArrayList();
                out.println("<h3 class=\"text-center\">Lista de contactos</h3>");
                out.println("<div class=\"panel panel-default\">");
                contactosX.addAll(current.getContactosCollection());
                for (Contactos x : contactosX) {
                    if(x.getTmovil()== null){ phone = "none";} else{ phone = x.getTmovil(); }
                    out.println("<h4 style=\"margin-left:10px\">" + x.getApellidos()+ ", "+x.getNombre()+" <a href=\"mailto:"+x.getMail()+"\">"+x.getMail()+"</a> "+phone+" <form style=\"display:none\" id=\"form"+x.getId()+"\" method=\"post\" action=\"Contacto\"><input name=\"current\" value=\""+current.getNick()+"\"/><input name=\"id\" value=\""+x.getId()+"\"/></form><button class=\"btn btn-default\" type=\"submit\" form=\"form"+x.getId()+"\" value=\"Submit\">Ver contacto</button></h4>");
                }
                out.println("</div>");//PANEL-DEF->AGENDA
                out.print("</div>");//COL2->AGENDA RIGHT
                out.print("</div>");//CONTAINER
                out.print("</div>");//ROW1
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
