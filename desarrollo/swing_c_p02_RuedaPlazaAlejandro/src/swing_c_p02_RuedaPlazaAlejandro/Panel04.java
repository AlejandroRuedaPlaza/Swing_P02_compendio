/**
 * JPanel01.java
   26 nov. 2020 10:19:43
 */
package swing_c_p02_RuedaPlazaAlejandro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;


// TODO: Auto-generated Javadoc
/**
 * The Class Panel04.
 *
 * @author Alejandro Rueda Plaza
 */
public class Panel04 extends JPanel {
	
	/** The p habitacion. */
	private JPanel pCliente,pHabitacion;
	
	/** The ja habitacion. */
	private JTextArea jaCliente,jaHabitacion;
	
	/** The texto hab. */
	private String textoCli="",textoHab="";

    /** The pestañas. */
    JTabbedPane pestañas;
	
	/**
	 * Instantiates a new panel 04.
	 */
	public Panel04(){

		this.setLayout(new BorderLayout());
//		label1=new JLabel("PANEL 4");
//		label1.setFont(new Font(label1.getName(), Font.PLAIN, 22));
		pestañas = new JTabbedPane();
        cargar();
	
	    
	   
		
	}
	
	/**
	 * Cargar.
	 */
	public void cargar() { 
	    /*propiedades Panel1*/
	    componentesPanel1();
	   	/*propiedades Panel2*/
		componentesPanel2();
	    
	    pestañas.addTab ("Datos del cliente", pCliente);
	    pestañas.addTab ("Datos de la habitacion", pHabitacion);
	
		this.add(pestañas,BorderLayout.CENTER);
		
	}
	
	/**
	 * Componentes panel 1.
	 */
	private void componentesPanel1() {
		pCliente = new JPanel();
		pCliente.setLayout(new GridLayout());
		jaCliente=new JTextArea(textoCli);
		pCliente.add(jaCliente,BorderLayout.CENTER);
		add(pCliente);
		
	}
	
	/**
	 * Sets the tex cli.
	 *
	 * @param t the new tex cli
	 */
	public void setTexCli(String t) {
		textoCli=t;
	}
	
	/**
	 * Sets the tex hab.
	 *
	 * @param t the new tex hab
	 */
	public void setTexHab(String t) {
		textoHab=t;
	}
	
	/**
	 * Componentes panel 2.
	 */
	private void componentesPanel2() {
		pHabitacion = new JPanel();

		pHabitacion.setLayout(new GridLayout());
		jaHabitacion=new JTextArea(textoHab);
		pHabitacion.add(jaHabitacion,BorderLayout.CENTER);
		
		add(pHabitacion);
	}
	
}//fin de clase

