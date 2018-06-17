/***********************************************************************
 * Module:  AddElementAction.java
 * Author:  sale
 * Purpose: Defines the Class AddElementAction
 ***********************************************************************/

package etapa3.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;

/** @pdOid f1f1c8e4-4ca8-4723-9173-6f9026790f75 */
public class AddElementAction extends AbstractAction {

	public AddElementAction() {
		putValue(NAME,"Element");
		// TODO Auto-generated constructor stub
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
				
				
				if (o instanceof Slot) {
					Slot maticniSlot = (Slot) o;
					AbstractElement element = maticniSlot.getCreator().create(); //ovde dolazi na videlo SABLON FABRIKE
					maticniSlot.addElement(element);
					AddElementCommand komanda = new AddElementCommand(element, maticniSlot);
					komanda.ddo();
				}else {
					JOptionPane.showMessageDialog(null, "Element se ne moze dodati ovde. Dodajte ga na slot.", null, JOptionPane.WARNING_MESSAGE );
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite slot na koji zelite da dodate element.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
		
	}
}