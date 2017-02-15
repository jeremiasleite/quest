package application;

import java.util.concurrent.ThreadLocalRandom;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Tabuleiro {
		static int vez = 1;
		static boolean primeiraPlayer1 = true;
		static boolean primeiraPlayer2 = true;
		static boolean primeiraRodada = true;
	public static void tabuleiro(int numJogadores, Stage primaryStage) {
		
		
		// TODO Auto-generated method stub
		Group root = new Group();
		
		Scene scene = new Scene(root,1200,674);
			
		Canvas canvas = new Canvas( 1200, 674 );
		root.getChildren().addAll(canvas, Tabuleiro.vez(numJogadores));
		Jogador.jogadores_init(numJogadores, root);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
	    Image tabuleiro = new Image( "Tabuleiro.png" );
	    gc.drawImage( tabuleiro, 0, 0, 1200, 674);
	    primaryStage.setTitle("Quest");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		jogar(numJogadores, root, primaryStage, 0,0);
		
		
		
	    
	    
	    
//****** Bot�o de teste da movimenta��o dos jogdores *******
	    Button btnT = new Button();		
	    btnT.setText("Mover");        
	    btnT.setCenterShape(true);
	    btnT.setTranslateY(280);
	    btnT.setTranslateX(830);
	    
	    btnT.setOnAction(new EventHandler<ActionEvent>() {  
	    	int i = 1;
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Jogador.andar(2, i, root); 
        		i++;

        	}
        });
//************************************************************* 
	   
	    
		
	}
	
	static boolean checarResposta=false;
	public static void jogar(int numJogadores, Group root, Stage primaryStage, int escolhaQuestao, int valorAposta){
		
		if(vez==1){
			//PRIMEIRA RODADA PLAYER1
			if(primeiraPlayer1){
				//PERGUNTA TEMA PLAYER1
				Questao.questao(numJogadores, root, primaryStage, true, valorAposta);
				primeiraPlayer1=false;
			}
			//PERGUNTA APOSTA
			if(escolhaQuestao!=0 && valorAposta==0)	{
				Aposta.aposta(numJogadores, root, primaryStage,primeiraRodada, escolhaQuestao);
			}
			//CHECAR RESPOSTA
			if(valorAposta!=0 && escolhaQuestao!=0 && checarResposta){
				//CHECAR RESPOSTA
				//se errar primeiraPlayer1=true
			}
			//RESPOSTA
			if(valorAposta!=0 && escolhaQuestao!=0 && checarResposta==false){
				Questao.questao(numJogadores, root, primaryStage, false, valorAposta);
				checarResposta =true;
			}
			
			
		}if(vez==2){
			if(primeiraPlayer2){
				Questao.questao(numJogadores, root, primaryStage, true, valorAposta);
				primeiraPlayer2=false;
			}
		}
		
	}
	
	
	
	
	public static Label vez(int numJogadores){
		int jogador = ThreadLocalRandom.current().nextInt(1, numJogadores + 1);
		String vezJogador = "Vez de: Jogador " + jogador;
		
		Label labelvezJogador = new Label(vezJogador);
		labelvezJogador.setTranslateY(21);
		labelvezJogador.setTranslateX(32);
		labelvezJogador.setFont(new Font("Helvetica", 22));
		labelvezJogador.setTextFill(Color.web("#FFFFFF"));
		
		return labelvezJogador;
		
	}
	

}
