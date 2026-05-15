<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty viewToLoad}">
    <c:set var="viewToLoad" value="/WEB-INF/Views/Main.jsp" />
</c:if>

<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>Paprender</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <link rel="preconnect" href="https://fonts.googleapis.com" />
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
        <link href="https://fonts.googleapis.com/css2?family=Cormorant:ital,wght@0,300..700;1,300..700&display=swap" rel="stylesheet" />

        <link rel="stylesheet" href="Assets/Css/Global.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
    </head>
    <body>
        <main>
            <jsp:include page="WEB-INF/Components/Sidebar.jsp" />

            <div class="container-main">
                <jsp:include page="WEB-INF/Components/Header.jsp" />
                <div class="container-secondary">
                    <jsp:include page="${viewToLoad}" />
                    <jsp:include page="WEB-INF/Components/Preview.jsp" />
                </div>
            </div>
        </main>
    </body>
</html>
