<link rel="stylesheet" href="Assets/Css/Main.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<link rel="stylesheet" href="Assets/Css/Books.component.css?v=<%= System.currentTimeMillis() %>" type="text/css">
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<article>
    <section class="materias">
        <h2>Materias</h2>
        <div class="section-content">
            <div class="materia-container">
                <ul class="materia-list">
                    <li>
                        <a href="main?p=home" class="materia-item ${empty param.m ? 'active' : ''}">
                            Todos
                        </a>
                    </li>
                    <c:forEach var="m" items="${listaMaterias}">
                        <li>
                            <c:set var="materiaNombre" value="${fn:trim(m.nombreMateria)}" />
                            <c:set var="materiaParam" value="${fn:trim(param.m)}" />
                            
                            <a href="main?p=home&m=${materiaNombre}" 
                                class="materia-item ${materiaParam == materiaNombre ? 'active' : ''}">
                                ${materiaNombre}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
                <div class="materia-options">
                    <div class="materia-options-btn" tabindex="0">
                        <div class="materia-item-text">Opciones</div>
                        <div class="materia-options-dropdown">
                            <ul class="materia-options-list">
                                <li>
                                    <a href="main?p=home&m=add-form" class="materia-option-item">
                                        <span>Agregar</span>
                                    </a>
                                </li>
                                <li>
                                    <a href="main?p=home&m=delete-form" class="materia-option-item">
                                        <span>Eliminar</span>
                                    </a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <c:if test="${param.m == 'add-form'}">
                <form action="MainServlet" method="post" class="materia-form">
                    <input type="hidden" name="action" value="add">
                    <input type="text" name="nombreMateria" placeholder="Agregar Materia" class="mtFormInput">
                    <button type="submit" class="mtFormBtn">+</button>
                </form>
            </c:if>
            <c:if test="${param.m == 'delete-form'}">
                <form action="MainServlet" method="post" class="materia-form">
                    <input type="hidden" name="action" value="delete">
                    <select name="idMateria" class="mtFormInput">
                        <c:forEach var="m" items="${listaMaterias}">
                            <option value="${m.id}">${m.nombreMateria}</option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="mtFormBtn">-</button>
                </form>
            </c:if>
        </div>
    </section>

    <section class="last-inserts">
        <h2>Ultimos agregados</h2>
        <div class="section-content">
            <div class="books-container">
                <c:forEach var="c" items="${listaContenidos}" >
                    <jsp:include page="/WEB-INF/Components/Books.jsp">
                        <jsp:param name="titulo" value="${c.titulo}"/>
                        <jsp:param name="autor" value="${c.publicador}"/>
                        <jsp:param name="imagen_url" value="${c.imagenUrl}"/>
                        <jsp:param name="estrellas" value="${c.promedioEstrellas}"/>
                        <jsp:param name="id" value="${c.id}"/>
                    </jsp:include>
                </c:forEach>
            </div>

        </div>
    </section>

    <section class="popular">
        <h2>Populares</h2>
        <div class="section-content">
            <div class="books-container">
                <c:forEach var="c" items="${listaContenidos}" >
                    <jsp:include page="/WEB-INF/Components/Books.jsp">
                        <jsp:param name="titulo" value="${c.titulo}"/>
                        <jsp:param name="autor" value="${c.publicador}"/>
                        <jsp:param name="imagen_url" value="${c.imagenUrl}"/>
                        <jsp:param name="estrellas" value="${c.promedioEstrellas}"/>
                        <jsp:param name="id" value="${c.id}"/>
                    </jsp:include>
                </c:forEach>
            </div>
        </div>
    </section>

</article>
