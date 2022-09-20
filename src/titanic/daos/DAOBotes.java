package titanic.daos;

import java.util.ArrayList;

import titanic.enums.Zona;
import titanic.servicio.Bote;

public class DAOBotes {
	
	private static DAOBotes daoBotes = null;
    private static ArrayList<Bote> listaBotes = null;
    
    private DAOBotes(){
        //Constructor
    }
    
    public static DAOBotes getInstance(){
        
        if(daoBotes == null){
        	daoBotes = new DAOBotes();    
        }
        
        if(listaBotes == null){
        	listaBotes = new ArrayList<Bote>();    
        }
        
        return daoBotes;
        
    }
    
    public ArrayList<Bote> getBotes(){
        
        if(listaBotes.isEmpty()){
        	
            listaBotes.add(new Bote(10, Zona.PROA));
            listaBotes.add(new Bote(10, Zona.POPA));
            listaBotes.add(new Bote(10, Zona.BABOR));
            listaBotes.add(new Bote(10, Zona.ESTRIBOR));
            
            return listaBotes;
        }
        else{
            return listaBotes;
        }
        
    }
	
}
