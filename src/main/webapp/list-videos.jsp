<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<c:set var = "title" scope = "page" value = "Videos List"/>
<head>
    <%@include file="include/head.jsp"%>
</head>
<body class="bg-dark pb-0 mb-0">
<%@include file="include/data-tables.jsp"%>
<div class="container-lg bg-secondary">
  <%@include file="include/header.jsp"%>
  <main class="bg-primary my-3 d-flex flex-column align-items-center text-white">
      <h3>Videos list (UI powered by <a class="link-light" href="https://datatables.net/">Data Tables</a>)</h3>
      <c:if test="${userName != null}">
          <div><span>You're logged in as <c:out value="${userName}"/>, <a class="link-light" href="video">Add your own?</a></span></div>
      </c:if>
      <div class="bg-light">
      <table id="data-table" class="display">
          <thead>
              <tr>
                  <th>Thumbnail</th>
                  <th>Title</th>
                  <th>Channel</th>
                  <th>Shared By</th>
              </tr>
          </thead>
          <tbody>
              <c:forEach items = "${videos}" var = "video">
                  <tr>
                      <td><img src="<c:out value="${video.snippet.getThumbnails().getDefault().getUrl()}"/>"
                               alt="<c:out value="${video.snippet.getTitle()}"/>"></td>
                      <td><a href="<c:url value="watch?video-id=${video.getId()}"/>">
                              <c:out value="${video.snippet.getTitle()}"/></a></td>
                      <td><c:out value="${video.snippet.getChannelTitle()}"/></td>
                      <td><c:out value="${video.getUser().getUsername()}"/></td>
                  </tr>
              </c:forEach>
          </tbody>
      </table>
      </div>
  </main>
  <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>
