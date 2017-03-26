package noodle.estadistica;

public class EstadisticaPregunta {
	
	private int numAciertos;
	private int numFallos;
	private int numBlanco;

	public EstadisticaPregunta(int numAciertos, int numFallos, int numBlanco) {
		this.setNumAciertos(numAciertos);
		this.setNumFallos(numFallos);
		this.setNumBlanco(numBlanco);
	}

	//Getters
	public int getNumAciertos() {
		return numAciertos;
	}

	public int getNumFallos() {
		return numFallos;
	}

	public int getNumBlanco() {
		return numBlanco;
	}

	//Setters
	public void setNumAciertos(int numAciertos) {
		this.numAciertos = numAciertos;
	}
	
	public void setNumFallos(int numFallos) {
		this.numFallos = numFallos;
	}
	
	public void setNumBlanco(int numBlanco) {
		this.numBlanco = numBlanco;
	}
	
	//Other methods
	public double getPorcentajeAciertos(){
		int total = numAciertos + numFallos + numBlanco; 
		return numAciertos / total * 100;
	}
	
	public double getPorcentajeFallos(){
		int total = numAciertos + numFallos + numBlanco; 
		return numFallos / total * 100;
	}
	
	public double getPorcentajeBlanco(){
		int total = numAciertos + numFallos + numBlanco; 
		return numBlanco / total * 100;
	}
	
	
}
