package bean;

public class Usuario {

	private Long dni;
	private String nombre;
	private String apellidos;
	private String fecha;
	private Long tfno;
	private Integer id_cliente;
	private boolean eliminado;

	public Usuario(Long dni, String nombre, String apellidos, String fecha ,Long tfno, Integer id_cliente, boolean eliminado) {

		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.tfno = tfno;
		this.fecha = fecha;
		this.id_cliente = id_cliente;
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

	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}

}
