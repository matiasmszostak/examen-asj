/*
2. Ejercicio Triángulo
Escriba en pseudocódigo (o lenguaje de programación preferido) un programa que diga si un
triángulo es equilátero, isósceles o escaleno (datos de entrada a, b y c).

Referencia:
● Equilátero todos los lados iguales.
● Isósceles 2 lados iguales.
● Escaleno todos los lados diferentes.


*/

//Al cargarse la ventana del browser, se inicia el programa
window.onload = function () {

    //inicializo un array triangulo y una variable longitud
    let triangulo = [];
    let triangulos = [];
    let long = 0;


    // Hago una función para que el usuario ingrese los lados del triángulo.
    // Si comete una falta, no se registra el lado.
    // Cuando el triángulo llega a los 3 lados, la función termina.
    function ingresarLados() {
        for (let i = 0; triangulo.length < 3; i++) {
            long = parseInt(prompt("Ingrese la longitud de un lado del triángulo"));
            if (long != isNaN && long > 0) {
                triangulo.push(long)
                console.log(triangulo)
            } else if (long <= 0) {
                alert("El número que ingresaste no es válido para armar un triángulo!")
            } else {
                alert("El valor que ingresaste no es un número!")
            }
        }
    }


    // Función para determinar la categoría del triangulo
    // Paso los lados del triángulo a variables para mejorar la lectura del código
    // Determina que tipo de triángulo puede ser en base a la consigna dada.
    function categorizarTriangulo() {

        let ladoA = triangulo[0];
        let ladoB = triangulo[1];
        let ladoC = triangulo[2];

        if (ladoA == ladoB && ladoB == ladoC) {
            console.log("El triangulo ingresado es un equilátero");
        } else if (ladoA != ladoB && ladoA != ladoC && ladoB != ladoC) {
            console.log("El triangulo ingresado es un escaleno");
        } else {
            console.log("El triangulo ingresado es un isósceles");
        }
    }


    // Función del programa que pide la consigna
    // Inicializa las dos funciones creadas anteriormente.
    // Luego, le pregunta el usuario si quiere volver a empezar. Si no quiere, finaliza el programa.
    // Si el usuario elige volver a empezar:
    // 1) Se vacía el contenido del array triángulo.
    // 2) La función se vuelve a llamar a sí misma, volviendo a empezar.
    // Así se genera un loop para que el programa no termine hasta que el usuario lo determine.
    // Esto se llama recursión.
    function programaTriangulo() {

        ingresarLados();

        categorizarTriangulo();

        let reiniciar = prompt("Igrese '1' si quiere volver a empezar.\nIngrese cualquier otra tecla si quiere terminar el programa.")
        if (reiniciar == '1') {
            triangulo = [];
            programaTriangulo();
        }

    }


    // Llamo a la función que inicia todo el programa
    programaTriangulo();






};