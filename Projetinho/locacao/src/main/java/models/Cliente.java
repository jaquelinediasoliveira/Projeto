package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class Cliente {

	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	private String cpf_passaporte;
	private String nome_completo;
	private String cep;
	private String email;
	private String senha;
	private Date data_nascimento;
	private String telefone;
	private String endereco;
	

	public Cliente() {
	
	}

	public Cliente(String cpf_passaporte, String nome_completo, String cep, String email, Date dataNascimento, String telefone, String endereco, String senha) {
		this.cpf_passaporte= cpf_passaporte;
		this.nome_completo = nome_completo;
		this.data_nascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		this.email = email;
		this.senha = senha;
	}
	
	
	public String getCpf_passaporte() {
		return cpf_passaporte;
	}
	public void setCpf_passaporte(String cpf) {
		this.cpf_passaporte = cpf;
	}
	
	
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome) {
		this.nome_completo = nome;
	}
	
	public String getCep() {
		return this.cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return this.senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Date getDataNascimento() {
		return data_nascimento;
	}
	
	

	
	//Data de Nascimento covertida em String
	public String getDataNascimentoC() {
		Calendar c = Calendar.getInstance();
		
		c.setTime(this.data_nascimento);
		
		String dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(c.get(Calendar.MONTH));
		String ano = String.valueOf(c.get(Calendar.YEAR));
		
		return ano + '-' + mes + '-' + dia;
	}
	
	
	public void setDataNascimento(String data_nascimento) throws ParseException {
			this.data_nascimento = formato.parse(data_nascimento);
	
	}
	
	public void setDataNascimento(Date data_nascimento) {	
			this.data_nascimento = data_nascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
	@Override
	public String toString() {
	return cpf_passaporte + "	|	" +  nome_completo + "	|	" + cep + "	|	" + email + "	|	" + senha + "	|	" +  formato.format(data_nascimento) + "	|	" + telefone + "	|	" + endereco;
	}

	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			
			json.put("cpf_passaporte", cpf_passaporte);
			json.put("nome_completo", nome_completo);
			json.put("cep", cep);
			json.put("email", email);
			json.put("senha", senha);
			json.put("dataNascimento", data_nascimento);
			json.put("telefone", telefone);
			json.put("endereco", endereco);
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		return json;
	}
	
}
