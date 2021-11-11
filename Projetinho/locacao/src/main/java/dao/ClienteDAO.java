package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.Cliente;
import models.Usuario;

public class ClienteDAO {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	JSONArray ja = new JSONArray();
	
	public void cadastrarCliente(Cliente cliente, Usuario usuario) {
		String sql = "insert into clientes (cpf, passaporte, nome_completo, cep, data_nascimento, telefone, endereco) values (?,?,?,?,?,?,?)"
				+ " ON DUPLICATE KEY UPDATE nome_completo = ?, cep = ?, data_nascimento = ?, telefone = ?, endereco = ?;";
		
		String cpf = cliente.getCpf();
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCpf());
			ps.setString(2, cliente.getPassaporte());
			ps.setString(3, cliente.getNome_completo());
			ps.setString(4, cliente.getCep());
			ps.setString(5, cliente.getDataNascimentoC());
			ps.setString(6, cliente.getTelefone());
			ps.setString(7, cliente.getEndereco());
			ps.setString(8, cliente.getNome_completo());
			ps.setString(9, cliente.getCep());
			ps.setString(10, cliente.getDataNascimentoC());
			ps.setString(11, cliente.getTelefone());
			ps.setString(12, cliente.getEndereco());
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException e) {
			System.out.println("ClienteDAO(Cadastrar): " + e);
		}
		
		int id_cliente;
		
		try {
			
			ja = consulClienteCPF(cpf);
			
			JSONObject jo = new JSONObject();
			
			try {
				
				jo = (JSONObject) ja.get(0);
				
				id_cliente = jo.getInt("id_cliente");
				
				usuario.setId_cliente(id_cliente);
				
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				//usuarioDAO.deletarUsuarioIDCLIENTE(id_cliente);
				usuarioDAO.cadastrarUsuario(usuario);
				
			} catch (JSONException e) {
				
				
				
				e.printStackTrace();
			}
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
/* ***************************************************************** Métodos de consulta ****************************************************************************************** */	
	
	
/* ******************************************************************* Consulta por CPF ******************************************************************************************* */	
	 
	
	public JSONArray consulClienteCPF(String cpf) throws ParseException {
		
		String sql = "select * from clientes;";
		String query = "select * from clientes where cpf = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		
		if(cpf != null) {
			
			
			try {
				
				ps = conn.prepareStatement(query);
				
				ps.setString(1, cpf);
				
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					Cliente cliente = new Cliente();
					
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setPassaporte(rs.getString("passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
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
					
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setPassaporte(rs.getString("passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
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
/* ***************************************************************************************************************************************************************************** */	
	
/* *************************************************************************** Consulta por passaporte ************************************************************************* */	
	public JSONArray consulClientePassaporte(String passaporte) throws ParseException {
		
		conn = new ConexaoBD().conectaBD();
		
		JSONArray ja = new JSONArray();
		
		String sql = "select * from clientes;";
		String query = "select * from clientes where passaporte = ?;";
		
		
		if(passaporte != null ) {
			
			try {
				
				ps = conn.prepareStatement(query);
				
				ps.setString(1, passaporte);
				
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					Cliente cliente = new Cliente();
					
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setPassaporte(rs.getString("passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					
					ja.put(cliente.toJSON());
				}
				
				
				ps.close();
				
			} catch (SQLException e) {
				System.out.println("Erro na pesquisa por passaporte: " + e);
			}
			
			
		}
		else {
			
			try {
				
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					Cliente cliente = new Cliente();
					
					cliente.setId_cliente(rs.getInt("id_cliente"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setPassaporte(rs.getString("passaporte"));
					cliente.setNome_completo(rs.getString("nome_completo"));
					cliente.setCep(rs.getString("cep"));
					cliente.setDataNascimento(rs.getString("data_nascimento"));
					cliente.setTelefone(rs.getString("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					
					ja.put(cliente.toJSON());
				}
				
				
				ps.close();
				
			} catch (SQLException e) {
				System.out.println("Erro na pesquisa por passaporte: " + e);
			}
			
			
		}
		
		return ja;
		
	}
/* ************************************************************************************************************************************************************************** */	
	
/* ************************************************************* Métodos de alteração *************************************************************************************** */
	
/* **************************************************************** Alterar por CPF ***************************************************************************************** */	
	
	
	public void alterarClienteCPF(Cliente cliente) {
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "update clientes set nome_completo = ?, cep = ?, data_nascimento = ?, telefone = ?, endereco = ? where cpf = ?";
		
		try {
			
			
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, cliente.getNome_completo());
			ps.setString(2, cliente.getCep());
			ps.setString(3, cliente.getDataNascimentoC());
			ps.setString(4, cliente.getTelefone());
			ps.setString(5, cliente.getEndereco());
			
			ps.setString(6, cliente.getCpf());
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			System.out.println("(ClienteDAO) Erro na alteração por CPF: " + e);	
			
		}
	}
/* ************************************************************************************************************************************************************************** */	
	
/* ********************************************************************* Alterar por Passaporte ***************************************************************************** */	

	public void alterarClientePassaporte(Cliente cliente) {
			
			conn = new ConexaoBD().conectaBD();
			
			String sql = "update clientes set nome_completo = ?, cep = ?, data_nascimento = ?, telefone = ?, endereco = ? where passaporte = ?";
			
			try {
				
				
				ps = conn.prepareStatement(sql);
				
				ps.setString(1, cliente.getNome_completo());
				ps.setString(2, cliente.getCep());
				ps.setString(3, cliente.getDataNascimentoC());
				ps.setString(4, cliente.getTelefone());
				ps.setString(5, cliente.getEndereco());
				
				ps.setString(6, cliente.getPassaporte());
				
				ps.execute();
				ps.close();
				
			} catch (SQLException e) {
				
				System.out.println("(ClienteDAO) Erro na alteração por Passaporte: " + e);	
				
			}
		}
	
/* ***************************************************************************************************************************************************************************** */	
	
/* *********************************************************************** Métodos para deletar ******************************************************************************** */
	
/* **************************************************************************** Deletar por CPF ******************************************************************************** */
	
	
	public void deletarClienteCPF(String cpf) {
		
		String sql = "delete from clientes where cpf = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, cpf);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("(ClienteDAO) Erro ao excluir: " + e);
		}
		
		
	}
	
/* ***************************************************************************************************************************************************************************** */
	
/* **************************************************************************** Deletar por Passaporte ******************************************************************************** */
	
	
	public void deletarClientePassaporte(String passaporte) {
		
		String sql = "delete from clientes where passaporte = ?;";
		
		conn = new ConexaoBD().conectaBD();
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, passaporte);
			
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			System.out.println("(ClienteDAO) Erro ao excluir: " + e);
		}
		
		
	}
	
/* ***************************************************************************************************************************************************************************** */
	

}
