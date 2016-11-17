package BusquedaLocal;

import java.io.*;

import static java.lang.Math.*;

public class Operations{

    /*
        Función que mete los valores de las distancias presentes en el archivo ciudades en una lista
    */
    public static void distancias(String FileName){
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
        Función que realiza una inicialización de la lista Sinicial tomando valores aleatorios generados.
        Existen condiciones especiales, si el aleatorio que se obtiene en la lista está generado, se incrementará en 1 su valor y se comprobará si ya está empleado,
        esto se hace para evitar tener que generar aleatorios demasiadas veces para una misma posición de la lista
    */
    public static void aleatorio(){
        int i=0;
        Double valor;
        while(i<Main.ciudades-1){ // Mientras no asociemos todas las ciudades a la solución
            valor=random();

            int randomNumber= (int)(floor((valor * 9))) + 1;
            if(!Main.Sinicial.contains(randomNumber)){
                Main.Sinicial.add(randomNumber);
            }
            else{
                while(Main.Sinicial.contains(randomNumber)){
                    if(randomNumber==(Main.ciudades-1)){ // Si es la ultima ciudad posible, la siguiente será la primera
                        randomNumber=1;
                    }
                    else{
                        randomNumber++; // Cuando la ciudad ya existe, se intenta asignar la siguiente inmediata
                    }
                }
                Main.Sinicial.add(randomNumber);
            }
            i++;
        }
    }

    /*
        Función que realiza una inicialización de la lista Sinicial tomando valores aleatorios de un archivo, si no es posible, se llama a la función de generar los valores aleatorios
        Existen condiciones especiales, si el aleatorio que se obtiene en la lista está generado, se incrementará en 1 su valor y se comprobará si ya está empleado,
        esto se hace para evitar tener que generar aleatorios demasiadas veces para una misma posición de la lista
    */
    public static void aleatorio(String FileName) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FileName)); // Abrimos el archivo
            int i = 0;
            String line;
            Double valor;
            while (i < Main.ciudades - 1) { // Mientras no asociemos todas las ciudades a la solución
                line = br.readLine();
                valor = Double.parseDouble(line);

                int randomNumber = (int) (floor((valor * 9))) + 1;
                if (!Main.Sinicial.contains(randomNumber)) {
                    Main.Sinicial.add(randomNumber);
                } else {
                    while (Main.Sinicial.contains(randomNumber)) {
                        if (randomNumber == (Main.ciudades - 1)) { // Si es la ultima ciudad posible, la siguiente será la primera
                            randomNumber = 1;
                        } else {
                            randomNumber++; // Cuando la ciudad ya existe, se intenta asignar la siguiente inmediata
                        }
                    }
                    Main.Sinicial.add(randomNumber);
                }
                i++;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void intercambio(){
    }

    public static void intercambio(String FileName){
    }

    /*
        Función para inicializar la lista de vecinos generados
    */
    public static void initializeNeighbors(){
        int i=0;
        int neighborNumber = ((Main.ciudades-1)*(Main.ciudades-2)/2);
        while(i<neighborNumber){
            Main.Vecinos.add(0);
            i++;
        }
    }

    /*
        Función para convertir un par de números a una posición en la lista, tanto de distancias como de vecinos generados
    */
    private static int conversorTuplaPosicion(int a, int b){
        int mayor, menor, posicion=0,i=1;
        if(a>b){
            mayor=a;
            menor=b;
        }
        else{
            mayor=b;
            menor=a;
        }

        while(i<mayor){
            posicion+=i;
            i++;
        }

        posicion+=menor;

        return posicion;
    }
}
