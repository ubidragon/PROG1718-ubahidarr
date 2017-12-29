/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea05.simuladorvehiculos;

/**
 * Clase para generar vehiculos y realizar operaciones con ellos. Tambien
 * podremos llevar estadisticas de los mismos a nivel individual, como a nivel
 * de flota.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Vehiculo {

    private double capacidadDeposito, consumoMedio, nivelCombustible, distanciaRecorrida, combustibleConsumido, distanciaRecorridaTotal, combustibleConsumidoTotal;

    private boolean arrancado = false;

    private static double distanciaRecorridaFlota = 0.;
    private static double combustibleConsumidoFlota = 0.;
    private static long numVehiculosArrancadosFlota = 0L;

    private final double MINIMO_CONSUMO_MEDIO = 2.;
    private final double MAXIMO_CONSUMO_MEDIO = 20.;
    private final double MINIMA_CAPACIDAD_DEPOSITO = 10.;
    private final double MAXIMA_CAPACIDAD_DEPOSITO = 120.;
    private final double CONSUMO_MEDIO_PREDETERMINADO = 5.;
    private final double CAPACIDAD_DEPOSITO_PREDETERMINADA = 50.;
    private final double CONSUMO_COMBUSTIBLE_ARRANQUE = 0.02;

    /**
     * Metodo getter con la capcidad del deposito
     *
     * @return capacidad del vehiculo
     */
    public double getCapacidadDeposito() {
        return capacidadDeposito;
    }

    /**
     * Metodo getter con el consumo medio del vehiculo
     *
     * @return consumo del vehiculo
     */
    public double getConsumoMedio() {
        return consumoMedio;
    }

    /**
     * Metodo getter con el nivel de combustible del deposito
     *
     * @return El combustible restante en el deposito
     */
    public double getNivelCombustible() {
        return nivelCombustible;
    }

    /**
     * Metodo setter del Nivel de Combustible
     *
     * @param nivelCombustible parametro del nuevo nivel de combustible
     */
    public void setNivelCombustible(double nivelCombustible) {
        this.nivelCombustible = nivelCombustible;
    }

    /**
     * Metodo getter de la distancia recorrida desde que se arranco el coche
     *
     * @return distancia recorrida desde el ultimo arranque
     */
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    /**
     * Metodo para modificar la distancia que ha recorrido el vehiculo
     *
     * @param distanciaRecorrida nueva distancia recorrida desde el arranque
     */
    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    /**
     * Metodo getter del Combustible que ha consumido el vehiculo desde que se
     * arranco
     *
     * @return el combustible que lleva consumido
     */
    public double getCombustibleConsumido() {
        return combustibleConsumido;
    }

    /**
     * Metodo para modificar el combustible consumido desde el arranque
     *
     * @param combustibleConsumido cambia a un nuevo valor el combustible que
     * lleva consumido el vehiculo
     */
    public void setCombustibleConsumido(double combustibleConsumido) {
        this.combustibleConsumido = combustibleConsumido;
    }

    /**
     * Metodo getter de la distancia que hay recorrido el vehiculo desde que
     * este se creo
     *
     * @return devuelve la distancia total que ha recorrido
     */
    public double getDistanciaRecorridaTotal() {
        return distanciaRecorridaTotal;
    }

    /**
     * Metodo para modificar la distancia que lleva recorrida el vehiculo desde
     * que este se creo
     *
     * @param distanciaRecorridaTotal nueva distancia que ha recorrido el
     * vehiculo
     */
    public void setDistanciaRecorridaTotal(double distanciaRecorridaTotal) {
        this.distanciaRecorridaTotal = distanciaRecorridaTotal;
    }

    /**
     * Metodo getter del combustible que lleva consumido el vehiculo desde que
     * este fue generado
     *
     * @return El combustible que lleva consumido
     */
    public double getCombustibleConsumidoTotal() {
        return combustibleConsumidoTotal;
    }

    /**
     * Metodo para modificar el combustible que se ha consumido desde la
     * creacion del vehiculo
     *
     * @param combustibleConsumidoTotal nuevo combustible consumido
     */
    public void setCombustibleConsumidoTotal(double combustibleConsumidoTotal) {
        this.combustibleConsumidoTotal = combustibleConsumidoTotal;
    }

    /**
     * Metodo getter para saber si esta arrancado o no
     *
     * @return true o false son los valores de arrancado
     */
    public boolean isArrancado() {
        return arrancado;
    }

    /**
     * Metodo para modificar el estado del vehiculo
     *
     * @param arrancado true o false en funcion de su nuevo estado
     */
    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    /**
     * Metodo getter para saber la distancia recorrida en computo general de
     * toda la flota de vehiculos
     *
     * @return el numero de kilometros que ha recorrido toda la flota
     */
    public static double getDistanciaRecorridaFlota() {

        return distanciaRecorridaFlota;
    }

    /**
     * Metodo que modifica el valor de la distancia que ha recorrido en computo
     * general toda la flota
     *
     * @param distanciaRecorridaFlota la nueva distancia recorrida por la flota
     */
    public static void setDistanciaRecorridaFlota(double distanciaRecorridaFlota) {

        Vehiculo.distanciaRecorridaFlota = distanciaRecorridaFlota;
    }

    /**
     * Metodo para modificar el numero total de litros consumidos por la flota
     *
     * @param combustibleConsumidoFlota el nuevo numero de combustible consumido
     * por la flota
     */
    public static void setCombustibleConsumidoFlota(double combustibleConsumidoFlota) {

        Vehiculo.combustibleConsumidoFlota = combustibleConsumidoFlota;
    }

    /**
     * Metodo para actualizar el valor del numero de vehiculos arrancados en ese
     * momento
     *
     * @param numVehiculosArrancadosFlota numero de vehiculos arrancados
     */
    public static void setNumVehiculosArrancadosFlota(long numVehiculosArrancadosFlota) {
        Vehiculo.numVehiculosArrancadosFlota = numVehiculosArrancadosFlota;
    }

    /**
     * Metodo getter statico del combustible total consumido por todos los
     * vehiculos de la flota
     *
     * @return El combustible consumido de toda la flota
     */
    public static double getCombustibleConsumidoFlota() {

        return combustibleConsumidoFlota;
    }

    /**
     * Metodo getter statico para determinar cuantos vehiculos se encuentran
     * arrancados en este momento
     *
     * @return el numero de vehiculos arrancados
     */
    public static long getNumVehiculosArrancadosFlota() {

        return numVehiculosArrancadosFlota;
    }

    /**
     * Metodo constructor por defecto.
     *
     */
    public Vehiculo() {

        this.capacidadDeposito = CAPACIDAD_DEPOSITO_PREDETERMINADA;
        this.consumoMedio = CONSUMO_MEDIO_PREDETERMINADO;

    }

    /**
     * Metodo constructor a partir de parametros
     *
     * @param capacidadDeposito capacidad del deposito del vehiculo
     * @param consumoMedio consumo del vehiculo
     *
     * @throws IllegalArgumentException Se puede producir por una capacidad o
     * consumo erroneo respecto a los maximos o minimos preestablecidos
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
     * Metodo para repostar vehiculos
     *
     * @param litros numero de litros que vamos a repostar
     * @throws IllegalStateException Si se intenta repostar con el motor
     * encendido saltara una excepcion ya que no se puede repostar estando el
     * vehiculo encendido.
     * @throws IllegalArgumentException Si se intenta repostar mas litros de los
     * que le puede caber al deposito se lanza una excepcion para indicarnos
     * cuantos litros se han desbordado.
     */
    public void repostar(double litros) {

        if (isArrancado()) {
            throw new IllegalStateException("Error: Se intento repostar con el motor encendido. No se ha repostado");

        } else if (capacidadDeposito < (nivelCombustible + litros)) {
            double desbordado = ((nivelCombustible + litros) - capacidadDeposito);
            setNivelCombustible(getNivelCombustible() + litros - desbordado);
            throw new IllegalArgumentException("Error: Deposito lleno. Se ha desbordado el combustible en " + desbordado + " litros");
        } else {

            setNivelCombustible(getNivelCombustible() + litros);
        }
    }

    /**
     * Metodo para realziar el arranque del vehiculo
     *
     * @throws IllegalStateException Se produce si intentamos arrancar el motor
     * estando este ya encendido
     * @throws IllegalStateException Se produce si intentamos arrancar el
     * vehiculo con el deposito vacio
     */
    public void arrancar() {

        if (isArrancado()) {

            throw new IllegalStateException("Error: el motor ya se encuentra arrancado");

        } else if (nivelCombustible < CONSUMO_COMBUSTIBLE_ARRANQUE) {

            throw new IllegalStateException("Error: Deposito vacio. Se intento arrancar sin combustible suficiente. ");

        } else {
            //pasamos a estado arrancado
            setArrancado(true);
            //añado vehiculo arrancado
            setNumVehiculosArrancadosFlota(getNumVehiculosArrancadosFlota() + 1);
            setNivelCombustible(getNivelCombustible() - CONSUMO_COMBUSTIBLE_ARRANQUE);
            setCombustibleConsumido(getCombustibleConsumido() + CONSUMO_COMBUSTIBLE_ARRANQUE);
            setCombustibleConsumidoTotal(getCombustibleConsumidoTotal() + CONSUMO_COMBUSTIBLE_ARRANQUE);
            setCombustibleConsumidoFlota(getCombustibleConsumidoFlota() + CONSUMO_COMBUSTIBLE_ARRANQUE);
        }
    }

    /**
     * Metodo para realizar un trayecto con distancia que le pasemos como
     * parametro. Tambien actualizara todos los datos referidos a Combustible y
     * Distancia.
     *
     * @param trayecto distancia que se intentara recorrer
     * @throws IllegalArgumentException Se producira una excepcion si se intenta
     * recorrer una distancia negativa
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

        } else if (!isArrancado()) {

            throw new IllegalStateException("Error: Se intento realizar un trayecto con el motor apagado. No se ha avanzado");

        } else if ((nivelCombustible - consumoTrayecto) < 0) {

            //Calculo la distancia que me falta por recorrer
            double distanciaRestante = trayecto - (nivelCombustible / (consumoMedio) * 100);
            //añado el combustible consumido que es lo que nos queda en el deposito
            setCombustibleConsumido(getCombustibleConsumido() + nivelCombustible);
            setCombustibleConsumidoTotal(getCombustibleConsumidoTotal() + nivelCombustible);
            setCombustibleConsumidoFlota(getCombustibleConsumidoFlota() + nivelCombustible);
            //añado la distancia que el combustible nos permite recorrer
            setDistanciaRecorrida(getDistanciaRecorrida() + (nivelCombustible / (consumoMedio)) * 100);
            setDistanciaRecorridaTotal(getDistanciaRecorridaTotal() + (nivelCombustible / (consumoMedio)) * 100);
            setDistanciaRecorridaFlota(getDistanciaRecorridaFlota() + (nivelCombustible / (consumoMedio)) * 100);
            //Reinicio el deposito
            setNivelCombustible(0.);
            //apago el motor
            apagar();

            //lanzo la excepcion
            throw new IllegalArgumentException("Error: No se ha podido finalizar el trayecto completamente. Deposito vacío. Han faltado por recorrer " + String.format("%.2f", distanciaRestante) + " km");

        } else {
            //Le quito al deposito lo que consume el trayecto

            setNivelCombustible(getNivelCombustible() - consumoTrayecto);
            //Le añado lo que recorro a la distancia
            setDistanciaRecorrida(getDistanciaRecorrida() + trayecto);
            setDistanciaRecorridaTotal(getDistanciaRecorridaTotal() + trayecto);
            setDistanciaRecorridaFlota(getDistanciaRecorridaFlota() + trayecto);
            //contabilizo el combustible que consumo
            setCombustibleConsumido(getCombustibleConsumido() + consumoTrayecto);
            setCombustibleConsumidoTotal(getCombustibleConsumidoTotal() + consumoTrayecto);
            setCombustibleConsumidoFlota(getCombustibleConsumidoFlota() + consumoTrayecto);

        }

    }

    /**
     * Metodo para realizar el apagado del motor. Tambien reiniciar los
     * parametros de Combustible y Distancia que se establecieron mientras el
     * motor estuvo arrancado
     *
     * @throws IllegalStateException Se producira una excepcion si el motor ya
     * se encuentra apagado. No realizara ninguna operacion mas.
     */
    public void apagar() {

        if (!isArrancado()) {
            throw new IllegalStateException("Error: El motor ya se encuentra apagado");
        } else {
            //elimino vehiculo arrancado por pasar a estado apagado
            setNumVehiculosArrancadosFlota(getNumVehiculosArrancadosFlota() - 1);
            //pasamos a estado apagado
            setArrancado(false);
            //reiniciamos combustible y distancia            
            setCombustibleConsumido(0.);
            setDistanciaRecorrida(0.);

        }

    }

    /**
     * Metodo toString de la clase, con el que imprimiremos por pantalla los
     * datos referidos al vehiculo
     *
     * @return un string con los datos de si esta arrancado o no, el nivel del
     * deposito, la distancia recorrida y finalmente el combustible que hayamos
     * consumido
     *
     */
    public String toString() {
        return "Motor: " + (isArrancado() ? "arrancado" : "apagado") + " - Deposito: "
                + (String.format("%.2f", getNivelCombustible())) + " - Dist: "
                + getDistanciaRecorrida() + " - Consumo: "
                + (String.format("%.2f", getCombustibleConsumido()));
    }

}
