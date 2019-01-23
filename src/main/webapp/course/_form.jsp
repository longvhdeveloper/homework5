<%@page import="my.vlong.java.homework05.domain.dto.CourseDTO"%>
<%
    CourseDTO courseDTO = (CourseDTO) request.getAttribute("courseDTO");
    String name = courseDTO.getName() != null ? courseDTO.getName() : "";
%>
<div class="form-group">
    <label for="name">Course Name</label>
    <span class="required">*</span>
    <input type="text" class="form-control" id="name" name="name" placeholder="Course Name" value="<%=name%>">
</div>

<button type="submit" class="btn btn-default">Save</button>
<a class="btn btn-danger" href="/courses">Cancel</a>
