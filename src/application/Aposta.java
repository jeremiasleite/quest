package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Aposta {
	
	boolean[] apostas = new boolean[4];
	
	public static void aposta(int numJogadores, Group root, Stage primaryStage){
		
		
		
		Button btnaposta1 = new Button();		
	    btnaposta1.setText("1");        
	    btnaposta1.setCenterShape(true);
	    btnaposta1.setTranslateY(440);
	    btnaposta1.setTranslateX(770);
	    btnaposta1.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnaposta2 = new Button();		
	    btnaposta2.setText("2");        
	    btnaposta2.setCenterShape(true);
	    btnaposta2.setTranslateY(440);
	    btnaposta2.setTranslateX(880);
	    btnaposta2.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnaposta3 = new Button();		
	    btnaposta3.setText("3");        
	    btnaposta3.setCenterShape(true);
	    btnaposta3.setTranslateY(500);
	    btnaposta3.setTranslateX(780);
	    btnaposta3.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnaposta4 = new Button();		
	    btnaposta4.setText("4");        
	    btnaposta4.setCenterShape(true);
	    btnaposta4.setTranslateY(500);
	    btnaposta4.setTranslateX(885);
	    btnaposta4.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
	    });
	    
	    root.getChildren().addAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4);
	}
	
	 

}
