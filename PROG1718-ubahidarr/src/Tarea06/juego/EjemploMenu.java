package Tarea06.juego;

import Tarea06.juego.personajes.Caballero;
import Tarea06.juego.personajes.Entrenable;
import Tarea06.juego.personajes.Escudero;
import Tarea06.juego.personajes.Mago;
import Tarea06.juego.personajes.Personaje;
import Tarea06.juego.personajes.Soldado;
import Tarea06.utilidades.ES;

/**
 * Clase de prueba  interactiva.
 * Contiene un pequeño programa interactivo en el que se crean varios personajes y 
 * podremos elegir alguno de ellos para observar cómo nos saludan y se despiden, 
 * así como para entrenarlos con el valor de porcentaje de energía que se desee. 
 * De este modo se podrá probar si los métodos <code>toString</code>, <code>entrenar</code>, 
 * <code>saludar</code> y <code>despedirse</code> están funcionando correctamente para 
 * cada uno de los distintos tipos de personaje.
 * @author profe
 */
public class EjemploMenu {

    // Disponemos de un array de personajes
    static int MAX_NUM_PERSONAJES= 10;
    static int numPersonajes= 0;
    static Personaje arrayPersonajes[]= new Personaje[MAX_NUM_PERSONAJES];

    /**
     * Método main: Programa de pruebas interactivas basadas en un menú.
     * <p>El menú interactivo que aparece tendrá la siguiente forma:</p>
     * <pre>
     * TRABAJO CON PERSONAJES DE JUEGO DE ROL
     * --------------------------------------
     * [1] {nombre: Azkor; descripcion: Soldado imperial; energía: 100,0; fuerza: 0,00; escudo: 0,00}
     * [2] {nombre: Runciman; descripcion: Sin descripcion; energía: 100,0; fuerza: 0,00; escudo: 0,00}
     * [3] {nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 100,0; magia: 0,00}
     * [4] {nombre: Jacob; descripcion: Sin descripcion; energía: 100,0; escudo: 0,00; caballero: Runciman}
     * [0] Terminar y salir
     * 
     * Introduzca un número de personaje para entrenar: (1-4):      
     * </pre>
     * @param args Argumentos de la línea de órdenes
     */
    public static void main(String[] args) {
                
        // Intentamos crear algunos presonajes y los añadimos al array
        
        // Intentamos crear un soldado
        try {
            ES.msgln ("Creando soldado...");
            arrayPersonajes[numPersonajes]= new Soldado("Azkor", "Soldado imperial");
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }

        // Intentamos crear un caballero
        try {
            ES.msgln ("Creando caballero...");
            arrayPersonajes[numPersonajes]= new Caballero ("Runciman");
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }
        
        // Intentamos crear un mago
        try {
            ES.msgln ("Creando mago...");
            arrayPersonajes[numPersonajes]= new Mago ("Gandalf", "Mago de la Tierra Media");
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }

        // Intentamos crear un escudero
        try {
            ES.msgln ("Creando escudero...");
            arrayPersonajes[numPersonajes]= new Escudero ("Jacob", (Caballero) arrayPersonajes[1]);
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }

        // Intentamos crear un escudero sin caballero asignado (null): debe dar un error
        try {
            ES.msgln ("Creando escudero...");
            arrayPersonajes[numPersonajes]= new Escudero ("Ariel", "Ayuda de cámara de Rhin", null);
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }
        
        // Intentamos crear un escudero asignándolo a un soldado: debe dar un error
        try {
            ES.msgln ("Creando escudero...");
            arrayPersonajes[numPersonajes]= new Escudero ("Gabriel", "Ayuda de cámara de Azkor", (Caballero) arrayPersonajes[0]);
            numPersonajes++;
        } catch (IllegalArgumentException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (ClassCastException ex) {
            ES.msgln ("Error durante la creación del personaje: " + ex.getMessage());
        } catch (Exception ex) {
            ES.msgln ("Error desconocido: " + ex.getMessage());
        }
        
        
        // Empieza el juego: recorremos todos los personajes para que:
        // Aparece un menú para poder elegir cualquier personaje disponible  (0 para salir)
        // Se elige un personaje
        // Observamos su estado actual
        // Se nos pide un porcentaje de energía para entrenarlo
        // El personaje nos saluda
        // Se intenta entrenar
        // Volvemos a observar su estado tras el intento de entrenamiento
        // Vuelve a aparecer el menú (0 para salir)
        
        int opcion;
        boolean continuar = true;
        //La variable lógica continuar determinará cuándo salimos del programa.
        do {
            /*
             * Presentamos en pantalla el menú, tras cada operación, para asegurarnos de que siempre va a estar visible
             * justo encima de la petición de la opción.
             */

            // Mostramos el menú y solictamos una opción
            opcion= menu();
            
            if (opcion==0)
                // Si la opción es salir, finaliza el bucle general
                continuar= false;
            else {  
                // Si se elige cualquier otra opción, se solicitan la cantidad de energía
                // para el entrenamiento del personaje
                Personaje personaje= arrayPersonajes [opcion-1];

                // Introducimos el porcentaje de energía para el entrenamiento
                float porcentaje= ES.leeReal("Introduzca un porcentaje de energía para dedicar al entrenamiento (0-100): ");        
                
                // Saludo del personaje
                ES.msgln ("Saludo del personaje: " + personaje.saludar());
                
                // Entrenamos al persnaje (si es posible)
                try {
                    ((Entrenable)personaje).entrenar (porcentaje);
                    ES.msgln ("Personaje entrenado.");
                } catch (IllegalArgumentException e) {
                    ES.msgln (e.getMessage());
                } catch (ClassCastException e) {
                    ES.msgln ("Error: Ese tipo de personaje no es entrenable.");
                } catch (Exception ex) {
                    ES.msgln ("Error desconocido: " + ex.getMessage());
                }                

                // Despedida del personaje
                ES.msgln ("Despedida del personaje: " + personaje.despedirse());
            }

        } while (continuar);            
        

    }

    private static int menu () {
        int opcion;
        
        mostrarCabecera();
        for (int i=0; i<numPersonajes; i++) {
            ES.msgln("[" + (i+1) + "] " + arrayPersonajes[i].toString() );
        }
        ES.msgln("[0] Terminar y salir");
        ES.msgln ();

        // Lectura de opciones
        opcion= ES.leeEntero ("Introduzca un número de personaje para entrenar: (1-" + numPersonajes + "): ", 0, numPersonajes);
        return opcion;
    }
        
    private static String relleno (String cadena, int veces)
    {
        StringBuilder acumulador= new StringBuilder ();
        
        for (int i=0; i<veces; i++) {
            acumulador.append(cadena);
        }
        
        return acumulador.toString();
    }

    private static void mostrarCabecera () {
        String titulo= "TRABAJO CON PERSONAJES DE JUEGO DE ROL";
        ES.msgln();
        ES.msgln(titulo);
        ES.msgln (relleno("-", titulo.length()));
    }

    
}
