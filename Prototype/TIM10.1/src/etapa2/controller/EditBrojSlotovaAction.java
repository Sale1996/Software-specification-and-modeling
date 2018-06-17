/***********************************************************************
 * Module:  EditBrojSlotovaAction.java
 * Author:  Leonidas
 * Purpose: Defines the Class EditBrojSlotovaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

/** Apsktraktna akcija za promenu broja slotova stranice
 * 
 * @pdOid 7eb55c5c-44c8-4ad0-a60c-21ee6335664b */
public class EditBrojSlotovaAction extends AbstractAction {
	public EditBrojSlotovaAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"broj slotova u stranici");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode)GlavniProzor.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		DefaultMutableTreeNode parent= null;
		Object roditelj=null;
		if(sel!=null){
			parent=(DefaultMutableTreeNode) sel.getParent();
			if(parent!=null)
				roditelj=parent.getUserObject();
		}
		
		if(sel != null) {
			Object o = sel.getUserObject();
			if(o instanceof Stranica) {
				Stranica s = (Stranica)o;
				int brojSlotova;
				try {
					brojSlotova = Integer.parseInt(JOptionPane.showInputDialog("Unesi novi broj slotova stranice:"));
					if(brojSlotova>= s.slotovi.size()){
						EditBrojSlotovaCommand komanda = new EditBrojSlotovaCommand(s,s.getBrojSlotova());
						komanda.ddo();
						s.setBrojSlotova(brojSlotova);
						
					}else{
					JOptionPane.showMessageDialog(null, "Novi broj slotova ne sme biti manji od broja trenutno postojecih slotova u stranici!", null, JOptionPane.WARNING_MESSAGE );
					}
				
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Unos indexa stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
				}
			}
		}
		
	}
}