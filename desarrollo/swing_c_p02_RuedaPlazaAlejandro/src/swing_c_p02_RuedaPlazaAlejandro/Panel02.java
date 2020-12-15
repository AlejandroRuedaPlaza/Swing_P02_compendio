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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.ParseException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel02.
 *
 * @author Alejandro Rueda Plaza
 */
public class Panel02 extends JPanel{
	
	/** The p interno. */
	PanelInterno2 pInterno;
	
	/**
	 * Instantiates a new panel 02.
	 */
	public Panel02(){
		this.setLayout(new BorderLayout());

		pInterno= new PanelInterno2();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Datos del cliente");
        title.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(82,68,229)));
        title.setTitleColor(new Color(237,104,43));
        pInterno.setBorder(title);
		this.add(pInterno,BorderLayout.CENTER);
	}
	

}//fin de clase
class PanelInterno2 extends JPanel implements FocusListener{
	private JLabel label1,lNombre,lApellidos,lDni,lTelef,
	lFechEnt,lFechSal,lEstancia;
	private JTextField tfNomb,tfApel,
	tfFechEnt,tfEstancia;
	JTextField tfFechSal;
	private JFormattedTextField tfDni,tfTelf;
	private MaskFormatter mascaraDni,mascaraTel;
	private boolean dat1=true,dat2=true;

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public PanelInterno2(){
		this.setLayout(null);
		//JLABEL
		lNombre=new JLabel();
		lNombre.setText("Nombre: ");
		lNombre.setBounds(10,25,70,20);
		
		lApellidos=new JLabel();
		lApellidos.setText("Apellidos: ");
		lApellidos.setBounds(300,25,70,20);
		
		lDni=new JLabel();
		lDni.setText("DNI: ");
		lDni.setBounds(10,55,70,20);
		
		lTelef=new JLabel();
		lTelef.setText("Telefono: ");
		lTelef.setBounds(10,85,70,20);
		
		lFechEnt=new JLabel();
		lFechEnt.setText("Fecha Entrada: ");
		lFechEnt.setBounds(700,25,100,20);
		
		lFechSal=new JLabel();
		lFechSal.setText("Fecha Salida: ");
		lFechSal.setBounds(950,25,100,20);
		
		lEstancia=new JLabel();
		lEstancia.setText("Nº de dias de estancia: ");
		lEstancia.setBounds(700,55,170,20);
		
		
		//JTEXTFIELD
		tfNomb=new JTextField();
		tfNomb.setBounds(70,25,170,20);
		tfNomb.addFocusListener(this);
		
		tfApel=new JTextField();
		tfApel.setBounds(360,25,270,20);
		
		try {
			mascaraDni = new MaskFormatter("AAAAAAAAA");
			tfDni = new JFormattedTextField(mascaraDni);
			tfDni.setFocusLostBehavior(tfDni.COMMIT);
			tfDni.setBounds(40,55,70,20);
			
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}
		try {
			mascaraTel = new MaskFormatter("#########");
			tfTelf = new JFormattedTextField(mascaraTel);
			tfTelf.setFocusLostBehavior(tfTelf.COMMIT);
			tfTelf.setBounds(70,85,70,20);	
			
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				}

		tfFechEnt = new JTextField(LocalDateTime.now().format(formatter).toString());
		tfFechEnt.setBounds(800,25,100,20);
		tfFechEnt.addFocusListener(this);
//		tfFechEnt.setEditable(false);


		LocalDateTime maniana=LocalDateTime.now().plusDays(1);
		tfFechSal = new JTextField(maniana.format(formatter).toString());
		tfFechSal.setBounds(1040,25,100,20);
		tfFechSal.addFocusListener(this);
		
		tfEstancia=new JTextField("1");
		tfEstancia.setBounds(850,55,40,20);
		tfEstancia.setEditable(false);
		
		
		this.add(lNombre);
		this.add(tfNomb);
		this.add(lApellidos);
		this.add(tfApel);
		this.add(lDni);
		this.add(tfDni);
		this.add(lTelef);
		this.add(tfTelf);
		this.add(lFechEnt);
		this.add(tfFechEnt);
		this.add(lFechSal);
		this.add(tfFechSal);
		this.add(lEstancia);
		this.add(tfEstancia);
	}
	
	
	public void diasEntre() {
		String inputString1=tfFechEnt.getText();
		String inputString2=tfFechSal.getText();
		try {
			dat1=false;
			LocalDate date1 = LocalDate.parse(inputString1,formatter);
			dat1=true;
			dat2=false;
			LocalDate date2 = LocalDate.parse(inputString2,formatter);
			dat2=true;
			long daysBetween = ChronoUnit.DAYS.between(date1, date2);
			if(daysBetween>0) {
				tfEstancia.setText(daysBetween+"");
			}else {
				tfEstancia.setText(0+"");
				}
		}catch(Exception ex) {
			System.out.println("ERROR: "+ex);
			
			if(dat1==false) {
				lFechEnt.setForeground(Color.red);
			}
			if(dat2==false&&dat1) {
				lFechSal.setForeground(Color.red);
			}
		}
		if(dat1)
			lFechEnt.setForeground(Color.black);
		if(dat2)
			lFechSal.setForeground(Color.black);
		
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	boolean b=false;

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==tfFechEnt||e.getSource()==tfFechSal) {
			diasEntre();
		}
	}
	/**
	 * @return the tfNomb
	 */
	public JTextField getTfNomb() {
		return tfNomb;
	}
	/**
	 * @param tfNomb the tfNomb to set
	 */
	public void setTfNomb(String t) {
		this.tfNomb.setText(t);
	}
	/**
	 * @return the tfApel
	 */
	public JTextField getTfApel() {
		return tfApel;
	}
	/**
	 * @param tfApel the tfApel to set
	 */
	public void setTfApel(String t) {
		this.tfApel.setText(t);
	}
	/**
	 * @return the tfFechEnt
	 */
	public JTextField getTfFechEnt() {
		return tfFechEnt;
	}
	/**
	 * @param tfFechEnt the tfFechEnt to set
	 */
	public void setTfFechEnt(JTextField tfFechEnt) {
		this.tfFechEnt = tfFechEnt;
	}
	/**
	 * @return the tfFechSal
	 */
	public JTextField getTfFechSal() {
		return tfFechSal;
	}
	/**
	 * @param tfFechSal the tfFechSal to set
	 */
	public void setTfFechSal(String t) {
		this.tfFechSal.setText(t);
	}
	/**
	 * @return the tfDni
	 */
	public JFormattedTextField getTfDni() {
		return tfDni;
	}
	/**
	 * @param tfDni the tfDni to set
	 */
	public void setTfDni(String t) {
		this.tfDni.setText(t);
	}
	/**
	 * @return the tfTelf
	 */
	public JFormattedTextField getTfTelf() {
		return tfTelf;
	}
	/**
	 * @param tfTelf the tfTelf to set
	 */
	public void setTfTelf(String t) {
		this.tfTelf.setText(t);
	}
	/**
	 * @return the tfEstancia
	 */
	public JTextField getTfEstancia() {
		return tfEstancia;
	}
	/**
	 * @param tfEstancia the tfEstancia to set
	 */
	public void setTfEstancia(JTextField tfEstancia) {
		this.tfEstancia = tfEstancia;
	}
	/**
	 * @return the lNombre
	 */
	public JLabel getlNombre() {
		return lNombre;
	}
	/**
	 * @param lNombre the lNombre to set
	 */
	public void setlNombreC(Color c) {
		this.lNombre.setForeground(c);
	}
	/**
	 * @return the lApellidos
	 */
	public JLabel getlApellidos() {
		return lApellidos;
	}
	/**
	 * @param lApellidos the lApellidos to set
	 */
	public void setlApellidosC(Color c) {
		this.lApellidos.setForeground(c);
	}
	/**
	 * @return the lDni
	 */
	public JLabel getlDni() {
		return lDni;
	}
	/**
	 * @param lDni the lDni to set
	 */
	public void setlDniC(Color c) {
		this.lDni.setForeground(c);
	}
	/**
	 * @return the lTelef
	 */
	public JLabel getlTelef() {
		return lTelef;
	}
	/**
	 * @param lTelef the lTelef to set
	 */
	public void setlTelefC(Color c) {
		this.lTelef.setForeground(c);
	}
	/**
	 * @return the dat1
	 */
	public boolean isDat1() {
		return dat1;
	}
	/**
	 * @param dat1 the dat1 to set
	 */
	public void setDat1C(Color c) {
		this.lFechEnt.setForeground(c);
	}
	/**
	 * @return the dat2
	 */
	public boolean isDat2() {
		return dat2;
	}
	/**
	 * @param dat2 the dat2 to set
	 */
	public void setDat2C(Color c) {
		this.lFechSal.setForeground(c);
	}


	/**
	 * @return the lEstancia
	 */
	public JLabel getlEstancia() {
		return lEstancia;
	}


	/**
	 * @param lEstancia the lEstancia to set
	 */
	public void setlEstanciaC(Color c) {
		this.lEstancia.setForeground(c);
	}


}
