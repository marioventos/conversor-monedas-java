import api.ApiClient;
import model.ExchangeResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        String apiKey = "7ba534481457558ccfb7eef6";
        String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

        try {
            ExchangeResponse response = ApiClient.obtenerTasas(url);

            if (response == null) {
                System.out.println("Error: la API no devolvió datos.");
                return;
            }

            Scanner scanner = new Scanner(System.in);

            Map<String, Double> tasas = response.getConversion_rates();

            List<String> historial = new ArrayList<>();

            while (true) {
                System.out.println("\n=== Conversor de Monedas ===");
                System.out.println("1. USD -> CLP");
                System.out.println("2. CLP -> USD");
                System.out.println("3. USD -> EUR");
                System.out.println("4. EUR -> USD");
                System.out.println("5. USD -> ARS");
                System.out.println("6. USD -> BRL");
                System.out.println("7. GBP -> USD");
                System.out.println("8. Ver historial de conversiones");
                System.out.println("0. Salir");
                System.out.println("Elige una opción.");

                String opcion = scanner.nextLine();

                if (opcion.equals("0")) {
                    System.out.println("¡Hasta luego!");
                    break;
                }

                if (opcion.equals("8")) {
                    System.out.println("¿Desea ver el historial?");
                    System.out.println("1. Sí");
                    System.out.println("2. No");

                    String confirmar = scanner.nextLine();

                    if (confirmar.equals("2")) {
                        System.out.println("Volviendo al menú...");
                        continue;
                    }

                    if (confirmar.equals("1")) {
                        if (historial.isEmpty()) {
                            System.out.println("No hay conversiones registradas todavía.");
                        } else {
                            System.out.println("\n--- Historial de Conversiones ---");
                            for (String registro : historial) {
                                System.out.println(registro);
                            }
                        }
                        continue;
                    }
                }

                double monto = 0;

                while (true) {
                    System.out.println("Ingrese monto a convertir: ");
                    String entrada = scanner.nextLine();

                    try {
                        monto = Double.parseDouble(entrada);
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: monto a convertir no valido.");
                    }
                }

                double resultado = 0;

                switch (opcion) {
                    case "1" -> resultado = monto * tasas.get("CLP");
                    case "2" -> resultado = monto / tasas.get("CLP");
                    case "3" -> resultado = monto * tasas.get("EUR");
                    case "4" -> resultado = monto / tasas.get("EUR");
                    case "5" -> resultado = monto * tasas.get("ARS");
                    case "6" -> resultado = monto * tasas.get("BRL");
                    case "7" -> resultado = monto / tasas.get("GBP");

                    default -> {
                        System.out.println("Opción inválida. Intente nuevamente.");
                        continue;
                    }
                }

                System.out.println("Resultado: " + resultado);
                historial.add("Monto: " + monto + " | Resultado: " + resultado + " | Opción: " + opcion);
            }

        } catch (Exception e) {
            System.out.println("Error al consumir su API: " + e.getMessage());
        }
    }
}