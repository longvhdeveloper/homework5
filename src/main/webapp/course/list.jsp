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
        <div class="row" style="margin-left: 10px;">
            <h1>List Course</h1>
            <div class="col-md-9">

                <a href="/course/add" class="btn btn-success" style="float:right; margin-right: 10px;">Add course</a>

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
                            <th></th>
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
                            if (courseDTO.getStudentDTOs() != null && !courseDTO.getStudentDTOs().isEmpty()) {%>
                                <span class="label label-success"><%= courseDTO.getStudentDTOs().size()%></span>
                                <% } else { %>
                                <span class="label label-default">0</span>
                                <%}
                                %></td>
                            <td>
                                <a class="btn btn-primary" href="/course/update?id=<%=courseDTO.getId()%>">Edit</a>
                                <a class="btn btn-danger" href="/course/delete?id=<%=courseDTO.getId()%>">Delete</a>
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
                <%}
                %>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
