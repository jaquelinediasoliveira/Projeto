package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import org.json.JSONArray;

import models.Cliente;
import models.ConsultaBD;
import models.Usuario;

public class UsuarioDAO {

	
	
	Connection conn;
	PreparedStatement ps;
	PreparedStatement ps2;
	ResultSet rs;
	ResultSet rs2;
	JSONArray ja = new JSONArray();
	
	
	
	
	/* ************************************ Consultar todos os usuários ****************************************************************** */
	
	public JSONArray consultarUsuario(String email, String senha) {
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "select * from usuarios;";
		String busca = "select c.nome_completo, c.id_cliente, c.cpf, c.passaporte, c.telefone, c.cep, c.endereco, c.data_nascimento from clientes c inner join usuarios u ON c.id_cliente = u.id_cliente where u.email = ? and u.senha = ?;";
			
		
		try {
			
			
			if(email == null || senha == null) {
				
				ps = conn.prepareStatement(sql);
				
				rs = ps.executeQuery();
				
				
				while(rs.next()) {
					
					Usuario usuario = new Usuario();
					
					usuario.setId_usuario(rs.getInt("id_usuario"));
					usuario.setId_cliente(rs.getInt("id_cliente"));
					usuario.setId_funcionario(rs.getInt("id_funcionario"));
					usuario.setEmail(rs.getString("email"));
					usuario.setSenha(rs.getString("senha"));
					usuario.setTipo(rs.getBoolean("tipo_usuario"));
					usuario.setLogOn(rs.getBoolean("logOn"));
					
					ja.put(usuario.toJSON());
					
				}
				
				
			}
			
			else {
				
				ps = conn.prepareStatement(busca);
				ps.setString(1, email);
				ps.setString(2, senha);
				
				rs = ps.executeQuery();
				
				
				
				while(rs.next()) {
					
					ConsultaBD consulta = new ConsultaBD();
					
					consulta.setId_cliente(rs.getInt("id_cliente"));
					consulta.setNome_completo(rs.getString("nome_completo"));
					consulta.setCpf(rs.getString("cpf"));
					consulta.setPassaporte(rs.getString("passaporte"));
					consulta.setTelefone(rs.getString("telefone"));
					consulta.setCep(rs.getString("cep"));
					consulta.setEndereco(rs.getString("endereco"));
					consulta.setData_nascimento(rs.getDate("data_nascimento"));
					
					ja.put(consulta.toJSON());
				}
				
				ps.close();
				
				
			}
			
			
			
		} catch (SQLException e) {
			System.out.println("(UsuarioDAO/Consultar: Erro na consulta - )" + e);
		}
		
		
		
		return ja;
		
		
	}
	
	
	
	
	
	
/* ******************************************************************** Cadastrar Usuário ********************************************************************************************** */	
	
	
	public boolean cadastrarUsuario(Usuario usuario) {
		
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "insert into usuarios (id_cliente, email, senha, tipo_usuario, logOn) values(?,?,?,?,?);";
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, usuario.getId_cliente());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getSenha());
			ps.setBoolean(4, usuario.getTipo());
			ps.setBoolean(5, usuario.getLogOn());
			
			ps.execute();
			ps.close();
			
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
			return false;
		}
		
		
		
		
	}
	
/* **************************************************** Alterar Usuário **************************************************** */
	
	public void alterarUsuario(Usuario usuario) {
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "update usuarios set id_cliente, id_funcionario, email, senha, tipo where id_usuario = ?;";
		
		int id_usuario = usuario.getId_usuario();
		int id_cliente = usuario.getId_cliente();
		int id_funcionario = usuario.getId_funcionario();
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		boolean tipo  = usuario.getTipo();
		
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id_cliente);
			ps.setInt(2, id_funcionario);
			ps.setString(3, email);
			ps.setString(4, senha);
			ps.setBoolean(5, tipo);
			ps.setInt(6, id_usuario);
			
			ps.execute();
			ps.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
/* ******************************************* Deletar Usuário ************************************************************ */	
	
	public void deletarUsuario(int id_usuario) {
		
		conn = new ConexaoBD().conectaBD();
		
		String sql = "delete * from usuarios where id_usuario = ?;";
		
		try {
			
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id_usuario);
			
			ps.execute();
			ps.close();
			
			
		} catch (SQLException e) {
			
			System.out.println("UsuarioDAO: Erro ao deletar usuário! " + e);
		}
		
		
	}
	
	
		
	
}
