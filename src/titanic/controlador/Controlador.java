package titanic.controlador;

import titanic.colas.Mapa;
import titanic.servicio.GestionTitanic;
import titanic.vista.Vista;

public class Controlador {
	
	Vista vista = new Vista();
	GestionTitanic gestionTitanic = new GestionTitanic();
	
	public void start() throws InterruptedException {
		
		Mapa mapaBote = gestionTitanic.startProgram();
		
		vista.mostrarMapaVista(mapaBote);
		
		if(!gestionTitanic.getListaPasajeros().isEmpty()){
			vista.mostrarPasajerosSinBote(gestionTitanic.getListaPasajeros());
		}
		
		if(!gestionTitanic.getListaTripulantes().isEmpty()){
			vista.mostrarTripulantesSinBote(gestionTitanic.getListaTripulantes());
		}
		
	}
	
	
}
