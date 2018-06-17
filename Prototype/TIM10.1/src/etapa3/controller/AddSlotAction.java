/***********************************************************************
 * Module:  AddSlotAction.java
 * Author:  sale
 * Purpose: Defines the Class AddSlotAction
 ***********************************************************************/

package etapa3.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory.Default;

import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;
import etapa3.model.Slot;
import etapa3.view.InputSlotDialog;

/** @pdOid 01596581-9e32-4e56-950a-36de49f4940f */
public class AddSlotAction extends AbstractAction {

	public AddSlotAction(){
		putValue(NAME,"Slot");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Singleton.getInstance().trenutniRadniProstor!=null) {
			
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				
				if (o instanceof Stranica) {
					Stranica maticnaStranica = (Stranica) o;
					InputSlotDialog d = new InputSlotDialog();
					d.setVisible(true);
					if(d.isStatus()){
						//ovde kazemo ako u stranici ima skoro popunjeno slotova i mi pokusamo da unesemo vise nego sto moze da primi
						//samo mu zabranimo, GDE SI KRENUO?
						if((maticnaStranica.getBrojSlotova()-maticnaStranica.getSlotovi().size())>=Integer.parseInt(d.getBrojSlotova1())){ 
							for(int i=0; i<Integer.parseInt(d.getBrojSlotova1());i++){
								Slot slot1=new Slot();
								maticnaStranica.addSlotovi(slot1);
								AddSlotCommand komanda = new AddSlotCommand(slot1, maticnaStranica);
								komanda.ddo();
							}
						}else{
							JOptionPane.showMessageDialog(null, "Unos ovolikog broja slotova prevazilazi granicu u stranici!", null, JOptionPane.WARNING_MESSAGE );	

						}
					}
				}else {
					JOptionPane.showMessageDialog(null, "Slot se ne može dodati ovde. Dodajte ga na stranicu.", null, JOptionPane.WARNING_MESSAGE );	
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite stranicu na koju zelite da dodate slot.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
	
	}
}