package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {
	private int capacidad;
	private int tamano;
	private Cliente[] coleccionClientes;

	public Clientes(int capacidad) {
		this.capacidad = capacidad;
		this.coleccionClientes = new Cliente[capacidad];
		tamano=0;

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
		Cliente[] copiaProfunda = new Cliente[capacidad];
		for (int i = 0; i < coleccionClientes.length; i++) {
			copiaProfunda[i] = new Cliente(coleccionClientes[i]);
		}
		return copiaProfunda;
	}

	private boolean capacidadSuperada(int indice) {
		if (indice >= capacidad) {
			return true;
		} else {
			return false;
		}

	}

	private boolean tamanoSuperado(int indice) {
		if (indice >= tamano) {
			return true;
		} else {
			return false;
		}
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo.");
		}
		int ind = buscarIndice(cliente);

		if (ind == tamano + 1) {
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente como el indicado.");
		}

		else {

			coleccionClientes[ind] = null;
			desplazarUnaPosicionHaciaIzquierda(ind);
			tamano--;
		}

	}

	public Cliente buscar(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		Cliente cliEn = null;
		boolean encontrado = false;

		for (int i = 0; i < coleccionClientes.length && !encontrado; i++) {
			if (coleccionClientes[i] != null && coleccionClientes[i].equals(cliente)) {
				cliEn= new Cliente (coleccionClientes[i]);
				encontrado = true;
			}
		}

		return cliEn;

	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if (capacidadSuperada(buscarIndice(cliente))) {
			throw new OperationNotSupportedException("ERROR: No se aceptan más clientes.");
		}
		if (!tamanoSuperado(buscarIndice(cliente))) {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");
		}
		coleccionClientes[buscarIndice(cliente)] = new Cliente (cliente);
		tamano++;		
		}
	
	
	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice; i < coleccionClientes.length - 1 && coleccionClientes[i] != null; i++) {
			coleccionClientes[i] = coleccionClientes[i + 1];
		}
	}

	private int buscarIndice(Cliente cliente) {
		int indice = -1;
		boolean encontrado = false;

		for (int i = 0; i < coleccionClientes.length && !encontrado; i++) {
			if (coleccionClientes[i] != null && coleccionClientes[i].equals(cliente)) {
				indice = i;
				encontrado = true;
			} else {
				indice = getTamano() + 1;
				encontrado = false;
			}
		}

		return indice;

	}
}
