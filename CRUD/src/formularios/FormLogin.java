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
import java.awt.Color;

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
		setTitle("Log In");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setForeground(new Color(255, 255, 255));
		lblTfno.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTfno.setBounds(97, 48, 70, 14);
		contentPane.add(lblTfno);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setForeground(new Color(255, 255, 255));
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDNI.setBounds(115, 90, 42, 14);
		contentPane.add(lblDNI);
		
		txtTfno = new JTextField();
		txtTfno.setBounds(188, 47, 150, 20);
		contentPane.add(txtTfno);
		txtTfno.setColumns(10);
		
		JButton btnINGRESAR = new JButton("INGRESAR");
		btnINGRESAR.setBackground(new Color(153, 255, 255));
		btnINGRESAR.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnINGRESAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ingresar();
			}
		});
		btnINGRESAR.setBounds(100, 149, 100, 23);
		contentPane.add(btnINGRESAR);
		
		JButton btnREGISTRAR = new JButton("REGISTRAR");
		btnREGISTRAR.setBackground(new Color(153, 255, 255));
		btnREGISTRAR.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnREGISTRAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrar();
			}
		});
		btnREGISTRAR.setBounds(240, 150, 100, 23);
		contentPane.add(btnREGISTRAR);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(188, 89, 150, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JButton btnRecuperarUsuario = new JButton("RECUPERAR USUARIO");
		btnRecuperarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recovery();
			}
		});
		btnRecuperarUsuario.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnRecuperarUsuario.setBackground(new Color(153, 255, 255));
		btnRecuperarUsuario.setBounds(128, 200, 180, 23);
		contentPane.add(btnRecuperarUsuario);
	}

	protected void Recovery() {
		FormRUsuario RUsuario = new FormRUsuario();
		RUsuario.setVisible(true);
		this.dispose();
	}

	protected void registrar() {
		FormRegistroCliente RegistroCliente = new FormRegistroCliente();
		RegistroCliente.setVisible(true);
		this.dispose();
	}

	protected void ingresar() {
		
		Long tfno_usuario = Long.parseLong(txtTfno.getText());
		long dni_usuario = Long.parseLong(txtDNI.getText());
		
		GestionUsuario gestionUsuario = new GestionUsuario();
		
		Usuario usuario2 = new Usuario();
		usuario2.setTfno(tfno_usuario);
		usuario2.setDni(dni_usuario);
		
		Usuario usu = gestionUsuario.obtenerUsuario(usuario2);
		
		if (usu!=null) {
			JOptionPane.showMessageDialog(contentPane, "Bienvenido");
			usuario2.setApellidos(usu.getApellidos());
			usuario2.setFecha(usu.getFecha());
			usuario2.setNombre(usu.getNombre());
			usuario2.setId_cliente(usu.getId_cliente());
			FormPrincipal principal = new FormPrincipal();
			principal.usuario2 = usuario2;
			principal.setVisible(true);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(contentPane, "Datos Invalidos", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
