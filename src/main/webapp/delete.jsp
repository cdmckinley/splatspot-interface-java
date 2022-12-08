<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Delete a video"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <h3>Really delete post sharing video?</h3>
        <form action="delete" method="post">
            <label for="yesInput">Yes</label>
            <input type="checkbox" id="yesInput" name="yes">
            <button type="submit">Confirm</button>
        </form>
<%--        TODO add delete confirmation--%>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>