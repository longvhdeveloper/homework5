/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.vlong.java.homework05.application.servlet.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.vlong.java.homework05.application.exception.AddException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.service.CourseService;

/**
 *
 * @author vlong
 */
@WebServlet(name = "AddServlet", urlPatterns = {"/course/add"})
public class AddServlet extends HttpServlet {

    private RequestDispatcher view;
    private final CourseService courseService;

    public AddServlet() {
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
        CourseDTO courseDTO = new CourseDTO();
        request.setAttribute("courseDTO", courseDTO);
        view = request.getRequestDispatcher("/course/add.jsp");
        view.forward(request, response);
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
        String message = null;
        try {
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(request.getParameter("name"));
            courseService.add(courseDTO);
            request.getSession().setAttribute("success", true);
            message = "Add course success.";
        } catch (AddException ex) {
            request.getSession().setAttribute("error", true);
            message = ex.getMessage();
        }
        request.getSession().setAttribute("message", message);
        response.sendRedirect("/courses");
    }

}
