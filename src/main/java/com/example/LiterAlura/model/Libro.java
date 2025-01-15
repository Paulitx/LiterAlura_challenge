package com.example.LiterAlura.model;

import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Lenguaje idioma;
    private Integer numDescargas;

    public Libro() {
    }

    public Libro(DatosLibro d) {
        this.titulo = d.titulo();
        this.idioma = Lenguaje.fromString(d.idioma().stream().limit(1).collect(Collectors.joining()));
        this.numDescargas = d.numDescargas();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Lenguaje getIdioma() {
        return idioma;
    }

    public void setIdioma(Lenguaje idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroVentas() {
        return numDescargas;
    }

    public void setNumeroVentas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }

    @Override
    public String toString() {
        return
                "\n----------LIBRO----------" +
                "\nTitulo: " + titulo +
                "\nAutor: " + getAutor().getNombre() +
                "\nIdioma: " + idioma +
                "\nNumero de Descargas: " + numDescargas +
                "\n-------------------------";
    }
}
