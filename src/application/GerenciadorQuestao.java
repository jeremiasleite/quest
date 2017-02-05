package application;

import java.util.ArrayList;
import java.util.Random;

import model.Questao;

public class GerenciadorQuestao {
	
	private ArrayList<Questao> questaoSC;
	private boolean estaRemovidoSC[];
	private ArrayList<Questao> questaoXP;
	private boolean estaRemovidoXP[];
	private ArrayList<Questao> questaoFDD;
	private boolean estaRemovidoFDD[];
	private ArrayList<Questao> questaoDSDM;
	private boolean estaRemovidoDSDM[];	

	public GerenciadorQuestao() {
		JSONRead lerQuestao = new JSONRead();
		
		this.questaoSC = lerQuestao.getQuestoesPorTema(0);
		this.questaoXP = lerQuestao.getQuestoesPorTema(1);
		this.questaoFDD = lerQuestao.getQuestoesPorTema(2);
		this.questaoDSDM = lerQuestao.getQuestoesPorTema(3);
		
		estaRemovidoSC = new boolean[this.questaoSC.size()];
		estaRemovidoXP = new boolean[this.questaoXP.size()];
		estaRemovidoFDD = new boolean[this.questaoFDD.size()];
		estaRemovidoDSDM = new boolean[this.questaoDSDM.size()];
		
		for (int i = 0; i < estaRemovidoSC.length; i++) {
			estaRemovidoSC[i] = false;
		}
		for (int i = 0; i < estaRemovidoXP.length; i++) {
			estaRemovidoXP[i] = false;
		}
		for (int i = 0; i < estaRemovidoFDD.length; i++) {
			estaRemovidoFDD[i] = false;
		}
		for (int i = 0; i < estaRemovidoDSDM.length; i++) {
			estaRemovidoDSDM[i] = false;
		}
		
	}

	public Questao sortearQuestao(int tema){
		 
		if(tema == 0){
			Random gerador = new Random();
			int index = gerador.nextInt(this.questaoSC.size());
			while(estaRemovidoSC[index]==true){
				index = gerador.nextInt(this.questaoSC.size());
			}
			estaRemovidoSC[index] = true;			
			return this.questaoSC.get(index);
		}else if(tema == 1){
			Random gerador = new Random();
			int index = gerador.nextInt(this.questaoXP.size());
			while(estaRemovidoXP[index]==true){
				index = gerador.nextInt(this.questaoXP.size());
			}
			estaRemovidoXP[index] = true;
			return this.questaoXP.get(index);
		}else if(tema == 2){
			Random gerador = new Random();
			int index = gerador.nextInt(this.questaoFDD.size());
			while(estaRemovidoFDD[index]==true){
				index = gerador.nextInt(this.questaoFDD.size());
			}
			estaRemovidoFDD[index] = true;
			return this.questaoFDD.get(index);
		}else if(tema == 3){
			Random gerador = new Random();
			int index = gerador.nextInt(this.questaoDSDM.size());
			while(estaRemovidoDSDM[index]==true){
				index = gerador.nextInt(this.questaoDSDM.size());
			}
			estaRemovidoDSDM[index] = true;
			return this.questaoDSDM.get(index);
		}else{
				return null;
		}
		
	}
	
	public void limparRemovido(){
		for (int i = 0; i < estaRemovidoSC.length; i++) {
			estaRemovidoSC[i] = false;
		}
		for (int i = 0; i < estaRemovidoXP.length; i++) {
			estaRemovidoXP[i] = false;
		}
		for (int i = 0; i < estaRemovidoFDD.length; i++) {
			estaRemovidoFDD[i] = false;
		}
		for (int i = 0; i < estaRemovidoDSDM.length; i++) {
			estaRemovidoDSDM[i] = false;
		}
	}
}
