package conversor;

import java.util.Scanner;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);
        ConsultarConversion consulta = new ConsultarConversion();

        // Obtener las tasas desde la API (base USD)
        ConversionDolares conversion;
        try {
            conversion = consulta.buscarConversion("");
        } catch (Exception e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
            System.out.println("No se puede continuar sin tasas.");
            menu.close();
            return;
        }

        Map<String, Double> tasas = conversion.conversion_rates();

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("\nMenu\n" +
                    "1) Dólar ==> Peso Argentino\n" +
                    "2) Peso Argentino ==> Dólar\n" +
                    "3) Dólar ==> Real Brasileño\n" +
                    "4) Real Brasileño ==> Dólar\n" +
                    "5) Dólar ==> Peso Colombiano\n" +
                    "6) Peso Colombiano ==> Dólar\n" +
                    "7) Salir");

            if (menu.hasNextInt()) {
                opcion = menu.nextInt();
            } else {
                System.out.println("Por favor ingrese un número válido.");
                menu.next(); // Limpia entrada incorrecta
                continue;
            }

            double cantidad, resultado;

            // Obtenemos las tasas actualizadas desde el mapa
            double tasaUSDaARS = tasas.getOrDefault("ARS", 0.0);
            double tasaUSDaBRL = tasas.getOrDefault("BRL", 0.0);
            double tasaUSDaCOP = tasas.getOrDefault("COP", 0.0);

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad * tasaUSDaARS;
                    System.out.printf("%.2f USD son %.2f ARS%n", cantidad, resultado);
                    break;
                case 2:
                    System.out.print("Ingrese cantidad en ARS: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad / tasaUSDaARS;
                    System.out.printf("%.2f ARS son %.2f USD%n", cantidad, resultado);
                    break;
                case 3:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad * tasaUSDaBRL;
                    System.out.printf("%.2f USD son %.2f BRL%n", cantidad, resultado);
                    break;
                case 4:
                    System.out.print("Ingrese cantidad en BRL: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad / tasaUSDaBRL;
                    System.out.printf("%.2f BRL son %.2f USD%n", cantidad, resultado);
                    break;
                case 5:
                    System.out.print("Ingrese cantidad en USD: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad * tasaUSDaCOP;
                    System.out.printf("%.2f USD son %.2f COP%n", cantidad, resultado);
                    break;
                case 6:
                    System.out.print("Ingrese cantidad en COP: ");
                    cantidad = menu.nextDouble();
                    resultado = cantidad / tasaUSDaCOP;
                    System.out.printf("%.2f COP son %.2f USD%n", cantidad, resultado);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Ingrese un número entre 1 y 7.");
                    break;
            }
        }

        menu.close();
    }
}
