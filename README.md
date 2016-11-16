# PracticaBusquedaLocal
## Descripción
Práctica 1 del módulo 2 de la asignatura Ingeniería del Conocimiento donde se empleará el algoritmo de Búsqueda Local al TSP (Traveling Salesman Problem) para n=10 ciudades.

### Restricciones
- La ciudad de partida y llegada tiene que ser la misma, en nuestro caso, la ciudad es 0.
- La información de las distancias se leerán de un fichero que contiene únicamente la **matriz diagonal inferior** de distancias.
  - La columna i-ésima guarda las distancias entre la ciudad i-ésima y las ciudades i+1, i+2, ...
  - La diagonal de la matriz D es 0, ya que mediría la distancia a si misma.
  - La matriz es simétrica D(i, j)= D(j, i).
- Para generar los vecinos solamente se podrá emplear el operador de **intercambio de dos elementos**.

### Solución inicial
La solución inicial será generada aleatoriamente, el rango de los índices será [1,n-1].

### Generación de vecinos
Para generar los vecinos solamente se podrá emplear el operador de **intercambio de dos elementos**. Esto nos permite un número máximo de vecinos de:

![Máximo de Vecinos](http://www.sciweavers.org/tex2img.php?eq=%5Csum_%7Bi%3D1%7D%5E%7Bn-2%7D%20i%3D%20%5Cfrac%7B%5Cbig%28n-1%5Cbig%29%20%2A%20%5Cbig%28n-2%5Cbig%29%7D%20%7B2%7D&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)

### Función de coste
Para calcular el coste total del problema se empleará la siguiente función:

![Función de coste](http://www.sciweavers.org/tex2img.php?eq=C%5Cbig%28S%5Cbig%29%3D%20D%280%2CS%5B0%5D%29%20%2B%20%5Csum_%7Bi%3D1%7D%5E%7Bn-2%7D%20D%5Cbig%28S%5Bi-1%5D%2CS%5Bi%5D%5Cbig%29%20%2B%20D%5Cbig%28S%28%5Bn-2%5D%2C0%29%5Cbig%29&bc=White&fc=Black&im=jpg&fs=12&ff=arev&edit=0)

### Mecanismo de selección de soluciones
El criterio de aceptación será el **primero mejor** de los vecinos.

### Criterio de parada
Se finalizará la búsqueda cuando se recorra todo el vecindario y no se obtengan soluciones mejores que la actual.
