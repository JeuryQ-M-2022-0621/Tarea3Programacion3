package ventas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import Empleados.Empleados;
import Interfaz.SubVentanas;
import RegistroTelefonos.RegistrarT;
import VentaDetalle.Detalle;

import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Ventas  {

	private JFrame frameVentas;
	private JPanel panelVentas;
	private JTextField textID;
	private JTextField textIdProducto;
	private JTextField textCantidad;
	private JLabel lblCantidad;
	private JTextField textCliente;
	private JTextField textIdEmpleado;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Ventas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameVentas = new JFrame();
		frameVentas.setTitle("Ventas");
		frameVentas.getContentPane().setBackground(new Color(255, 255, 255));
		frameVentas.setBounds(100, 100, 637, 469);
		frameVentas.setLocationRelativeTo(null);
		frameVentas.setVisible(true);
		frameVentas.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameVentas.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 621, 70);
		frameVentas.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblVentas = new JLabel("VENTAS");
		lblVentas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblVentas.setForeground(new Color(255, 255, 255));
		lblVentas.setHorizontalAlignment(SwingConstants.CENTER);
		lblVentas.setBounds(223, 21, 142, 38);
		panel.add(lblVentas);
		
		panelVentas = new JPanel();
		panelVentas.setBounds(10, 269, 601, 128);
		frameVentas.getContentPane().add(panelVentas);
		
		
		
		model = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						 "ID", "Id_Producto", "Fecha_Ventas", "Cantidad", "Cliente", "Id_Empleado"
				}
				
				
				);
		panelVentas.setLayout(null);
		
		JTable tabla = new JTable(model);
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(0, 0, 601, 127);
		
		panelVentas.add(sp);
		
		JPanel panelRVentas = new JPanel();
		panelRVentas.setBackground(new Color(255, 255, 255));
		panelRVentas.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 120, 215)));
		panelRVentas.setBounds(10, 122, 601, 138);
		frameVentas.getContentPane().add(panelRVentas);
		panelRVentas.setLayout(null);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblID.setBounds(10, 21, 30, 14);
		panelRVentas.add(lblID);
		
		textID = new JTextField();
		textID.setBackground(SystemColor.menu);
		textID.setBounds(10, 41, 182, 20);
		panelRVentas.add(textID);
		textID.setColumns(10);
		
		JLabel lblModelo = new JLabel("Id_Producto");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModelo.setBounds(202, 18, 110, 20);
		panelRVentas.add(lblModelo);
		
		textIdProducto = new JTextField();
		textIdProducto.setBackground(SystemColor.menu);
		textIdProducto.setColumns(10);
		textIdProducto.setBounds(202, 41, 179, 20);
		panelRVentas.add(textIdProducto);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCantidad.setBounds(10, 87, 75, 14);
		panelRVentas.add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setBackground(SystemColor.menu);
		textCantidad.setColumns(10);
		textCantidad.setBounds(10, 107, 182, 20);
		panelRVentas.add(textCantidad);
		
		JLabel lblNombrecliente = new JLabel("Cliente");
		lblNombrecliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNombrecliente.setBounds(202, 87, 75, 14);
		panelRVentas.add(lblNombrecliente);
		
		textCliente = new JTextField();
		textCliente.setBackground(SystemColor.menu);
		textCliente.setColumns(10);
		textCliente.setBounds(202, 107, 179, 20);
		panelRVentas.add(textCliente);
		
		JLabel lblIdempleado = new JLabel("Id_Empleado");
		lblIdempleado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIdempleado.setBounds(391, 18, 120, 20);
		panelRVentas.add(lblIdempleado);
		
		textIdEmpleado = new JTextField();
		textIdEmpleado.setBackground(SystemColor.menu);
		textIdEmpleado.setColumns(10);
		textIdEmpleado.setBounds(391, 41, 200, 20);
		panelRVentas.add(textIdEmpleado);
		
		JLabel lblNewLabel = new JLabel("Registrar Venta");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 100, 130, 22);
		frameVentas.getContentPane().add(lblNewLabel);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setForeground(new Color(255, 255, 255));
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Guardar();
				
			}
		});
		btnGuardar.setBounds(515, 91, 96, 31);
		frameVentas.getContentPane().add(btnGuardar);
		
		JButton btnBuscarVentas = new JButton("Buscar");
		btnBuscarVentas.setBackground(SystemColor.textHighlight);
		btnBuscarVentas.setForeground(new Color(255, 255, 255));
		btnBuscarVentas.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscarVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Buscar();
				
				
			}
		});
		btnBuscarVentas.setBounds(409, 91, 96, 31);
		frameVentas.getContentPane().add(btnBuscarVentas);
		
		JMenuBar menuBar = new JMenuBar();
		frameVentas.setJMenuBar(menuBar);
		
		JMenu mnVer = new JMenu("Ver");
		menuBar.add(mnVer);
		
		JMenuItem mntmDetalle = new JMenuItem("Detalle");
		mntmDetalle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Detalle detail = new Detalle();
			}
		});
		mnVer.add(mntmDetalle);
		
	}
	
	public void Guardar() {
		try {
			if(textID.getText().equals("") || textIdProducto.getText().equals("") || textCantidad.getText().equals("") || textCliente.getText().equals("") || textIdEmpleado.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
				return;
			}
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			ResultSet almacen = stm.executeQuery("Select Stock from Celulares where ID = " + Integer.parseInt(textIdProducto.getText()));
			
				
				while(almacen.next()) {
					
					if(Integer.parseInt(textCantidad.getText()) >  Integer.parseInt(almacen.getString("Stock"))) {
					
						JOptionPane.showMessageDialog(null, "Este producto esta agotado o pasa del limite!");
						return;
					} 
					else {
						stm.execute("insert into Ventas(ID, Id_Producto, Cantidad, Cliente, Id_Empleado) values("+Integer.parseInt(textID.getText())+", '"+textIdProducto.getText()+"',  "+Integer.parseInt(textCantidad.getText())+", '"+textCliente.getText()+"', '"+textIdEmpleado.getText()+"')");
						
						textID.setText("");
						textIdProducto.setText("");
						textCantidad.setText("");
						textCliente.setText("");
						textIdEmpleado.setText("");
						
						JOptionPane.showMessageDialog(null, "Venta registrada!");
						
					}
					
				
					
					
			}
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
	
	public void Buscar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			ResultSet result = stm.executeQuery("Select ID, Id_Producto, Fecha_Ventas, Cantidad, Cliente, Id_Empleado from ventas Order by ID desc");
			model.setRowCount(0);
			
			while(result.next()) {
				
				model.addRow(new Object[] {result.getString("ID"), result.getString("Id_Producto"), result.getString("Fecha_Ventas"), result.getString("Cantidad"), result.getString("Cliente"), result.getString("Id_Empleado")});
			
			}
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}

	
}
