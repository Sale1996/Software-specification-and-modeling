/***********************************************************************
 * Module:  EditImeRadniProstorAction.java
 * Author:  sale
 * Purpose: Defines the Class EditImeRadniProstorAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa1.view.InputDialog;

/** @pdOid a2657e2e-f71e-42b5-8307-35826efc3143 */
public class EditImeRadniProstorAction extends AbstractAction {

	public EditImeRadniProstorAction() {
		
			putValue(NAME,"Ime radnog prostora");
			
		
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
				
				
				if (o instanceof RadniProstor) {
					RadniProstor RPKojemMenjamoIme = (RadniProstor) o;
					InputDialog d = new InputDialog();
					d.setVisible(true);
					if(d.isStatus()) {
						int postojiIme=0;
						//provera da li ime vec postoji
						if(Singleton.getInstance().radniProstori!=null) {
							for(int i=0; i<Singleton.getInstance().radniProstori.size(); i++) {
								if(Singleton.getInstance().radniProstori.get(i).getNaziv().equals(d.getName()))
									postojiIme=1;
							}
						}
						
						if(postojiIme!=1) {
							RPKojemMenjamoIme.promenaImena(d.getName());
						}else {
							JOptionPane.showMessageDialog(null, "Radni prostor sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}
					}
				}
			}
			
		}
	}
}