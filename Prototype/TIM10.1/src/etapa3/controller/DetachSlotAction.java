/***********************************************************************
 * Module:  DetachSlotAction.java
 * Author:  sale
 * Purpose: Defines the Class DetachSlotAction
 ***********************************************************************/

package etapa3.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.controller.RemoveStranicaCommand;
import etapa2.model.Stranica;
import etapa3.model.Slot;

/** @pdOid df424a05-5ab9-4977-b745-a0c8844098cf */
public class DetachSlotAction extends AbstractAction {

	public DetachSlotAction() {
		putValue(NAME,"Slot");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

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
				if (o instanceof Slot) {
					Slot slotZaUkidanjeDeljenja = (Slot) o;
					/*
					 * prvo smo uzeli parent cvor da vidimo da li je on maticni dokument od nase stranice za prekid deljenja
					 * ako nije onda mu zabranjujemo deljenje!
					 * */
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) sel.getParent();
					Object oo = parent.getUserObject();
					Stranica daLiJeMaticni = (Stranica) oo;
					izbori1.clear();
					if(daLiJeMaticni == slotZaUkidanjeDeljenja.getMaticnaStranica()) {
						for(Stranica item : slotZaUkidanjeDeljenja.getSadrzanUStranicama()){
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde ces ponistiti deljenje:",
						        "Ponistavanje deljenja", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						
						for(Stranica item : slotZaUkidanjeDeljenja.getSadrzanUStranicama()){
							if(item.getNaziv().equals(izbor)) {
								item.removeSlotovi(slotZaUkidanjeDeljenja);
								
								RemoveSlotCommand komanda= new RemoveSlotCommand(slotZaUkidanjeDeljenja,item,null);
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