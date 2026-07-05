package io.github.lucasnsnt.unemployment_killer.utils;

public class JsonSanitizer {

    private JsonSanitizer() {
        throw new UnsupportedOperationException("Classe utilitária não instanciada");
    }

    public static String jsonSanitizer(String rawText) {

        int startIndex = rawText.indexOf("{");
        int endIndex = rawText.lastIndexOf("}");

        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            if(endIndex - startIndex <= 1) {
                throw new IllegalArgumentException("JSON string is empty"); // throw simplificada
            }
            return rawText.substring(startIndex, endIndex + 1);
        } else {
            throw new IllegalArgumentException("Invalid JSON string"); // throw simplificada
        }

    }

}
