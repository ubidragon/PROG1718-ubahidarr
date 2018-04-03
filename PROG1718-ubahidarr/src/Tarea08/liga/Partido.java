/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea08.liga;

import java.time.LocalDate;

/**
 * Informacion de los partidos que se disputaran en la Temporada
 * <br>Tendra como atributos:
 * <ul>
 * <li>local: Equipo Local del Partido</li>
 * <li>visitante: Equipo Visitante del Partido</li>
 * <li>puntosLocal: Puntos que obtiene el Equipo que juega como Local</li>
 * <li>puntosVisitante: Puntos que obtiene el Equipo que juega como
 * Visitante</li>
 * <li>fecha: Fecha en la cual se celebrara el partido</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Partido implements Comparable<Partido> {

    /*Atributos*/
    private Equipo local = null;
    private Equipo visitante = null;
    private Integer puntosLocal = 0;
    private Integer puntosVisitante = 0;
    private LocalDate fecha = null;

    /*Constructor*/
    /**
     * Constructor basico para un Partido
     *
     * @param local Equipo que juega como Local
     * @param visitante Equipo que juega como Visitante
     * @param puntosLocal Puntos del Equipo Local
     * @param puntosVisitante Puntos del Equipo Visitante
     * @param fecha Fecha del Partido
     */
    public Partido(Equipo local, Equipo visitante, Integer puntosLocal, Integer puntosVisitante, LocalDate fecha) {
        /*Realizamos la comprobacion de las excepciones antes de la asignacion para evitar problemas de otro tipo*/
        checkEquipo(local);
        checkEquipo(visitante);
        checkPuntuacion(puntosLocal);
        checkPuntuacion(puntosVisitante);
        checkFecha(fecha);
        this.local = local;
        this.visitante = visitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.fecha = LocalDate.from(fecha);
    }

    /*Excepciones*/
 /*Metodo privado para comprobar que la puntuacion pasada no sea negativa*/
    private void checkPuntuacion(Integer puntos) {
        if (puntos < 0) {
            throw new NullPointerException("Los datos de creación del partido son erroneos.");
        }
    }

    /*Metodo privado para comprobar que el equipo no es nulo*/
    private void checkEquipo(Equipo equipo) {
        if (equipo == null) {
            throw new NullPointerException("Los datos de creación del partido son erroneos.");
        }
    }

    /*Metodo privado para comprobar que la fecha es correcta*/
    private static void checkFecha(LocalDate fecha) {
        if (fecha == null) {
            throw new NullPointerException("Los datos de creación del partido son erroneos.");
        } else if (fecha.isBefore(LocalDate.of(1990, 1, 1))) {
            throw new IllegalArgumentException("Los datos de creación del partido son erroneos.");
        }
    }

    /*Utilidades*/
    /**
     * Nombre del equipo que juega como Local
     *
     * @return El nombre del Equipo en cuestion
     */
    public String nombreEquipoLocal() {
        return this.local.getNombreEquipo();
    }

    /**
     * Nombre del equipo que juega como Visitante
     *
     * @return El nombre del Equipo en cuestion
     */
    public String nombreEquipoVisitante() {
        return this.visitante.getNombreEquipo();
    }

    /**
     * El equipo que ha ganado el partido
     *
     * @return El equipo local o visitante o ninguno en caso de empate
     */
    public Equipo equipoGanador() {
        Equipo res = null;

        if (this.puntosLocal > this.puntosVisitante) {
            res = this.local;
        } else if (this.puntosVisitante > this.puntosLocal) {
            res = this.visitante;
        }

        return res;
    }

    /**
     * Comparador de partidos
     *
     * @param p Partido que se le pasa como parametro
     * @return -1,0,1 en funcion de si es menor, igual o mayor la comparacion
     * entre dos partidos.
     */
    public int compareTo(Partido p) {
        int res = fecha.compareTo(p.fecha);
        if (res == 0) {

            res = nombreEquipoLocal().compareTo(p.nombreEquipoLocal());
            if (res == 0) {

                res = nombreEquipoVisitante().compareTo(p.nombreEquipoVisitante());
            }
        }
        return res;
    }

    /*toString*/
    /**
     * Informacion de todo el partido
     *
     * @return Fecha - Equipo Puntos - Equipo Puntos
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append(this.fecha);
        res.append(" - ");
        res.append(nombreEquipoLocal()).append(" ").append(puntosLocal);
        res.append(" - ");
        res.append(nombreEquipoVisitante()).append(" ").append(puntosVisitante);
        return res.toString();
    }

}
