import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ConversorMonedasAlura {
    private static final String API_KEY = "6dfd98a2a3b1b290314a6f4b";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/6dfd98a2a3b1b290314a6f4b/latest/USD";

    public static void main(String[] args) {
        try {
            // Crear cliente y solicitud HTTP
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(API_URL))
                    .build();

            // Enviar la solicitud y obtener la respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Verificar el código de estado de la respuesta
            if (response.statusCode() == 200) {
                System.out.println("Solicitud exitosa.");
                String jsonResponse = response.body(); // Obtener la respuesta JSON
                // System.out.println("Respuesta JSON: " + jsonResponse); // Imprimir la respuesta completa

                // Analizar la respuesta JSON
                JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();

                // Verificar si 'conversion_rates' está presente y obtener tasas de cambio
                if (jsonObject.has("conversion_rates")) {
                    JsonObject rates = jsonObject.getAsJsonObject("conversion_rates");
                    double usdToArs = rates.get("ARS").getAsDouble();
                    double usdToBrl = rates.get("BRL").getAsDouble();
                    double usdToCop = rates.get("COP").getAsDouble();

                    // Interacción con el usuario
                    Scanner scanner = new Scanner(System.in);
                    int opcion;

                    do {
                        System.out.println("Seleccione una opción de conversión:");
                        System.out.println("1. Convertir dólares a pesos argentinos (USD a ARS)");
                        System.out.println("2. Convertir pesos argentinos a dólares (ARS a USD)");
                        System.out.println("3. Convertir dólares a reales brasileños (USD a BRL)");
                        System.out.println("4. Convertir reales brasileños a dólares (BRL a USD)");
                        System.out.println("5. Convertir dólares a pesos colombianos (USD a COP)");
                        System.out.println("6. Convertir pesos colombianos a dólares (COP a USD)");
                        System.out.println("0. Salir");
                        System.out.print("Ingrese su opción: ");
                        opcion = scanner.nextInt();

                        switch (opcion) {
                            case 1:
                                System.out.print("Ingrese la cantidad en dólares: ");
                                double dolaresA = scanner.nextDouble();
                                System.out.println("Equivale a: " + (dolaresA * usdToArs) + " ARS");
                                break;
                            case 2:
                                System.out.print("Ingrese la cantidad en pesos argentinos: ");
                                double pesosA = scanner.nextDouble();
                                System.out.println("Equivale a: " + (pesosA / usdToArs) + " USD");
                                break;
                            case 3:
                                System.out.print("Ingrese la cantidad en dólares: ");
                                double dolaresB = scanner.nextDouble();
                                System.out.println("Equivale a: " + (dolaresB * usdToBrl) + " BRL");
                                break;
                            case 4:
                                System.out.print("Ingrese la cantidad en reales brasileños: ");
                                double realesB = scanner.nextDouble();
                                System.out.println("Equivale a: " + (realesB / usdToBrl) + " USD");
                                break;
                            case 5:
                                System.out.print("Ingrese la cantidad en dólares: ");
                                double dolaresC = scanner.nextDouble();
                                System.out.println("Equivale a: " + (dolaresC * usdToCop) + " COP");
                                break;
                            case 6:
                                System.out.print("Ingrese la cantidad en pesos colombianos: ");
                                double pesosC = scanner.nextDouble();
                                System.out.println("Equivale a: " + (pesosC / usdToCop) + " USD");
                                break;
                            case 0:
                                System.out.println("Saliendo...");
                                break;
                            default:
                                System.out.println("Opción no válida. Intente de nuevo.");
                        }
                    } while (opcion != 0);
                    scanner.close();
                } else {
                    System.out.println("No se encontró el objeto 'conversion_rates' en la respuesta JSON.");
                }
            } else {
                System.out.println("Error en la solicitud. Código de estado: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
