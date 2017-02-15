package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Aposta {
	
	boolean[] apostas = new boolean[4];
	static int[]   player1 = { 1, 2, 3, 4 };
	static int[]   player2 = { 1, 2, 3, 4 };
	static int vez = 1;
	static int retomarFichas = 0;
	static int valorAposta = 0;
	
	public static void aposta(int numJogadores, Group root, Stage primaryStage, boolean primeiraRodada, int escolhaQuestao){
		
		Label labelPergunta = Questao.perg(Questao.fazerPergunta(false, true, false));
		
		Button btnaposta1 = new Button();		
	    btnaposta1.setText("1");        
	    btnaposta1.setCenterShape(true);
	    btnaposta1.setTranslateY(440);
	    btnaposta1.setTranslateX(770);
	    
	    Button btnaposta2 = new Button();		
	    btnaposta2.setText("2");        
	    btnaposta2.setCenterShape(true);
	    btnaposta2.setTranslateY(440);
	    btnaposta2.setTranslateX(880);
	    
	    Button btnaposta3 = new Button();		
	    btnaposta3.setText("3");        
	    btnaposta3.setCenterShape(true);
	    btnaposta3.setTranslateY(500);
	    btnaposta3.setTranslateX(780);
	    
	    Button btnaposta4 = new Button();		
	    btnaposta4.setText("4");        
	    btnaposta4.setCenterShape(true);
	    btnaposta4.setTranslateY(500);
	    btnaposta4.setTranslateX(885);
	    
	    btnaposta1.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		if(vez==1){
        			player1[0]=0;
        		}if(vez==2){
        			player2[0]=0;
        		}
        		valorAposta = 1;
        		root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelPergunta);
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        	}
        });
	    
	    btnaposta2.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		if(vez==1){
        			player1[1]=0;
        		}if(vez==2){
        			player2[1]=0;
        		}
        		valorAposta = 2;
        		root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelPergunta);
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        	}
        });
	    
	    btnaposta3.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		if(vez==1){
        			player1[2]=0;
        		}if(vez==2){
        			player2[2]=0;
        		}
        		valorAposta = 3;
        		root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelPergunta);
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        	}
        });
	    
	    btnaposta4.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		if(vez==1){
        			player1[3]=0;
        		}if(vez==2){
        			player2[3]=0;
        		}
        		valorAposta = 4;
        		root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelPergunta);
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        	}
	    });
	    
	    
	    
	    
	    if(primeiraRodada){
	    	root.getChildren().addAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelPergunta);
		    }else{
		      if(vez==1){
		        if(player1[0]!=0){
		        	root.getChildren().addAll(btnaposta1);
		        }if(player1[1]!=0){
		        	root.getChildren().addAll(btnaposta2);
		        }if(player1[2]!=0){
		        	root.getChildren().addAll(btnaposta3);
		        }if(player1[3]!=0){
		        	root.getChildren().addAll(btnaposta4);
		        }
		        root.getChildren().addAll(labelPergunta);
		      }if(vez==2){
		        if (player2[0]!=0){
		        	root.getChildren().addAll(btnaposta1);
		        }if(player2[1]!=0){
		        	root.getChildren().addAll(btnaposta2);
		        }if(player2[2]!=0){
		        	root.getChildren().addAll(btnaposta3);
		        }if(player2[3]!=0){
		        	root.getChildren().addAll(btnaposta4);
		        }
		        
		        root.getChildren().addAll(labelPergunta);
		      }
		    }
	    	
	    }
	
	public static void passarVez(){
		int fimDaRodada = 3;
		
		vez = vez+1;
		if (vez==fimDaRodada){
			vez = 1;
			String s = player1[0] + "" + player1[1] + "" + player1[2] + "" + player1[3];
		    System.out.println(s);
			retomarFichas +=1;
			System.out.println(retomarFichas);
			if (retomarFichas == 4){
				System.out.println("ok");
				player1[0] = 1;
				player1[1] = 2;
				player1[2] = 3;
				player1[3] = 4;
				
				player2[0] = 1;
				player2[1] = 2;
				player2[2] = 3;
				player2[3] = 4;
				
				retomarFichas = 0;
			}
		}
	
	}
	
	 

}
