package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Proveedor;
import bean.Usuario;
import mantenimiento.GestionProveedor;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtRFC;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtBuscar;

	public Proveedor proveedor;
	public Usuario usuario2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProveedores frame = new FormProveedores();
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
	public FormProveedores() {
		setTitle("Proveedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(153, 255, 255));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar();	
				btnGuardar.setEnabled(false);
			}
		});
		btnGuardar.setEnabled(false);
		btnGuardar.setBounds(222, 75, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(153, 255, 255));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setEditable(true);
				txtDireccion.setEditable(true);
				btnGuardar.setEnabled(true);
				
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setBounds(115, 75, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
		});
		btnEliminar.setEnabled(false);
		btnEliminar.setBackground(new Color(255, 51, 51));
		btnEliminar.setBounds(328, 75, 89, 23);
		contentPane.add(btnEliminar);
		
		txtRFC = new JTextField();
		txtRFC.setEditable(false);
		txtRFC.setColumns(10);
		txtRFC.setBounds(97, 130, 86, 20);
		contentPane.add(txtRFC);
		
		JLabel lblDNI = new JLabel("RFC:");
		lblDNI.setForeground(new Color(255, 255, 255));
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(52, 133, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTfno = new JLabel("Nombre:");
		lblTfno.setForeground(new Color(255, 255, 255));
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTfno.setBounds(195, 133, 55, 14);
		contentPane.add(lblTfno);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(252, 130, 123, 20);
		contentPane.add(txtNombre);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(new Color(153, 255, 255));
		btnAgregar.setEnabled(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agregar();
			}
		});
		btnAgregar.setBounds(10, 75, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setForeground(new Color(255, 255, 255));
		lblDireccion.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDireccion.setBounds(84, 178, 60, 14);
		contentPane.add(lblDireccion);
		
		txtDireccion = new JTextField();
		txtDireccion.setEditable(false);
		txtDireccion.setColumns(10);
		txtDireccion.setBounds(147, 175, 200, 20);
		contentPane.add(txtDireccion);
		
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
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(130, 23, 120, 20);
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
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
				txtDireccion.setEditable(false);
			}
		});
		btnBuscar.setBounds(275, 22, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnLimpiar = new JButton("Habilitar / Limpiar");
		btnLimpiar.setBackground(new Color(153, 255, 255));
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtRFC.setText("");
				txtNombre.setText("");
				txtDireccion.setText("");
				txtRFC.setEditable(true);;
				txtNombre.setEditable(true);
				txtDireccion.setEditable(true);
				btnAgregar.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEliminar.setEnabled(false);
				btnGuardar.setEnabled(false);
			}
		});
		btnLimpiar.setBounds(267, 227, 150, 23);
		contentPane.add(btnLimpiar);
	}

	protected void Agregar() {
		String RFC = txtRFC.getText();
		String Nombre = txtNombre.getText();
		String Direccion = txtDireccion.getText();
		
		GestionProveedor insert = new GestionProveedor();

		boolean existe = insert.provRFCExiste(RFC);

		if (existe) {
			JOptionPane.showMessageDialog(contentPane, "Este RFC ya esta en uso.", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Proveedor proveedor = new Proveedor();
		
		proveedor.setRfc(RFC);
		proveedor.setNombre(Nombre);
		proveedor.setDireccion(Direccion);
		
		insert.ProveedorInsert(proveedor);
		}
		

	protected void Eliminar() {
		String RFC = proveedor.getRfc();
		GestionProveedor delete = new GestionProveedor();

		proveedor = new Proveedor();
		
		proveedor.setRfc(RFC);
		
		delete.ProveedorDelete(proveedor);
		txtRFC.setText("");
		txtNombre.setText("");
		txtDireccion.setText("");
		
	}

	protected void Guardar() {
		String Nombre = txtNombre.getText();
		String Direccion = txtDireccion.getText();
		String RFC = proveedor.getRfc();
		
		GestionProveedor update = new GestionProveedor();
		
		proveedor = new Proveedor();
		
		proveedor.setNombre(Nombre);
		proveedor.setDireccion(Direccion);
		proveedor.setRfc(RFC);
		
		update.ProveedorUpdate(proveedor);
		
	}

	protected void Buscar() {
		String rfc = txtBuscar.getText();
		
		GestionProveedor gestionproveedor = new GestionProveedor();
		
		proveedor = new Proveedor();
		proveedor.setRfc(rfc);
		
		Proveedor pro = gestionproveedor.obtenerProveedor(proveedor);
		
		if (pro!=null) {
			proveedor.setDireccion(pro.getDireccion());
			proveedor.setNombre(pro.getNombre());
			proveedor.setRfc(pro.getRfc());
			
			txtRFC.setText(pro.getRfc());
			txtNombre.setText(pro.getNombre());
			txtDireccion.setText(pro.getDireccion());
		} else {
			JOptionPane.showMessageDialog(contentPane, "RFC no existente", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
	}

	protected void Back() {
		FormPrincipal principal = new FormPrincipal();
		principal.usuario2 = usuario2;
		principal.setVisible(true);
		this.dispose();
		
	}
}
