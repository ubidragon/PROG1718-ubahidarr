/*
 * The MIT License
 *
 * Copyright 2017 Ubaldo Hidalgo Arriaga.
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
package Tarea07.caja;

import Tarea07.caja.utilidades.ES;

/**
 *
 * @version 2.0 Añadidos cambios correspondientes a codigos, lectura de
 * ficheros...
 * @author Ubaldo Hidalgo Arriaga
 */
public class Caja {

    public int x;
    public int y;
    public char caracter;
    private Material material;
    protected int codigo;
    protected static int codigoGlobal;

    /**
     * Tipo Enumerado de Materiales
     */
    public enum Material {
        /**
         * Madera
         */
        MADERA,
        /**
         * Corcho
         */
        CORCHO,
        /**
         * Plastico
         */
        PLASTICO,
        /**
         * Carton
         */
        CARTON
    };

    /**
     * Contructor por defecto que no recibe parametros
     *
     */
    public Caja() {
        this(5, 2, '*', Material.CORCHO);
        this.codigo = codigoGlobal;
        setCodigo();
    }

    /**
     * Contructor con parametros
     *
     * @param x Numero de columnas
     * @param y Numero de filas
     * @param caracter Caracter con el que dibujaremos la caja
     * @param material Material de la caja
     */
    public Caja(int x, int y, char caracter, Material material) {
        this.x = x;
        this.y = y;
        this.caracter = caracter;
        this.material = material;
        this.codigo = codigoGlobal;
        setCodigo();
    }

    /**
     *
     * @return Numero de columnas actual
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @param x nuevo numero de columnas
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     *
     * @return numero de filas actual
     */
    public int getY() {
        return y;
    }

    /**
     *
     * @param y nuevo numero de filas
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     *
     * @return Caracter actual para dibujar la caja
     */
    public char getCaracter() {
        return caracter;
    }

    /**
     *
     * @param caracter nuevo caracterque imprimiremos
     */
    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @return the CODIGO
     */
    public int getCodigo() {

        return codigo;
    }

    /**
     * Incrementa el codigo global de las cajas
     */
    public static void setCodigo() {

        codigoGlobal += 1;
    }

    /**
     *  Metodo que dibuja por consola la caja
     * @return Devuelve la caja pintada
     */
    public String dibujar() {
        StringBuilder linea = new StringBuilder();
       StringBuilder res = new StringBuilder();

        for (int i = 0; i < getX(); i++) {
            linea.append(getCaracter());
            
        }
        linea.append("\n");
        for (int j = 0; j < getY(); j++) {
            res.append(linea);
             
        }
        return res.toString();
    }

    /**
     *
     * @param unidades numero entero que indicara el aumento de la caja
     * @return Aumenta el valor de la anchura si es mayor que 0
     */
    public boolean aumentarAnchura(int unidades) {
        boolean aumento = false;
        if (unidades > 0) {
            aumento = true;
        }
        if (aumento == true) {
            setX(getX() + unidades);
        }
        return aumento;
    }

    /**
     * Metodo modificador que intercambia los valores de X e Y
     */
    public void girarCaja() {
        int giroX = getY();
        int giroY = getX();
        setX(giroX);
        setY(giroY);

    }

    /**
     * Metodo estatico que transformara el numero recibido por consola en uno de
     * los materiales
     *
     * @param numero numero entero
     * @return devolvera un material que estara asociado a dicho numero
     *
     */
    public static Material enteroAMaterial(int numero) {
        Material material;
        switch (numero) {
            case 1:
                material = Material.MADERA;
                break;
            case 2:
                material = Material.CORCHO;
                break;
            case 3:
                material = Material.PLASTICO;
                break;
            case 4:
                material = Material.CARTON;
                break;
            default:
                material = Material.MADERA;

        }

        return material;
    }

    /**
     *
     * @return Imprime la informacion del objeto Caja que hemos creado
     */
    public String toString() {
        StringBuilder res = new StringBuilder("\nLa caja de codigo: ");
        res.append(getCodigo())
                .append(" se dibuja con el caracter: \"")
                .append(caracter)
                .append("\" y se dibujara con: ")
                .append(getX())
                .append(" columnas y ")
                .append(getY())
                .append(" filas. El material de la caja es: ")
                .append(this.getMaterial());
        return res.toString();
    }

}
