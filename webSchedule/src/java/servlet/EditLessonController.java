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
import model.Class_roomDAO;
import model.DAOException;
import model.DegreeDAO;
import model.LessonDAO;
import model.StaffDAO;
import model.entities.Class_room;
import model.entities.Degree;
import model.entities.Lesson;
import model.entities.Staff;

/**
 *
 * @author Laurie
 */
@WebServlet(name = "EditLessonController", urlPatterns = {"/EditLessonController"})
public class EditLessonController extends HttpServlet {

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
         
        int id =  Integer.parseInt(request.getParameter("id"));
        Timestamp timeStart  = Timestamp.valueOf(request.getParameter("time_start"));
        Timestamp timeEnd  = Timestamp.valueOf(request.getParameter("time_end"));
        String title = request.getParameter("title");
        int room =  Integer.parseInt(request.getParameter("room"));
        Staff teach = user;
        
        
        if(user.getIsAdmin()){
            int teacher =  Integer.parseInt(request.getParameter("teacher"));
            StaffDAO s = new StaffDAO();
            teach = s.getById(teacher);
        }
        
        
        String[] degree = request.getParameterValues("degree");

        ArrayList<Degree> participants = new ArrayList<Degree>();
        for (int i = 0; i < degree.length; ++i) {
            DegreeDAO d = new DegreeDAO();
            int idD = Integer.parseInt(degree[i]);
            participants.add(d.getById(idD));
        }
        
        Class_roomDAO clD = new Class_roomDAO();
        Class_room classRoom = clD.getById(room);
        
        LessonDAO l = new LessonDAO();
        
        if (user.getIsAdmin()) {
            Lesson lessonE = new Lesson(id, timeStart, timeEnd, title,classRoom , teach, participants);
            l.edit(lessonE);
        }
        else{
            Lesson lesson = l.getById(id);
        
            if(lesson.getTeacher()==user){
               Lesson lessonE = new Lesson(id, timeStart, timeEnd, title,classRoom , teach, participants);
               l.edit(lessonE); 
            }
            else{
                request.setAttribute("errorMessage", "impossible d'éditer un cours dont vous n'êtes pas l'auteur");
            }
        }
        
        
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
            Logger.getLogger(EditLessonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(EditLessonController.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditLessonController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DAOException ex) {
            Logger.getLogger(EditLessonController.class.getName()).log(Level.SEVERE, null, ex);
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
