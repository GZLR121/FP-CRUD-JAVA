package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
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
		btnINGRESAR.setBounds(98, 170, 89, 23);
		contentPane.add(btnINGRESAR);
		
		JButton btnREGISTRAR = new JButton("REGISTRAR");
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnREGISTRAR.setBounds(238, 170, 89, 23);
		contentPane.add(btnREGISTRAR);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(188, 110, 150, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
	}

	protected void registrar() {
		// TODO Auto-generated method stub
		
	}

	protected void ingresar() {
		
		String tfno_usuario = txtTfno.getText();
		String dni_usuario = txtDNI.getText();
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setTfno(tfno_usuario);
		
		
		
		Usuario usu = gestionUsuario.obtenerUsuario(usu);
		
	}
}
