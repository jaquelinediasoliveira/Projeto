package models;

import org.json.JSONException;
import org.json.JSONObject;

public class Veiculo {

	private String placa;
	private int id_tipo;
	private String marca;
	private String modelo;
	private String cor;
	private float preco;
	private String status_loc;
	private String imagem;
	
	public Veiculo() {
		
	}


	public Veiculo(String placa, int id_tipo, String marca, String modelo, String cor, float preco, String status_loc) {
		this.placa = placa;
		this.id_tipo = id_tipo;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.preco = preco;
		this.status_loc = status_loc;
	}
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public int getId_tipo() {
		return id_tipo;
	}
	
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getCor() {
		return cor;
	}
	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public float getPreco() {
		return this.preco;	
	}
	
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public String getStatus_loc() {
		return this.status_loc;
	}
	
	public void setStatus_loc(String status_loc) {
		this.status_loc = status_loc;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getImagem() {
		return this.imagem;
	}


	@Override
	public String toString() {
		return placa + "	|	" + id_tipo + "		|	 " + marca + "	|	" + modelo + "		|	" + cor + " 	|	" + preco + "	|	" + status_loc + "\r\t";
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("placa", placa);
			json.put("id_tipo", id_tipo);
			json.put("marca", marca);
			json.put("modelo", modelo);
			json.put("cor", cor);
			json.put("preco", preco);
			json.put("status_loc", status_loc);
			json.put("imagem", imagem);
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		
		return json;
		
	}
	
	
}
