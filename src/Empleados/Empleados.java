package Empleados;

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

import Usuarios.Usuarios;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Empleados  {

	private JFrame frameEmpleado;
	private JPanel panelEmpleados;
	private JPanel panelEmail;
	private JPanel panelTelefonos;
	private JTextField textCedula;
	private JInternalFrame frameBorrar;
	private DefaultTableModel model, model2, model3;
	private JTextField textID;
	private JInternalFrame frameEditar;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textFN;
	private JTextField textTel;
	private JTextField textEmail;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the application.
	 */
	public Empleados() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameEmpleado = new JFrame();
		frameEmpleado.getContentPane().setBackground(new Color(255, 255, 255));
		frameEmpleado.setTitle("Empleados");
		frameEmpleado.setBounds(100, 100, 744, 708);
		frameEmpleado.setLocationRelativeTo(null);
		frameEmpleado.setVisible(true);
		frameEmpleado.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameEmpleado.getContentPane().setLayout(null);
		
		frameBorrar = new JInternalFrame("Borrar");
		frameBorrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameBorrar.setBounds(497, 363, 221, 143);
		frameBorrar.setVisible(false);
		
		frameEditar = new JInternalFrame("Editar");
		frameEditar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameEditar.setClosable(true);
		frameEditar.setBounds(20, 363, 315, 273);
		frameEmpleado.getContentPane().add(frameEditar);
		frameEditar.getContentPane().setLayout(null);
		
		JLabel lblIdEmpleado = new JLabel("Id_Empleado");
		lblIdEmpleado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdEmpleado.setBounds(10, 25, 88, 14);
		frameEditar.getContentPane().add(lblIdEmpleado);
		
		textID = new JTextField();
		textID.setBounds(10, 45, 139, 20);
		frameEditar.getContentPane().add(textID);
		textID.setColumns(10);
		
		JButton btnPull = new JButton("Pull");
		btnPull.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pull();
			}
		});
		btnPull.setForeground(SystemColor.text);
		btnPull.setBackground(SystemColor.textHighlight);
		btnPull.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPull.setBounds(159, 43, 139, 23);
		frameEditar.getContentPane().add(btnPull);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNombre.setBounds(10, 76, 88, 14);
		frameEditar.getContentPane().add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 101, 139, 20);
		frameEditar.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblApellido.setBounds(10, 132, 73, 14);
		frameEditar.getContentPane().add(lblApellido);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(10, 151, 139, 20);
		frameEditar.getContentPane().add(textApellido);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar();
			}
		});
		btnActualizar.setForeground(Color.WHITE);
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.setBackground(SystemColor.textHighlight);
		btnActualizar.setBounds(159, 182, 139, 50);
		frameEditar.getContentPane().add(btnActualizar);
		
		JLabel lblFN = new JLabel("Fecha_Nacimiento");
		lblFN.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFN.setBounds(10, 182, 118, 14);
		frameEditar.getContentPane().add(lblFN);
		
		textFN = new JTextField();
		textFN.setColumns(10);
		textFN.setBounds(10, 207, 139, 20);
		frameEditar.getContentPane().add(textFN);
		
		JLabel lblTel = new JLabel("Telefono");
		lblTel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTel.setBounds(159, 77, 88, 14);
		frameEditar.getContentPane().add(lblTel);
		
		textTel = new JTextField();
		textTel.setColumns(10);
		textTel.setBounds(159, 101, 139, 20);
		frameEditar.getContentPane().add(textTel);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(159, 151, 139, 20);
		frameEditar.getContentPane().add(textEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(159, 133, 88, 14);
		frameEditar.getContentPane().add(lblEmail);
		frameEditar.setVisible(false);
		frameEmpleado.getContentPane().add(frameBorrar);
		frameBorrar.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingrese cédula del empleado");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 11, 185, 24);
		frameBorrar.getContentPane().add(lblNewLabel);
		
		textCedula = new JTextField();
		textCedula.setBounds(10, 39, 185, 20);
		frameBorrar.getContentPane().add(textCedula);
		textCedula.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBackground(SystemColor.textHighlight);
		btnNewButton.setForeground(SystemColor.text);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AceptarBorrar();
				
				
			}
		});
		btnNewButton.setBounds(10, 70, 89, 23);
		frameBorrar.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setForeground(SystemColor.text);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameBorrar.setVisible(false);
				textCedula.setText("");
			}
		});
		btnNewButton_1.setBounds(106, 70, 89, 23);
		frameBorrar.getContentPane().add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 728, 61);
		frameEmpleado.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmpleados = new JLabel("Empleados");
		lblEmpleados.setForeground(new Color(255, 255, 255));
		lblEmpleados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblEmpleados.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpleados.setBounds(278, 11, 184, 38);
		panel.add(lblEmpleados);
		
		panelEmpleados = new JPanel();
		panelEmpleados.setBounds(10, 109, 708, 243);
		frameEmpleado.getContentPane().add(panelEmpleados);
		
		model = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						"Cedula", "Nombre", "Apellido", "Fecha_Nacimiento"
				}
				
				
				);
		panelEmpleados.setLayout(null);
		
		JTable tabla = new JTable(model);
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(0, 0, 708, 243);
		
		panelEmpleados.add(sp);
		
		panelTelefonos = new JPanel();
		panelTelefonos.setBounds(10, 391, 348, 245);
		frameEmpleado.getContentPane().add(panelTelefonos);
		panelTelefonos.setLayout(null);
		
		panelEmail = new JPanel();
		panelEmail.setBounds(368, 391, 350, 245);
		frameEmpleado.getContentPane().add(panelEmail);
		
		
		model2 = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						"Telefono", "Id_Empleado"
				}
				
				
				);
		
		JTable tabla2 = new JTable(model2);
		JScrollPane sp2 = new JScrollPane(tabla2);
		sp2.setBounds(0, 0, 348, 245);
		panelTelefonos.add(sp2);
		
	    model3 = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						"Email", "Id_Empleado"
				}
				
				
				);
		panelEmail.setLayout(null);
		JTable tabla3 = new JTable(model3);
		JScrollPane sp3 = new JScrollPane(tabla3);
		sp3.setBounds(0, 0, 350, 245);
		panelEmail.add(sp3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(SystemColor.textHighlight);
		separator.setBounds(10, 100, 708, 10);
		frameEmpleado.getContentPane().add(separator);
		
		JLabel lblDatos = new JLabel("Datos Empleados");
		lblDatos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDatos.setBounds(10, 72, 162, 26);
		frameEmpleado.getContentPane().add(lblDatos);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setForeground(SystemColor.text);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Buscar();
			}
		});
		btnBuscar.setBounds(629, 75, 89, 23);
		frameEmpleado.getContentPane().add(btnBuscar);
		
		JButton btnVer = new JButton("Ver");
		btnVer.setForeground(SystemColor.text);
		btnVer.setBackground(SystemColor.textHighlight);
		btnVer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Ver1();
			}
		});
		btnVer.setBounds(298, 363, 60, 23);
		frameEmpleado.getContentPane().add(btnVer);
		
		JButton btnVer2 = new JButton("Ver");
		btnVer2.setForeground(SystemColor.text);
		btnVer2.setBackground(SystemColor.textHighlight);
		btnVer2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVer2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ver2();
			}
		});
		btnVer2.setBounds(658, 363, 60, 23);
		frameEmpleado.getContentPane().add(btnVer2);
		
		JButton btnDelete = new JButton("Borrar");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Borrar();
			}
		});
		btnDelete.setForeground(SystemColor.text);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBackground(SystemColor.textHighlight);
		btnDelete.setBounds(530, 75, 89, 23);
		frameEmpleado.getContentPane().add(btnDelete);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEditar.setVisible(true);
				
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(431, 75, 89, 23);
		frameEmpleado.getContentPane().add(btnEditar);
		
		JMenuBar menuBar = new JMenuBar();
		frameEmpleado.setJMenuBar(menuBar);
		
		JMenu mnMas = new JMenu("Más");
		menuBar.add(mnMas);
		
		JMenuItem mntmUsers = new JMenuItem("Usuarios");
		mntmUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuarios user = new Usuarios();
			}
		});
		mnMas.add(mntmUsers);
	}
	
	
	public void Buscar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			ResultSet result = stm.executeQuery("Select Cedula, Nombre, Apellido, Fecha_Nacimiento from Empleados ");
			model.setRowCount(0);
				
			while(result.next()) {	
			
			model.addRow(new Object[] {result.getString("Cedula"), result.getString("Nombre"), result.getString("Apellido"), result.getString("Fecha_Nacimiento")});
			
			}
			
		
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Borrar() {
		
			frameBorrar.setVisible(true);	
	
		
	}
	
	public void AceptarBorrar()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			String query2 = "Delete from Email where Id_Empleado = " +textCedula.getText();
			String query3 = "Delete from Telefonos where Id_Empleado = " +textCedula.getText();
			String query4 = "Delete from users where Id_Empleado = " +textCedula.getText();
			String query = "Delete from empleados where Cedula = " +textCedula.getText();
			
			if(textCedula.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese la cédula");
				return;
			}else {
				
			stm.executeUpdate(query2);
			stm.executeUpdate(query3);
			stm.executeUpdate(query4);
			stm.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "Datos eliminados!");
			
			frameBorrar.setVisible(false);
	
			textCedula.setText("");
			
			}
			
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	public void Ver1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
		
			ResultSet result2 = stm.executeQuery("Select Telefono, Id_Empleado from Telefonos ");
			model2.setRowCount(0);
			
		
			while(result2.next()) {	
				
			model2.addRow(new Object[] {result2.getString("Telefono"), result2.getString("Id_Empleado")});
				
			}
			
			

			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Ver2() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
	
			
			ResultSet result3 = stm.executeQuery("Select Email, Id_Empleado from Email ");
			model3.setRowCount(0);
			
		
			
			while(result3.next()) {	
				
			model3.addRow(new Object[] {result3.getString("Email"), result3.getString("Id_Empleado")});
					
			}

			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Pull() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			if(textID.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe ingresar la cédula!");
				return;
			}
			
			ResultSet result = stm.executeQuery("Select Nombre, Apellido, Fecha_Nacimiento from Empleados where Cedula = '"+textID.getText()+"'");
			
			while(result.next()) {
				textNombre.setText(result.getString("Nombre"));
				textApellido.setText(result.getString("Apellido"));
				textFN.setText(result.getString("Fecha_Nacimiento"));
				
			}
			
			ResultSet result2 = stm.executeQuery("Select Telefono from Telefonos where Id_Empleado = '"+textID.getText()+"'");
			
			while(result2.next()) {
				textTel.setText(result2.getString("Telefono"));
			}
			
			ResultSet result3 = stm.executeQuery("Select Email from Email where Id_Empleado = '"+textID.getText()+"'");
			
			
			while( result3.next() ) {
				textEmail.setText(result3.getString("Email"));
			}
			
			
			
			
			
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Editar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
	
			if(textNombre.getText().equals("") || textApellido.getText().equals("") || textFN.getText().equals("") || textTel.getText().equals("") || textEmail.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Primero debe traer los datos con pull!");
				return;
			}
			else {
				
			stm.execute("Update Empleados Set Nombre = '"+textNombre.getText()+"', Apellido = '"+textApellido.getText()+"', Fecha_Nacimiento = '"+textFN.getText()+"'");
			stm.execute("Update Telefonos Set Telefono = '"+textTel.getText()+"'");
			stm.execute("Update Email Set Email = '"+textEmail.getText()+"'");
			JOptionPane.showMessageDialog(null, "Datos Actualizados!");
			textNombre.setText("");
			textApellido.setText("");
			textFN.setText("");
			textTel.setText("");
			textEmail.setText("");
			}
			

			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
}
