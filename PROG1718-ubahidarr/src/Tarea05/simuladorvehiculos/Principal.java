package Tarea05.simuladorvehiculos;

import Tarea05.utilidades.ES;

/**
 *
 * @author profe
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int LONG_MARGEN = 25;

        Vehiculo flota[] = new Vehiculo[10];
        Vehiculo v1 = null, v2 = null, v3 = null;

        String margenEstadoVehiculo = relleno(' ', LONG_MARGEN);
        String justificacionAccionVehiculo = "%-" + LONG_MARGEN + "s";

        // Informes iniciales
        ES.msg(generaInformeFlota());

        // Pruebas con el vehículo v1
        ES.msgln();
        ES.msgln("PRUEBAS CON EL VEHÍCULO v1");
        ES.msgln("--------------------------");
        ES.msg(String.format(justificacionAccionVehiculo, "Fabricación v1(100,100): "));
        try {
            v1 = new Vehiculo(100.0, 100.0);
            ES.msgln("Vehículo creado sin error.");
        } catch (IllegalArgumentException e) {
            // Error al crear el vehículo con los parámetros proporcionados
            // Creamos el vehículo con el constructor por defecto
            ES.msg(e.getMessage());
            ES.msgln(" Se crea el vehículo con los valores por defecto.");
            v1 = new Vehiculo();
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v1.arrancar();
            ES.msgln("Vehículo arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Repostar 5 litros:"));
        try {
            v1.repostar(5);
            ES.msgln("Vehículo respostado sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v1.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 10 km: "));
        try {
            v1.realizarTrayecto(10.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer -50 km: "));
        try {
            v1.realizarTrayecto(-50.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 5 km: "));
        try {
            v1.realizarTrayecto(5.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Apagar: "));
        try {
            v1.apagar();
            ES.msgln("Motor apagado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v1.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v1.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
            //ES.msg (String.format (margenIzquierdo, ""));
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Repostar 5 litros: "));
        try {
            v1.repostar(5.0);
            ES.msgln("Vehículo repostado sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 500 km: "));
        try {
            v1.realizarTrayecto(500.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 500 km: "));
        try {
            v1.realizarTrayecto(500.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Apagar: "));
        try {
            v1.apagar();
            ES.msgln("Motor apagado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Repostar 300 litros: "));
        try {
            v1.repostar(300.0);
            ES.msgln("Vehículo repostado sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 500 km: "));
        try {
            v1.realizarTrayecto(500.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v1.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 100 km: "));
        try {
            v1.realizarTrayecto(100.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Apagar: "));
        try {
            v1.apagar();
            ES.msgln("Motor apagado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v1.toString());
        }

        // Informe final
        ES.msg(generaInformeVehiculo(v1, "v1"));
        ES.msg(generaInformeFlota());

        ES.msgln();
        ES.msgln("PRUEBAS CON EL VEHÍCULO v2");
        ES.msgln("--------------------------");
        ES.msg(String.format(justificacionAccionVehiculo, "Fabricación v2 (3.0,60.0): "));
        try {
            v2 = new Vehiculo(3.0, 60.0); // Vehículo con un consumo medio de 3l/100km y una capacidad de 60 litros
            ES.msgln("Vehículo creado sin error.");
        } catch (IllegalArgumentException e) {
            // Error al crear el vehículo con los parámetros proporcionadosç
            // Creamos el vehículo con el constructor por defecto
            ES.msg(e.getMessage());
            ES.msgln(" Se crea el vehículo con los valores por defecto.");
            v2 = new Vehiculo();
        } finally {
            ES.msgln(margenEstadoVehiculo + v2.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Repostar 5 litros:"));
        try {
            v2.repostar(5);
            ES.msgln("Vehículo respostado sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v2.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v2.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v2.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 10 km: "));
        try {
            v2.realizarTrayecto(10.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v2.toString());
        }

        // Informe final
        ES.msg(generaInformeVehiculo(v2, "v2"));
        ES.msg(generaInformeFlota());

        // Pruebas con el vehículo v3
        ES.msgln();
        ES.msgln("PRUEBAS CON EL VEHÍCULO v3");
        ES.msgln("--------------------------");
        // Introducir aquí el código necesario para llevar a cabo las siguientes cuatro acciones:
        // Crear objeto v3 con el constructor sin parámetros, arrancar , repostar 20 litros y recorer 100 km (dejarlo arrancado) 
        ES.msgln("Introducir aquí el código necesario para llevar a cabo las siguientes cuatro acciones:");
        ES.msg(String.format(justificacionAccionVehiculo, "Fabricación v3 (): "));
        try {
            v3 = new Vehiculo(); // Vehículo con un consumo medio de 3l/100km y una capacidad de 60 litros
            ES.msgln("Vehículo creado sin error.");
        } catch (IllegalArgumentException e) {
            // Error al crear el vehículo con los parámetros proporcionadosç
            // Creamos el vehículo con el constructor por defecto
            ES.msg(e.getMessage());
            ES.msgln(" Se crea el vehículo con los valores por defecto.");
            v3 = new Vehiculo();
        } finally {
            ES.msgln(margenEstadoVehiculo + v3.toString());
        }
        ES.msgln();
        ES.msg(String.format(justificacionAccionVehiculo, "Repostar 20 litros:"));
        try {
            v3.repostar(20);
            ES.msgln("Vehículo respostado sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v3.toString());
        }

        ES.msg(String.format(justificacionAccionVehiculo, "Arrancar: "));
        try {
            v3.arrancar();
            ES.msgln("Motor arrancado sin error.");
        } catch (IllegalStateException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v3.toString());
        }
        ES.msg(String.format(justificacionAccionVehiculo, "Recorrer 100 km: "));
        try {
            v3.realizarTrayecto(100.0);
            ES.msgln("Trayecto recorrido sin error.");
        } catch (IllegalStateException | IllegalArgumentException e) {
            ES.msgln(e.getMessage());
        } finally {
            ES.msgln(margenEstadoVehiculo + v3.toString());
        }

        // Informe final
        ES.msgln();
        ES.msg(generaInformeVehiculo(v3, "v3"));
        ES.msg(generaInformeFlota());

    }

    // Método para generar una cadena rellena con un caracter
    private static String relleno(char caracter, int longitud) {
        StringBuilder resultado = new StringBuilder(longitud);
        for (int i = 0; i < longitud; i++) {
            resultado.append(caracter);
        }
        return resultado.toString();
    }

    // Método para generar un informe sobre un vehículo
    private static String generaInformeVehiculo(Vehiculo v, String nombreVehiculo) {
        StringBuilder informe = new StringBuilder();
        String cabecera = "INFORME DEL VEHÍCULO " + nombreVehiculo;

        informe.append("\n" + cabecera + "\n");
        informe.append(relleno('-', cabecera.length()));
        if (v != null) {
            informe.append("\nCapacidad del depósito: ");
            informe.append(String.format("%5.2f", v.getCapacidadDeposito()));
            informe.append("\nConsumo medio del vehículo: ");
            informe.append(String.format("%5.2f", v.getConsumoMedio()));
            informe.append("\nDistancia recorrida por el vehículo en el período de encendido actual: ");
            informe.append(String.format("%5.2f", v.getDistanciaRecorrida()));
            informe.append("\nCombustible total consumido por el vehículo en el período de encendido actual: ");
            informe.append(String.format("%5.2f", v.getCombustibleConsumido()));
            informe.append("\nDistancia total recorrida por el vehículo desde su fabricación: ");
            informe.append(String.format("%5.2f", v.getDistanciaRecorridaTotal()));
            informe.append("\nCombustible total consumido por el vehículo desde su fabricación: ");
            informe.append(String.format("%5.2f", v.getCombustibleConsumidoTotal()));
        } else {
            informe.append("\nEl vehículo " + nombreVehiculo + " aún no existe.");
        }
        informe.append("\n\n");
        return informe.toString();
    }

    // Método para generar un informe sobre toda la flota de vehículos
    private static String generaInformeFlota() {
        StringBuilder informe = new StringBuilder();
        String cabecera = "INFORME GLOBAL DE LA FLOTA DE VEHÍCULOS";

        informe.append(cabecera + "\n");
        informe.append(relleno('-', cabecera.length()));
        informe.append("\nDistancia total recorrida por toda la flota: ");
        informe.append(String.format("%5.2f", Vehiculo.getDistanciaRecorridaFlota()));
        informe.append("\nCombustible total consumido por toda la flota: ");
        informe.append(String.format("%5.2f", Vehiculo.getCombustibleConsumidoFlota()));
        informe.append("\nNúmeo de vehículos de la flota con el motor encendido: ");
        informe.append(Vehiculo.getNumVehiculosArrancadosFlota());
        informe.append("\n\n");

        return informe.toString();
    }

}
