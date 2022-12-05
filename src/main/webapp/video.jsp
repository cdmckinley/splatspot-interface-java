<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Video Information"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <h3 class="my-2">Post a New Video</h3>
        <form action="video" method="post">
            <label for="link">Link for the video</label>
            <input type="text" name="link" id="link">
            <label for="description">Enter a description of the video, or your thoughts on it</label>
            <textarea name="description" id="description" cols="30" rows="10" maxlength="500"></textarea>
            <button type="submit">Submit</button>
        </form>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>