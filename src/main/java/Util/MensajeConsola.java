package Util;

import Enum.CodigoMoneda;

public class MensajeConsola {
    public static void mostrarMensajeOpciones() {
        System.out.println("""
                Elija una opción:
                1) Convertir
                9) Salir""");
    }

    public static void mostrarListaMonedas(String listaMonedas) {
        System.out.printf("""
                ***********************************************************************************
                De la siguiente lista de monedas, seleccione aquellas que quiera usar para
                la conversión:
                
                %s
                ***********************************************************************************\n""", listaMonedas);
    }

    public static String construirListaMonedas() {
        int contadorColumnas = 0;
        String listaMonedas = "";

        for (CodigoMoneda codigoMoneda : CodigoMoneda.values()) {
            contadorColumnas++;
            // Se añade codigo moneda a la misma fila
            listaMonedas += "\t[" + codigoMoneda.getCodigoMoneda() + "] " + codigoMoneda.getNombreMoneda();
            if (contadorColumnas == 3) {
                // Se crea una nueva fila
                listaMonedas += "\n";
                contadorColumnas = 0;
            }
        }

        return listaMonedas;
    }
}
