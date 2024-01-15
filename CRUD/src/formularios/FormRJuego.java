package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Juegos;
import bean.Usuario;
import mantenimiento.GestionJuegos;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormRJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Usuario usuario2;
	private JTextField txtCodigo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRJuego frame = new FormRJuego();
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
	public FormRJuego() {
		setTitle("Recuperar Juego");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigo.setBounds(84, 34, 55, 14);
		contentPane.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(144, 31, 100, 20);
		contentPane.add(txtCodigo);
		
		JButton btnRecuperarJuego = new JButton("Recuperar Juego");
		btnRecuperarJuego.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recovery();
			}
		});
		btnRecuperarJuego.setBackground(new Color(153, 255, 255));
		btnRecuperarJuego.setBounds(84, 59, 160, 23);
		contentPane.add(btnRecuperarJuego);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBackground(new Color(153, 255, 255));
		btnBack.setBounds(10, 11, 50, 51);
		contentPane.add(btnBack);
	}

	protected void Recovery() {
		Integer Codigo = Integer.parseInt(txtCodigo.getText());
		GestionJuegos recover = new GestionJuegos();
		
		Juegos game = new Juegos();
		game.setCodigo(Codigo);
		
		recover.JuegoRecovery(game);
		
	}

	protected void Back() {
		FormAdminJuegos juegos = new FormAdminJuegos();
		juegos.usuario2 = usuario2;
		juegos.setVisible(true);
		this.dispose();
		
	}

}
