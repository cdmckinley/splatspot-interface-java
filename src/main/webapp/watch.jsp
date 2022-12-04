<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Watch a Shared Video"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <h3><c:out value="${videoName}"/></h3>
        <h4>Shared by <c:out value="${profileName}"/> - from the YouTube channel <c:out value="${channelName}"/></h4>
        <iframe type="text/html" width="640" height="360"
                src="https://www.youtube.com/embed/<c:out value="${videoId}"/>"></iframe>
        <label for="description">Description by <c:out value="${profileName}"/>:</label>
        <p id="description"><c:out value="${mediaDescription}"/></p>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>