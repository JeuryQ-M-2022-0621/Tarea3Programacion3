package RegistroUsers;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import RegistroTelefonos.RegistrarT;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Usuarios {

	private JFrame frmRegistro;
	private JTextField textUsuario;
	private JPasswordField textContraseña;
	private JPasswordField textConfirmacion;
	private JTextField textCedula;
	private JTextField textNombre;
	private JTextField textFE;
	private JTextField textTelefono;
	private JTextField textCorreo;
	private JTextField textApellido;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 */
	public Usuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistro = new JFrame();
		frmRegistro.setTitle("Registro");
		frmRegistro.getContentPane().setLocation(-48, 0);
		frmRegistro.setBounds(100, 100, 634, 390);
		frmRegistro.setLocationRelativeTo(null);
		frmRegistro.setVisible(true);
		frmRegistro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistro.getContentPane().setLayout(null);
		
		JPanel panelUsuarios = new JPanel();
		panelUsuarios.setBackground(SystemColor.textHighlight);
		panelUsuarios.setBounds(0, 0, 618, 157);
		frmRegistro.getContentPane().add(panelUsuarios);
		panelUsuarios.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(10, 42, 598, 11);
		panelUsuarios.add(separator);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblUsuario.setBounds(10, 11, 98, 33);
		panelUsuarios.add(lblUsuario);
		
		JLabel lblUser = new JLabel("Usuario");
		lblUser.setForeground(new Color(255, 255, 255));
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUser.setBounds(20, 64, 98, 20);
		panelUsuarios.add(lblUser);
		
		textUsuario = new JTextField();
		textUsuario.setBackground(SystemColor.menu);
		textUsuario.setBounds(30, 96, 133, 20);
		panelUsuarios.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblClave = new JLabel("Contraseña");
		lblClave.setForeground(Color.WHITE);
		lblClave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblClave.setBounds(185, 64, 98, 20);
		panelUsuarios.add(lblClave);
		
		textContraseña = new JPasswordField();
		textContraseña.setBackground(SystemColor.menu);
		textContraseña.setBounds(195, 96, 133, 20);
		panelUsuarios.add(textContraseña);
		
		JLabel lblConfimacionClave = new JLabel("Confirme Contraseña");
		lblConfimacionClave.setForeground(Color.WHITE);
		lblConfimacionClave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblConfimacionClave.setBounds(348, 64, 156, 20);
		panelUsuarios.add(lblConfimacionClave);
		
		textConfirmacion = new JPasswordField();
		textConfirmacion.setBackground(SystemColor.menu);
		textConfirmacion.setBounds(358, 96, 133, 20);
		panelUsuarios.add(textConfirmacion);
		
		JButton btnCheck = new JButton("Comprobar");
		btnCheck.setForeground(new Color(255, 255, 255));
		btnCheck.setBackground(new Color(0, 206, 209));
		btnCheck.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Comprobar();
		}
			});
		btnCheck.setBounds(501, 88, 107, 28);
		panelUsuarios.add(btnCheck);
		
		JPanel panelEmpleado = new JPanel();
		panelEmpleado.setBackground(Color.WHITE);
		panelEmpleado.setBounds(0, 157, 618, 201);
		frmRegistro.getContentPane().add(panelEmpleado);
		panelEmpleado.setLayout(null);
		
		JLabel lblEmpleado = new JLabel("Empleado");
		lblEmpleado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleado.setForeground(new Color(0, 0, 0));
		lblEmpleado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblEmpleado.setBounds(10, 11, 111, 33);
		panelEmpleado.add(lblEmpleado);
		
		JLabel lblCedula = new JLabel("Cedula");
		lblCedula.setForeground(Color.BLACK);
		lblCedula.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCedula.setBounds(10, 63, 98, 20);
		panelEmpleado.add(lblCedula);
		
		textCedula = new JTextField();
		textCedula.setBackground(SystemColor.menu);
		textCedula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Cédula sin guión!");
			}
		});
		textCedula.setColumns(10);
		textCedula.setBounds(20, 94, 133, 20);
		panelEmpleado.add(textCedula);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNombre.setBounds(156, 63, 98, 20);
		panelEmpleado.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBackground(SystemColor.menu);
		textNombre.setColumns(10);
		textNombre.setBounds(163, 94, 133, 20);
		panelEmpleado.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setForeground(Color.BLACK);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblApellido.setBounds(301, 64, 98, 20);
		panelEmpleado.add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setBackground(SystemColor.menu);
		textApellido.setColumns(10);
		textApellido.setBounds(306, 94, 133, 20);
		panelEmpleado.add(textApellido);
		
		JLabel lblFE = new JLabel("Fecha_Nacimiento");
		lblFE.setForeground(Color.BLACK);
		lblFE.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFE.setBounds(443, 64, 143, 20);
		panelEmpleado.add(lblFE);
		
		textFE = new JTextField();
		textFE.setBackground(SystemColor.menu);
		textFE.setColumns(10);
		textFE.setBounds(449, 94, 159, 20);
		panelEmpleado.add(textFE);
		
		JLabel lblTel = new JLabel("Teléfono");
		lblTel.setForeground(Color.BLACK);
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTel.setBounds(10, 125, 143, 20);
		panelEmpleado.add(lblTel);
		
		textTelefono = new JTextField();
		textTelefono.setBackground(SystemColor.menu);
		textTelefono.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Incluya guiones!");
			}
		});
		textTelefono.setColumns(10);
		textTelefono.setBounds(20, 155, 133, 20);
		panelEmpleado.add(textTelefono);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCorreo.setBounds(156, 125, 143, 20);
		panelEmpleado.add(lblCorreo);
		
		textCorreo = new JTextField();
		textCorreo.setBackground(SystemColor.menu);
		textCorreo.setColumns(10);
		textCorreo.setBounds(166, 155, 343, 20);
		panelEmpleado.add(textCorreo);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(0, 206, 209));
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			Guardar();
				
			}
		});
		btnGuardar.setBounds(519, 142, 89, 33);
		panelEmpleado.add(btnGuardar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(10, 41, 598, 11);
		panelEmpleado.add(separator_1);
	}
	
	public void Comprobar() {
		if(textConfirmacion.getText().equals(textContraseña.getText())) {
			JOptionPane.showMessageDialog(null, "Coinciden!");
			return;
		}else {
			
		}JOptionPane.showMessageDialog(null, "No hay coincidencia!");
	}
	
	public void Guardar(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			if(textUsuario.getText().equals("") || textContraseña.getText().equals("") || textCedula.getText().equals("") || textNombre.getText().equals("") || textApellido.getText().equals("") || textFE.getText().equals("") || textTelefono.getText().equals("") || textCorreo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos, excepto la confirmación de la contraseña, ya que es opcional.");
			}else {
				stm.execute("insert into Empleados(Cedula, Nombre, Apellido, Fecha_Nacimiento) values('"+textCedula.getText()+"', '"+textNombre.getText()+"', '"+textApellido.getText()+"', '"+textFE.getText()+"')");
				if(stm != null) {
					stm.execute("insert into Users(Id_Empleado, Usuario, Clave) values('"+textCedula.getText()+"','"+textUsuario.getText()+"', '"+textContraseña.getText()+"')");
					stm.execute("insert into Telefonos(Telefono, Id_Empleado) values('"+textTelefono.getText()+"', '"+textCedula.getText()+"')");
					stm.execute("insert into Email(Email, Id_Empleado) values('"+textCorreo.getText()+"', '"+textCedula.getText()+"')");
					textUsuario.setText("");
					textContraseña.setText("");
					textConfirmacion.setText("");
					textCedula.setText("");
					textNombre.setText("");
					textApellido.setText("");
					textFE.setText("");
					textTelefono.setText("");
					textCorreo.setText("");
					JOptionPane.showMessageDialog(null, "Datos guardados!");
					return;
				}
			
			}

			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
		
		
		
	}
}
