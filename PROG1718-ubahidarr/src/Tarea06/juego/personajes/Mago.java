/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea06.juego.personajes;

/**
 * Clase que representa un <strong>personaje</strong> de tipo
 * <strong>mago</strong> para un juego de rol.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un personaje de tipo mago en un juego. Además de los
 * atributos propios de un personaje, deberá contener los específicos de un
 * mago, que son:</p>
 * <ul>
 * <li><strong>Puntos de magia</strong> del personaje (número real
 * positivo).</li>
 * </ul>
 *
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Mago extends Personaje implements Entrenable {

    /*-- Declaracion de Atributos --*/
    private double puntosMagia = 0.;

    private final StringBuilder mensaje = new StringBuilder("");

     /*-- Constructores --*/
    /**
     * Constructor básico de la clase. Crea un objeto Mago con un texto de
     * descripción "Sin descripcion". Su energía será 100.0, mientras que sus
     * puntos de magia seán 0.0.
     *
     * @param nombre Nombre del mago
     */
    public Mago(String nombre) {
        super(nombre);
        energia = MAX_ENERGIA;
        this.puntosMagia = puntosMagia;
    }

    /**
     * Constructor con parámetros. Crea un objeto Mago con un nombre y un texto
     * de descripción. Su energía será 100.0, mientras que sus puntos de magia
     * seán 0.0.
     *
     * @param nombre Nombre del mago
     * @param descripcion Descripción del mago
     */
    public Mago(String nombre, String descripcion) {
        super(nombre, descripcion);
        energia = MAX_ENERGIA;
        this.puntosMagia = puntosMagia;
    }

     /*-- Metodos de accion --*/
    /**
     * Generación de saludo. Genera el texto de saludo de un soldado, que es del
     * tipo "Te encuentras ante el mago XXX. Póstrate ante mi poder...", donde
     * XXX es el nombre del mago.
     *
     * @return Saludo del mago.
     */
    @Override
    public String saludar() {

        mensaje.append("Te encuentras ante el mago ").append(getNombre())
                .append(". Póstrate ante mi poder...");
        return mensaje.toString();
    }

    /**
     * Generación de despedida. Genera el texto de despedida de un mago, que es
     * del tipo "El mago XXX se despide. Buena suerte y que la magia te
     * acompañe.", donde XXX es el nombre del mago.
     *
     * @return Despedida del mago.
     */
    @Override
    public String despedirse() {
        mensaje.delete(0, mensaje.length());
        mensaje.append("El mago ").append(getNombre());
        mensaje.append(" se despide. Buena suerte y que la magia te acompañe");
        return mensaje.toString();

    }

    /**
     * Entrenamiento de un mago. Cuando un mago se entrena, incrementa sus
     * puntos de magia en una cantidad igual al porcentaje de energía que se le
     * pasa como parámetro. Ese porcentaje de energía será perdido por el mago
     * al realizar su entrenamiento para mejorar sus puntos de magia.
     *
     * @param porcentaje Porcentaje de la energía del mago que se desea invertir
     * en el entrenamiento.
     * @throws java.lang.IllegalArgumentException
     */
    public void entrenar(double porcentaje) throws java.lang.IllegalArgumentException {
        if (porcentaje < MIN_ENTRENAMIENTO || porcentaje > MAX_ENTRENAMIENTO) {

            throw new IllegalArgumentException("Error: Porcentaje de "
                    + "entrenamiento no valido");

        } else {

            this.puntosMagia += ((porcentaje / 100) * this.energia);
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
     * <li>Puntos de <strong>magia</strong> del personaje.</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será de la forma siguiente: </p>
     * <pre>{nombre: XXX; descripcion: YYY; energía: ZZZ; magia: MMM}</pre>
     * <p>
     * donde XXX será el nombre del personaje; YYY la descripción; ZZZ la
     * energía (con dos decimales) y MMM los puntos de magia (con dos
     * decimales).</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>{nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 80,0; magia: 20,00}</pre></li>
     * <li><pre>{nombre: Saruman; descripcion: Sin descripción; energía: 32,0; magia: 68,00}</pre></li>
     * </ul>
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(super.toString());

        res.deleteCharAt(res.length() - 1);
        res.append("; Magia:").append(String.format("%.2f", this.puntosMagia));
        res.append('}');

        return res.toString();

    }

}
