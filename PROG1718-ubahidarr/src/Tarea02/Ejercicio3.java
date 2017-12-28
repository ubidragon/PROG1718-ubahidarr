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
 * <h3>Ejercicio3. Día y mes.</h3><br>
 * En este ejercicio tienes que hacer un programa en Java empleando estructuras
 * de control tipo Switch (no pueden usarse otro tipo de estructuras de control
 * de flujo). En el programa propuesto tiene que solicitarse dos datos:<br>
 * Un número que indicará el número de día de la semana (de 1 a 7).<br>
 * Un número que indicará el número de mes (de 1 a 12).<br>
 * Después, dados esos números, el programa mostrará una frase como la
 * siguiente:<br>
 * Si el usuario introduce, por ejemplo, "Día: 2" y "Mes: 5", mostrará "En un
 * martes de mayo brillaba el sol.".
 * <br>Si el usuario introduce un día fuera de rango, y por ejemplo, el "Mes:5"
 * mostrará: "En un día desconocido de mayo brillaba el sol."
 * <br> Si el usuario introduce un día correcto ("Día: 2", por ejemplo) y un mes
 * fuera de rango mostrará: "En un martes de un mes desconocido brillaba el
 * sol."
 * <br> Si el usuario introduce tanto un día fuera de rango como un mes fuera de
 * rango, el programa mostrará: "En un día desconocido de un mes desconocido
 * brillaba el sol."
 *
 * @author Hidalgo Arriaga, Ubaldo
 */
public class Ejercicio3 {

    /**
     * Metodo que lee por consola y luego recorre 2 estructuras switch la
     * primera para determinar a que dia de la semana pertenece el numero, tras
     * eso el segundo switch determina a que mes pertenece el numero
     * proporcionado.
     *
     * @param args Los parametros de entrada seran aquellos que introduzca el
     * usuario por consola.
     * @exception InputMismatchException Excepcion generada por introduccion de
     * un tipo diferente al solicitado.
     */
    public static void main(String[] args) {
        int a, b;
        String day, month, mensaje;
        final String EXCEPCION_VALOR = "Se ha producido un error en la entrada de datos,"
                + " el formato no es el solicitado.\nSolo se admiten numeros enteros";
        final String EXCEPCION_OTRO = "ERROR del programa";

        try {

            System.out.println("Introduzca un numero de dia de la semana (1-7):");
            Scanner scan = new Scanner(System.in);
            a = scan.nextInt();

            System.out.println("Introduzca un numero correspondiente a un mes (1-12):");
            b = scan.nextInt();
            scan.close();
            
            //Seleccion del dia de la semana
            switch (a) {
                case 1:
                    day = "lunes";
                    break;
                case 2:
                    day = "martes";
                    break;
                case 3:
                    day = "miercoles";
                    break;
                case 4:
                    day = "jueves";
                    break;
                case 5:
                    day = "viernes";
                    break;
                case 6:
                    day = "sabado";
                    break;
                case 7:
                    day = "domingo";
                    break;
                default:
                    day = "dia desconocido";
            }
            //Seleccion del mes del año
            switch (b) {
                case 1:
                    month = "enero";
                    break;
                case 2:
                    month = "febrero";
                    break;
                case 3:
                    month = "marzo";
                    break;
                case 4:
                    month = "abril";
                    break;
                case 5:
                    month = "mayo";
                    break;
                case 6:
                    month = "junio";
                    break;
                case 7:
                    month = "julio";
                    break;
                case 8:
                    month = "agosto";
                    break;
                case 9:
                    month = "septiembre";
                    break;
                case 10:
                    month = "octubre";
                    break;
                case 11:
                    month = "noviembre";
                    break;
                case 12:
                    month = "diciembre";
                    break;
                default:
                    month = "un mes desconocido";
            }

            //Creacion del mensaje
            if (day == "desconocido") {
                mensaje = "En un " + day + " de " + month + " brillaba el sol.";
            } else if (month == "desconocido") {
                mensaje = "En un " + day + " de " + month + " brillaba el sol.";
            } else if (day == "desconocido" && month == "desconocido") {
                mensaje = "En un " + day + " de " + month + " brillaba el sol.";
            } else {
                mensaje = "En un " + day + " de " + month + " brillaba el sol.";
            }

            System.out.println(mensaje);

        } catch (InputMismatchException e) {
            System.out.println(EXCEPCION_VALOR);
        } catch (Exception e) {

            System.out.println(EXCEPCION_OTRO);
        }
    }
}
