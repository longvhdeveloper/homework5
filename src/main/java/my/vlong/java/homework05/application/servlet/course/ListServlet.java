package my.vlong.java.homework05.application.servlet.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import my.vlong.java.homework05.application.exception.ResultNotFoundException;
import my.vlong.java.homework05.domain.dto.CourseDTO;
import my.vlong.java.homework05.domain.service.CourseService;

@WebServlet(value = "/courses", name = "courseListServlet")
public class ListServlet extends HttpServlet {

    private final CourseService courseService;
    private RequestDispatcher view;

    public ListServlet() {
        courseService = new CourseService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CourseDTO> courses = new ArrayList<>();
        try {
            courses = courseService.findAll();
            
        } catch (ResultNotFoundException ex) {
            request.setAttribute("error", true);
            request.setAttribute("message", ex.getMessage());
        }
        request.setAttribute("courses", courses);
        view = request.getRequestDispatcher("course/list.jsp");
        view.forward(request, response);
    }

}
