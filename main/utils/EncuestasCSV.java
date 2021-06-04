package main.utils;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import main.GUI.MenuPrincipal;
import main.controladores.ControladorCSV;
import main.controladores.ControladorEncuesta;
import main.models.Encuesta;
import main.models.Pregunta;
import main.models.Respuesta;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Esta clase tiene la función de importar y exportar las encuestas a un archivo CSV y viceversa, así podemos utilizar otros programas con las encuestas
 * El primer método sirve para exportar los datos de las encuestas a través del ID_Encuesta de la clase Encuesta.java, en el que se definen una serie de variables
 * ese ID_Encuesta sirve a su vez para conectar con las clases Encuesta.java y respuesta.java.
 * El otro método es para importar a la base de datos desde el mismo archivo Encuesta.csv, convirtiendo el texto
 * en variables que se envian y guardan a la base de datos.
 * */
//Esta clase interpreta el texto del archivo CSV y lo transforma en las variables que se introducen en la base de datos
public class EncuestasCSV {




    public static void main(String[] args) {


        ExportarCSV(19);


        ImportarCSV();



    }

    public static void ExportarCSV(int ID_Encuesta) {
        Encuesta enc = ControladorEncuesta.getEncuesta(ID_Encuesta);
        ArrayList<Pregunta> preguntas = enc.getPreguntas();
        //Aquí decimos el nombre del archivo que la clase tiene que interpretar
        String salidaArchivo = "Encuesta.csv"; // Nombre del archivo
        boolean existe = new File(salidaArchivo).exists(); // Verifica si existe

        // Si existe un archivo llamado asi lo borra
        if (existe) {
            File archivoEncuesta = new File(salidaArchivo);
            archivoEncuesta.delete();
        }

        try {
            // Crea el archivo
            CsvWriter salidaCSV = new CsvWriter(new FileWriter(salidaArchivo, true), ',');

            // Datos para identificar las columnas
            salidaCSV.write(enc.getTitulo());
            salidaCSV.write(String.valueOf(enc.getRemuneracion()));
            salidaCSV.write(enc.getNombre_Usuario());
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            salidaCSV.endRecord(); // Deja de escribir en el archivo
            salidaCSV.write(String.valueOf(preguntas));

            // Recorremos la lista y lo insertamos en el archivo







            salidaCSV.close(); // Cierra el archivo

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ImportarCSV() {
        //Este método sirve para acceder a la base de datos e inyectarle las nuevas variables
        try {
            CsvReader leerEncuestas = new CsvReader("Encuesta.csv", ',');

            leerEncuestas.readRecord();
            String titulo = leerEncuestas.get(0);
            double remuneracion = Double.parseDouble(leerEncuestas.get(1));
            String nombre_usuario = leerEncuestas.get(2);
            int numero_preguntas = 0;
            while (leerEncuestas.readRecord()) {
                numero_preguntas++;
            }
            leerEncuestas.close(); //Cierra el archivo
            int ID_Encuesta = ControladorCSV.añadirEncuesta(titulo, remuneracion, nombre_usuario, numero_preguntas); //Se crea la encuesta en la BD y se obtiene el id encuesta

            leerEncuestas = new CsvReader("Encuesta.csv", ',');
            leerEncuestas.readRecord();
            while (leerEncuestas.readRecord()) {
                //El titulo de la pregunta
                String tituloPregunta = leerEncuestas.get(0);
                //El id (se genera automáticamente)
                int ID_Pregunta = ControladorCSV.añadirPregunta(tituloPregunta, ID_Encuesta);
                //Las tres respuestas a la pregunta
                String respuesta1 = leerEncuestas.get(1);//Obtenemos las respuestas
                String respuesta2 = leerEncuestas.get(2);
                String respuesta3 = leerEncuestas.get(3);
                //se asocian las respuestas al ID_Pregunta
                ControladorCSV.añadirRespuesta(respuesta1, ID_Pregunta);
                ControladorCSV.añadirRespuesta(respuesta2, ID_Pregunta);
                ControladorCSV.añadirRespuesta(respuesta3, ID_Pregunta);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MenuPrincipal.main();
    }
}

