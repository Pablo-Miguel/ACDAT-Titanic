package titanic.controlador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import titanic.colas.Mapa;
import titanic.daos.DAOBotes;
import titanic.daos.DAOPersonas;
import titanic.enums.Zona;
import titanic.servicio.Bote;
import titanic.servicio.Bote.ComprarPorPlazas;
import titanic.servicio.Pasajero;
import titanic.servicio.Persona;
import titanic.servicio.Persona.CompararPorEdad;
import titanic.servicio.Tripulante;
import titanic.servicio.Tripulante.CompararPorRango;
import titanic.vista.Vista;

public class GestionTitanic {
	private final Integer EDAD_MIN_ANCIANO = 65;
	private final Integer MAYORIA_EDAD = 18;
	private Random random = new Random();
	private Vista vista;
	
	private ArrayList<Persona> listaPersonas;
	private ArrayList<Bote> listaBotes;
	private ArrayList<Pasajero> listaPasajeros;
	private ArrayList<Tripulante> listaTripulantes;
	private Mapa mapaBote;
	
	public GestionTitanic() {
		super();
		this.vista = new Vista();
		
		this.listaPersonas = DAOPersonas.getInstance().getPersonas();
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
		
		for(int i = 0; i < Zona.getVectZona().length; i++) {
			meterMenoresEdad(i, false);
			meterAncianos(i, false);
			meterMinusvalidos(i, false);
			meterAdultos(i, false);
		}
		
		if(!listaPasajeros.isEmpty()) {
			for(int i = 0; i < Zona.getVectZona().length; i++) {
				meterMenoresEdad(i, true);
				meterAncianos(i, true);
				meterMinusvalidos(i, true);
				meterAdultos(i, true);
			}
		}
		
		for(int i = 0; i < Zona.getVectZona().length; i++) {
			meterTripulantes(i, false);
		}
		
		if(!listaTripulantes.isEmpty()) {
			for(int i = 0; i < Zona.getVectZona().length; i++) {
				meterTripulantes(i, true);
			}
		}
		
		vista.mostrarMapaVista();
		
		//System.out.println(mapaBote.convertWithStream());
		//System.out.println(listaPasajeros.toString());

	}
	
	private void meterTripulantes(int zona, boolean estado) {
		Bote bote;
		for(int i = 0; i < listaTripulantes.size(); i++) {
			bote = getBotes(zona, estado);
			if(bote != null) {
				
				if(listaTripulantes.get(i).getZona() == Zona.getVectZona()[zona] && !estado) {
					
					mapaBote.insMapa(bote, listaTripulantes.get(i));
					
					listaTripulantes.remove(listaTripulantes.get(i));
					
				} else if(estado) {
					mapaBote.insMapa(bote, listaTripulantes.get(i));
					
					listaTripulantes.remove(listaTripulantes.get(i));
				}
			
			}
		}
		
	}
	
	private void meterPasajerosEnMapa(Bote bote, int i) {
		
		mapaBote.insMapa(bote, listaPasajeros.get(i));
		
		listaPasajeros.remove(listaPasajeros.get(i));
		
	}

	private void meterAdultos(int zona, boolean estado) {
		Bote bote;
		for(int i = 0; i < listaPasajeros.size(); i++) {
			bote = getBotes(zona, estado);
			if(bote != null) {
				if(!comprobarMenorEdad(i) && !comprobarEdadAnciano(i) && listaPasajeros.get(i).getZona() == Zona.getVectZona()[zona] && !estado) {
					
					meterPasajerosEnMapa(bote, i);
					
				}
				else if(!comprobarMenorEdad(i) && !comprobarEdadAnciano(i) && estado){
					
					meterPasajerosEnMapa(bote, i);
					
				}
			}
		}
		
	}

	private void meterMinusvalidos(int zona, boolean estado) {
		Bote bote;
		for(int i = 0; i < listaPasajeros.size(); i++) {
			bote = getBotes(zona, estado);
			if(bote != null) {
				if(listaPasajeros.get(i).getMinusvalia() && listaPasajeros.get(i).getZona() == Zona.getVectZona()[zona] && !estado) {
					
					meterPasajerosEnMapa(bote, i);
					
				} else if(listaPasajeros.get(i).getMinusvalia() && estado) {
					
					meterPasajerosEnMapa(bote, i);
					
				}
			}
		}
		
	}

	private void meterAncianos(int zona, boolean estado) {
		Bote bote;
		for(int i = 0; i < listaPasajeros.size(); i++) {
			bote = getBotes(zona, estado);
			if(bote != null) {
				if(comprobarEdadAnciano(i) && listaPasajeros.get(i).getZona() == Zona.getVectZona()[zona]  && !estado) {
					
					meterPasajerosEnMapa(bote, i);
					
				} else if(comprobarEdadAnciano(i) && estado) {
					
					meterPasajerosEnMapa(bote, i);
					
				}
			}
		}
		
	}

	private boolean comprobarEdadAnciano(int i) {
		return listaPasajeros.get(i).getFecha_nac().isBefore(LocalDate.of(LocalDate.now().getYear() - EDAD_MIN_ANCIANO, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
	}

	private void meterMenoresEdad(int zona, boolean estado) {
		Pasajero pasajeroTemp;
		Bote bote;
		for(int i = 0; i < listaPasajeros.size(); i++) {
			bote = getBotes(zona, estado);
			if(bote != null) {
				if(comprobarMenorEdad(i) && listaPasajeros.get(i).getZona() == Zona.getVectZona()[zona] && !estado) {
					
					mapaBote.insMapa(bote, listaPasajeros.get(i));
					
					pasajeroTemp = listaPasajeros.get(i);
					
					listaPasajeros.remove(listaPasajeros.get(i));
					
					meterHermanosMenoresDelMenor(pasajeroTemp, bote, zona, estado);
					
					tutorLegalAleatorio(pasajeroTemp, bote);
					
				} else if(comprobarMenorEdad(i) && estado) {
					mapaBote.insMapa(bote, listaPasajeros.get(i));
					
					pasajeroTemp = listaPasajeros.get(i);
					
					listaPasajeros.remove(listaPasajeros.get(i));
					
					meterHermanosMenoresDelMenor(pasajeroTemp, bote, zona, estado);
					
					tutorLegalAleatorio(pasajeroTemp, bote);
				}
			}
		}
		
	}
	
	private void tutorLegalAleatorio(Pasajero pasajero, Bote bote) {
		ArrayList<Pasajero> tempArray = new ArrayList<Pasajero>();
		for(int i = 0; i < listaPasajeros.size(); i++) {
			if(pasajero.getNum_habitacion() == listaPasajeros.get(i).getNum_habitacion() && !comprobarMenorEdad(i)) {
				tempArray.add(listaPasajeros.get(i));
			}
		}
		if(!tempArray.isEmpty()) {
			int i = random.nextInt(tempArray.size());
			mapaBote.insMapa(bote, tempArray.get(i));
			listaPasajeros.remove(tempArray.get(i));
		}
	}

	private Bote getBotes(int zona, boolean estado) {
		for(int i = 0; i < listaBotes.size(); i++) {
			if(listaBotes.get(i).getZona() == Zona.getVectZona()[zona] && listaBotes.get(i).getNum_plazas() >= 1) {
				return listaBotes.get(i);
			}
		}
		if(estado) {
			Collections.sort(listaBotes, new ComprarPorPlazas());
			for(int i = 0; i < listaBotes.size(); i++) {
				if(listaBotes.get(i).getNum_plazas() >= 1) {
					return listaBotes.get(i);
				}
			}
		}
		return null;
		
	}

	private void meterHermanosMenoresDelMenor(Pasajero pasajero, Bote bote, int zona, boolean estado) {
		Bote newBote;
		for(int i = 0; i < listaPasajeros.size(); i++) {
			if(pasajero.getNum_habitacion() == listaPasajeros.get(i).getNum_habitacion() && comprobarMenorEdad(i)) {
				
				if(bote.getNum_plazas() >= 1) {
					mapaBote.insMapa(bote, listaPasajeros.get(i));
					listaPasajeros.remove(listaPasajeros.get(i));
				} else {
					newBote = getBotes(zona, estado);
					mapaBote.insMapa(newBote, listaPasajeros.get(i));
					listaPasajeros.remove(listaPasajeros.get(i));
					tutorLegalAleatorio(listaPasajeros.get(i), newBote);
				}
			}
		}
		
	}

	private boolean comprobarMenorEdad(int i) {
		return listaPasajeros.get(i).getFecha_nac().isAfter(LocalDate.of(LocalDate.now().getYear() - MAYORIA_EDAD, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth()));
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
		Collections.sort(listaPasajeros, new CompararPorEdad());
		Collections.sort(listaTripulantes, new CompararPorRango());
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
