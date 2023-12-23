package conectorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
//Lo inicializamos con un valor null
		Connection con = null;
//Hare el try catch para cargar el driver y conectarme a la bd y si se conecta o no, nos de un aviso
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/crud_java";
			String usuario = "root";
			String contra = "";
			
			con = DriverManager.getConnection(url,usuario,contra);
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error al conectar a la BD");
			e.printStackTrace();
		}	
		return con;
	}
}
