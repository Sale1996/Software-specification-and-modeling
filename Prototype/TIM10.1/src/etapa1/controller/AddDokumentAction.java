/***********************************************************************
 * Module:  AddDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class AddDokumentAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa1.view.InputDialog;

/** @pdOid ef1a10a4-4048-4173-91b8-fb685e975bd5 */
public class AddDokumentAction extends AbstractAction {

	public AddDokumentAction(){
		putValue(NAME,"Document");
		
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
					Dokument noviDokument = new Dokument();
					Projekat maticniProjekat = (Projekat) o;

					InputDialog d = new InputDialog();
					d.setVisible(true);
					if(d.isStatus()) {
						int postojiIme=0;
						
						for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.getProjekti().size(); i++) {
							for(int j=0; j<Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).getDokumenti().size(); j++) {
								if(Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).dokumenti.get(j).getNaziv().equals(d.getName()))
								postojiIme=1;
							}
						}
							
						if(postojiIme!=1) {
							noviDokument.setNaziv(d.getName());
							maticniProjekat.addDokumenti(noviDokument);
						}else {
							JOptionPane.showMessageDialog(null, "Dokument sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}
					}
						
				}else {
					JOptionPane.showMessageDialog(null, "Dokument se ne može dodati ovde. Dodajte ga na projekat.", null, JOptionPane.WARNING_MESSAGE );	
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite projekat u koji želite da dodate dokument.", null, JOptionPane.WARNING_MESSAGE );	
			}
		}else {
			JOptionPane.showMessageDialog(null, "Nije moguce dodati dokument bez aktivnog radnog prostora.", null, JOptionPane.WARNING_MESSAGE );
		}
	}
}