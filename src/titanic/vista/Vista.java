package titanic.vista;

import java.util.Iterator;

import titanic.colas.Mapa;
import titanic.servicio.Bote;

public class Vista {

	public void mostrarMapaVista(Mapa mapa) throws InterruptedException {
		Iterator<Bote> iter = mapa.getMapa().keySet().iterator();
		
		while(iter.hasNext()) {
			Bote key = iter.next();
			
			System.out.println("\n" + key + "\n\n\t -> " + mapa.getMapa().get(key) + "\n\n\n");
			System.out.println("<====================================================================>");
			
			Thread.sleep(1000);
			
		}
		
	}

}
