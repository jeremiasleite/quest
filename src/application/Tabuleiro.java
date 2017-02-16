package application;

import java.util.ArrayList;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;

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
import model.Jogador;

public class Tabuleiro {
	private int contJogadas = 0;
	
	private int vez = 0;
	private boolean vencedor = false;
	private ArrayList<Jogador> jogadores = new ArrayList<>();
	private GerenciadorQuestao gestorQuestao;
	private int tabuleiro[] = { -1, 0, 1, 2, 3, 0, 4, 3, 0, 1, 2, 3, 5, 2, 3, 0, 6, 3, 5, 2, 3, 0, 7 };// inicio:-1,
																										// sc:0,
																										// xp:1,
																										// fdd:2,
																										// dsdm:3,
																										// xp/fdd:4,
																										// sc/xp:5,
																										// sc/fdd:6,
																										// fim:7

	public Tabuleiro() {
		super();
		this.gestorQuestao = new GerenciadorQuestao();
		for (int i = 0; i < 2; i++) {
			Jogador novoJogador = new Jogador();
			this.jogadores.add(novoJogador);
		}
	}

	public void tabuleiro(int numJogadores, Stage primaryStage) {

		// TODO Auto-generated method stub
		Group root = new Group();

		Scene scene = new Scene(root, 1200, 674);

		Canvas canvas = new Canvas(1200, 674);
		root.getChildren().addAll(canvas);
		application.Jogador.jogadores_init(numJogadores, root);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image tabuleiro = new Image("Tabuleiro.png");
		gc.drawImage(tabuleiro, 0, 0, 1200, 674);
		primaryStage.setTitle("Quest");
		primaryStage.setScene(scene);
		primaryStage.show();

		Tabuleiro tab = new Tabuleiro();

		tab.jogar(root);

	}

	public void jogar(Group root) {
		this.contJogadas++;
		if(this.contJogadas == 7){
			this.jogadores.get(0).reiniciarFichas();
			this.jogadores.get(1).reiniciarFichas();
			this.contJogadas = 1;
		}
		setTemas(this.jogadores.get(this.vez).getPosicao(), root);

	}

	public Label mostarVez(Group root) {
		// int jogador = ThreadLocalRandom.current().nextInt(1, numJogadores +
		// 1);
		int a = this.vez +1;
		String vezJogador = "Vez de: Jogador " + a;
		Label labelVezJogador = new Label(vezJogador);
		labelVezJogador.setTranslateY(21);
		labelVezJogador.setTranslateX(32);
		labelVezJogador.setFont(new Font("Helvetica", 22));
		labelVezJogador.setTextFill(Color.web("#FFFFFF"));
		// root.getChildren().add(labelVezJogador);
		return labelVezJogador;
	}

	public void mostrarPergunta(int tema, Group root) {

		model.Questao questao = this.gestorQuestao.sortearQuestao(tema);

		Label mostrarVez = mostarVez(root);
		root.getChildren().add(mostrarVez);

		Label labelPergunta = new Label();
		labelPergunta.setText(questao.getPergunta());
		labelPergunta.setTranslateY(290);
		labelPergunta.setTranslateX(742);
		labelPergunta.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		labelPergunta.setWrapText(true);
		labelPergunta.setFont(new Font("Helvetica", 13));
		labelPergunta.setTextFill(Color.web("#000000"));

		Label labelAposta = new Label();
		labelAposta.setText("Escolha umas das fichas para apostar!");
		labelAposta.setTranslateY(410);
		labelAposta.setTranslateX(742);
		labelAposta.setFont(new Font("Helvetica", 13));
		labelAposta.setTextFill(Color.web("#000000"));

		boolean fichas[] = jogadores.get(vez).getFichas();

		Button btnaposta1 = new Button();
		btnaposta1.setText("1");
		btnaposta1.setCenterShape(true);
		btnaposta1.setTranslateY(440);
		btnaposta1.setTranslateX(770);
		if (fichas[0] == false) {
			btnaposta1.setDisable(true);
		}
		Button btnaposta2 = new Button();
		btnaposta2.setText("2");
		btnaposta2.setCenterShape(true);
		btnaposta2.setTranslateY(440);
		btnaposta2.setTranslateX(880);
		if (fichas[1] == false) {
			btnaposta2.setDisable(true);
		}
		Button btnaposta3 = new Button();
		btnaposta3.setText("3");
		btnaposta3.setCenterShape(true);
		btnaposta3.setTranslateY(500);
		btnaposta3.setTranslateX(770);
		if (fichas[2] == false) {
			btnaposta3.setDisable(true);
		}
		Button btnaposta4 = new Button();
		btnaposta4.setText("4");
		btnaposta4.setCenterShape(true);
		btnaposta4.setTranslateY(500);
		btnaposta4.setTranslateX(880);
		if (fichas[3] == false) {
			btnaposta4.setDisable(true);
		}
		root.getChildren().addAll(labelPergunta, labelAposta, btnaposta1, btnaposta2, btnaposta3, btnaposta4);

		btnaposta1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jogadores.get(vez).apostarFicha(1);
				root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelAposta, labelPergunta,
						mostrarVez);
				mostrarAlternativas(questao, 1, root);
			}
		});

		btnaposta2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jogadores.get(vez).apostarFicha(2);
				root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelAposta, labelPergunta,
						mostrarVez);
				mostrarAlternativas(questao, 2, root);
			}
		});

		btnaposta3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jogadores.get(vez).apostarFicha(3);
				root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelAposta, labelPergunta,
						mostrarVez);
				mostrarAlternativas(questao, 3, root);
			}
		});

		btnaposta4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				jogadores.get(vez).apostarFicha(4);
				root.getChildren().removeAll(btnaposta1, btnaposta2, btnaposta3, btnaposta4, labelAposta, labelPergunta,
						mostrarVez);
				mostrarAlternativas(questao, 4, root);
			}
		});

	}

	public void mostrarAlternativas(model.Questao questao, int aposta, Group root) {
		Label mostrarVez = mostarVez(root);
		root.getChildren().add(mostrarVez);

		Label labelPergunta = new Label();
		labelPergunta.setText(questao.getPergunta());
		labelPergunta.setTranslateY(290);
		labelPergunta.setTranslateX(742);
		labelPergunta.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		labelPergunta.setWrapText(true);
		labelPergunta.setFont(new Font("Helvetica", 13));
		labelPergunta.setTextFill(Color.web("#000000"));

		Label lAternaviva1 = new Label();
		lAternaviva1.setText(questao.getAlternativas()[0]);
		lAternaviva1.setTranslateY(400);
		lAternaviva1.setTranslateX(730);
		lAternaviva1.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		lAternaviva1.setWrapText(true);
		lAternaviva1.setFont(new Font("Helvetica", 12));
		lAternaviva1.setTextFill(Color.web("#000000"));

		Button btnAlt1 = new Button();
		btnAlt1.setText("A");
		btnAlt1.setCenterShape(true);
		btnAlt1.setTranslateY(400);
		btnAlt1.setTranslateX(700);

		Label lAternaviva2 = new Label();
		lAternaviva2.setText(questao.getAlternativas()[1]);
		lAternaviva2.setTranslateY(450);
		lAternaviva2.setTranslateX(730);
		lAternaviva2.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		lAternaviva2.setWrapText(true);
		lAternaviva2.setFont(new Font("Helvetica", 12));
		lAternaviva2.setTextFill(Color.web("#000000"));

		Button btnAlt2 = new Button();
		btnAlt2.setText("B");
		btnAlt2.setCenterShape(true);
		btnAlt2.setTranslateY(450);
		btnAlt2.setTranslateX(700);

		Label lAternaviva3 = new Label();
		lAternaviva3.setText(questao.getAlternativas()[2]);
		lAternaviva3.setTranslateY(500);
		lAternaviva3.setTranslateX(730);
		lAternaviva3.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		lAternaviva3.setWrapText(true);
		lAternaviva3.setFont(new Font("Helvetica", 12));
		lAternaviva3.setTextFill(Color.web("#000000"));

		Button btnAlt3 = new Button();
		btnAlt3.setText("C");
		btnAlt3.setCenterShape(true);
		btnAlt3.setTranslateY(500);
		btnAlt3.setTranslateX(700);

		Label lAternaviva4 = new Label();
		lAternaviva4.setText(questao.getAlternativas()[3]);
		lAternaviva4.setTranslateY(550);
		lAternaviva4.setTranslateX(730);
		lAternaviva4.setMaxWidth(450);// limitar tamanho da linha pergunta e
										// quebra linha
		lAternaviva4.setWrapText(true);
		lAternaviva4.setFont(new Font("Helvetica", 12));
		lAternaviva4.setTextFill(Color.web("#000000"));

		Button btnAlt4 = new Button();
		btnAlt4.setText("D");
		btnAlt4.setCenterShape(true);
		btnAlt4.setTranslateY(550);
		btnAlt4.setTranslateX(700);

		root.getChildren().addAll(lAternaviva1, lAternaviva2, lAternaviva3, lAternaviva4, btnAlt1, btnAlt2, btnAlt3,
				btnAlt4, labelPergunta);

		btnAlt1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().removeAll(btnAlt1, btnAlt2, btnAlt3, btnAlt4, lAternaviva1, lAternaviva2,
						lAternaviva3, lAternaviva4, labelPergunta, mostrarVez);
				if (questao.getResposta() == 0) {
					jogadores.get(vez).setPosicao(aposta);
					application.Jogador.andar(vez + 1, jogadores.get(vez).getPosicao(), root);					
				}
				if(jogadores.get(vez).getPosicao()>=22){
					Label labelVencedor = new Label();
					int a = vez +1;
					labelVencedor.setText("O jogador "+ a +" venceu!!");
					labelVencedor.setTranslateY(290);
					labelVencedor.setTranslateX(742);
					labelVencedor.setMaxWidth(450);// limitar tamanho da linha pergunta e
													// quebra linha
					labelVencedor.setWrapText(true);
					labelVencedor.setFont(new Font("Helvetica", 30));
					labelVencedor.setTextFill(Color.web("#000000"));
					
					root.getChildren().add(labelVencedor);
				}else{
					mudarVez();
					jogar(root);
				}
			}
		});

		btnAlt2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().removeAll(btnAlt1, btnAlt2, btnAlt3, btnAlt4, lAternaviva1, lAternaviva2,
						lAternaviva3, lAternaviva4, labelPergunta, mostrarVez);
				if (questao.getResposta() == 1) {
					jogadores.get(vez).setPosicao(aposta);
					application.Jogador.andar(vez + 1, jogadores.get(vez).getPosicao(), root);
				}
				if(jogadores.get(vez).getPosicao()>=22){
					Label labelVencedor = new Label();
					int a = vez +1;
					labelVencedor.setText("O jogador "+ a +" venceu!!");
					labelVencedor.setTranslateY(290);
					labelVencedor.setTranslateX(742);
					labelVencedor.setMaxWidth(450);// limitar tamanho da linha pergunta e
													// quebra linha
					labelVencedor.setWrapText(true);
					labelVencedor.setFont(new Font("Helvetica", 30));
					labelVencedor.setTextFill(Color.web("#000000"));
					
					root.getChildren().add(labelVencedor);
				}else{
					mudarVez();
					jogar(root);
				}
			}
		});

		btnAlt3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().removeAll(btnAlt1, btnAlt2, btnAlt3, btnAlt4, lAternaviva1, lAternaviva2,
						lAternaviva3, lAternaviva4, labelPergunta, mostrarVez);
				if (questao.getResposta() == 2) {
					jogadores.get(vez).setPosicao(aposta);
					application.Jogador.andar(vez + 1, jogadores.get(vez).getPosicao(), root);

				}
				if(jogadores.get(vez).getPosicao()>=22){
					Label labelVencedor = new Label();
					int a = vez +1;
					labelVencedor.setText("O jogador "+ a+" venceu!!");
					labelVencedor.setTranslateY(290);
					labelVencedor.setTranslateX(742);
					labelVencedor.setMaxWidth(450);// limitar tamanho da linha pergunta e
													// quebra linha
					labelVencedor.setWrapText(true);
					labelVencedor.setFont(new Font("Helvetica", 30));
					labelVencedor.setTextFill(Color.web("#000000"));
					
					root.getChildren().add(labelVencedor);
				}else{
					mudarVez();
					jogar(root);
				}
			}
		});

		btnAlt4.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				root.getChildren().removeAll(btnAlt1, btnAlt2, btnAlt3, btnAlt4, lAternaviva1, lAternaviva2,
						lAternaviva3, lAternaviva4, labelPergunta, mostrarVez);
				if (questao.getResposta() == 3) {
					jogadores.get(vez).setPosicao(aposta);
					application.Jogador.andar(vez + 1, jogadores.get(vez).getPosicao(), root);
				}
				if(jogadores.get(vez).getPosicao()>=22){
					Label labelVencedor = new Label();
					int a = vez +1;
					labelVencedor.setText("O jogador "+ a +" venceu!!");
					labelVencedor.setTranslateY(290);
					labelVencedor.setTranslateX(742);
					labelVencedor.setMaxWidth(450);// limitar tamanho da linha pergunta e
													// quebra linha
					labelVencedor.setWrapText(true);
					labelVencedor.setFont(new Font("Helvetica", 30));
					labelVencedor.setTextFill(Color.web("#000000"));
					
					root.getChildren().add(labelVencedor);
				}else{
					mudarVez();
					jogar(root);
				}
			}
		});
	}

	public void setTemas(int posicao, Group root) {
		Label mostrarVez = mostarVez(root);
		root.getChildren().add(mostrarVez);
		int tema = this.tabuleiro[posicao];
		
		if (posicao == 0) {// jogador está na casa inicial			

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
			root.getChildren().addAll(btnFDD, btnXp, btnDsdm, btnScrum);
			
			btnScrum.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, mostrarVez);
					mostrarPergunta(0, root);
				}
			});

			btnDsdm.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, mostrarVez);
					mostrarPergunta(3, root);
				}
			});

			btnXp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, mostrarVez);
					mostrarPergunta(1, root);
				}
			});

			btnFDD.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, btnDsdm, btnScrum, mostrarVez);
					mostrarPergunta(2, root);
				}
			});
		}else if(tema ==4){
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
			root.getChildren().addAll(btnFDD, btnXp);
			btnXp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, mostrarVez);
					mostrarPergunta(1, root);
				}
			});

			btnFDD.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnXp, mostrarVez);
					mostrarPergunta(2, root);
				}
			});
		}else if(tema==5){
			Button btnScrum = new Button();
			btnScrum.setText("Scrum");
			btnScrum.setCenterShape(true);
			btnScrum.setTranslateY(440);
			btnScrum.setTranslateX(770);
			
			Button btnXp = new Button();
			btnXp.setText("XP");
			btnXp.setCenterShape(true);
			btnXp.setTranslateY(500);
			btnXp.setTranslateX(780);
			
			root.getChildren().addAll(btnXp, btnScrum);
			
			btnScrum.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnXp, btnScrum, mostrarVez);
					mostrarPergunta(0, root);
				}
			});
			
			btnXp.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnScrum, btnXp, mostrarVez);
					mostrarPergunta(1, root);
				}
			});

		}else if(tema==6){
			Button btnScrum = new Button();
			btnScrum.setText("Scrum");
			btnScrum.setCenterShape(true);
			btnScrum.setTranslateY(440);
			btnScrum.setTranslateX(770);
			
			Button btnFDD = new Button();
			btnFDD.setText("FDD");
			btnFDD.setCenterShape(true);
			btnFDD.setTranslateY(500);
			btnFDD.setTranslateX(780);
			
			root.getChildren().addAll(btnFDD, btnScrum);
			
			btnScrum.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnFDD, btnScrum, mostrarVez);
					mostrarPergunta(0, root);
				}
			});
			
			btnFDD.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					root.getChildren().removeAll(btnScrum, btnFDD, mostrarVez);
					mostrarPergunta(1, root);
				}
			});
		}else{
			root.getChildren().removeAll(mostrarVez);
			mostrarPergunta(tema, root);
		}

	}

	private void mudarVez() {
		if (this.vez == 0) {
			this.vez = 1;
		} else {
			this.vez = 0;
		}
	}
}
