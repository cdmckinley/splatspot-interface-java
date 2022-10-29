<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Profile"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <table>
            <tr><th>Username</th><th>Nickname</th><th>Friend code</th><th>Splash Tag</th></tr>
            <tr><td><c:out value="${userName}"/></td><td><c:out value="${nickname}"/></td><td><c:out value="${friendCode}"/></td><td><c:out value="${splashTag}"/></td></tr>
        </table>
        <%-- TODO make prettier --%>
        <form action="profile" method="post">
            <label for="nickname-input">SplatSpot Nickname</label>
            <input type="text" name="nickname" id="nickname-input"><br>
            <label for="friend-code-input">Nintendo Switch Friend Code</label>
            <input type="text" name="friend-code" id="friend-code-input"><br>
            <fieldset>
                <legend>Splash Tag information</legend>
                <label for="splash-tag-name-input">Name</label>
                <input type="text" name="splash-tag-name" id="splash-tag-name-input">
                <label for="splash-tag-number-input">Four-digit number</label>
                <input type="text" name="splash-tag-number" id="splash-tag-number-input">
            </fieldset>
            <%-- TODO test if submission works or not --%>
            <button type="submit" name="submit">Submit</button>
        </form>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>