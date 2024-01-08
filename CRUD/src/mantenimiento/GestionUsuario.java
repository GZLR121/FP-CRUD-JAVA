package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

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
		 /*
		 Long col_DNI = rs.getLong(1);
		 String col_Name = rs.getString(2);
		 String col_App = rs.getString(3);
		 String col_Fecha = rs.getString(4);
		 Long col_Tel = rs.getLong(5);
		 Integer col_Id = rs.getInt(6);
		 */
		 usuario = new Usuario(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getLong(5), rs.getInt(6));
	 }
	
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al obtener al usuario", "Error", JOptionPane.ERROR_MESSAGE);
	}
	return usuario;
	
}

public boolean usuarioDNIExiste(Long dni) {
	boolean existe = false;
	
	try {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
			
	 con = MySQLConexion.getConexion();
	 
	 String sql = "SELECT * FROM cliente WHERE dni = ?";
	 
	 pst = con.prepareStatement(sql);
	 
	 pst.setLong(1, dni);
	 
	 rs = pst.executeQuery();
	 
	 while(rs.next()) {
		 existe = true;
	 }
	
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al obtener al usuario", "Error", JOptionPane.ERROR_MESSAGE);
	e.printStackTrace();
	}
	
	return existe;
	
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
	 
	 JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al registrar al usuario", "Error", JOptionPane.ERROR_MESSAGE);
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
	 pst.setInt(6, usu.getId_cliente());
	 
	 pst.execute();
	 
	 JOptionPane.showMessageDialog(null, "Usuario actualizado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al actualizar al usuario", "Error", JOptionPane.ERROR_MESSAGE);
	e.printStackTrace();
	}
	return usuario;
}
public Usuario UsuarioDelete(Usuario usu) {
	Usuario usuario = null;
	
	Connection con = null;
	PreparedStatement pst = null;
	
	try {
		
	 con = MySQLConexion.getConexion();
	 
	 String sql = "DELETE FROM cliente WHERE id_cliente = ?";
	 
	 pst = con.prepareStatement(sql);
	 pst.setInt(1, usu.getId_cliente());
	 
	 pst.execute();
	 JOptionPane.showMessageDialog(null, "Usuario eliminado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
	 System.exit(0);
		
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Error al eliminar al usuario", "Error", JOptionPane.ERROR_MESSAGE);
	e.printStackTrace();
	}
	return usuario;

}
}
