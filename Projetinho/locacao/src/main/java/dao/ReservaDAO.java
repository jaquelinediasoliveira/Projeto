package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import org.json.JSONArray;

import models.Reserva;

public class ReservaDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	JSONArray ja;
	
	
	@SuppressWarnings("deprecation")
	public boolean cadastrarReserva(Reserva reserva) {
		
		boolean cadastro = true;

		String sql = "insert into reservas (id_cliente, veiculo, id_loja, id_tipo, data_retirada, data_devolucao_esperada) values (?,?,?,?,?,?);";
	
		String query = "insert into reservas (id_cliente, veiculo, id_loja, id_tipo, data_retirada) values (?,?,?,?,?);";
		
		String search = "select status_loc from veiculos where placa = ?;";
		
		
		
		conn = new ConexaoBD().conectaBD();
		
		
		PreparedStatement ps2;
		ResultSet rs2;
		Connection cnx;
		
		
		cnx = new ConexaoBD().conectaBD();
		
		try {
			
			
			
			ps2 = cnx.prepareStatement(search);
			
			ps2.setString(1, reserva.getVeiculo());
			
			rs2 = ps2.executeQuery();
			
			String veiculo = null;
			
			while(rs2.next()) {
				
				veiculo = rs2.getString("status_loc");
			}
			
			
			
			ps2.close();
			
			
			
			if(veiculo.equals("DISPONIVEL")) {
				
				

				if(reserva.getData_devolucao_esperada() != null) {
					
					try {
						
						ps = conn.prepareStatement(sql);
						
						ps.setInt(1, reserva.getId_cliente());
						ps.setString(2, reserva.getVeiculo());
						ps.setInt(3, reserva.getId_loja());
						ps.setInt(4, reserva.getId_tipo());
						ps.setString(5,  new java.sql.Timestamp(reserva.getData_retirada().getTime()).toString());
						ps.setString(6, new java.sql.Timestamp(reserva.getData_devolucao_esperada().getTime()).toString());
						System.out.println(new java.sql.Date(reserva.getData_retirada().getTime()));
						
						ps.execute();
						ps.close();
						
					} catch (SQLException e) {
						
						System.out.println("ReservaDAO: " + e);
					}
					
				}
				
				else {
					
					try {
						
						
						ps = conn.prepareStatement(query);
						
						ps.setInt(1, reserva.getId_cliente());
						ps.setString(2, reserva.getVeiculo());
						ps.setInt(3, reserva.getId_loja());
						ps.setInt(4, reserva.getId_tipo());
						ps.setString(5,  new java.sql.Timestamp(reserva.getData_retirada().getTime()).toString());
						
						ps.execute();
						ps.close();
						
					} catch (SQLException e) {
						
						System.out.println("ReservaDAO: " + e);
					}
					
					
				}
				
				
				cadastro = true;
			}
			
			else {
				
				cadastro = false;
			}
			
			
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		
		return cadastro;
		
		
		
		
	}
	
	
	public JSONArray consultarReserva(String id_cliente) throws ParseException {
		
		String sql = "SELECT reservas.*, veiculos.preco, veiculos.imagem FROM reservas\r\n"
				+ "INNER JOIN veiculos ON reservas.veiculo = veiculos.placa;";
		
		String busca = "SELECT reservas.*, veiculos.preco, veiculos.imagem FROM reservas\r\n"
				+ "INNER JOIN veiculos ON reservas.veiculo = veiculos.placa where id_cliente = ?;";
		
		String id = String.valueOf(id_cliente);
		
		JSONArray json = new JSONArray();
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			
			if(id_cliente == null) {
				
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				
				while(rs.next()){
					
					Reserva reserva = new Reserva();
					
					
					if(rs.getString("data_devolucao_esperada") != null && rs.getString("data_devolucao_final") == null) {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setData_devolucao_esperada(rs.getString("data_devolucao_esperada"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
					
					else if(rs.getString("data_devolucao_esperada") != null && rs.getString("data_devolucao_final") != null) {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setData_devolucao_esperada(rs.getString("data_devolucao_esperada"));
						reserva.setData_devolucao_final(rs.getString("data_devolucao_final"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
					
					
					
					else {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
					
					
				}
			}
			
			
			else {
				
				ps = conn.prepareStatement(busca);
				
				
				ps.setInt(1, Integer.parseInt(id_cliente));
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Reserva reserva = new Reserva();
					
					
					if(rs.getString("data_devolucao_esperada") != null && rs.getString("data_devolucao_final") == null) {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setData_devolucao_esperada(rs.getString("data_devolucao_esperada"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
					
					else if(rs.getString("data_devolucao_esperada") != null && rs.getString("data_devolucao_final") != null) {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setData_devolucao_esperada(rs.getString("data_devolucao_esperada"));
						reserva.setData_devolucao_final(rs.getString("data_devolucao_final"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
					
					else {
						
						reserva.setId_cliente(rs.getInt("id_cliente"));
						reserva.setVeiculo(rs.getString("veiculo"));
						reserva.setId_tipo(rs.getInt("id_tipo"));
						reserva.setId_loja(rs.getInt("id_loja"));
						reserva.setData_ret(rs.getString("data_retirada"));
						reserva.setValor(rs.getDouble("preco"));
						reserva.setImagem(rs.getString("imagem"));
						
						json.put(reserva.toJSON());
						
					}
				
				}
				
			}
			
			
			
			
			ps.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		return json;
		
	}
	
	
	public void atualizarReserva(Reserva reserva) {
		
		
		String sql = "update reservas set data_devolucao_final = ? where id_reserva = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, new java.sql.Timestamp(reserva.getData_devolucao_final().getTime()).toString());
			ps.setInt(2, reserva.getId_reserva());
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException e) {

			System.out.println("ERRO na alteração da reserva: " + e);
		}
		
		
		
		
	}
	
	public void deletarReserva(int id_reserva) {
		
		String sql = "delete from reservas where id_reserva = ?;";
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id_reserva);
			
			ps.execute();
			
			ps.close();
			
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		
		
		
	}

}
