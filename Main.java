import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static CurrencyConverter converter = new CurrencyConverter();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Conversor de Moneda");
        System.out.println("Actualizando tasas de cambio...");

        try {
            converter.updateExchangeRates();
        } catch (IOException e) {
            System.out.println("Error al obtener las tasas de cambio. Saliendo...");
            return;
        }

        boolean keepRunning = true;
        while (keepRunning) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1) USD => ARS");
            System.out.println("2) ARS => USD");
            System.out.println("3) USD => BRL");
            System.out.println("4) BRL => USD");
            System.out.println("5) USD => COP");
            System.out.println("6) COP => USD");
            System.out.println("7) CLP => USD");
            System.out.println("8) Exit\n");
            System.out.println("USD: United States Dollar");
            System.out.println("ARS: Argentine Peso");
            System.out.println("BRL: Brazilian Real");
            System.out.println("COP: Colombian Peso");
            System.out.println("CLP: Chilean Peso");

            int choice = scanner.nextInt();
            String fromCurrency = "";
            String toCurrency = "";

            switch (choice) {
                case 1:
                    fromCurrency = "USD";
                    toCurrency = "ARS";
                    break;
                case 2:
                    fromCurrency = "ARS";
                    toCurrency = "USD";
                    break;
                case 3:
                    fromCurrency = "USD";
                    toCurrency = "BRL";
                    break;
                case 4:
                    fromCurrency = "BRL";
                    toCurrency = "USD";
                    break;
                case 5:
                    fromCurrency = "USD";
                    toCurrency = "COP";
                    break;
                case 6:
                    fromCurrency = "COP";
                    toCurrency = "USD";
                    break;
                case 7:
                    fromCurrency = "CLP";
                    toCurrency = "USD";
                    break;
                case 8:
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
            }

            if (keepRunning) {
                System.out.println("Ingrese la cantidad a convertir desde " + fromCurrency + " a " + toCurrency + ":");
                double amount = scanner.nextDouble();
                double result = converter.convert(fromCurrency, toCurrency, amount);
                System.out.printf("%.2f %s equivale a %.2f %s a una tasa de cambio de %.4f%n",
                        amount, fromCurrency, result, toCurrency, converter.getExchangeRates().get(toCurrency).rate());

                System.out.println("¿Desea realizar otra conversión? (s/n)");
                String continueChoice = scanner.next();
                if (continueChoice.equalsIgnoreCase("n")) {
                    keepRunning = false;
                }
            }
        }

        System.out.println("Gracias por usar la aplicación. ¡Hasta luego!");
        scanner.close();
    }
}
