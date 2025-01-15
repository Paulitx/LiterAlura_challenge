package com.example.LiterAlura.principal;

import com.example.LiterAlura.model.*;
import com.example.LiterAlura.repository.AutorRepository;
import com.example.LiterAlura.service.ConsumoAPI;
import com.example.LiterAlura.service.ConvierteDatos;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private static final String URL_BASE = "https://gutendex.com/books/";
    private ConvierteDatos conversor = new ConvierteDatos();
    private AutorRepository repository;
    private List<Libro> libros;
    private List<Autor> autores;


    public Principal(AutorRepository repository) {
        this.repository = repository;
    }

    public void mostrarMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    -------------------------Menu-------------------------
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores con vida por año determinado
                    5 - Listar libros por idiomas
                    0 - Salir
                    
                    Por favor inserta una opcion: 
                    """;
            System.out.println(menu);
            try {
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibroTitulo();
                        break;
                    case 2:
                        listarLibrosRegis();
                        break;
                    case 3:
                        listarAutoresRegis();
                        break;
                    case 4:
                        listAutoresVida();
                        break;
                    case 5:
                        listarLibrosIdiomas();
                        break;
                    case 0:
                        System.out.println("Saliendo de la aplicacion...");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
        }
    }

    //Se busca el libro desde la API y se registra en la base de datos
    private void buscarLibroTitulo() {
        System.out.println("Ingresa el título del libro que desea buscar");
        try {
            String titulo = scanner.nextLine().toLowerCase();

            String url = URL_BASE + "?search=" + titulo.replace(" ", "+");
            String json = consumoApi.obtenerDatos(url);

            if (json.isEmpty() || !json.contains("\"count\":0,\"next\":null,\"previous\":null,\"results\":[]")) {
                var datos = conversor.obtenerDatos(json, Datos.class);

                Optional<DatosLibro> libroBuscado = datos.libros().stream()
                        .filter(libro -> libro.titulo().toLowerCase().contains(titulo))
                        .findFirst();

                //Comprobar si se encontro la busqueda y se muestra
                if (libroBuscado.isPresent()) {
                    DatosLibro libro = libroBuscado.get();

                    System.out.println("\n----------LIBRO----------" +
                            "\nTítulo: " + libro.titulo() +
                            "\nAutor: " + libro.autores().stream().map(a -> a.nombre()).limit(1).collect(Collectors.joining()) +
                            "\nIdioma: " + libro.idioma().stream().collect(Collectors.joining()) +
                            "\nDescargas: " + libro.numDescargas() +
                            "\n-------------------------\n"
                    );

                        String nombreAutor = libro.autores().stream().map(a -> a.nombre()).collect(Collectors.joining());
                        Optional<Autor> autorRegis = repository.buscarAutorNombre(nombreAutor);

                        Optional<Libro> libroRegis = repository.buscarLibroTitulo(titulo);

                        //Comprueba si el libro ya se encuentra en la base de datos y de lo contrario, lo agrega
                        if (libroRegis.isPresent()) {
                            System.out.println("\nEl libro ya se encuentra dentro de la base de datos.\n");
                        } else {
                            Autor autorComp = autorRegis.orElseGet(() -> {
                                Autor nuevoAutor = new Autor(libro.autores().stream().findFirst().orElseThrow());
                                repository.save(nuevoAutor);
                                System.out.println("El libro se ha registrado con exito.");
                                return nuevoAutor;
                            });
                            autorComp.setLibros(List.of(new Libro(libro)));
                            repository.save(autorComp);
                        }

                } else {
                    System.out.println("Libro no encontrado");
                }
            } else {
                System.out.println("Error en la busqueda dentro de la API, libro no encontrado");
            }
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    //Busca y muestra todos los libros registrados dentro de la base de datos
    private void listarLibrosRegis () {
        try {
            libros = repository.librosRegistrados();
            libros.stream().sorted(Comparator.comparing(Libro::getTitulo)).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    //Busca y muestra todos los autores registrados dentro de la base de datos
    private void listarAutoresRegis () {
        try {
            autores = repository.findAll();
            autores.stream().sorted(Comparator.comparing(Autor::getNombre)).forEach(System.out::println);

        } catch(Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    //Busca y muestra todos los autores registrados dentro de la base de datos que se encuentren con vida en un año específico
    private void listAutoresVida () {
        System.out.println("Ingresar el año en el que desea verificar el autor que quiere consultar");
        try {
            var fecha = Integer.parseInt(scanner.nextLine());
            List<Autor> autoresVida = repository.listarAutoresVivos(fecha);
            if (autoresVida.isEmpty()) {
                System.out.println("No se encontro ningun actor con vida en el plazo del año " + fecha);

            } else {
                autoresVida.stream().sorted(Comparator.comparing(Autor::getNombre)).forEach(System.out::println);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }

    //Busca y lista todos los libros registrados dentro de la base de datos de un idioma específico
    private void listarLibrosIdiomas () {
        var menuIdioma = """
                   es - Español
                   en - English
                   fr - Français
                   pt - Português
                    
                   "Ingrese el idioma de los libros que quiere consultar"
                   """;
        System.out.println(menuIdioma);
        try {
            var idioma = scanner.nextLine().toLowerCase();
            if (idioma.equals("es") || idioma.equals("en") || idioma.equals("fr") || idioma.equals("pt")) {
                var lenguaje = Lenguaje.fromString(idioma);
                List<Libro> libroIdioma = repository.librosPorIdioma(lenguaje);
                if (libroIdioma.isEmpty()) {
                    System.out.println("No existen registros de libros en el idioma " + lenguaje);
                } else {
                    System.out.println("Libros en idioma " + lenguaje);
                    libroIdioma.forEach(System.out::println);
                }
            } else {
                System.out.println("Opcion invalida, vuelva a intentar");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}
