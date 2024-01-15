package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Usuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

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
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnJuegos = new JButton("Juegos");
		btnJuegos.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnJuegos.setBackground(new Color(153, 255, 255));
		btnJuegos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				juegos();
				
			}	
		});
		btnJuegos.setBounds(128, 55, 175, 148);
		contentPane.add(btnJuegos);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnPerfil.setBackground(new Color(153, 255, 255));
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfil();
			}
		});
		btnPerfil.setBounds(10, 86, 105, 86);
		contentPane.add(btnPerfil);
		
		JButton btnProv = new JButton("Proveedores");
		btnProv.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnProv.setBackground(new Color(153, 255, 255));
		btnProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provedores();
			}
		});
		btnProv.setBounds(316, 86, 105, 86);
		contentPane.add(btnProv);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(255, 51, 51));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LogOut();
			}
		});
		btnLogOut.setBounds(10, 227, 89, 23);
		contentPane.add(btnLogOut);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setForeground(new Color(255, 255, 255));
		btnSalir.setBackground(new Color(255, 51, 51));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 11));
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
		JOptionPane.showMessageDialog(contentPane, "Sesion cerrada exitosamente", "Log Out Success", JOptionPane.INFORMATION_MESSAGE);
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
