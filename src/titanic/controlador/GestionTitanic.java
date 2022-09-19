package titanic.controlador;

import java.util.ArrayList;

import titanic.daos.DAOBotes;
import titanic.daos.DAOPersonas;
import titanic.servicio.Bote;
import titanic.servicio.Pasajero;
import titanic.servicio.Persona;
import titanic.servicio.Tripulante;

public class GestionTitanic {
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Bote> listaBotes;
	private ArrayList<Pasajero> listaPasajeros;
	private ArrayList<Tripulante> listaTripulantes;
	
	public GestionTitanic() {
		super();
		this.listaPersonas = DAOPersonas.getInstance().getPersonas();
		this.listaBotes = DAOBotes.getInstance().getBotes();
		this.listaPasajeros = new ArrayList<Pasajero>();
		this.listaTripulantes = new ArrayList<Tripulante>();
	}

	public ArrayList<Persona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	public ArrayList<Bote> getListaBotes() {
		return listaBotes;
	}

	public void setListaBotes(ArrayList<Bote> listaBotes) {
		this.listaBotes = listaBotes;
	}
	
	public void startProgram() {
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i) instanceof Pasajero) {
				Pasajero pasajero = (Pasajero) listaPersonas.get(i);
				listaPasajeros.add(pasajero);
			}
		}
		System.out.println(toStringArray(listaPasajeros));
		
	}
	
	private String toStringArray(ArrayList<Pasajero> lista) {
		StringBuilder cadena = new StringBuilder();
		
		for(int i = 0; i < lista.size(); i++) {
			cadena.append(lista.get(i) + "\n");
		}
		
		return cadena.toString();
	}

	@Override
	public String toString() {
		return "GestionTitanic [listaPersonas=" + listaPersonas + ", listaBotes=" + listaBotes + "]";
	}

}
