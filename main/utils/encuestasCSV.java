package main.utils;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import main.models.Encuesta;
import main.models.Pregunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class encuestasCSV {

            public static void main(String[] args) {
           List<Encuesta> encuestas = new ArrayList<Encuesta>();

            encuestas.add(new Encuesta("encuesta de cultura",0.01,"Nikkolay21"));

            ExportarCSV(encuestas);


            ImportarCSV();
        }

        public static void ExportarCSV(List<Encuesta> encuestas) {
            String salidaArchivo = "Encuesta.csv"; // Nombre del archivo
            boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

            // Si existe un archivo llamado asi lo borra
            if(existe) {
                File archivoEncuesta = new File(salidaArchivo);
                archivoEncuesta.delete();
            }

            try {
                // Crea el archivo
                CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

                // Datos para identificar las columnas
                salidaCSV.write("Titulo");
                salidaCSV.write("Remuneracion");
                salidaCSV.write("Nombre_Usuario");


                salidaCSV.endRecord(); // Deja de escribir en el archivo

                // Recorremos la lista y lo insertamos en el archivo
                for(Encuesta quest : encuestas ) {
                    salidaCSV.write(quest.getTitulo());
                    salidaCSV.write(String.valueOf(quest.getRemuneracion()));
                    salidaCSV.write(quest.getNombre_Usuario());


                    salidaCSV.endRecord(); // Deja de escribir en el archivo
                }

                salidaCSV.close(); // Cierra el archivo

            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        public static void ImportarCSV() {
            try{
                List<Encuesta> encuestas = new ArrayList<Encuesta>(); // Lista donde guardaremos los datos del archivo

                CsvReader leerEncuestas = new CsvReader("Encuesta.csv");
                leerEncuestas.readHeaders();

                // Mientras haya lineas obtenemos los datos del archivo
                while(leerEncuestas.readRecord()) {
                    String titulo = leerEncuestas.get(0);
                    double Remuneracion = Double.parseDouble(leerEncuestas.get(1));
                    String Nombre_Usuario = leerEncuestas.get(2);

                    encuestas.add(new Encuesta(titulo, Remuneracion, Nombre_Usuario)); // Añade la informacion a la lista
                }

                leerEncuestas.close(); // Cierra el archivo

                // Recorremos la lista y la mostramos en la pantalla
                for(Encuesta encuesta : encuestas) {
                    System.out.println(
                            encuesta.getTitulo() + " , "
                            + encuesta.getRemuneracion() + " , "
                            + encuesta.getNombre_Usuario());
                }

            } catch(FileNotFoundException e) {
                e.printStackTrace();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }

