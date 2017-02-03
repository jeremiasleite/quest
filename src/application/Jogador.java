package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Jogador {
	
	private static model.Jogador j = new model.Jogador();
	private static Circle player1 = new Circle();
	private static Circle player2 = new Circle();
	
	public static void jogadores_init(int numJogadores, Group root){
		
		
		player1.setRadius(5.0);
		player1.setFill(Color.DARKORANGE);
		player1.setTranslateY(j.getYJogador(0, 0));
		player1.setTranslateX(j.getXJogador(0, 0));
		player1.setCache(true);
	    
	    player2.setRadius(5.0);
	    player2.setFill(Color.CHARTREUSE);
	    player2.setTranslateY(j.getYJogador(1, 0));
	    player2.setTranslateX(j.getXJogador(1, 0));
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
	
	/**
	 * Jogador.andar(Jogador[1 - 2], casa[0 - 26], Grupo);
	 * Movimenta um jogador para determinada casa.
	 */
	public static void andar(int jogador, int casa, Group root){
		switch (jogador) {
		case 1:
			root.getChildren().remove(player1);
			player1.setTranslateY(j.getYJogador(0, casa));
			player1.setTranslateX(j.getXJogador(0, casa));
			player1.setCache(true);
			root.getChildren().add(player1);
			break;
			
		case 2:
			root.getChildren().remove(player2);
			player2.setTranslateY(j.getYJogador(1, casa));
			player2.setTranslateX(j.getXJogador(1, casa));
			player2.setCache(true);
			root.getChildren().add(player2);
			break;

		default:
			break;
		}
	}

}
