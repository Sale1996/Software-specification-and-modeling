/***********************************************************************
 * Module:  EditImeDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class EditImeDokumentAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa1.view.InputDialog;

/** @pdOid 8d852098-d55d-4e99-ac79-78960b4088e5 */
public class EditImeDokumentAction extends AbstractAction {

	public EditImeDokumentAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Ime dokumenta");
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
				
				
				if (o instanceof Dokument) {
					Dokument DokumentKojemMenjamoIme = (Dokument) o;
					InputDialog d = new InputDialog();
					d.setVisible(true);
					if(d.isStatus()) {	
						
						int postojiIme=0;
						
						for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.getProjekti().size(); i++) {
							for(int j=0; j<Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).dokumenti.size(); j++) {
								if(Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).dokumenti.get(j).getNaziv().equals(d.getName()))
								postojiIme=1;
							}
						}
							
						if(postojiIme!=1) {
							DokumentKojemMenjamoIme.promenaImena(d.getName());
						}else {
							JOptionPane.showMessageDialog(null, "Dokument sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}
					}
				}
			}
			
		}
	}
}