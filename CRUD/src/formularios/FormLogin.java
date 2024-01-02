package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class FormLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTfno;
	private JTextField txtDNI;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
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
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTfno.setBounds(97, 69, 70, 14);
		contentPane.add(lblTfno);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setBounds(115, 111, 42, 14);
		contentPane.add(lblDNI);
		
		txtTfno = new JTextField();
		txtTfno.setBounds(188, 68, 150, 20);
		contentPane.add(txtTfno);
		txtTfno.setColumns(10);
		
		JButton btnINGRESAR = new JButton("INGRESAR");
		btnINGRESAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnINGRESAR.setBounds(97, 170, 100, 23);
		contentPane.add(btnINGRESAR);
		
		JButton btnREGISTRAR = new JButton("REGISTRAR");
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnREGISTRAR.setBounds(238, 170, 100, 23);
		contentPane.add(btnREGISTRAR);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(188, 110, 150, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
	}

	protected void registrar() {
		FormRegistroCliente RegistroCliente = new FormRegistroCliente();
		RegistroCliente.setVisible(true);
		this.dispose();
	}

	protected void ingresar() {
		
		String tfno = txtTfno.getText();
		String dni = txtDNI.getText();
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		long tfno_usuario = Long.parseLong(tfno);
		long dni_usuario = Long.parseLong(dni);
		
		Usuario usuario2 = new Usuario();
		usuario2.setTfno(tfno_usuario);
		usuario2.setDni(dni_usuario);
		
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if (usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			
			FormPrincipal principal = new FormPrincipal();
			principal.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
