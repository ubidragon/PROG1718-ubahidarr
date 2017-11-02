package Tarea2;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * The MIT License
 *
 * Copyright 2017 Hidalgo Arriaga, Ubaldo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
/**
 * <h3>Ejercicio1. Tres números (uso de if-else).</h3> <br>Almacena en una
 * constante numérica tipo entera llamada "D" el número 22. Después, lee tres
 * números enteros por teclado (podrán ser negativos o positivos). Dados esos
 * tres números: <br>Si los tres números leídos son menores que D, se mostrará
 * <b>"TRES NÚMEROS MENORES"</b>. <br>Si dos de los tres números leídos por
 * teclado es menor que D, se mostrará <b>"DOS NÚMEROS MENORES"</b>.
 * <br>Si uno de los tres números leídos por teclado es menor que D, se mostrará
 * <b>"UN NÚMERO MENOR"</b>. <br>Si ninguno de los tres números leídos por
 * teclado es menor que D, se mostrará <b>"NINGÚN NÚMERO MENOR"</b>.
 *
 * @author Hidalgo Arriaga, Ubaldo
 *
 */
public class Ejercicio1 {

    /**
     * Metodo que lee por consola y luego ejecuta un contador para saber cuantos
     * numeros son menores que la constante D
     *
     * @param args Los parametros de entrada seran aquellos que introduzca el
     * usuario por consola.
     * @exception InputMismatchException Excepcion generada por introduccion de
     * un tipo diferente al solicitado.
     */
    public static void main(String[] args) {
        final int D = 22;
        int numero = 0;
        int contador = 0;
        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";

        try {

            System.out.println("Introduzca un numero:");
            Scanner scan = new Scanner(System.in);
            numero = scan.nextInt();
            //Contador para saber cuantos numeros son menores
            if (numero < D) {
                contador++;
            }
            System.out.println("Introduzca otro numero:");
            numero = scan.nextInt();
            if (numero < D) {
                contador++;
            }
            System.out.println("Introduzca otro numero:");
            numero = scan.nextInt();
            if (numero < D) {
                contador++;
            }
            scan.close();

            //Observa el valor del contador y determina el mensaje para el usuario
            if (contador == 3) {
                System.out.println("Los TRES numeros son menores que " + D);

            } else if (contador == 2) {
                System.out.println("Dos numeros son menores que " + D);

            } else if (contador == 1) {
                System.out.println("Un numero es menor que " + D);
            } else {
                System.out.println("Ningun numero es menor que " + D);
            }

        } catch (InputMismatchException e) {

            System.out.println(EXCEPCION_VALOR);
        } catch (Exception e) {

            System.out.println(EXCEPCION_OTRO);
        }

    }
}
