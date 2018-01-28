package Tarea06.juego.personajes;

/**
 * Clase que representa un <strong>personaje</strong> de tipo
 * <strong>caballero</strong> para un juego de rol.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un personaje de tipo caballero en un juego. Además de
 * los atributos propios de un personaje, deberá contener los específicos de un
 * caballero, que son:</p>
 * <ul>
 * <li><strong>Puntos de fuerza</strong> del personaje (número entero
 * positivo).</li>
 * <li><strong>Puntos de escudo</strong> del personaje (número entero
 * positivo).</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Caballero extends Personaje implements Entrenable {

    /*-- Declaracion de Atributos --*/
    private double puntosFuerza = 0.;
    private double puntosEscudo = 0.;

    private StringBuilder mensaje = new StringBuilder("El caballero ");

    /*-- Constructores --*/
    /**
     * Constructor básico de la clase. Crea un objeto Caballero con un texto de
     * descripción "Sin descripcion".
     *
     * @param nombre Nombre del personaje.
     */
    public Caballero(String nombre) {
        super(nombre);
        energia = MAX_ENERGIA;
        this.puntosFuerza = puntosFuerza;
        this.puntosEscudo = puntosEscudo;

    }

    /**
     * Constructor con parámetros.
     *
     * @param nombre Nombre del personaje.
     * @param descripcion Descripción del personaje.
     */
    public Caballero(String nombre, String descripcion) {
        super(nombre, descripcion);
        energia = MAX_ENERGIA;
        this.puntosFuerza = puntosFuerza;
        this.puntosEscudo = puntosEscudo;
    }

    /*-- Metodos de accion --*/
    /**
     * Generación de saludo. Genera el texto de saludo de un caballero, que es
     * del tipo "El caballero XXX os saluda", donde XXX es el nombre del
     * caballero.
     *
     * @return Saludo del caballero.
     */
    @Override
    public String saludar() {

        mensaje.append(getNombre())
                .append(" os saluda");
        return mensaje.toString();
    }

    /**
     * Generación de despedida. Genera el texto de despedida de un caballero,
     * que es del tipo "El caballero XXX se despide", donde XXX es el nombre del
     * caballero.
     *
     * @return Despedida del caballero.
     */
    @Override
    public String despedirse() {
        mensaje.delete(mensaje.length() - 9, mensaje.length());
        mensaje.append("se despide");
        return mensaje.toString();
    }

    /**
     * Entrenamiento de un caballero. Cuando un caballero entrena, incrementa
     * sus puntos de fuerza y de escudo en una cantidad igual a una vez y media
     * el porcentaje de energía que se le pasa como parámetro. Esa energía será
     * perdida por el caballero al realizar su entrenamiento para mejorar sus
     * puntos de fuerza y de escudo.
     *
     * @param porcentaje Porcentaje de la energía del caballero que se desea
     * invertir en el entrenamiento.
     * @throws java.lang.IllegalArgumentException
     */
    @Override
    public void entrenar(double porcentaje) throws java.lang.IllegalArgumentException {
        if (porcentaje < MIN_ENTRENAMIENTO || porcentaje > MAX_ENTRENAMIENTO) {

            throw new IllegalArgumentException("Error: Porcentaje de "
                    + "entrenamiento no valido");

        } else {

            this.puntosFuerza += ((porcentaje / 100) * energia * 1.5);
            this.puntosEscudo += ((porcentaje / 100) * energia * 1.5);;
            energia = energia - (porcentaje / 100 * energia);

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
     * <li><pre>{nombre: Runciman; descripcion: Sin descripcion; energía: 100,0; fuerza: 0,00; escudo: 0,00}</pre></li>
     * <li><pre>{nombre: Runciman; descripcion: Caballero imperial; energía: 32,0; fuerza: 102,00; escudo: 102,00}</pre></li>
     * </ul
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
