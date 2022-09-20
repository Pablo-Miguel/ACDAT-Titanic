package titanic.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import titanic.colas.Mapa;
import titanic.daos.DAOBotes;
import titanic.daos.DAOPersonas;
import titanic.enums.Zona;
import titanic.servicio.Bote;
import titanic.servicio.Pasajero;
import titanic.servicio.Persona;
import titanic.servicio.Persona.CompararPorPaisyNombre;
import titanic.servicio.Tripulante;

public class GestionTitanic {
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Bote> listaBotes;
	private ArrayList<Pasajero> listaPasajeros;
	private ArrayList<Tripulante> listaTripulantes;
	private Mapa mapaBote;
	
	public GestionTitanic() {
		super();
		this.listaPersonas = DAOPersonas.getInstance().getPersonas();
		Collections.sort(listaPersonas, new CompararPorPaisyNombre());
		this.listaBotes = DAOBotes.getInstance().getBotes();
		this.listaPasajeros = new ArrayList<Pasajero>();
		this.listaTripulantes = new ArrayList<Tripulante>();
		this.mapaBote = Mapa.creaMapa();
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
		separarPasajerosYTripulantes();
		meterMenoresEdadProa();
		System.out.println(mapaBote.convertWithStream());

	}
	
	private void meterMenoresEdadProa() {
		Pasajero pasajeroTemp;
		Bote bote = getBotesProa();
		if(bote != null) {
			for(int i = 0; i < listaPasajeros.size(); i++) {
				if(comprobarMenorEdad(i) && listaPasajeros.get(i).getZona() == Zona.PROA) {
					//Si son menores de edad comprobar
					
					mapaBote.insMapa(bote, listaPasajeros.get(i));
					
					pasajeroTemp = listaPasajeros.get(i);
					
					listaPasajeros.remove(listaPasajeros.get(i));
					
					meterHermanosMenoresDelMenor(pasajeroTemp, bote);
					
				}
				else {
					//Si no son menores de edad comprobar
					
				}
				
			}
		}
		
	}
	
	private Bote getBotesProa() {
		Bote boteTemp;
		for(int i = 0; i < listaBotes.size(); i++) {
			if(listaBotes.get(i).getZona() == Zona.PROA) {
				boteTemp = listaBotes.get(i);
				listaBotes.remove(boteTemp);
				return boteTemp;
			}
		}
		return null;
		
	}

	private void meterHermanosMenoresDelMenor(Pasajero pasajero, Bote bote) {
		for(int i = 0; i < listaPasajeros.size(); i++) {
			if(pasajero.getNum_habitacion() == listaPasajeros.get(i).getNum_habitacion() && comprobarMenorEdad(i)) {
				
				mapaBote.insMapa(bote, listaPasajeros.get(i));
				listaPasajeros.remove(listaPasajeros.get(i));
				
			}
		}
		
	}

	private boolean comprobarMenorEdad(int i) {
		return listaPasajeros.get(i).getFecha_nac().isAfter(LocalDate.of(LocalDate.now().getYear() - 18, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
	}

	private void separarPasajerosYTripulantes() {
		for(int i = 0; i < listaPersonas.size(); i++) {
			if(listaPersonas.get(i) instanceof Pasajero) {
				Pasajero pasajero = (Pasajero) listaPersonas.get(i);
				listaPasajeros.add(pasajero);
			} else {
				Tripulante tripulante = (Tripulante) listaPersonas.get(i);
				listaTripulantes.add(tripulante);
			}
		}
	}
	
	private String toStringArray(ArrayList lista) {
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
