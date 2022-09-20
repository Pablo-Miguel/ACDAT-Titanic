package titanic.interfaces;

import java.util.ArrayList;
import java.util.Map;

import titanic.servicio.Bote;
import titanic.servicio.Persona;

public interface IMapa {
	public Integer insMapa(Bote bote, Persona persona);
	public Persona desenMapa(); // retorna un proceso para ser antendido y lo borra de la cola;
	public boolean esVaciaMapa(); // nos dice si la cola est� vacia
	public String toString(); //muestra todos los elementos existentes en la cola;
	public static Map creaMapa() {
		return null;
	} //Crea una cola vac�a, instanciando el ArrayList.
}
