package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.concurrent.ThreadLocalRandom;


public class Main extends Application {
	public int numJogadores = 2;
	@Override
	public void start(Stage primaryStage) {
		//Bot�o incrementa n�mero de jogadores
		Button btnJogadores = new Button();		
        btnJogadores.setText("2 Jogadores");        
        btnJogadores.setCenterShape(true);
        btnJogadores.setTranslateY(430);
        btnJogadores.setTranslateX(420);
        btnJogadores.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
            	if(numJogadores==6){
            		numJogadores=2;
            	}else{
            		numJogadores++; 
            	}            	           	
            	btnJogadores.setText(numJogadores +" Jogadores");
            }
        });
        
        //Bot�o incrementa n�mero de jogadores
        Button btnJogar = new Button();		
        btnJogar.setText("Jogar");        
        btnJogar.setCenterShape(true);
        btnJogar.setTranslateY(500);
        btnJogar.setTranslateX(420);
        btnJogar.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		System.out.println(numJogadores);
        		int jogador = ThreadLocalRandom.current().nextInt(1, numJogadores + 1);
        		String vezJogador = "Vez do " + jogador + " Jogador";
        		
        		Label label1 = new Label(vezJogador);
        		label1.setTranslateY(25);
        		label1.setTranslateX(42);
        		label1.setFont(new Font("Arial", 20));
        		label1.setTextFill(Color.web("#FFFF00"));

        		
        		
        		Circle c1 = new Circle(); 
        	    c1.setRadius(5.0);
        	    c1.setTranslateY(360);
                c1.setTranslateX(540);
        	    c1.setCache(true);
        	    
        	    Circle c2 = new Circle(); 
        	    c2.setRadius(5.0);
        	    c2.setTranslateY(345);
                c2.setTranslateX(540);
        	    c2.setCache(true);
        	    
        		Group root = new Group();
    			
    			Scene scene = new Scene(root,1023,674);
    			
    			
    			Canvas canvas = new Canvas( 1023, 674 );
    			root.getChildren().addAll(canvas, c1, c2, label1);
    			
    		    GraphicsContext gc = canvas.getGraphicsContext2D();
    		    
    		    Image tabuleiro = new Image( "Tabuleiro.png" );
    		    gc.drawImage( tabuleiro, 0, 0, 1023, 674);	//(image, posi��o horizontal em px, posi��o vertical em px, largura em px, altura em px)
    		    
    		    
    			primaryStage.setTitle("Quest");
    			primaryStage.setScene(scene);
    			primaryStage.show();
        	}
        });
        
		try {
			
			Group root = new Group();
			
			Scene scene = new Scene(root,1023,674);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			Canvas canvas = new Canvas( 1023, 674 );
		    root.getChildren().addAll( canvas, btnJogar, btnJogadores );
		    
		    GraphicsContext gc = canvas.getGraphicsContext2D();
		    
		    Image backgroud = new Image( "backgroud.png" );
		    gc.drawImage( backgroud, 0, 0, 1023, 674);	//(image, posi��o horizontal em px, posi��o vertical em px, largura em px, altura em px)
		    
		    Image logo = new Image( "logo.png" );
		    gc.drawImage( logo, 160, 10, 714, 500); //(image, posi��o horizontal em px, posi��o vertical em px, largura em px, altura em px)    
		   
			
			primaryStage.setTitle("Bem Vindo ao Quest");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
