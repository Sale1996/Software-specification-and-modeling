/***********************************************************************
 * Module:  RemoveStranicaAction.java
 * Author:  Leonidas
 * Purpose: Defines the Class RemoveStranicaAction
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

/** @pdOid 396cd86a-73c4-4faf-8e22-7b2029d8a8a7 */
public class RemoveStranicaAction extends AbstractAction {

	public RemoveStranicaAction(){
		putValue(NAME,"Stranica");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		
		int postojiStranica=0;
		if(Singleton.getInstance().trenutniRadniProstor!=null && Singleton.getInstance().trenutniRadniProstor.Projekti != null 
		   && !Singleton.getInstance().trenutniRadniProstor.Projekti.isEmpty()) { //proverava da li su WS i Projekat uopste uneseni
			for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.Projekti.size(); i++) {//ako jesu prolazi kroz sve projekte i proveri da li nekom lista dokumenata nije prazna
				if(Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti != null && !Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti.isEmpty()) {
				   for(int j=0; j<Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti.size(); j++) {//prolaz kroz sve dokumente gde se proverava da li sadrze stranicu
					   if(Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti.get(j).stranice != null 
						  && !Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti.get(j).stranice.isEmpty()) {
						   postojiStranica=1;
					   }
				   }
				}
			}
		}
		// TODO Auto-generated method stub
		if(postojiStranica==1) {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
				Object parent = parentNode.getUserObject();
				if(o instanceof Stranica){
					Stranica stranicaZaBrisati = (Stranica) o;
					Dokument dokumentRoditelj = (Dokument) parent;
					Stranica stranicaZaDeliti=null;
					//ako se desi da obrisemo maticni a deljen je !
					
					if(dokumentRoditelj == stranicaZaBrisati.getMaticniDokument()) {
						
						for(Dokument item : dokumentRoditelj.getMaticniProjekat().getDokumenti()){
							if(item != stranicaZaBrisati.getMaticniDokument() && item.getStranice().contains(stranicaZaBrisati))
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
							//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
							//jer nam i ne treba
							izbor=(String) JOptionPane.showInputDialog(null, "Izaberi dokument koji ce biti maticni ovoj stranici od referenci:",
							        "Brisanje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
							
							for(Dokument item : dokumentRoditelj.getMaticniProjekat().getDokumenti()){
								if(item.getNaziv().equals(izbor)) {
									stranicaZaBrisati.setMaticniDokument(item);
									stranicaZaDeliti=stranicaZaBrisati;
									break;
								}
							}
						}
						
						
					}
					
					
					
					dokumentRoditelj.removeStranice(stranicaZaBrisati);
					RemoveStranicaCommand komanda = new RemoveStranicaCommand(stranicaZaBrisati,dokumentRoditelj,stranicaZaDeliti);
					komanda.ddo();
				}else {
					JOptionPane.showMessageDialog(null, "Izbor za brisanje nije stranica.", null, JOptionPane.WARNING_MESSAGE );
					//ne prikazuje se kada se klikne WS i onda Delete->Project. To treba resiti.
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite stranicu koju želite obrisati.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trenutno ne postoji nijedna stranica za brisanje.", null, JOptionPane.WARNING_MESSAGE );
		}	
	}
}