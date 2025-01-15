# Proyecto: Biblioteca API

&#x20; &#x20;

## Índice

1. [Descripción del proyecto](#descripción-del-proyecto)
2. [Estado del proyecto](#estado-del-proyecto)
3. [Tecnologías usadas](#tecnologías-usadas)
4. [Instalación y configuración](#instalación-y-configuración)
5. [Autor](#autor)

---

## Descripción del proyecto

Este proyecto consiste en una aplicación de biblioteca digital desarrollada con Java 17, Spring Boot 3.4.1 y PostgreSQL. Se conecta con la API de [GutenDex](https://gutendex.com/books/) para buscar libros y almacenarlos en una base de datos local (PGAdmin). La aplicación permite realizar las siguientes acciones:

- Buscar libros en la API de GutenDex y registrarlos en la base de datos.
- Visualizar el listado de libros almacenados.
- Consultar el listado de autores.
- Listar libros clasificados por idioma.
- Mostrar autores que estaban vivos en un año específico.

## Estado del proyecto



Actualmente, el proyecto se encuentra concluido, pero podría haber algún tipo de modificación en el futuro.

## Tecnologías usadas

- **Lenguaje:** Java 17
- **Framework:** Spring Boot 3.4.1
- **Dependencias:**
  - PostgreSQL Driver
  - Spring Data JPA
  - Jackson
- **Gestor de dependencias:** Maven
- **Base de datos:** PostgreSQL (PGAdmin)

## Instalación y configuración

### Prerrequisitos

- JDK 17 instalado.
- IntellijIDEA instalado (Recomendado)
- PGAdmin instalado

### Pasos

1. Clonar este repositorio o descargar el archivo:

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   ```

2. Configurar la base de datos PostgreSQL:

   - Crear una base de datos.
   - Actualizar las credenciales en el archivo `application.properties` o `application.yml`:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/nombre_base_datos
     spring.datasource.username=tu_usuario
     spring.datasource.password=tu_contraseña
     ```

3. Ejecutar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Autor

**Paula Vargas**

&#x20;

---

**Nota:** Si tienes sugerencias o encuentras algún error, no dudes en crear un issue o contactar al autor.

