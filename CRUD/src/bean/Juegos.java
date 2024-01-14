package bean;

public class Juegos {
	
	private int Codigo;
	private String Nombre;
	private int Precio;
	private String RFC;
	private boolean eliminado;
	
	public Juegos(int codigo, String nombre, int precio, String rFC, boolean eliminado) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Precio = precio;
		RFC = rFC;
		
	
	}

	public Juegos() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return Codigo;
	}

	public void setCodigo(int codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getRFC() {
		return RFC;
	}

	public void setRFC(String rFC) {
		RFC = rFC;
	}
	
	@Override

	public String toString() {
		return getNombre();
		}

	public boolean isEliminado() {
		return eliminado;
	}

	public void setEliminado(boolean eliminado) {
		this.eliminado = eliminado;
	}
}
