package etapa2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;



public class InputStranicaDialog extends JDialog {
	private String name;
	private String duzina;
	private String sirina;
	private String brojSlotova1;
	private String rasporedSlotova1;
	private String brojIndeksaStranice1;
	
	private JButton okButton = new JButton("Ok")	;
	private JButton cancelButton = new JButton("Cancel");
	private JLabel labela = new JLabel("Naziv:");
	private JTextField text = new JTextField();
	private JLabel dimenzijaX = new JLabel("Sirina stranice:");
	private JLabel dimenzijaY = new JLabel("Duzina stranice:");
	private JTextField textX = new JTextField();
	private JTextField textY = new JTextField();
	private JLabel brojSlotova = new JLabel("Broj slotova:");
	private JTextField textSlotovi = new JTextField();
	private JLabel raspodelaSlotova = new JLabel("Raspored dodavanja slota:");
	private String rasporedele[] = {"Horizontalno","Vertikalno"};
	private JComboBox rasporedSlotova = new JComboBox(rasporedele);
	private JLabel brojIndeksaStranice = new JLabel("Indeks stranice u dokumentu:");
	private JTextField brojIndeksaText= new JTextField();
	
	


	private boolean status;
	
	public InputStranicaDialog() {
		// TODO Auto-generated constructor stub
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Unos stranice");
		setSize(new Dimension(330,250));

		setLocationRelativeTo(null);
		okButton.setSize(new Dimension(20,20));
		okButton.addActionListener(new OkAction());
		cancelButton.setSize(new Dimension(20,20));
		cancelButton.addActionListener(new CancelAction());
		this.setLayout(new BorderLayout());
		Panel p = new Panel();
		p.setLayout(new FlowLayout());
		p.add(okButton);
		p.add(cancelButton);
		add(p,BorderLayout.SOUTH);
		Panel panelCenter = new Panel();
		panelCenter.setLayout(new BorderLayout());
		Panel plabele = new Panel();
		plabele.setLayout(new BoxLayout(plabele, BoxLayout.Y_AXIS));
		plabele.add(labela);
		plabele.add(Box.createRigidArea(new Dimension(0,5)));
		plabele.add(dimenzijaX);
		plabele.add(Box.createRigidArea(new Dimension(0,5)));

		plabele.add(dimenzijaY);
		plabele.add(Box.createRigidArea(new Dimension(0,5)));

		plabele.add(brojIndeksaStranice);
		plabele.add(Box.createRigidArea(new Dimension(0,5)));

		plabele.add(brojSlotova);
		plabele.add(Box.createRigidArea(new Dimension(0,5)));

		plabele.add(raspodelaSlotova);
		panelCenter.add(plabele,BorderLayout.WEST);
		Panel PTextFields= new Panel();
		PTextFields.setLayout(new BoxLayout(PTextFields, BoxLayout.Y_AXIS));
		PTextFields.add(text);
		PTextFields.add(textX);
		PTextFields.add(textY);
		PTextFields.add(brojIndeksaText);
		PTextFields.add(textSlotovi);
		PTextFields.add(rasporedSlotova);
		panelCenter.add(PTextFields,BorderLayout.CENTER);
		add(panelCenter,BorderLayout.NORTH);
		
	}
	
	
	public class OkAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			name = text.getText();
			duzina = textY.getText();
			sirina = textX.getText();
			brojSlotova1 = textSlotovi.getText();
			rasporedSlotova1 =(String) rasporedSlotova.getSelectedItem();
			brojIndeksaStranice1= brojIndeksaText.getText();
			
			status = true;
			setVisible(false);
		}	
	}
	public class CancelAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			status = false;
			setVisible(false);
		}
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDuzina() {
		return duzina;
	}
	public void setDuzina(String duzina) {
		this.duzina = duzina;
	}
	public String getSirina() {
		return sirina;
	}
	public void setSirina(String sirina) {
		this.sirina = sirina;
	}
	public String getBrojSlotova1() {
		return brojSlotova1;
	}
	public void setBrojSlotova1(String brojSlotova1) {
		this.brojSlotova1 = brojSlotova1;
	}
	public String getRasporedSlotova1() {
		return rasporedSlotova1;
	}
	public void setRasporedSlotova1(String rasporedSlotova1) {
		this.rasporedSlotova1 = rasporedSlotova1;
	}
	public String getBrojIndeksaStranice1() {
		return brojIndeksaStranice1;
	}
	public void setBrojIndeksaStranice1(String brojIndeksaStranice1) {
		this.brojIndeksaStranice1 = brojIndeksaStranice1;
	}
	
}
