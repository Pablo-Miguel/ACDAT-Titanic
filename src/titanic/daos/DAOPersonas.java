package titanic.daos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

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
            
        	listaPersonas.add(new Pasajero("31507976P", "Jett Privado", LocalDate.of(2000,02,15), false, Zona.PROA, Pais.ESPANYA, 15));
        	listaPersonas.add(new Pasajero("32507976P", "Phoenix Privado", LocalDate.of(2000, 02, 16), true, Zona.POPA, Pais.ALEMANIA, 3));
        	listaPersonas.add(new Pasajero("33507976P", "Raze Privado", LocalDate.of(2000, 02, 17), false, Zona.BABOR, Pais.UK, 34));
        	listaPersonas.add(new Pasajero("34507976P", "Sage Privado", LocalDate.of(2000, 02, 18), false, Zona.ESTRIBOR, Pais.USA, 76));
        	
        	listaPersonas.add(new Tripulante("35507976P", "Fade Privado", LocalDate.of(2000, 02, 19), false, Zona.PROA, Pais.ESPANYA, Responsabilidad.ALTA));
        	listaPersonas.add(new Tripulante("36507976P", "Chamber Privado", LocalDate.of(2000, 02, 20), true, Zona.POPA, Pais.ALEMANIA, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("37507976P", "Neon Privado", LocalDate.of(2000, 02, 21), false, Zona.BABOR, Pais.UK, Responsabilidad.MUY_ALTA));
        	listaPersonas.add(new Tripulante("38507976P", "Viper Privado", LocalDate.of(2000, 02, 22), false, Zona.ESTRIBOR, Pais.USA, Responsabilidad.MUY_BAJA));
        	
        	Collections.shuffle(listaPersonas);
        	
            return listaPersonas;
        }
        else{
            return listaPersonas;
        }
        
    }
}
