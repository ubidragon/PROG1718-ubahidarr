package Tarea07.caja;

import Tarea07.caja.Caja.Material;
import Tarea07.caja.utilidades.ES;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Clase principal del programa, que consiste en un bucle do-while que estar�
 * iterando continuamente mientras que el usuario no introduzca un 0.
 *
 * @author Ubaldo Hidalgo Arriaga
 */
public class Principal {

    /**
     * 
     * Metodo principal de la aplicacion
     *
     * @param args parametro estandart
     * @throws FileNotFoundException En caso de que no se encuentre el fichero
     * @throws IOException En caso de que haya un error de lectura y escritura
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        boolean key = false;
        Caja[] cajas = new Caja[30];
        String file = "cajas.dat";
        existFile(file, cajas);

        //Apertura del bucle
        while (key != true) {
            ES.msg(menu());
            int respuesta = ES.leeEntero();
            switch (respuesta) {
                case 0:
                    key = checkSave(cajas, file);
                    break;
                case 1:
                    addBoxStorage(cajas);
                    break;
                case 2:
                    ES.msg(boxList(cajas));
                    break;
                case 3:
                    deleteBox(cajas);
                    break;
                case 4:
                    saveInFile(cajas, file);
                    break;
                case 5:
                    resetFromFile(file, cajas);
                    break;
                case 6:
                    exportInventory(cajas);
                    break;
                default:
                    //Si se equivoca de opcion vuelve al menu
                    ES.msg(menu());
                    break;
            }

            // Cierre del bucle
        }

        System.out.println("\nSaliendo de la aplicacion de Gestion de Almacen");
    }

    /*Generacion del menu de la gestion del almacen*/
    /**
     * Generador del menu correspondiente que vera el usuario
     *
     * @return El menu
     * conformado:<br>========================================<br>
     * ========= Gestión del almacén ==========<br>
     * ========================================<br>
     * 1.- Añadir una caja.<br>
     * 2.- Listar cajas.<br>
     * 3.- Borrar una caja.<br>
     * 4.- Guardar datos en fichero.<br>
     * 5.- Recuperar datos desde fichero.<br>
     * 6.- Escribir lista de cajas a txt.<br>
     * 0.- Salir de la aplicación.<br> ========================================
     */
    private static String menu() {
        StringBuilder res = new StringBuilder();

        res.append("\n========================================")
                .append("\n========= Gestión del almacén ==========")
                .append("\n========================================")
                .append("\n1.- Añadir una caja.")
                .append("\n2.- Listar cajas.")
                .append("\n3.- Borrar una caja.")
                .append("\n4.- Guardar datos en fichero.")
                .append("\n5.- Recuperar datos desde fichero.")
                .append("\n6.- Escribir lista de cajas a txt.")
                .append("\n0.- Salir de la aplicación.")
                .append("\n========================================")
                .append("\nIntroduzca la opción elegida: ");
        return res.toString();

    }

    /*Metodo para comprobar que se han guardado los datos*/
    /**
     * Metodo auxiliar para comprobar si hay cambios desde que se inicio el
     * software
     *
     * @param cajas Cajas del almacen
     * @param file Fichero donde se guardaran los archivos
     * @return Cambia el estado de la variable del bucle del programa para poder
     * cerrar dicho programa
     * @throws IOException En caso de que se produzca un error de lectura o
     * escritura
     */
    private static boolean checkSave(Caja[] cajas, String file) throws IOException, NullPointerException {

        int statusAdd = 0;
        int statusDel = 0;
        int statusFile = 0;
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        try {

            for (int i = 0; i < cajas.length; i++) {
                String linea = buffer.readLine();
                if (!linea.contains("#")) {
                    statusAdd = new Integer(linea);
                } else if (linea.contains("#")) {
                    statusFile++;
                }
            }
            reader.close();
            buffer.close();
        } catch (NullPointerException e) {
            reader.close();
            buffer.close();
        } finally {

            for (int i = 0; i < cajas.length; i++) {
                if (cajas[i] != null) {
                    statusDel++;
                }
            }
            if (statusAdd != Caja.codigoGlobal || statusFile != statusDel) {
                String respuesta = ES.leeCadena("Va a salir de la aplicacion."
                        + "\n¿Esta seguro de que quiere salir?"
                        + "\nHay cambios que no se han guardado"
                        + "\n¿Desea guardarlos antes de salir? (S/N): ");
                if (respuesta.equalsIgnoreCase("S")) {
                    saveInFile(cajas, file);
                }
            }
        }
        boolean key = true;
        return key;
    }

    /*Metodo para realizar la comprobacion de que existe o no el fichero*/
    /**
     * Realizara la comprobacion de que exista el fichero
     *
     * @param file Cadena que contendra la ubicacion del fichero
     * @param cajas Array de cajas del almacen
     * @throws FileNotFoundException En caso de que el fichero no exista
     * @throws IOException Se produzca algun error de lectura o escritura
     */
    private static void existFile(String file, Caja[] cajas) throws FileNotFoundException, IOException {
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        try {

            //EjeX#EjeY#caracter#material
            for (int i = 0; i < cajas.length; i++) {
                String linea = buffer.readLine();

                if (!linea.contains("#")) {
                    Caja.codigoGlobal = new Integer(linea);
                } else if (linea.contains("#")) {
                    String[] trozos = linea.split("#");
                    int x = new Integer(trozos[0].trim());
                    int y = new Integer(trozos[1].trim());
                    char caracter = trozos[2].charAt(0);
                    Material material = Material.valueOf(trozos[3].trim());
                    int codigo = new Integer(trozos[4]);
                    cajas[i] = new Caja(x, y, caracter, material);
                    cajas[i].codigo = codigo;
                } else {
                    i = cajas.length;
                }
            }

            buffer.close();
            System.out.println("Datos del fichero cargados correctamente");

        } catch (FileNotFoundException e) {
            buffer.close();
            System.err.println("Error.\nAun no se han generado datos para la aplicacion");
        } catch (NullPointerException e) {
            buffer.close();
            System.out.println("Datos del fichero cargados correctamente");
        }

    }

    /*Opcion 1.a: Se encarga de crear la caja que añadiremos al almacen. */
    /**
     * Crea la caja segun los parametros que escoja el usuario
     *
     * @param cajas Contenido de cajas del almacen
     */
    private static void createBox(Caja[] cajas) {
        for (int i = 0; i < cajas.length; i++) {
            //Buscamos la primera posicion del array que este vacio para no pisar valores al añadir la caja
            if (cajas[i] == null) {
                ES.msgln("Primero vamos a crear la caja.");
                char caracter = ES.leeCaracter("Escriba un carácter para dibujar la caja");
                int columnas = ES.leeEntero("Escribe el número de columnas que tendrá la caja");
                int filas = ES.leeEntero("Escribe el número de filas que tendrá la caja");
                int materialNum = ES.leeEntero("Escriba el material de la caja (1-> MADERA, 2-> CORCHO, 3-> PLASTICO, 4-> CARTON)");
                Material material = Caja.enteroAMaterial(materialNum);
                Caja box = new Caja(columnas, filas, caracter, material);
                cajas[i] = box;
                ES.msg("Se ha añadido la nueva caja");
                i = cajas.length;
            }
        }
    }

    /*Opcion 1.b: Se encarga de añadir la caja creada al almacen, previa comprobacion de que el almacen tiene espacio suficiente*/
    /**
     * Comprueba que hay espacio en el almacen, si lo hay llama a createBox() y
     * añade la caja, en caso contrario lanza una excepcion.
     *
     * @param cajas Cajas que hay en el almacen
     */
    private static void addBoxStorage(Caja[] cajas) {
        int espacioLibre = 0;
        for (Caja caja : cajas) {
            if (caja == null) {
                espacioLibre++;
            }
        }
        if (espacioLibre == 0) {
            System.err.println("ERROR: almacen completo. No es posible dar de alta mas de 30 cajas");
        } else {
            createBox(cajas);
        }
    }

    /*Opcion 2: Listar el contenido del almacen y devolver el numero total de cajas*/
    /**
     * Lista el contenido del almacen
     *
     * @param cajas Cajas del almacen
     * @return Listado de cajas existentes con el formato:<br>
     * Lista de cajas del almacen<br>
     * --------------------------<br>
     * La caja de codigo: X se dibuja con el caracter: "X" y se dibujara con: X
     * columnas y Y filas. El material de la caja es: MATERIAL<br> El total de
     * cajas: X
     */
    private static String boxList(Caja[] cajas) {
        int numCajas = 0;
        StringBuilder res = new StringBuilder("\nLista de cajas del almacen");
        res.append("\n--------------------------");
        for (Caja caja : cajas) {
            if (caja != null) {
                res.append("\n").append(caja.toString());
                numCajas++;
            }
        }
        res.append("\nEl total de cajas: ").append(numCajas).append("\n");

        return res.toString();
    }

    /*Opcion 3: Eliminar caja para ello eliminaremos la caja a la que le corresponda el codigo correspondiente*/
    /**
     * Elimina del conjunto de cajas la que tenga el codigo que el usuario le
     * pasa por consola
     *
     * @param cajas Conjunto de cajas del almacen
     */
    private static void deleteBox(Caja[] cajas) throws NullPointerException {
        ES.msg("Introduzca el codigo de la caja a borrar: ");

        int codigo = ES.leeEntero();

        try {
            for (int i = 0; i < cajas.length; i++) {

                if (cajas[i].getCodigo() == codigo) {
                    ES.msg("Se procedera al borrado de la caja:\n");
                    ES.msg(cajas[i].toString());
                    ES.msg("\n¿Desea continuar con el borrado? (S/N):");
                    String respuesta = ES.leeCadena();
                    if (respuesta.equalsIgnoreCase("S")) {
                        cajas[i] = null;
                        System.out.println("La caja ha sido eliminada");
                    }
                    i = cajas.length;
                } else if ((i == cajas.length - 1) && (cajas[i].getCodigo() != codigo)) {
                    System.err.println("No existe la caja en el Almacen");
                }
            }

        } catch (NullPointerException e) {
            System.err.println("No existe la caja en el Almacen");
        }

    }

    /*Opcion 4: Guardar datos en fichero .dat*/
    /**
     * Metodo que guarda la informacion de las cajas en un fichero cajas.dat
     *
     * @param cajas Cajas del almacen
     * @param file Ubicacion del fichero dentro del directorio de archivos
     * @throws FileNotFoundException Si no se encuentra el fichero especificado
     * @throws IOException Si se produce un error de escritura o lectura
     */
    private static void saveInFile(Caja[] cajas, String file) throws FileNotFoundException, IOException {
        StringBuilder res = new StringBuilder();
        res.delete(0, cajas.length - 1);
        FileWriter writer = new FileWriter(file);
        PrintWriter buffer = new PrintWriter(writer);
        for (Caja c : cajas) {
            if (c != null) {
                res.append(c.getX()).append("#");
                res.append(c.getY()).append("#");
                res.append(c.getCaracter()).append("#");
                res.append(c.getMaterial()).append("#");
                res.append(c.getCodigo()).append("\n");
                buffer.write(res.toString());
                buffer.flush();
                res.delete(0, cajas.length - 1);
            }
        }
        String global = String.valueOf(Caja.codigoGlobal);
        buffer.write(global);
        ES.msg("Los datos del almacen se han guardado correctamente\n");
        buffer.close();
    }

    /*opcion 5: Restaura datos desde el fichero original*/
    /**
     * Restaura los datos desde el fichero original SOLO si se ha efectuado
     * algun cambio respecto al original
     *
     * @param file Ubicacion del fichero original
     * @param cajas Cajas que se encuentran en el almacen
     * @throws IOException Se ha producido un error de lectura o escritura
     */
    private static void resetFromFile(String file, Caja[] cajas) throws IOException {
        int statusAdd = 0;
        int statusDel = 0;
        int statusFile = 0;

        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        for (int i = 0; i < cajas.length; i++) {
            String linea = buffer.readLine();
            if (!linea.contains("#")) {
                statusAdd = new Integer(linea);
            } else if (linea.contains("#")) {
                statusFile++;
            }
        }
        buffer.close();
        for (int i = 0; i < cajas.length; i++) {
            if (cajas[i] != null) {
                statusDel++;
            }
        }
        if (statusAdd != Caja.codigoGlobal || statusFile != statusDel) {
            String respuesta = ES.leeCadena("Ha realizado cambios en disco"
                    + "\nSi continua la carga del archivo restauraran los datos de disco y se perderan los datos no guardados"
                    + "\n¿Desea continuar con la carga y restaurar los datos del archivo? (S/N): ");
            if (respuesta.equalsIgnoreCase("S")) {
                existFile(file, cajas);
            } else if (respuesta.contentEquals("N")) {
                ES.msg("Se ha cancelado la operacion de carga de datos");
            }
        }
        ES.msg("No hay nada que restaurar, la informacion actual es la misma que la del fichero\n");
    }

    /**/
    /**
     * Metodo de utilidad para realizar la exportacion del inventario de cajas
     * en formato txt, dando la opcion al usuario de nombrar dicho fichero como
     * quiera
     *
     * @param cajas Cajas para inventariar
     * @throws IOException En caso de producirse un eroor de lectura o escritura
     */
    private static void exportInventory(Caja[] cajas) throws IOException {
        StringBuilder res = new StringBuilder();
        StringBuilder msgFinal = new StringBuilder();

        try {
            res.append("\n============================================")
                    .append("\n========= Interfaz de exportacion ==========")
                    .append("\n============================================\n");
            ES.msg(res.toString());
            res.delete(0, res.length());
            res.append(ES.leeCadena("Inserte el nombre con el que desea nombrar al fichero: "));
            res.append(".txt");
            saveInFile(cajas, res.toString());
            FileReader reader = new FileReader(res.toString());
            msgFinal.append("Fichero ").append(res.toString()).append(" creado correctamente");
            ES.msg(msgFinal.toString());
            reader.close();
        } catch (FileNotFoundException e) {

            System.err.println("No se ha creado correctamente el fichero");
        }

    }

}
