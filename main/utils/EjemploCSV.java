package main.utils;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjemploCSV {

        public static void main(String[] args) {
           List<pregunta> preguntas = new ArrayList<pregunta>();

            preguntas.add(new pregunta("¿qué plato te gusta más?","pizza","hamburguesa","ensalada","pasta"));

            ExportarCSV(preguntas);

            ImportarCSV();
        }

        public static void ExportarCSV(List<pregunta> preguntas) {
            String salidaArchivo = "Preguntas.csv"; // Nombre del archivo
            boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

            // Si existe un archivo llamado asi lo borra
            if(existe) {
                File archivoPreguntas = new File(salidaArchivo);
                archivoPreguntas.delete();
            }

            try {
                // Crea el archivo
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                // Datos para identificar las columnas
                salidaCSV.write("Titulo");
                salidaCSV.write("Opcion 1");
                salidaCSV.write("Opcion 2");
                salidaCSV.write("opcion 3");
                salidaCSV.write("opcion 4");

                salidaCSV.endRecord(); // Deja de escribir en el archivo

                // Recorremos la lista y lo insertamos en el archivo
                for(pregunta quest : preguntas ) {
                    salidaCSV.write(quest.getTitulo());
                    salidaCSV.write(quest.getR1());
                    salidaCSV.write(quest.getR2());
                    salidaCSV.write(quest.getR3());
                    salidaCSV.write(quest.getR4());

                    salidaCSV.endRecord(); // Deja de escribir en el archivo
                }

                salidaCSV.close(); // Cierra el archivo

            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        public static void ImportarCSV() {
            try{
                List<pregunta> preguntas = new ArrayList<pregunta>(); // Lista donde guardaremos los datos del archivo

                CsvReader leerPreguntas = new CsvReader("Preguntas.csv");
                leerPreguntas.readHeaders();

                // Mientras haya lineas obtenemos los datos del archivo
                while(leerPreguntas.readRecord()) {
                    String titulo = leerPreguntas.get(0);
                    String R1 = leerPreguntas.get(1);
                    String R2 = leerPreguntas.get(2);
                    String R3 = leerPreguntas.get(3);
                    String R4 = leerPreguntas.get(4);
                    preguntas.add(new pregunta(titulo, R1, R2, R3, R4)); // Añade la informacion a la lista
                }

                leerPreguntas.close(); // Cierra el archivo

                // Recorremos la lista y la mostramos en la pantalla
                for(pregunta pregunta : preguntas) {
                    System.out.println(
                            pregunta.getTitulo() + " , "
                            + pregunta.getR1() + " , "
                            + pregunta.getR2() + " , "
                            + pregunta.getR3() + " , "
                            + pregunta.getR4());
                }

            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

