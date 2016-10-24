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


	public static void tabuleiro(int numJogadores, Stage primaryStage) {
		// TODO Auto-generated method stub
		
		
	    
	    Button btnScrum = new Button();		
	    btnScrum.setText("Scrum");        
	    btnScrum.setCenterShape(true);
	    btnScrum.setTranslateY(440);
	    btnScrum.setTranslateX(770);
	    btnScrum.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnDsdm = new Button();		
	    btnDsdm.setText("DSDM");        
	    btnDsdm.setCenterShape(true);
	    btnDsdm.setTranslateY(440);
	    btnDsdm.setTranslateX(880);
	    btnDsdm.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnXp = new Button();		
	    btnXp.setText("XP");        
	    btnXp.setCenterShape(true);
	    btnXp.setTranslateY(500);
	    btnXp.setTranslateX(780);
	    btnXp.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Button btnFDD = new Button();		
	    btnFDD.setText("FDD");        
	    btnFDD.setCenterShape(true);
	    btnFDD.setTranslateY(500);
	    btnFDD.setTranslateX(885);
	    btnFDD.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		
        		Inicio.inicio(numJogadores, primaryStage);
        		
        	}
        });
	    
	    Group root = new Group();
		
		Scene scene = new Scene(root,1023,674);
			
		Canvas canvas = new Canvas( 1023, 674 );
		root.getChildren().addAll(canvas, Quest�o.tema(), Tabuleiro.vez(numJogadores),btnFDD, btnXp, btnDsdm, btnScrum);
		Jogador.jogadores(numJogadores, root);
	    GraphicsContext gc = canvas.getGraphicsContext2D();
	    
	    Image tabuleiro = new Image( "Tabuleiro.png" );
	    gc.drawImage( tabuleiro, 0, 0, 1023, 674);
	    primaryStage.setTitle("Quest");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	    
	    
	    
		
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
