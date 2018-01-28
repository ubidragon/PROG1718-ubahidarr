/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea06.juego.personajes;

/**
 *
 * Interfaz que incorpora la capacidad de saludar y despedirse.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public interface Hablador {

    /**
     * Genera saludo.
     *
     * @return Cadena de caracteres con saludo de un personaje
     */
    String saludar();

    /**
     * Genera despedida.
     *
     * @return Cadena de caracteres con despedida de un personaje
     */
    String despedirse();

}
