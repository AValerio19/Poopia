<a href="main?p=details&id=${param.id}" class="book-card ${param.id == requestScope.selectedBookId ? 'book-selected' : ''}">
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
            <span class="book-card-save">Fav</span>
        </div>
    </div>
</a>