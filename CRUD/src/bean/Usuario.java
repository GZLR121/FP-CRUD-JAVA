package bean;

public class Usuario {

	private Long dni;
	private String nombre;
	private String apellidos;
	private String fecha;
	private Long tfno;
	private int id_cliente;

	public Usuario(Long dni, String nombre, String apellidos, String fecha ,Long tfno, int id_cliente) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tfno = tfno;
		this.fecha = fecha;
	}

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
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

	public Long getTfno() {
		return tfno;
	}

	public void setTfno(Long tfno) {
		this.tfno = tfno;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

}
