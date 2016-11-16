package BusquedaLocal;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead{

    /*
        Función que mete los valores de las distancias presentes en el archivo ciudades en una lista
    */
    public static void distancias(String FileName){
        System.out.println(FileName);
        try{
            BufferedReader br = new BufferedReader(new FileReader(FileName)); // Abrimos el archivo
            int i=0, j=0;
            String line;
            String linesplitted[];
            while(i<Main.ciudades-1){
                line = br.readLine();
                linesplitted=line.split("\t");
                System.out.println("Distancias de la ciudad "+ (i+1)+":");
                while(j<linesplitted.length){
                    System.out.println("\t Distancia de la ciudad "+(i+1)+" con la ciudad "+j+": "+Integer.parseInt(linesplitted[j]));
                    Main.Distancias.add(Integer.parseInt(linesplitted[j]));
                    j++;
                }
                j=0;
                i++;
            }
            br.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        Función que realiza una inicialización de la lista Sinicial tomando valores aleatorios de un archivo si es posible, si no se crean esos valores aleatorios
        Existen condiciones especiales, si el aleatorio que se obtiene en la lista está generado, se incrementará en 1 su valor y se comprobará si ya está empleado,
        esto se hace para evitar tener que generar aleatorios demasiadas veces para una misma posición de la lista
    */
    public static void aleatorio(){
    }

    public static void aleatorio(String FileName){
    }
}
