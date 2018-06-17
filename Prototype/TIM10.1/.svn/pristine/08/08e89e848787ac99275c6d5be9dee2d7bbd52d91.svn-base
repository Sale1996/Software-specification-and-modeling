/***********************************************************************
 * Module:  DetachDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class DetachDokumentAction
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

/** @pdOid eeec03c8-a339-4b62-9c86-a22bb26f8e15 */
public class DetachDokumentAction extends AbstractAction {
	String[] izbori;
	ArrayList<String> izbori1=new ArrayList<String>();
	String izbor;
	
	public DetachDokumentAction() {
		putValue(NAME,"Dokument");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(Singleton.getInstance().trenutniRadniProstor!=null){
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				//vidimo ako je funkcija pozvana iz selektovanog dokumenta
				//ako jeste idemo kroz sve projekte i njihove dokumente i ako sadrze
				//isti dokument brisemo ga (naravno ako nije maticni)!
				if (o instanceof Dokument) {
					Dokument dokumentZaUkidanjeDeljenja = (Dokument) o;
					/*
					 * prvo smo uzeli parent cvor da vidimo da li je on maticni projekat od naseg dokumenta za prekid deljenja
					 * ako nije onda mu zabranjujemo deljenje!
					 * */
					DefaultMutableTreeNode parent = (DefaultMutableTreeNode) sel.getParent();
					Object oo = parent.getUserObject();
					Projekat daLiJeMaticni = (Projekat) oo;
					izbori1.clear();
					if(daLiJeMaticni == dokumentZaUkidanjeDeljenja.getMaticniProjekat()) {
						for(Projekat item : dokumentZaUkidanjeDeljenja.getDeljenUProjektima()){
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde ces ponistiti deljenje:",
						        "Ponistavanje deljenja", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						
						for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
							if(item.getNaziv().equals(izbor)) {
								item.removeDokumenti(dokumentZaUkidanjeDeljenja);
								break;
							}
						}
					}
				}
					
			}
				
		
		}
	}
}