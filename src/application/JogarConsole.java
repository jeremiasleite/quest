package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Jogador;
import model.Questao;

public class JogarConsole {
	private final int nCasas = 23;
	private int nJogadores;
	private boolean vencedor = false;
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private GerenciadorQuestao gestorQuestao;
	private int tabuleiro[] = {-1,0,1,2,3,0,4,3,0,1,2,3,5,2,3,0,6,3,5,2,3,0,7};//inicio:-1, sc:0, xp:1, fdd:2, dsdm:3, xp/fdd:4, sc/xp:5, sc/fdd:6, fim:7
	
	public void iniciar(int nJogadores){
		this.gestorQuestao = new GerenciadorQuestao();
		this.nJogadores = nJogadores;
		for (int i = 0; i < nJogadores; i++) {
			Jogador novoJogador = new Jogador();			
			this.jogadores.add(novoJogador);
		}
		Scanner ler = new Scanner(System.in);
		for (int y = 0; y < 4; y++) {// quatro rodadas para reiniciar fichas
			for (int i = 0; i < nJogadores; i++) {
				this.jogadores.get(i).reiniciarFichas();
			}
			for (int j = 0; j < nJogadores; j++) {//rodada jogadores
				int vez = j;
				
				System.out.println("Vez do jogador: "+vez);			
				
				int tema = -1;
				if(this.jogadores.get(vez).getPosicao()==0){
					while(tema!=0 && tema!=1 && tema!=2 && tema!=3){
						System.out.println("Selecione o tema: 0-Scrum, 1-XP, 2-FDD, 3-DSDM");
						tema = ler.nextInt();
					}
				}else{
					tema = tabuleiro[this.jogadores.get(vez).getPosicao()];
				}					
				
				if(tema == 4){
					System.out.println("Selecione o tema: 1-XP, 2-FDD");
					tema = ler.nextInt();
				}else if(tema == 5){
					System.out.println("Selecione o tema: 0-SC, 1-XP");
					tema = ler.nextInt();
				}else if(tema == 6){
					System.out.println("Selecione o tema: 0-SC, 2-FDD");
					tema = ler.nextInt();
				}
				
				Questao  questao= this.gestorQuestao.sortearQuestao(tema);
				System.out.println(questao.getPergunta());
				int lerAposta = -1;
				while(lerAposta!=1 && lerAposta!=2 && lerAposta!=3 && lerAposta!=4){
					System.out.println("Faça a aposta:");
					lerAposta = ler.nextInt();
				}
				//realiza a aposta
				this.jogadores.get(vez).apostarFicha(lerAposta);
				
				System.out.println("Selecione um alteranativa:");
				System.out.println("0) "+questao.getAlternativas()[0]);
				System.out.println("1) "+questao.getAlternativas()[1]);
				System.out.println("2) "+questao.getAlternativas()[2]);
				System.out.println("3) "+questao.getAlternativas()[3]);
				
				int lerAlternativa = -1;
				
				while(lerAlternativa!=0 && lerAlternativa!=1 && lerAlternativa!=2 && lerAlternativa!=3){
					System.out.println("Selecione um alteranativa:");
					lerAlternativa = ler.nextInt();
					
				}
				if(lerAlternativa==questao.getResposta()){
					System.out.println("Acertou");
					this.jogadores.get(vez).setPosicao(lerAposta);
					if(this.jogadores.get(vez).getPosicao()>=22){
						System.out.println("O jogador " + vez + "Venceu");
						this.vencedor =true;
						break;
					}
				}else{
					System.out.println("Errou");
				}
				
				for (int i = 0; i < nJogadores; i++) {
					System.out.println("Posicao jogador "+i+":"+this.jogadores.get(i).getPosicao());
				}		
			}
			
			if(this.vencedor){
				break;
			}
		}	
		
		
	}	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JogarConsole jogar = new JogarConsole();
		Scanner ler = new Scanner(System.in);
		System.out.println("Entre com o numero de jogadores: ");
		int n = ler.nextInt();
		jogar.iniciar(n);
		
		
		

	}

}

