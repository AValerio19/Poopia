<link rel="stylesheet" href="Assets/Css/Preview.component.css?v=<%= System.currentTimeMillis() %>" type="text/css" />

<div class="preview-container" style="display: ${param.id != null ? 'flex' : 'none' };">
    <div style="padding: 1em">
        <div class="preview-top">
            <div class="preview-img-container">
                <img src="Assets/Img/Books/${requestScope.previewBook.imagenUrl}" alt="${requestScope.previewBook.titulo}" />
            </div>
            <div class="preview-book-info">
                <div class="book-info-title">${requestScope.previewBook.titulo}</div>
                <div class="book-info-list">
                    <p class="book-info-row"><span class="book-label">Autor</span><span>${requestScope.previewBook.publicador}</span></p>
                    <p class="book-info-row"><span class="book-label">Fecha de subida</span><span>${requestScope.previewBook.fechaPublicacion}</span></p>
                    <p class="book-info-row"><span class="book-label">Calificacion</span><span>${requestScope.previewBook.promedioEstrellas} ⭐</span></p>
                </div>
            </div>
        </div>
        <div class="preview-content">
            <div class="preview-options">
                <a href="" class="preview-start">Comenzar lectura</a>
                <div class="preview-options-row">
                    <a href="" class="preview-tool">
                        <span class="tool-icon">
                            <svg viewBox="0 0 100 100" stroke="var(--text-main)" stroke-width="6" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M50 15 L15 45 L15 85 H85 V45 L50 15 Z" />
                                <path d="M35 70 V70 H65" />
                            </svg>
                        </span>
                        <span class="tool-name">Descargar</span>
                    </a>
                    <a href="" class="preview-tool">
                        <span class="tool-icon">
                            <svg viewBox="0 0 100 100" stroke="var(--text-main)" stroke-width="6" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M50 15 L15 45 L15 85 H85 V45 L50 15 Z" />
                                <path d="M35 70 V70 H65" />
                            </svg>
                        </span>
                        <span class="tool-name">Guardar</span>
                    </a>
                    <a href="" class="preview-tool">
                        <span class="tool-icon">
                            <svg viewBox="0 0 100 100" stroke="var(--text-main)" stroke-width="6" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M50 15 L15 45 L15 85 H85 V45 L50 15 Z" />
                                <path d="M35 70 V70 H65" />
                            </svg>
                        </span>
                        <span class="tool-name">Enlistar</span>
                    </a>
                </div>
            </div>
            <div class="preview-info">
                <p class="preview-book-desc">
                    ${requestScope.previewBook.cuerpoTexto}
                </p>
            </div>
        </div>
    </div>
</div>
