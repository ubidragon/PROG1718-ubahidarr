package Tarea3.caja.utilidades ;

import java.util.Scanner;



/**
 * Esta clase define algunos m�todos para entrada de datos, de forma que se 
 * capturen los errores de entrada sin abortar, en caso de que el usuario 
 * introduzca datos no v�lidos.
 * Tambi�n incluye un par de m�todos para simplificar la escritura de mensajes
 * en pantalla, abreviando la escritura de las sentencias System.out.println()
 * y System.out.print(). Se hace uso tambi�n de la sobrecarga de m�todos, 
 * que es algo que se hab�a visto con los constructores, pero sin entrar en
 * detalle. As�, podemos tener tres m�todos para leer enteros, que se llaman 
 * todos igual, pero que se diferencian en su lista de par�metros. 
 * 
 * @author Profesor
 */
 
public class ES {

    /**
     * Este m�todo sirve para leer desde teclado cualquier n�mero entero en el
     * rango de n�meros del tipo int. La lectura se estar� repitiendo hasta que
     * el valor suministrado est� en ese rango.
     *
     * @return El n�mero entero le�do.
     */
    public static int leeEntero() {
        boolean leido = false;
        int numero = 0;
        Scanner teclado = null;
        do {
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception e) {
                ES.msgln("Error: No es un n�mero entero v�lido. ");
            }

        } while (!leido);
        return numero;
    }

    /**
     * Este m�todo sirve para escribir el mensaje indicado para solicitar la
     * introducci�n de un dato desde teclado, y espera la introducci�n de
     * cualquier n�mero entero en el rango de n�meros del tipo int, que ser� el
     * dato le�do. La lectura se estar� repitiendo hasta que el valor
     * suministrado est� en ese rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducci�n del n�mero.
     * @return El n�mero entero le�do.
     */
    public static int leeEntero(String mensaje) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                leido = true;
            } catch (Exception e) {
                ES.msgln("Error: No es un n�mero entero v�lido. ");
            }
        } while (!leido);
        return numero;
    }

    /**
     * Este m�todo sirve para leer desde teclado cualquier n�mero entero en el
     * rango de n�meros del tipo int que adem�s sea mayor o igual que el valor
     * m�nimo indicado como par�metro. La lectura se estar� repitiendo hasta que
     * el valor suministrado est� en ese rango.
     *
     * @param minimo Es el valor m�s peque�o dentro del rango de los n�meros
     * enteros tipo int que se aceptar� como v�lido.
     * @return El n�mero entero le�do.
     */
    public static int leeEntero(int minimo) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    ES.msgln("Error: Debe ser un n�mero entero mayor o igual que " + minimo + ". ");
                }
            } catch (Exception e) {
                ES.msgln("Error: No es un n�mero entero v�lido. ");
            }
        } while (!leido);
        return numero;
    }

    /**
     * Este m�todo sirve para escribir el mensaje indicado para solicitar la
     * introducci�n de un dato desde teclado, y espera la introducci�n de
     * cualquier n�mero entero en el rango de n�meros del tipo int que adem�s
     * sea mayor o igual que el valor m�nimo indicado como par�metro. La lectura
     * se estar� repitiendo hasta que el valor suministrado est� en ese rango.
     *
     * @param mensaje  Es el mensaje que se muestra para solicitar la
     * introducci�n del n�mero.
     * @param minimo  Es el valor m�s peque�o dentro del rango de los n�meros
     * enteros tipo int que se aceptar� como v�lido.
     * @return El n�mero entero le�do.
     */
    public static int leeEntero(String mensaje, int minimo) {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                numero = teclado.nextInt();
                if (numero >= minimo) {
                    leido = true;
                } else {
                    ES.msgln("Error: Debe ser un n�mero entero mayor o igual que " + minimo + ".");
                }
            } catch (Exception e) {
                ES.msgln("Error: No es un n�mero entero v�lido. ");
            }

        } while (!leido);
        return numero;
    }

    /**
     * Este m�todo sirve para leer desde teclado cualquier n�mero entero en el
     * rango de n�meros del tipo int que adem�s sea mayor o igual que el valor
     * m�nimo indicado como primer par�metro y menor o igual que el valor m?ximo
     * indicado como segundo par�metro. La lectura se estar� repitiendo hasta
     * que el valor suministrado est� en ese rango.
     *
     * @param minimo Es el valor m�s peque�o dentro del rango de los n�meros
     * enteros tipo int que se aceptar� como v�lido.
     * @param maximo Es el valor m�s alto dentro del rango de los n�meros
     * enteros tipo int que se aceptar� como v�lido.
     * @return El n�mero entero le�do.
     * @throws IllegalArgumentException Lanza excepci?n si el par�metro m�nimo
     *   es mayor que el m�nimo.
     */
    public static int leeEntero(int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        // Si el valor m�nimo es mayor que el m?ximo, lanzamos una excepci�n
        if (minimo <= maximo) {
            do {
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        ES.msgln("Error: Debe ser un n�mero entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception e) {
                    ES.msgln("Error: No es un n�mero entero v�lido. ");
                }
            } while (!leido);
        } else {
            throw new IllegalArgumentException("Rango imposible. El valor m�nimo no puede ser mayor que el valor m?ximo");
        }
        return numero;
    }

    /**
     * Este m�todo sirve para escribir el mensaje indicado para solicitar la
     * introducci�n de un dato desde teclado, y espera la introducci�n de
     * cualquier n�mero entero en el rango de n�meros del tipo int que adem�s
     * sea mayor o igual que el valor m�nimo indicado como primer par�metro y
     * menor o igual que el valor m?ximo indicado como segundo par�metro. La
     * lectura se estar� repitiendo hasta que el valor suministrado est� en ese
     * rango.
     *
     * @param mensaje Es el mensaje que se muestra para solicitar la
     * introducci�n del n�mero.
     * @param minimo Es el valor m�s peque�o dentro del rango de los n�meros
     * enteros tipo int que se aceptar? como v�lido.
     * @param maximo Es el valor m�s alto dentro del rango de los n�meros.
     * enteros tipo int que se aceptar� como v�lido.
     * @return El n�mero entero le�do.
     * @throws IllegalArgumentException Lanza excepci?n si el par�metro m�nimo
     *   es mayor que el m�nimo.
     */
    public static int leeEntero(String mensaje, int minimo, int maximo) throws IllegalArgumentException {
        int numero = 0;
        boolean leido = false;
        Scanner teclado = null;

        // Si el valor m�nimo es mayor que el m?ximo, lanzamos una excepci�n
        if (minimo <= maximo) {
            do {
                ES.msgln(mensaje);
                try {
                    teclado = new Scanner(System.in);
                    numero = teclado.nextInt();
                    if (numero >= minimo && numero <= maximo) {
                        leido = true;
                    } else {
                        ES.msgln("Error: Debe ser un n�mero entero mayor o igual que " + minimo + " y menor o igual que " + maximo + ". ");
                    }
                } catch (Exception e) {
                    ES.msgln("Error: No es un n�mero entero v�lido. ");
                }
            } while (!leido);
        } else {
            throw new IllegalArgumentException("Rango imposible. El valor m�nimo no puede ser mayor que el valor m?ximo");
        }
        return numero;
    }

    

    /**
     * Este m�todo lee una cadena de caracteres desde teclado, y comprueba que
     * efectivamente la lectura se ha producido correctamente, mandando un
     * mensaje de error en caso de que haya fallado.
     *
     * @return La cadena de caracteres le�do desde el teclado.
     */
    public static String leeCadena() {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        try {
            cadena = teclado.nextLine();
        } catch (Exception e) {
            ES.msgln("Error: Ha fallado la entrada de datos.");
        }
        return cadena;
    }

    /**
     * Este m�todo sirve para escribir el mensaje indicado para solicitar la
     * introducci�n de un dato desde teclado, espera la introducci�n de una
     * cadena de caracteres desde teclado, y comprueba que efectivamente la
     * lectura se ha producido correctamente, mandando un mensaje de error en
     * caso de que haya fallado.
     *
     * @param mensaje Es el mensaje que se env?a solicitando la introducci�n
     * de la cadena de texto.
     * @return La cadena de caracteres le�do desde el teclado.
     */
    public static String leeCadena(String mensaje) {
        Scanner teclado = new Scanner(System.in);
        String cadena = "";
        try {
            ES.msgln(mensaje);
            cadena = teclado.nextLine();
        } catch (Exception e) {
            ES.msgln("Error: Ha fallado la entrada de datos.");
        }
        return cadena;
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.print(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param entero  Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msg(int entero) {
        System.out.print(entero);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.print(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msg(long enteroLargo) {
        System.out.print(enteroLargo);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.print(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param real  Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msg(float real) {
        System.out.print(real);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.print(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msg(double realLargo) {
        System.out.print(realLargo);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.print(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.print() se use mucho.
     *
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida est�ndar.
     */
    public static void msg(String cadenaAImprimir) {
        System.out.print(cadenaAImprimir);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * cuando se invoca sin par�metros, pero tiene la ventaja de que su
     * escritura es m�s corta y ahorra algo de trabajo en programas donde la
     * sentencia System.out.println() se use mucho.
     */
    public static void msgln() {
        System.out.println();
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param entero Es es el valor entero de tipo int a imprimir como texto.
     */
    public static void msgln(int entero) {
        System.out.println(entero);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param enteroLargo Es es el valor entero de tipo long a imprimir como
     * texto.
     */
    public static void msgln(long enteroLargo) {
        System.out.println(enteroLargo);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param real Es es el valor real de tipo float a imprimir como texto.
     */
    public static void msgln(float real) {
        System.out.println(real);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param realLargo Es es el valor entero de tipo double a imprimir como
     * texto.
     */
    public static void msgln(double realLargo) {
        System.out.println(realLargo);
    }

    /**
     * Este m�todo hace exactamente lo mismo que el m�todo System.out.println(),
     * pero tiene la ventaja de que su escritura es m�s corta y ahorra algo de
     * trabajo en programas donde la sentencia System.out.println() se use
     * mucho.
     *
     * @param cadenaAImprimir Es la cadena de texto que hay que escribir en
     * el dispositivo de salida est�ndar.
     */
    public static void msgln(String cadenaAImprimir) {
        System.out.println(cadenaAImprimir);
    }

    
    
    /**
     * Lee desde teclado una respuesta para una pregunta de tipo S� o No,
     * mostrando por pantalla la pregunta en cuesti�n. S�lo se admiten como
     * respuestas S, s, N o bien n.
     *
     * @param mensaje  Es el mensaje que se env?a con la pregunta cuya
     * respuesta se espera que sea S o N.
     * @return la cadena "S" si se ha respondido "S" o "s" y la cadena "N" si se
     * ha respondido "N" o "n".
     */
    public static String leeRespuesta(String mensaje) {
        boolean correcta = false;
        String cadena = "";
        Scanner teclado = null;
        do {
            ES.msgln(mensaje);
            try {
                teclado = new Scanner(System.in);
                cadena = teclado.nextLine();
                if ( cadena!= null && cadena.length() == 1 && ((cadena.equalsIgnoreCase("S")) || (cadena.equalsIgnoreCase("N")))) {
                    correcta = true;
                } else {
                    ES.msgln("Error: Solo se admite como respuesta un �nico car�cter, que debe ser 's', 'S', 'n' o 'N'.");
                }
            } catch (Exception e) {
                ES.msgln("Error: Ha fallado la entrada de datos.");
            }
        } while (!correcta);
        return cadena.toUpperCase();
    }
    
    
    /**
     * Lee un car�cter de teclado.
     * @param mensaje Mensaje a mostrar por pantalla
     * @return El car�cter le�do por teclado.
     */
    public static char leeCaracter(String mensaje) {
      
        Scanner teclado = null;
        teclado = new Scanner(System.in);
        ES.msgln(mensaje);
        String cadena=teclado.next();
        char caracter = cadena.charAt(0); 
        return caracter ;
    }
    
    
}//class ES