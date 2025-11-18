package br.com.martinperez.conversor;

import br.com.martinperez.conversor.domain.SupportedCurrencies;
import br.com.martinperez.conversor.service.CurrencyConverter;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static final String RESET = "\u001B[0m";
    static final String CYAN = "\u001B[36m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String RED = "\u001B[31m";

    static final DecimalFormat df = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();
        boolean running = true;

        // Dados da última conversão
        String lastFrom = null;
        String lastTo = null;
        double lastAmount = 0;
        double lastResult = 0;
        boolean hasLastConversion = false;

        List<String> history = new ArrayList<>();

        System.out.println(CYAN + "============================================" + RESET);
        System.out.println(CYAN + "     🌎  Conversor de Monedas – LATAM  💱" + RESET);
        System.out.println(CYAN + "============================================" + RESET);

        while (running) {
            System.out.println();
            System.out.println(GREEN + "Seleccione una opción:" + RESET);
            System.out.println("1) Nueva conversión");
            System.out.println("2) Repetir última conversión");
            System.out.println("3) Ver historial de la sesión");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 0) {
                System.out.println(GREEN + "Gracias por usar el conversor. ¡Hasta luego!" + RESET);
                running = false;

            } else if (option == 1) {
                // NOVA CONVERSÃO
                System.out.println();
                System.out.println(CYAN + "Monedas disponibles:" + RESET);

                for (int i = 0; i < SupportedCurrencies.LIST.length; i++) {
                    System.out.println((i + 1) + ") " + SupportedCurrencies.LIST[i]);
                }

                System.out.print("\nElige el número de la moneda de origen: ");
                int fromIndex = scanner.nextInt();
                scanner.nextLine();

                if (fromIndex < 1 || fromIndex > SupportedCurrencies.LIST.length) {
                    System.out.println(RED + "Opción inválida para moneda de origen." + RESET);
                    continue;
                }

                System.out.print("Elige el número de la moneda de destino: ");
                int toIndex = scanner.nextInt();
                scanner.nextLine();

                if (toIndex < 1 || toIndex > SupportedCurrencies.LIST.length) {
                    System.out.println(RED + "Opción inválida para moneda de destino." + RESET);
                    continue;
                }

                String fromCurrency = SupportedCurrencies.LIST[fromIndex - 1];
                String toCurrency = SupportedCurrencies.LIST[toIndex - 1];

                if (fromCurrency.equals(toCurrency)) {
                    System.out.println(YELLOW + "La moneda de origen y destino no pueden ser iguales." + RESET);
                    continue;
                }

                System.out.print("Ingrese el valor a convertir: ");
                double amount = scanner.nextDouble();
                scanner.nextLine();

                try {
                    double result = converter.convert(fromCurrency, toCurrency, amount);

                    System.out.println();
                    System.out.println(GREEN + "Resultado:" + RESET);
                    System.out.printf("%s %s equivalen a %s %s%n",
                            df.format(amount), fromCurrency,
                            df.format(result), toCurrency);

                    // salvar como última conversão bem-sucedida
                    lastFrom = fromCurrency;
                    lastTo = toCurrency;
                    lastAmount = amount;
                    lastResult = result;
                    hasLastConversion = true;

                    // registrar no histórico
                    String record = String.format(
                            "%s %s → %s %s",
                            df.format(amount), fromCurrency,
                            df.format(result), toCurrency
                    );
                    history.add(record);


                } catch (RuntimeException e) {
                    System.out.println(RED + "Error durante la conversión: " + e.getMessage() + RESET);
                }

            } else if (option == 2) {
                // REPETIR ÚLTIMA CONVERSÃO

                if (!hasLastConversion) {
                    System.out.println(YELLOW + "No hay conversión previa para repetir." + RESET);
                    continue;
                }

                System.out.println();
                System.out.println(CYAN + "Repitiendo conversión previa:" + RESET);
                System.out.println("De: " + lastFrom);
                System.out.println("A : " + lastTo);
                System.out.println("(Última cantidad: " + df.format(lastAmount) + " " + lastFrom + ")");
                System.out.println();

                System.out.print("Ingrese un nuevo valor para convertir: ");
                double newAmount = scanner.nextDouble();
                scanner.nextLine();

                try {
                    double newResult = converter.convert(lastFrom, lastTo, newAmount);

                    System.out.println();
                    System.out.println(GREEN + "Resultado:" + RESET);
                    System.out.printf("%s %s equivalen a %s %s%n",
                            df.format(newAmount), lastFrom,
                            df.format(newResult), lastTo);

                    // atualizar última conversão
                    lastAmount = newAmount;
                    lastResult = newResult;

                    String record = String.format(
                            "%s %s → %s %s",
                            df.format(newAmount), lastFrom,
                            df.format(newResult), lastTo
                    );
                    history.add(record);

                } catch (RuntimeException e) {
                    System.out.println(RED + "Error durante la conversión: " + e.getMessage() + RESET);
                }

            } else if (option == 3) {
                // VER HISTÓRICO DA SESSÃO
                System.out.println();
                if (history.isEmpty()) {
                    System.out.println(YELLOW + "Aún no hay conversiones en esta sesión." + RESET);
                } else {
                    System.out.println(CYAN + "Historial de esta sesión:" + RESET);
                    for (String record : history) {
                        System.out.println("- " + record);
                    }
                }

            } else {
                System.out.println(RED + "Opción inválida. Intente nuevamente." + RESET);
            }
        }

        scanner.close();
    }
}
