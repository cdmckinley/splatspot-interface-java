<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Error"/>
<%@include file="include/head.jsp"%>
<body class="bg-dark pb-0 mb-0">
<div class="container-lg bg-secondary">
  <%@include file="include/header.jsp"%>
  <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
    <h1>An error occurred</h1>
    <p class="w-50">Please try again. If this repeats, please check if someone has made an issue
      <a class="link-dark" href="https://github.com/cdmckinley/splatspot-interface-java/issues">Here on GitHub</a>,
      that describes the situation you encountered. Someone may have replied to an issue with a
      solution for you, or we may be in progress of fixing it. If there's no issue made for this
      situation, please create a new issue describing what you tried and when, the result you expected, and what
      happened instead.
    </p>
    <%-- TODO Update link --%>
    <p>Thanks for using SplatSpot! <a class="link-dark" href="<c:url value="/home"/>">Return to home page</a></p>
  </main>
  <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>
