package bean;

public class Usuario {

	private long dni;
	private String nombre;
	private String apellidos;
	private String fecha;
	private long tfno;

	public Usuario(long dni, String nombre, String apellidos, String fecha ,long tfno) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.setFecha(fecha);
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

	public long getTfno() {
		return tfno;
	}

	public void setTfno(long tfno) {
		this.tfno = tfno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
