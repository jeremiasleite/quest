package application;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Questão {
	static boolean perg = true;
	static String pergunta = "";
	public static Label tema(){
		
		if (perg){
			pergunta = "Escolha o tema da pergunta";
			perg = false;
		}else {
			pergunta = "Pergunta";
		}
		
		
		Label labelPergunta = new Label(pergunta);
		labelPergunta.setTranslateY(350);
		labelPergunta.setTranslateX(740);
		labelPergunta.setFont(new Font("Helvetica", 20));
		labelPergunta.setTextFill(Color.web("#000000"));
		
		return labelPergunta;
		
	}
	public static TextField resposta(){
		
		
		TextField resposta = new TextField();
		resposta.setTranslateY(575);
		resposta.setTranslateX(710);
		resposta.setPrefSize(270, 30);
		
		return resposta;
		
	}

}
