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


@WebServlet("/locar")
public class Locacao extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		ClienteDAO clientedao = new ClienteDAO();
		
		String cpf_passaporte = req.getParameter("cpf_passaporte");
		
		try {
			JSONArray ja = clientedao.consultarCliente(cpf_passaporte);
			
			pw.write(ja.toString());
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
			String cpf_passsaporte = data.getString("cpf_passaporte");
			String nome_completo = data.getString("nome_completo");
			String cep = data.getString("cep");
			String email = data.getString("email");
			String senha = data.getString("senha");
			String data_nascimento = data.getString("data_nascimento");
			String telefone = data.getString("telefone");
			String endereco = data.getString("endereco");
			
			
			//É criado um objeto do tipo cliente a partir das variáveis que receberam os parâmetros da requisição
			Cliente cliente = new Cliente();
			cliente.setCpf_passaporte(cpf_passsaporte);
			cliente.setNome_completo(nome_completo);
			cliente.setCep(cep);
			cliente.setEmail(email);
			cliente.setSenha(senha);
			try {cliente.setDataNascimento(data_nascimento);} catch (ParseException e) {e.printStackTrace();}
			cliente.setTelefone(telefone);
			cliente.setEndereco(endereco);
			
			ClienteDAO clienteDAO = new ClienteDAO();
			
			clienteDAO.cadastrarCliente(cliente);
	
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	
		String cpf_passaporte = req.getParameter("cpf_passaporte");
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.deletarCliente(cpf_passaporte);
		
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		//A vaiável body recebe o corpo da requisição
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		
		try {
			
			JSONObject jo = new JSONObject(body);
			
			String cpf_passaporte = jo.getString("cpf_passaporte");
			String nome_completo = jo.getString("nome_completo");
			String cep = jo.getString("cep");
			String email = jo.getString("email");
			String senha = jo.getString("senha");
			String data_nascimento = jo.getString("data_nascimento");
			String telefone = jo.getString("telefone");
			String endereco = jo.getString("endereco");
			
			
			Cliente cliente = new Cliente();
			
			cliente.setCpf_passaporte(cpf_passaporte);
			cliente.setNome_completo(nome_completo);
			cliente.setCep(cep);
			cliente.setEmail(email);
			cliente.setSenha(senha);
			try {cliente.setDataNascimento(data_nascimento);} catch (ParseException e) {e.printStackTrace();}
			cliente.setTelefone(telefone);
			cliente.setEndereco(endereco);
			
			
			ClienteDAO clienteDAO = new ClienteDAO();
			
			clienteDAO.alterarCliente(cliente);
			
		} catch (JSONException e) {
			
			System.out.println("Erro na alteração: " + e);
		}
		
		
	}
}


