# TrabajoPractico2
El objetivo de este trabajo es fortalecernos aún más en la lucha contra las vicisitudes de la programación en Android. Vamos a desarrollar un pequeño y simple juego de tablero, con su funcionalidad completa.   

El juego en consiste en lo siguiente: se muestra una cuadrícula de tres por tres.  Cada una de las nueve posiciones puede valer 1 o 0.  El estado inicial es al azar, con la sola condición que NO sean todas las casillas iguales (o sea, que haya al menos un 0, y al menos un 1).   El objetivo del juego, es, justamente, es lograr que las nueve casillas queden iguales entre sí: todas en 0, o todas en 1.

Para lograrlo, el jugador puede tocar cualquier casilla, y tanto la casilla tocada, como las adyacentes cambian su estado, de acuerdo a las siguientes reglas: supongamos que las casillas se numeran del 1 al 9, en orden de escritura, de forma tal que la 1 es la de arriba a la izquierda, la 2 es la de arriba al medio, la 3 es de la de arriba a la derecha, las 4, 5, y 6 son las de la fila del centro (izquierda, centro y derecha), y las 7, 8 y 9 son las de abajo (izquierda, centro y derecha).

Las reglas del juego dicen que:

Al tocar la 1, cambia su estado la 1, 2, 4 y 5.
Al tocar la 2, cambia su estado la 1, 2, 3 y 5.
Al tocar la 3, cambia su estado la 2, 3, 5 y 6.
Al tocar la 4, cambia su estado la 1, 4, 5 y 7.
Al tocar la 5, cambia su estado la 2, 4, 5, 6 y 8.
Al tocar la 6, cambia su estado la 3, 5, 6 y 9
Al tocar la 7, cambia su estado la 4, 5, 7 y 8.
Al tocar la 8, cambia su estado la 5, 7, 8 y 9.
Al tocar la 9, cambia su estado la 5, 6, 8 y 9.
O sea que:

- La casilla tocada cambia siempre.

- La casilla 5 cambia siempre.

- Todas las casillas (excepto la 5), además de si mismas, invierten a sus tres adyacentes.

Se trata de lograr que todas las casillas queden iguales entre sí (todas 0 o todas 1, es lo mismo), en la menor cantidad posible de jugadas.  El juego debe detectar cuando el jugador ganó, y avisarlo de alguna forma.

La arquitectura del juego será entonces que el jugador ingrese su nombre en  una casilla arriba de los botones de juego, y recién tonces pueda jugar.  Va tocando los casilleros que quiere, y estos van alternando su estado en base a las reglas indicadas.  Visualmente, podríamos lograr un lindo efecto si usamos nueve ImageButtons, a los que les vamos modificando la imagen al ser clickeados.

Opcionales:

1) Que haya un botón adicional en la pantalla de juego, que haga que se juegue en forma automática al azar hasta ganar.  Es decir que al presionar este nuevo botón se empieza a repetir una sucesión de jugadas al azar sin intervención humana, hasta que el juego termine.  Buscar la forma de que haya una pequeña pausa entre jugada y jugada, para que vea la sucesión de cambios de las imágenes de los botones (hay una ayudita más abajo, en este mismo artículo).

2) Que el juego no pueda empezar hasta que el usuario no haya ingresado su nombre.

3) Que el usuario, además de su nombre, deba ingresar un captcha para poder jugar.   En nuestro caso, para simplificarlo, el captcha consistirá en mostrar dos números de una cifra, y el usuario deberá ingresar la suma de ambos.  Si el usuario no responde correctamente, el juego no puede empezar.

4) Que haya una segunda lista desplegable en la que se muestran los nombres de los sucesivos jugadores que fueron participando.

5) Que luego que el jugador gane, la cantidad máxima de jugadas permitidas se establezca en la cantidad que se utilizó, de forma que el jugador siguiente solo pueda ganar si realiza una cantidad de jugadas menor o igual que la anterior.

6) Que haya un botón de "Ganá por mi", que realice jugadas automáticas en forma inteligente para ganar en la menor cantidad posible.  

Si, existe una pequeña técnica, no demasiado compleja, para ganar en pocos movimientos. Es así:

A) Me fijo si hay más unos y hay mas ceros.  Supongamos que hay más unos, entonces uso los ceros.

B) Me fijo en qué posiciones están los ceros.  Supongamos que hay ceros en el 1, 2 y 9.

C) Clickeo entonces el 1, 2 y 9, sabiendo que, para cuando clickee el 2 o el 9 tal vez ya no sean ceros.   No importa, yo clickeo los que determiné en el punto B).

D) Si no gané, vuelvo al punto B).  Ojo, NO al punto A, sino que si arranqué usando ceros, sigo usando ceros.

Cómo máximo en cuatro loops de estos (o tres, la verdad, no me acuerdo), gané.
