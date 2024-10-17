package Service;

import Api.ConversorApi;
import Enum.CodigoMoneda;
import Model.Conversion;

import java.util.Scanner;

public class ConversorService {

    public static void convertir(Scanner scanner) {
        String monedaOrigen = solicitudMoneda(scanner, "origen");
        String monedaDestino = solicitudMoneda(scanner, "destino");
        int monto = solicitudMonto(scanner);

        ConversorApi consultaApi = new ConversorApi();
        Conversion resultado = consultaApi.convertir(monedaOrigen, monedaDestino, monto);
        System.out.println("\n********************************************************************");
        System.out.println(monto + " [" + monedaOrigen + "] es igual a " + resultado.conversion_result() + " [" + monedaDestino + "]");
        System.out.println("********************************************************************\n");

    }

    private static String solicitudMoneda(Scanner scanner, String tipoMoneda) {
        String moneda = "";
        boolean informacionCorrecta = false;

        while (!informacionCorrecta) {
            // Moneda
            System.out.printf("¿Qué moneda es la de %s? ", tipoMoneda);
            moneda = scanner.nextLine().toUpperCase();

            informacionCorrecta = CodigoMoneda.exists(moneda);

            if (!informacionCorrecta) {
                System.out.println("\t¡La información digitada es errónea, intente de nuevo!");
            }
        }
        return moneda;
    }

    private static int solicitudMonto(Scanner scanner) {
        int monto = 0;
        boolean informacionCorrecta = false;

        while (!informacionCorrecta) {
            // Monto a convertir
            try {
                System.out.print("¿Cuál es el monto que desea convertir? ");
                monto = scanner.nextInt();
                informacionCorrecta = true;
            } catch (Exception e) {
                informacionCorrecta = false;
            }
            scanner.nextLine(); // Limpiar el buffer después de nextDouble()

            if (!informacionCorrecta) {
                System.out.println("\t¡La información digitada es errónea, intente de nuevo!");
            }
        }
        return monto;
    }

}
