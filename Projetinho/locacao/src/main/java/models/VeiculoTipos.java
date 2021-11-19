package models;

import org.json.JSONException;
import org.json.JSONObject;

public class VeiculoTipos {
	
	
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float preco;
	private String status_loc;
	private String tipo;
	
	
	
	public VeiculoTipos() {
		
	}
	
	
	
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
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
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public String getStatus_loc() {
		return status_loc;
	}
	public void setStatus_loc(String status_loc) {
		this.status_loc = status_loc;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("placa", placa);
			json.put("marca", marca);
			json.put("modelo", modelo);
			json.put("cor", cor);
			json.put("preco", preco);
			json.put("status_loc", status_loc);
			json.put("tipo", tipo);
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		
		return json;
		
	}
	

}
