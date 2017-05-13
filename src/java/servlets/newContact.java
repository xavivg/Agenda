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
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xaviv & Brian
 */
public class newContact extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Mi Agenda App</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\">");
            out.println("<link href=\"css/custom.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<META http-equiv='refresh' content='3;URL=myprofile.jsp'>");
            out.println("</head>");
            out.println("<body class=\"promo\">");

            // Recogemos los datos del formulario
            String name = request.getParameter("reg_name");
            String surname = request.getParameter("reg_surname");
            String mail = request.getParameter("reg_mail");
            String mobile = request.getParameter("reg_mobile");
            String house = request.getParameter("reg_house");
            String location = request.getParameter("reg_location");
            String nombre = request.getParameter("reg_user");
            String password = request.getParameter("reg_password");

            Usuario u = miEjb.getUserByNick(nombre);
            Contactos c = new Contactos(Integer.SIZE, name, surname, mail, house, mobile, location, u);

            if (miEjb.insertContact(c)) {
                u = miEjb.getUserByNick(nombre);
                request.getSession().setAttribute("usuario", u);
                out.println("<div class=\"start_descrition option animated fadeInDownBig\">");
                out.println("<h1>CONTACTO AÑADIDO<span></span></h1>");
                out.println("<span>" + name + " ha sido agregado a la lista de contactos de " + nombre + " redireccionando a la página principal...</span>");
                out.println("<div class=\"btns\">");
                out.println("</form>");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"bg\"></div>");
            } else {
                out.println("<div class=\"start_descrition option animated fadeInDownBig\">");
                out.println("<a href=\"#\" class=\"start_logo\"><h1>Error</h1></a>");
                out.println("<h1>CONTACTO NO AÑADIDO<span></span></h1>");
                out.println("<span>" + name + " no ha podido ser agregado a la lista de contactos de " + nombre + ", redireccionando a la página principal...</span>");
                out.println("<div class=\"btns\">");
                out.println("</div>");
                out.println("</div>");
                out.println("<div class=\"bg\"></div>");
            }
            out.println("<script src=\"https://code.jquery.com/jquery-3.2.1.min.js\"></script>");
            out.println("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"js/custom.js\" type=\"text/javascript\"></script>");
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
