package titanic.servicio;

import java.time.LocalDate;

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

	@Override
	public String toString() {
		return "Tripulante [" + super.toString() + ", responsabilidad=" + responsabilidad + "]";
	}
	
}
