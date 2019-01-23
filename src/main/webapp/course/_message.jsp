<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    if (request.getSession().getAttribute("success") != null && (boolean) request.getSession().getAttribute("success") == true) {
%>
<div class="alert alert-success" role="alert"><%=request.getSession().getAttribute("message")%></div>
<%
    }
%>

<%
    if (request.getSession().getAttribute("error") != null && (boolean) request.getSession().getAttribute("error") == true) {
%>
<div class="alert alert-danger" role="alert"><%=request.getSession().getAttribute("message")%></div>
<%
    }
%>
<c:remove scope="session" var="message"></c:remove>
<c:remove scope="session" var="success"></c:remove>
<c:remove scope="session" var="error"></c:remove>