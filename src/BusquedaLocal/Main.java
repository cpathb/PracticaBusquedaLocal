package BusquedaLocal;

import java.util.*;

public class Main {
    public static final int ciudades = 10; // Definimos en esta constante el número de ciudades que habrá en la búsqueda
    public static int vecinosGenerados = 0; // Variable global que lleva cuenta de el número de vecinos que hemos generado
    public static int MaxVecinosGenerados = ((ciudades-1)*(ciudades-2)/2); // Variable global que lleva cuenta de el número de vecinos que hemos generado
    public static int posAleatorios = 0; // Variable global que lleva cuenta de el número de aleaorios que se han empleado
    public static int distanciaSolucion=0;
    public static int distanciaSolucionTemp=0;
    public static int numSolucion=0;
    public static List<Integer> Solucion    = new ArrayList<Integer>();
    public static List<Integer> SolucionTemp    = new ArrayList<Integer>();
    public static List<Integer> Distancias  = new ArrayList<Integer>();
    public static List<Integer> Vecinos     = new ArrayList<Integer>();
    public static List<Integer> Aleatorios  = new ArrayList<Integer>(); // Array que guardará enteros entre 0 y 8 leidos de un fichero


    public static void main(String[] args) {
        // Inicio etapa de inicialización
        if(args.length==0){ // No se pasa ningún argumento
            Operations.distancias("distancias.txt");
            Operations.aleatorio();
            distanciaSolucion=Operations.calculoDistancia(Solucion);
            Operations.initializeNeighbors();
            System.out.print("SOLUCION S_"+numSolucion+" -> [");
            Operations.printSolution(Solucion);
            System.out.println("]; "+ distanciaSolucion +"km");
            while(vecinosGenerados<MaxVecinosGenerados){
                Operations.intercambio();
            }
        }
        else{
            if(args.length == 1){ // Se introdujo solo el archivo de distancias como argumento
                Operations.distancias(args[0]);
                Operations.aleatorio();
                distanciaSolucion=Operations.calculoDistancia(Solucion);
                Operations.initializeNeighbors();
                System.out.print("SOLUCION S_"+numSolucion+" -> [");
                Operations.printSolution(Solucion);
                System.out.println("]; "+ distanciaSolucion +"km");
                while(vecinosGenerados<MaxVecinosGenerados){
                    Operations.intercambio();
                }
            }
            else{ // Se introdujo el archivo de distancias y el de aleatorios como argumento
                Operations.distancias(args[0]);
                Operations.aleatorio(args[1]);
                distanciaSolucion=Operations.calculoDistancia(Solucion);
                Operations.initializeNeighbors();
                System.out.print("SOLUCION S_"+numSolucion+" -> [");
                Operations.printSolution(Solucion);
                System.out.println("]; "+ distanciaSolucion +"km");
                while(vecinosGenerados<MaxVecinosGenerados){
                    Operations.intercambioArch();
                }
            }
        }
    }
}
