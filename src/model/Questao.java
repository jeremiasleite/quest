package model;

public class Questao {
	private int tema;
	private String pergunta;
	private String[] alternativas;
	private int resposta;
	private int id;
	
	
	public int getTema() {
		return tema;
	}
	public void setTema(int tema) {
		this.tema = tema;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public int getResposta() {
		return resposta;
	}
	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	public String[] getAlternativas() {
		return alternativas;
	}
	public void setAlternativas(String[] alternativas) {
		this.alternativas = alternativas;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
