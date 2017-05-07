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
public class Contacto extends HttpServlet {
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
            int id = Integer.parseInt(request.getParameter("id"));
            String current = request.getParameter("current");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Contacto</title>");
            out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
            out.println("</head>");
            out.println("<body>");
             if (miEjb.existeContacto(id, current) != null) {
               Contactos contacto = miEjb.existeContacto(id, current);        
               
                out.println("<div class=\"row\">");
                out.println("<div class=\"jumbotron text-center\">");
                out.println("<h2>Agenda</h2>");
                out.println("<h5>Java project created in STUCOM -2017-</h5>");
                out.print("</div>");//JUMBOTRON
                out.print("<div class=\"container\">");
                out.print("<div class=\"row\">");
                out.print("<div class=\"col-md-2\">");
                out.println("<h4 class=\"text-center\">Contact ID: " + id + "</h4>");
                out.print("</div>");//COL1->Bienvenido LEFT
                out.println("</div>");//ROW1->IDCONTACT
                out.print("<div class=\"row\">");
                out.print("<div class=\"col-md-12\">");
                out.println("<div class=\"row\">");
                out.println("<h3 class=\"text-center\">Editar "+contacto.getNombre()+"</h3>");
                out.println("</div>");
                out.println("<form method=\"post\" id=\"form1\" action=\"updateContact\">");//ponle action al form o no vas a hacer nada :)
                out.println("<div class=\"row\">");
                out.println("<br/>");         
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"nombre\">Nombre: </label>");
                out.println("<input type=\"text\" value="+contacto.getNombre()+" id=\"nombre\" name=\"nombre\">");
                out.println("</div>");//COL3
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"apellidos\">Apellidos: </label>");
                out.println("<input type=\"text\" value="+contacto.getApellidos()+" id=\"apellidos\" name=\"apellidos\">");
                out.println("</div>");//COL3
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"mail\">Mail: </label>");
                out.println("<input type=\"mail\" value="+contacto.getMail()+" id=\"mail\" name=\"mail\">");
                out.println("</div>");//COL3
                out.println("</div>");//CLOSE-ROW1-FORM
                out.println("<div class=\"row\">");
                out.println("<br/>");         
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"tfijo\">Telf. fijo: </label>");
                out.println("<input type=\"number\" value="+contacto.getTfijo()+" id=\"tfijo\" name=\"tfijo\">");
                out.println("</div>");//COL3
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"tmovil\">Telf. móvil: </label>");
                out.println("<input type=\"number\" value="+contacto.getTmovil()+" id=\"tmovil\" name=\"tmovil\">");
                out.println("</div>");//COL3
                out.println("<div class=\"col-md-3 col-md-offset-1\">");
                out.println("<label for=\"direccion\">Dirección: </label>");
                out.println("<input type=\"text\" value="+contacto.getDireccion()+" id=\"direccion\" name=\"direccion\">");
                out.println("<input style=\"display:none\" type=\"number\" value="+id+" id=\"id\" name=\"id\">");//SPECIAL INPUTS TO THROUGH THE CURRENT USER LOGED & CONTACTID
                out.println("<input style=\"display:none\" type=\"text\" value="+current+" id=\"current\" name=\"current\">");
                out.println("</div>");//COL3
                out.println("</div>");//CLOSE-ROW2-FORM
                out.println("");
                out.println("");
                out.println("<br/>");
                out.println("<div class=\"col-md-4 col-md-offset-6\">");
                out.println("<label for=\"password\">Contraseña: </label>");
                out.println("<input type=\"password\" placeholder=\"Introduce tu contraseña\" id=\"password\" name=\"password\" required>");
                out.println("</div>");//COL3
                out.println("</form>");//ROW1->FORM
                //pillo sitio Buttons
                out.println("<div class=\"row\">");
                out.println("<div class=\"pull-right\">");
                
                out.println("<button type=\"submit\" form=\"form1\" class=\"btn btn-primary\">Update</button>");
                out.println("<button type=\"submit\" form=\"form1\" class=\"btn btn-danger\" formaction=\"deleteContact\">Delete</button>");
                out.println("</div>");//COL12 BUTTONS
                out.println("</div>");//ROW BUTTONS
                out.print("</div>");//CONTAINER
                out.print("</div>");//ROW1
                out.print("</div>");//CONTAINER
                out.print("</div>");//ROW1
                
            }
            else{
                 out.println("<p>Error, no existe este contacto en tu lista</p>");
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
