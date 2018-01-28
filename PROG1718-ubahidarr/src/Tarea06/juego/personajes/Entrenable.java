/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea06.juego.personajes;

/**
 * Interfaz que incorpora la capacidad de ser entrenado.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public interface Entrenable {

    /**
     * Mínima energía permitida para el entrenamiento (porcentaje): 0.0.
     */
    static final double MIN_ENTRENAMIENTO = 0.0;

    /**
     * Máxima energía permitida para el entrenamiento (porcentaje): 100.0.
     */
    static final double MAX_ENTRENAMIENTO = 100.0;

    /**
     * Entrena al personaje.
     *
     * @param porcentaje Porcentaje de energía del pesonaje que se desea
     * utilizar para el entrenamiento
     * @throws IllegalArgumentException
     */
    void entrenar(double porcentaje) throws java.lang.IllegalArgumentException;

}
