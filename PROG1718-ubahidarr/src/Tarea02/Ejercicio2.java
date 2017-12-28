package Tarea02;

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
 * <h3>Ejercicio2. Restar número menor al mayor.</h3><br> Realiza un programa
 * que considere cuatro números: tres números enteros leídos por teclado,
 * llamados "a", "b" y "c", y una constante entera llamada "D" que almacenará el
 * número 22. Dados esos cuatro números tendrás que hacer un algoritmo que:
 * <br>Calcule el menor de los cuatro números (entre a, b, c y D). <br>Calcule
 * el mayor de los cuatro números (entre a, b, c y D). <br>Muestre la diferencia
 * entre el mayor y el menor.
 *
 * @author Hidalgo Arriaga, Ubaldo
 *
 */
public class Ejercicio2 {

    /**
     * Metodo que lee por consola y luego compara 4 numeros para determinar cual
     * es el
     * <br>mayor y el menor
     *
     * @param args Los parametros de entrada seran aquellos que introduzca el
     * usuario por consola.
     * @exception InputMismatchException Excepcion generada por introduccion de
     * un tipo diferente al solicitado.
     */
    public static void main(String[] args) {
        final int D = 22;
        int a = 0;
        int b = 0;
        int c = 0;
        int menor = 0, mayor = 0;
        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";
        try {

            System.out.println("Introduzca un numero:");
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();

            System.out.println("Introduzca otro numero:");
            b = scan.nextInt();

            System.out.println("Introduzca otro numero:");
            c = scan.nextInt();

            scan.close();
            //Determinacion del numero mayor
            if (a > b && a > c && a > D) {
                mayor = a;
            }
            if (b > c && b > a && b > D) {

                mayor = b;
            }
            if (c > b && c > a && c > D) {
                mayor = c;
            }
            if (D > a && D > b && D > c) {
                mayor = D;
            }

            //Determinacion del menor
            if (a < b && a < c && a < D) {
                menor = a;
            }
            if (b < c && b < a && b < D) {
                menor = b;
            }
            if (c < b && c < a && c < D) {
                menor = c;
            }
            if (D < a && D < b && D < c) {
                menor = D;
            }

            System.out.println("El numero mayor introducido es " + mayor
                    + "\n El numero menor introducido es " + menor);

        } catch (InputMismatchException e) {

            System.out.println(EXCEPCION_VALOR);
        } catch (Exception e) {

            System.out.println(EXCEPCION_OTRO);
        }

    }

}
