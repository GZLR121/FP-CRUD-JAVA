package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Juegos;
import bean.Usuario;
import mantenimiento.GestionJuegos;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.awt.event.ActionEvent;

public class FormAdminJuegos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCodigo;
	private JTextField txtPrecio;
	private JTextField txtRFC;
	private JComboBox<String> cb_Juegos;
	private JButton btnAgregar;
	private JButton btnEditar;
	private JButton btnEliminar;
	private JButton btnGuardar;
	
	public Juegos juegos;
	public Usuario usuario2;
	private JButton btnRecuperarJuego;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAdminJuegos frame = new FormAdminJuegos();
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
	public FormAdminJuegos() {
		setTitle("Administrar Juegos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(0, 51, 102));
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 459, 321);
		contentPane.add(contentPane_1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(new Color(153, 255, 255));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Buscar();
				btnAgregar.setEnabled(false);
				btnEditar.setEnabled(true);
				btnEliminar.setEnabled(true);
				txtRFC.setEditable(false);;
				txtNombre.setEditable(false);
				txtPrecio.setEditable(false);
				txtCodigo.setEditable(false);
			}
		});
		btnBuscar.setBounds(299, 22, 90, 23);
		contentPane_1.add(btnBuscar);
		
		cb_Juegos = new JComboBox<String>();
		cb_Juegos.setBounds(100, 22, 180, 22);
		contentPane_1.add(cb_Juegos);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(139, 95, 250, 20);
		contentPane_1.add(txtNombre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setBounds(80, 98, 55, 14);
		contentPane_1.add(lblNombre);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setForeground(new Color(255, 255, 255));
		lblCodigo.setBounds(80, 154, 55, 14);
		contentPane_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(140, 151, 90, 20);
		contentPane_1.add(txtCodigo);
		
		JLabel lblPrecio_1 = new JLabel("Precio:");
		lblPrecio_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio_1.setForeground(new Color(255, 255, 255));
		lblPrecio_1.setBounds(245, 154, 50, 14);
		contentPane_1.add(lblPrecio_1);
		
		txtPrecio = new JTextField();
		txtPrecio.setEditable(false);
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(303, 151, 86, 20);
		contentPane_1.add(txtPrecio);
		
		JLabel lblPrecio = new JLabel("RFC del Proveedor:");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrecio.setForeground(new Color(255, 255, 255));
		lblPrecio.setBounds(100, 199, 115, 14);
		contentPane_1.add(lblPrecio);
		
		txtRFC = new JTextField();
		txtRFC.setEditable(false);
		txtRFC.setColumns(10);
		txtRFC.setBounds(222, 196, 135, 20);
		contentPane_1.add(txtRFC);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(153, 255, 255));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar();
			}
		});
		btnAgregar.setEnabled(false);
		btnAgregar.setBounds(10, 287, 89, 23);
		contentPane_1.add(btnAgregar);
		
		JButton btnBack = new JButton("<");
		btnBack.setBackground(new Color(153, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 50, 43);
		contentPane_1.add(btnBack);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Eliminar();	
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(new Color(255, 51, 51));
		btnEliminar.setBounds(360, 287, 89, 23);
		contentPane_1.add(btnEliminar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(153, 255, 255));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hab();
				txtCodigo.setEditable(false);
			}
		});
		btnEditar.setBounds(128, 287, 89, 23);
		contentPane_1.add(btnEditar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(153, 255, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar();	
				btnGuardar.setEnabled(false);
		}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(245, 287, 89, 23);
		contentPane_1.add(btnGuardar);
		
		JButton btnHab_Lim = new JButton("Habilitar / Limpiar");
		btnHab_Lim.setBackground(new Color(153, 255, 255));
		btnHab_Lim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hab();
				txtNombre.setText("");
				txtPrecio.setText("");
				txtRFC.setText("");
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnGuardar.setEnabled(false);
			}
		});
		btnHab_Lim.setBounds(10, 253, 160, 23);
		contentPane_1.add(btnHab_Lim);
		
		btnRecuperarJuego = new JButton("Recuperar Juego");
		btnRecuperarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recovery();
			}
		});
		btnRecuperarJuego.setBackground(new Color(153, 255, 255));
		btnRecuperarJuego.setBounds(289, 253, 160, 23);
		contentPane_1.add(btnRecuperarJuego);
		cargarJuegos();
	}

	protected void Recovery() {
		FormRJuego juegosR = new FormRJuego();
		juegosR.usuario2 = usuario2;
		juegosR.setVisible(true);
		this.dispose();
	}

	protected void hab() {
		txtNombre.setEditable(true);
		txtPrecio.setEditable(true);
		txtRFC.setEditable(true);
		txtCodigo.setEditable(true);
		btnGuardar.setEnabled(true);
		
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
			
		protected void Agregar() {
			String Cod = txtCodigo.getText();
			String RFC = txtRFC.getText();
			String Nombre = txtNombre.getText();
			String Pre = txtPrecio.getText();
			Integer Codigo = Integer.parseInt(Cod);
			Integer Precio = Integer.parseInt(Pre);
			GestionJuegos insert = new GestionJuegos();
			
			Juegos juegos = new Juegos();
			
			juegos.setCodigo(Codigo);
			juegos.setNombre(Nombre);
			juegos.setPrecio(Precio);
			juegos.setRFC(RFC);
			
			boolean existe = insert.CodigoExiste(Codigo);

			if (existe) {
				JOptionPane.showMessageDialog(contentPane, "Este Codigo ya esta en uso.", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			insert.JuegosInsert(juegos);		
		}

		protected void Eliminar() {
			Integer Codigo = Integer.parseInt(txtCodigo.getText());
			GestionJuegos delete = new GestionJuegos();

			juegos = new Juegos();
			
			juegos.setCodigo(Codigo);
			
			delete.JuegosDelete(juegos);
			txtNombre.setText("");
			txtPrecio.setText("");
			txtRFC.setText("");
			txtCodigo.setText("");
			
		}

		protected void Guardar() {
			String Cod = txtCodigo.getText();
			Integer Codigo = Integer.parseInt(Cod);
			String Nombre = txtNombre.getText();
			String Pre = txtPrecio.getText();
			String RFC = txtRFC.getText();
			Integer Precio = Integer.parseInt(Pre);
			
			GestionJuegos update = new GestionJuegos();
			
			juegos = new Juegos();
			
			juegos.setNombre(Nombre);
			juegos.setPrecio(Precio);
			juegos.setRFC(RFC);
			juegos.setCodigo(Codigo);
			
			update.JuegosUpdate(juegos);
			
		}

		protected void Back() {
			FormJuegos juegos = new FormJuegos();
			juegos.usuario2 = usuario2;
			juegos.setVisible(true);
			this.dispose();

		}
}
