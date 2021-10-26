package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Filiais;

public class FiliaisDAO {

	
	Connection conn;
	PreparedStatement ps;
	
	
	
	public void cadastrarFiliais(Filiais filial) {
		
		String sql = "insert into filiais (id_loja, endereco) values(?,?);";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, filial.getId_loja());
			ps.setString(2, filial.getEnder_loja());
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException e) {
			System.out.println("Filiais: " + e);
		}
		
		
	}
	
	
	
	
	
	
	
}
