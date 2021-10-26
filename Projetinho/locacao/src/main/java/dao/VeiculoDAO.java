package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Veiculo;

public class VeiculoDAO {
	
	Connection conn;
	PreparedStatement ps;
	

	public void cadastrarVeiculo(Veiculo veiculo) {
		
		
		
		String sql = "insert into veiculo (id_veiculo, marca, modelo, cor, placa, tipo_loc) values(?,?,?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, veiculo.getId_veiculo());
			ps.setString(2, veiculo.getMarca());
			ps.setString(3, veiculo.getModelo());
			ps.setString(4, veiculo.getCor());
			ps.setString(5, veiculo.getPlaca());
			ps.setString(6, veiculo.getTipo_loc());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("VeiculoDAO: " + e);
		}
		
		
		
		
		
	}
	

}
