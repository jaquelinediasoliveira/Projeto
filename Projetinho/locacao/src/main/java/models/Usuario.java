package models;

import org.json.JSONException;
import org.json.JSONObject;

public class Usuario {

	private int id_usuario;
	private int id_cliente;
	private int id_funcionario;
	private String cpf;
	private String passaporte;
	private String email;
	private String senha;
	private boolean tipo;
	private boolean logOn;
	
	
	public Usuario() {
		
	}
	
	
	public Usuario(int id_usuario, int id_cliente,String cpf, String passaporte, String email, String senha, boolean tipo, boolean logOn) {
		
		this.id_usuario = id_usuario;
		this.id_cliente = id_cliente;
		this.cpf = cpf;
		this.passaporte = passaporte;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.logOn = logOn;
	}
	
	
	public Usuario(int id_usuario, String cpf, String passaporte, String email, String senha, boolean tipo, boolean logOn, int id_funcionario) {
		
		this.id_usuario = id_usuario;
		this.id_funcionario = id_funcionario;
		this.cpf = cpf;
		this.passaporte = passaporte;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
		this.logOn = logOn;
	}
	
	
	public int getId_usuario() {
		return this.id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public int getId_cliente() {
		return this.id_cliente;
	}
	
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public int getId_funcionario() {
		return this.id_funcionario;
	}
	
	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassaporte() {
		return this.passaporte;
	}
	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public boolean getTipo() {
		return tipo;
	}
	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}
	public boolean getLogOn() {
		return logOn;
	}
	public void setLogOn(boolean logOn) {
		this.logOn = logOn;
	}
	
	
	@Override
	public String toString() {
		
		return id_usuario + " | " + id_cliente + " | " + id_funcionario + " | " + cpf + " | " + passaporte + " | " + email + " | " + senha + " | " + tipo + " | " + logOn + "\r\t";
	}
	
	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			
			json.put("id_usuario", id_usuario);
			json.put("id_cliente", id_cliente);
			json.put("id_funcionario", id_funcionario);
			json.put("cpf", cpf);
			json.put("passaporte", passaporte);
			json.put("email", email);
			json.put("senha", senha);
			json.put("tipo", tipo);
			json.put("logOn", logOn);
			
		} catch (JSONException e) {
			
			System.out.println("(Models/Usuários)Erro na conversão do JSON: " + e);
		}
		
		
		return json;
	}

	
}
