package org.iesalandalus.programacion.clientesempresa.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;



public class Consola {
	
	private Consola() {
	}
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
	 public static Opcion elegirOpcion() 
	    {
		int eleccion;
		Opcion opcion=null;
		do 
	        {
	            System.out.println("Elige una opción (1-6): ");
	            eleccion = Entrada.entero();
		} while (eleccion <= 0 || eleccion > 6);
		switch (eleccion) {
		case 1: {
			System.out.println("Seleccionó insertar cliente.");
			opcion = Opcion.INSERTAR_CLIENTE;
			break;
		}
		case 2: {
			System.out.println("Seleccionó buscar cliente.");
			opcion = Opcion.BUSCAR_CLIENTE;
			break;
		}
		case 3: {
			System.out.println("Seleccionó borrar cliente. ");
			opcion = Opcion.BORRAR_CLIENTE;
			break;
		}
		case 4: {
			System.out.println("Seleccionó mostrar cliente. ");
			opcion = Opcion.MOSTRAR_CLIENTES;
			break;
		}
		case 5: {
			System.out.println("Seleccionó mostrar cliente por fecha. ");
			opcion = Opcion.MOSTRAR_CLIENTES_FECHA;
			break;
		}
		case 6: {
			System.out.println("Seleccionó salir. ");
			opcion = Opcion.SALIR;
			break;
		}
		
		}
		return opcion;
		}
	 
	 public static Cliente leerCliente() {
		 String nombre,dni,correo,telefono;
		 LocalDate fechaNacimiento;
		
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
	fechaNacimiento = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(Cliente.FORMATO_FECHA));
	
	
	Cliente cliente = new Cliente(nombre,dni,correo,telefono,fechaNacimiento);
	return cliente;
		 
	 }
	 public static Cliente leerClienteDni() {
			String dni;
			
			System.out.print("Introduzca el DNI del cliente a buscar: ");
			dni = Entrada.cadena();
				
			Cliente clienteDni = new Cliente("Pepe", dni, "yusu@hotmail.com", "656659332", LocalDate.of(1994, 11, 3));
				
			return clienteDni;
		}
	 public static LocalDate leerFechaNacimiento() {
		 System.out.println("Introduzca la fecha de nacimiento del cliente:");
		 LocalDate fechaNacimiento = LocalDate.parse(Entrada.cadena(), DateTimeFormatter.ofPattern(Cliente.FORMATO_FECHA));
		 return fechaNacimiento;
		 }
}
