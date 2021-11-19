package models;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.json.JSONException;
import org.json.JSONObject;

public class ConsultaBD {

	private int id_cliente;
	private String nome_completo;
	private String cpf;
	private String passaporte;
	private String telefone;
	private String cep;
	private String endereco;
	private Date data_nascimento;
	
	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	
	public ConsultaBD() {
	}


	public ConsultaBD(int id_cliente, String nome_completo) {
		
		this.id_cliente = id_cliente;
		this.nome_completo = nome_completo;
		
		
	}
	
	
	
	
	
	
	
	
	
	

	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getPassaporte() {
		return passaporte;
	}


	public void setPassaporte(String passaporte) {
		this.passaporte = passaporte;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Date getData_nascimento() {
		return data_nascimento;
	}


	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}


	public void setData_nascimento(String data_nascimento) throws ParseException {
		this.data_nascimento = (Date) d.parse(data_nascimento);
	}


	public int getId_cliente() {
		return id_cliente;
	}


	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}


	public String getNome_completo() {
		return nome_completo;
	}


	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	
	
	public JSONObject toJSON() {
		
		JSONObject jo = new JSONObject();
		
		try {
			
			
			
			jo.put("id_cliente", id_cliente);
			jo.put("nome_completo", nome_completo);
			jo.put("cpf", cpf);
			jo.put("passaporte", passaporte);
			jo.put("telefone", telefone);
			jo.put("cep", cep);
			jo.put("endereco", endereco);
			jo.put("data_nascimento", data_nascimento);
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
		return jo;
	}
	
	
	
	
	
	
}
