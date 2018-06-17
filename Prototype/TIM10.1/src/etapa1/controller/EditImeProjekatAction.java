/***********************************************************************
 * Module:  EditImeProjekatAction.java
 * Author:  sale
 * Purpose: Defines the Class EditImeProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Projekat;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa1.view.InputDialog;

/** @pdOid b56cec54-f980-4b41-ae47-638878f95499 */
public class EditImeProjekatAction extends AbstractAction {

	public EditImeProjekatAction() {
		putValue(NAME,"Ime projekta");
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
				
				
				if (o instanceof Projekat) {
					Projekat ProjekatKojemMenjamoIme = (Projekat) o;
					InputDialog d = new InputDialog();
					d.setVisible(true);
					if(d.isStatus()) {
						int postojiIme=0;
						//provera da li ime vec postoji
						for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.getProjekti().size(); i++) {
							if(Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).getNaziv().equals(d.getName()))
								postojiIme=1;
						}
							
						if(postojiIme!=1) {
							ProjekatKojemMenjamoIme.promenaImena(d.getName());
						}else {
							JOptionPane.showMessageDialog(null, "Projekat sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}
					}
				}
			}
			
		}
	}
}