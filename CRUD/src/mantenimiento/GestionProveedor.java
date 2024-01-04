package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Proveedor;
import bean.Usuario;
import conectorBD.MySQLConexion;

public class GestionProveedor {

	public Proveedor obtenerProveedor(Proveedor pro) {
		Proveedor proveedor = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT * FROM proveedor WHERE rfc = ?";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, pro.getRfc());
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 proveedor = new Proveedor(rs.getString(1), rs.getString(2), rs.getString(3));
		 }
		
		}catch (Exception e) {
		System.out.println("Error en obtener proveedor");
		}
		return proveedor;
}
	public Proveedor ProveedorRegistro(Proveedor usu) {
		Proveedor proveedor = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "INSERT INTO proveedor(rfc, nombre, direccion) VALUES (?,?,?)";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, usu.getRfc());
		 pst.setString(2, usu.getNombre());
		 pst.setString(3, usu.getDireccion());
		 
		 pst.execute();
		 
		
		}catch (Exception e) {
		System.out.println("Error en registrar proveedor");
		e.printStackTrace();
		}
		return proveedor;

	}
	public Proveedor ProveedorUpdate(Proveedor usu) {
		Proveedor proveedor = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "UPDATE proveedor SET nombre = ?, direccion = ? WHERE rfc = ?";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, usu.getNombre());
		 pst.setString(2, usu.getDireccion());
		 pst.setString(3, usu.getRfc());
		 
		 pst.execute();
		 
		
		}catch (Exception e) {
		System.out.println("Error en actualizar proveedor");
		e.printStackTrace();
		}
		return proveedor;
	}
}
