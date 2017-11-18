package Tarea3.caja;

import Tarea3.caja.Caja.Material;
import Tarea3.caja.utilidades.ES;

/**
 * Clase principal del programa, que consiste en un bucle do-while que estar�
 * iterando continuamente mientras que el usuario no introduzca un 0.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int respuesta = 1;
        int columnas, filas, materialNum;
        char caracter;
        Material material;
        //Apertura del bucle
        while (respuesta == 1) {
            // Escribir por pantalla: Primero vamos a crear la caja.
            ES.msgln("Primero vamos a crear la caja.");
            // Pedir por teclado el car�cter con el que se dibujar� la caja
            caracter = ES.leeCaracter("Escriba un carácter para dibujar la caja");

            // Pedir por teclado el n�mero de columnas que tendr� la caja
            columnas = ES.leeEntero("Escribe el número de columnas que tendrá la caja");
            // Pedir por teclado el n�mero de filas que tendr� la caja
            filas = ES.leeEntero("Escribe el número de filas que tendrá la caja");
            // Pedir el tipo de material de la caja.
            materialNum = ES.leeEntero("Escriba el material de la caja (1-> MADERA, 2-> CORCHO, 3-> PLASTICO, 4-> CARTON)");
            // Pasar el entero introducido al tipo enumerado correspondiente       
            material = Caja.enteroAMaterial(materialNum);
            // Usar el constructor con par�metros pas�ndole los valores le�dos por teclado
            Caja box = new Caja(columnas, filas, caracter, material);
            // Usar toString para mostrar los valores del objeto reci�n creado
            ES.msgln(box.toString());
            // Dibujar la caja con el m�todo apropiado
            box.dibujar();
            // Leer un valor entero por teclado para aumentar la altura de la caja 
            int aumento = ES.leeEntero("Escriba un número entre 2 y 7 para aumentar la anchura de la caja en ese valor:");
            // usando el m�todo creado para tal efecto.
            box.aumentarAnchura(aumento);
            // Escribir los datos de la caja.
            ES.msgln("Mostramos los datos de la caja aumentada de tamaño:");
            ES.msgln(box.toString());
            // Dibujar de nuevo la caja
            box.dibujar();
            // Informamos sobre que vamos a girar la caja
            ES.msgln("Ahora girar la caja: Mostramos los datos de la caja girada:");
            ES.msgln(box.toString());
            ES.msgln("Dibujamos la caja girada:");
            // Aplicar el m�todo de giro
            box.girarCaja();
            box.dibujar();
            // Pedir por teclado un 1 para seguir iterando o un 0 para terminar la ejecuci�n
            respuesta = ES.leeEntero("¿Desea continuar con otra caja? (1->para seguir / 0->para terminar)");

            // Cierre del bucle
        }
    }

}
