package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {
	private int capacidad;
	private static int tamano;
	private static Cliente[] coleccionClientes;

	public Clientes(int capacidad, int tamano) {
		this.capacidad = capacidad;
		this.tamano = tamano;
		Clientes.coleccionClientes = new Cliente[capacidad];

	}

	public int getTamano() {
		return tamano;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public Cliente[] get() {
		return coleccionClientes;
	}

	private Cliente[] copiaProfundaClientes() {
		Cliente[] copiaProfunda = new Cliente[tamano];
		for (int i = 0; i < coleccionClientes.length; i++) {
			copiaProfunda[i] = new Cliente(coleccionClientes[i]);
		}
		return copiaProfunda;
	}

	private boolean capacidadSuperada(int indice) {
		if (capacidad >= indice) {
			return true;
		} else {
			return false;
		}

	}

	private boolean tamanoSuperado(int indice) {
		if (tamano >= indice) {
			return true;
		} else {
			return false;
		}
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		int i;

		cliente = new Cliente(cliente);

		i = buscar(cliente);

		if (i == -1)
			throw new OperationNotSupportedException("El cliente a borrar no existe.");
		else
			desplazarUnaPosicionHaciaIzquierda(i);

	}

	public int buscar(Cliente cliente) {
		int indice = -1;
		boolean encontrado = false;

		for (int i = 0; i < coleccionClientes.length && !encontrado; i++) {
			if (coleccionClientes[i] != null && coleccionClientes[i].equals(cliente)) {
				indice = i;
				encontrado = true;
			}
		}

		return indice;

	}

	public static void insertar(Cliente ciente) throws OperationNotSupportedException {

		Cliente cliente = null;
		int i;
		cliente = new Cliente(cliente);
		i = buscarIndice(cliente);

		if (i != -1)
			coleccionClientes[i] = cliente;
		else
			throw new OperationNotSupportedException("El array de clientes está lleno.");
	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < coleccionClientes.length - 1 && coleccionClientes[i] != null; i++) {
			coleccionClientes[i] = coleccionClientes[i + 1];
		}
	}

	private static int buscarIndice(Cliente cliente) {
		int indice = -1;
		boolean encontrado = false;

		for (int i = 0; i < coleccionClientes.length && !encontrado; i++) {
			if (coleccionClientes[i] != null && coleccionClientes[i].equals(cliente)) {
				indice = i;
				encontrado = true;
			} else {
				indice = tamano + 1;
				encontrado = false;
			}
		}

		return indice;

	}
}
