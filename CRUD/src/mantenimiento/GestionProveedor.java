package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import bean.Proveedor;
import conectorBD.MySQLConexion;

public class GestionProveedor {

	public Proveedor obtenerProveedor(Proveedor pro) {
		Proveedor proveedor = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT * FROM proveedor WHERE rfc = ? and eliminado = 0";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, pro.getRfc());
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 proveedor = new Proveedor(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4));
		 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return proveedor;
}
	public Proveedor ProveedorInsert(Proveedor pro) {
		Proveedor proveedor = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "INSERT INTO proveedor(rfc, nombre, direccion) VALUES (?,?,?)";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, pro.getRfc());
		 pst.setString(2, pro.getNombre());
		 pst.setString(3, pro.getDireccion());
		 
		 pst.execute();
		 JOptionPane.showMessageDialog(null, "Proveedor registrado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al registrar al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
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
		 JOptionPane.showMessageDialog(null, "Proveedor actualizado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		}
		return proveedor;
	}
		
		public Proveedor ProveedorDelete(Proveedor pro) {
			Proveedor proveedor = null;
			
			Connection con = null;
			PreparedStatement pst = null;
			
			try {
				
			 con = MySQLConexion.getConexion();
			 
			 String sql = "UPDATE proveedor SET eliminado = 1 WHERE rfc = ?";
			 
			 
			 pst = con.prepareStatement(sql);
			 pst.setString(1, pro.getRfc());
			 
			 pst.execute();
			 JOptionPane.showMessageDialog(null, "Proveedor eliminado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al eliminar al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			}
			return proveedor;
		
		}
		public boolean provRFCExiste(String rfc) {
			boolean existe = false;
			
			try {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
					
			 con = MySQLConexion.getConexion();
			 
			 String sql = "SELECT * FROM proveedor WHERE rfc = ?";
			 
			 pst = con.prepareStatement(sql);
			 
			 pst.setString(1, rfc);
			 
			 rs = pst.executeQuery();
			 
			 while(rs.next()) {
				 existe = true;
			 }
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al obtener al proveedor", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			}
			
			return existe;

		}
}
