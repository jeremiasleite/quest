package application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Inicio {
	
	public static void inicio(int numJogadores, Stage primaryStage){
				
		Group root = new Group();
		
		Scene scene = new Scene(root,1200,674);		
		
		Canvas canvas = new Canvas( 1200, 674 );
		root.getChildren().addAll(canvas, Questao.tema(), Tabuleiro.vez(numJogadores), Questao.resposta());
		
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
	    Image tabuleiro = new Image( "Tabuleiro.png" );
	    gc.drawImage( tabuleiro, 0, 0, 1200, 674);	
	    
	    Jogador.jogadores_init(numJogadores, root);
	    
	    
		primaryStage.setTitle("Quest");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	


}
