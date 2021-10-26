package models;

import org.json.JSONException;
import org.json.JSONObject;

public class Veiculo {

	private int id_veiculo;
	private String marca;
	private String modelo;
	private String cor;
	private String placa;
	private String tipo_loc;
	
	public Veiculo() {
		
	}


	public Veiculo(int id_veiculo, String marca, String modelo, String cor, String placa, String tipo_loc) {
		this.id_veiculo = id_veiculo;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.tipo_loc = tipo_loc;
	}
	
	
	public int getId_veiculo() {
		return id_veiculo;
	}
	public void setId_veiculo(int id_veiculo) {
		this.id_veiculo = id_veiculo;
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
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getTipo_loc() {
		return tipo_loc;
	}
	public void setTipo_loc(String tipo_loc) {
		this.tipo_loc = tipo_loc;
	}


	@Override
	public String toString() {
		return id_veiculo + "	|	" + marca + "	|	" + modelo + "	|	" + cor
				+ "	|	" + placa + "	|	" + tipo_loc;
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("id_veiculo", id_veiculo);
			json.put("marca", marca);
			json.put("modelo", modelo);
			json.put("cor", cor);
			json.put("placa", placa);
			json.put("tipo_loc", tipo_loc);
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		
		return json;
		
	}
	
	
}
