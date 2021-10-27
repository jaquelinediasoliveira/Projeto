package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Reservas;

public class ReservaDAO {
	
	Connection conn;
	PreparedStatement ps;
	
	
	
	public void cadastrarReserva(Reservas reserva) {
		
		
		String sql = "insert into reserva (cpf_passaporte, veiculo, id_loja, id_tipo, data_retirada, hora_retirada, data_devolucao, hora_devolucao) values (?,?,?,?,?,?,?,?);";
		
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, reserva.getCpf_passaporte());
			ps.setString(2, reserva.getVeiculo());
			ps.setInt(3, reserva.getId_loja());
			ps.setInt(4, reserva.getId_tipo());
			ps.setString(5, reserva.getDataRet());
			ps.setString(6, reserva.getHoraRetirada());
			ps.setString(7, reserva.getDataDevolucao());
			ps.setString(8, reserva.getHoraDevolucao());
			
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("ReservaDAO: " + e);
		}
		
	}
	
	
	
	

}
