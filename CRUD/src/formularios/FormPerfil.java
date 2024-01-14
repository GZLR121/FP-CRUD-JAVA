package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtTfno;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtFecha;

	public Usuario usuario2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPerfil frame = new FormPerfil();
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
	public FormPerfil() {
		setTitle("Perfil");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtDNI = new JTextField();
		txtDNI.setEditable(false);
		txtDNI.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDNI.setBounds(100, 120, 100, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(new Color(255, 255, 255));
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(55, 123, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setForeground(new Color(255, 255, 255));
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTfno.setBounds(220, 123, 60, 14);
		contentPane.add(lblTfno);
		
		txtTfno = new JTextField();
		txtTfno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTfno.setEditable(false);
		txtTfno.setColumns(10);
		txtTfno.setBounds(289, 120, 100, 20);
		contentPane.add(txtTfno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(new Color(255, 255, 255));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(40, 182, 60, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 179, 100, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setForeground(new Color(255, 255, 255));
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblApellidos.setBounds(220, 182, 65, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(289, 179, 100, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
		lblFecha.setForeground(new Color(255, 255, 255));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFecha.setBounds(95, 237, 130, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(230, 234, 100, 20);
		contentPane.add(txtFecha);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
			
		});
		btnEliminar.setBackground(new Color(255, 51, 51));
		btnEliminar.setBounds(286, 75, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(153, 255, 255));
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtNombre.getText();
				String lastname = txtApellidos.getText();
				String fecha;
				int Id = usuario2.getId_cliente();
				fecha = txtFecha.getText();
				String tfno = txtTfno.getText();
				String dni = txtDNI.getText();

				long tfno_usuario = Long.parseLong(tfno);
				long dni_usuario = Long.parseLong(dni);
				usuario2.setDni(dni_usuario);
				
		
				GestionUsuario regisUsuario = new GestionUsuario();
				
				boolean existe = regisUsuario.usuarioDNIExiste(dni_usuario, Id);

				if (existe) {
					JOptionPane.showMessageDialog(contentPane, "Este DNI ya esta en uso.", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				
 				Usuario usuario2 = new Usuario();
				usuario2.setDni(dni_usuario);
				usuario2.setNombre(name);
				usuario2.setApellidos(lastname);
				usuario2.setFecha(fecha);
				usuario2.setTfno(tfno_usuario);
				usuario2.setId_cliente(Id);
				regisUsuario.UsuarioUpdate(usuario2);
				
				btnGuardar.setEnabled(false);
				
				}
				
			}
			
		);
		btnGuardar.setBounds(175, 75, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBackground(new Color(153, 255, 255));
		btnEditar.setEnabled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar();
				btnGuardar.setEnabled(true);
			}
		});
		btnEditar.setBounds(55, 75, 89, 23);
		contentPane.add(btnEditar);
		
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
		
		JButton btnDatos = new JButton("Mostrar Datos");
		btnDatos.setBackground(new Color(153, 255, 255));
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datos();
				btnEliminar.setEnabled(true);
				btnEditar.setEnabled(true);
							}
		});
		btnDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDatos.setBounds(314, 12, 110, 43);
		contentPane.add(btnDatos);
	}

	protected void Eliminar() {
		int Id = usuario2.getId_cliente();
		GestionUsuario delete = new GestionUsuario();

		Usuario usuario3 = new Usuario();
		
		usuario3.setId_cliente(Id);
		
		delete.UsuarioDelete(usuario3);
		
	}

	protected void Editar() {
		txtNombre.setEditable(true);
		txtApellidos.setEditable(true);
		txtDNI.setEditable(true);
		txtTfno.setEditable(true);
		txtFecha.setEditable(true);
		
	}

	protected void Datos() {
		txtNombre.setText(usuario2.getNombre());
		txtApellidos.setText(usuario2.getApellidos());
		txtFecha.setText(usuario2.getFecha());
		txtDNI.setText(usuario2.getDni().toString());
		txtTfno.setText(usuario2.getTfno().toString());
	}

	protected void Back() {
		FormPrincipal principal = new FormPrincipal();
		principal.usuario2 = usuario2;
		principal.setVisible(true);
		this.dispose();
		
	}
}
