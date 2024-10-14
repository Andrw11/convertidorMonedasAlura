package conversor;

import com.google.gson.Gson;

public class TestGson {
    public static void main(String[] args) {
        // Crear una instancia de Gson
        Gson gson = new Gson();

        // Convertir una cadena a JSON usando Gson
        String json = gson.toJson("Hola, Gson");

        // Imprimir el resultado en formato JSON
        System.out.println(json);  // Esto imprimirá: "Hola, Gson"
    }
}

