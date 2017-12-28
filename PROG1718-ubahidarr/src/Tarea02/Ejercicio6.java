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
 * <h3>Ejercicio6. Crear un marco.</h3><br>
 * Escribir un programa en java que cree un marco habiendose dado un<br> alto y
 * largo.<br>
 *
 * @author Hidalgo Arriaga, Ubaldo
 */
public class Ejercicio6 {

    /**
     *
     * @param args el valor que introduzca el usuario por consola cuando se le
     * solicite
     * @exception InputMismatchException Lanza una excepcion por no introducir
     * un valor de tipo int
     * @exception InputMismatchException Lanza una excepcion por no introducir
     * un valor dentro del intervalo predefinido
     */
    public static void main(String[] args) {
        int alto = 0;
        int ancho = 0;
        String first = "";
        String end = "";
        String cuerpo = "";
        String cuerpo2 = "";
        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";
        final String EXCEPCION_INTERVAL = "Se ha producido un error en la entrada de datos,"
                + " numeros fuera de rango.\nIntroduzca el numero de nuevo";

        System.out.println("Marco -> Solo se admiten valores de 1 a 20");

        Scanner scan = new Scanner(System.in);

        do {

            try {

                System.out.println("Introduce el alto del marco");
                alto = scan.nextInt();

                if (1 > alto || alto > 20) {
                    throw new InputMismatchException(EXCEPCION_INTERVAL);
                }

            } catch (InputMismatchException e) {
                System.out.println(EXCEPCION_VALOR);

            } catch (Exception e) {
                System.out.println(EXCEPCION_OTRO);
            }
        } while (1 > alto || alto > 20);

        do {

            try {
                System.out.println("Introduce el ancho del marco");
                ancho = scan.nextInt();

                if (1 > ancho || ancho > 20) {
                    throw new InputMismatchException(EXCEPCION_INTERVAL);
                }

            } catch (InputMismatchException e) {
                System.out.println(EXCEPCION_VALOR);

            } catch (Exception e) {
                System.out.println(EXCEPCION_OTRO);
            }

        } while (1 > ancho || ancho > 20);

        int ancho2 = ancho - 2;
        int ancho3 = ancho - 3;
        for (int i = 0; i < ancho2; i++) {
         
            first += "-";
        }
        System.out.println("+" + first + "+");

       
        for (int i = 0; i < alto - 2; i++) {

            System.out.print("|*");

            if (i == 0 || i == (alto - 3)) {

                for (int j = 0; j < ancho3; j++) {
                    cuerpo = "*";
                    System.out.print(cuerpo);
                }

            } else {
                
                for (int j = 0; j < ancho3 - 1; j++) {
                    
                    cuerpo2 = " ";
                    System.out.print(cuerpo2);
                }
                System.out.print("*");
            }
            System.out.println("|");
        }

        for (int i = 0; i < ancho2; i++) {
            end += "-";
        }
        System.out.println("+" + end + "+");

    }

}
