<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="Assets/Css/Discover.view.css?v=<%= System.currentTimeMillis() %>" type="text/css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="Assets/Css/Books.component.css?v=<%= System.currentTimeMillis() %>" type="text/css">

<article class="discover-article">
    <div class="discover-header">
        <div class="discover-title-wrapper">
            <h1 class="discover-title">Descubrir Nuevas Historias</h1>
            <p class="discover-subtitle">Explora, edita o agrega tu propio conocimiento a la colección.</p>
        </div>
        <button class="btn-vintage add-btn" onclick="openModal('addModal')">+ Añadir Libro</button>
    </div>

    <div class="discover-grid">
        <c:forEach var="c" items="${listaContenidos}">
            <div class="discover-card-wrapper">
                <jsp:include page="/WEB-INF/Components/Books.jsp">
                    <jsp:param name="titulo" value="${c.titulo}"/>
                    <jsp:param name="autor" value="${c.publicador}"/>
                    <jsp:param name="imagen_url" value="${c.imagenUrl}"/>
                    <jsp:param name="estrellas" value="${c.promedioEstrellas}"/>
                    <jsp:param name="id" value="${c.id}"/>
                    <jsp:param name="p" value="discover"/>
                </jsp:include>
                
                <!-- Opciones de Edición/Borrado superpuestas -->
                <div class="discover-card-actions">
                    <button class="btn-action edit" onclick="openEditModal('${c.id}', '${c.titulo}', '${c.publicador}', '${c.materiaId}', '${c.cuerpoTexto}', '${c.imagenUrl}')" title="Editar Libro">✏️</button>
                    <form action="DiscoverServlet" method="POST" class="delete-form">
                        <input type="hidden" name="action" value="delete" />
                        <input type="hidden" name="id" value="${c.id}" />
                        <button type="submit" class="btn-action delete" onclick="return confirm('¿Estás seguro de que deseas eliminar este libro? Esta acción no se puede deshacer.');" title="Eliminar Libro">🗑️</button>
                    </form>
                </div>
            </div>
        </c:forEach>
        
        <c:if test="${empty listaContenidos}">
            <div class="empty-state">
                <p>No hay libros disponibles en este momento. ¡Sé el primero en añadir uno!</p>
            </div>
        </c:if>
    </div>

    <!-- Modal para Añadir Libro -->
    <div id="addModal" class="modal-overlay">
        <div class="modal-box">
            <div class="modal-header">
                <h2>Añadir Nuevo Libro</h2>
                <button class="close-btn" onclick="closeModal('addModal')">&times;</button>
            </div>
            <form action="DiscoverServlet" method="POST" class="vintage-form" enctype="multipart/form-data">
                <input type="hidden" name="action" value="add" />
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Título del libro</label>
                        <input type="text" name="titulo" required placeholder="Ej: Clean Code" />
                    </div>
                    <div class="form-group">
                        <label>Autor / Publicador</label>
                        <input type="text" name="publicador" placeholder="Ej: Robert C. Martin" />
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Materia / Categoría</label>
                        <select name="materiaId" required>
                            <c:forEach var="m" items="${listaMaterias}">
                                <option value="${m.id}">${m.nombreMateria}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Fecha de Publicación</label>
                        <input type="date" name="fecha" />
                    </div>
                </div>
                
                <div class="form-group">
                    <label>Subir Imagen</label>
                    <input type="file" name="imagenFile" accept="image/*" />
                </div>
                
                <div class="form-group">
                    <label>Descripción / Contenido</label>
                    <textarea name="cuerpo" required rows="5" placeholder="Escribe la sinopsis o el contenido principal del libro aquí..."></textarea>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn-vintage cancel-btn" onclick="closeModal('addModal')">Cancelar</button>
                    <button type="submit" class="btn-vintage submit-btn">Guardar Libro</button>
                </div>
            </form>
        </div>
    </div>
    
    <!-- Modal para Editar Libro -->
    <div id="editModal" class="modal-overlay">
        <div class="modal-box">
            <div class="modal-header">
                <h2>Editar Libro</h2>
                <button class="close-btn" onclick="closeModal('editModal')">&times;</button>
            </div>
            <form action="DiscoverServlet" method="POST" class="vintage-form" enctype="multipart/form-data">
                <input type="hidden" name="action" value="edit" />
                <input type="hidden" name="id" id="edit-id" />
                <input type="hidden" name="url_actual" id="edit-url-actual" />
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Título del libro</label>
                        <input type="text" name="titulo" id="edit-titulo" required />
                    </div>
                    <div class="form-group">
                        <label>Autor / Publicador</label>
                        <input type="text" name="publicador" id="edit-publicador" />
                    </div>
                </div>
                
                <div class="form-row">
                    <div class="form-group">
                        <label>Materia (No editable desde aquí)</label>
                        <select name="materiaId" id="edit-materiaId" disabled>
                            <c:forEach var="m" items="${listaMaterias}">
                                <option value="${m.id}">${m.nombreMateria}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Fecha de Publicación</label>
                        <input type="date" name="fecha" id="edit-fecha" />
                    </div>
                </div>
                
                <div class="form-group">
                    <label>Cambiar Imagen (Deja vacío para mantener la actual)</label>
                    <input type="file" name="imagenFile" accept="image/*" />
                </div>
                
                <div class="form-group">
                    <label>Descripción / Contenido</label>
                    <textarea name="cuerpo" id="edit-cuerpo" required rows="5"></textarea>
                </div>
                
                <div class="modal-footer">
                    <button type="button" class="btn-vintage cancel-btn" onclick="closeModal('editModal')">Cancelar</button>
                    <button type="submit" class="btn-vintage submit-btn">Actualizar Libro</button>
                </div>
            </form>
        </div>
    </div>

    <script>
        function openModal(id) {
            document.getElementById(id).style.display = "flex";
            // Prevenir scroll en el background
            document.querySelector('.discover-article').style.overflow = "hidden";
        }
        function closeModal(id) {
            document.getElementById(id).style.display = "none";
            document.querySelector('.discover-article').style.overflow = "auto";
        }
        function openEditModal(id, titulo, publicador, materiaId, cuerpo, url) {
            document.getElementById('edit-id').value = id;
            document.getElementById('edit-titulo').value = titulo;
            document.getElementById('edit-publicador').value = publicador;
            document.getElementById('edit-materiaId').value = materiaId;
            document.getElementById('edit-cuerpo').value = cuerpo;
            document.getElementById('edit-url-actual').value = url;
            openModal('editModal');
        }
        // Cerrar modal al hacer clic fuera del cuadro
        window.onclick = function(event) {
            if (event.target.classList.contains("modal-overlay")) {
                event.target.style.display = "none";
                document.querySelector('.discover-article').style.overflow = "auto";
            }
        }
    </script>
</article>
