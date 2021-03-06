/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAOException;
import model.DegreeDAO;
import model.LessonDAO;
import model.StaffDAO;
import model.entities.Degree;
import model.entities.Lesson;
import model.entities.Staff;

/**
 *
 * @author Jarretier Adrien "jarretier.adrien@gmail.com"
 */
@WebServlet(name = "AjaxScheduleDatasServlet", urlPatterns = {"/AjaxScheduleDatasServlet"})
public class AjaxScheduleDatasServlet extends HttpServlet {

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

        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter pwout = response.getWriter()) {
            String name = request.getParameter("name");
            int id = Integer.parseInt(request.getParameter("teacherId"));

            try {
                LessonDAO dao = new LessonDAO();

                Gson gson = new Gson();
                String gsonData = "";
                ArrayList<Lesson> schedule = null;

                if (name.equals("teacher")) {

                    Staff teacher = (new StaffDAO()).getById(id);
                    schedule = dao.getSchedule(teacher);

                } else if (name.equals("degree")) {

                    Degree degree = (new DegreeDAO()).getById(id);
                    schedule = dao.getSchedule(degree);
                }

                gsonData = gson.toJson(schedule);

                System.out.println(gsonData);
                pwout.println(gsonData);

            } catch (SQLException ex) {
                Logger.getLogger(AjaxScheduleDatasServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DAOException ex) {
                Logger.getLogger(AjaxScheduleDatasServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
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
