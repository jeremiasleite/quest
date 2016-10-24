package application;


import javafx.scene.Group;

import javafx.scene.shape.Circle;

public class Jogador {
	
	public static void jogadores(Group root){
		
		Circle player1 = new Circle(); 
		player1.setRadius(5.0);
		player1.setTranslateY(360);
		player1.setTranslateX(540);
		player1.setCache(true);
	    
	    Circle player2 = new Circle(); 
	    player2.setRadius(5.0);
	    player2.setTranslateY(345);
	    player2.setTranslateX(540);
	    player2.setCache(true);
	    
	    
	    
	    
		root.getChildren().addAll(player1, player2);
		
	    
	    
	    
	    
		
	    		
		
	}

}
