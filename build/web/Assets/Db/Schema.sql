-- 1. Crear tabla de Roles
CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    nombre_rol VARCHAR(50) NOT NULL UNIQUE
);

-- 2. Crear tabla de Usuarios
CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(150) UNIQUE NOT NULL,
    contrasena TEXT NOT NULL, -- Recuerda usar hashing en Java antes de insertar
    rol_id INTEGER REFERENCES roles(id) ON DELETE SET NULL
);

-- 3. Crear tabla de Materias
CREATE TABLE materias (
    id SERIAL PRIMARY KEY,
    nombre_materia VARCHAR(100) NOT NULL UNIQUE
);

-- 4. Crear tabla de Contenidos (Libros/Temas)
CREATE TABLE contenidos (
    id SERIAL PRIMARY KEY,
    materia_id INTEGER REFERENCES materias(id) ON DELETE CASCADE,
    titulo VARCHAR(255) NOT NULL,
    publicador VARCHAR(150),
    fecha_publicacion DATE,
    cuerpo_texto TEXT, -- Aquí va la información a transcribir
    imagen_url VARCHAR(255),
    promedio_estrellas DECIMAL(3,2) DEFAULT 0
);

CREATE TABLE topicos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL -- Ej: 'Java', 'Ciberseguridad'
);

CREATE TABLE contenido_topicos (
    contenido_id INTEGER REFERENCES contenidos(id) ON DELETE CASCADE,
    topico_id INTEGER REFERENCES topicos(id) ON DELETE CASCADE,
    PRIMARY KEY (contenido_id, topico_id)
);

CREATE TABLE secciones_info (
    id SERIAL PRIMARY KEY,
    contenido_id INTEGER REFERENCES contenidos(id) ON DELETE CASCADE,
    subtitulo VARCHAR(255),
    cuerpo_texto TEXT NOT NULL,
    orden INTEGER -- Para saber qué párrafo va primero
);

-- 5. Crear tabla de Reseñas (Evaluación de 1 a 5 estrellas)
CREATE TABLE resenas (
    id SERIAL PRIMARY KEY,
    usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
    contenido_id INTEGER REFERENCES contenidos(id) ON DELETE CASCADE,
    estrellas INTEGER CHECK (estrellas >= 1 AND estrellas <= 5),
    comentario TEXT,
    fecha_resena TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT unica_resena_por_usuario UNIQUE (usuario_id, contenido_id)
);

-- 6. Crear tabla de Guardados (Relación Muchos a Muchos)
CREATE TABLE guardados (
    usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
    contenido_id INTEGER REFERENCES contenidos(id) ON DELETE CASCADE,
    fecha_guardado TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (usuario_id, contenido_id)
);

-- Inserción de datos iniciales para pruebas
INSERT INTO roles (nombre_rol) VALUES ('admin'), ('maestro'), ('estudiante');
INSERT INTO materias (nombre_materia) VALUES ('Programación');