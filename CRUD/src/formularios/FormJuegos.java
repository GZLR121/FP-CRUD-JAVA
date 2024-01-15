package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Juegos;
import bean.Usuario;
import bean.Ventas;
import mantenimiento.GestionJuegos;
import mantenimiento.GestionVentas;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class FormJuegos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtRFC;
	private JComboBox<String> cb_Juegos;
	
	public Usuario usuario2;
	public Juegos juegos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormJuegos frame = new FormJuegos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormJuegos() {
		setResizable(false);
		setTitle("Juegos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(153, 255, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		btnBuscar.setBounds(299, 22, 90, 23);
		contentPane.add(btnBuscar);
		
		cb_Juegos = new JComboBox<String>();
		cb_Juegos.setBounds(89, 22, 180, 22);
		contentPane.add(cb_Juegos);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(145, 87, 244, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(80, 90, 55, 14);
		contentPane.add(lblNombre);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(84, 146, 55, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(145, 143, 85, 20);
		contentPane.add(txtCodigo);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setForeground(new Color(255, 255, 255));
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio_1.setBounds(243, 146, 50, 14);
		contentPane.add(lblPrecio_1);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(303, 143, 86, 20);
		contentPane.add(txtPrecio);
		
		JLabel lblPrecio = new JLabel("RFC del Proveedor:");
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setBounds(100, 191, 115, 14);
		contentPane.add(lblPrecio);
		
		txtRFC = new JTextField();
		txtRFC.setEditable(false);
		txtRFC.setColumns(10);
		txtRFC.setBounds(222, 188, 135, 20);
		contentPane.add(txtRFC);
		
		JButton btnAdministar = new JButton("Administrar");
		btnAdministar.setBackground(new Color(153, 255, 255));
		btnAdministar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Admin();
			}
		});
		btnAdministar.setBounds(10, 257, 100, 23);
		contentPane.add(btnAdministar);
		
		JButton btnBack = new JButton("<");
		btnBack.setBackground(new Color(153, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 50, 43);
		contentPane.add(btnBack);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBackground(new Color(153, 255, 153));
		btnComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprar();
			}
		});
		btnComprar.setBounds(349, 257, 100, 23);
		contentPane.add(btnComprar);
		
		cargarJuegos();
	}
	

	protected void Admin() {
		FormAdminJuegos AdminJuegos = new FormAdminJuegos();
		AdminJuegos.usuario2 = usuario2;
		AdminJuegos.setVisible(true);
		this.dispose();
	}

	protected void comprar() {
		String Cod = txtCodigo.getText();
		int cod = Integer.parseInt(Cod);
		int Id = usuario2.getId_cliente();
		
		GestionVentas compra = new GestionVentas();
		boolean existe = compra.VentaExiste(Id, cod);

		if (existe) {
			JOptionPane.showMessageDialog(contentPane, "Este articulo ya ha sido comprado.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		Ventas venta = new Ventas();
		venta.setCodigo(cod);
		venta.setId_cliente(Id);
		compra.Compra(venta);
	}

	private void cargarJuegos() {
		cb_Juegos.removeAllItems();
		GestionJuegos gestionJuegos = new GestionJuegos();
		List<Juegos> juegos = gestionJuegos.getJuegos();
		Iterator<Juegos> iterador = juegos.iterator();
				
		while (iterador.hasNext()) {
			Juegos juego = iterador.next();
			cb_Juegos.addItem(juego.toString());
		}
		}
	protected void Buscar() {
		String juego = (String) cb_Juegos.getSelectedItem();
			
		GestionJuegos gestionJuegos = new GestionJuegos();
			
		Juegos juegos = new Juegos();
		juegos.setNombre(juego);
			
		Juegos game = gestionJuegos.obtenerJuego(juegos);
		
		if (game!=null) {
			juegos.setCodigo(game.getCodigo());
			juegos.setNombre(game.getNombre());
			juegos.setPrecio(game.getPrecio());
			juegos.setRFC(game.getRFC());
				
			txtRFC.setText(game.getRFC());
			txtNombre.setText(game.getNombre());
			Integer Cod = game.getCodigo();
			txtCodigo.setText(Cod.toString());
			Integer Price = game.getPrecio();
			txtPrecio.setText(Price.toString());
		} else {
			JOptionPane.showMessageDialog(contentPane, "Juego no existente", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
			

		protected void Back() {
			FormPrincipal principal = new FormPrincipal();
			principal.usuario2 = usuario2;
			principal.setVisible(true);
			this.dispose();
			
		}

}

