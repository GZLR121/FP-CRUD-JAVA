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
	 pst.setLong(2, usu.getTfno());
	 
	 rs = pst.executeQuery();
	 
	 while(rs.next()) {
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));
	 }
	
	}catch (Exception e) {
	System.out.println("Error en obtener usuario");
	}
	return usuario;
	
}
public Usuario obtenerUsuarioRegistroBusqueda(Usuario usu) {
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		
	 con = MySQLConexion.getConexion();
	 
	 String sql = "SELECT * FROM cliente WHERE dni = ?";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setLong(1, usu.getDni());
	 
	 rs = pst.executeQuery();
	 
	 while(rs.next()) {
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5));
	 }
	
	}catch (Exception e) {
	System.out.println("Error en obtener usuario");
	e.printStackTrace();
	}
	return usuario;
	
}

public Usuario UsuarioRegistro(Usuario usu) {
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try {
		
	 con = MySQLConexion.getConexion();
	 
	 String sql = "INSERT INTO cliente(dni, nombre, apellidos, fecha_nac, tfno) VALUES (?,?,?,?,?)";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setLong(1, usu.getDni());
	 pst.setString(2, usu.getNombre());
	 pst.setString(3, usu.getApellidos());
	 pst.setString(4, usu.getFecha());
	 pst.setLong(5, usu.getTfno());
	 
	 pst.execute();
	 
	
	}catch (Exception e) {
	System.out.println("Error en registrar usuario");
	e.printStackTrace();
	}
	return usuario;
	
}
}
