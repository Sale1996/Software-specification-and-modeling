/***********************************************************************
 * Module:  ShareDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class ShareDokumentAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;

/** @pdOid b1cd24ea-910e-4ecb-844b-73ae70e49cd2 */
public class ShareDokumentAction extends AbstractAction {

    public ShareDokumentAction() {
    	putValue(NAME,"Dokument");
    	
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;

		if(Singleton.getInstance().trenutniRadniProstor!=null){
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				
				if (o instanceof Dokument) {
					Dokument dokumentZaDeliti = (Dokument) o;
					/*
					 * prvo smo uzeli parent cvor da vidimo da li je on maticni projekat od naseg dokumenta za deliti
					 * ako nije onda mu zabranjujemo deljenje!
					 * */
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) sel.getParent();
					Object oo = parent.getUserObject();
					Projekat daLiJeMaticni = (Projekat) oo;
					if(daLiJeMaticni == dokumentZaDeliti.getMaticniProjekat()) {
						for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
							if(item != dokumentZaDeliti.getMaticniProjekat())
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde deliti:",
						        "Deljenje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						
						for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
							if(item.getNaziv().equals(izbor))
								item.addDokumenti(dokumentZaDeliti);
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite sta zelite da podelite.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
	}
}