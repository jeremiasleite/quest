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
import javafx.scene.image.Image;


public class Main extends Application {
	public int numJogadores = 2;
	@Override
	public void start(Stage primaryStage) {
		//Bot�o incrementa n�mero de jogadores
		/*Button btnJogadores = new Button();		
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
        });*/
        
        //Bot�o incrementa n�mero de jogadores
        Button btnJogar = new Button();		
        btnJogar.setText("Jogar");        
        btnJogar.setCenterShape(true);
        btnJogar.setTranslateY(500);
        btnJogar.setTranslateX(420);
        btnJogar.setOnAction(new EventHandler<ActionEvent>() {            
        	@Override
        	public void handle(ActionEvent event) {
        		//System.out.println(numJogadores);
        		Tabuleiro tabuleiro = new Tabuleiro();
        		tabuleiro.tabuleiro(numJogadores, primaryStage);
        	}
        });
        
		try {
			
			Group root = new Group();
			
			Scene scene = new Scene(root,1200,674);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			Canvas canvas = new Canvas( 1200, 674 );
		    root.getChildren().addAll( canvas, btnJogar );
		    
		    GraphicsContext gc = canvas.getGraphicsContext2D();
		    
		    Image backgroud = new Image( "background.png" );
		    gc.drawImage( backgroud, 0, 0, 1200, 674);	//(image, posi��o horizontal em px, posi��o vertical em px, largura em px, altura em px)
		    
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
