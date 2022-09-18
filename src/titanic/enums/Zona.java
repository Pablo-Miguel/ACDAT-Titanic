package titanic.enums;

import java.util.ArrayList;

public enum Zona {
	PROA(), POPA(), BABOR(), ESTRIBOR();
	
	private ArrayList<Integer> escalerasAcceso;
	
	private Zona() {
	}

	private Zona(ArrayList<Integer> escalerasAcceso) {
		this.escalerasAcceso = escalerasAcceso;
	}

	public ArrayList<Integer> getEscalerasAcceso() {
		return escalerasAcceso;
	}

	public void setEscalerasAcceso(ArrayList<Integer> escalerasAcceso) {
		this.escalerasAcceso = escalerasAcceso;
	}
	
}
