package titanic.controlador;

import java.util.ArrayList;

import titanic.daos.DAOBotes;
import titanic.daos.DAOPersonas;
import titanic.servicio.Bote;
import titanic.servicio.Persona;

public class GestionTitanic {
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Bote> listaBotes;
	
	public GestionTitanic(ArrayList<Persona> listaPersonas, ArrayList<Bote> listaBotes) {
		super();
		this.listaPersonas = DAOPersonas.getInstance().getPersonas();
		this.listaBotes = DAOBotes.getInstance().getBotes();
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

	@Override
	public String toString() {
		return "GestionTitanic [listaPersonas=" + listaPersonas + ", listaBotes=" + listaBotes + "]";
	}

}
