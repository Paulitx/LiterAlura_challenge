package com.example.LiterAlura.principal.model;

import jakarta.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Lenguaje idioma;
    private Integer numeroVentas;

    public Libro() {
    }

    public Libro(DatosLibro d) {
        this.titulo = d.titulo();
        this.idioma = Lenguaje.fromString(d.idioma().split(" ")[0].trim());
        this.numeroVentas = d.numVentas();
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

    @Override
    public String toString() {
        return
                "Id: " + id +
                "\nTitulo: " + titulo +
                "\nAutor: " + autor;
    }
}
