package Usuarios;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import Empleados.Empleados;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

public class Usuarios {

	private JFrame frameUsuarios;
	private JPanel panelUsuarios;
	private JTextField textCedA;
	private JTextField textUA;
	private JTextField textCA;
	private JInternalFrame frameEditar;
	private DefaultTableModel model;

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
		frameUsuarios = new JFrame();
		frameUsuarios.getContentPane().setBackground(new Color(255, 255, 255));
		frameUsuarios.setTitle("Usuarios");
		frameUsuarios.setBounds(100, 100, 623, 407);
		frameUsuarios.setLocationRelativeTo(null);
		frameUsuarios.setVisible(true);
		frameUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameUsuarios.getContentPane().setLayout(null);
		
		frameEditar = new JInternalFrame("Editar");
		frameEditar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameEditar.setClosable(true);
		frameEditar.setBounds(131, 80, 288, 187);
		frameUsuarios.getContentPane().add(frameEditar);
		frameEditar.getContentPane().setLayout(null);
		
		JLabel lblIdEmpleado = new JLabel("Id_Empleado");
		lblIdEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdEmpleado.setBounds(10, 22, 77, 14);
		frameEditar.getContentPane().add(lblIdEmpleado);
		
		textCedA = new JTextField();
		textCedA.setBounds(10, 36, 133, 20);
		frameEditar.getContentPane().add(textCedA);
		textCedA.setColumns(10);
		
		JButton btnPull = new JButton("Pull");
		btnPull.setBackground(SystemColor.textHighlight);
		btnPull.setForeground(SystemColor.text);
		btnPull.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				pull();
			}
		});
		btnPull.setBounds(164, 35, 89, 23);
		frameEditar.getContentPane().add(btnPull);
		
		textUA = new JTextField();
		textUA.setColumns(10);
		textUA.setBounds(10, 83, 133, 20);
		frameEditar.getContentPane().add(textUA);
		
		textCA = new JTextField();
		textCA.setColumns(10);
		textCA.setBounds(10, 128, 133, 20);
		frameEditar.getContentPane().add(textCA);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsuario.setBounds(10, 68, 77, 14);
		frameEditar.getContentPane().add(lblUsuario);
		
		JLabel lblContraseña = new JLabel("Contraseña");
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblContraseña.setBounds(10, 114, 77, 14);
		frameEditar.getContentPane().add(lblContraseña);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setForeground(SystemColor.text);
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Actualizar();
			}
		});
		btnActualizar.setBounds(153, 83, 109, 65);
		frameEditar.getContentPane().add(btnActualizar);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 607, 63);
		frameUsuarios.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(223, 21, 139, 31);
		panel.add(lblNewLabel);
		
		panelUsuarios = new JPanel();
		panelUsuarios.setBounds(10, 124, 587, 233);
		frameUsuarios.getContentPane().add(panelUsuarios);
		
		
		model = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						"Id_Empleado", "Usuario", "Clave", 
				}
				
				
				);
		panelUsuarios.setLayout(null);
		
		JTable tabla = new JTable(model);
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(0, 0, 587, 233);
		
		panelUsuarios.add(sp);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(SystemColor.textHighlight);
		separator.setBounds(10, 111, 587, 2);
		frameUsuarios.getContentPane().add(separator);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEditar.setVisible(true);
			}
		});
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setForeground(SystemColor.text);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBounds(409, 90, 89, 23);
		frameUsuarios.getContentPane().add(btnEditar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setForeground(SystemColor.text);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(508, 90, 89, 23);
		frameUsuarios.getContentPane().add(btnBuscar);
		
		JLabel lblNewLabel_1 = new JLabel("Datos Usuarios");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 90, 134, 19);
		frameUsuarios.getContentPane().add(lblNewLabel_1);
		
	}
	
	
	public void Buscar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			ResultSet result = stm.executeQuery("Select Id_Empleado, Usuario, Clave from users");
			model.setRowCount(0);
			
			
			while(result.next()) {
				if(result == null) {
					JOptionPane.showMessageDialog(null, "No hay datos!");
					return;
				}
				
				model.addRow(new Object[] {result.getString("Id_Empleado"), result.getString("Usuario"), result.getString("Clave")});
			
			}
			
		
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void pull() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			if(textCedA.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese el Id_Empleado");
				return;
			}else {
				ResultSet result = stm.executeQuery("Select Usuario, Clave from users where Id_Empleado = " + textCedA.getText());
				
				while(result.next()) {
					textUA.setText(result.getString("Usuario"));
					textCA.setText(result.getString("Clave"));
				}
			
			}
			
		
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Actualizar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			if(textUA.getText().equals("") || textCedA.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Primero debe traer los datos con pull!");
				return;
			}
			else {
				
				stm.execute("update users set Usuario = '"+textUA.getText()+"', Clave = '"+textCA.getText()+"' where Id_Empleado = " + textCedA.getText());
				JOptionPane.showMessageDialog(null, "Registro actualizado!");
				textCedA.setText("");
				textUA.setText("");
				textCA.setText("");
			}
		
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
}
