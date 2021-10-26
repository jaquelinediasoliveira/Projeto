package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import org.json.JSONArray;

import models.Cliente;

public class ClienteDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	JSONArray ja = new JSONArray();
	
	public void cadastrarCliente(Cliente cliente) {
		String sql = "insert into clientes (cpf_passaporte, nome_completo, cep, email, senha, data_nascimento, telefone, endereco) values (?,?,?,?,?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpf_passaporte());
			ps.setString(2, cliente.getNome_completo());
			ps.setString(3, cliente.getCep());
			ps.setString(4, cliente.getEmail());
			ps.setString(5, cliente.getSenha());
			ps.setString(6, cliente.getDataNascimentoC());
			ps.setString(7, cliente.getTelefone());
			ps.setString(8, cliente.getEndereco());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			System.out.println("ClienteDAO(Cadastrar): " + e);
		}
	}
	
	
	public JSONArray consultarCliente(String cpf_passaporte) throws ParseException {
		
		String sql = "select * from clientes;";
		String query = "select * from clientes where cpf_passaporte = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		
		if(cpf_passaporte != null) {
			
			
			try {
				
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cpf_passaporte);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Cliente cliente = new Cliente();
					
					cliente.setCpf_passaporte(rs.getString("cpf_passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					
					ja.put(cliente.toJSON());
					
					
				}
				
				ps.close();
				
				
			} catch (SQLException e) {
				System.out.println("(ClienteDAO) Erro na pesquisa por CPF/Passaporte: " + e);
			}
			
			
		}
		
		
		else {
			
			try {
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Cliente cliente  = new Cliente();
					
					cliente.setCpf_passaporte(rs.getString("cpf_passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
					cliente.setEmail(rs.getString("email"));
					cliente.setSenha(rs.getString("senha"));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					
					ja.put(cliente.toJSON());
				}
				
				ps.close();
				
			} catch (SQLException e) {
				System.out.println("ClienteDAO(Consultar): " + e);
			}
			
			
		}
		
		return ja;	
	}
	
	public void alterarCliente(Cliente cliente) {
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "update clientes set nome_completo = ?, cep = ?, email = ?, senha = ?, data_nascimento = ?, telefone = ?, endereco = ? where cpf_passaporte = ?";
		
		try {
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome_completo());
			ps.setString(2, cliente.getCep());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getSenha());
			ps.setString(5, cliente.getDataNascimentoC());
			ps.setString(6, cliente.getTelefone());
			ps.setString(7, cliente.getEndereco());
			ps.setString(8, cliente.getCpf_passaporte());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("(ClienteDAO) Erro na alteração: " + e);
			
			
			
		}
	}
	
	
	public void deletarCliente(String cpf_passaporte) {
		
		String sql = "delete from clientes where cpf_passaporte = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpf_passaporte);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("(ClienteDAO) Erro ao excluir: " + e);
		}
		
		
	}
	

}
