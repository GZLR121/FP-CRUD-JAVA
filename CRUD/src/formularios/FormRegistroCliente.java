package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

import bean.Usuario;
import mantenimiento.GestionUsuario;

public class FormRegistroCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtTfno;
	private JTextField txtDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRegistroCliente frame = new FormRegistroCliente();
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
	public FormRegistroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(87, 34, 54, 16);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(169, 33, 200, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidos.setBounds(87, 82, 70, 16);
		contentPane.add(lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setColumns(10);
		txtApellidos.setBounds(169, 81, 200, 20);
		contentPane.add(txtApellidos);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTfno.setBounds(87, 213, 65, 16);
		contentPane.add(lblTfno);
		
		txtTfno = new JTextField();
		txtTfno.setColumns(10);
		txtTfno.setBounds(169, 212, 200, 20);
		contentPane.add(txtTfno);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDNI.setBounds(100, 169, 30, 16);
		contentPane.add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(169, 168, 200, 20);
		contentPane.add(txtDNI);
		
		JLabel lblFecha_cum = new JLabel("Fecha de nacimiento:");
		lblFecha_cum.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha_cum.setBounds(45, 126, 140, 16);
		contentPane.add(lblFecha_cum);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnRegistrar.setBounds(179, 247, 89, 23);
		contentPane.add(btnRegistrar);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 43, 43);
		contentPane.add(btnBack);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("y-M-d");
		dateChooser.setBounds(210, 126, 120, 20);
		contentPane.add(dateChooser);
	}

	protected void Registrar() {
		
		String name = txtNombre.getText();
		String lastname = txtApellidos.getText();
		//String fecha = dateChooser.getText();
		String tfno = txtTfno.getText();
		String dni = txtDNI.getText();
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		int tfno_usuario = Integer.parseInt(tfno);
		long dni_usuario = Integer.parseInt(dni);
		
		Usuario usuario2 = new Usuario();
		usuario2.setDni(dni_usuario);
		
		
		Usuario usu = gestionUsuario.obtenerUsuarioRegistro(usuario2);
		
		GestionUsuario regisUsuario = new GestionUsuario();
		
		Usuario usuario3 = new Usuario();
		usuario3.setDni(dni_usuario);
		usuario3.setNombre(name);
		usuario3.setApellidos(lastname);
		usuario3.setTfno(tfno_usuario);
		
		//Usuario usu3 = regisUsuario.UsuarioRegistro(usuario3);
		
		if (usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Este DNI ya esta en uso.", "Error", JOptionPane.ERROR_MESSAGE);

		} else {
			regisUsuario.UsuarioRegistro(usuario3);
			JOptionPane.showMessageDialog(contentPane, "¡Usuario Registrado Correctamente!");	
		}
		
	}

	protected void Back() {
		FormLogin login = new FormLogin();
		login.setVisible(true);
		this.dispose();
	}
}
