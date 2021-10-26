package models;

import org.json.JSONException;
import org.json.JSONObject;

public class Filiais {

	private int id_loja;
	private String ender_loja;
	
	public Filiais() {
	
	}


	public Filiais(int id_loja, String ender_loja) {
		this.id_loja = id_loja;
		this.ender_loja = ender_loja;
	}
	
	
	public int getId_loja() {
		return id_loja;
	}
	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}
	public String getEnder_loja() {
		return ender_loja;
	}
	public void setEnder_loja(String ender_loja) {
		this.ender_loja = ender_loja;
	}


	@Override
	public String toString() {
		return id_loja + "	|	" + ender_loja;
	}
	
	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			
			json.put("id_loja", id_loja);
			json.put("ender_loja", ender_loja);
			
		}catch(JSONException e) {
			System.out.println("Erro ao converter JSON " + e);
		}
		
		
		return json;
	}
	
	
	
}
