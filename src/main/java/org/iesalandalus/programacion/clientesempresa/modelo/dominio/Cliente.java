package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Cliente {

	private String ER_CORREO = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+[.com|.es|.org]";
	private static String ER_DNI = "(\\d{8})([a-zA-Z])";
	private String ER_TELEFONO = "[967]\\d{8}";
	public String FORMATO_FECHA = "dd/mm/yyyy";
	private String nombre;
	private String dni;
	private String correo;
	private String telefono;
	private LocalDate fechaNacimiento;

	public Cliente(Cliente cliente) {
		if (cliente == null)
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		setNombre(cliente.getNombre());
		setDni(cliente.getDni());
		setCorreo(cliente.getCorreo());
		setTelefono(cliente.getTelefono());
		setFechaNacimiento(cliente.getFechaNacimiento());
	}

	private  String formateaNombre(String nombre) {
		String[] texto = nombre.trim().toLowerCase().split("\\s+");
		String palabra;
		String nombreFormato = "";
		for (int i = 0; i < texto.length; i++) {
			palabra = texto[i].trim();
			String letra = palabra.toUpperCase().charAt(0) + "";
			String resto = palabra.substring(1, palabra.length());
			String partes = letra + resto + " ";
			nombreFormato = nombreFormato + partes;
			nombre = nombreFormato;
		}
		return nombre;
	}

	public boolean comprobarLetraDni(String dni) {

		boolean verificador = true;
		Pattern patron;
		Matcher comparador;

		patron = Pattern.compile(ER_DNI);

		comparador = patron.matcher(dni);

		if (!comparador.matches()) {
			throw new IllegalArgumentException("ERROR: el dni del cliente no tiene un formato valido");
		}

		System.out.printf("Numero: %s%n", comparador.group(1));
		System.out.printf("Letra NIF: %s%n", comparador.group(2));
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V","H", "L", "C", "K", "E" };
		int dniNum = Integer.parseInt(comparador.group(1));
		

		String letraDni = comparador.group(2);
		System.out.println(letras[dniNum % 23]);
		if (letras[dniNum % 23].equals(letraDni) ) {

			
			System.out.println("dni es correcto");
			verificador = true;

		} else {
			

			verificador = false;
			System.out.println("dni es incorrecto");

		}
		return verificador;
	}

	private String getIniciales() {

		String[] texto = nombre.trim().toUpperCase().split("\\s+");
		String palabra;
		String inicial;
		String iniciales = "";

		for (int i = 0; i < texto.length; i++) {
			palabra = texto[i].trim();
			inicial = palabra.charAt(0) + "";
			iniciales = iniciales + inicial;

		}
		return iniciales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre==null)
			throw new NullPointerException("ERROR: El nombre de un cliente no puede ser nulo.");
		
		if (nombre.trim().isEmpty())
			throw new IllegalArgumentException("ERROR: El nombre de un cliente no puede estar vacío.");
		
		this.nombre = formateaNombre(nombre);
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El dni de un cliente no puede ser nulo.");
		}
		if (dni.trim().isEmpty() || !dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El dni del cliente no tiene un formato válido.");
		}
		if (!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra del dni del cliente no es correcta.");
		}
		this.dni = dni.toUpperCase();
	}

	public String getCorreo() {
		return correo;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + (getIniciales()) + nombre + ", dni=" + dni + ", correo=" + correo + ", telefono="
				+ telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	public void setCorreo(String correo) {
		if (correo == null) {
			throw new NullPointerException("ERROR: El correo de un cliente no puede ser nulo.");
		}
		if (!correo.matches(ER_CORREO)) {
			throw new IllegalArgumentException("ERROR: El correo del cliente no tiene un formato válido.");
		}
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null)
			throw new NullPointerException("ERROR: El teléfono de un cliente no puede ser nulo.");
		if (!telefono.matches(ER_TELEFONO))
			throw new IllegalArgumentException("ERROR: El teléfono del cliente no tiene un formato válido.");
		this.telefono = telefono;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
};
