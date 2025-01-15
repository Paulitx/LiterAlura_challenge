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


![image](https://github.com/user-attachments/assets/626cec7f-456a-4337-af62-7df3b8c44c8d)

### Buscar Libro por nombre y respectivas excepciones
![image](https://github.com/user-attachments/assets/4992c4b8-3659-49b0-8f7c-e9af5f664e69)

![image](https://github.com/user-attachments/assets/9b78674f-4728-4a7f-bb5f-9c6de1396d1e)

### Listar libros almacenados

![image](https://github.com/user-attachments/assets/93f5175e-60d4-4354-8c0e-645ec216a3d1)

### Listar Autores almacenados

![image](https://github.com/user-attachments/assets/c299eb4c-b12f-46b8-be51-3b1c57209259)

### Listar autores vivos en un año específico

![image](https://github.com/user-attachments/assets/26c72475-23a1-4293-95c9-a5f54a9027d2)

![image](https://github.com/user-attachments/assets/79fe8480-6612-4bd0-8c6b-91761edbadf5)

### Listar libros por idioma

![image](https://github.com/user-attachments/assets/6c459c67-a347-4b73-8c5c-10096404dab6)

![image](https://github.com/user-attachments/assets/42700a64-a846-495e-bcdb-03ecb6370844)

### Tablas base de datos de autores y libros

![image](https://github.com/user-attachments/assets/18e95c18-81a8-4257-bb65-946350faf164)

![image](https://github.com/user-attachments/assets/cfda8fe7-45da-47c1-8aad-559df8b622c4)


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
   https://github.com/Paulitx/LiterAlura.git
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
