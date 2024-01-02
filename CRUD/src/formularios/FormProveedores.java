package formularios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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
					FormProveedores frame = new FormProveedores();
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
	public FormProveedores() {
		setTitle("Proveedores");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(115, 75, 89, 23);
		contentPane.add(btnEditar);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(222, 75, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.RED);
		btnEliminar.setBounds(328, 75, 89, 23);
		contentPane.add(btnEliminar);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(97, 130, 86, 20);
		contentPane.add(textField);
		
		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(52, 133, 46, 14);
		contentPane.add(lblDNI);
		
		JLabel lblTfno = new JLabel("Telefono:");
		lblTfno.setBounds(230, 133, 46, 14);
		contentPane.add(lblTfno);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(286, 130, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 75, 89, 23);
		contentPane.add(btnAgregar);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(84, 178, 55, 14);
		contentPane.add(lblDireccion);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(147, 175, 200, 20);
		contentPane.add(textField_2);
		
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
