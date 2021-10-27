package models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

public class Reservas {

	private int id_reserva;
	private String cpf_passaporte;
	private String veiculo;
	private int id_loja;
	private int id_tipo;
	
	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat h = new SimpleDateFormat("hh:mm");
	
	private Date data_retirada;
	private Date hora_retirada;
	private Date data_devolucao;
	private Date hora_devolucao;
	
	
	public Reservas() {
	
	}


	public Reservas(String cpf_passaporte, String veiculo, int id_loja, int id_tipo, Date data_retirada, Date hora_retirada,
			Date data_devolucao, Date hora_devolucao) {
		this.cpf_passaporte = cpf_passaporte;
		this.veiculo = veiculo;
		this.id_loja = id_loja;
		this.id_tipo = id_tipo;
		this.data_retirada = data_retirada;
		this.hora_retirada = hora_retirada;
		this.data_devolucao = data_devolucao;
		this.hora_devolucao = hora_devolucao;
	}
	
	
	public int getId_reserva() {
		return this.id_reserva;
	}
	
	public String getCpf_passaporte() {
		return cpf_passaporte;
	}
	public void setCpf(String cpf_passaporte) {
		this.cpf_passaporte = cpf_passaporte;
	}
	public String getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}
	public int getId_loja() {
		return id_loja;
	}
	public void setId_loja(int id_loja) {
		this.id_loja = id_loja;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
	
	public Date getData_retirada() {
		return data_retirada;
	}
	
	/* ********************************************************************************************************* */
	
	public String getDataRet() {
		String data;
		data = String.valueOf(this.data_retirada);
		return data;
	}
	
	/* *************************************************************************************************************** */ 

	public void setData_retirada(Date data_retirada) {
		this.data_retirada = data_retirada;
	}
	
	public void setData_retirada(String data_retirada) throws ParseException {
		this.data_retirada = d.parse(data_retirada);
	
	}
	
	
	
	
	public String getHoraRetirada() {
		String hora;
		hora = String.valueOf(this.hora_retirada);
		return hora;
	}
	
	
	
	public Date getHora_retirada() {
		return hora_retirada;
	}
	
	
	public void setHora_retirada(Date hora_retirada) {
		this.hora_retirada = hora_retirada;
	}
	
	
	public void setHora_retirada(String hora_retirada) throws ParseException {
		this.hora_retirada = h.parse(hora_retirada);
	}

	
	
	
	public String getDataDevolucao() {
		String data;
		data = String.valueOf(this.data_devolucao);
		
		return data;
	}
	
	public Date getData_devolucao() {
		return data_devolucao;
	}
	
	
	

	public void setData_devolucao(Date data_devolucao) {
		this.data_devolucao = data_devolucao;
	}
	
	
	public void setData_devolucao(String data_devolucao) throws ParseException {
		this.data_devolucao = d.parse(data_devolucao);
	}
	
	
	public Date getHora_devolucao() {
		return hora_devolucao;
	}
	
	public String getHoraDevolucao() {
		String hora;
		
		hora = String.valueOf(this.hora_devolucao);
		return hora;
	}
	
	
	public void setHora_devolucao(Date hora_devolucao) {
		this.hora_devolucao = hora_devolucao;
	}
	
	public void setHora_devolucao(String hora_devolucao) throws ParseException {
		this.hora_devolucao = h.parse(hora_devolucao);
	}
	
	@Override
	public String toString() {
		return id_reserva + "	|	" + cpf_passaporte + "	|	" + veiculo + "	|	" + id_loja + "	|	" + id_tipo + "	|	" + d.format(data_retirada) + "	|	" + h.format(hora_retirada) + "	|	" + d.format(data_devolucao) + "	|	" + h.format(hora_devolucao) + "	|	";
	}
	
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		
		try {
			
			json.put("id_reserva", id_reserva);
			json.put("cpf_passsaporte", cpf_passaporte);
			json.put("veiculo", veiculo);
			json.put("id_loja", id_loja);
			json.put("id_tipo", id_tipo);
			json.put("data_retirada", data_retirada);
			json.put("hora_retirada", hora_retirada);
			json.put("data_devolucao", data_devolucao);
			json.put("hora_devolucao", hora_devolucao);
			
			
			
		}catch(JSONException e) {
			System.out.println("Erro ao converter JSON: "+e);
		}
		
		return json;
	}
	
	
}