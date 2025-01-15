package com.example.LiterAlura.model;

public enum Lenguaje {
    Español("es"), Inglés("en"), Francés("fr"), Portugués("pt");

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
