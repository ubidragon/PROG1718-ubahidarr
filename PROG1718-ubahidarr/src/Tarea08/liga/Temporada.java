/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea08.liga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * Clase que representa a una <strong>Temporada</strong> de una Liga de
 * futbol<br>
 * Poseera como atributos:
 * <ul>
 * <li>equipos: Mapa con el <strong>nombre</strong> como clave y como valor el
 * tipo <strong>Equipo</strong></li>
 * <li>partidos: Conjunto de partidos de tipo <strong>Partido</strong></li>
 * <li>nombreTemporada: Cadena de texto que sera el nombre de la temporada</li>
 * </ul>
 *
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Temporada {

    /*Atributos*/
    private HashMap<String, Equipo> equipos = new HashMap<>();
    private Set<Partido> partidos = new HashSet<>();
    private String nombreTemporada = new String();

    /*Constructor*/
    /**
     * Constructor basico de la clase
     *
     * @param nombreTemporada Nombre que le asignaremos a la Temporada
     */
    public Temporada(String nombreTemporada) {
        this.equipos = new HashMap<>();
        this.partidos = new TreeSet<>();
        this.nombreTemporada = nombreTemporada;

    }

    /*Metodos de la clase*/
    /**
     * Nombre de la Temporada que estamos creando
     *
     * @return Nombre de la Temporada
     */
    public String getNombreTemporada() {
        return nombreTemporada;
    }

    /**
     * Operacion de añadir equipo a la Temporada que se esta realizando ahora
     * mismo
     *
     * @param team Equipo que añadiremos
     * @return Devolvera si se ha añadido correctamente el equipo a la temporada
     */
    public boolean añadirEquipo(Equipo team) {
        boolean res = false;

        if (!equipos.containsValue(team)) {
            equipos.put(team.getNombreEquipo(), team);
            res = true;
        }
        return res;
    }

    /**
     * Lista de los equipos que compiten en dicha temporada
     *
     * @return La lista completa de los equipos que participan en la Temporada
     */
    public List<Equipo> listaDeEquipos() {
        List<Equipo> res = new ArrayList<>();

        res.addAll(equipos.values());

        return res;

    }

    /**
     * Inserta partidos en la temporada que estamos creando
     *
     * @param part Partido que estamos añadiendo
     */
    public void insertarPartido(Partido part) {

        if (checkPartido(part)) {
            partidos.add(part);

        }

    }

    /**
     * Metodo de operacion para calcular todos los puntos de un equipo de la
     * temporada
     *
     * @param team Equipo al que calcularemos los puntos
     * @return El total de los puntos del Equipo
     */
    public Integer calcularPuntosEquipo(Equipo team) {

        Integer puntos = 0;

        for (Partido partido : partidos) {
            if (partido.equipoGanador() == null) {
                if (partido.nombreEquipoLocal().equals(team.getNombreEquipo())
                        || partido.nombreEquipoVisitante().equals(team.getNombreEquipo())) {
                    puntos += 1;
                }
            } else if (partido.equipoGanador().equals(team)) {
                puntos += 3;
            }

        }

        return puntos;
    }

    /**
     * Datos de los Partidos de un equipo
     *
     * @param e equipo del que diremos los partidos
     * @return La lista de partidos del equipo pasado como parametro
     */
    public String partidosToString(Equipo e) {
        StringBuilder res = new StringBuilder();

        if (e == null) {
            partidos.forEach(p -> res.append(p.toString()).append("\n"));
        } else {
            for (Partido partido : partidos) {
                if (partido.nombreEquipoLocal().equals(e.getNombreEquipo())
                        || partido.nombreEquipoVisitante().equals(e.getNombreEquipo())) {
                    res.append(partido.toString()).append("\n");
                }
            }
        }

        return res.toString();
    }

    /**
     * Lista de todos los partidos de la Temporada
     *
     * @return Lista total de los partidos que se realizan en la Temporada
     */
    public String partidosToString() {
        StringBuilder res = new StringBuilder();

        partidos.forEach(p -> res.append(p.toString()).append("\n"));

        return res.toString();
    }

    /*Operaciones secundarias
    Se han creado estos metodos para no dificultar la 
    lectura de la clase en vista a un futuro mantenimiento del codigo
     */
    private boolean checkPartido(Partido partido) {
        boolean res = false;

        for (Equipo team : listaDeEquipos()) {
            if (partido.nombreEquipoLocal().equals(team.getNombreEquipo())
                    || partido.nombreEquipoVisitante().equals(team.getNombreEquipo())) {
                if (listaDeEquipos().contains(team)) {
                    res = true;
                }

            }

        }

        return res;
    }

    private List<Equipo> partidosOrdenados() {
        List<Equipo> teamOrden = listaDeEquipos();

        class OrdenarEquipoPorPuntos implements Comparator<Equipo> {

            @Override
            public int compare(Equipo o1, Equipo o2) {
                return calcularPuntosEquipo(o2) - calcularPuntosEquipo(o1);
            }
        }

        Collections.sort(teamOrden, new OrdenarEquipoPorPuntos());
        return teamOrden;
    }

    /*toString*/
    /**
     * Informacion general de la Temporada
     *
     * @return Todos los equipos de la temporada junto con los puntos que han
     * obtenido
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(nombreTemporada)
                .append("\n-------------------\n")
                .append("Equipos participantes:")
                .append("\n-------------------\n");
        for (Equipo team : partidosOrdenados()) {

            res.append(team.toString()).append(" : ");
            res.append(calcularPuntosEquipo(team).toString());
            res.append("\n");
        }

        // teams.comparator();
        return res.toString();
    }

}
