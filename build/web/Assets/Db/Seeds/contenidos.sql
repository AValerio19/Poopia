-- Asumiendo que tus materias tienen IDs específicos (ej: 1 para Programación, 2 para Ciberseguridad)
-- Puedes ajustar el 'materia_id' según tus registros actuales en la tabla 'materias'.

INSERT INTO contenidos (materia_id, titulo, publicador, fecha_publicacion, cuerpo_texto, imagen_url, promedio_estrellas)
VALUES 
(
    1, 
    'Clean Code: A Handbook of Agile Software Craftsmanship', 
    'Prentice Hall', 
    '2008-08-01', 
    'Incluso el código malo puede funcionar. Pero si el código no es limpio, puede acabar con una empresa de desarrollo. Este libro detalla las mejores prácticas para escribir código elegante y mantenible, centrándose en el uso de nombres significativos, funciones pequeñas y la eliminación de código redundante.', 
    'clean-code.jpg', 
    4.80
),
(
    2, 
    'The Art of Invisibility', 
    'Little, Brown and Company', 
    '2017-02-14', 
    'Kevin Mitnick, el hacker más famoso del mundo, explica cómo las empresas y los gobiernos rastrean cada uno de nuestros movimientos en línea. La obra funciona como una guía de ciberseguridad personal, enseñando tácticas para proteger la identidad y mantener la privacidad en una era de vigilancia constante.', 
    'invisibility.jpg', 
    4.50
),
(
    1, 
    'Introduction to Algorithms', 
    'MIT Press', 
    '2009-07-31', 
    'Conocido comúnmente como CLRS, este libro es la referencia estándar para el diseño y análisis de algoritmos. Cubre desde estructuras de datos básicas hasta algoritmos complejos de grafos y flujos de redes, siendo esencial para cualquier estudiante de ciencias de la computación que aspire a la excelencia técnica.', 
    'clrs.jpg', 
    4.90
);