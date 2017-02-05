package model;

public class Jogador {
	private boolean fichas[];
	private int posicao = 0;
	
	public Jogador(){
		this.fichas = new boolean[4];
		for (int i = 0; i < this.fichas.length; i++) {
			this.fichas[i] = true;			
		}			
	}
	
	public boolean apostarFicha(int ficha){ // fichas: [1,2,3,4]
		if(this.fichas[ficha-1]== true){
			this.fichas[ficha-1] = false;
			return true;			
		}else{
			return false;
		}
		
	}
	
	public void reiniciarFichas(){
		for (int i = 0; i < this.fichas.length; i++) {
			this.fichas[i] = true;			
		}
	}
	
	public boolean[] getFichas(){
		return this.fichas;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = this.posicao+ posicao;
	}
	

}
