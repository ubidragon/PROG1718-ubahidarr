/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea4;

/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class SopaLetras {

    public int numFilas = 0;
    public int numColumnas = 0;
    public char[][] cuadricula;

    public enum Direccion {
        HORIZONTAL, VERTICAL, DIAGONAL1, DIAGONAL2
    }

    public SopaLetras() {

        numFilas = 10;
        numColumnas = 10;
        cuadricula = new char[numFilas][numColumnas];
         //Generador de caracteres aleatorios
        generadorCaracteres(cuadricula);

    }

    public SopaLetras(int numFilas, int numColumnas) {

        this.numFilas = numFilas;
        this.numColumnas = numColumnas;
        cuadricula = new char[numFilas][numColumnas];
         //Generador de caracteres aleatorios
        generadorCaracteres(cuadricula);

    }

    public Integer getNumFilas() {
        return numFilas;
    }

    public Integer getNumColumnas() {
        return numColumnas;
    }

    public char getLetra(int indexFila, int indexColumna) {
        char letter = cuadricula[indexFila][indexColumna];

        return letter;

    }

    public boolean compruebaSiCabe(String s, int fila, int columna, Direccion dir) {

        int longitudFila = s.length() + fila;
        int longitudColumna = s.length() + columna;
        boolean contieneColumna = (longitudColumna <= (numColumnas - 1));
        boolean contieneFila = (longitudFila <= (numFilas - 1));
        boolean res = false;

        //Comprobacion de si la posicion esta en la cuadricula
        if ((dir.equals(Direccion.HORIZONTAL)) && contieneColumna) {

            res = true;

        } else if ((dir.equals(Direccion.VERTICAL)) && contieneFila) {

            res = true;

        } else if (((dir.equals(Direccion.DIAGONAL1)) || (dir.equals(Direccion.DIAGONAL2))) && contieneColumna && contieneFila) {
            res = true;
        }
        return res;

    }

    // TODO: Queda por hacer
    public static boolean compruebaSiEsValida(String s) {

        return true;

    }

    
    public void colocaPalabra(String s, int fila, int columna, Direccion dir) {

       

        String res = s.toUpperCase();
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
            default:
                for (int i = 0; i < s.length(); i++) {
                    cuadricula[fila - 1][columna - 1] = res.charAt(i);
                }
                break;
        }

    }

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
     *
     * @return Imprime la sopa de letras de forma amigable y legible para el
     * usuario
     */
    // TODO: Por montar la sopa de letras
    public String toString() {
        String primeraLinea = "";
        String segundaLinea = "";
        String res = "";
        String cuadri = "";
        String numeroColumnas = "   ";
        String second = "  +-";
        for (int i = 0; i < getNumColumnas(); i++) {

            if (i < 10) {
                numeroColumnas += "  " + i;
            } else {
                numeroColumnas += " " + i;
            }
            second += "---";
        }

        primeraLinea = numeroColumnas;
        segundaLinea = second + "-+";

        for (int i = 0; i < cuadricula.length; i++) {
            if (i < 10) {
                cuadri += i + " |";
            } else {
                cuadri += i + "|";
            }
            for (int j = 0; j < cuadricula[i].length; j++) {

                cuadri += "  " + String.valueOf(cuadricula[i][j]);
            }
            cuadri += "  |\n";
        }

        res = primeraLinea + "\n" + segundaLinea + "\n" + cuadri + segundaLinea;

        return res;//To change body of generated methods, choose Tools | Templates.
    }

}
