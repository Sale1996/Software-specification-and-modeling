/***********************************************************************
 * Module:  RemoveElementAction.java
 * Author:  sale
 * Purpose: Defines the Class RemoveElementAction
 ***********************************************************************/

package etapa3.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.view.GlavniProzor;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;

/** @pdOid f7ade2e2-12c2-4101-a0ce-fe3beb486084 */
public class RemoveElementAction extends AbstractAction {
	public RemoveElementAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Element");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
				.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		
		Object o = null;
		if (sel != null) {
			o = sel.getUserObject();
		}
		
		if (sel != null){
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
			Object parent = parentNode.getUserObject();
			if(o instanceof AbstractElement){
				AbstractElement elementZaBrisati = (AbstractElement) o;
				Slot slotRoditelj = (Slot) parent;
				slotRoditelj.removeElement(elementZaBrisati);
				RemoveElementCommand komanda= new RemoveElementCommand(elementZaBrisati, slotRoditelj);
				komanda.ddo();
			}else {
				JOptionPane.showMessageDialog(null, "Izbor za brisanje nije element.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Izaberite element koji zelite obrisati.", null, JOptionPane.WARNING_MESSAGE );
		}
	}
}