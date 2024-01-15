package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

import javax.swing.JOptionPane;

import bean.Ventas;
import conectorBD.MySQLConexion;

public class GestionVentas {
	
	public Ventas Compra (Ventas game) {
		Ventas venta = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "INSERT INTO ventas(id_cliente, codigo) VALUES (?,?)";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setInt(1, game.getId_cliente());
		 pst.setInt(2, game.getCodigo());
		 
		 pst.execute();
		 System.out.println("Compra existosa");
		 JOptionPane.showMessageDialog(null, "Compra existosa", "Sucess", JOptionPane.INFORMATION_MESSAGE);
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en la compra", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		}
		return venta;
}
	public boolean VentaExiste(Integer Id, Integer cod) {
		boolean existe = false;
		
		try {
			Connection con = null;
			PreparedStatement pst = null;
			ResultSet rs = null;
				
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT * FROM ventas WHERE id_cliente = ? AND codigo = ?";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setInt(1, Id);
		 pst.setInt(2, cod);
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 existe = true;
		 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener la venta", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		}
		
		return existe;
	}
	/*public List<Ventas> getVentas() {
		List<Ventas> ventas_lista = new ArrayList<>();
		Ventas ventas = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT codigo FROM producto WHERE id_cliente = ";
		 
		 pst = con.prepareStatement(sql);
		  
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 ventas = new Ventas();

			 ventas.setCodigo(null);

			 ventas_lista.add(ventas);
		 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de los juegos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return ventas_lista;
}*/
}
