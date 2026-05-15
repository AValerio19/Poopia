<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="Assets/Css/Reading.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<article class="reading-article">
    <div class="reading-container">
        <!-- Sidebar: Índice de secciones -->
        <aside class="reading-sidebar">
            <h2 class="reading-sidebar-title">Índice</h2>
            <ul class="reading-toc">
                <c:choose>
                    <c:when test="${not empty listaSecciones}">
                        <c:forEach var="seccion" items="${listaSecciones}">
                            <li>
                                <a href="main?p=read&id=${readingBook.id}&seccionId=${seccion.id}" 
                                   class="toc-link ${seccion.id == seccionSeleccionada.id ? 'active' : ''}">
                                    ${seccion.orden}. ${seccion.subtitulo}
                                </a>
                            </li>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <li class="toc-empty">No hay secciones disponibles.</li>
                    </c:otherwise>
                </c:choose>
            </ul>
            
            <a href="main?p=details&id=${readingBook.id}" class="btn-vintage back-btn">← Volver al libro</a>
        </aside>

        <!-- Main Content: Contenido de la sección seleccionada -->
        <div class="reading-content-area">
            <header class="reading-header">
                <h1 class="reading-book-title">${readingBook.titulo}</h1>
                <p class="reading-book-author">Por ${readingBook.publicador}</p>
            </header>
            
            <div class="reading-divider"></div>
            
            <section class="reading-body">
                <c:choose>
                    <c:when test="${not empty seccionSeleccionada}">
                        <h2 class="reading-section-title">${seccionSeleccionada.subtitulo}</h2>
                        <div class="reading-text">
                            ${seccionSeleccionada.cuerpoTexto}
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="reading-empty-state">
                            <p>Selecciona una sección del índice para comenzar a leer.</p>
                            <div class="reading-text-placeholder">
                                ${readingBook.cuerpoTexto}
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </section>
        </div>
    </div>
</article>
