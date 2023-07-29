package Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import Empleados.Empleados;
import RegistroTelefonos.RegistrarT;
import RegistroUsers.Usuarios;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import javax.swing.DropMode;

public class InicioSesion {

	public JFrame frmLogin;
	private JTextField textUser;
	private JPasswordField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion login = new InicioSesion();
					login.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public InicioSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setTitle("LOGIN");
		frmLogin.setBounds(100, 100, 635, 368);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panelBienvenida = new JPanel();
		panelBienvenida.setBorder(new MatteBorder(0, 0, 0, 5, (Color) new Color(255, 255, 255)));
		panelBienvenida.setBackground(new Color(255, 255, 255));
		panelBienvenida.setBounds(0, 0, 619, 329);
		frmLogin.getContentPane().add(panelBienvenida);
		panelBienvenida.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 250, 154));
		separator.setBounds(121, 91, 442, 10);
		panelBienvenida.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(201, 107, -109, 10);
		panelBienvenida.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(InicioSesion.class.getResource("/Logo/image001.png")));
		lblNewLabel_1.setBounds(68, 9, 541, 92);
		panelBienvenida.add(lblNewLabel_1);
		
		textUser = new JTextField();
		textUser.setBounds(121, 160, 442, 29);
		panelBienvenida.add(textUser);
		textUser.setBackground(SystemColor.menu);
		textUser.setColumns(10);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(121, 225, 442, 29);
		panelBienvenida.add(textPassword);
		textPassword.setBackground(SystemColor.menu);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(120, 135, 72, 14);
		panelBienvenida.add(lblUsuario);
		lblUsuario.setForeground(new Color(0, 0, 0));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBounds(121, 200, 104, 14);
		panelBienvenida.add(lblContraseña);
		lblContraseña.setForeground(new Color(0, 0, 0));
		lblContraseña.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnComprobar = new JButton("Aceptar");
		btnComprobar.setBounds(452, 277, 111, 29);
		panelBienvenida.add(btnComprobar);
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aceptarLogin();
			}
		});
		btnComprobar.setForeground(Color.WHITE);
		btnComprobar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnComprobar.setBackground(SystemColor.textHighlight);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(121, 277, 98, 29);
		panelBienvenida.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios user = new Usuarios();
	
			}
		});
		btnRegistrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRegistrar.setForeground(new Color(255, 255, 255));
		btnRegistrar.setBackground(SystemColor.textHighlight);
		
		JButton btnEmpleados = new JButton("Empleados");
		btnEmpleados.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEmpleados.setBounds(275, 277, 119, 29);
		panelBienvenida.add(btnEmpleados);
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Empleados();
			}
		});
		btnEmpleados.setBackground(SystemColor.textHighlight);
		btnEmpleados.setForeground(new Color(255, 255, 255));
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBackground(SystemColor.textHighlight);
		panelLogin.setBounds(0, 0, 98, 329);
		panelBienvenida.add(panelLogin);
		panelLogin.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 150, 67, 31);
		panelLogin.add(lblLogin);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblLogin.setForeground(SystemColor.text);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		
		

		
	}

	public void aceptarLogin() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			ResultSet login = stm.executeQuery("Select Usuario, Clave from Users where Usuario = '"+textUser.getText()+"' and Clave = '"+ textPassword.getText()+"'");
			
			if(textUser.getText().equals("") && textPassword.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe llenar los campos!");
				return;
			}
			

			if(login.next()) {
		
					
						JOptionPane.showMessageDialog(null, "Usuario y contraseña correctos");
						RegistrarT window = new RegistrarT();
						textUser.setText("");
						textPassword.setText("");
						frmLogin.dispose();
						return;
				
					}else {
						
						textUser.setText("");
						textPassword.setText("");
						JOptionPane.showMessageDialog(null, "Usuario o contraseña incorretos");
								
				
			}
			
			
		
			conex.close();
			
			
			}catch(ClassNotFoundException o) {
				o.printStackTrace();
			}catch(SQLException l) {
				l.printStackTrace();
			}
		
	}
	
	public void Empleados() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			ResultSet loginDBA = stm.executeQuery("Select Usuario, Clave from Users where Id_Empleado = '40233579859'");
			
			while(loginDBA.next()) {
				
			
			if(textUser.getText().equals(loginDBA.getString("Usuario")) && textPassword.getText().equals(loginDBA.getString("Clave"))) {
				
				Empleados empleado = new Empleados();
				textUser.setText("");
				textPassword.setText("");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "Solo el DBA puede acceder a esta sección!");
				textUser.setText("");
				textPassword.setText("");

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
