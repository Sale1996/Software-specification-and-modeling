/***********************************************************************
 * Module:  ElementView.java
 * Author:  sale
 * Purpose: Defines the Class ElementView
 ***********************************************************************/

package etapa3.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import etapa1.model.events.AbstractEvent;
import etapa3.controller.EditTextElementCommand;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;
import etapa3.model.events.EventEditTextElement;

/** @pdOid 17157736-41ca-49e8-8163-5ec51dbd521e */
public class ElementView extends JPanel implements Observer {
	JTextArea textArea;
	JPanel panelElement;
	AbstractElement element;
	JButton ok;
	String textIzTextArea;
	public ElementView(AbstractElement element1) {
		element=element1;
		element.addObserver(this);
		ok=new JButton("OK");
		ok.addActionListener(new OkAction());
		textArea=new JTextArea();
		textArea.setBackground(Color.YELLOW);
		textArea.setLineWrap(true);
		panelElement=new JPanel(new BorderLayout());
		panelElement.add(ok, BorderLayout.SOUTH);
		panelElement.add(textArea, BorderLayout.CENTER);
		this.setLayout(new BorderLayout());
		this.add(new JScrollPane(panelElement), BorderLayout.CENTER);
		revalidate();
	}
	
	public class OkAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(textArea.getText().trim().length() != 0)
				textIzTextArea = textArea.getText();
				EditTextElementCommand komanda = new EditTextElementCommand(textIzTextArea, element);
				komanda.ddo();
			 	element.promeniText(textIzTextArea);
			 	
		}	
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		AbstractEvent event = (AbstractEvent) arg1;
		 if(event instanceof EventEditTextElement){
			 EventEditTextElement event1= (EventEditTextElement) event;
			 textArea.setText(event1.getNoviText());
			 this.revalidate();
		 }
		
	}
	public AbstractElement getElement() {
		return element;
	}
	public void setElement(AbstractElement element) {
		this.element = element;
	}

}