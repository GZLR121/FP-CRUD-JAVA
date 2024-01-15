package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Proveedor;
import bean.Usuario;
import mantenimiento.GestionProveedor;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormRProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public Usuario usuario2;
	private JTextField txtRFC;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormRProveedor frame = new FormRProveedor();
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
	public FormRProveedor() {
		setTitle("Recuperar Proveedor");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 175);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 51, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JLabel lblDNI = new JLabel("RFC:");
		lblDNI.setForeground(Color.WHITE);
		lblDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDNI.setBounds(100, 26, 46, 14);
		contentPane.add(lblDNI);
		
		txtRFC = new JTextField();
		txtRFC.setColumns(10);
		txtRFC.setBounds(145, 23, 86, 20);
		contentPane.add(txtRFC);
		
		JButton btnRecuperarProveedor = new JButton("Recuperar Proveedor");
		btnRecuperarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recovery();
			}
		});
		btnRecuperarProveedor.setBackground(new Color(153, 255, 255));
		btnRecuperarProveedor.setBounds(61, 84, 170, 23);
		contentPane.add(btnRecuperarProveedor);
	}

	protected void Recovery() {
		String RFC = txtRFC.getText();
		GestionProveedor recover = new GestionProveedor();
		
		Proveedor prov = new Proveedor();
		prov.setRfc(RFC);
		
		recover.ProveedorRecovery(prov);
	}

	protected void Back() {
		FormProveedores proveedores = new FormProveedores();
		proveedores.usuario2 = usuario2;
		proveedores.setVisible(true);
		this.dispose();
		
	}

}
