<header class="sticky-top bg-info container-fluid">
    <nav class="navbar d-flex flex-row">
        <a class="navbar-brand mx-3 text-white" href="#"><img src="images/logo_2x.png" alt="SplatSpot Logo">SplatSpot</a>
        <div class="d-flex justify-content-end">
            <%-- TODO Update ALL links, including for every condition --%>
            <a class="mx-2 text-dark" href="#">Find a game</a>
            <a class="mx-2 text-dark" href="#">Moments</a>
            <c:choose>
                <c:when test="${nickname != null}">
                    <a class="mx-2 text-dark" href="#"><c:out value="${nickname}"/></a>
                </c:when>
                <c:when test="${userName != null}">
                    <a class="mx-2 text-dark" href="#"><c:out value="${userName}"/></a>
                </c:when>
                <c:otherwise>
                    <c:set var="guestUser" value="Yes"/>
                    <a class="mx-2 text-dark" href="#">Sign Up</a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${guestUser != null}">
                    <a class="mx-2 text-dark" href="#">Log in</a>
                </c:when>
                <c:otherwise>
                    <a class="mx-2 text-dark" href="#">Log out</a>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>