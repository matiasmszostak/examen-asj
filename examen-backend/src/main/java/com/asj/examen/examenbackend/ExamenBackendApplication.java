package com.asj.examen.examenbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.asj.examen.examenbackend.models")
		public class ExamenBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamenBackendApplication.class, args);
	}

}





/*

1. Ejercicio práctico
		Deberá implementarse la funcionalidad básica de una tienda de productos:
		● Se podrán almacenar
x		○ Productos (código, nombre, precio, categoría).
		○ Vendedor (código, nombre, sueldo).

		● Al registrar una venta, se tendrá que relacionar el producto con el vendedor que
		realizó la venta.

		● Se debe de poder calcular la comisión de ventas por cada vendedor, el cual se
		obtiene de un 5% de las ventas realizadas en el caso de vender hasta dos productos
		y un 10% al vender más de dos productos.

		● Debe implementarse distintos tipos de buscadores de productos, por ejemplo el
		buscar por categoría.

		● La aplicación tendrá que implementar el manejo de excepciones correctamente.

		● Deberá diseñarse un DER (Diagrama de Entidad Relación) para la solución.

		● Se deberá almacenar en una base de datos.


 */