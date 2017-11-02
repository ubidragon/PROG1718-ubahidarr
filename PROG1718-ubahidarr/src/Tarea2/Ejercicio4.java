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
 * <h3>Ejercicio4. Anteriores y posteriores.</h3><br>
 * Escribe un programa que partiendo de dos números enteros y diferentes leídos
 * por teclado, muestre primero los números que hay entre el menor de ellos y la
 * media de dichos números, y entre el mayor de ellos y la media de dichos
 * números. Para realizar este ejercicio ten en cuenta que:<br>
 * En primer lugar debes leer los números, si los números son iguales, se deben
 * volver a pedir los números.
 * <br>En segundo lugar deberías calcular cual es el menor y cual es el mayor, y
 * almacenarlo en dos variables separadas.
 * <br>En tercer lugar deberías calcular el número que hay a medio camino entre
 * el menor y el mayor haciendo la media. Puedes hacer una división entera para
 * calcular la media.
 * <br>En cuarto lugar deberás mostrar los números entre el menor y la media en
 * orden ascentente, incluyendo ambos.
 * <br>En quinto lugar deberás mostrar los números entre el mayor y la media en
 * orden descendente, incluyendo ambos.
 *
 * @author Hidalgo Arriaga, Ubaldo
 */
public class Ejercicio4 {

    /**
     *
     * @param args Los parametros de entrada seran aquellos que introduzca el
     * usuario por consola.
     * @exception InputMismatchException Excepcion generada por introduccion de
     * un tipo diferente al solicitado.
     */
    public static void main(String[] args) {
        int num1 = 0;
        int num2 = 0;
        int mayor = 0;
        int menor = 0;
        int media = 0;

        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";

        try {

            Scanner scan = new Scanner(System.in);
            //Comprobar si mientras el numero 1 y numero 2 sean iguales
            do {
                System.out.println("\nIntroduce el primer número:");

                num1 = scan.nextInt();

                System.out.println("Introduce el segundo número:");
                num2 = scan.nextInt();

            } while (num1 == num2);

            //Asignacion de mayor o menor
            if (num1 > num2) {
                mayor = num1;
                menor = num2;

            } else {
                mayor = num2;
                menor = num1;
            }
            media = (num1 + num2) / 2;

            System.out.print("Lista ascendente desde " + menor + " hasta " + media
                    + ": ");
            
            //Creacion de la lista de numeros ascendente
            while (menor < media) {
                String sigNum = menor++ + " ";
                System.out.print(sigNum);
            }
            System.out.print("\nLista descendente desde " + mayor + " hasta " + media
                    + ": ");
            
            //Creacion de la lista de numeros descendente
            while (media < mayor) {
                String sigNum2 = mayor-- + " ";
                System.out.print(sigNum2);
            }

            scan.close();
        } catch (InputMismatchException e) {
            System.out.println(EXCEPCION_VALOR);

        } catch (Exception e) {

            System.out.println(EXCEPCION_OTRO);
        }

    }

}
