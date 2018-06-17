/***********************************************************************
 * Module:  DetachStranicaAction.java
 * Author:  Leonidas
 * Purpose: Defines the Class DetachStranicaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

/** @pdOid 1d6a17cd-5970-4015-b458-31ef578df98d */
public class DetachStranicaAction extends AbstractAction {

	public DetachStranicaAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Stranica");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
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
				
				//vidimo ako je funkcija pozvana iz selektovane stranice
				//ako jeste idemo kroz sve dokumente i njihove stranice i ako sadrze
				//istu stranicu ubacujemo u listu(naravno ako nije maticni)!
				if (o instanceof Stranica) {
					Stranica stranicaZaUkidanjeDeljenja = (Stranica) o;
					/*
					 * prvo smo uzeli parent cvor da vidimo da li je on maticni dokument od nase stranice za prekid deljenja
					 * ako nije onda mu zabranjujemo deljenje!
					 * */
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) sel.getParent();
					Object oo = parent.getUserObject();
					Dokument daLiJeMaticni = (Dokument) oo;
					izbori1.clear();
					if(daLiJeMaticni == stranicaZaUkidanjeDeljenja.getMaticniDokument()) {
						for(Dokument item : stranicaZaUkidanjeDeljenja.getDeljenUDokumentima()){
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde ces ponistiti deljenje:",
						        "Ponistavanje deljenja", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						
						for(Dokument item : stranicaZaUkidanjeDeljenja.getMaticniDokument().getMaticniProjekat().getDokumenti()){
							if(item.getNaziv().equals(izbor)) {
								item.removeStranice(stranicaZaUkidanjeDeljenja);
								
								RemoveStranicaCommand komanda= new RemoveStranicaCommand(stranicaZaUkidanjeDeljenja,item,null);
								komanda.ddo();
								
								break;
							}
						}
					}
				}
			}
		}
	}
}