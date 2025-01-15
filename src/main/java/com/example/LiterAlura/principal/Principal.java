package com.example.LiterAlura.principal;

public class Principal {

    public Principal() {}

    public void mostrarMenu(){
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
                    """;
            
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
        }
    }

    private void listarLibrosIdiomas() {
    }

    private void listAutoresVida() {
    }

    private void listarAutoresRegis() {
    }

    private void listarLibrosRegis() {
    }

    private void buscarLibroTitulo() {
    }
}
