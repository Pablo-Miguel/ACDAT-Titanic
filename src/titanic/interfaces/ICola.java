package titanic.interfaces;

import titanic.colas.Cola;
import titanic.servicio.Persona;

public interface ICola {
	public void insCola(Persona persona);
	public Persona desenCola(); // retorna un proceso para ser antendido y lo borra de la cola;
	public boolean esVaciaCola(); // nos dice si la cola est� vacia
	public String toString(); //muestra todos los elementos existentes en la cola;
	public static Cola creaCola() {
		return null;
	} //Crea una cola vac�a, instanciando el ArrayList.
}
