package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Usuario usuario2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
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
	public FormPrincipal() {

		//Long tfno = usuario2.getTfno();
		//System.out.println(tfno);
		
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJuegos = new JButton("Juegos");
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				juegos();
				
			}	
		});
		btnJuegos.setBounds(128, 55, 175, 148);
		contentPane.add(btnJuegos);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil();
			}
		});
		btnPerfil.setBounds(10, 86, 105, 86);
		contentPane.add(btnPerfil);
		
		JButton btnProv = new JButton("Proveedores");
		btnProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provedores();
			}
		});
		btnProv.setBounds(316, 86, 105, 86);
		contentPane.add(btnProv);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOut();
			}
		});
		btnLogOut.setBounds(10, 227, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Salir();
			}
		});
		btnSalir.setBounds(332, 227, 89, 23);
		contentPane.add(btnSalir);
	}

	protected void juegos() {
		FormJuegos juegos = new FormJuegos();
		juegos.usuario2 = usuario2;
		juegos.setVisible(true);
		this.dispose();
		
	}

	protected void Salir() {
		System.exit(0);
	}
	protected void LogOut() {
		FormLogin login = new FormLogin();
		login.setVisible(true);
		this.dispose();
	}

	protected void perfil() {
		FormPerfil perfil = new FormPerfil();
		perfil.usuario2 = usuario2;
		perfil.setVisible(true);
		this.dispose();
	}

	protected void provedores() {
		FormProveedores proveedores = new FormProveedores();
		proveedores.usuario2 = usuario2;
		proveedores.setVisible(true);
		this.dispose();
		
	}
}
