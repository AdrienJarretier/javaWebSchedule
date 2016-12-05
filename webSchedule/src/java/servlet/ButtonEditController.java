/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
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
import model.LessonDAO;
import model.StaffDAO;
import model.Class_roomDAO;
import model.DegreeDAO;
import model.entities.Class_room;
import model.entities.Degree;
import model.entities.Lesson;
import model.entities.Staff;

/**
 *
 * @author Laurie
 */
@WebServlet(name = "ButtonEditController", urlPatterns = {"/ButtonEditController"})
public class ButtonEditController extends HttpServlet {

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
            
            Staff user = (Staff) request.getSession().getAttribute("userEntity");
            int lesson_id =  Integer.parseInt(request.getParameter("id"));
            
            LessonDAO l = new LessonDAO();
            Lesson lesson = l.getById(lesson_id);
            
            Class_roomDAO c = new Class_roomDAO();
            ArrayList<Class_room> rooms = c.getClassRooms();
            
            if (user.getIsAdmin()) {
                 StaffDAO s = new StaffDAO();
                ArrayList<Staff> teacherNames = s.getTeachers();
                request.setAttribute("teacherNames", teacherNames);
            }
            
            DegreeDAO d = new DegreeDAO();
            ArrayList<Degree> degrees = d.getDegrees();
                
            System.out.println(lesson.getTimeStart());
            
            request.setAttribute("degrees", degrees);
            request.setAttribute("lesson", lesson);
            request.setAttribute("rooms", rooms);
            request.getRequestDispatcher("editLesson.jsp").forward(request, response);
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
            Logger.getLogger(ButtonEditController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(ButtonEditController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ButtonEditController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(ButtonEditController.class.getName()).log(Level.SEVERE, null, ex);
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
