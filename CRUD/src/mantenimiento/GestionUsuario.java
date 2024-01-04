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
		 /*Long col1 = rs.getLong(1);
		 String col2 = rs.getString(2);
		 String col3 = rs.getString(3);
		 String col4 = rs.getString(4);
		 Long col5 = rs.getLong(5);*/
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6));
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
	 
	 String sql = "SELECT * FROM cliente WHERE id_clientes = ?";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setInt(1, usu.getId_cliente());
	 
	 rs = pst.executeQuery();
	 
	 while(rs.next()) {
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6));
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
public Usuario UsuarioUpdate(Usuario usu) {
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	
	try {
		
	 con = MySQLConexion.getConexion();
	 
	 String sql = "UPDATE cliente SET dni=?,nombre= ?,apellidos=?,fecha_nac=?,tfno=? WHERE id_cliente = ?";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setLong(1, usu.getDni());
	 pst.setString(2, usu.getNombre());
	 pst.setString(3, usu.getApellidos());
	 pst.setString(4, usu.getFecha());
	 pst.setLong(5, usu.getTfno());
	 pst.setLong(6, usu.getId_cliente());
	 
	 pst.execute();
	 
	
	}catch (Exception e) {
	System.out.println("Error en actualizar usuario");
	e.printStackTrace();
	}
	return usuario;
}
}
