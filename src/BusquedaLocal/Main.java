package BusquedaLocal;

import java.util.*;

public class Main {
    public static final int ciudades = 10; // Definimos en esta constante el número de ciudades que habrá en la búsqueda
    public static List<Integer> Sinicial    = new ArrayList<Integer>();
    public static List<Integer> Distancias    = new ArrayList<Integer>();
    public static List<Integer> Vecinos     = new ArrayList<Integer>();

    public static void main(String[] args) {

        if(args.length==0){ // No se pasa ningún argumento
            FileRead.distancias("distancias_10.txt");
            FileRead.aleatorio();
        }
        else{
            if(args.length == 1){ // Se introdujo solo el archivo de distancias como argumento
                FileRead.distancias(args[0]);
                FileRead.aleatorio();
            }
            else{ // Se introdujo el archivo de distancias y el de aleatorios como argumento
                FileRead.distancias(args[0]);
                FileRead.aleatorio(args[1]);
            }
        }

    }
}
