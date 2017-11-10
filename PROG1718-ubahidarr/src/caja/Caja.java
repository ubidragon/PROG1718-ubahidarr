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
package caja;

/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Caja {

    public int x;
    public int y;
    public char caracter;
    public Material material;

    public enum Material {
        MADERA, CORCHO, PLASTICO, CARTON
    };

    public Caja() {
        this.x = 5;
        this.y = 2;
        this.caracter = '*';
        this.material = Material.CORCHO;

    }

    public Caja(int x, int y, char caracter, Material material) {
        this.x = x;
        this.y = y;
        this.caracter = caracter;
        this.material = material;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String dibujar() {
        String caja ="";

        for (int i = 0; i < getX(); i++) {
            caja += getCaracter();

        }
        for (int j = 0; j < getY(); j++) {
            System.out.println(caja);

        }
        return caja;
    }

    public boolean aumentarAnchura(int unidades) {
        boolean aumento = false;
        if (unidades > 0) {
            aumento = true;
        }
        if (aumento = true) {
            setX(getX() + unidades);
        }
        return aumento;
    }

    public void girarCaja() {
      int giroX = getY();
      int giroY = getX();
      setX(giroX);
      setY(giroY);

    }

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

    public String toString() {
        return "La caja se dibuja con el caracter: \"" + caracter + "\" y se dibujara con: " + getX() + " columnas y " + getY() + " filas. El material de la caja es: " + this.material;
    }

}
