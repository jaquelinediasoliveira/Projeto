package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.ReservaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Reserva;


@WebServlet("/reservas")

public class Reservas extends HttpServlet{
	

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		JSONArray ja = new JSONArray();
		
		PrintWriter pw = resp.getWriter();
		
		ReservaDAO reservaDAO = new ReservaDAO();
		
		String id_cliente = req.getParameter("id_cliente");
	
	
		
		try {
			
			ja = reservaDAO.consultarReserva(id_cliente);
			
			
			pw.write(ja.toString());
			
			
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		
		try {
			
			JSONObject jo = new JSONObject(body);
			SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			
			Reserva reserva = new Reserva();
			
			int id_cliente = jo.getInt("id_cliente");
			String veiculo = jo.getString("veiculo");
			int id_loja = jo.getInt("id_loja");
			int id_tipo = jo.getInt("id_tipo");
			String data_retirada = jo.getString("data_retirada");
			String data_devolucao_esperada = jo.getString("data_devolucao_esperada");
			
			reserva.setId_cliente(id_cliente);
			reserva.setVeiculo(veiculo);
			reserva.setId_loja(id_loja);
			reserva.setId_tipo(id_tipo);
			
			try {
				reserva.setData_retirada(d.parse(data_retirada));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			
			if(!jo.getString("data_devolucao_esperada").equals("")) {
				
				try {	reserva.setData_devolucao_esperada(d.parse(data_devolucao_esperada));	} catch (ParseException e) {	e.printStackTrace();	}
			}
			
			ReservaDAO reservaDAO = new ReservaDAO();
			
			boolean b = reservaDAO.cadastrarReserva(reserva);
			
			
			
			JSONArray ja = new JSONArray();
			
				
			try {
				
				
				if(b == true) {
					
					ja = reservaDAO.consultarReserva(String.valueOf(reserva.getId_cliente()));
					
					PrintWriter imprimir = resp.getWriter();
		  			 
		  	        imprimir.println(ja.get(0));
				}
			
				else {
					PrintWriter imprimir = resp.getWriter();
		  			 
		  	        imprimir.println("Ve�culo n�o dispon�vel");
				}
				
				
				
				
			} catch (ParseException e) {
				
				
				e.printStackTrace();
			}
			
			
			
		} catch (JSONException e) {
		
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("application/json");
		
		SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String body = req.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
		
		
		try {
			
			
			
			
			JSONObject jo = new JSONObject(body);
			
			int id_reserva = jo.getInt("id_reserva");
			String data_devolucao_final = jo.getString("data_devolucao_final");
			
			
			Reserva reserva = new Reserva();
			
			reserva.setId_reserva(id_reserva);
			try {	reserva.setData_devolucao_final(d.parse(data_devolucao_final));	} catch (ParseException e) {	e.printStackTrace();	}
			
			
			ReservaDAO reservaDAO = new ReservaDAO();
			
			reservaDAO.atualizarReserva(reserva);
			
		} catch (JSONException e) {

			System.out.println("Erro na convers�o do JSON: " + e);
		}
		
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int id_reserva = Integer.parseInt(req.getParameter("id_reserva"));
		
		
		ReservaDAO reservaDAO = new ReservaDAO();
		
		reservaDAO.deletarReserva(id_reserva);
	}

}
























