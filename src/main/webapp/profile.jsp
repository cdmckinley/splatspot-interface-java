<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Profile"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
    <%@include file="include/header.jsp"%>
    <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
        <table class="table table-info m-3 w-50">
            <tr><th>Username</th><th>Nickname</th><th>Friend code</th><th>Splash Tag</th><th>Share game information</th><th>Share game status</th></tr>
            <tr><td><c:out value="${userName}"/></td><td><c:out value="${nickname}"/></td><td><c:out value="${friendCode}"/></td>
                <td><c:out value="${splashTag}"/></td><td><c:out value="${shareInfo}"/></td><td><c:out value="${shareStatus}"/></td></tr>
        </table>
        <%-- TODO make prettier --%>
        <form action="profile" method="post" class="w-50 border border-info p-2">
            <div>
                <label for="nickname-input" class="form-label">SplatSpot Nickname</label><br>
                <input type="text" name="nickname" id="nickname-input">
            </div>
            <div>
                <label for="friend-code-input" class="form-label">Nintendo Switch Friend Code</label><br>
                <input type="text" name="friend-code" id="friend-code-input">
            </div>
            <fieldset>
                <legend>Splatoon 3 Splash-Tag information</legend>
                <div>
                    <label for="splash-tag-name-input" class="form-label">Name</label><br>
                    <input type="text" name="splash-tag-name" id="splash-tag-name-input">
                </div>
                <div>
                    <label for="splash-tag-number-input" class="form-label">Four-digit number</label><br>
                    <input type="text" name="splash-tag-number" id="splash-tag-number-input">
                </div>
            </fieldset>
            <fieldset>
                <legend>SplatSpot Preferences</legend>
                <div>
                    <label for="share-info-input" class="form-label">Share my game information automatically?</label>
                    <select name="share-info" id="share-info-input">
                        <option value="keep">Keep my current setting</option>
                        <option value="no">No</option>
                        <option value="yes">Yes</option>
                    </select>
                </div>
                <div>
                    <label for="share-status-input">Share when I'm ready to play automatically?</label>
                    <select name="share-status" id="share-status-input">
                        <option value="keep">Keep my current setting</option>
                        <option value="no">No</option>
                        <option value="yes">Yes</option>
                    </select>
                </div>
            </fieldset>
            <button type="submit" name="submit">Submit</button>
        </form>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>