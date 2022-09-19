package titanic.colas;

import java.util.LinkedList;

import titanic.interfaces.ICola;
import titanic.servicio.Persona;

public class Cola implements ICola {
	private LinkedList<Persona> cola;
	
	public static Cola creaCola() {
		
		return new Cola();
	
	}
	
	private Cola() {
		
		this.cola = new LinkedList<Persona>();
	
	}

	public LinkedList<Persona> getCola() {
		
		return cola;
	
	}

	public void setCola(LinkedList<Persona> cola) {
		
		this.cola = cola;
	
	}

	@Override
	public void insCola(Persona persona) {
		
		cola.addLast(persona);
	
	}

	@Override
	public Persona desenCola() {
		if(!cola.isEmpty()) {
			
			return cola.removeFirst();
			
		}
		else {
			
			return null;
		
		}
	}

	@Override
	public boolean esVaciaCola() {
		
		if(cola.isEmpty()) return true;
		
		else return false;
	}

	@Override
	public String toString() {
		return "Cola [cola=" + cola + "]";
	}
}
