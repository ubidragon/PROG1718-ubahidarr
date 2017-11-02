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
 * <h3>Ejercicio5. Rectángulo.</h3><br>
 * Escribe un programa en JAVA que dibuje un rectángulo en modo texto del alto y
 * ancho solicitado por teclado. Tanto el alto como el ancho tienen que ser
 * mayores que cero y menores o iguales a 10. El rectángulo deberá alternar,
 * para representar las filas del cuadrado, asteriscos y guiones. Para realizar
 * este ejercicio ten en cuenta que:<br>
 *
 * En primer lugar debe leerse el alto del rectángulo, y este deberá de ser un
 * número entre 0 y 10. Si el número no está en ese rango, se mostrará un
 * mensaje de error y se volverá a pedir el número. <br>En segundo lugar debe
 * leerse el ancho del rectángulo, y este deberá de ser un número entre 0 y 10.
 * Si el número no está en ese rango, se mostrará un mensaje de error y se
 * volverá a pedir el número. <br>En tercer lugar se mostrará el rectangulo
 * empleando estructuras de control de flujo anidadas. No se pueden usar
 * estructuras tipo "for" para hacer el bucle. Para pintar el rectángulo puedes
 * usar asteríscos inicialmente (" * "). <br>En cuarto lugar modifica el código
 * para que alterne una línea con asteriscos y otra línea con guiones.
 *
 * @author Hidalgo Arriaga, Ubaldo
 */
public class Ejercicio5 {

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
        int cont = 0;
        int cont2 = 0;
        int cont3 = 0;
        String guion = "";
        String asterisco = "";

        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";
        final String EXCEPCION_INTERVAL = "Se ha producido un error en la entrada de datos,"
                + " numeros fuera de rango.\nIntroduzca el numero de nuevo";

        System.out.println("Rectangulo -> Solo se admiten valores de 0 a 10");

        Scanner scan = new Scanner(System.in);

        do {

            try {

                System.out.println("Introduce el alto del rectangulo");
                alto = scan.nextInt();

                if (0 >= alto || alto > 10) {
                    throw new InputMismatchException(EXCEPCION_INTERVAL);
                }

            } catch (InputMismatchException e) {
                System.out.println(EXCEPCION_VALOR);

            } catch (Exception e) {
                System.out.println(EXCEPCION_OTRO);
            }
        } while (0 >= alto || alto > 10);

        do {

            try {
                System.out.println("Introduce el ancho del rectangulo");
                ancho = scan.nextInt();

                if (0 >= ancho || ancho > 10) {
                    throw new InputMismatchException(EXCEPCION_INTERVAL);
                }

            } catch (InputMismatchException e) {
                System.out.println(EXCEPCION_VALOR);

            } catch (Exception e) {
                System.out.println(EXCEPCION_OTRO);
            }

        } while (0 >= ancho || ancho > 10);
        //Diseño del rectangulo, incluido el alternar filas
        while (cont < alto) {

            if (cont % 2 == 0) {
                while (cont3 < ancho) {

                    guion += "- ";
                    cont3++;
                }

                System.out.println(guion);
            } else {
                while (cont2 < ancho) {

                    asterisco += "* ";
                    cont2++;
                }
                System.out.println(asterisco);
            }

            cont++;

        }
    }
}
