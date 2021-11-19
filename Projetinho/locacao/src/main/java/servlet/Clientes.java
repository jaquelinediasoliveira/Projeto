package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.ClienteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Cliente;
import models.Usuario;

@WebServlet("/clientes")
public class Clientes extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();

		ClienteDAO clientedao = new ClienteDAO();

		String cpf = req.getParameter("cpf");
		String passaporte = req.getParameter("passaporte");

		try {

			if (cpf != null) {

				JSONArray ja = clientedao.consulClienteCPF(cpf);

				pw.write(ja.toString());

			} else if (passaporte != null) {

				JSONArray ja = clientedao.consulClientePassaporte(passaporte);

				pw.write(ja.toString());

			}else {
				JSONArray ja = clientedao.consulClienteCPF(null);

				pw.write(ja.toString());
			}

		} catch (ParseException e) {
			pw.write(e.toString());
			e.printStackTrace();
		}

	}

	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		resp.setContentType("application/json"); 
		resp.setCharacterEncoding("utf-8");
	 
	
	 	//A vaiável body recebe o corpo da requisição 
	 	String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
	
	  
	  try {
	 
	 //a variável body é formatada no formato JSON 
		  JSONObject data = new JSONObject(body);
	 
	 
	 //Cada atributo do objeto JSON é pego e armazenado em uma variável correspondente ao seu conteúdo 
		  String cpf = data.getString("cpf");
		  String passaporte = data.getString("passaporte");
		  String nome_completo = data.getString("nome_completo"); 
		  String cep = data.getString("cep"); 
		  String data_nascimento = data.getString("data_nascimento"); 
		  String telefone = data.getString("telefone"); 
		  String endereco = data.getString("endereco");
		  
	//Atributos do objeto usuário
		  //int id_funcionario = data.getInt("id_funcionario");
		  String email = data.getString("email");
		  String senha = data.getString("senha");
		  boolean tipo_usuario = data.getBoolean("tipo_usuario");
		  boolean logOn = data.getBoolean("logOn");
		  
	
	 
	 //É criado um objeto do tipo cliente a partir das variáveis que receberam os parâmetros da requisição 
		  Cliente cliente = new Cliente();
		  cliente.setCpf(cpf);
		  cliente.setPassaporte(passaporte);
		  cliente.setNome_completo(nome_completo);
		  cliente.setCep(cep);
		  
		  try{
			  cliente.setDataNascimento(data_nascimento);
		  } catch (ParseException e){
			  e.printStackTrace();
		  } cliente.setTelefone(telefone);
		  
		  cliente.setEndereco(endereco);
		  
	 
		  ClienteDAO clienteDAO = new ClienteDAO();
		  
		  Usuario usuario = new Usuario();
		  
		  //usuario.setId_funcionario(id_funcionario);
		  usuario.setEmail(email);
		  usuario.setSenha(senha);
		  usuario.setTipo(tipo_usuario);
		  usuario.setLogOn(logOn);
		  
		  
		  boolean b =  clienteDAO.cadastrarCliente(cliente,usuario);
		  
		  
	  		if(b == true) {
	  			
	  			
	  			try {
	  				
	  				JSONArray ja;
	  				
					ja = clienteDAO.consulClienteCPF(cpf);
					
					PrintWriter imprimir = resp.getWriter();
		  			 
		  	        imprimir.println(ja.get(0));
		  	        
		  	        
					
				} catch (ParseException e) {
				
					e.printStackTrace();
				}
	  			
	  			
	  			
	  			
	  		}
	  		
	  		else {
	  			
	  			JSONObject jo = new JSONObject();
	  			
	  			jo.put("id_cliente", 0);
  				
				PrintWriter imprimir = resp.getWriter();
	  			 
	  	        imprimir.println(jo.toString());
	  	        
	  		}
	 
		  //clienteDAO.cadastrarCliente(cliente,usuario);
	 
	  		} catch (JSONException e) {
	  			e.printStackTrace(); 
	  		}
	  
	  		
	  
	  
	 }

	 @Override protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		 String cpf = req.getParameter("cpf");
		 String passaporte = req.getParameter("passaporte");
		 ClienteDAO clienteDAO = new ClienteDAO();
		 
		 if(cpf != null) {
			  
			 clienteDAO.deletarClienteCPF(cpf);
		 }
	 
		 else if(passaporte != null) {
			 
			 clienteDAO.deletarClientePassaporte(passaporte);
			 
		 }
	  
	 }

	 @Override protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  
		 resp.setContentType("application/json"); 
		 resp.setCharacterEncoding("utf-8");
	 
		 //A vaiável body recebe o corpo da requisição 
		 String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		 try {
	 
			 JSONObject jo = new JSONObject(body);
			 
			 //Variáveis de controle 
			 String cpf = jo.getString("cpf");
			 String passaporte = jo.getString("passaporte");
			 
	 
			 String nome_completo = jo.getString("nome_completo"); 
			 String cep = jo.getString("cep"); 
			 String data_nascimento = jo.getString("data_nascimento"); 
			 String telefone = jo.getString("telefone");
			 String endereco = jo.getString("endereco");
	 
	 
			 Cliente cliente = new Cliente();
			
			 cliente.setCpf(cpf);
			 cliente.setPassaporte(passaporte);
			 cliente.setNome_completo(nome_completo); cliente.setCep(cep);
			 try{
				 
				 cliente.setDataNascimento(data_nascimento);
				 
			} catch (ParseException e){
				
				e.printStackTrace();
				
			}
			 cliente.setTelefone(telefone);
			 cliente.setEndereco(endereco);
			 
			 ClienteDAO clienteDAO = new ClienteDAO();
			 
			 if(cpf != null) {
				 
				 clienteDAO.alterarClienteCPF(cliente);
				 
			 }
			 
			 else if(passaporte != null) {
				 clienteDAO.alterarClientePassaporte(cliente);
			 }
	  
	  } catch (JSONException e) {
	  
		  System.out.println("Erro na alteração: " + e); }
	 
	 }
	 
	 
}
