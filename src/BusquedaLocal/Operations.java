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

            int randomNumber= (int)(floor((valor * (Main.ciudades-1)))) + 1;
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
            int i = 0,randomNumber;
            String line;
            Double valor;
            if(Main.Aleatorios.size()==0){ // Si no se inicializó el aray de aleatorios lo inicializamos
                line = br.readLine();
                while(line!=null){
                    valor = Double.parseDouble(line);
                    randomNumber = (int) (floor((valor * 9)));
                    Main.Aleatorios.add(randomNumber);
                    line = br.readLine();
                }
                br.close();
            }
            while (i < Main.ciudades - 1) { // Mientras no asociemos todas las ciudades a la solución
                randomNumber = (Main.Aleatorios.get(Main.posAleatorios))+1;
                if (!Main.Sinicial.contains(randomNumber)) {
                    Main.Sinicial.add(randomNumber);
                    Main.posAleatorios++;
                }
                else {
                    while (Main.Sinicial.contains(randomNumber)) {
                        if (randomNumber == (Main.ciudades - 1)) { // Si es la ultima ciudad posible, la siguiente será la primera
                            randomNumber = 1;
                        } else {
                            randomNumber++; // Cuando la ciudad ya existe, se intenta asignar la siguiente inmediata
                        }
                    }
                    Main.Sinicial.add(randomNumber);
                    Main.posAleatorios++;
                }
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void intercambio(){
        int random1,random2;
        Double valor;
        int aux;
        // Se comprueba si se ha generado un nuevo vecino no generado previamente, si no es así, se incrementa la posición destino, hasta que no se pueda incrementar más que se incrementa la posición origen y se repite el proceso hasta encontrar uno no generado
        if (Main.vecinosGenerados<((Main.ciudades-1)*(Main.ciudades-2)/2)){ // Si no se han generado todos los vecinos ¡¡ESTO CREO QUE SOBRARÁ!!
            valor=random();
            random1=(int)(floor((valor * (Main.ciudades-1))));

            valor=random();
            random2=(int)(floor((valor * (Main.ciudades-1))));

            if (random2==random1){ // Si los numeros aleatorios generados son iguales, incrementamos en uno el segundo número para que no sea así
                if(random1==(Main.ciudades-2)){ // Si se ha llegado al límite se vuelve a 0
                    random2=0;
                    random1=1;
                }
                else{
                    random2=0;
                    random1++;
                }
            }
            else{
                if(random2>random1){
                    aux=random1;
                    random1=random2;
                    random2=aux;
                }
            }

            boolean nuevo=false;

            while(nuevo==false){
                if(Main.Vecinos.get(conversorTuplaPosicion(random1,random2))==0){
                    Main.Vecinos.set(conversorTuplaPosicion(random1,random2),1);
                    nuevo=true;
                }
                else{
                    if(random2==random1-1){
                        random2=0;
                        if(random1==Main.ciudades-2){
                            random1=1;
                        }
                        else{
                        random1++;
                        }
                    }
                    else{
                        random2++;
                    }
                }
            }
            Main.vecinosGenerados++;
            System.out.print("Vecino ("+random1+", "+random2+")\n Solución Nueva -> [");

            /*
            int i=0;
            aux=Main.Sinicial.get(random1);
            Main.Sinicial.set(random1,Main.Sinicial.get(random2));
            Main.Sinicial.set(random2,aux);
            while(i<Main.Sinicial.size()){
                System.out.print(Main.Sinicial.get(i)+";");
                i++;
            }
            initializeNeighbors();
            Main.vecinosGenerados=0;
            */

            int i=0;
            while(i<Main.Sinicial.size()){
                if(i==random1){
                    System.out.print(Main.Sinicial.get(random2)+";");
                }
                else{
                    if(i==random2){
                        System.out.print(Main.Sinicial.get(random1)+";");
                    }
                    else{
                        System.out.print(Main.Sinicial.get(i)+";");
                    }
                }
                i++;
            }
            System.out.print("]\n");
        }
        else{
            System.out.println("Todos los vecinos han sido ya generados");
        }
    }

    public static void intercambioArch(){
        int random1,random2;
        int aux;
        // Se comprueba si se ha generado un nuevo vecino no generado previamente, si no es así, se incrementa la posición destino, hasta que no se pueda incrementar más que se incrementa la posición origen y se repite el proceso hasta encontrar uno no generado
        if (Main.vecinosGenerados<((Main.ciudades-1)*(Main.ciudades-2)/2)){ // Si no se han generado todos los vecinos ¡¡ESTO CREO QUE SOBRARÁ!!
            random1=Main.Aleatorios.get(Main.posAleatorios);
            Main.posAleatorios++;
            random2=Main.Aleatorios.get(Main.posAleatorios);
            Main.posAleatorios++;
            if (random2==random1){ // Si los numeros aleatorios generados son iguales, incrementamos en uno el segundo número para que no sea así
                if(random1==(Main.ciudades-2)){ // Si se ha llegado al límite se vuelve a 0
                    random2=0;
                    random1=1;
                }
                else{
                    random2=0;
                    random1++;
                }
            }
            else{
                if(random2>random1){
                    aux=random1;
                    random1=random2;
                    random2=aux;
                }
            }

            boolean nuevo=false;

            while(nuevo==false){
                if(Main.Vecinos.get(conversorTuplaPosicion(random1,random2))==0){
                    Main.Vecinos.set(conversorTuplaPosicion(random1,random2),1);
                    nuevo=true;
                }
                else{
                    if(random2==random1-1){
                        random2=0;
                        if(random1==Main.ciudades-2){
                            random1=1;
                        }
                        else{
                            random1++;
                        }
                    }
                    else{
                        random2++;
                    }
                }
            }
            Main.vecinosGenerados++;
            System.out.print("Vecino ("+random1+", "+random2+")\n Solución Nueva -> [");

            /*
            int i=0;
            aux=Main.Sinicial.get(random1);
            Main.Sinicial.set(random1,Main.Sinicial.get(random2));
            Main.Sinicial.set(random2,aux);
            while(i<Main.Sinicial.size()){
                System.out.print(Main.Sinicial.get(i)+";");
                i++;
            }
            initializeNeighbors();
            Main.vecinosGenerados=0;
            */

            int i=0;
            while(i<Main.Sinicial.size()){
                if(i==random1){
                    System.out.print(Main.Sinicial.get(random2)+";");
                }
                else{
                    if(i==random2){
                        System.out.print(Main.Sinicial.get(random1)+";");
                    }
                    else{
                        System.out.print(Main.Sinicial.get(i)+";");
                    }
                }
                i++;
            }
            System.out.print("]\n");
        }
        else{
            System.out.println("Todos los vecinos han sido ya generados");
        }
    }

    /*
        Función para inicializar la lista de vecinos generados
    */
    public static void initializeNeighbors(){
        int i=0;
        int neighborNumber = ((Main.ciudades-1)*(Main.ciudades-2)/2);
        if(Main.Vecinos.size()!=neighborNumber){
            while(i<neighborNumber){
                Main.Vecinos.add(0);
                i++;
            }
        }
        else{
            while(i<neighborNumber){
                Main.Vecinos.set(i,0);
                i++;
            }
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

    public static Integer calculoDistancia(){
        Integer distancia=0;

        distancia=distancia+Main.Distancias.get(conversorTuplaPosicion(Main.Sinicial.get(0),0));
        distancia=distancia+Main.Distancias.get(conversorTuplaPosicion(Main.Sinicial.get(Main.Sinicial.size()-1),0));
        int i=0;
        while(i<Main.ciudades-2){
            distancia=distancia+Main.Distancias.get(conversorTuplaPosicion(Main.Sinicial.get(i),Main.Sinicial.get(i+1)));
            i++;
        }
        return distancia;
    }
}
