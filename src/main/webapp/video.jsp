<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Video Information"/>
<head>
<%@include file="include/head.jsp"%>
    <!-- jQuery library -->
    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
            integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
</head>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <c:choose>
            <c:when test="${mode == 'edit'}">
                <h3>Edit video "<c:out value="${videoName}"/>"</h3>
            </c:when>
            <c:otherwise>
                <h3 class="my-2">Post a New Video</h3>
            </c:otherwise>
        </c:choose>
        <form action="video" method="post">
            <c:choose>
                <c:when test="${mode == 'edit'}">
                    <span>Edit the data for "<c:out value="${videoName}"/>"</span>
                </c:when>
                <c:otherwise>
                    <div class="form-group">
                        <label for="link">ID for the YouTube video</label>
                        <input class="form-control" type="text" name="link" id="link" required>
                        <p id="linkvalid">
                            Enter the 11 character id found after the <span>'v='</span> in
                            <span>www.youtube.com/watch?v=***********</span>, also found as the 11 characters following
                            <span>youtu.be/</span> in <span>youtu.be/***********</span>
                        </p>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea class="form-control" name="description" id="description" cols="30" rows="10" maxlength="500"></textarea>
                <p id="descriptionvalid">
                    Enter a description of the video, or your thoughts on it, if you'd like.
                    Must be no longer than 500 characters.
                </p>
            </div>
            <input type="submit" id="submitbutton" value="Submit" class="btn btn-primary">
        </form>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<!-- jQuery validation -->
<script src="js/videoValidation.js"></script>
<%@include file="include/closing-scripts.jsp"%></body>
</html>