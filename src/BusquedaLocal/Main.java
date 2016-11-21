package BusquedaLocal;

import java.util.*;

public class Main {
    public static final int ciudades = 10; // Definimos en esta constante el número de ciudades que habrá en la búsqueda
    public static int vecinosGenerados = 0; // Variable global que lleva cuenta de el número de vecinos que hemos generado
    public static int posAleatorios = 0; // Variable global que lleva cuenta de el número de aleaorios que se han empleado
    public static List<Integer> Sinicial    = new ArrayList<Integer>();
    public static List<Integer> Distancias  = new ArrayList<Integer>();
    public static List<Integer> Vecinos     = new ArrayList<Integer>();
    public static List<Integer> Aleatorios  = new ArrayList<Integer>(); // Array que guardará enteros entre 0 y 8 leidos de un fichero


    public static void main(String[] args) {
        // Inicio etapa de inicialización
        if(args.length==0){ // No se pasa ningún argumento
            Operations.distancias("distancias_10.txt");
            Operations.aleatorio("aleatorios.txt");
        }
        else{
            if(args.length == 1){ // Se introdujo solo el archivo de distancias como argumento
                Operations.distancias(args[0]);
                Operations.aleatorio();
            }
            else{ // Se introdujo el archivo de distancias y el de aleatorios como argumento
                Operations.distancias(args[0]);
                Operations.aleatorio(args[1]);
            }
        }

        Operations.initializeNeighbors();
        int i=0;
        while(i<40){
            Operations.intercambioArch();
            i++;
        }

        i=0;
        System.out.print("Solución inicial: [ ");
        while(i<Sinicial.size()){
            System.out.print(Sinicial.get(i)+"; ");
            i++;
        }
        System.out.println("]");
        System.out.println("Distancia: "+Operations.calculoDistancia()+"Km");
    }
}
