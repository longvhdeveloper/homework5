<%@page import="my.vlong.java.homework05.domain.dto.CourseDTO"%>
<%@page import="java.util.*"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">


        <title>List Course</title>
    </head>
    <body>
        <h1>List Course</h1>

        <a class="btn btn-primary right">Add course</a>

        <%
                    List<CourseDTO> courses = (ArrayList<CourseDTO>) request.getAttribute("courses");
                    if (courses.isEmpty()) { %>
                    No have data
                %>
                 <%
                } else {
                %>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Name</th>
                            <th>Number of students</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (CourseDTO courseDTO : courses) {
                        %>
                        <tr>
                            <td><%= courseDTO.getId()%></td>
                            <td><%= courseDTO.getName()%></td>
                            <td><%
                            if (courseDTO.getStudentDTOs() != null) {
                                out.write(courseDTO.getStudentDTOs().size());
                            } else {
                                out.write("0");
                            }
                            %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <%}
                %>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
