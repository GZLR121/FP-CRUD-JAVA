package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Usuario;
import conectorBD.MySQLConexion;

public class GestionUsuario {

	
public Usuario obtenerUsuario(Usuario usu) {
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		
	 con = MySQLConexion.getConexion();
	 
	 String sql = "SELECT * FROM cliente WHERE dni = ? and tfno = ?";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setLong(1, usu.getDni());
	 pst.setInt(2, usu.getTfno());
	 
	 rs = pst.executeQuery();
	 
	 while(rs.next()) {
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	 }
	
	}catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	return usuario;
	
}

}
