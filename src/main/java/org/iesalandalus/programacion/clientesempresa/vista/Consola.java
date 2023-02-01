package org.iesalandalus.programacion.clientesempresa.vista;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

import colecciondelibros.Libro;

public class Consola {
	 public static void mostrarMenu() 
	    {
	        System.out.println("");
	        System.out.println("");
	        System.out.println("--------------------------------------------------");
		System.out.println("Programa de menu de clientes");
		System.out.println("--------------------------------------------------");
		System.out.println("");
	        System.out.println("1.- insertar cliente");
	        System.out.println("2.- buscar cliente");
	        System.out.println("3.- Borrar cliente");
	        System.out.println("4.- Mostrar clientes");	
	        System.out.println("5.- Mostrar cliuentes por fecha de nacimiento ");
		System.out.println("");
		System.out.println("6.- Salir.");
		System.out.println("");
	    }
	 public static int elegirOpcion() 
	    {
		int opcion;
		do 
	        {
	            System.out.println("Elige una opción (0-6): ");
	            opcion = Entrada.entero();
		} while (opcion < 0 || opcion > 6);

	        return opcion;
	    }
	 public static Cliente leerCliente() {
		 String nombre,dni,correo,telefono,fechaNacimiento;
		 Cliente cliente = null;
	System.out.println("");
	System.out.println("introduce los datos del cliente");
	System.out.println("");
	System.out.println("Nombre:");
	nombre = Entrada.cadena();
	System.out.println("Dni:");
	dni = Entrada.cadena();
	System.out.println("Correo:");
	correo = Entrada.cadena();
	System.out.println("telefono:");
	telefono = Entrada.cadena();
	System.out.println("fecha de nacimiento:");
	fechaNacimiento = Entrada.cadena();
	
	
	cliente = new Cliente(cliente);
	return cliente;
		 
	 }
}
