/**
 * JPanel01.java
   26 nov. 2020 10:19:43
 */
package swing_c_p02_RuedaPlazaAlejandro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel01.
 *
 * @author Alejandro Rueda Plaza
 */
public class Panel01 extends JPanel{
	
	/** The nombre hotel. */
	private JLabel label1,nombreHotel;
	
	/** The p interno. */
	PanelInterno pInterno;
	
	/**
	 * Instantiates a new panel 01.
	 */
	public Panel01(){
		
		this.setLayout(new BorderLayout());
//		label1=new JLabel("PANEL 1");
//		label1.setFont(new Font(label1.getName(), Font.PLAIN, 22));
		pInterno= new PanelInterno();
//		this.setBackground(Color.green);
        
		this.add(pInterno,BorderLayout.CENTER);
	}

}//fin de clase

class PanelInterno extends JPanel{

	private JLabel nombreHotel;
	
	public PanelInterno(){
		
		this.setLayout(new BorderLayout());
		nombreHotel=new JLabel("EL HOTEL",SwingConstants.CENTER);
		nombreHotel.setFont(new Font("Tahoma", Font.ITALIC + Font.BOLD, 34));
		nombreHotel.setForeground(new Color(249,110,67));
		this.setBackground(new Color(82,68,229));
        
		this.add(nombreHotel,BorderLayout.CENTER);
	}
}
