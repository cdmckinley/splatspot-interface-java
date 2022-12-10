<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Home"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <h1>Welcome to SplatSpot!</h1>
        <p>Share Splatoon 3 battles and media</p>
        <div class="m-5 p-5">
            <img src="images/logo_4x.png" alt="SplatSpot Logo" >
        </div>
        <h3>SplatSpot: The Spot for sharing Splatoon 3 moments!</h3>
        <p class="w-50">Want to see our collection of Splatoon 3 moments?
            Head to our <a class="link-light" href="list-videos">List of Videos</a>.
            Want to share something of your own?
            <a class="link-light" href="video">Share a video</a> after <a class="link-light" href="login">signing up and logging in</a>
        </p>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>
