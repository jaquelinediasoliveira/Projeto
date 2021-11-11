package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.json.JSONArray;

import models.Reserva;

public class ReservaDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	JSONArray ja;
	
	
	@SuppressWarnings("deprecation")
	public void cadastrarReserva(Reserva reserva) {
		

		String sql = "insert into reservas (id_cliente, veiculo, id_loja, id_tipo, data_retirada, data_devolucao_esperada) values (?,?,?,?,?,?);";
	
		String query = "insert into reservas (id_cliente, veiculo, id_loja, id_tipo, data_retirada) values (?,?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		
		
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
				System.out.println(new java.sql.Timestamp(reserva.getData_retirada().getTime()));
				System.out.println(new java.sql.Timestamp(reserva.getData_retirada().getTime()).toString());
				ps.setString(5,  new java.sql.Timestamp(reserva.getData_retirada().getTime()).toString());
				
				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				
				System.out.println("ReservaDAO: " + e);
			}
			
			
		}
		
		
	}
	
	
	public JSONArray consultarReserva() throws ParseException {
		
		String sql = "select * from reservas;";
		JSONArray json = new JSONArray();
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				
				Reserva reserva = new Reserva();
				
				
				if(rs.getString("data_devolucao_esperada") != null) {
					
					reserva.setId_cliente(rs.getInt("id_cliente"));
					reserva.setVeiculo(rs.getString("veiculo"));
					reserva.setId_tipo(rs.getInt("id_tipo"));
					reserva.setId_loja(rs.getInt("id_loja"));
					reserva.setData_ret(rs.getString("data_retirada"));
					reserva.setData_devolucao_esperada(rs.getString("data_devolucao_esperada"));
					
					json.put(reserva.toJSON());
					
				}
				
				else {
					
					reserva.setId_cliente(rs.getInt("id_cliente"));
					reserva.setVeiculo(rs.getString("veiculo"));
					reserva.setId_tipo(rs.getInt("id_tipo"));
					reserva.setId_loja(rs.getInt("id_loja"));
					reserva.setData_ret(rs.getString("data_retirada"));
					
					json.put(reserva.toJSON());
					
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
