package com.example.LiterAlura.repository;

import com.example.LiterAlura.model.Autor;
import com.example.LiterAlura.model.Lenguaje;
import com.example.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Buscar un autor por nombre
    @Query("SELECT a FROM Autor a WHERE a.nombre LIKE %:nombre%")
    Optional<Autor> buscarAutorNombre(@Param("nombre") String nombre);

    // Buscar un libro por título
    @Query("SELECT l FROM Libro l WHERE l.titulo LIKE %:titulo%")
    Optional<Libro> buscarLibroTitulo(@Param("titulo") String titulo);

    //Listar libros registrados en la base de datos
    @Query("SELECT l FROM Autor a JOIN a.libros l ORDER BY l.titulo")
    List<Libro> librosRegistrados();

    //Listar los autores con vida en un año especifico
    @Query("SELECT a FROM Autor a WHERE a.anoNacimiento <= :fecha AND a.anoFallecimiento > :fecha")
    List<Autor> listarAutoresVivos(@Param("fecha") Integer fecha);

    //Listar libros seleccionados por idiomas
    @Query("SELECT l FROM Autor a JOIN a.libros l WHERE l.idioma = :idioma")
    List<Libro> librosPorIdioma(@Param("idioma") Lenguaje idioma);

}
