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
        <h3>TODO: General App Description</h3>
        <p class="w-50">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos at aliquid molestiae accusamus quisquam ad, deleniti quis dicta necessitatibus similique maxime optio! Dignissimos corrupti, possimus illo in earum ipsa esse.</p>
        <div class="m-5 p-5 border border-info">
            <span>TODO: Put Image Here</span>
        </div>
        <h3>TODO: Discord Integration Description</h3>
        <p class="w-50">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos at aliquid molestiae accusamus quisquam ad, deleniti quis dicta necessitatibus similique maxime optio! Dignissimos corrupti, possimus illo in earum ipsa esse.</p>
        <div class="m-5 p-5 border border-info">
            <span>TODO: Put Image Here</span>
        </div>
        <h3>TODO: Media Sharing Description</h3>
        <p class="w-50">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos at aliquid molestiae accusamus quisquam ad, deleniti quis dicta necessitatibus similique maxime optio! Dignissimos corrupti, possimus illo in earum ipsa esse.</p>
        <div class="m-5 p-5 border border-info">
            <span>TODO: Put Image Here</span>
        </div>
        <h3>TODO: Other Notes and Contact</h3>
        <p class="w-50">Lorem ipsum dolor sit amet consectetur adipisicing elit. Quos at aliquid molestiae accusamus quisquam ad, deleniti quis dicta necessitatibus similique maxime optio! Dignissimos corrupti, possimus illo in earum ipsa esse.</p>
    </main>
    <%@include file="include/footer.jsp"%>
</div>
<%@include file="include/closing-scripts.jsp"%></body>
</html>
