package application;

import java.util.ArrayList;
import java.util.Collections;

import model.Questao;

public class GerenciadorQuestao {
	
	private ArrayList<Questao> questaoSC;	
	private int indexSC=0;
		
	private ArrayList<Questao> questaoXP;
	private int indexXP = 0;
	
	private ArrayList<Questao> questaoFDD;
	private int indexFDD = 0;
	private ArrayList<Questao> questaoDSDM;
	private int indexDSDM = 0;

	public GerenciadorQuestao() {
		JSONRead lerQuestao = new JSONRead();
		
		this.questaoSC = lerQuestao.getQuestoesPorTema(0);
		this.questaoXP = lerQuestao.getQuestoesPorTema(1);
		this.questaoFDD = lerQuestao.getQuestoesPorTema(2);
		this.questaoDSDM = lerQuestao.getQuestoesPorTema(3);
		
		
		Collections.shuffle(questaoSC);
		Collections.shuffle(questaoXP);
		Collections.shuffle(questaoFDD);
		Collections.shuffle(questaoDSDM);
		
		
	}

	public Questao sortearQuestao(int tema){
		 
		if(tema == 0){			
			if(this.indexSC>=this.questaoSC.size()){
				Collections.shuffle(questaoSC);
				this.indexSC=0;
			}
			Questao saida = this.questaoSC.get(this.indexSC);
			this.indexSC++;
			return saida;
		}else if(tema == 1){
			if(this.indexXP>=this.questaoXP.size()){
				Collections.shuffle(questaoXP);
				this.indexXP=0;
			}
			Questao saida = this.questaoXP.get(this.indexXP);
			this.indexXP++;
			return saida;
		}else if(tema == 2){
			if(this.indexFDD>=this.questaoFDD.size()){
				Collections.shuffle(questaoFDD);
				this.indexFDD=0;
			}
			Questao saida = this.questaoFDD.get(this.indexFDD);
			this.indexFDD++;
			return saida;
		}else if(tema == 3){
			if(this.indexDSDM>=this.questaoDSDM.size()){
				Collections.shuffle(questaoDSDM);
				this.indexDSDM=0;
			}
			Questao saida = this.questaoDSDM.get(this.indexDSDM);
			this.indexDSDM++;
			return saida;
		}else{
				return null;
		}
		
	}
	
	
}
