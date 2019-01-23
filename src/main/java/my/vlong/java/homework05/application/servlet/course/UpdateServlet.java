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
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.application.exception.UpdateException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.service.CourseService;

/**
 *
 * @author vlong
 */
@WebServlet(name = "UpdateServlet", urlPatterns = {"/course/update"})
public class UpdateServlet extends HttpServlet {

    private RequestDispatcher view;
    private final CourseService courseService;

    public UpdateServlet() {
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
            CourseDTO courseDTO = courseService.getCourse(id);
            request.setAttribute("id", id);
            request.setAttribute("courseDTO", courseDTO);
            view = request.getRequestDispatcher("/course/update.jsp");
            view.forward(request, response);
        } catch (NumberFormatException | ResultNotFoundException ex) {
            request.setAttribute("error", true);
            request.setAttribute("message", "Course not found");
            response.sendRedirect("/courses");
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
        int id = 0;
        try {
            id = Integer.parseInt(request.getParameter("id"));
            System.out.println("ID: " + id);
            CourseDTO courseDTO = new CourseDTO();
            courseDTO.setName(request.getParameter("name"));
            CourseDTO update = courseService.update(id, courseDTO);

            request.setAttribute("courseDTO", update);
            request.getSession().setAttribute("success", true);
            request.getSession().setAttribute("message", "Update course success.");

        } catch (NumberFormatException | ResultNotFoundException ex) {
            request.getSession().setAttribute("error", true);
            request.getSession().setAttribute("message", "Course not found");
            response.sendRedirect("/courses");
        } catch (UpdateException ex) {
            request.getSession().setAttribute("error", true);
            request.getSession().setAttribute("message", "Course can not update");
        }
        request.setAttribute("id", id);
        view = request.getRequestDispatcher("/course/update.jsp");
        view.forward(request, response);
    }
}
