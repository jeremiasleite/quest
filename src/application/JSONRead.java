package application;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.Questao;

public class JSONRead {	
	private ArrayList<Questao> questoes = new ArrayList<>();	
	
	public JSONRead() {
		lerArquivoQuestoes();
	}
	/**Método que retorna todas as questao
	 * @return ArrayList - ArrayList<Questao> de todas as questoes*/
	public ArrayList<Questao> getQuestoes() {
		return this.questoes;
	}	
	
	/**Método que retorna todas as questao de um tema
	 * @param tema int - codigo do tema
	 * @return ArrayList - ArrayList<Questao> de um determinado tema*/
	public ArrayList<Questao> getQuestoesPorTema(int tema) {
		ArrayList<Questao> questoesPorTema = new ArrayList<>();
		for (int i = 0; i < this.questoes.size(); i++) {
			if(questoes.get(i).getTema()==tema){
				questoesPorTema.add(questoes.get(i));
			}
		}
		return questoesPorTema;
	} 
	
	private void lerArquivoQuestoes(){
		JSONObject jsonObject;
		//Cria o parse de tratamento
		JSONParser parser = new JSONParser();
		
		try {
			//Salva no objeto JSONObject o que o parse tratou do arquivo
			jsonObject = (JSONObject) parser.parse(new FileReader(
					"src/perguntas.json"));		
			
			JSONArray jsonQuestoes = new JSONArray();
			jsonQuestoes = (JSONArray) jsonObject.get("questoes");
			//System.out.printf(jsonQuestoes.toJSONString());
			
			for (int i = 0; i < jsonQuestoes.size(); i++) {
				Questao questao = new Questao();
				String[] alternativas = new String[4];
				JSONObject jsonQuestao = new JSONObject();
				jsonQuestao = (JSONObject) jsonQuestoes.get(i);
				
				questao.setTema(Integer.parseInt((String) jsonQuestao.get("tema")));
				questao.setResposta(Integer.parseInt((String) jsonQuestao.get("resposta")));
				questao.setPergunta((String) jsonQuestao.get("pergunta"));
				questao.setId(Integer.parseInt((String) jsonQuestao.get("id")));
				
				
				JSONArray jsonAlternativas = new JSONArray();
				jsonAlternativas = (JSONArray) jsonQuestao.get("alternativas");	
				
				alternativas[0] = (String) jsonAlternativas.get(0);
				alternativas[1] = (String) jsonAlternativas.get(1);
				alternativas[2] = (String) jsonAlternativas.get(2);
				alternativas[3] = (String) jsonAlternativas.get(3);
				
				questao.setAlternativas(alternativas);
				this.questoes.add(questao);	
				
			}
			
		} 
		//Trata as exceptions que podem ser lançadas no decorrer do processo
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
