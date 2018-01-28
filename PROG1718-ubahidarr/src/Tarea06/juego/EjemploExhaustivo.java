package Tarea06.juego;

import Tarea06.juego.personajes.Caballero;
import Tarea06.juego.personajes.Entrenable;
import Tarea06.juego.personajes.Escudero;
import Tarea06.juego.personajes.Mago;
import Tarea06.juego.personajes.Personaje;
import Tarea06.juego.personajes.Soldado;
import Tarea06.utilidades.ES;

/**
 * Clase de prueba no interactiva.
 * Contiene un pequeño programa no interactivo en el que se crean varios 
 * personajes y son sistemáticamente probados uno tras otro para observar cómo 
 * saludan, se entrenan (primero al 20%, luego al 50% y nuevamente al 20%)
 * y finalmente se despiden.
 * @author profe
 */
public class EjemploExhaustivo {

    // Disponemos de un array de personajes
    static int MAX_NUM_PERSONAJES= 10;
    static int numPersonajes= 0;
    static Personaje arrayPersonajes[]= new Personaje[MAX_NUM_PERSONAJES];

    /**
     * Método main: Programa de pruebas no interactivas basado en pruebas sistemáticas.
     * <p>El resultado final que debe producir en pantalla debería ser el siguiente:</p>
     * <pre>
     * Creando soldado...
     * Creando caballero...
     * Creando mago...
     * Creando escudero...
     * 
     * TRABAJO CON PERSONAJES DE JUEGO DE ROL
     * --------------------------------------
     * 
     * PERSONAJE 1: {nombre: Azkor; descripcion: Soldado imperial; energía: 100,0; fuerza: 0,00; escudo: 0,00}
     * Saludo del personaje: Saludos del soldado Azkor. A sus órdenes.
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Azkor; descripcion: Soldado imperial; energía: 80,0; fuerza: 20,00; escudo: 20,00}
     * Entrenando al personaje al 50%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Azkor; descripcion: Soldado imperial; energía: 40,0; fuerza: 60,00; escudo: 60,00}
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Azkor; descripcion: Soldado imperial; energía: 32,0; fuerza: 68,00; escudo: 68,00}
     * Despedida del personaje: El soldado Azkor se despide.
     * 
     * PERSONAJE 2: {nombre: Runciman; descripcion: Sin descripcion; energía: 100,0; fuerza: 0,00; escudo: 0,00}
     * Saludo del personaje: El caballero Runciman os saluda.
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Runciman; descripcion: Sin descripcion; energía: 80,0; fuerza: 30,00; escudo: 30,00}
     * Entrenando al personaje al 50%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Runciman; descripcion: Sin descripcion; energía: 40,0; fuerza: 90,00; escudo: 90,00}
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Runciman; descripcion: Sin descripcion; energía: 32,0; fuerza: 102,00; escudo: 102,00}
     * Despedida del personaje: El caballero Runciman se despide.
     * 
     * PERSONAJE 3: {nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 100,0; magia: 0,00}
     * Saludo del personaje: Te encuentras ante el mago Gandalf. Póstrate ante mi poder...
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 80,0; magia: 20,00}
     * Entrenando al personaje al 50%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 40,0; magia: 60,00}
     * Entrenando al personaje al 20%: Personaje entrenado.
     * Resultado tras el entrenamiento: {nombre: Gandalf; descripcion: Mago de la Tierra Media; energía: 32,0; magia: 68,00}
     * Despedida del personaje: El mago Gandalf se despide. Buena suerte y que la magia te acompañe.
     * 
     * PERSONAJE 4: {nombre: Jacob; descripcion: Sin descripcion; energía: 100,0; escudo: 0,00; caballero: Runciman}
     * Saludo del personaje: Saludos del escudero Jacob al servicio del caballero Runciman.
     * Entrenando al personaje al 20%: Error: Ese tipo de personaje no es entrenable.
     * Entrenando al personaje al 50%: Error: Ese tipo de personaje no es entrenable.
     * Entrenando al personaje al 20%: Error: Ese tipo de personaje no es entrenable.
     * Despedida del personaje: Hasta luego.
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
        
        
        // Empieza el juego: recorremos todos los personajes y los intentamos entrenar:
        // 1. Primero al 20%.
        // 2. A continuación al 50%.
        // 3. Por último de nuevo al 20%
        // Cada vez que se intente entrenar el personaje mostraremos su estado para observar el resultado del entrenamiento
        
        int opcion;
        boolean continuar = true;
        //La variable lógica continuar determinará cuándo salimos del programa.
        mostrarCabecera();
        for (int i=0; i<numPersonajes; i++) {
                Personaje personaje= arrayPersonajes[i];  // Referencia rápida para mayor brevedad
                // Mostramos al personaje                
                ES.msgln();
                ES.msgln ("PERSONAJE " + Integer.toString(i+1) +": " + personaje.toString() );
                // Saludo del personaje
                ES.msgln ("Saludo del personaje: " + personaje.saludar());

                // Entrenamos al personaje al 20% (si es posible)
                try {
                    ES.msg ("Entrenando al personaje al 20%: ");
                    ((Entrenable)personaje).entrenar (20.0);
                    ES.msgln ("Personaje entrenado.");
                    ES.msgln ("Resultado tras el entrenamiento: " + personaje.toString());
                } catch (IllegalArgumentException e) {
                    ES.msgln (e.getMessage());
                } catch (ClassCastException e) {
                    ES.msgln ("Error: Ese tipo de personaje no es entrenable.");
                } catch (Exception ex) {
                    ES.msgln ("Error desconocido: " + ex.getMessage());
                }                
                                
                // Entrenamos al personaje al 50% (si es posible)
                try {
                    ES.msg ("Entrenando al personaje al 50%: ");
                    ((Entrenable)personaje).entrenar (50.0);
                    ES.msgln ("Personaje entrenado.");
                    ES.msgln ("Resultado tras el entrenamiento: " + personaje.toString());
                } catch (IllegalArgumentException e) {
                    ES.msgln (e.getMessage());
                } catch (ClassCastException e) {
                    ES.msgln ("Error: Ese tipo de personaje no es entrenable.");
                } catch (Exception ex) {
                    ES.msgln ("Error desconocido: " + ex.getMessage());
                }                

                // Entrenamos al personaje al 20% (si es posible)
                try {
                    ES.msg ("Entrenando al personaje al 20%: ");
                    ((Entrenable)personaje).entrenar (20.0);
                    ES.msgln ("Personaje entrenado.");
                    ES.msgln ("Resultado tras el entrenamiento: " + personaje.toString());
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
