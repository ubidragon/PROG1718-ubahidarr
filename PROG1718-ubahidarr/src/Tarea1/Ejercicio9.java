/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tarea1;

import java.util.Scanner;

/**
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Ejercicio9 {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Double primera, segunda, tercera, cuarta, calculo;
        System.out.println("Calculo de Notas\n Bienvenido "
                + "al programa de calculo de nota final"
                + "\nEscribe la primera nota");

        Scanner reading = new Scanner(System.in);
        primera = reading.nextDouble();
        System.out.println("Escriba la segunda nota");
        segunda = reading.nextDouble();
        System.out.println("Escriba la tercera nota");
        tercera = reading.nextDouble();
        System.out.println("Escriba cuarta nota");
        cuarta = reading.nextDouble();
        
        
        calculo = (primera * 0.2 + segunda * 0.2) + (tercera * 0.3 + cuarta * 0.3);

        System.out.println("Su nota ponderada es: " + calculo);

    }
    
    
}
