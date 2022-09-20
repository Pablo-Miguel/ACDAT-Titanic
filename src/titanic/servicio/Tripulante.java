package titanic.servicio;

import java.time.LocalDate;
import java.util.Comparator;

import titanic.enums.Pais;
import titanic.enums.Responsabilidad;
import titanic.enums.Zona;

public class Tripulante extends Persona {

	private Responsabilidad responsabilidad;

	public Tripulante(String dni, String nombre, LocalDate fecha_nac, Boolean minusvalia, Zona zona, Pais pais,
			Responsabilidad responsabilidad) {
		super(dni, nombre, fecha_nac, minusvalia, zona, pais);
		this.responsabilidad = responsabilidad;
	}

	public Responsabilidad getResponsabilidad() {
		return responsabilidad;
	}

	public void setResponsabilidad(Responsabilidad responsabilidad) {
		this.responsabilidad = responsabilidad;
	}
	
	/*
	@Override
	public String toString() {
		return "Tripulante [" + super.toString() + ", responsabilidad=" + responsabilidad + "]";
	}
	*/
	
	@Override
	public String toString() {
		return "[" + super.toString() + "]";
	}
	
	public static class CompararPorRango implements Comparator<Tripulante> {

	    @Override
	    public int compare(Tripulante persona1, Tripulante persona2) {
	    	if(persona1.getResponsabilidad().compareTo(persona2.getResponsabilidad()) != 0) {
	    		return persona1.getResponsabilidad().compareTo(persona2.getResponsabilidad());
	    	}
	    	else if(persona1.getPais().compareTo(persona2.getPais()) != 0) {
	    		return persona1.getPais().compareTo(persona2.getPais());
	        }
	    	else {
	            return persona1.getNombre().compareTo(persona2.getNombre());
	        }

	    }

	}
	
}
