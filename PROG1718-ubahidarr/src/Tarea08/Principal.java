package Tarea08;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import Tarea08.liga.Equipo;
import Tarea08.liga.Partido;
import Tarea08.liga.Temporada;

/**
 *
 * @author salva
 */
public class Principal {

    public static void main(String[] args) {
        
        /*  Código ejecutable después de realizar el apartado 1. */
        System.out.println("1.- Creación de equipos:");
        System.out.println("------------------------");
        
        Equipo zuazo = new Equipo("Zuazo", "Barakaldo");
        System.out.println("Creado equipo: "+zuazo);
        Equipo aula = new Equipo("Aula", "Valladolid");
        System.out.println("Creado equipo: "+aula);
        Equipo malaga = new Equipo("Málaga", "Málaga");
        System.out.println("Creado equipo: "+malaga);
        Equipo castellon = new Equipo("Castellón", "Castellón");
        System.out.println("Creado equipo: "+castellon);
                            
                   
        /* Código ejecutable después de realizar el apartado 2 y 3. */
        System.out.println("\n2.- Creación de los partidos:");
        System.out.println("-----------------------------");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d-M-y", Locale.getDefault());
        Partido p1 = new Partido(zuazo, aula, 17, 14, LocalDate.parse("18-12-2017", dtf));
        System.out.println(p1);
        Partido p2 = new Partido(aula, zuazo, 10, 16, LocalDate.parse("6-12-2017", dtf));
        System.out.println(p2);
        Partido p3 = new Partido(aula, malaga, 13, 19, LocalDate.parse("22-12-2017", dtf));
        System.out.println(p3);
        Partido p4 = new Partido(malaga, aula, 23, 11, LocalDate.parse("7-12-2017", dtf));
        System.out.println(p4);
        Partido p5 = new Partido(malaga, castellon, 13, 13, LocalDate.parse("8-12-2017", dtf));
        System.out.println(p5);
        Partido p6 = new Partido(castellon, malaga, 17, 18, LocalDate.parse("9-12-2017", dtf));
        System.out.println(p6);
        Partido p7 = new Partido(castellon, zuazo, 13, 18, LocalDate.parse("10-12-2017", dtf));
        System.out.println(p7);
        Partido p8 = new Partido(zuazo, castellon, 18, 9, LocalDate.parse("16-12-2017", dtf));
        System.out.println(p8);
        Partido p9 = new Partido(zuazo, malaga, 11, 11, LocalDate.parse("17-12-2017", dtf));
        System.out.println(p9);
        Partido p10 = new Partido(malaga, zuazo, 11, 17, LocalDate.parse("16-12-2017", dtf));
        System.out.println(p10);
        Partido p11 = new Partido(aula, castellon, 9, 15, LocalDate.parse("1-12-2017", dtf));
        System.out.println(p11);
        Partido p12 = new Partido(castellon, aula, 14, 16, LocalDate.parse("6-12-2017", dtf));
        System.out.println(p12);
       
        System.out.println();
        
        /* Código ejecutable después de hacer el apartado 4:*/
        
        Temporada t1 = new Temporada("División de Honor Femenina 2017/2018");
        
        /* Código ejecutable después de hacer el apartado 5: */
        
        t1.añadirEquipo(zuazo);
        t1.añadirEquipo(aula);
        t1.añadirEquipo(malaga);
        t1.añadirEquipo(castellon);
       
        /* Código ejecutable después de hacer el apartado 6: */
        System.out.println("\n3.- Los equipos insertados en la temporada son:");
        System.out.println("------------------------------------------------");
        t1.listaDeEquipos().forEach(System.out::println);
        System.out.println();

        /* Código ejecutable después de hacer el apartado 7: */
        t1.insertarPartido(p1);
        t1.insertarPartido(p2);
        t1.insertarPartido(p3);
        t1.insertarPartido(p4);
        t1.insertarPartido(p5);
        t1.insertarPartido(p6);
        t1.insertarPartido(p7);
        t1.insertarPartido(p8);
        t1.insertarPartido(p9);
        t1.insertarPartido(p10);
        t1.insertarPartido(p11);
        t1.insertarPartido(p12);
        
        /* Código ejecutable después de hacer el apartado 8. */
        System.out.println("\n4.- Los puntos de cada equipo son:");
        System.out.println("------------------------------------");
        t1.listaDeEquipos().stream()
                .map(e->e.getNombreEquipo()+": "+t1.calcularPuntosEquipo(e))
                .forEach(System.out::println);
        System.out.println();
              
        
        System.out.println("\n5.- Lista de partidos");
        System.out.println("-----------------------");
        System.out.println(t1.partidosToString(zuazo));
        System.out.println("\n5.- Lista de partidos");
        System.out.println("-----------------------");
        System.out.println(t1.partidosToString(aula));
        System.out.println("\n5.- Lista de partidos");
        System.out.println("-----------------------");
        System.out.println(t1.partidosToString(malaga));
        
        
        
        
        
        /* Código ejecutable después de hacer el apartado 9.
           (después al hacer el apartado 11 deberían salir ordenados por fecha) */
        System.out.println("\n5.- Lista de partidos");
        System.out.println("-----------------------");
        System.out.println(t1.partidosToString());
        
        /* Código ejecutable después de hacer el apartado 10.
           (después al hacer el apartado 11 deberían salir ordenados por fecha) */
        System.out.println("\n6.- Clasificación");
        System.out.println("-------------------");
        System.out.println(t1.toString());       

    }
}
