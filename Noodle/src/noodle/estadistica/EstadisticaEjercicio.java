package noodle.estadistica;

public class EstadisticaEjercicio {
	
	private int numAprobados;
	private int numSuspensos;

	public EstadisticaEjercicio(int numAprobados, int numSuspensos) {
		this.setNumAprobados(numAprobados);
		this.setNumSuspensos(numSuspensos);
	}

	//Getters
	public int getNumAprobados() {
		return numAprobados;
	}

	public int getNumSuspensos() {
		return numSuspensos;
	}

	//Setters
	public void setNumAprobados(int numAprobados) {
		this.numAprobados = numAprobados;
	}

	public void setNumSuspensos(int numSuspensos) {
		this.numSuspensos = numSuspensos;
	}
	
	//Other methods
	public double getPorcentajeAprobados(){
		int total = numAprobados + numSuspensos;
		return (numAprobados / total) * 100;
	}
	
	public double getPorcentajeSuspensos(){
		int total = numAprobados + numSuspensos;
		return (numSuspensos / total) * 100;
	}

}
