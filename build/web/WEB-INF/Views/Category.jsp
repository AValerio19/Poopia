<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="Assets/Css/Category.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="Assets/Css/Books.component.css?v=<%= System.currentTimeMillis() %>" type="text/css">

<article class="category-article">
    <div class="category-header">
        <h1 class="category-main-title">Explorar por Categorías</h1>
    </div>

    <div class="shelves-container">
        <c:forEach var="m" items="${listaMaterias}">
            <div class="shelf-section">
                <div class="shelf-title-wrapper">
                    <h2 class="shelf-title">${m.nombreMateria}</h2>
                </div>
                <div class="shelf-row">
                    <c:set var="hasBooks" value="false" />
                    <c:forEach var="c" items="${listaContenidos}">
                        <c:if test="${c.materiaId == m.id}">
                            <c:set var="hasBooks" value="true" />
                            <div class="shelf-item">
                                <jsp:include page="/WEB-INF/Components/Books.jsp">
                                    <jsp:param name="titulo" value="${c.titulo}"/>
                                    <jsp:param name="autor" value="${c.publicador}"/>
                                    <jsp:param name="imagen_url" value="${c.imagenUrl}"/>
                                    <jsp:param name="estrellas" value="${c.promedioEstrellas}"/>
                                    <jsp:param name="id" value="${c.id}"/>
                                    <jsp:param name="p" value="category"/>
                                </jsp:include>
                                
                            </div>
                        </c:if>
                    </c:forEach>
                    <c:if test="${!hasBooks}">
                        <div class="empty-shelf-msg">
                            <p>No hay libros en esta categoría aún.</p>
                        </div>
                    </c:if>
                </div>
                <div class="shelf-board"></div>
            </div>
        </c:forEach>
    </div>
</article>
