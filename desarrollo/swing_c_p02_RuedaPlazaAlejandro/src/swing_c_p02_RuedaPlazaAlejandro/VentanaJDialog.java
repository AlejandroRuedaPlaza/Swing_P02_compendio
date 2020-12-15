/*
 * Alejandro Rueda Plaza
 */
package swing_c_p02_RuedaPlazaAlejandro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
// TODO: Auto-generated Javadoc

/**
 * The Class VentanaJDialog.
 *
 * @author Alejandro Rueda Plaza
 */

public class VentanaJDialog extends JDialog implements ActionListener,FocusListener,WindowListener{
	
	/** The contenedor. */
	private Container contenedor;
	
	/** The p 1. */
	private Panel01 p1;
	
	/** The p 2. */
	private Panel02 p2;
	
	/** The p 3. */
	private Panel03 p3;
	
	/** The p 4. */
	private Panel04 p4;
	
	/** The bt guardar. */
	private JButton btImprimir,btNuevo,btGuardar;
	
	/** The label titulo. */
	private JLabel labelTitulo;
	
	/** The area de texto. */
	private JTextArea areaDeTexto;
	
	/** The texto. */
	private String texto;
	
	/** The layout. */
	private GridBagLayout layout;
	
	/** The constraints. */
	private GridBagConstraints constraints;
	
	/**
	 * Instantiates a new ventana J dialog.
	 *
	 * @param miVentanaPrincipal the mi ventana principal
	 * @param modal              the modal
	 */
	public VentanaJDialog(VentanaPrincipal miVentanaPrincipal, boolean modal){
		/*Al llamar al constructor super(), le enviamos el
		 * JFrame Padre y la propiedad booleana que determina
		 * que es hija*/
		super(miVentanaPrincipal, modal);
		contenedor=getContentPane();
		contenedor.setLayout(new BorderLayout());
   		//Asigna un titulo a la barra de titulo
		setTitle("Altas Reservas");
		constraints = new GridBagConstraints();

		this.addWindowListener(this);
		
		/*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		p1=new Panel01();
		p1.setBorder(BorderFactory.createLineBorder(new Color(249,110,67),2));
		p2=new Panel02();
		p3=new Panel03();
		p4=new Panel04();


		p2.pInterno.tfFechSal.addFocusListener(this);
		p3.setDias(Integer.parseInt(p2.pInterno.getTfEstancia().getText()));
			
		btImprimir=new JButton("Imprimir");
		Image imgI = new ImageIcon(getClass().getResource("/resource/print.png")).getImage();
  		Image newimgI = imgI.getScaledInstance(70, 80,  0);
		ImageIcon iconI = new ImageIcon(newimgI);
		btImprimir.setIcon(iconI);
		
		btNuevo=new JButton("Nuevo");
		Image imgN = new ImageIcon(getClass().getResource("/resource/new.png")).getImage();
  		Image newimgN = imgN.getScaledInstance(70, 80,  0);
		ImageIcon iconN = new ImageIcon(newimgN);
		btNuevo.setIcon(iconN);
		
		btGuardar=new JButton("Guardar");
		Image imgG = new ImageIcon(getClass().getResource("/resource/save.png")).getImage();
  		Image newimgG = imgG.getScaledInstance(70, 80,  0);
		ImageIcon iconG = new ImageIcon(newimgG);
		btGuardar.setIcon(iconG);
		
		btImprimir.addActionListener(this);
		btNuevo.addActionListener(this);
		btGuardar.addActionListener(this);
		
		
		JPanel border=new JPanel();
		layout=new GridBagLayout();
		border.setLayout(layout);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.25;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(p1, constraints);
		border.add(p1);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=0.85;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(p2, constraints);
		border.add(p2);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=1.90;
		constraints.gridwidth = GridBagConstraints.RELATIVE;
		layout.setConstraints(p3, constraints);
		border.add(p3);
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=3;
		constraints.gridwidth = GridBagConstraints.REMAINDER;
		layout.setConstraints(p4, constraints);
		border.add(p4);
		

		Box cajaH = Box.createHorizontalBox();
		cajaH.add(btImprimir);
		cajaH.add(btNuevo);
		cajaH.add(btGuardar);

		Box cajaV = Box.createVerticalBox();
		cajaV.add(cajaH);
		
		/*Agregamos los componentes al Contenedor*/

		contenedor.add(border, BorderLayout.CENTER);
		contenedor.add(cajaV,BorderLayout.SOUTH);

		//icono de la ventana
		URL iconURL = getClass().getResource("/resource/hotel.jpg");
		ImageIcon icon = new ImageIcon(iconURL);
		this.setIconImage(icon.getImage());
		
		/*tamaño de la ventana*/
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		//obtener la resolucion
		Dimension tamanioPantalla=miPantalla.getScreenSize();
		
		//obtener altura y anchura
		int altoPantalla=tamanioPantalla.height;
		int anchoPantalla=tamanioPantalla.width;
		
		setSize(anchoPantalla,altoPantalla);
		
		//pone la ventana en el Centro de la pantalla
		setLocationRelativeTo(null);
		
		
	}

	/**
	 * Datos cli.
	 *
	 * @return the string
	 */
	private String datosCli() {
		String datos="";
		datos="Nombre: "+p2.pInterno.getTfNomb().getText();
		datos+="\nApellido: "+p2.pInterno.getTfApel().getText();
		datos+="\nDNI: "+p2.pInterno.getTfDni().getText();
		datos+="\nTelefono: "+p2.pInterno.getTfTelf().getText();
		datos+="\nFecha Entrada: "+p2.pInterno.getTfFechEnt().getText();
		datos+="\nFecha Salida: "+p2.pInterno.getTfFechSal().getText();
		datos+="\nEstancia: "+p2.pInterno.getTfEstancia().getText();
		return datos;
	}
	
	/**
	 * Datos hab.
	 *
	 * @return the string
	 */
	private String datosHab() {
		String datos="";
		datos="Tipo de habitacion: "+p3.pInterno.getCbTipoHab().getSelectedItem().toString();
		datos+="\nNumero de habitaciones: "+p3.pInterno.getSpNHab().getValue().toString();
		if(p3.pInterno.getChNinios().isSelected()) {
			datos+="\nNiños: Si";
			datos+="\nEdad de niños: "+p3.pInterno.getSpEdadNi().getValue().toString();
			datos+="\nExtras: "+p3.pInterno.getTfExtra().getText().toString();
			
		}
		else {
			datos+="\nNiños: No";
		}
		if(p3.pInterno.getRbVisa().isSelected()) {
			datos+="\nTipo de Pago: "+p3.pInterno.getRbVisa().getText().toString();
		}
		else {
			datos+="\nTipo de Pago: "+p3.pInterno.getRbMasterCard().getText().toString();
		}
		datos+="\nImporte Total: "+p3.pInterno.getTfImporte().getText().toString();
		return datos;
	}

	/**
	 * Limpiar color fuente.
	 */
	private void limpiarColorFuente() {		
		
			p2.pInterno.setlNombreC(Color.black);
		
			p2.pInterno.setlApellidosC(Color.black);
		
			p2.pInterno.setlDniC(Color.black);
		
			p2.pInterno.setlTelefC(Color.black);
			
			p2.pInterno.setDat1C(Color.black);
			
			p2.pInterno.setDat2C(Color.black);
			
			p2.pInterno.setlEstanciaC(Color.black);
		
			p3.pInterno.setlPagoC(Color.black);
		
	}
	
	/**
	 * Comprobar color fuente.
	 */
	private void comprobarColorFuente() {		
		if(p2.pInterno.getTfNomb().getText().isEmpty()) {
			p2.pInterno.setlNombreC(Color.red);
		}
		else {
			p2.pInterno.setlNombreC(Color.black);
		}
		
		if(p2.pInterno.getTfApel().getText().isEmpty()) {
			p2.pInterno.setlApellidosC(Color.red);
		}
		else {
			p2.pInterno.setlApellidosC(Color.black);
		}
		
		if(p2.pInterno.getTfDni().getText().trim().isEmpty()) {
			p2.pInterno.setlDniC(Color.red);
		}
		else {
			p2.pInterno.setlDniC(Color.black);
		}
		
		if(p2.pInterno.getTfTelf().getText().trim().isEmpty()) {
			p2.pInterno.setlTelefC(Color.red);
		}
		else {
			p2.pInterno.setlTelefC(Color.black);
		}
		if(p2.pInterno.isDat1()) {
			p2.pInterno.setDat1C(Color.black);
		}
		else {
			p2.pInterno.setDat1C(Color.red);
		}
		if(p2.pInterno.isDat2()) {
			p2.pInterno.setDat2C(Color.black);
		}
		else {
			p2.pInterno.setDat2C(Color.red);
		}
				
		if(!p2.pInterno.getTfEstancia().getText().contentEquals("0")) {
			p2.pInterno.setlEstanciaC(Color.black);
		}
		else {
			p2.pInterno.setlEstanciaC(Color.red);
		}
		if(p3.pInterno.getRbVisa().isSelected()||
				p3.pInterno.getRbMasterCard().isSelected()) {
			p3.pInterno.setlPagoC(Color.black);
			
		}
		else {
			p3.pInterno.setlPagoC(Color.red);
		}
	}
	
	/**
	 * Comprobar datos.
	 *
	 * @return true, if successful
	 */
	private boolean comprobarDatos() {
		comprobarColorFuente();
		if(!p2.pInterno.getTfNomb().getText().isEmpty()&&
				!p2.pInterno.getTfApel().getText().isEmpty()&&
				!p2.pInterno.getTfDni().getText().isEmpty()&&
				!p2.pInterno.getTfTelf().getText().isEmpty()&&
				p2.pInterno.isDat1()&&
				p2.pInterno.isDat2()&&
				!p2.pInterno.getTfEstancia().getText().contentEquals("0")&&
				(p3.pInterno.getRbVisa().isSelected()||
				p3.pInterno.getRbMasterCard().isSelected())) {
			return true;
			}
		
		return false;
	}
	
	/**
	 * Rellena pestanias.
	 *
	 * @param i the i
	 * @param e the e
	 */
	private void rellenaPestanias(String i,String e) {
		p4.pestañas.removeAll();
		p4.setTexCli(i);
		p4.setTexHab(e);
		p4.cargar();
	}
	
	/**
	 * Limpiar datos.
	 */
	private void limpiarDatos() {
		limpiarColorFuente();
		//PANEL 2
		p2.pInterno.setTfNomb("");
		p2.pInterno.setTfApel("");
		p2.pInterno.setTfDni("");
		p2.pInterno.setTfTelf("");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String fecha = LocalDateTime.now().plusDays(1).format(formatter).toString();
		p2.pInterno.setTfFechSal(fecha);
		//PANEL 3
		p3.pInterno.setCbTipoHab(0);
		p3.pInterno.setSpNHab(1);
		p3.pInterno.setChNinios(false);
		p3.pInterno.setSpEdadNi(0);
		p3.pInterno.ninios.setVisible(false);
		p3.pInterno.setTfImporte(new JTextField());
		p3.pInterno.limpiarRadioGrp();
		//PANEL 4
		rellenaPestanias("","");
	}
	
	/**
	 * Action performed.
	 *
	 * @param e the e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btImprimir)	{
			if(comprobarDatos()) {
				rellenaPestanias(datosCli(),datosHab());
			}
			else {
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos corectamente", "AVISO", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource()==btNuevo)	{
			limpiarDatos();
		}
		if (e.getSource()==btGuardar)	{
			if(comprobarDatos()) {
				JOptionPane.showMessageDialog(null, "Registro Guardado", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
				limpiarDatos();
			}else {
				JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos corectamente antes de guardar", "AVISO", JOptionPane.WARNING_MESSAGE);
				
			}
		}
		
	}

	/**
	 * Focus gained.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Focus lost.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void focusLost(FocusEvent arg0) {
		p2.pInterno.diasEntre();
		if(arg0.getSource()==p2.pInterno.getTfEstancia())
			System.out.println(Integer.parseInt(p2.pInterno.getTfEstancia()+""));
			p3.pInterno.setDias(Integer.parseInt(p2.pInterno.getTfEstancia().getText()));
		
	}

	/**
	 * Window activated.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}

	/**
	 * Window closed.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Window closing.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Window deactivated.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Window deiconified.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Window iconified.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Window opened.
	 *
	 * @param arg0 the arg 0
	 */
	@Override
	public void windowOpened(WindowEvent arg0) {
		JOptionPane.showMessageDialog(null, "Formulario Abierto", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
		
	}
}
