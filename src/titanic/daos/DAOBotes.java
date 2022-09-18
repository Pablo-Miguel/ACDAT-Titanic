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
        	ArrayList<Integer> listaEscaleraAccesoProa = new ArrayList<Integer>();
        	ArrayList<Integer> listaEscaleraAccesoPopa = new ArrayList<Integer>();
        	ArrayList<Integer> listaEscaleraAccesoBabor = new ArrayList<Integer>();
        	ArrayList<Integer> listaEscaleraAccesoEstribor = new ArrayList<Integer>();
        	
        	listaEscaleraAccesoProa.add(4);
        	listaEscaleraAccesoProa.add(9);
        	listaEscaleraAccesoProa.add(24);
        	
        	listaEscaleraAccesoPopa.add(5);
        	listaEscaleraAccesoPopa.add(7);
        	listaEscaleraAccesoPopa.add(45);
        	
        	listaEscaleraAccesoBabor.add(34);
        	listaEscaleraAccesoBabor.add(23);
        	listaEscaleraAccesoBabor.add(12);
        	
        	listaEscaleraAccesoEstribor.add(1);
        	listaEscaleraAccesoEstribor.add(21);
        	listaEscaleraAccesoEstribor.add(14);
        	
        	Zona.PROA.setEscalerasAcceso(listaEscaleraAccesoProa);
        	Zona.POPA.setEscalerasAcceso(listaEscaleraAccesoPopa);
        	Zona.BABOR.setEscalerasAcceso(listaEscaleraAccesoBabor);
        	Zona.ESTRIBOR.setEscalerasAcceso(listaEscaleraAccesoEstribor);
        	
            listaBotes.add(new Bote(5, Zona.PROA));
            listaBotes.add(new Bote(10, Zona.POPA));
            listaBotes.add(new Bote(8, Zona.BABOR));
            listaBotes.add(new Bote(7, Zona.ESTRIBOR));
            
            return listaBotes;
        }
        else{
            return listaBotes;
        }
        
    }
	
}
