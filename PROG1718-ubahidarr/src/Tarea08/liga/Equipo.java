/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea08.liga;

/**
 * Informacion general de un equipo de la liga.<br>
 * Tendremos como atributos:
 * <ul>
 * <li>nombreEquipo: Que sera el nombre del equipo en cuestion</li>
 * <li>ciudad: Ciudad a la que pertenece el equipo en cuestion</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Equipo {

    /*Atributos*/
    private String nombreEquipo = new String();
    private String ciudad = new String();

    /*Constructor*/
    /**
     * Constructor basico de un Equipo
     * @param nombreEquipo Nombre que posee el equipo
     * @param ciudad Ciudad a la que pertenece el equipo
     */
    public Equipo(String nombreEquipo, String ciudad) {
        this.nombreEquipo = nombreEquipo;
        this.ciudad = ciudad;
    }

    /*Metodos*/
    /**
     * Nombre del equipo
     * @return nombre del equipo
     */
    public String getNombreEquipo() {
        return nombreEquipo;
    }

    /*toString*/
    /**
     * Informacion del Equipo
     * @return Nombre del Equipo (Ciudad)
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder(getNombreEquipo());
        res.append(" (").append(ciudad).append(")");

        return res.toString();
    }

}
