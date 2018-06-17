/***********************************************************************
 * Module:  RemoveSlotAction.java
 * Author:  sale
 * Purpose: Defines the Class RemoveSlotAction
 ***********************************************************************/

package etapa3.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;
import etapa3.model.Slot;

/** @pdOid dc84142d-225b-4907-9ad0-42bf94c2b50f */
public class RemoveSlotAction extends AbstractAction {
	public RemoveSlotAction() {
		putValue(NAME, "Slot");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		// TODO Auto-generated method stub
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
				.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		
		Object o = null;
		if (sel != null) {
			o = sel.getUserObject();
		}
		
		if (sel != null){
			DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
			Object parent = parentNode.getUserObject();
			if(o instanceof Slot){
				Slot slotZaBrisati = (Slot) o;
				Stranica stranicaRoditelj = (Stranica) parent;
				Slot deljeniSlot=null;
				
				//ako se desi da obrisemo maticni a deljen je !
				
				if(stranicaRoditelj == slotZaBrisati.getMaticnaStranica()) {
					
					for(Stranica item : stranicaRoditelj.getMaticniDokument().getStranice()){
						if(item != slotZaBrisati.getMaticnaStranica() && item.getSlotovi().contains(slotZaBrisati))
							izbori1.add(item.getNaziv());
					}
					izbori = new String[izbori1.size()];
					izbori1.toArray(izbori);
					if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
						//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
						//jer nam i ne treba
						izbor=(String) JOptionPane.showInputDialog(null, "Izaberi dokument koji ce biti maticni ovoj stranici od referenci:",
						        "Brisanje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
						
						for(Stranica item : stranicaRoditelj.getMaticniDokument().getStranice()){
							if(item.getNaziv().equals(izbor)) {
								slotZaBrisati.setMaticnaStranica(item);
								deljeniSlot=slotZaBrisati;
								break;
							}
						}
					}
					
					
				}
				
				
				stranicaRoditelj.removeSlotovi(slotZaBrisati);
				RemoveSlotCommand komanda= new RemoveSlotCommand(slotZaBrisati,stranicaRoditelj,deljeniSlot);
				komanda.ddo();
			}else {
				JOptionPane.showMessageDialog(null, "Izbor za brisanje nije slot.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trenutno ne postoji nijedan slot za brisanje.", null, JOptionPane.WARNING_MESSAGE );
		}
	}
}