package titanic.servicio;

import titanic.enums.Zona;

public class Bote {
	
	private static Integer countID = 0;
	private Integer boteID, num_plazas;
	private Zona zona;
	
	public Bote(Integer num_plazas, Zona zona) {
		super();
		setBoteID(++countID);
		this.num_plazas = num_plazas;
		this.zona = zona;
	}
	
	public Integer getBoteID() {
		return boteID;
	}

	private void setBoteID(Integer boteID) {
		this.boteID = boteID;
	}

	public Integer getNum_plazas() {
		return num_plazas;
	}

	public void setNum_plazas(Integer num_plazas) {
		this.num_plazas = num_plazas;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	@Override
	public String toString() {
		return "Bote [boteID=" + boteID + ", num_plazas=" + num_plazas + ", zona=" + zona + "]";
	}
	
}
