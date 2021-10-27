package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Veiculo;

public class VeiculoDAO {
	
	Connection conn;
	PreparedStatement ps;
	

	public void cadastrarVeiculo(Veiculo veiculo) {
		
		
		
		String sql = "insert into veiculo (placa, id_tipo, marca, modelo, cor, preco, status_loc) values(?,?,?,?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,veiculo.getPlaca());
			ps.setInt(2, veiculo.getId_tipo());
			ps.setString(3, veiculo.getMarca());
			ps.setString(4, veiculo.getModelo());
			ps.setString(5, veiculo.getCor());
			ps.setFloat(6, veiculo.getPreco());
			ps.setBoolean(7, veiculo.getStatus_loc());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("VeiculoDAO: " + e);
		}
		
	}
	
	
	
	

}
