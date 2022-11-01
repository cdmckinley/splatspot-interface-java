<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Profile"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <h3 class="my-2">User information</h3>
        <form action="profile" method="post" class="w-50 border border-info p-2">
            <fieldset>
                <legend>General information</legend>
                <div>
                    <label for="nickname-input" class="form-label">SplatSpot Nickname</label><br>
                    <input type="text" name="nickname" id="nickname-input" value="<c:out value="${userName}"/>">
                </div>
                <div>
                    <label for="friend-code-input" class="form-label">Nintendo Switch Friend Code</label><br>
                    <input type="text" name="friend-code" id="friend-code-input" value="<c:out value="${friendCode}"/>">
                </div>
            </fieldset>
            <fieldset>
                <legend>Splatoon 3 Splash-Tag information</legend>
                <div>
                    <label for="splash-tag-name-input" class="form-label">Name</label><br>
                    <input type="text" name="splash-tag-name" id="splash-tag-name-input" value="<c:out value="${splashTagName}"/>">
                </div>
                <div>
                    <label for="splash-tag-number-input" class="form-label">Four-digit number</label><br>
                    <input type="text" name="splash-tag-number" id="splash-tag-number-input" value="<c:out value="${splashTagNumber}"/>">
                </div>
            </fieldset>
            <fieldset>
                <legend>SplatSpot Preferences</legend>
                <div>
                    <label for="share-info-input" class="form-label">Share my game information automatically?</label>
                    <select name="share-info" id="share-info-input">
                        <option value="no">No</option>
                        <option value="yes" <c:if test="${shareInfo == 'yes'}">selected</c:if>>Yes</option>
                    </select>
                </div>
                <div>
                    <label for="share-status-input">Share when I'm ready to play automatically?</label>
                    <select name="share-status" id="share-status-input">
                        <option value="no">No</option>
                        <option value="yes" <c:if test="${shareStatus == 'yes'}">selected</c:if>>Yes</option>
                    </select>
                </div>
            </fieldset>
            <button type="submit" name="submit">Submit</button>
<%--        TODO button to discard changes (probably refresh the page)    --%>
        </form>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>