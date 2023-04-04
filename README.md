# TP Integrador Entrega 2

Tareas de la Entrega 2:  

En esta entrega se debe poder soportar que los archivos contengan información de muchas rondas y de muchas personas (para eso hay que agregar los datos de ronda y persona en los archivos correspondientes).  
Por otro lado, al leer cada línea del archivo de resultados, se debe verificar que la misma sea correcta: número correcto de campos y que la cantidad de goles sea un número entero. Cada ronda puede tener cualquier cantidad de partidos.  
Al finalizar el programa, se debe imprimir un listado de los puntajes de cada persona que participa.  

El programa debe:  

● Utilizar la herramienta Maven y su estructura de proyecto. La misma debe estar implementada en el repositorio de GIT escogido.

● Imprimir por pantalla el nombre de cada persona, el puntaje total y la cantidad de pronósticos acertados.

● Implementar un test (al menos uno, pero se recomienda hacer más) que calcule el puntaje de una persona en 2 (dos) rondas consecutivas.


Tareas:
    - Sobreescribir en la clase persona el toString y ver dónde falla la calculadora con un toString en los loops.
    - Testear que la linea tenga 6 elementos: [0] (número de rondas) tiene que ser mayor o igual a 1, y [2] y [3] (goles) tienen que ser enteros mayores o iguales a 0.
