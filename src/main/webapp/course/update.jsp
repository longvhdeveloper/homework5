<%@page import="my.vlong.java.homework05.domain.dto.CourseDTO"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <title>Course</title>
    </head>
    <body>
        <div class="row" style="margin-left: 10px;">
            <h1>Update Course</h1>            
            <div class="col-md-9">
                <%
                    int id = (int) request.getAttribute("id");
                    if (request.getAttribute("success") != null && (boolean) request.getAttribute("success") == true) {
                %>
                <div class="alert alert-success" role="alert"><%=request.getAttribute("message")%></div>
                <%
                    }
                %>

                <%
                    if (request.getAttribute("error") != null && (boolean) request.getAttribute("error") == true) {
                %>
                <div class="alert alert-danger" role="alert"><%=request.getAttribute("message")%></div>
                <%
                    }
                %>
                <form method="POST" action="/course/update">
                    <input type="hidden" name="id" value="<%=id%>" />
                    <jsp:include page="_form.jsp"></jsp:include>
                </form>
            </div>
        </div>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </body>
</html>
