/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import model.entities.Degree;
import model.entities.Staff;

/**
 *
 * @author Laurie
 */
@WebServlet(name = "AddLessonController", urlPatterns = {"/AddLessonController"})
public class AddLessonController extends HttpServlet {

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
            throws ServletException, IOException, SQLException, DAOException {

        request.setCharacterEncoding("UTF-8");

        Staff user = (Staff) request.getSession().getAttribute("userEntity");

        Timestamp timeStart = Timestamp.valueOf(request.getParameter("time_start") + ":00");
        Timestamp timeEnd = Timestamp.valueOf(request.getParameter("time_end") + ":00");

        if (timeStart.after(timeEnd)) {
            request.setAttribute("error", "lesson must ends after it starts");
            request.getRequestDispatcher("addLesson.jsp").forward(request, response);
        }

        String title = request.getParameter("title");
        int room = Integer.parseInt(request.getParameter("room"));
        int teacher = user.getId();

        if (user.getIsAdmin()) {
            teacher = Integer.parseInt(request.getParameter("teacher"));
        }

        String[] degree = request.getParameterValues("degree");

        ArrayList<Degree> participants = new ArrayList<Degree>();
        for (int i = 0; i < degree.length; ++i) {
            DegreeDAO d = new DegreeDAO();
            int id = Integer.parseInt(degree[i]);
            participants.add(d.getById(id));
        }

        LessonDAO l = new LessonDAO();
        l.add(timeStart, timeEnd, title, room, teacher, participants);

        request.getRequestDispatcher("StaffController").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddLessonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(AddLessonController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddLessonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(AddLessonController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
