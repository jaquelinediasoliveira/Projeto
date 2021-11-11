package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;


public class Cliente {

	SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id_cliente;
	private String cpf;
	private String passaporte;
	private String nome_completo;
	private String cep;
	private Date data_nascimento;
	private String telefone;
	private String endereco;
	

	public Cliente() {
	
	}

	public Cliente(int id_cliente, String cpf, String passaporte, String nome_completo, String cep, Date dataNascimento, String telefone, String endereco) {
		this.id_cliente = id_cliente;
		this.cpf= cpf;
		this.passaporte = passaporte;
		this.nome_completo = nome_completo;
		this.data_nascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
		
	}
	
	
	public int getId_cliente() {
		return this.id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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
	return id_cliente + " | " + cpf + " | " + passaporte + " | " +  nome_completo + " | " + cep +  " | " +  formato.format(data_nascimento) + " | " + telefone + " | " + endereco + "\r\t";
	}

	public JSONObject toJSON() {
		
		JSONObject json = new JSONObject();
		
		try {
			json.put("id_cliente", id_cliente);
			json.put("cpf", cpf);
			json.put("passaporte", passaporte);
			json.put("nome_completo", nome_completo);
			json.put("cep", cep);
			json.put("data_nascimento", data_nascimento);
			json.put("telefone", telefone);
			json.put("endereco", endereco);
			
		} catch (JSONException e) {
			System.out.println("Erro ao converter JSON: " + e);
		}
		
		return json;
	}
	
}
