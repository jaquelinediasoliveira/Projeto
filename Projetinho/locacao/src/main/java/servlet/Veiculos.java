package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.VeiculoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Veiculo;



@WebServlet("/veiculos")

public class Veiculos extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		
		String busca = req.getParameter("busca");
		
		JSONArray ja = new JSONArray();
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		ja = veiculoDAO.consultarVeiculos(busca);
		
		
		pw.write(ja.toString());
		
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			
			
			JSONObject jo = new JSONObject(body);
			
			
			Veiculo veiculo = new Veiculo();
			
			veiculo.setPlaca(jo.getString("placa"));
			veiculo.setId_tipo(jo.getInt("id_tipo"));
			veiculo.setMarca(jo.getString("marca"));
			veiculo.setModelo(jo.getString("modelo"));
			veiculo.setCor(jo.getString("cor"));
			veiculo.setPreco(Float.parseFloat(jo.getString("preco")));
			veiculo.setStatus_loc(jo.getString("status_loc"));
			veiculo.setImagem(jo.getString("imagem"));
			
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			
			veiculoDAO.cadastrarVeiculo(veiculo);
			
			
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String placa = req.getParameter("placa");
		
		VeiculoDAO veiculoDAO = new VeiculoDAO();
		
		veiculoDAO.deletarVeiculo(placa);
		
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		try {
			
			
			JSONObject jo = new JSONObject(body);
			
			Veiculo veiculo = new Veiculo();
			VeiculoDAO veiculoDAO = new VeiculoDAO();
			
			veiculo.setPlaca(jo.getString("placa"));
			veiculo.setCor(jo.getString("cor"));
			veiculo.setPreco(Float.parseFloat(jo.getString("preco")));
			veiculo.setStatus_loc(jo.getString("status_loc"));
			veiculo.setImagem(jo.getString("imagem"));
			
			veiculoDAO.alterarVeiculo(veiculo);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		

		
		
		
	}
}























