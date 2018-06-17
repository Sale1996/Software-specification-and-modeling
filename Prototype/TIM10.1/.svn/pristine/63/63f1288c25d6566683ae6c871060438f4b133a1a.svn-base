/***********************************************************************
 * Module:  ShareStranicaAction.java
 * Author:  Leonidas
 * Purpose: Defines the Class ShareStranicaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

/** @pdOid 043cfdc1-253c-4896-8f3c-82636860fa5f */
public class ShareStranicaAction extends AbstractAction {

	public ShareStranicaAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Stranica");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//ovde ces pozivati istu komandu kao add stranica command
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
				
				
				if (o instanceof Stranica) {
					Stranica stranicaZaDeliti = (Stranica) o;
					/*
					 * prvo smo uzeli parent cvor da vidimo da li je on maticni projekat od naseg dokumenta za deliti
					 * ako nije onda mu zabranjujemo deljenje!
					 * */
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) sel.getParent();
					Object oo = parent.getUserObject();
					Dokument daLiJeMaticni = (Dokument) oo;
					if(daLiJeMaticni == stranicaZaDeliti.getMaticniDokument()) {
						//ako je deljenje pozvano unutar maticnog dokumenta 
						//onda ulazimo u njegov maticni projekaat i izlistavamo sve dokumente na koje mozemo
						//prosiriti deljenje
						for(Dokument item : daLiJeMaticni.getMaticniProjekat().getDokumenti()){
							if(item != stranicaZaDeliti.getMaticniDokument())
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde deliti:",
						        "Deljenje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						//ovde samo nalazimo dokument koji smo izabrali da dobije nasu stranicu kao referencu
						for(Dokument item : daLiJeMaticni.getMaticniProjekat().getDokumenti()){
							if(item.getNaziv().equals(izbor)) {
								item.addStranice(stranicaZaDeliti);
								AddStranicaCommand komanda = new AddStranicaCommand(stranicaZaDeliti, item);
								komanda.ddo(); // sa ovim pozivom smo registrovali promenu za undo!
							}
						}
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite sta zelite da podelite.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
	}
}