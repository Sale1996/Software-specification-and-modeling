package etapa1.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import sun.reflect.annotation.TypeAnnotation.LocationInfo.Location;

public class InputDialog extends JDialog {
	private String name;
	private JButton okButton = new JButton("Ok")	;
	private JButton cancelButton = new JButton("Cancel");
	private JLabel labela = new JLabel("Naziv:");
	private JTextField text = new JTextField();
	private boolean status;
	
	public InputDialog() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setTitle("Unos imena");
		setSize(new Dimension(250,100));
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
		p = new Panel();
		p.setLayout(new BorderLayout());
		p.add(labela,BorderLayout.WEST);
		p.add(text,BorderLayout.CENTER);
		add(p,BorderLayout.NORTH);
	}
	
	
	public class OkAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			name = text.getText();
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
	



	
	
	
	

}
