<header class="sticky-top bg-info container-fluid">
    <nav class="navbar d-flex flex-row">
        <a class="navbar-brand mx-3 text-white" href="<c:url value="/home"/>"><img src="images/logo_2x.png" alt="SplatSpot Logo">SplatSpot</a>
        <div class="d-flex justify-content-end">
            <%-- TODO Update ALL links, including for every condition --%>
            <a class="mx-2 text-dark" href="list-videos">Moments</a>
            <c:choose>
                <c:when test="${sessionScope.userName != null}">
                    <a class="mx-2 text-dark" href="<c:url value="/list-videos?user=${userName}"/>"><c:out value="${userName}"/></a>
                </c:when>
                <c:otherwise>
                    <c:set var="guestUser" value="Yes"/>
                    <a class="mx-2 text-dark" href="<c:url value="/login"/>">Sign Up</a>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${guestUser != null}">
                    <a class="mx-2 text-dark" href="<c:url value="/login"/>">Log in</a>
                </c:when>
                <c:otherwise>
                    <a class="mx-2 text-dark" href="home?logout=logout">Log out</a>
                </c:otherwise>
            </c:choose>
        </div>
    </nav>
</header>