package my.vlong.java.homework05.application.servlet.course;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CourseDTO> courses = courseService.findAll();
        System.out.println("XXXXXXXXX");
        System.out.println(courses);
        req.setAttribute("courses", courses);
        view = req.getRequestDispatcher("course/list.jsp");

        view.forward(req, resp);
    }

}
