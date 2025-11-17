package br.com.martinperez.conversor;

import br.com.martinperez.conversor.domain.SupportedCurrencies;
import br.com.martinperez.conversor.service.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        boolean running = true;

        System.out.println("Bienvenido al conversor de monedas 💱");

        while (running) {
            System.out.println();
            System.out.println("Seleccione una opción:");
            System.out.println("1) Nueva conversión");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                running = false;
            } else if (option == 1) {

                System.out.println();
                System.out.println("Monedas disponibles:");
                for (int i = 0; i < SupportedCurrencies.LIST.length; i++) {
                    System.out.println((i + 1) + ") " + SupportedCurrencies.LIST[i]);
                }

                System.out.print("\nElige el número de la moneda de origen: ");
                int fromIndex = scanner.nextInt();
                scanner.nextLine();

                if (fromIndex < 1 || fromIndex > SupportedCurrencies.LIST.length) {
                    System.out.println("Opción inválida para moneda de origen. Intente nuevamente.");
                    continue;
                }

                System.out.print("Elige el número de la moneda de destino: ");
                int toIndex = scanner.nextInt();
                scanner.nextLine();

                if (toIndex < 1 || toIndex > SupportedCurrencies.LIST.length) {
                    System.out.println("Opción inválida para moneda de destino. Intente nuevamente.");
                    continue;
                }

                String fromCurrency = SupportedCurrencies.LIST[fromIndex - 1];
                String toCurrency = SupportedCurrencies.LIST[toIndex - 1];


                // Valor a convertir
                System.out.print("Ingrese el valor a convertir: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                try {
                    double result = converter.convert(fromCurrency, toCurrency, amount);

                    System.out.println();
                    System.out.printf("%.2f %s equivalen a %.2f %s%n",
                            amount, fromCurrency, result, toCurrency);

                } catch (RuntimeException e) {
                    System.out.println("Error durante la conversión: " + e.getMessage());
                }

            } else {
                System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }
}
