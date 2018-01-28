/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea06.juego.personajes;

/**
 *
 * Clase que representa un <strong>personaje</strong> de tipo
 * <strong>soldado</strong> para un juego de rol.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un personaje de tipo soldado en un juego. Además de
 * los atributos propios de un personaje, deberá contener los específicos de un
 * soldado, que son:</p>
 * <ul>
 * <li><strong>Puntos de fuerza</strong> del personaje (número real
 * positivo).</li>
 * <li><strong>Puntos de escudo</strong> del personaje (número real
 * positivo).</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Soldado extends Personaje implements Entrenable {

    /*-- Declaracion de Atributos --*/
    private double puntosFuerza = 0.;
    private double puntosEscudo = 0.;

    StringBuilder mensaje = new StringBuilder("");

    /*-- Constructores --*/
    /**
     * Constructor básico de la clase. Crea un objeto Soldado con un texto de
     * descripción "Sin descripcion". Su energía será 100.0, mientras que sus
     * puntos de fuerza y escudo seán 0.0.
     *
     * @param nombre Nombre del personaje
     */
    public Soldado(String nombre) {
        super(nombre);
        energia = MIN_ENERGIA;
        this.puntosFuerza = puntosFuerza;
        this.puntosEscudo = puntosEscudo;
    }

    /**
     * Constructor con parámetros. Crea un objeto Soldado con un nombre y un
     * texto de descripción. Su energía será 100.0, mientras que sus puntos de
     * fuerza y escudo seán 0.0.
     *
     * @param nombre Nombre del personaje
     * @param descripcion Descripción del personaje
     */
    public Soldado(String nombre, String descripcion) {
        super(nombre, descripcion);
        energia = MAX_ENERGIA;
        this.puntosFuerza = puntosFuerza;
        this.puntosEscudo = puntosEscudo;
    }

    /*-- Metodos de accion --*/
    /**
     * Generación de saludo. Genera el texto de saludo de un soldado, que es del
     * tipo "Saludos del soldado XXX. A sus órdenes", donde XXX es el nombre del
     * soldado.
     *
     * @return Saludo del soldado.
     */
    @Override
    public String saludar() {

        mensaje.append("Saludos del soldado ").append(getNombre())
                .append(". A sus ordenes");
        return mensaje.toString();
    }

    /**
     * Generación de despedida. Genera el texto de despedida de un soldado, que
     * es del tipo "El soldado XXX se despide", donde XXX es el nombre del
     * soldado.
     *
     * @return Despedida del soldado.
     */
    @Override
    public String despedirse() {
        mensaje.delete(0, mensaje.length());
        mensaje.append("El soldado ").append(getNombre());
        mensaje.append(" se despide");
        return mensaje.toString();

    }

    /**
     * Entrenamiento de un soldado. Cuando un soldado se entrena, incrementa sus
     * puntos de fuerza y de escudo en una cantidad igual al porcentaje de
     * energía que se le pasa como parámetro. Ese porcentaje de energía será
     * perdido por el soldado al realizar su entrenamiento para mejorar sus
     * puntos de fuerza y de escudo.
     *
     * @param porcentaje Porcentaje de la energía del soldado que se desea
     * invertir en el entrenamiento.
     * @throws java.lang.IllegalArgumentException
     */
    public void entrenar(double porcentaje) throws java.lang.IllegalArgumentException {
        if (porcentaje < MIN_ENTRENAMIENTO || porcentaje > MAX_ENTRENAMIENTO) {

            throw new IllegalArgumentException("Error: Porcentaje de "
                    + "entrenamiento no valido");

        } else {

            this.puntosFuerza += ((porcentaje / 100) * this.energia);
            this.puntosEscudo += ((porcentaje / 100) * this.energia);
            this.energia = this.energia - (porcentaje / 100 * this.energia);

        }
    }

    /*-- toString --*/
    /**
     * Método que devuelve una representación textual del estado del personaje.
     *
     * @return
     * <p>
     * Cadena que representa el estado actual del personaje proporcionando la
     * siguiente información:</p>
     * <ol>
     * <li><strong>Nombre</strong> del personaje.</li>
     * <li><strong>Descripción</strong> del personaje.</li>
     * <li><strong>Energía</strong> del personaje.</li>
     * <li>Puntos de <strong>fuerza</strong> del personaje.</li>
     * <li>Puntos de <strong>escudo</strong> del personaje.</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será de la forma siguiente: </p>
     * <pre>{nombre: XXX; descripcion: YYY; energía: ZZZ; fuerza: FFF; escudo: EEE}</pre>
     * <p>
     * donde XXX será el nombre del personaje; YYY la descripción; ZZZ la
     * energía (con dos decimales); FFF los puntos de fuerza (con dos decimales)
     * y EEE los puntos de escudo (con dos decimales).</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>{nombre: Azkor; descripcion: Sin descripción; energía: 80,0; fuerza: 20,00; escudo: 20,00}</pre></li>
     * <li><pre>{nombre: Azkor; descripcion: Soldado imperial; energía: 32,0; fuerza: 68,00; escudo: 68,00}</pre></li>
     * </ul>
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());
        res.deleteCharAt(res.length() - 1);
        res.append("; Fuerza:").append(String.format("%.2f", this.puntosFuerza));
        res.append("; Escudo:").append(String.format("%.2f", this.puntosEscudo));
        res.append('}');
        return res.toString();

    }

}
