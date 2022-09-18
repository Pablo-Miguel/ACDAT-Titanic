package titanic.servicio;

import java.util.Date;

import titanic.enums.Pais;
import titanic.enums.Zona;

public class Pasajero extends Persona {
	
	private Integer num_habitacion;

	public Pasajero(String dni, String nombre, Date fecha_nac, Boolean minusvalia, Zona zona, Pais pais,
			Integer num_habitacion) {
		super(dni, nombre, fecha_nac, minusvalia, zona, pais);
		this.num_habitacion = num_habitacion;
	}

	public Integer getNum_habitacion() {
		return num_habitacion;
	}

	public void setNum_habitacion(Integer num_habitacion) {
		this.num_habitacion = num_habitacion;
	}

	@Override
	public String toString() {
		return "Pasajero [" + super.toString() + ", num_habitacion=" + num_habitacion + "]";
	}
	
	
	
}
