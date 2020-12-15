/**
 * JPanel01.java
   26 nov. 2020 10:19:43
 */
package swing_c_p02_RuedaPlazaAlejandro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// TODO: Auto-generated Javadoc
/**
 * The Class Panel03.
 *
 * @author Alejandro Rueda Plaza
 */
public class Panel03 extends JPanel{
	
	/** The label 1. */
	private JLabel label1;
	
	/** The p interno. */
	PanelInterno3 pInterno;
	
	/** The dias. */
	int dias;
	
	/**
	 * Instantiates a new panel 03.
	 */
	public Panel03(){
		this.setLayout(new BorderLayout());
		pInterno= new PanelInterno3();
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Datos de la habitacion");
        title.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2,new Color(82,68,229)));
        title.setTitleColor(new Color(237,104,43));
        pInterno.setBorder(title);
		this.add(pInterno,BorderLayout.CENTER);
	}
	
	/**
	 * Sets the dias.
	 *
	 * @param d the new dias
	 */
	public void setDias(int d) {
		dias=d;
        pInterno.setDias(dias);
	}
	

}//fin de clase

class PanelInterno3 extends JPanel implements ActionListener,ChangeListener,FocusListener{

	private JLabel lTipoHab,lNHab,lNinios,
	lEdadNi,lExtra,lImporte,lImagen,lPago;
	private JComboBox cbTipoHab;
	private JSpinner spNHab,spEdadNi;
	private JCheckBox chNinios;
	private JTextField tfExtra,tfImporte;
	private JPanel pImagenes,pBotones;
	private JButton bAntes,bSiguiente;
	private JRadioButton rbVisa, rbMasterCard;
	private ButtonGroup grupoRadios;
	JPanel ninios;
	int dias,idImag;
	
	//IMAGEN 1
	private Image img1 = new ImageIcon(getClass().getResource("/resource/hotel01.jpg")).getImage();
	private Image newimg1 = img1.getScaledInstance(300, 180,  0);
	private ImageIcon icon1 = new ImageIcon(newimg1);

	//IMAGEN 2
	private Image img2 = new ImageIcon(getClass().getResource("/resource/hotel02.jpg")).getImage();
	private Image newimg2 = img2.getScaledInstance(300, 180,  0);
	private ImageIcon icon2 = new ImageIcon(newimg2);

	//IMAGEN 3
	private Image img3 = new ImageIcon(getClass().getResource("/resource/hotel03.jpg")).getImage();
	private Image newimg3 = img3.getScaledInstance(300, 180,  0);
	private ImageIcon icon3 = new ImageIcon(newimg3);
	
	public PanelInterno3(){
		
		this.setLayout(null);
		
		//JLABEL
		lTipoHab=new JLabel();
		lTipoHab.setText("Tipo de habitación: ");
		lTipoHab.setBounds(10,25,170,20);
		
		lNHab=new JLabel();
		lNHab.setText("Nº de habitaciones: ");
		lNHab.setBounds(300,25,170,20);
		
		lNinios=new JLabel();
		lNinios.setText("¿Niños?");
		lNinios.setBounds(10,140,70,20);
		
		lEdadNi=new JLabel();
		lEdadNi.setText("Edad de niños: ");
		lEdadNi.setBounds(10,30,170,20);
		
		lExtra=new JLabel();
		lExtra.setText("Extras: ");
		lExtra.setBounds(10,115,100,20);
		
		lImporte=new JLabel();
		lImporte.setText("Importe habitación: ");
		lImporte.setBounds(450,415,170,20);
		
		//COMBOBOX
		String[] opciones= {"Simple", "Doble", "Suite"};
		cbTipoHab = new JComboBox<String>(opciones);
		cbTipoHab.setBounds(150, 25, 100, 23);
		
		//SPINNER
		SpinnerNumberModel model1 = new SpinnerNumberModel(1, 0, 50, 1);
		spNHab = new JSpinner(model1);
		spNHab.setBounds(450, 25, 50, 30);
		

		SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 14, 1);
		spEdadNi = new JSpinner(model2);
		spEdadNi.setBounds(110, 30, 50, 30);
		spEdadNi.addChangeListener(this);
		
		//CHECKBOX
		chNinios=new JCheckBox();
		chNinios.setBounds(110, 140, 80, 23);
		chNinios.addActionListener(this);
		
		//JTEXTFIELD
		tfExtra=new JTextField();
		tfExtra.setBounds(70,115,170,20);
		tfExtra.setText("cuna");
		
		tfImporte=new JTextField();
		tfImporte.setBounds(580,415,80,20);
		tfImporte.addFocusListener(this);
		
		//BUTTON
		bAntes=new JButton("Anterior");
		bAntes.setBounds(0,180,150,20);
		bAntes.addActionListener(this);
		
		bSiguiente=new JButton("Siguiente");
		bSiguiente.setBounds(150,180,150,20);
		bSiguiente.addActionListener(this);
		
		//PANEL NIÑOS
		ninios=new JPanel();
		ninios.setLayout(null);
		ninios.setBounds(10,165,300,200);
		ninios.setBackground(new Color(77,138,200));
		ninios.add(lEdadNi);
		ninios.add(spEdadNi);
		ninios.add(lExtra);
		ninios.add(tfExtra);
		ninios.setVisible(false);

		//PANEL IMAGENES
		pImagenes=new JPanel();
		pImagenes.setLayout(new BorderLayout());
		pImagenes.setBounds(350,165,300,200);
		
		pBotones=new JPanel();
		pBotones.setLayout(new GridLayout());
		pBotones.add(bAntes);
		pBotones.add(bSiguiente);

		lImagen=new JLabel(icon1);
		idImag=1;
		
		pImagenes.add(lImagen,BorderLayout.CENTER);
		pImagenes.add(pBotones,BorderLayout.SOUTH);
		
		
		//METODO DE PAGO
		lPago=new JLabel();
		lPago.setText("Tipo de Pago*: ");
		lPago.setBounds(10,415,90,20);
		lPago.setToolTipText("Metodo de pago");
		
		rbVisa=new JRadioButton();
		rbVisa.setText("Visa");
		rbVisa.setBounds(100, 415, 60, 23);
		
		rbMasterCard=new JRadioButton();
		rbMasterCard.setText("MasterCard");
		rbMasterCard.setBounds(170, 415, 150, 23);
		
		grupoRadios = new ButtonGroup();
		grupoRadios.add(rbVisa);
		grupoRadios.add(rbMasterCard);
		
		
		this.add(lTipoHab);
		this.add(lNHab);
		this.add(lNinios);
		this.add(ninios);
		this.add(lImporte);
		this.add(cbTipoHab);
		this.add(spNHab);
		this.add(chNinios);
		this.add(pImagenes);
		this.add(tfImporte);
		this.add(lPago);
		this.add(rbVisa);
		this.add(rbMasterCard);
		
	}

	public void limpiarRadioGrp() {
		grupoRadios.clearSelection();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==chNinios) {
			if(chNinios.isSelected()) {
				ninios.setVisible(true);}
			else {
				ninios.setVisible(false);
			}
		}
		if(e.getSource()==bAntes) {
			switch(idImag) {
				case 1:
					lImagen.setIcon(icon3);
					idImag=3;
					break;
				case 2:
					lImagen.setIcon(icon1);
					idImag=idImag-1;
					break;
				case 3:
					lImagen.setIcon(icon2);
					idImag=idImag-1;
					break;
			}
		}
		if(e.getSource()==bSiguiente) {
			switch(idImag) {
			case 1:
				lImagen.setIcon(icon2);
				idImag=idImag+1;
				break;
			case 2:
				lImagen.setIcon(icon3);
				idImag=idImag+1;
				break;
			case 3:
				lImagen.setIcon(icon1);
				idImag=1;
				break;
		}
		}
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if(e.getSource()==spEdadNi) {
			int edad=(int)spEdadNi.getValue();
			if(edad<=3&edad>=0) {
				tfExtra.setText("cuna");
			}else if(edad<=10&edad>=4){
				tfExtra.setText("cama supletoria pequeña");
			}else if(edad<=14&edad>=11){
				tfExtra.setText("cama supletoria normal");
			}
		}
		
	}

	public void setDias(int d) {
		dias=d;
	}
	
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==tfImporte) {
			int d=dias;
			int precio=0;
			switch(cbTipoHab.getSelectedIndex()) {
			case 0:
//				System.out.println("Simple");
				precio=50;
				break;
			case 1:
//				System.out.println("Doble");
				precio=75;
				break;
			case 2:
//				System.out.println("Suite");
				precio=125;
				break;
			}
			if(chNinios.isSelected()) {
				precio+=20;
			}
			
			precio*=d;
			
			tfImporte.setText(precio+"");
			
		}
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return the cbTipoHab
	 */
	public JComboBox getCbTipoHab() {
		return cbTipoHab;
	}

	/**
	 * @param cbTipoHab the cbTipoHab to set
	 */
	public void setCbTipoHab(int i) {
		this.cbTipoHab.setSelectedIndex(i);
	}

	/**
	 * @return the spNHab
	 */
	public JSpinner getSpNHab() {
		return spNHab;
	}

	/**
	 * @param spNHab the spNHab to set
	 */
	public void setSpNHab(int i) {
		this.spNHab.setValue(1);
	}

	/**
	 * @return the spEdadNi
	 */
	public JSpinner getSpEdadNi() {
		return spEdadNi;
	}

	/**
	 * @param spEdadNi the spEdadNi to set
	 */
	public void setSpEdadNi(int i) {
		this.spEdadNi.setValue(i);
	}

	/**
	 * @return the chNinios
	 */
	public JCheckBox getChNinios() {
		return chNinios;
	}

	/**
	 * @param chNinios the chNinios to set
	 */
	public void setChNinios(boolean b) {
		this.chNinios.setSelected(b);
	}

	/**
	 * @return the tfExtra
	 */
	public JTextField getTfExtra() {
		return tfExtra;
	}

	/**
	 * @param tfExtra the tfExtra to set
	 */
	public void setTfExtra(String t) {
		this.tfExtra.setText(t);
	}

	/**
	 * @return the tfImporte
	 */
	public JTextField getTfImporte() {
		return tfImporte;
	}

	/**
	 * @param tfImporte the tfImporte to set
	 */
	public void setTfImporte(JTextField tfImporte) {
		this.tfImporte = tfImporte;
	}

	/**
	 * @return the rbVisa
	 */
	public JRadioButton getRbVisa() {
		return rbVisa;
	}

	/**
	 * @param rbVisa the rbVisa to set
	 */
	public void setRbVisa(boolean b) {
		this.rbVisa.setSelected(b);
	}

	/**
	 * @return the rbMasterCard
	 */
	public JRadioButton getRbMasterCard() {
		return rbMasterCard;
	}

	/**
	 * @param rbMasterCard the rbMasterCard to set
	 */
	public void setRbMasterCard(boolean b) {
		this.rbMasterCard.setSelected(b);
	}

	/**
	 * @return the lPago
	 */
	public JLabel getlPago() {
		return lPago;
	}

	/**
	 * @param lPago the lPago to set
	 */
	public void setlPagoC(Color c) {
		this.lPago.setForeground(c);
	}
}