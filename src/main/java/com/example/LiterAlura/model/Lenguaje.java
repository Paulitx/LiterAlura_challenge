package com.example.LiterAlura.principal.model;

public enum Lenguaje {
    Espanol("es"), Ingles("en"), Frances("fr"), Portugues("pt");

    private String lenguajeDim;

    Lenguaje (String lenguajeDim) {
        this.lenguajeDim = lenguajeDim;
    }

    public static Lenguaje fromString(String text) {
        for (Lenguaje lenguaje : Lenguaje.values()) {
            if (lenguaje.lenguajeDim.equalsIgnoreCase(text)) {
                return lenguaje;
            }
        }
        throw new IllegalArgumentException("No se encontro el lenguaje " + text);
    }
}
