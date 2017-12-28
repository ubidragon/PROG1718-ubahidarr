/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sopasdeletras;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase que genera y realiza operaciones sobre una sopa de letras que creemos.
 *
 * @author Ubaldo Hidalgo Arriaga
 *
 */
public class SopaLetras {

    /**
     * Numero de Filas de la Sopa de Letras
     */
    public int numFilas = 0;

    /**
     * Numero de Columnas de la Sopa de Letras
     */
    public int numColumnas = 0;

    /**
     * Array bidimensional que contentdra las ltras y palabras de la sopa
     */
    public char[][] cuadricula;

    /**
     * Enumerado que define las direcciones que pueden tomar las palabras
     */
    public enum Direccion {

        /**
         * Direccion Horizontal
         */
        HORIZONTAL,
        /**
         * Direccion Vertical
         */
        VERTICAL,
        /**
         * Direccion Diagonal hacia abajo
         */
        DIAGONAL1,
        /**
         * Direccion Diagonal hacia arriba
         */
        DIAGONAL2
    }

    /**
     * Constructor por defecto que crea una sopa de letras de 10x10
     */
    public SopaLetras() {

        numFilas = 10;
        numColumnas = 10;
        cuadricula = new char[numFilas][numColumnas];
        //Generador de caracteres aleatorios
        generadorCaracteres(cuadricula);

    }

    /**
     * Constructor a partir de parametros para crear sopas de letras segun los
     * parametros que indique el usuario
     *
     * @param numFilas numero de filas que determine el usuario
     * @param numColumnas numero de columnas que determine el usuario
     */
    public SopaLetras(int numFilas, int numColumnas) {

        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        cuadricula = new char[numFilas][numColumnas];
        //Generador de caracteres aleatorios
        generadorCaracteres(cuadricula);

    }

    /**
     * Getter de Filas
     *
     * @return Numero de Filas
     */
    public int getNumFilas() {
        return numFilas;
    }

    /**
     * Getter de las columnas
     *
     * @return Numero de Columnas
     */
    public int getNumColumnas() {
        return numColumnas;
    }

    /**
     * Metodo para obtener la letras que haya en una ubicacion determinada
     *
     * @param indexFila fila de la sopa
     * @param indexColumna columna de la sopa
     * @return devuelve la letra que se encuentra en la posicion que hemos
     * indicado
     */
    public char getLetra(int indexFila, int indexColumna) {
        char letter = cuadricula[indexFila][indexColumna];

        return letter;

    }

    /**
     * Metodo que utilizaremos para saber si cabe o no la plabra antes de
     * insertarla en la sopa de letras
     *
     * @param s Palabra que queremos insertar
     * @param fila numero de filas que posee la sopa de letras
     * @param columna numero de columnas que posee la sopa de letras
     * @param dir Orientacion de la palabra dentro de la sopa de letras
     *
     * @return Devolvera si cabe o no en la sopa de letras
     *
     */
    public boolean compruebaSiCabe(String s, int fila, int columna, Direccion dir) {

        boolean contieneColumna = ((s.length() + columna) <= numColumnas);
        boolean contieneFila = ((s.length() + fila) <= numFilas);
        boolean res = false;

        //Comprobacion de si la posicion esta en la cuadricula
        if ((dir.equals(Direccion.HORIZONTAL)) && contieneColumna) {

            res = true;

        } else if ((dir.equals(Direccion.VERTICAL)) && contieneFila) {

            res = true;

        } else if (((dir.equals(Direccion.DIAGONAL1))) && contieneColumna && contieneFila) {
            res = true;
        } else if (dir.equals(Direccion.DIAGONAL2) && contieneColumna && ((fila - s.length()) >= -1)) {
            res = true;
        }

        return res;

    }

    /**
     * Metodo que utilizaremos para saber si valida o no la plabra antes de
     * insertarla en la sopa de letras
     *
     * @param s Palabra que queremos insertar
     *
     * @return Devolvera si cabe o no en la sopa de letras
     *
     */
    public static boolean compruebaSiEsValida(String s) {

        boolean res = true;

        // Pattern p = Pattern.compile("([a-zA-Z_0-9_-]{2,20})");
        Pattern p = Pattern.compile("^([a-zA-Z_0-9_-]{2,20})$");
        Matcher m = p.matcher(s);

        if (!m.find()) {
            res = false;
        }

        return res;

    }

    /**
     * Metodo modificador que utilizaremos para colocar las palabras en la
     * cuadricula que conforma la sopa de letras
     *
     * @param s palabra que queremos colocar
     * @param fila fila donde colocar la palabra
     * @param columna columna donde colocar la palabra
     * @param dir orientacion que tendra la palabra
     */
    public void colocaPalabra(String s, int fila, int columna, Direccion dir) {

        /*Comprobaciones de si la palabra cabe en la sopa de letras 
        o es valida
        compruebaSiCabe(s, fila, columna, dir);
        compruebaSiEsValida(s);
         */
        //String res = s.toUpperCase();
        String res = s;

        //Escritura de characters en las psoiciones indicadas segun la Direccion
        switch (dir) {
            case HORIZONTAL:
                for (int i = 0; i < s.length(); i++) {
                    cuadricula[fila][columna + i] = res.charAt(i);
                }
                break;
            case VERTICAL:
                for (int i = 0; i < s.length(); i++) {
                    cuadricula[fila + i][columna] = res.charAt(i);
                }
                break;
            case DIAGONAL1:
                for (int i = 0; i < s.length(); i++) {
                    cuadricula[fila + i][columna + i] = res.charAt(i);
                }
                break;
            case DIAGONAL2:
                for (int i = 0; i < s.length(); i++) {
                    cuadricula[fila - i][columna + i] = res.charAt(i);
                }
                break;
        }

    }

    /**
     * Metodo estatico para convertir numeros en Direcciones
     *
     * @param numero Numero que introducimos por consola para poder trabajar con
     * la direccion
     *
     * @return Devuelve un objeto de tipo Direccion
     */
    public static Direccion enteroADireccion(int numero) {

        Direccion dir = null;
        switch (numero) {
            case 1:
                dir = Direccion.HORIZONTAL;
                break;
            case 2:
                dir = Direccion.VERTICAL;
                break;
            case 3:
                dir = Direccion.DIAGONAL1;
                break;
            case 4:
                dir = Direccion.DIAGONAL2;
                break;

        }

        return dir;
    }

    /**
     * El metodo auxiliar lo unico que realiza es la generacion de caracteres
     * para insertarlos en toda la sopa
     *
     * @param cuadri Cuadricula generada en el constructor
     */
    public static void generadorCaracteres(char[][] cuadri) {
        for (int i = 0; i < cuadri.length; i++) {
            for (int j = 0; j < cuadri[i].length; j++) {
                Double n = 65 + Math.random() * 26;
                cuadri[i][j] = (char) n.intValue();
            }
        }
    }

    /**
     * toString de la Clase
     *
     * @return Imprime la sopa de letras de forma amigable y legible para el
     * usuario
     *    
     */
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        StringBuilder segundaLinea = new StringBuilder();
        for (int i = 0; i < getNumColumnas(); i++) {

            switch (i) {
                case 0:
                    resultado.append(String.format("%6d", i));
                    segundaLinea.append(String.format("\n%2s+", ""));
                    break;

                default:

                    resultado.append(String.format("%3d", i));

            }
            segundaLinea.append("---");

        }

        segundaLinea.append("--+");
        resultado.append(segundaLinea);

        for (int i = 0; i < cuadricula.length; i++) {
            resultado.append(String.format("\n%2d|", i));

            for (int j = 0; j < cuadricula[i].length; j++) {

                resultado.append(String.format("%3s", cuadricula[i][j]));
            }
            resultado.append(String.format("%3s", "|"));
        }

        return resultado.append(segundaLinea).toString();
      
    }


}
