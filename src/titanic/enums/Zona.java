package titanic.enums;

import java.util.List;

public enum Zona {
	PROA(List.of(4, 9, 24)), POPA(List.of(5, 7, 45)), BABOR(List.of(34, 23, 12)), ESTRIBOR(List.of(1, 21, 14));
	
	private List<Integer> escalerasAcceso;
	private static Zona[] vectZona = Zona.values();;

	private Zona(List<Integer> escalerasAcceso) {
		this.escalerasAcceso = escalerasAcceso;
	}

	public List<Integer> getEscalerasAcceso() {
		return escalerasAcceso;
	}

	public void setEscalerasAcceso(List<Integer> escalerasAcceso) {
		this.escalerasAcceso = escalerasAcceso;
	}

	public static Zona[] getVectZona() {
		return vectZona;
	}

	public static void setVectZona(Zona[] vectZona) {
		Zona.vectZona = vectZona;
	}
	
}
