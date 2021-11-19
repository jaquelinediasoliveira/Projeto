package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;

import models.Veiculo;
import models.VeiculoTipos;

public class VeiculoDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;

	public void cadastrarVeiculo(Veiculo veiculo) {
		
		
		
		String sql = "insert into veiculos (placa, id_tipo, marca, modelo, cor, preco, status_loc) values(?,?,?,?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1,veiculo.getPlaca());
			ps.setInt(2, veiculo.getId_tipo());
			ps.setString(3, veiculo.getMarca());
			ps.setString(4, veiculo.getModelo());
			ps.setString(5, veiculo.getCor());
			ps.setFloat(6, veiculo.getPreco());
			ps.setString(7, veiculo.getStatus_loc());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("VeiculoDAO: " + e);
		}
		
	}
	
	public JSONArray consultarVeiculos(String busca) {
		
		JSONArray ja = new JSONArray();
		
		String sqlTodos = "select * from veiculos;";
		String sqlFiltrado = "select * from veiculos where status_loc = ?;";
		String search = "select v.placa, v.marca, v.modelo, v.cor, v.preco, v.status_loc from veiculos v inner join tipos t ON v.id_tipo;";
		
	
		
		conn = new ConexaoBD().conectaBD();
		
		
		
		if(busca.equals("TODOS")) {
			
			try {
				
				
				ps = conn.prepareStatement(sqlTodos);
				
				
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					Veiculo veiculo = new Veiculo();
					//VeiculoTipos veiculoTipos = new VeiculoTipos();
					
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setId_tipo(rs.getInt("id_tipo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setPreco(rs.getFloat("preco"));
					veiculo.setStatus_loc(rs.getString("status_loc"));
					
					ja.put(veiculo.toJSON());
				}
				
				
				ps.close();
			} 
			
		
			
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		else{
			
			try {
				
				
				ps = conn.prepareStatement(sqlFiltrado);
				
				ps.setString(1, busca);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Veiculo veiculo = new Veiculo();
					
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setId_tipo(rs.getInt("id_tipo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setPreco(rs.getFloat("preco"));
					veiculo.setStatus_loc(rs.getString("status_loc"));
					
					ja.put(veiculo.toJSON());
				}
				
				ps.close();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		}
		
		
		
		
		return ja;
	}
	
	public void deletarVeiculo(String placa) {
		
		String sql = "delete from veiculos where placa = ?;";
		
		conn = new ConexaoBD().conectaBD();

		try {
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, placa);
			
			ps.execute();
			
			ps.close();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void alterarVeiculo(Veiculo veiculo) {
		
		String sql = "update veiculos set placa = ?, cor = ?, preco = ?, status_loc = ? where placa = ?;";
		
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, veiculo.getPlaca());
			ps.setString(2, veiculo.getCor());
			ps.setFloat(3, veiculo.getPreco());
			ps.setString(4, veiculo.getStatus_loc());
			ps.setString(5, veiculo.getPlaca());
			
			ps.execute();
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
