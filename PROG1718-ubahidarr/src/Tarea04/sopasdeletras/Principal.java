/*
 * Clase Principal para el Proyecto SopasDeLetras.
 */
package sopasdeletras;

import Tarea04.sopasdeletras.SopaLetras;
import utilidades.ES;

/**
 * <p>
 * Clase de prueba para el proyecto de sopas de letras.</p>
 * <p>
 * Contiene el programa principal que permite probar el funcionamiento de la
 * clase <code>SopaLetras.</code></p>
 * <p>
 * Lleva a cabo las siguientea acciones:</p>
 * <ol>
 * <li>Solicitar por teclado el número de filas y de columnas para una nueva
 * sopa de letras.</li>
 * <li>Crear la sopa de letras.</li>
 * <li>Pedir por teclado una palabra para insertar en la sopa de letras.
 * Comprobar que esa palabra es válida. Si no es así, volver a pedir otra
 * palabra hasta que se cumplan los requisitos.</li>
 * <li>Solicitar la ubicación (fila y columna) de la primera letra de la palabra
 * que se desea colocar, así como la dirección de inserción (horizontal,
 * vertical, diagonal1, diagonal2).</li>
 * <li>Comprobar si con esa información de colocación (ubicación de la primera
 * letra más la dirección de inserción) es posible incrustar la palabra en la
 * sopa de letras. Si la inserción es posible, se llevará a cabo y así se
 * indicará por pantalla. Si no es posible, no se hará la inserción y también se
 * informará de ello.</li>
 * <li>Por último preguntará si se quiere continuar iterando en el programa,
 * intentando insertar una nueva palabra en la sopa de letras.</li>
 * <li>Cuando finalmente no se deseen insertar más palabras, el bucle principal
 * de la aplicación finalizará y mostrará el contenido completo de la sopa de
 * letras con todas las palabras que han podido ser colocadas.</li>
 * </ol>
 *
 * @author Profesor
 */
public class Principal {

    /**
     * @param args Argumentos del intérprete de órdenes (command line)
     */
    public static void main(String[] args) {

        // Máximo y mínimo número de filas y columnas permitido
        final int maxFilasColumnas = 20;
        final int minFilasColumnas = 5;

        // Presentación del programa
        // -------------------------
        ES.msgln("GENERADOR DE SOPAS DE LETRAS");
        ES.msgln("----------------------------");

        // Creación de la sopa de letras
        // -------------------------------
        // Solicitamos por teclado el número de filas que tendrá la sopa
        int numFilas = ES.leeEntero("\nEscribe el número de filas que tendrá la sopa de letras (" + minFilasColumnas + "-" + maxFilasColumnas + "):", minFilasColumnas, maxFilasColumnas);

        // Solicitamos por teclado el número de columnas que tendrá la sopa
        int numColumnas = ES.leeEntero("\nEscribe el número de columnas que tendrá la sopa de letras (" + minFilasColumnas + "-" + maxFilasColumnas + "):", minFilasColumnas, maxFilasColumnas);

        // Creamos la sopa con el constructor con parámetros pasándole los valores leídos por teclado
        SopaLetras sopa = new SopaLetras(numFilas, numColumnas);
        System.out.println("\nSopa de letras de tamaño " + numFilas + "x" + numColumnas + " creada.");

        // Introducción de palabras de la sopa de letras
        // ---------------------------------------------
        int respuesta;
        do {

            String palabra;
            boolean palabraValida;
            do {
                // Solicitamos por teclado la palabra que deseamos insertar en la sopa.
                palabra = ES.leeCadena("\nEscribe la palabra que quieres insertar en la sopa de letras:");

                // Comprobamos si palabra es válida según las reglas de la sopa de letras
                palabraValida = SopaLetras.compruebaSiEsValida(palabra);
                if (!palabraValida) {
                    ES.msgln("\nLa palabra \"" + palabra + "\" no es válida para su inserción en la sopa de letras.");
                }
            } while (!palabraValida);

            // Solicitamos por teclado la fila a partir de donde se colocará la palabra en la sopa
            int fila = ES.leeEntero("\nEscribe la fila a partir de la que se colocará la palabra en la sopa de letras (" + 0 + "-" + (sopa.getNumFilas() - 1) + "):", 0, sopa.getNumColumnas() - 1);

            // Solicitamos por teclado la columna a partir de donde se colocará la palabra en la sopa
            int columna = ES.leeEntero("\nEscribe la columna a partir de la que se colocará la palabra en la sopa de letras (" + 0 + "-" + (sopa.getNumFilas() - 1) + "):", 0, sopa.getNumColumnas() - 1);

            // Solicitamos por teclado la dirección en la que deseamos insertar la palabra en la sopa.           
            int direccionNumerica = ES.leeEntero("\nEscribe la dirección en la que quieres que se escriba la palabra (1-> HORIZONTAL, 2-> VERTICAL, 3-> DIAGONAL1, 4->DIAGONAL2):", 1, 4);

            // Pasamos el entero introducido al tipo enumerado correspondiente       
            SopaLetras.Direccion direccion = SopaLetras.enteroADireccion(direccionNumerica);

            // Comprobamos si la palabra "cabe" en la sopa
            if (sopa.compruebaSiCabe(palabra, fila, columna, direccion)) {
                // Si la palabra cabe, la colocamos
                sopa.colocaPalabra(palabra, fila, columna, direccion);
                ES.msgln("\nColocada la palabra \"" + palabra + "\" en la posición (" + fila + ", " + columna + ") en dirección " + direccion + ".");
            } else {
                // Si la palabra no cabe, lo indicamos por pantalla
                ES.msgln("\nLa palabra \"" + palabra + "\" no cabe en la posición (" + fila + ", " + columna + ") en dirección " + direccion + ".");
            }

            // Pedir por teclado un 1 para seguir iterando o un 0 para terminar la ejecución
            respuesta = ES.leeEntero("\n¿Desea colocar otra palabra en la sopa de letras? (1->para seguir / 0->para terminar)", 0, 1);

        } while (respuesta != 0);

        // Salida por pantalla de la sopa de letras
        // ----------------------------------------
        ES.msgln("\nPROCESO FINALIZADO: CONTENIDO DE LA SOPA DE LETRAS DE " + sopa.getNumFilas() + "x" + sopa.getNumColumnas());
        ES.msgln(sopa.toString());
    }
}
