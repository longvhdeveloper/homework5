/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.vlong.java.homework05.application.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.vlong.java.homework05.application.exception.DeleteException;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.service.CourseService;

/**
 *
 * @author vlong
 */
@WebServlet(name = "courseDeleteServlet", urlPatterns = {"/course/delete"})
public class DeleteServlet extends HttpServlet {

    private RequestDispatcher view;
    private final CourseService courseService;

    public DeleteServlet() {
        courseService = new CourseService();
    }

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
            int id = Integer.parseInt(request.getParameter("id"));

            boolean isDelete = courseService.delete(id);
            if (isDelete) {
                request.setAttribute("success", true);
                request.setAttribute("message", "Delete course success.");
            } else {
                request.setAttribute("error", true);
                request.setAttribute("message", "Course not found");
            }

        } catch (NumberFormatException ex) {
            request.setAttribute("error", true);
            request.setAttribute("message", "Course not found");
        }
        response.sendRedirect("/courses");
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

    }

}
