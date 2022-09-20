package titanic.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import titanic.enums.Pais;
import titanic.enums.Responsabilidad;
import titanic.enums.Zona;
import titanic.servicio.Pasajero;
import titanic.servicio.Persona;
import titanic.servicio.Tripulante;

public class DAOPersonas {
	private static DAOPersonas daoPersonas = null;
    private static ArrayList<Persona> listaPersonas = null;
    
    private DAOPersonas(){
        //Constructor
    }
    
    public static DAOPersonas getInstance(){
        
        if(daoPersonas == null){
        	daoPersonas = new DAOPersonas();    
        }
        
        if(listaPersonas == null){
        	listaPersonas = new ArrayList<Persona>();    
        }
        
        return daoPersonas;
        
    }
    
    public ArrayList<Persona> getPersonas(){
        
        if(listaPersonas.isEmpty()){
            
        	listaPersonas.add(new Pasajero("31507976P", "Jett", LocalDate.of(2005,9,1), false, Zona.PROA, Pais.ESPANYA, 15));
        	listaPersonas.add(new Pasajero("32507976P", "Phoenix", LocalDate.of(2000, 2, 16), true, Zona.PROA, Pais.ALEMANIA, 15));
        	listaPersonas.add(new Pasajero("33507976P", "Raze", LocalDate.of(2006, 2, 17), false, Zona.PROA, Pais.UK, 15));
        	listaPersonas.add(new Pasajero("34507976P", "Sage", LocalDate.of(2000, 2, 18), false, Zona.PROA, Pais.USA, 15));
        	
        	listaPersonas.add(new Tripulante("35507976P", "Fade", LocalDate.of(2000, 2, 19), false, Zona.PROA, Pais.ESPANYA, Responsabilidad.ALTA));
        	listaPersonas.add(new Tripulante("36507976P", "Chamber", LocalDate.of(2000, 2, 20), true, Zona.POPA, Pais.ALEMANIA, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("37507976P", "Neon", LocalDate.of(2000, 2, 21), false, Zona.BABOR, Pais.UK, Responsabilidad.MUY_ALTA));
        	listaPersonas.add(new Tripulante("38507976P", "Viper", LocalDate.of(2000, 2, 22), false, Zona.ESTRIBOR, Pais.USA, Responsabilidad.MUY_BAJA));
        	
        	Collections.shuffle(listaPersonas);
        	
            return listaPersonas;
        }
        else{
            return listaPersonas;
        }
        
    }
}
