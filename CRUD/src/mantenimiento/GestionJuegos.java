package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bean.Juegos;
import conectorBD.MySQLConexion;

public class GestionJuegos {
	
	public Juegos obtenerJuego(Juegos game) {
		Juegos juego = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT * FROM producto WHERE nombre = ?;";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, game.getNombre());
		 
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 juego = new Juegos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getBoolean(5));	 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener el juego", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return juego;
}
	public List<Juegos> getJuegos() {
		List<Juegos> juegos_lista = new ArrayList<>();
		Juegos juegos = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "SELECT nombre FROM producto WHERE eliminado = 0";
		 
		 pst = con.prepareStatement(sql);
		  
		 rs = pst.executeQuery();
		 
		 while(rs.next()) {
			 juegos = new Juegos();

			 juegos.setNombre(rs.getString(1));

			 juegos_lista.add(juegos);
		 }
		
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al obtener nombres de los juegos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		return juegos_lista;
		
	}
		
		
	public Juegos JuegosInsert(Juegos game) {
		Juegos juego = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "INSERT INTO producto(codigo, nombre, precio, rfc) VALUES (?,?,?,?)";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setInt(1, game.getCodigo());
		 pst.setString(2, game.getNombre());
		 pst.setInt(3, game.getPrecio());
		 pst.setString(4, game.getRFC());
		 
		 pst.execute();
		 JOptionPane.showMessageDialog(null, "Juego registrado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al registrar el juego", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		}
		return juego;


	}
	public Juegos JuegosUpdate(Juegos game) {
		Juegos juego = null;
		
		Connection con = null;
		PreparedStatement pst = null;
		
		try {
			
		 con = MySQLConexion.getConexion();
		 
		 String sql = "UPDATE producto SET nombre = ?, precio = ?, rfc = ? WHERE codigo = ?";
		 
		 pst = con.prepareStatement(sql);
		 
		 pst.setString(1, game.getNombre());
		 pst.setInt(2, game.getPrecio());
		 pst.setString(3, game.getRFC());
		 pst.setInt(4, game.getCodigo());
		 
		 pst.execute();
		 JOptionPane.showMessageDialog(null, "Juego actualizado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al actualizar el juego", "Error", JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
		}
		return juego;
	}
		
		public Juegos JuegosDelete(Juegos game) {
			Juegos juego = null;
			
			Connection con = null;
			PreparedStatement pst = null;
			
			try {
				
			 con = MySQLConexion.getConexion();
			 
			 String sql = "UPDATE producto SET eliminado = 1 WHERE codigo = ?";
			 
			 pst = con.prepareStatement(sql);

			 pst.setInt(1, game.getCodigo());
			 
			 pst.execute();
			 JOptionPane.showMessageDialog(null, "Juego eliminado exitosamente", "Sucess", JOptionPane.INFORMATION_MESSAGE);
				
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al eliminar el juego", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			}
			return juego;
	}
		public boolean CodigoExiste(Integer cod) {
			boolean existe = false;
			
			try {
				Connection con = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
					
			 con = MySQLConexion.getConexion();
			 
			 String sql = "SELECT * FROM producto WHERE codigo = ?";
			 
			 pst = con.prepareStatement(sql);
			 
			 pst.setInt(1, cod);
			 
			 rs = pst.executeQuery();
			 
			 while(rs.next()) {
				 existe = true;
			 }
			
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error al obtener el codigo del juego", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			}
			
			return existe;
		}
}