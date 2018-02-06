/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea05.simuladorvehiculos;

/**
 * Clase que representa un <strong>vehículo</strong>.
 * <p>
 * Los objetos de esta clase contienen atributos que que permiten almacenar
 * información sobre:</p>
 * <ul>
 * <li><strong>Capacidad del depósito</strong> de combustible (litros).</li>
 * <li><strong>Consumo medio</strong> del vehículo (litros/100km).</li>
 * <li><strong>Estado del motor</strong> (<strong>encendido</strong> o
 * <strong>apagado</strong>).</li>
 * <li><strong>Nivel de combustible</strong> actual (litros).</li>
 * <li><strong>Distancia recorrida</strong> desde que se arrancó el motor por
 * última vez (y no se ha apagado) (km).</li>
 * <li><strong>Distancia recorrida total</strong> desde que el objeto se creó
 * (km).</li>
 * <li><strong>Combustible consumido</strong> desde que se arrancó el motor por
 * última vez (y no se ha apagado) (litros).</li>
 * <li><strong>Combustible total consumido</strong> desde que el objeto se creó
 * (litros).</li>
 * </ul>
 * <p>
 * La clase también dispone de información general independiente de los objetos
 * concretos que se hayan creado. Es el caso de:</p>
 * <ul>
 * <li><strong>Distancia recorrida total</strong> por <strong>todos los
 * vehículos</strong> que se hayan creado hasta el momento (km).</li>
 * <li><strong>Combustible total consumido</strong> por <strong>todos los
 * vehículos</strong> que se hayan creado hasta el momento (litros).</li>
 * <li><strong>Número de vehículos</strong> con el <strong>motor
 * encendido</strong> en el momento actual.</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Vehiculo {

    //Declaracion de atributos
    private double capacidadDeposito, consumoMedio, nivelCombustible, distanciaRecorrida, combustibleConsumido, distanciaRecorridaTotal, combustibleConsumidoTotal;
    private boolean arrancado = false;
    //Declaracion e inicializacion de atributos estaticos
    private static double distanciaRecorridaFlota = 0.;
    private static double combustibleConsumidoFlota = 0.;
    private static long numVehiculosArrancadosFlota = 0L;
    //Declaracion de constantes
    private final double MINIMO_CONSUMO_MEDIO = 2.;
    private final double MAXIMO_CONSUMO_MEDIO = 20.;
    private final double MINIMA_CAPACIDAD_DEPOSITO = 10.;
    private final double MAXIMA_CAPACIDAD_DEPOSITO = 120.;
    private final double CONSUMO_MEDIO_PREDETERMINADO = 5.;
    private final double CAPACIDAD_DEPOSITO_PREDETERMINADA = 50.;
    private final double CONSUMO_COMBUSTIBLE_ARRANQUE = 0.02;

    /**
     * **Constructores***
     */
    /**
     * Metodo constructor por defecto. Crea un objeto Vehiculo con un consumo
     * medio de 5.0 litros/100km y un depósito de una capacidad de 50.0 litros.
     *
     */
    public Vehiculo() {

        this.capacidadDeposito = CAPACIDAD_DEPOSITO_PREDETERMINADA;
        this.consumoMedio = CONSUMO_MEDIO_PREDETERMINADO;

    }

    /**
     * Constructor con parámetros.
     *
     * @param capacidadDeposito Capacidad del depósito del vehículo (litros).
     * Debe estar entre 10.0 y 120.0
     * @param consumoMedio Consumo medio del vehículo (l/100km). Debe estar
     * entre 2.0 y 20.0.
     *
     * @throws IllegalArgumentException Si alguno de los parámetros está fuera
     * del rango permitido.
     */
    public Vehiculo(double consumoMedio, double capacidadDeposito) {

        //Comprobamos la restriccion de la capacidad deposito
        if ((capacidadDeposito < MINIMA_CAPACIDAD_DEPOSITO || capacidadDeposito > MAXIMA_CAPACIDAD_DEPOSITO) || (consumoMedio < MINIMO_CONSUMO_MEDIO || consumoMedio > MAXIMO_CONSUMO_MEDIO)) {
            throw new IllegalArgumentException("Error: Parámetros de creación del vechículo inválidos.");
        }

        this.capacidadDeposito = capacidadDeposito;
        this.consumoMedio = consumoMedio;

    }

    /**
     * *****GETTERS******
     */
    /**
     *
     * @return La capacidad del depósito de combustible del vehículo (en
     * litros).
     */
    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    /**
     *
     * @return El consumo medio del vehículo (en litros/100km).
     */
    public double getConsumoMedio() {
        return consumoMedio;
    }

    /**
     *
     * @return El nivel actual del depósito de combustible del vehículo (en
     * litros).
     */
    public double getNivelCombustible() {
        return nivelCombustible;
    }

    /**
     *
     * @return La distancia recorrida por el vehículo desde que ha sido
     * arrancado por última vez (en km). El vehículo debe estar arrancado. Si
     * no, los contadores se habrán puesto a cero.
     */
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     *
     * @return El combustible que ha sido consumido por el vehículo desde que ha
     * sido arrancado por última vez (en litros). El vehículo debe estar
     * arrancado. Si no, los contadores se habrán puesto a cero.
     */
    public double getCombustibleConsumido() {
        return combustibleConsumido;
    }

    /**
     *
     * @return La distancia total recorrida por el vehículo desde su
     * fabricación.
     */
    public double getDistanciaRecorridaTotal() {
        return distanciaRecorridaTotal;
    }

    /**
     *
     * @return El combustible total que ha sido consumido por el vehículo desde
     * su fabricación (en litros).
     */
    public double getCombustibleConsumidoTotal() {
        return combustibleConsumidoTotal;
    }

    /**
     *
     * @return Si el motor del vehículo está arrancado o no.
     */
    public boolean isArrancado() {
        return arrancado;
    }

    /**
     *
     * @return La distancia recorrida total por todos los vehículos que se hayan
     * creado hasta el momento (en km).
     */
    public static double getDistanciaRecorridaFlota() {
        return distanciaRecorridaFlota;
    }

    /**
     *
     * @return El combustible total que ha sido consumido por todos los
     * vehículos que hayan sido creados hasta el momento (en litros).
     */
    public static double getCombustibleConsumidoFlota() {
        return combustibleConsumidoFlota;
    }

    /**
     *
     * @return El número de vehículos que haya con el motor encendido en ese
     * momento.
     */
    public static long getNumVehiculosArrancadosFlota() {
        return numVehiculosArrancadosFlota;
    }

    /**
     * ****Metodos de Accion*****
     */
    /**
     * Rellena el depósito de combustible del vehículo con una cantidad de
     * litros. Recibirá un parámetro que indicará la cantidad de litros para
     * repostar. Se actualizará el nivel de combustible del vehículo en función
     * del valor del parámetro que se le pase. Ahora bien, podrían darse algunos
     * casos de error lanzarán una excepción.
     *
     * @param litros Cantidad de litros para repostar.
     * @throws IllegalStateException Si el motor está arrancado.
     * @throws IllegalArgumentException Si la cantidad de combustible que se
     * intenta repostar es superior a la que puede admitir el depósito en ese
     * momento. El depósito se llenará completamente pero se producirá un
     * rebosamiento.
     */
    public void repostar(double litros) {

        if (isArrancado()) {
            throw new IllegalStateException("Error: Se intento repostar con el motor encendido. No se ha repostado");

        } else if (capacidadDeposito < (nivelCombustible + litros)) {

            double desbordado = ((nivelCombustible + litros) - capacidadDeposito);
            this.nivelCombustible += (litros - desbordado);

            throw new IllegalArgumentException("Error: Deposito lleno. Se ha desbordado el combustible en " + desbordado + " litros");

        } else {

            this.nivelCombustible += litros;

        }
    }

    /**
     * Arranca el motor del vehículo. Esta acción hará que se produzca un
     * pequeño consumo de combustible de 0.02 litros.
     *
     * @throws IllegalStateException Se produce si intentamos arrancar el motor
     * estando este ya encendido
     * @throws IllegalStateException Se produce si intentamos arrancar el
     * vehiculo con el deposito vacio
     */
    public void arrancar() {

        if (isArrancado() == true) {

            throw new IllegalStateException("Error: el motor ya se encuentra arrancado");

        } else if (nivelCombustible < CONSUMO_COMBUSTIBLE_ARRANQUE) {

            throw new IllegalStateException("Error: Deposito vacio. Se intento arrancar sin combustible suficiente. ");

        } else {
            //pasamos a estado arrancado
            this.arrancado = true;
            //añado vehiculo arrancado
            numVehiculosArrancadosFlota = getNumVehiculosArrancadosFlota() + 1;
            //Actualizo valores de combustible
            this.nivelCombustible -= CONSUMO_COMBUSTIBLE_ARRANQUE;
            this.combustibleConsumido += CONSUMO_COMBUSTIBLE_ARRANQUE;
            this.combustibleConsumidoTotal += CONSUMO_COMBUSTIBLE_ARRANQUE;
            combustibleConsumidoFlota += CONSUMO_COMBUSTIBLE_ARRANQUE;

        }
    }

    /**
     * Hace que el vehículo realice un trayecto de una determinada cantidad de
     * kilómetros que se pasarán como parámetro.
     *
     * @param trayecto Distancia en km que se desea recorrer.
     * @throws IllegalArgumentException Si no hay combustible suficiente para
     * recorrer esa distancia. En tal caso se consume todo el depósito, se
     * recorre la distancia que sea posible, y se apaga el motor. También se
     * puede producir esta excepción si la distancia proporcionada es negativa.
     * @throws IllegalStateException Se producira una excepcion si intentamos
     * realizar un trayecto con el motor apagado
     * @throws IllegalArgumentException Se producira una excepcion si no hay
     * combustible suficiente para realizar el trayecto que se pasa como
     * parametro. Tambien nos informara de cuanta distancia nos ha faltado por
     * recorrer.
     */
    public void realizarTrayecto(double trayecto) {
        //variable local que me sirve para calcular cuantos litros voy a consumir en el trayecto
        double consumoTrayecto = (trayecto / 100) * consumoMedio;

        if (trayecto < 0) {

            throw new IllegalArgumentException("Error: Se intento realizar un trayecto negativo");

        } else if (isArrancado() == false) {

            throw new IllegalStateException("Error: Se intento realizar un trayecto con el motor apagado. No se ha avanzado");

        } else if ((nivelCombustible - consumoTrayecto) < 0) {

            //Calculo la distancia que me falta por recorrer
            double distanciaRestante = trayecto - (this.nivelCombustible / (this.consumoMedio) * 100);
            //añado el combustible consumido que es lo que nos queda en el deposito
            this.combustibleConsumido += this.nivelCombustible;
            this.combustibleConsumidoTotal += this.nivelCombustible;
            combustibleConsumidoFlota += this.nivelCombustible;
            //añado la distancia que el combustible nos permite recorrer
            this.distanciaRecorrida += ((this.nivelCombustible / (this.consumoMedio)) * 100);
            this.distanciaRecorridaTotal += ((this.nivelCombustible / (this.consumoMedio)) * 100);
            distanciaRecorridaFlota += ((this.nivelCombustible / (this.consumoMedio)) * 100);
            //Reinicio el deposito
            this.nivelCombustible = 0.; //setNivelCombustible(0.);
            //apago el motor
            apagar();

            //lanzo la excepcion
            throw new IllegalArgumentException("Error: No se ha podido finalizar el trayecto completamente. Deposito vacío. Han faltado por recorrer " + String.format("%.2f", distanciaRestante) + " km");

        } else {
            //Le quito al deposito lo que consume el trayecto
            this.nivelCombustible -= consumoTrayecto;
            //Le añado lo que recorro a la distancia
            this.distanciaRecorrida += trayecto;
            this.distanciaRecorridaTotal += trayecto;
            Vehiculo.distanciaRecorridaFlota += trayecto;
            //contabilizo el combustible que consumo
            this.combustibleConsumido += consumoTrayecto;
            this.combustibleConsumidoTotal += consumoTrayecto;
            combustibleConsumidoFlota += consumoTrayecto;

        }

    }

    /**
     * Apaga el motor del vehículo y reinicia a cero los indicadores de consumo
     * y distancia recorrida desde el último arranque.
     *
     * @throws IllegalStateException Si el motor ya está apagado.
     */
    public void apagar() {

        if (!isArrancado()) {
            throw new IllegalStateException("Error: El motor ya se encuentra apagado");
        } else {
            //elimino vehiculo arrancado por pasar a estado apagado

            numVehiculosArrancadosFlota = numVehiculosArrancadosFlota - 1;
            //pasamos a estado apagado
            arrancado = false;
            //reiniciamos combustible y distancia            

            this.combustibleConsumido = 0.;

            this.distanciaRecorrida = 0.;

        }

    }

    /**
     * **toString****
     */
    /**
     *
     *
     * @return
     * <p>
     * Cadena que representa el estado actual del vehículo proporcionando la
     * siguiente información:</p>
     * <ol>
     * <li><strong>Estado del motor</strong> (<strong>encendido</strong> o
     * <strong>apagado</strong>).</li>
     * <li><strong>Nivel del depósito de combustible</strong>.</li>
     * <li><strong>Distancia recorrida</strong> desde que se ha arrancado (si es
     * que el motor está arrancado, pues si está apagado será obviamente
     * cero).</li>
     * <li><strong>Consumo realizado</strong> desde que se ha arrancado (si es
     * que el motor está arrancado, pues si está apagado será obviamente
     * cero).</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será del siguiente tipo: </p>
     * <pre>Motor: XXX - Deposito: YYY - Dist: ZZZ - Consumo: VVV</pre>
     * <p>
     * donde XXX podrá ser encendido o apagado; YYY será el nivel del depósito
     * expresado en litros y con dos decimales; ZZZ será la distancia recorrida
     * expresada en kilómetros y con dos decimales, y VVV el consumo expresado
     * en litros y con dos decimales.</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>Motor: apagado   - Depósito:   0,00 - Dist:     0,00 - Consumo:     0,00</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,98 - Dist:     0,00 - Consumo:     0,02</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,23 - Dist:    15,00 - Consumo:     0,77</pre></li>
     * <li><pre>Motor: apagado   - Depósito:   4,23 - Dist:     0,00 - Consumo:     0,00</pre></li>
     * <li><pre>Motor: arrancado - Depósito:   4,68 - Dist:    10,00 - Consumo:     0,32</pre></li>
     * </ul>
     *
     */
    public String toString() {

        StringBuilder resultado = new StringBuilder("Motor: ");
        resultado.append(isArrancado() ? "arrancado":"apagado");
        resultado.append(" - Deposito: ");
        resultado.append((String.format("%.2f", getNivelCombustible())));
        resultado.append(" - Dist: ");
        resultado.append(getDistanciaRecorrida());
        resultado.append(" - Consumo: ");
        resultado.append((String.format("%.2f",getCombustibleConsumido())));

        return resultado.toString();
    }

}
