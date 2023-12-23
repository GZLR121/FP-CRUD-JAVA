package bean;

public class Usuario {

	private long dni;
	private String nombre;
	private String apellidos;
	private int tfno;

	public Usuario(long dni, String nombre, String apellidos, int tfno) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tfno = tfno;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getTfno() {
		return tfno;
	}

	public void setTfno(int tfno) {
		this.tfno = tfno;
	}

}
