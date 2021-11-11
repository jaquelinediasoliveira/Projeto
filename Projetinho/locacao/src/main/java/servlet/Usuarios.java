package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Usuario;

@WebServlet("/usuarios")

public class Usuarios extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		JSONArray ja = new JSONArray();
		
		PrintWriter pw = resp.getWriter();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		ja = usuarioDAO.consultarUsuario();
		
		pw.write(ja.toString());
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		
		try {
			JSONObject jo = new JSONObject(body);
			
			int id_cliente = jo.getInt("id_cliente");
			int id_funcionario = jo.getInt("id_funcionario");
			String email = jo.getString("email");
			String senha = jo.getString("senha");
			boolean tipo = jo.getBoolean("tipo_usuario");
			boolean logOn = jo.getBoolean("logOn");
			
			Usuario usuario = new Usuario();
			
			usuario.setId_cliente(id_cliente);
			usuario.setId_funcionario(id_funcionario);
			usuario.setEmail(email);
			usuario.setSenha(senha);
			usuario.setTipo(tipo);
			usuario.setLogOn(logOn);
			
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			usuarioDAO.cadastrarUsuario(usuario);
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
		
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id_usuario = Integer.parseInt(req.getParameter("id_usuario"));
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		usuarioDAO.deletarUsuario(id_usuario);
		
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("utf-8");
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			
			
			JSONObject jo = new JSONObject(body);
			
			Usuario usuario = new Usuario();
			
			usuario.setId_usuario(jo.getInt("id_usuario"));
			usuario.setId_cliente(jo.getInt("id_cliente"));
			usuario.setId_funcionario(jo.getInt("id_funcionario"));
			usuario.setEmail(jo.getString("email"));
			usuario.setSenha(jo.getString("senha"));
			usuario.setTipo(jo.getBoolean("tipo_usuario"));
			
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			
			usuarioDAO.alterarUsuario(usuario);
			
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		}
		
	}
	

}
