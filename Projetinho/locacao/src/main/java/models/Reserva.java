package models;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.json.JSONException;
import org.json.JSONObject;

public class Reserva {

	private int id_reserva;
	private int id_cliente;
	private String veiculo;
	private double valor;
	private String imagem;
	private int id_tipo;
	private int id_loja;
	
	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	NumberFormat z = NumberFormat.getCurrencyInstance();
	
	private Date data_retirada;
	private Date data_devolucao_esperada;
	private Date data_devolucao_final;
	
	public Reserva() {
	
	}


	public Reserva(int id_cliente, String veiculo, int id_loja, int id_tipo, Date data_retirada, Date data_devolucao_esperada, Date data_devolucao_final) {
		this.id_cliente = id_cliente;
		this.veiculo = veiculo;
		this.id_loja = id_loja;
		this.id_tipo = id_tipo;
		this.data_retirada = data_retirada;
		this.data_devolucao_esperada = data_devolucao_esperada;
		this.data_devolucao_final = data_devolucao_final;
	}
	
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	public int getId_reserva() {
		return this.id_reserva;
	}
	
	public int getId_cliente() {
		return this.id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
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
	
	
/* ********************************************************************************************************* */
	
	public Date getData_retirada() {
		return data_retirada;
	}
	
	
	public String getDataRet() {

		Calendar c = GregorianCalendar.getInstance();
		
		c.setTime(this.data_retirada);
		
		String dia = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		String mes = String.valueOf(c.get(Calendar.MONTH) + 1);
		String ano = String.valueOf(c.get(Calendar.YEAR));
		
		String horas = String.valueOf(c.get(Calendar.HOUR_OF_DAY));
		
		String minutos = String.valueOf(c.get(Calendar.MINUTE));
		
		return ano + '-' + mes + '-' + dia + " " + horas + ":" + minutos;
		
	}
	


	public void setData_retirada(Date data_retirada) {
		this.data_retirada = data_retirada;
	}
	
	public void setData_ret(String data_retirada) throws ParseException {
		this.data_retirada = d.parse(data_retirada);
	
	}
	
/* *************************************************************************************************************** */ 
	
	public Date getData_devolucao_esperada() {
		return data_devolucao_esperada;
	}


	public void setData_devolucao_esperada(Date data_devolucao_esperada) {
		this.data_devolucao_esperada = data_devolucao_esperada;
	}
	
	public void setData_devolucao_esperada(String data_devolucao_esperada) throws ParseException {
		this.data_devolucao_esperada = d.parse(data_devolucao_esperada);
	}
	
	
	public Date getData_devolucao_final() {
		return data_devolucao_final;
	}


	public void setData_devolucao_final(Date data_devolucao_final) {
		this.data_devolucao_final = data_devolucao_final;
	}
	
	public void setData_devolucao_final(String data_devolucao_final) throws ParseException {
		this.data_devolucao_final = d.parse(data_devolucao_final);
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	public String getImagem() {
		return this.imagem;
	}
	
	@Override
	public String toString() {
		return id_reserva + "	|	" + id_cliente + "	|	" + veiculo + "	|	" + id_loja + "	|	" + id_tipo + "	|	" + d.format(data_retirada) + "	|	" + d.format(data_devolucao_esperada) +  "	|	"
				+ "	|	"	+ data_devolucao_final;
	}
	
	
	public JSONObject toJSON() {
		JSONObject json = new JSONObject();
		
		
		if(data_devolucao_esperada != null && data_devolucao_final != null) {
			
			try {
				
				json.put("id_reserva", id_reserva);
				json.put("id_cliente", id_cliente);
				json.put("veiculo", veiculo);
				json.put("id_loja", id_loja);
				json.put("id_tipo", id_tipo);
				json.put("data_retirada", data_retirada);
				json.put("data_devolucao_esperada", data_devolucao_esperada);
				json.put("data_devolucao_final", data_devolucao_final);
				json.put("valor", z.format(valor));
				json.put("imagem", imagem);
				
			}catch(JSONException e) {
				System.out.println("Erro ao converter JSON: "+e);
			}
			
		}
		
		else if(data_devolucao_esperada != null && data_devolucao_final == null) {
			
			try {
				
				json.put("id_reserva", id_reserva);
				json.put("id_cliente", id_cliente);
				json.put("veiculo", veiculo);
				json.put("id_loja", id_loja);
				json.put("id_tipo", id_tipo);
				json.put("data_retirada", data_retirada);
				json.put("data_devolucao_esperada", data_devolucao_esperada);
				json.put("valor", z.format(valor));
				json.put("imagem", imagem);
				
			}catch(JSONException e) {
				System.out.println("Erro ao converter JSON: "+e);
			}
			
		}
		
		
		else {
			
			try {
				
				json.put("id_reserva", id_reserva);
				json.put("id_cliente", id_cliente);
				json.put("veiculo", veiculo);
				json.put("id_loja", id_loja);
				json.put("id_tipo", id_tipo);
				json.put("data_retirada", data_retirada);
				json.put("valor", z.format(valor));
				json.put("imagem", imagem);
				
			}catch(JSONException e) {
				System.out.println("Erro ao converter JSON: "+e);
			}
			
			
		}
		
		
		
		
		return json;
	}
	
	
}