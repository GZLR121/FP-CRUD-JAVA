package bean;

public class Ventas {
	
	private Integer id_cliente;
	private Integer Codigo;
	
	public Integer getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Integer id_cliente) {
		this.id_cliente = id_cliente;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public Ventas(Integer id_cliente, Integer codigo) {
		super();
		this.id_cliente = id_cliente;
		Codigo = codigo;
	}

	public Ventas() {
		// TODO Auto-generated constructor stub
	}

}
