/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea06.juego.personajes;

/**
 * Clase que representa un <strong>personaje</strong> de tipo
 * <strong>escudero</strong> para un juego de rol.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un personaje de tipo escudero en un juego. Además de
 * los atributos propios de un personaje, deberá contener los específicos de un
 * escudero, que son:</p>
 * <ul>
 * <li><strong>Puntos de escudo</strong> del personaje (número real
 * positivo).</li>
 * <li><strong>Caballero</strong> al cual sirve este personaje. Todo escudero
 * debe servir siempre a un caballero.</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Escudero extends Personaje {

    /*-- Declaracion de Atributos --*/
    private double puntosEscudo = 0.;
    private Caballero caballero;

    private StringBuilder mensaje = new StringBuilder("");

    /*-- Constructores --*/
    /**
     * Constructor básico de la clase. Crea un objeto Escudero con un texto de
     * descripción "Sin descripcion". Su energía será 100.0, mientras que sus
     * puntos de escudo seán 0.0.
     *
     * @param nombre Nombre del personaje.
     * @param caballero Caballero al que está asignado el personaje (es
     * obligatorio asignarle un caballero).
     * @throws java.lang.IllegalArgumentException Si no se le pasa un caballero
     * correctamente creado.
     */
    public Escudero(String nombre, Caballero caballero) throws java.lang.IllegalArgumentException {
        super(nombre);
        checkCaballero(caballero);
        this.puntosEscudo = puntosEscudo;
        this.caballero = caballero;
        energia = 100.0;
    }

    /**
     * Constructor con parámetros. Crea un objeto Escudero con un nombre y un
     * texto de descripción. Su energía será 100.0, mientras que sus puntos de
     * escudo seán 0.0.
     *
     * @param nombre Nombre del personaje.
     * @param descripcion Descripción del personaje.
     * @param caballero Caballero al que está asignado el personaje (es
     * obligatorio asignarle un caballero).
     * @throws java.lang.IllegalArgumentException Si no se le pasa un caballero
     * correctamente creado.
     */
    public Escudero(String nombre, String descripcion, Caballero caballero) throws java.lang.IllegalArgumentException {
        super(nombre, descripcion);
        checkCaballero(caballero);
        this.puntosEscudo = puntosEscudo;
        this.caballero = caballero;
        energia = 100.0;
    }

    /*-- Metodos de accion --*/
    /**
     * Generación de saludo. Genera el texto de saludo de un escudero, que es
     * del tipo "Hola. Os saluda el escudero XXX al servicio del caballero YYY",
     * donde XXX es el nombre del escudero e YYY el nombre del caballero al que
     * sirve.
     *
     * @return Saludo del escudero.
     */
    @Override
    public String saludar() {

        mensaje.append("Hola. Os saluda el escudero ").append(getNombre())
                .append(" al servicio del caballero ").append(caballero.getNombre()).append(".");
        return mensaje.toString();
    }

    /**
     * Generación de despedida. Genera el texto de despedida de un soldado, que
     * es del tipo "Hasta luego."
     *
     * @return Despedida del escudero.
     */
    @Override
    public String despedirse() {

        mensaje.delete(0, mensaje.length());
        mensaje.append("Hasta luego");
        return mensaje.toString();

    }

    /*-- Metodos auxiliares --*/
    /*--Metodo privado para ser reutilizado y hacer el testeo del caballero,
    de esta forma solo se declara una vez el metodo y se instancia 2 veces,
    una vez en cada constructor--*/
    private void checkCaballero(Caballero caballero) {
        if (caballero == null) {
            throw new IllegalArgumentException("Error: Parámetros de creación del"
                    + " personaje no válidos. Un escudero debe tener caballero asignado");
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
     * <li>Puntos de <strong>escudo</strong> del personaje.</li>
     * <li><strong>Caballero</strong> al cual sirve el personaje.</li>
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será de la forma siguiente: </p>
     * <pre>{nombre: XXX; descripcion: YYY; energía: ZZZ; escudo: EEE; caballero: CCC}</pre>
     * <p>
     * donde XXX será el nombre del personaje; YYY la descripción; ZZZ la
     * energía (con dos decimales); EEE los puntos de escudo (con dos decimales)
     * y CCC el nombre del caballero al cual sirve.</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>{nombre: Jacob; descripcion: Sin descripcion; energía: 100,0; escudo: 0,00; caballero: Runciman}</pre></li>
     * <li><pre>{nombre: Gabriel; descripcion: Escudero de armas; energía: 100,0; escudo: 0,00; caballero: Rantor}</pre></li>
     * </ul>
     */
    @Override
    public String toString() {

        StringBuilder res = new StringBuilder(super.toString());

        res.deleteCharAt(res.length() - 1);
        res.append("; Escudo:").append(String.format("%.2f", this.puntosEscudo));
        res.append("; Caballero: ").append(this.caballero.getNombre());
        res.append('}');

        return res.toString();

    }

}
