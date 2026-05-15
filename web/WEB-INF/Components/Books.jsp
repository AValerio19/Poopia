<a href="main?p=${param.p}&id=${param.id}" class="book-card ${param.id == requestScope.selectedBookId ? 'book-selected' : ''}">
    <div class="book-card-img-container">
        <img src="Assets/Img/Books/${param.imagen_url}" alt="${param.titulo}">
    </div>
    <div class="book-card-content">
        <div class="book-card-information">
            <h3 class="book-card-title">${param.titulo}</h3>
            <p class="book-card-autor">${param.autor}</p>
        </div>
        <div class="book-card-options">
            <span class="book-card-stars">${param.estrellas} ⭐</span>
            <span class="book-card-save">
                <svg viewBox="0 0 100 100"  stroke="var(--text-main)" stroke-width="6" stroke-linejoin="round">
                    <path d="M80 85l-30-20-30 20V20a8 8 0 0 1 8-8h44a8 8 0 0 1 8 8z" />
                </svg>
            </span>
        </div>
    </div>
</a>