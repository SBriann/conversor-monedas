import Service.ConversorService;
import Util.MensajeConsola;

import java.util.Scanner;

public class ConversorApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String listaMonedas = MensajeConsola.construirListaMonedas();
        String opcion = "";
        boolean salir = false;

        System.out.println("""
            ***********************************************************************************
            Bienvenido/a al Conversor de Monedas :)
            ***********************************************************************************
            """);

        while (!salir) {
            MensajeConsola.mostrarMensajeOpciones();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1": {
                    MensajeConsola.mostrarListaMonedas(listaMonedas);
                    ConversorService.convertir(scanner);
                    break;
                }
                case "9": {
                    salir = true;
                    System.out.println("Gracias por usar nuestro sistema...");
                    break;
                }
                default:
                    System.out.println("La opción seleccionada no existe...\n");
            }
        }
    }
}
