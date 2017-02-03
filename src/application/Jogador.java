package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Jogador {
	
	public static void jogadores(int numJogadores, Group root){
		
		model.Jogador j = new model.Jogador();
		
		Circle player1 = new Circle(); 
		player1.setRadius(5.0);
		player1.setFill(Color.DARKORANGE);
		player1.setTranslateY(j.getYJogador(0, 1));
		player1.setTranslateX(j.getXJogador(0, 1));
		player1.setCache(true);
	    
	    Circle player2 = new Circle(); 
	    player2.setRadius(5.0);
	    player2.setFill(Color.CHARTREUSE);
	    player2.setTranslateY(j.getYJogador(1, 13));
	    player2.setTranslateX(j.getXJogador(1, 13));
	    player2.setCache(true);
	    
	    Circle player3 = new Circle(); 
	    player3.setRadius(5.0);
	    player3.setTranslateY(360);
	    player3.setTranslateX(555);
	    player3.setCache(true);
	    
	    Circle player4 = new Circle(); 
	    player4.setRadius(5.0);
	    player4.setTranslateY(345);
	    player4.setTranslateX(555);
	    player4.setCache(true);
	    
	    Circle player5 = new Circle(); 
	    player5.setRadius(5.0);
	    player5.setTranslateY(360);
	    player5.setTranslateX(570);
	    player5.setCache(true);

	    Circle player6 = new Circle(); 
	    player6.setRadius(5.0);
	    player6.setTranslateY(345);
	    player6.setTranslateX(570);
	    player6.setCache(true);
	    
	    if(numJogadores==2){
	    	root.getChildren().addAll(player1, player2);
	    }
	    if(numJogadores==3){
	    	root.getChildren().addAll(player1, player2, player3);
	    }
	    if(numJogadores==4){
	    	root.getChildren().addAll(player1, player2, player3, player4);
	    }
	    if(numJogadores==5){
	    	root.getChildren().addAll(player1, player2, player3, player4, player5);
	    }        
	    if(numJogadores==6){
	    	root.getChildren().addAll(player1, player2, player3, player4, player5, player6);
	    }
	    
	    
		
	    		
		
	}

}
