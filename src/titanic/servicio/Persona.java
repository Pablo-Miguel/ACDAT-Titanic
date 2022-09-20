package titanic.servicio;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

import titanic.enums.Pais;
import titanic.enums.Zona;

public class Persona {
	
	private String dni, nombre;
	private LocalDate fecha_nac;
	private Boolean minusvalia;
	private Zona zona;
	private Pais pais;
	
	public Persona(String dni, String nombre, LocalDate fecha_nac, Boolean minusvalia, Zona zona, Pais pais) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.fecha_nac = fecha_nac;
		this.minusvalia = minusvalia;
		this.zona = zona;
		this.pais = pais;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(LocalDate fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public Boolean getMinusvalia() {
		return minusvalia;
	}

	public void setMinusvalia(Boolean minusvalia) {
		this.minusvalia = minusvalia;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, pais);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(dni, other.dni) && pais == other.pais;
	}
	
	/*
	@Override
	public String toString() {
		return "dni=" + dni + ", nombre=" + nombre + ", fecha_nac=" + fecha_nac + ", minusvalia=" + minusvalia
				+ ", zona=" + zona + ", pais=" + pais;
	}
	*/
	
	@Override
	public String toString() {
		return nombre;
	}

	public static class CompararPorPaisyNombre implements Comparator<Persona> {

	    @Override
	    public int compare(Persona persona1, Persona persona2) {
	            if(persona1.getPais().compareTo(persona2.getPais()) != 0) {
	                    return persona1.getPais().compareTo(persona2.getPais());
	            }
	            else {
	                    return persona1.getNombre().compareTo(persona2.getNombre());
	            }

	    }

	}
	
	public static class CompararPorEdad implements Comparator<Persona> {

	    @Override
	    public int compare(Persona persona1, Persona persona2) {
	            return persona1.getFecha_nac().compareTo(persona2.getFecha_nac());

	    }

	}
	
}
