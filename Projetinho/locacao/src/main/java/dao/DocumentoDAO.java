package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import models.Documentos;

public class DocumentoDAO {
	
	Connection conn;
	PreparedStatement ps;
	
	
	public void cadastrarDocumento(Documentos documento) {
		
		String sql = "insert into documentos (id_documento, cnh, rg, passaporte) values (?,?,?,?);";
		
		conn = new ConexaoBD().conectaBD();
		
		try {
			
			ps = conn.prepareStatement(sql);
			
			if(documento.getPassaporte() == null) {
				ps.setInt(1, documento.getId_documento());
				ps.setString(2, documento.getCnh());
				ps.setString(3, documento.getRg());
			}
			
			else if(documento.getPassaporte() == null && documento.getRg() == null) {
				ps.setInt(1, documento.getId_documento());
				ps.setString(2, documento.getCnh());
			}
			
			else if(documento.getPassaporte() == null && documento.getCnh() == null) {
				ps.setInt(1, documento.getId_documento());
				ps.setString(3, documento.getRg());
			}
			
			else if(documento.getRg() == null && documento.getCnh() == null) {
				ps.setInt(1, documento.getId_documento());
				ps.setString(4, documento.getPassaporte());
			}
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e) {
			System.out.println("DocumentoDAO: " + e);
		}
	}
	
	
	
	

}
