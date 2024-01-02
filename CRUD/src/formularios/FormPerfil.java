package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtTfno;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		txtDNI.setBounds(100, 120, 86, 20);
		contentPane.add(txtDNI);
		txtDNI.setColumns(10);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(55, 123, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setBounds(233, 123, 46, 14);
		contentPane.add(lblTfno);
		
		txtTfno = new JTextField();
		txtTfno.setEditable(false);
		txtTfno.setColumns(10);
		txtTfno.setBounds(289, 120, 86, 20);
		contentPane.add(txtTfno);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(44, 182, 55, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(100, 179, 86, 20);
		contentPane.add(textField);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(230, 182, 55, 14);
		contentPane.add(lblApellidos);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(289, 179, 86, 20);
		contentPane.add(textField_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(255, 234, 120, 20);
		contentPane.add(dateChooser);
		
		JLabel lblFecha = new JLabel("Fecha de Nacimiento:");
		lblFecha.setBounds(44, 237, 110, 14);
		contentPane.add(lblFecha);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(150, 234, 100, 20);
		contentPane.add(textField_2);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(55, 65, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(new Color(255, 0, 0));
		btnEliminar.setBounds(286, 65, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(174, 65, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnBack = new JButton("<");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnBack.setBounds(10, 11, 50, 43);
		contentPane.add(btnBack);
	}

	protected void Back() {
		FormPrincipal principal = new FormPrincipal();
		principal.setVisible(true);
		this.dispose();
		
	}
}
