package VentaDetalle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import com.mysql.jdbc.Statement;

import Interfaz.SubVentanas;
import ventas.Ventas;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class Detalle  implements SubVentanas {
	
	private static final String Interger = null;
	private JFrame frameDetalle;
	private JLabel lblNombreCliente, lblCantidad, lblDescripcion, lblFormatoMoneda, lblPrecioUnitario, lblImporte, lblDinero, lblValorCantidad, lblValorPrecio, lblValorDescripcion, lblValorImporte;
	private JTextField textIdVenta;
	private JInternalFrame frameFacturar;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Detalle() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameDetalle = new JFrame();
		frameDetalle.setTitle("Factura");
		frameDetalle.getContentPane().setBackground(new Color(255, 255, 255));
		frameDetalle.setBounds(100, 100, 418, 375);
		frameDetalle.setVisible(true);
		frameDetalle.setLocationRelativeTo(null);
		frameDetalle.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameDetalle.getContentPane().setLayout(null);
		
		frameFacturar = new JInternalFrame("Facturar");
		frameFacturar.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		frameFacturar.setBounds(81, 167, 224, 124);
		frameDetalle.getContentPane().add(frameFacturar);
		frameFacturar.getContentPane().setLayout(null);
		
		JLabel lblIngreseID = new JLabel("Ingrese el ID de la venta:");
		lblIngreseID.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblIngreseID.setBounds(10, 11, 164, 14);
		frameFacturar.getContentPane().add(lblIngreseID);
		
		textIdVenta = new JTextField();
		textIdVenta.setBounds(10, 36, 188, 20);
		frameFacturar.getContentPane().add(textIdVenta);
		textIdVenta.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente(); 
			}
		});
		btnAceptar.setBackground(SystemColor.textHighlight);
		btnAceptar.setForeground(SystemColor.text);
		btnAceptar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAceptar.setBounds(10, 60, 89, 23);
		frameFacturar.getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFacturar.setVisible(false);
			}
		});
		btnCancelar.setForeground(SystemColor.text);
		btnCancelar.setBackground(SystemColor.textHighlight);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancelar.setBounds(109, 60, 89, 23);
		frameFacturar.getContentPane().add(btnCancelar);
		frameFacturar.setVisible(false);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 250, 154));
		separator.setBounds(10, 80, 382, 9);
		frameDetalle.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Detalle.class.getResource("/Logo/Mini-Tecno.png")));
		lblNewLabel.setBounds(0, 16, 135, 28);
		frameDetalle.getContentPane().add(lblNewLabel);
		
		lblCantidad = new JLabel("Cantidad");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCantidad.setBounds(10, 128, 67, 14);
		frameDetalle.getContentPane().add(lblCantidad);
		
		lblDescripcion = new JLabel("Descripción");
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDescripcion.setBounds(104, 121, 77, 28);
		frameDetalle.getContentPane().add(lblDescripcion);
		
		lblPrecioUnitario = new JLabel("Precio\r Unitario");
		lblPrecioUnitario.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecioUnitario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPrecioUnitario.setBounds(215, 121, 100, 28);
		frameDetalle.getContentPane().add(lblPrecioUnitario);
		
		lblImporte = new JLabel("Importe");
		lblImporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblImporte.setBounds(325, 121, 67, 28);
		frameDetalle.getContentPane().add(lblImporte);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 250, 154));
		separator_1.setBounds(10, 116, 382, 9);
		frameDetalle.getContentPane().add(separator_1);
		
		LocalDate fechaActual = LocalDate.now();
		
		
		JLabel lblFechaHora = new JLabel();
		lblFechaHora.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaHora.setText("" + fechaActual);
		lblFechaHora.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFechaHora.setBounds(309, 48, 83, 21);
		frameDetalle.getContentPane().add(lblFechaHora);
		
		JButton btnImprimir = new JButton("IMPRIMIR");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Imprimir();
			}
		});
		btnImprimir.setBackground(SystemColor.textHighlight);
		btnImprimir.setForeground(new Color(255, 255, 255));
		btnImprimir.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnImprimir.setBounds(147, 302, 107, 23);
		frameDetalle.getContentPane().add(btnImprimir);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotal.setBounds(10, 80, 67, 37);
		frameDetalle.getContentPane().add(lblTotal);
		
		JLabel lblCliente = new JLabel("Facturar A:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCliente.setBounds(10, 55, 67, 14);
		frameDetalle.getContentPane().add(lblCliente);
		
		lblNombreCliente = new JLabel("");
		lblNombreCliente.setBounds(81, 55, 143, 14);
		frameDetalle.getContentPane().add(lblNombreCliente);
		
		lblFormatoMoneda = new JLabel("RD$");
		lblFormatoMoneda.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFormatoMoneda.setBounds(247, 80, 47, 37);
		frameDetalle.getContentPane().add(lblFormatoMoneda);
		
		lblDinero = new JLabel("");
		lblDinero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDinero.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDinero.setBounds(292, 80, 100, 37);
		frameDetalle.getContentPane().add(lblDinero);
		
		lblValorCantidad = new JLabel("");
		lblValorCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorCantidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorCantidad.setBounds(20, 154, 57, 28);
		frameDetalle.getContentPane().add(lblValorCantidad);
		
		lblValorDescripcion = new JLabel("");
		lblValorDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorDescripcion.setBounds(102, 154, 91, 28);
		frameDetalle.getContentPane().add(lblValorDescripcion);
		
		lblValorPrecio = new JLabel("");
		lblValorPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorPrecio.setBounds(225, 154, 90, 28);
		frameDetalle.getContentPane().add(lblValorPrecio);
		
		lblValorImporte = new JLabel("");
		lblValorImporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblValorImporte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblValorImporte.setBounds(335, 154, 57, 28);
		frameDetalle.getContentPane().add(lblValorImporte);
		
		JButton btnFacturar = new JButton("Facturar");
		btnFacturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frameFacturar.setVisible(true);
			}
		});
		btnFacturar.setBackground(SystemColor.textHighlight);
		btnFacturar.setForeground(SystemColor.text);
		btnFacturar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnFacturar.setBounds(313, 0, 89, 23);
		frameDetalle.getContentPane().add(btnFacturar);
	}
	
	@Override
	public void Cliente() {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection conex = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectofinal", "root", "");
			
			Statement stm = (Statement) conex.createStatement();
			
			ResultSet result = stm.executeQuery("Select Ventas.Cliente, Celulares.Modelo, Ventas.Cantidad, Celulares.Precio, (Celulares.Precio * Ventas.Cantidad) as 'Monto' from DetalleVentas INNER JOIN Ventas on DetalleVentas.Id_Ventas = Ventas.ID INNER JOIN Celulares on DetalleVentas.Id_Producto = Celulares.ID where Ventas.ID = '"+textIdVenta.getText()+"'");
		
			if(textIdVenta.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Ingrese ID");
				return;
			}
			
			while(result.next()) {
				double precio = Double.parseDouble(result.getString("Celulares.Precio"));
				int cantidad = Integer.parseInt(result.getString("Ventas.Cantidad"));
				double resultado = cantidad * precio; 
				
				lblNombreCliente.setText(result.getString("Ventas.Cliente"));
				lblValorCantidad.setText(result.getString("Ventas.Cantidad"));
				lblValorDescripcion.setText(result.getString("Celulares.Modelo"));
				lblValorPrecio.setText(result.getString("Celulares.Precio"));
				lblValorImporte.setText(resultado+"");
				lblDinero.setText(resultado+"");
			}
			
			textIdVenta.setText("");
			
			frameFacturar.setVisible(false);
			
			conex.close();
			
			
		}catch(ClassNotFoundException o) {
			o.printStackTrace();
		}catch(SQLException l) {
			l.printStackTrace();
		}
		
	}

	@Override
	public void Imprimir() {
		// TODO Auto-generated method stub
		
		if(lblNombreCliente.getText().equals("") || lblValorCantidad.getText().equals("") || lblValorDescripcion.getText().equals("") || lblValorPrecio.getText().equals("") || lblValorImporte.getText().equals("") || lblDinero.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Primero debes generar los datos en Facturar");
		}else {
			
		lblNombreCliente.setText("");
		lblValorCantidad.setText("");
		lblValorDescripcion.setText("");
		lblValorPrecio.setText("");
		lblValorImporte.setText("");
		lblDinero.setText("");
		JOptionPane.showMessageDialog(null, "Factura impresa!");
		}
	}
}
