/*
 * The MIT License
 *
 * Copyright 2018 Ubaldo Hidalgo Arriaga.
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
package PreparacionFebrero;

/**
 * Hola Ubaldo... la verdad es que estoy superatareado corrigiendo y no he
 * podido pensar nada... estoy al 120% ahora mismo triste.
 *
 * Así que sobre la marcha os propongo el siguiente ejercicio, que una vez
 * plantee en presencial para trabajar en clase y creo que puede ser interesante
 * de cara al examen. El ejercicio no lo tenía redactado, y he tirado de
 * "memoria"... pero más o menos era así. El martes os publico la solución...
 * los dos últimos apartados son más complejos. Tomadlo como un ensayo para el
 * examen, pero no como el examen en sí (no he medido el tiempo que puede llevar
 * este ejercicio, puede que os lleve más de lo esperado).
 *
 * Yo me prepararía los apuntes, una taza de café e intentaría resolverlo con el
 * cronómetro puesto. Una vez que terminéis, podéis publicar cuanto tiempo os ha
 * llevado y hasta que ejercicio habéis sabido realizar.
 *
 * TIEMPO TOTAL DE DEDICACION:
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class MultiContador {

    /*---------ATRIBUTOS---------*/
    int valorInicial = 0;
    //TODO: No entiendo esta restriccion "Si el valor máximo es menor o igual al inicial, se considerará que no hay máximo."
    int valorMaximo = 0;
    //Este atributo será el valor de cada contador. 
    int enteros[];
    //Este atributo será por defecto 0 y se incrementará o decrementará en uno en cada incremento o decremento de cada contador. 
    static long cuentaGlobal = 0L;

    

    /*---------GETTERS & SETTERS---------*/
    /**
     *
     * @return Valor inicial de los contadores del array
     */
    public int getValorInicial() {
        return valorInicial;
    }

    /**
     * Modifica el valor inicial del contador
     *
     * @param valorInicial el nuevo valor inicial
     */
    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    /**
     *
     * @return Indica el valor maximo del contador
     */
    public int getValorMaximo() {
        return valorMaximo;
    }

    /**
     * Modifica el valor maximo del contador
     *
     * @param valorMaximo el nuevo valor maximo
     */
    public void setValorMaximo(int valorMaximo) {
        this.valorMaximo = valorMaximo;
    }

    /**
     *
     * @return Llevara una cuenta global de los incrementos de contadores
     */
    public static long getCuentaGlobal() {
        return cuentaGlobal;
    }

    /*---------CONSTRUCTORES---------*/
    /**
     *
     * @param inicial valor inicial de los contadores
     * @param contadores numero de contadores
     */
    public MultiContador(int inicial, int contadores) {
        this.valorInicial = inicial;
        this.valorMaximo = inicial;
        this.enteros = new int[contadores];
        rellenaContadores(enteros, valorInicial);

    }

    /**
     *
     * @param inicial valor inicial de los contadores
     * @param contadores numero de contadores
     * @param maximo valor maximo de los contadores
     */
    public MultiContador(int inicial, int contadores, int maximo) {
        this.valorInicial = inicial;
        this.valorMaximo = maximo;
        this.enteros = new int[contadores];
        rellenaContadores(enteros, valorInicial);
    }

    /*---------METODOS DE ACCION----------*/
    /**
     * Un método para incrementar en uno un contador específico (el que reciba
     * como parametro) , y el contador global.
     *
     * @param valor contador a incrementar
     * @return si el contador no existe el método retornará false. En caso de
     * que se haya realizado el incremento, se retornará true.
     */
    public boolean incrementaContador(int valor) throws IllegalArgumentException{
        
        int check[] = enteros;
        boolean res = enteros.length > valor;

        if (check[valor] + 1 > this.valorMaximo) {
            throw new IllegalArgumentException("Se ha pasado el valor maximo permitido");

        } else {
            enteros[valor]++;
            cuentaGlobal++;

        }

        return res;

    }

    public boolean decrementaContador(int valor) {
        /*TODO: Tendriamos que contemplar que el usuario sabe que los arrays empiezan 
        desde 0? o habria que realizar el metodo jugando con el -1, es decir
        boolean check = enteros[valor-1]++ > this.valorMaximo;*/
         int check[] = enteros;
        boolean res = enteros.length > valor;

        if (check[valor]-1 < this.valorInicial) {
            throw new IllegalStateException("Se ha decrementado mas de lo permitido");

        } else {
            enteros[valor]--;
            cuentaGlobal--;

        }

        return res;

    }

    public void menoresQue(int valor) {

        int parada = 0;
        int menores = 0;
        while (parada < enteros.length) {

            if (enteros[parada] < valor) {
                menores++;
            }

            parada++;

        }

    }

    public void mayoresQue(int valor) {

        int parada = 0;
        int mayores = 0;
        while (parada < enteros.length) {

            if (enteros[parada] > valor) {
                mayores++;
            }

            parada++;

        }

    }

    public void entre(int minimo, int maximo) {

        int parada = 0;
        int entre = 0;
        while (parada < enteros.length) {

            if (enteros[parada] >= minimo && enteros[parada] <= maximo) {
                entre++;
            }

            parada++;

        }

    }

    public void incrementoGeneral() {
        
        
        for (int i = 0; i < enteros.length; i++) {
            enteros[i]++;
            cuentaGlobal++;
        }
        
         
        for (int i = 0; i < enteros.length; i++) {

            if (enteros[i] > this.valorMaximo) {
                throw new IllegalStateException("Se ha decrementado mas de lo permitido");
            }
        }

    }

    public void decrementoGeneral() {
        for (int i = 0; i < enteros.length; i++) {
            enteros[i]--;
            cuentaGlobal--;
        }
        for (int i = 0; i < enteros.length; i++) {

            if (enteros[i] < this.valorInicial) {
                enteros[i] = this.valorInicial;
                throw new IllegalStateException("Se ha decrementado mas de lo permitido");
            }
        }

    }


    /*---------METODOS AUXILIARES---------*/
 /*Metodo auxiliar para llenar los contadores con el valor inicial que se nos pase
    al usar este metodo nos ahorramos tener que estar construyendo dos veces el for,
    ahorramos codigo y ayudamos a la legibilidad del codigo */
    private void rellenaContadores(int[] lista, int valor) {
        for (int i = 0; i < lista.length; i++) {
            lista[i] = valor;
        }
    }

    /*---------toString------------*/
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder(" Estado de los contadores: {Total: ");
        res.append(enteros.length).append("} [");
        for (int i = 0; i < enteros.length; i++) {
            if (i != enteros.length - 1) {
                res.append("Contador ").append(i).append(": ").append(enteros[i]).append(", ");
            } else {
                res.append("Contador ").append(i).append(": ").append(enteros[i]).append("]");
            }

        }

        return res.toString();
    }

}
