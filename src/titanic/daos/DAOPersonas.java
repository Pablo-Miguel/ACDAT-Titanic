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
            
        	listaPersonas.add(new Pasajero("00000001P", "Persona1", LocalDate.of(2005, 9,1), false, Zona.PROA, Pais.ESPANYA, 15));
        	listaPersonas.add(new Pasajero("00000002P", "Persona2", LocalDate.of(1968, 2, 16), false, Zona.PROA, Pais.ALEMANIA, 15));
        	listaPersonas.add(new Pasajero("00000003P", "Persona3", LocalDate.of(2006, 2, 17), false, Zona.PROA, Pais.UK, 15));
        	listaPersonas.add(new Pasajero("00000004P", "Persona4", LocalDate.of(1973, 2, 18), false, Zona.PROA, Pais.USA, 15));
        	listaPersonas.add(new Pasajero("00000005P", "Persona5", LocalDate.of(2007, 2, 18), false, Zona.PROA, Pais.ESPANYA, 15));
        	listaPersonas.add(new Pasajero("00000006P", "Persona6", LocalDate.of(2000, 2, 18), false, Zona.ESTRIBOR, Pais.ALEMANIA, 32));
        	listaPersonas.add(new Pasajero("00000007P", "Persona7", LocalDate.of(1964, 2, 18), true, Zona.ESTRIBOR, Pais.ESPANYA, 12));
        	listaPersonas.add(new Pasajero("00000008P", "Persona8", LocalDate.of(1950, 2, 18), false, Zona.ESTRIBOR, Pais.USA, 56));
        	listaPersonas.add(new Pasajero("00000009P", "Persona9", LocalDate.of(1996, 2, 18), true, Zona.BABOR, Pais.UK, 78));
        	listaPersonas.add(new Pasajero("00000010P", "Persona10", LocalDate.of(1984, 2, 18), false, Zona.BABOR, Pais.ESPANYA, 45));
        	listaPersonas.add(new Pasajero("00000011P", "Persona11", LocalDate.of(1982, 2, 18), false, Zona.BABOR, Pais.USA, 43));
        	listaPersonas.add(new Pasajero("00000012P", "Persona12", LocalDate.of(1999, 2, 18), false, Zona.BABOR, Pais.ALEMANIA, 87));
        	listaPersonas.add(new Pasajero("00000013P", "Persona13", LocalDate.of(2003, 2, 18), true, Zona.POPA, Pais.ESPANYA, 23));
        	listaPersonas.add(new Pasajero("00000014P", "Persona14", LocalDate.of(2001, 2, 18), false, Zona.POPA, Pais.UK, 65));
        	
        	listaPersonas.add(new Tripulante("00000001T", "Tripulante1", LocalDate.of(2000, 2, 19), false, Zona.PROA, Pais.ESPANYA, Responsabilidad.ALTA));
        	listaPersonas.add(new Tripulante("00000002T", "Tripulante2", LocalDate.of(2000, 2, 20), false, Zona.POPA, Pais.ALEMANIA, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("00000003T", "Tripulante3", LocalDate.of(2000, 2, 21), false, Zona.BABOR, Pais.UK, Responsabilidad.MUY_ALTA));
        	listaPersonas.add(new Tripulante("00000004T", "Tripulante4", LocalDate.of(2000, 2, 22), false, Zona.ESTRIBOR, Pais.USA, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("00000005T", "Tripulante5", LocalDate.of(2000, 2, 22), false, Zona.PROA, Pais.ALEMANIA, Responsabilidad.ALTA));
        	listaPersonas.add(new Tripulante("00000006T", "Tripulante6", LocalDate.of(2000, 2, 22), false, Zona.ESTRIBOR, Pais.ESPANYA, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("00000007T", "Tripulante7", LocalDate.of(2000, 2, 22), false, Zona.PROA, Pais.UK, Responsabilidad.MEDIA));
        	listaPersonas.add(new Tripulante("00000008T", "Tripulante8", LocalDate.of(2000, 2, 22), false, Zona.ESTRIBOR, Pais.USA, Responsabilidad.BAJA));
        	listaPersonas.add(new Tripulante("00000009T", "Tripulante9", LocalDate.of(2000, 2, 22), false, Zona.BABOR, Pais.ESPANYA, Responsabilidad.BAJA));
        	listaPersonas.add(new Tripulante("00000009T", "Tripulante9", LocalDate.of(2000, 2, 22), false, Zona.BABOR, Pais.ALEMANIA, Responsabilidad.MUY_BAJA));
        	
        	Collections.shuffle(listaPersonas);
        	
            return listaPersonas;
        }
        else{
            return listaPersonas;
        }
        
    }
}
