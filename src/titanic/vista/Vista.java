package titanic.vista;

import java.util.ArrayList;
import java.util.Iterator;

import titanic.colas.Mapa;
import titanic.servicio.Bote;
import titanic.servicio.Pasajero;
import titanic.servicio.Tripulante;

public class Vista {

	public void mostrarMapaVista(Mapa mapa) throws InterruptedException {
		Iterator<Bote> iter = mapa.getMapa().keySet().iterator();
		
		while(iter.hasNext()) {
			Bote key = iter.next();
			
			System.out.println("\n" + key + "\n" + toStringArray(mapa.getMapa().get(key)) + "\n\n\n");
			System.out.println("<====================================================================>");
			
			Thread.sleep(1000);
			
		}
		
	}

	public void mostrarPasajerosSinBote(ArrayList<Pasajero> listaPasajeros) throws InterruptedException {
		StringBuilder cadena = new StringBuilder();
		String cad;
		
		for(int i = 0; i < listaPasajeros.size(); i++) {
			cadena.append("\n\t -> " + listaPasajeros.get(i));
		}
		
		cad = cadena.toString();
		
		System.out.println("Pasajeros sin botes:\n\n" + cad + "\n\n\n");
		System.out.println("<====================================================================>");
		
		Thread.sleep(1000);
		
	}
	
	public void mostrarTripulantesSinBote(ArrayList<Tripulante> listaTripulante) throws InterruptedException {
		StringBuilder cadena = new StringBuilder();
		String cad;
		
		for(int i = 0; i < listaTripulante.size(); i++) {
			cadena.append("\n\t -> " + listaTripulante.get(i));
		}
		
		cad = cadena.toString();
		
		System.out.println("Tripulantes sin botes: \n" + cad + "\n\n\n");
		System.out.println("<====================================================================>");
		
		Thread.sleep(1000);
	}
	
	private String toStringArray(ArrayList lista) {
		StringBuilder cadena = new StringBuilder();
		
		for(int i = 0; i < lista.size(); i++) {
			cadena.append("\n\t -> " + lista.get(i));
		}
		
		return cadena.toString();
	}

}
