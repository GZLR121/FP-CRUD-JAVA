package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;
import mantenimiento.GestionUsuario;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormRUsuario extends JFrame {

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
					FormRUsuario frame = new FormRUsuario();
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
	public FormRUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setForeground(Color.WHITE);
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTfno.setBounds(93, 73, 70, 14);
		contentPane.add(lblTfno);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setBounds(111, 115, 42, 14);
		contentPane.add(lblDNI);
		
		txtTfno = new JTextField();
		txtTfno.setColumns(10);
		txtTfno.setBounds(184, 72, 150, 20);
		contentPane.add(txtTfno);
		
		txtDNI = new JTextField();
		txtDNI.setColumns(10);
		txtDNI.setBounds(184, 114, 150, 20);
		contentPane.add(txtDNI);
		
		JButton btnRecuperarUsuario = new JButton("RECUPERAR USUARIO");
		btnRecuperarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recovery();
			}
		});
		btnRecuperarUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRecuperarUsuario.setBackground(new Color(153, 255, 255));
		btnRecuperarUsuario.setBounds(123, 171, 180, 23);
		contentPane.add(btnRecuperarUsuario);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(new Color(153, 255, 255));
		btnBack.setBounds(10, 11, 50, 43);
		contentPane.add(btnBack);
	}

	protected void Recovery() {
		Long tfno_usuario = Long.parseLong(txtTfno.getText());
		long dni_usuario = Long.parseLong(txtDNI.getText());
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setTfno(tfno_usuario);
		usuario2.setDni(dni_usuario);
		
		gestionUsuario.UsuarioRecovery(usuario2);
		
	}

	protected void Back() {
		FormLogin login = new FormLogin();
		login.setVisible(true);
		this.dispose();
		
	}
}
