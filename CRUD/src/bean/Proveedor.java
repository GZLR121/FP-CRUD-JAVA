package bean;

public class Proveedor {
	private String rfc;
	private String nombre;
	private String direccion;
	private boolean eliminado;
	
	public Proveedor(String rfc, String nombre, String direccion, boolean eliminado) {
		super();
		this.rfc = rfc;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public String getRfc() {
		return rfc;
	}

	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
	

}
