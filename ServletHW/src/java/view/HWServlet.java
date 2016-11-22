/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import data.Names;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author danecek
 */
@WebServlet(name = "HWServlet", urlPatterns = {"/"})
public class HWServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HWServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='1'>");
            out.println("<thead>");
            out.println(" <tr>");
            out.println(" <th>Names</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (String name : Names.inst.allNames()) {
                out.println(" <tr>");
                out.println("   <td>" + name + "</td>");
                out.println(" </tr>");
            }

            out.println(" </tbody>");
            out.println("</table>");
            out.println("<form action='/ServletHW/add.do' method='POST'>");
            out.println("  <input type='text' name='name' />");
            out.println(" <input type='submit' value='Submit' />");
            out.println("</form>");

            out.println("<form action='/ServletHW/deleteall.do' method='POST'>");
            out.println(" <input type='submit' value='Delete all' />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
