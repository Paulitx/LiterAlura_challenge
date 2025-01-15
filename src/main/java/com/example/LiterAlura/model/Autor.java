package com.example.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "autores")
public class Autor {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long Id;
   @Column(unique = true)
   private String nombre;
   private Integer anoNacimiento;
   private Integer anoFallecimiento;
   @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
   private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor d) {
        this.nombre = d.nombre();
        this.anoNacimiento = d.anoNacimiento();
        this.anoFallecimiento = d.anoFallecimiento();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(int anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public int getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public void setAnoFallecimiento(int anoFallecimiento) {
        this.anoFallecimiento = anoFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l -> l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return
                "\n----------AUTOR----------" +
                "\nNombre: " + nombre +
                "\nAño de Nacimiento: " + anoNacimiento +
                "\nAño de fallecimiento: " + anoFallecimiento +
                "\nLibros: " + libros.stream().map(Libro::getTitulo).collect(Collectors.joining(", ")) +
                "\n-------------------------";
    }
}
