package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Questao {
	static boolean primeiraPlayer1 = true;
	static boolean primeiraPlayer2 = true;
	static String pergunta = "";
	static int escolhaQuestao = 0;
	
	public static void questao(int numJogadores, Group root, Stage primaryStage, boolean primeiraRodada, int valorAposta){
		
		
		//LABEL PERGUNTA
		Label labelPergunta = new Label();
		labelPergunta.setTranslateY(350);
		labelPergunta.setTranslateX(740);
		labelPergunta.setFont(new Font("Helvetica", 20));
		labelPergunta.setTextFill(Color.web("#000000"));
		
		//BOTOES TEMA
		Button btnScrum = new Button();		
	    btnScrum.setText("Scrum");        
	    btnScrum.setCenterShape(true);
	    btnScrum.setTranslateY(440);
	    btnScrum.setTranslateX(770);
	      
	    Button btnDsdm = new Button();		
	    btnDsdm.setText("DSDM");        
	    btnDsdm.setCenterShape(true);
	    btnDsdm.setTranslateY(440);
	    btnDsdm.setTranslateX(880);
	        
	    Button btnXp = new Button();		
	    btnXp.setText("XP");        
	    btnXp.setCenterShape(true);
	    btnXp.setTranslateY(500);
	    btnXp.setTranslateX(780);
	    	    
	    Button btnFDD = new Button();		
	    btnFDD.setText("FDD");        
	    btnFDD.setCenterShape(true);
	    btnFDD.setTranslateY(500);
	    btnFDD.setTranslateX(885);
	    
	    btnScrum.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
        		escolhaQuestao=1;
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        		

        	}
        });
	    
	    btnDsdm.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
        		escolhaQuestao=2;
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        		
        	}
        });
	    
	    
	    
	    btnXp.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
        		escolhaQuestao=3;
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        		
        	}
        });
	    
	    btnFDD.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
        		escolhaQuestao=4;
        		Tabuleiro.jogar(numJogadores, root, primaryStage, escolhaQuestao, valorAposta);
        		
        		
        	}
        });
	    
	    if(primeiraRodada){
	    	labelPergunta.setText(fazerPergunta(true,false,false));
	    	root.getChildren().addAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
	    }if(primeiraRodada==false){
	    	labelPergunta.setText(fazerPergunta(false,false,true));
	    	btnScrum.setText("A");
	    	btnDsdm.setText("B");
		    btnXp.setText("C");  
		    btnFDD.setText("D");        
	    	root.getChildren().addAll(btnFDD, btnXp, btnDsdm, btnScrum, labelPergunta);
	    }
	    
	}
	
	public static Label perg(String pergunta){
		
		Label labelPergunta = new Label();
		labelPergunta.setText(pergunta);
		labelPergunta.setTranslateY(350);
		labelPergunta.setTranslateX(740);
		labelPergunta.setFont(new Font("Helvetica", 20));
		labelPergunta.setTextFill(Color.web("#000000"));
		
		return labelPergunta;
	}
	
	public static String fazerPergunta(boolean primeiraRodada, boolean rodadaAposta, boolean rodadaPergunta){
    	
    	if (primeiraRodada){
			pergunta = "Escolha o tema da pergunta";
			
			return pergunta;
			
    	}if(rodadaAposta){
    		pergunta = "Suas fichas";
    		return pergunta;
    		
		}if(rodadaPergunta) {
			
			
			pergunta = "Pergunta";
			
			return pergunta;
		}
		return pergunta;
		
    }

}
