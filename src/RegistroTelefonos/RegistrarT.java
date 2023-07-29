package RegistroTelefonos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;

import Empleados.Empleados;
import Login.InicioSesion;
import ventas.Ventas;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegistrarT {

	private JFrame frmDispositivo;
	private JTextField textID;
	private JTextField textTipo;
	private JTextField textModelo;
	private JTextField textPrecio;
	private JTextField textStock;
	private JPanel panelTabla;
	private JTextField textEditar;
	private JInternalFrame frameEditar;
	private JTextField textDescripcion;
	private JTextField textMarca;
	private JInternalFrame frameFiltrar;
	private JComboBox cmbMarca, cmbTipo;
	private DefaultTableModel model;
	
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 */
	public RegistrarT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDispositivo = new JFrame();
		frmDispositivo.getContentPane().setBackground(new Color(255, 255, 255));
		frmDispositivo.setTitle("Registrar Dispositivo");
		frmDispositivo.setBounds(100, 100, 740, 561);
		frmDispositivo.dispose();
		frmDispositivo.setVisible(true);
		frmDispositivo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDispositivo.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 724, 54);
		frmDispositivo.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblRegistro = new JLabel("NUEVO DISPOSITIVO");
		lblRegistro.setForeground(SystemColor.text);
		lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblRegistro.setBounds(175, 11, 352, 32);
		panel.add(lblRegistro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new MatteBorder(1, 0, 1, 0, (Color) SystemColor.textHighlight));
		panel_1.setBounds(10, 108, 704, 183);
		frmDispositivo.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		frameFiltrar = new JInternalFrame("Filtrar");
		frameFiltrar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameFiltrar.setClosable(true);
		frameFiltrar.setBounds(425, 18, 269, 129);
		panel_1.add(frameFiltrar);
		frameFiltrar.getContentPane().setLayout(null);
		
		cmbMarca = new JComboBox();
		cmbMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
					
					Statement stm = (Statement) conex.createStatement();
						
					ResultSet result = stm.executeQuery("Select ID, Marca, Modelo, Tipo, Precio, Descripcion, Stock from Celulares where Marca = '"+cmbMarca.getSelectedItem()+"'");
					model.setRowCount(0);
				
					
					while(result.next()) {						
						model.addRow(new Object[] {result.getString("ID"), result.getString("Marca"), result.getString("Modelo"), result.getString("Tipo"),  result.getString("Precio"), result.getString("Descripcion"), result.getString("Stock")});
					
					}

		
					conex.close();
					
					
				}catch(ClassNotFoundException o) {
					o.printStackTrace();
				}catch(SQLException l) {
					l.printStackTrace();
				}
			}
		});
		cmbMarca.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione--", "OnePlus", "Xiaomi", "Samsung", "Iphone"}));
		cmbMarca.setBackground(SystemColor.textHighlight);
		cmbMarca.setForeground(SystemColor.text);
		cmbMarca.setBounds(10, 54, 115, 22);
		frameFiltrar.getContentPane().add(cmbMarca);
		
		cmbTipo = new JComboBox();
		cmbTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
					
					Statement stm = (Statement) conex.createStatement();
						
					ResultSet result = stm.executeQuery("Select ID, Marca, Modelo, Tipo, Precio, Descripcion, Stock from Celulares where Tipo = '"+cmbTipo.getSelectedItem()+"'");
					model.setRowCount(0);
				
					
					while(result.next()) {						
						model.addRow(new Object[] {result.getString("ID"), result.getString("Marca"), result.getString("Modelo"), result.getString("Tipo"),  result.getString("Precio"), result.getString("Descripcion"), result.getString("Stock")});
					
					}

		
					conex.close();
					
					
				}catch(ClassNotFoundException o) {
					o.printStackTrace();
				}catch(SQLException l) {
					l.printStackTrace();
				}
			}
		});
		cmbTipo.setModel(new DefaultComboBoxModel(new String[] {"--Seleccione--", "Celular", "Cover", "Tablet", "PC"}));
		cmbTipo.setForeground(SystemColor.text);
		cmbTipo.setBackground(SystemColor.textHighlight);
		cmbTipo.setBounds(133, 54, 110, 22);
		frameFiltrar.getContentPane().add(cmbTipo);
		
		JLabel lblFilMarca = new JLabel("Marca");
		lblFilMarca.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilMarca.setBounds(45, 29, 46, 14);
		frameFiltrar.getContentPane().add(lblFilMarca);
		
		JLabel lblFilTipo = new JLabel("Tipo");
		lblFilTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFilTipo.setBounds(164, 29, 46, 14);
		frameFiltrar.getContentPane().add(lblFilTipo);
		frameFiltrar.setVisible(false);
		
		frameEditar = new JInternalFrame("Editar");
		frameEditar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameEditar.setBounds(96, 18, 249, 151);
		panel_1.add(frameEditar);
		frameEditar.getContentPane().setLayout(null);
		
		JLabel lblEditar = new JLabel("Ingresa el ID");
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEditar.setBounds(10, 11, 114, 20);
		frameEditar.getContentPane().add(lblEditar);
		
		textEditar = new JTextField("");
		textEditar.setBounds(10, 42, 213, 20);
		frameEditar.getContentPane().add(textEditar);
		textEditar.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBackground(SystemColor.textHighlight);
		btnAceptar.setForeground(SystemColor.text);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar();
			
			}
		});
		btnAceptar.setBounds(10, 73, 101, 31);
		frameEditar.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(SystemColor.textHighlight);
		btnCancelar.setForeground(SystemColor.text);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEditar.setVisible(false);
			}
		});
		btnCancelar.setBounds(122, 73, 101, 31);
		frameEditar.getContentPane().add(btnCancelar);
		frameEditar.setVisible(false);
		
		JLabel lblID = new JLabel("ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblID.setBounds(10, 28, 46, 25);
		panel_1.add(lblID);
		
		textID = new JTextField();
		textID.setBackground(SystemColor.menu);
		textID.setBounds(10, 52, 224, 20);
		panel_1.add(textID);
		textID.setColumns(10);
		
		model = new DefaultTableModel(
				new Object[][] {
					,
				},
				
				new String[] {
						"Id", "Marca", "Modelo", "Tipo", "Descripción","Precio", "Stock"
				}
				
				
				);
		
		JTable tabla = new JTable(model);
		JScrollPane sp = new JScrollPane(tabla);
		sp.setBounds(0, 0, 704, 181);
		
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTipo.setBounds(571, 28, 46, 25);
		panel_1.add(lblTipo);
		
		textTipo = new JTextField();
		textTipo.setBackground(SystemColor.menu);
		textTipo.setColumns(10);
		textTipo.setBounds(571, 52, 123, 20);
		panel_1.add(textTipo);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModelo.setBounds(354, 28, 71, 25);
		panel_1.add(lblModelo);
		
		textModelo = new JTextField();
		textModelo.setBackground(SystemColor.menu);
		textModelo.setColumns(10);
		textModelo.setBounds(354, 52, 207, 20);
		panel_1.add(textModelo);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrecio.setBounds(10, 96, 123, 25);
		panel_1.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setBackground(SystemColor.menu);
		textPrecio.setColumns(10);
		textPrecio.setBounds(10, 120, 224, 20);
		panel_1.add(textPrecio);
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblStock.setBounds(461, 96, 123, 25);
		panel_1.add(lblStock);
		
		textStock = new JTextField();
		textStock.setBackground(SystemColor.menu);
		textStock.setColumns(10);
		textStock.setBounds(461, 120, 233, 20);
		panel_1.add(textStock);
		
		JLabel lblDesc = new JLabel("Descripción");
		lblDesc.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesc.setBounds(244, 96, 123, 25);
		panel_1.add(lblDesc);
		
		textDescripcion = new JTextField();
		textDescripcion.setBackground(SystemColor.menu);
		textDescripcion.setColumns(10);
		textDescripcion.setBounds(244, 120, 207, 20);
		panel_1.add(textDescripcion);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMarca.setBounds(244, 28, 71, 25);
		panel_1.add(lblMarca);
		
		textMarca = new JTextField();
		textMarca.setBackground(SystemColor.menu);
		textMarca.setColumns(10);
		textMarca.setBounds(244, 52, 100, 20);
		panel_1.add(textMarca);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
					
					Statement stm = (Statement) conex.createStatement();
						
					
					frameFiltrar.setVisible(true);
					conex.close();
					
					
				}catch(ClassNotFoundException o) {
					o.printStackTrace();
				}catch(SQLException l) {
					l.printStackTrace();
				}
				
			}
		});
		btnFiltrar.setBounds(615, 158, 79, 25);
		panel_1.add(btnFiltrar);
		btnFiltrar.setBackground(new Color(0, 206, 209));
		btnFiltrar.setForeground(SystemColor.text);
		btnFiltrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblDatos = new JLabel("Ingresar Datos");
		lblDatos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatos.setBounds(10, 82, 146, 25);
		frmDispositivo.getContentPane().add(lblDatos);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(SystemColor.text);
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Guardar();
				
			}
		});
		btnGuardar.setBackground(SystemColor.textHighlight);
		btnGuardar.setBounds(619, 74, 95, 33);
		frmDispositivo.getContentPane().add(btnGuardar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Buscar();
			}
		});
		btnBuscar.setBackground(SystemColor.textHighlight);
		btnBuscar.setBounds(514, 74, 95, 33);
		frmDispositivo.getContentPane().add(btnBuscar);
		
		panelTabla = new JPanel();
		panelTabla.setBackground(new Color(255, 255, 255));
		panelTabla.setBounds(10, 302, 704, 181);
		frmDispositivo.getContentPane().add(panelTabla);
		panelTabla.setLayout(null);
		panelTabla.add(sp);
		
		JButton btnUpdate = new JButton("Actualizar");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Actualizar();
			}
		});
		btnUpdate.setBounds(403, 74, 101, 33);
		frmDispositivo.getContentPane().add(btnUpdate);
		btnUpdate.setBackground(SystemColor.textHighlight);
		
		JMenuBar menuBar = new JMenuBar();
		frmDispositivo.setJMenuBar(menuBar);
		
		JMenu mas = new JMenu("Más");
		menuBar.add(mas);
		
		JMenuItem itemVentas = new JMenuItem("Ventas");
		itemVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas venta = new Ventas();
			}
		});
		mas.add(itemVentas);
		
		JMenu acciones = new JMenu("Acciones");
		menuBar.add(acciones);
		
		JMenuItem itemEditar = new JMenuItem("Editar");
		itemEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameEditar.setVisible(true);
				
				
			}
		});
		acciones.add(itemEditar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDispositivo.setVisible(false);
				InicioSesion login = new InicioSesion();
				login.frmLogin.setVisible(true);
				
			}
		});
		menuBar.add(mntmSalir);
	}
	
	public void Guardar() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();

			if(textID.getText().equals("")|| textMarca.getText().equals("") || textTipo.getText().equals("") || textModelo.getText().equals("") || textDescripcion.getText().equals("") || textPrecio.getText().equals("") || textStock.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos!");
			}
			else {
				
				
					
					stm.execute("insert into celulares values("+Integer.parseInt(textID.getText())+", '"+textMarca.getText()+"', '"+textModelo.getText()+"','"+textTipo.getText()+"', "+textPrecio.getText()+", '"+textDescripcion.getText()+"', "+Integer.parseInt(textStock.getText())+")");
					textID.setText("");
					textTipo.setText("");
					textMarca.setText("");
					textModelo.setText("");		
					textPrecio.setText("");		
					textDescripcion.setText("");
					textStock.setText("");	
					
					
					JOptionPane.showMessageDialog(null, "Se han ingresado los datos correctamente!");
					
				
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
				
			ResultSet result = stm.executeQuery("Select ID, Marca, Modelo, Tipo, Precio, Descripcion, Stock from Celulares");
			model.setRowCount(0);
		
			
			while(result.next()) {						
				model.addRow(new Object[] {result.getString("ID"), result.getString("Marca"), result.getString("Modelo"), result.getString("Tipo"), result.getString("Descripcion"), result.getString("Precio"), result.getString("Stock")});
			
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
			
			if(textID.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe ingresar el ID en Acciones > Editar antes de actualizar!");
			return;
			}else {
				
			stm.execute("Update celulares set Tipo = '"+textTipo.getText()+"', Marca = '"+textMarca.getText()+"', Modelo = '"+textModelo.getText()+"', Precio = '"+textPrecio.getText()+"', Descripcion = '"+textDescripcion.getText()+"', Stock = "+Integer.parseInt(textStock.getText())+" where ID = " + Integer.parseInt(textID.getText()));
			JOptionPane.showMessageDialog(null, "Datos actualizados!");
			textID.setText("");
			textTipo.setText("");
			textMarca.setText("");
			textModelo.setText("");
			textPrecio.setText("");
			textDescripcion.setText("");
			textStock.setText("");
			
			
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
			if(textEditar.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese el Id!");
				return;
			}
			
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
				
			ResultSet update = stm.executeQuery("Select ID, Marca, Modelo, Tipo, Precio, Descripcion, Stock from Celulares where ID = "+ Integer.parseInt(textEditar.getText()));
		
			while(update.next()) {
			
					textID.setText(update.getString("ID"));
					textMarca.setText(update.getString("Marca"));
					textModelo.setText(update.getString("Modelo"));
					textTipo.setText(update.getString("Tipo"));
					textPrecio.setText(update.getString("Precio"));
					textDescripcion.setText(update.getString("Descripcion"));
					textStock.setText(update.getString("Stock"));
					textEditar.setText("");
				

			}
			frameEditar.setVisible(false);
			
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
	}
}
