package models;

import org.json.JSONException;
import org.json.JSONObject;

public class Documentos {

	private String cpf_passaporte;
	private int id_documento;
	private String cnh;
	private String rg;
	private String passaporte;
	
	public Documentos() {
		
	}
	
	public Documentos(int id_documento) {
		this.id_documento = id_documento;
	}
	
	public Documentos(int id_documento, String opc, boolean doc) {
		this.id_documento = id_documento;
		
		if(doc == true) {
			this.cnh = opc;
		}
		
		else {
			this.passaporte = opc;
		}
		
	}
	
	public Documentos(int id_documento, String cnh, String rg) {
		this.id_documento = id_documento;
		this.cnh = cnh;
		this.rg = rg;
	}
	

	
	public int getId_documento() {
		return id_documento;
	}
	public void setId_documento(int id_documento) {
		this.id_documento = id_documento;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getPassaporte() {
		return passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}

	@Override
	public String toString() {
		String retorno = null;
		
		if(this.passaporte == null) {
			retorno =  id_documento + "	|	" + cnh + "	|	" + rg;
		}
		
		else if((this.passaporte == null) && (this.rg == null)) {
			retorno = id_documento + "	|	" + cnh;
		}
		
		else if((this.passaporte == null) && (this.cnh == null)) {
			retorno = id_documento + "	|	" + rg;
		}
		else if((this.cnh == null) && (this.rg == null)) {
			retorno = id_documento + "	|	" + passaporte;
		}
	
		return retorno;
	}
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		
		try {
			
			if(this.passaporte == null) {
				json.put("id_documento", id_documento);
				json.put("cnh", cnh);
				json.put("rg", rg);
			}
			else if((this.passaporte == null) && (this.rg == null)) {
				json.put("id_documento", id_documento);
				json.put("cnh", cnh);
			}
			else if((this.passaporte == null) && (this.cnh == null)) {
				json.put("id_documento", id_documento);
				json.put("rg", rg);
			}
			else if((this.cnh == null) && (this.rg == null)) {
				json.put("id_documento", id_documento);
				json.put("passaporte", passaporte);
			}
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		return json;
	}
	
	
	
	
	
	
	
	
	
}
