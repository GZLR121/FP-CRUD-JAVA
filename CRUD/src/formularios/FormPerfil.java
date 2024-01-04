package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;

import com.toedter.calendar.JDateChooser;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 325);
		contentPane = new JPanel();
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
		lblDNI.setBounds(55, 123, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setBounds(233, 123, 46, 14);
		contentPane.add(lblTfno);
		
		txtTfno = new JTextField();
		txtTfno.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTfno.setEditable(false);
		txtTfno.setColumns(10);
		txtTfno.setBounds(289, 120, 100, 20);
		contentPane.add(txtTfno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(44, 182, 55, 14);
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(100, 179, 100, 20);
		contentPane.add(txtNombre);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(230, 182, 55, 14);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtApellidos.setEditable(false);
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(289, 179, 100, 20);
		contentPane.add(txtApellidos);
		
		JDateChooser jdc_Fecha = new JDateChooser();
		jdc_Fecha.setBounds(255, 234, 120, 20);
		contentPane.add(jdc_Fecha);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
		lblFecha.setBounds(30, 237, 115, 14);
		contentPane.add(lblFecha);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(155, 234, 100, 20);
		contentPane.add(txtFecha);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar();
			}
			
		});
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(286, 75, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txtNombre.getText();
				String lastname = txtApellidos.getText();
				String fecha;
				SimpleDateFormat f = new SimpleDateFormat ("yyyy-MM-dd");
				//fecha = f.format(jdc_Fecha.getDate());
				int Id = usuario2.getId_cliente();
				fecha = txtFecha.getText();
				String tfno = txtTfno.getText();
				String dni = txtDNI.getText();
				
				//GestionUsuario gestionUsuario = new GestionUsuario();
				long tfno_usuario = Long.parseLong(tfno);
				long dni_usuario = Long.parseLong(dni);
				
				//Usuario usuario3 = new Usuario();
				usuario2.setDni(dni_usuario);
				
				
				GestionUsuario regisUsuario = new GestionUsuario();
				
 				Usuario usuario2 = new Usuario();
				usuario2.setDni(dni_usuario);
				usuario2.setNombre(name);
				usuario2.setApellidos(lastname);
				usuario2.setFecha(fecha);
				usuario2.setTfno(tfno_usuario);
				usuario2.setId_cliente(Id);
				regisUsuario.UsuarioUpdate(usuario2);
				
				/*if (usu!=null) {
					JOptionPane.showMessageDialog(contentPane, "Este DNI ya esta en uso.", "Error", JOptionPane.ERROR_MESSAGE);

				} else {
					regisUsuario.UsuarioUpdate(usuario2);
					JOptionPane.showMessageDialog(contentPane, "¡Usuario Registrado Correctamente!");	*/
				}
				
			}
			
		);
		btnGuardar.setBounds(175, 75, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar();
				btnGuardar.setEnabled(true);
			}
		});
		btnEditar.setBounds(55, 75, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 50, 43);
		contentPane.add(btnBack);
		
		JButton btnDatos = new JButton("Mostrar Datos");
		btnDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Datos();
				/*String fecha;
				SimpleDateFormat f = new SimpleDateFormat ("d MMM y");
				fecha = f.format(usuario2.getFecha());
				jdc_Fecha.setDateFormatString(fecha);*/
			}
		});
		btnDatos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnDatos.setBounds(314, 12, 110, 43);
		contentPane.add(btnDatos);
	}

	protected void Eliminar() {
		// TODO Auto-generated method stub
		
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
		principal.setVisible(true);
		this.dispose();
		
	}
}
