package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Cliente {

	private String ER_CORREO = "[a-zA-Z0-9_]+@[a-zA-Z0-9_]+[.com|.es|.org]" ;
	private String ER_DNI ="(\\d{8})([a-zA-Z])" ;
	private String ER_TELEFONO = "[967]\\d{8}";
	public String FORMATO_FECHA ="dd/mm/yyyy";
	private String nombre;
	private String dni;
	private String correo;
	private String telefono;
	private LocalDate fechaNacimiento;
	
public Cliente (Cliente cliente) {
	if (cliente==null)
		throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
	setNombre (cliente.getNombre());
	setDni (cliente.getDni());
	setCorreo (cliente.getCorreo());
	setTelefono (cliente.getTelefono());
	setFechaNacimiento (cliente.getFechaNacimiento());
}
	

private static String formateaNombre (String nombre) {
	String [] texto=nombre.trim().toLowerCase().split("\\s+");
	String palabra;
	String nombreFormato="";
	for (int i=0;i<texto.length;i++)
	{
		palabra=texto[i].trim();
		String letra=palabra.toUpperCase().charAt(0)+"";
		String resto=palabra.substring(1, palabra.length());
		String partes=  letra + resto + " ";
		nombreFormato= nombreFormato + partes;
		nombre = nombreFormato  ;
	}
	return nombre;
}
private boolean comprobarLetraDni (String dni) {
	
		boolean verificador=false;
		Pattern patron;
		Matcher comparador;
		
		patron =Pattern.compile(ER_DNI);
		do {
			System.out.print("Introduce un DNI: ");
			dni = Entrada.cadena();
			comparador = patron.matcher(dni);
		} while (!comparador.matches());
		
		System.out.printf("Numero: %s%n", comparador.group(1));
		System.out.printf("Letra NIF: %s%n", comparador.group(2));
		String[] letras = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
	        int dniNum = Integer.parseInt(comparador.group(1));
	        
	        String letradni = comparador.group(2);
	        try {
	            if (
		        		letras[dniNum % 23] == letradni);
		        
		        return true;
	        } catch (NumberFormatException e) {
	            return verificador;
	       
             }

		}
private String getIniciales() {
	
	String [] texto=nombre.trim().toUpperCase().split("\\s+");
	String palabra;
	String inicial;
	String iniciales="";
	
	for(int i=0;i<texto.length;i++) {
		palabra=texto[i].trim();
		inicial=palabra.charAt(0)+"";
	iniciales = iniciales + inicial;
		
	}
	return iniciales;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public String getDni() {
	return dni;
}

private void setDni(String dni) {
	this.dni = dni;
}

 public String getCorreo() {
	return correo;
}

@Override
public String toString() {
	return "Cliente [nombre=" + (  getIniciales() ) + nombre + ", dni=" + dni + ", correo=" + correo + ", telefono=" + telefono
			+ ", fechaNacimiento=" + fechaNacimiento + "]";
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
	this.correo = correo;
}

public String getTelefono() {
	return telefono;
}

public void setTelefono(String telefono) {
	this.telefono = telefono;
}

public LocalDate getFechaNacimiento() {
	return fechaNacimiento;
}

public void setFechaNacimiento(LocalDate fechaNacimiento) {
	this.fechaNacimiento = fechaNacimiento;
}
};
