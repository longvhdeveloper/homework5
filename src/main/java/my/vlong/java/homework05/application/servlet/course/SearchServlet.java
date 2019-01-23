package my.vlong.java.homework05.application.servlet.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.service.CourseService;

@WebServlet(name = "courseSearchServlet", urlPatterns = {"/course/search"})
public class SearchServlet extends HttpServlet {

    private final CourseService courseService;
    private RequestDispatcher view;

    public SearchServlet() {
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
        List<CourseDTO> courses = new ArrayList<>();
        try {
            String keyword = request.getParameter("keyword");
            courses = courseService.search(keyword);
        } catch (ResultNotFoundException ex) {
            request.setAttribute("error", true);
            request.setAttribute("message", ex.getMessage());
        }
        System.out.println(courses);
        request.setAttribute("courses", courses);
        view = request.getRequestDispatcher("/course/list.jsp");
        view.forward(request, response);
    }

}
