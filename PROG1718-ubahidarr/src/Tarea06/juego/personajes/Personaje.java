package Tarea06.juego.personajes;

/**
 * Clase abastracta que representa un <strong>personaje</strong> para juego de
 * rol.
 * <p>
 * Los objetos de esta clase contienen atributos que permiten almacenar toda la
 * información relativa a un personaje de juegos del rol:</p>
 * <ul>
 * <li><strong>Nombre</strong> del personaje.</li>
 * <li><strong>Descripción</strong> del personaje.</li>
 * <li><strong>Energía del personaje</strong> (valor real en el rango
 * 0-100).</li>
 * </ul>
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public abstract class Personaje implements Hablador {

     /*-- Declaracion de Atributos --*/
    protected String nombre;
    protected String descripcion;
    protected double energia;

    /**
     * Máxima energía permitida.
     */
    protected static double MAX_ENERGIA = 100.0;

    /**
     * Mínima energía permitida.
     */
    protected static double MIN_ENERGIA = 0.0;

        /*-- Constructores --*/
    /**
     * Constructor básico de la clase. Crea un objeto Personaje con un texto de
     * descripción "Sin descripcion". Su energía será 100.0.
     *
     * @param nombre Nombre del personaje.
     */
    public Personaje(String nombre) {

        this(nombre, "Sin descripcion");
        energia = MAX_ENERGIA;
    }

    /**
     * Constructor con dos parámetros. Crea un objeto Personaje con un nombre y
     * un texto de descripción. Su energía será 100.0.
     *
     * @param nombre Nombre del personaje.
     * @param descripcion Descripción del personaje.
     */
    public Personaje(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        energia = MAX_ENERGIA;
    }

    /*-- Metodos de getters --*/
    /**
     * Devuelve el nombre del personaje
     *
     * @return Nombre del personaje
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la descripción del personaje
     *
     * @return Descripción del personaje
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve la energía actual del personaje
     *
     * @return Energía del personaje
     */
    public double getEnergia() {
        return energia;
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
     * </ol>
     * <p>
     * <strong>El formato de salida</strong> será de la forma siguiente: </p>
     * <pre>{nombre: XXX; descripcion: YYY; energía: ZZZ}</pre>
     * <p>
     * donde XXX será el nombre del personaje; YYY la descripción; ZZZ la
     * energía (con dos decimales).</p>
     * <p>
     * Algunos ejemplos de este <code>String</code> de salida podrían ser:</p>
     * <ul>
     * <li><pre>{nombre: Azkor; descripcion: Soldado imperial; energía: 100,0}</pre></li>
     * <li><pre>{nombre: Runciman; descripcion: Sin descripcion; energía: 80,0}</pre></li>
     * </ul>
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");

        res.append("nombre: ").append(getNombre());
        res.append("; descripcion: ").append(getDescripcion());
        res.append("; energia:").append(String.format("%.2f", getEnergia()));
        res.append('}');
        return res.toString();

    }

}
