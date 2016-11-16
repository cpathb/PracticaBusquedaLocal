# Práctica de búsqueda local
## Descripción
Práctica 1 del módulo 2 de la asignatura Ingeniería del Conocimiento donde se aplicará el algoritmo de Búsqueda Local al TSP (Traveling Salesman Problem) para n=10 ciudades.

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

![Máximo de Vecinos1](http://latex.codecogs.com/gif.latex?%5Csum_%7Bi%3D1%7D%5E%7Bn-2%7Di%3D%5Cfrac%7B%28n-1%29*%28n-2%29%7D%7B2%7D)

### Función de coste
Para calcular el coste total del problema se empleará la siguiente función:

![Función de coste](http://latex.codecogs.com/gif.latex?C%28S%29%3D%20D%280%2C%20S%5B0%5D%29%20&plus;%20%5Csum_%7Bi%3D1%7D%5E%7Bn-2%7D&plus;D%28S%5Bi-1%5D%2CS%5Bi%5D%29%20&plus;%20D%28S%5Bn-2%5D%2C0%29)

### Mecanismo de selección de soluciones
El criterio de aceptación será el **primero mejor** de los vecinos.

### Criterio de parada
Se finalizará la búsqueda cuando se recorra **todo el vecindario** y no se obtengan soluciones mejores que la actual.
