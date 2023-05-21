package org.iesalandalus.programacion.clientesempresa;

import java.time.LocalDate;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.clientesempresa.modelo.negocio.Clientes;
import org.iesalandalus.programacion.clientesempresa.vista.Consola;
import org.iesalandalus.programacion.clientesempresa.vista.Opcion;

public class MainApp {
	
	private final static int NUM_MAX_CLIENTES = 5;
	private static Clientes clientes = new Clientes(NUM_MAX_CLIENTES);

	public static void main(String[] args) {
		
		do  {
			Consola.mostrarMenu();
			if(Consola.elegirOpcion().equals(Opcion.SALIR)) {
				System.out.println("Gracias por usar este servicio.");
			}
			ejecutarOpcion(Consola.elegirOpcion());
		}
		while (!Consola.elegirOpcion().equals(Opcion.SALIR));
	}
	private static void insertarCliente() {
		try {
			clientes.insertar(Consola.leerCliente());
		}
		catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void borrarCliente() {
		try {
			clientes.borrar(Consola.leerClienteDni());
		}
		catch (NullPointerException | IllegalArgumentException | OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void mostrarClientes() {
		
		Cliente[] clientesLi = clientes.get();
		
		for (int i =0; i < clientesLi.length;i++)
		{
			if (clientesLi[i] != null)
				System.out.println(clientesLi[i]);
		}
	}
	private static void buscarCliente() {
		try {
			clientes.buscar(Consola.leerClienteDni());
		}
		catch (NullPointerException | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
	private static void ejecutarOpcion(Opcion opcion) {
		switch (opcion) {
		case INSERTAR_CLIENTE: {
			insertarCliente();
			break;
		}
		case BORRAR_CLIENTE: {
			borrarCliente();
			break;
		}
		case BUSCAR_CLIENTE: {
			buscarCliente();
			break;
		}
		case MOSTRAR_CLIENTES:{
			mostrarClientes();
			break;
		}
		case MOSTRAR_CLIENTES_FECHA: {
			mostrarClientesFecha();
			break;
		}
		case SALIR:{
			break;
		}
		}	
	}
	private static void mostrarClientesFecha() {
		try {
			Cliente[] clientesLi = clientes.get();
			LocalDate fechaNacimiento = Consola.leerFechaNacimiento();
			
			for (int i =0; i < clientesLi.length;i++)
			{
				if (clientesLi[i] != null && clientesLi[i].getFechaNacimiento().equals(fechaNacimiento))
					System.out.println(clientesLi[i]);
			}
		}
		catch (NullPointerException | IllegalArgumentException e) {
		}
	}
}