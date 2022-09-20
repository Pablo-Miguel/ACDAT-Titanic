package titanic.colas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import titanic.interfaces.IMapa;
import titanic.servicio.Bote;
import titanic.servicio.Persona;

public class Mapa implements IMapa {
	private Map<Bote, ArrayList<Persona>> mapaBotes;
	
	public static Mapa creaMapa() {
		
		return new Mapa();
	
	}
	
	private Mapa() {
		
		this.mapaBotes = new HashMap<Bote, ArrayList<Persona>>();
	
	}

	public Map<Bote, ArrayList<Persona>> getMapa() {
		
		return mapaBotes;
	
	}

	public void setCola(Map<Bote, ArrayList<Persona>> mapaBotes) {
		
		this.mapaBotes = mapaBotes;
	
	}

	@Override
	public Integer insMapa(Bote bote, Persona persona) {
		//ArrayList<Persona> listaTemp = mapaBotes.get(bote);
		if(mapaBotes.get(bote) == null) {
			if(bote.getNum_plazas() >= 1) {
				mapaBotes.put(bote, new ArrayList<Persona>());
				mapaBotes.get(bote).add(persona);
				bote.setNum_plazas(bote.getNum_plazas()-1);
				return 0;
			}
		} else {
			if(bote.getNum_plazas() >= 1) {
				mapaBotes.get(bote).add(persona);
				bote.setNum_plazas(bote.getNum_plazas()-1);
				return 0;
			}
		}
		
		return -1;
	
	}

	@Override
	public Persona desenMapa() {
		
		if(!mapaBotes.isEmpty()) {
			
			return null;
			
		}
		else {
			
			return null;
		
		}
		
	}

	@Override
	public boolean esVaciaMapa() {
		
		if(mapaBotes.isEmpty()) return true;
		
		else return false;
	}

	@Override
	public String toString() {
		return "Mapa [" + mapaBotes + "]";
	}
	
	public String convertWithStream() {
	    String mapAsString = mapaBotes.keySet().stream()
	      .map(key -> key + "  ====>  " + mapaBotes.get(key).toString())
	      .collect(Collectors.joining(", ", "{", "}"));
	    return mapAsString;
	}
}
