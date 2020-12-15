/*
 * Alejandro Rueda Plaza
 */
package swing_c_p02_RuedaPlazaAlejandro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;

import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaPrincipal.
 *
 * @author Alejandro Rueda Plaza
 */

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	/** The contenedor. */
	private Container contenedor;/*declaramos el contenedor*/
	
	/** The bt baja. */
	JButton btAlta,btBaja;
	
	/** The label vacia. */
	JLabel labelTitulo,labelVacia;
	
	/** The mi ventana principal. */
	private VentanaPrincipal miVentanaPrincipal;
	
	/** The barra menu. */
	private JMenuBar barraMenu;
	
	/** The menu ayuda. */
	private JMenu menuArchivo,menuRegistro,menuAyuda;
    
    /** The Acerca de. */
    private JMenuItem menuSalir,menuAltas,menuBajas,AcercaDe;
	
	/** The informacion aplicacion. */
	String informacionAplicacion="";
	
	/**
	 * Instantiates a new ventana principal.
	 */
	public VentanaPrincipal(){
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
		
		setSize(anchoPantalla/2,altoPantalla/2);
		
		/**/
		/*permite iniciar las propiedades de los componentes*/
		iniciarComponentes();
   		/*Asigna un titulo a la barra de titulo*/
		setTitle("Gestión Hotel ElHotel");
		/*pone la ventana en el Centro de la pantalla*/
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Sets the ventana principal.
	 *
	 * @param miVentana Enviamos una instancia de la ventana principal
	 */
	public void setVentanaPrincipal(VentanaPrincipal miVentana) {
		miVentanaPrincipal=miVentana;
	}

	/**
	 * Iniciar componentes.
	 */
	private void iniciarComponentes() {
		contenedor=getContentPane();/*instanciamos el contenedor*/
		/*con esto definmos nosotros mismos los tamaños y posicion
		 * de los componentes*/
		contenedor.setLayout(new BorderLayout());
		barraMenu = new JMenuBar();
		
		menuArchivo = new JMenu();
		menuSalir = new JMenuItem();
		
		menuRegistro = new JMenu();
		menuAltas = new JMenuItem();
		menuBajas = new JMenuItem();
	        
		menuAyuda = new JMenu();
		AcercaDe = new JMenuItem();
		
	    /*Crea los items del menu Acerca De...*/
		menuSalir.setText("Salir");
	    menuArchivo.add(menuSalir);
	    menuSalir.addActionListener(this);
	    
	    menuArchivo.setText("Archivo");
	    barraMenu.add(menuArchivo);


	    menuAltas.setText("Altas");
		menuRegistro.add(menuAltas);
		menuAltas.addActionListener(this);

		menuBajas.setText("Bajas");
		menuRegistro.add(menuBajas);
		menuBajas.addActionListener(this);
		
	    menuRegistro.setText("Registro");
	    barraMenu.add(menuRegistro);
	    

	    AcercaDe.setText("Acerca de...");
	    menuAyuda.add(AcercaDe);
	    AcercaDe.addActionListener(this);
		
		menuAyuda.setText("Ayuda");
	    barraMenu.add(menuAyuda);
	    
	    setJMenuBar(barraMenu);
		
		/*Propiedades del boton, lo instanciamos, posicionamos y
		 * activamos los eventos*/

	    
	    btAlta= new JButton();
	    
	  //redimension de imagenes
  		Image img1 = new ImageIcon(getClass().getResource("/resource/add-hotel-symbol.png")).getImage();
  		Image newimg = img1.getScaledInstance(70, 80,  0);
		ImageIcon icon = new ImageIcon(newimg);
		btAlta.setIcon(icon);
		btAlta.addActionListener(this);
		
		Image img2 = new ImageIcon(getClass().getResource("/resource/delete-hotel-symbol.png")).getImage();
  		Image newimg2 = img2.getScaledInstance(70, 80,  0);
		ImageIcon icon2 = new ImageIcon(newimg2);
		btBaja= new JButton();
		btBaja.setIcon(icon2);
		btBaja.addActionListener(this);
		
		/////////////////////////////////////
		
		/*Propiedades del Label, lo instanciamos, posicionamos y
		 * activamos los eventos*/
		labelTitulo= new JLabel();
		labelTitulo.setFont(new Font("Tahoma", Font.ITALIC, 20));
		labelTitulo.setForeground(new Color(237,104,43));
		labelTitulo.setText("EL HOTEL");
		
		labelVacia= new JLabel();
		

		menuRegistro.setMnemonic(KeyEvent.VK_R);
		btAlta.setMnemonic(KeyEvent.VK_A);
		btBaja.setMnemonic(KeyEvent.VK_B);
				
		
		/*Agregamos los componentes al Contenedor*/
		JPanel pTit=new JPanel(new FlowLayout());
		pTit.add(labelTitulo);
		
		
		Box cajaH = Box.createHorizontalBox();
		cajaH.add(btAlta);
		cajaH.add(Box.createHorizontalStrut(10));
		cajaH.add(btBaja);
		
		Box cajaV = Box.createVerticalBox();
		cajaV.add(pTit, BorderLayout.SOUTH);
		cajaV.add(cajaH);

		JPanel contenido=new JPanel(new FlowLayout());
		contenido.add(cajaV);
		
		JPanel PanelVacio=new JPanel(new FlowLayout());
		PanelVacio.add(labelVacia);
		
		
		contenedor.add(PanelVacio,BorderLayout.NORTH);
		contenedor.add(contenido,BorderLayout.CENTER);
	}

	/**
	 * Action performed.
	 *
	 * @param evento the evento
	 */
	/*Agregamos el evento al momento de llamar la otra ventana*/
	@Override
	public void actionPerformed(ActionEvent evento) {
		if (evento.getSource()==btAlta||evento.getSource()==menuAltas)
		{
			VentanaJDialog miClaseJDialog=new VentanaJDialog(miVentanaPrincipal,true);
			miClaseJDialog.setVisible(true);
		}
		if (evento.getSource()==btBaja||evento.getSource()==menuBajas)
		{
			JOptionPane.showMessageDialog(null, "Opcion no desarrollada", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
		}
		if (evento.getSource()==menuSalir) {
			this.dispose();
		}
		if (evento.getSource()==AcercaDe) {
			String texto="Aplicacion desarrollada para el hotel \"EL HOTEL\", \n esta aplicacion a sido "
					+ "desarrollada para el modulo \nde Interfaces Graficas."
					+ "\n\n\nAutor: Alejandro Rueda Plaza";
			JOptionPane.showMessageDialog(null, texto, "ACERCA DE...", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
