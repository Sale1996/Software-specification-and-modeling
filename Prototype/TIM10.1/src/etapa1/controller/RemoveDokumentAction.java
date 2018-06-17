/***********************************************************************
 * Module:  RemoveDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class RemoveDokumentAction
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

/** @pdOid a392a2e5-d0d6-4433-8006-3731749740a6 */
public class RemoveDokumentAction extends AbstractAction {
	//ovi atributi sluze za biranje novog maticnog projekta ako se desi da se obrise dokument koji je dokument maticnog projekta
	String[] izbori;
	ArrayList<String> izbori1=new ArrayList<String>();
	String izbor;

	public RemoveDokumentAction(){
		putValue(NAME,"Dokument");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		int postojiDokument=0;//mozda treba dodati u model
		if(Singleton.getInstance().trenutniRadniProstor!=null && Singleton.getInstance().trenutniRadniProstor.Projekti != null 
		   && !Singleton.getInstance().trenutniRadniProstor.Projekti.isEmpty()) { //proverava da li su WS i Projekat uopste uneseni
			for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.Projekti.size(); i++) {//ako jesu prolazi kroz sve projekte i proveri da li nekom lista dokumenata nije prazna
				if(Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti != null 
				   && !Singleton.getInstance().trenutniRadniProstor.Projekti.get(i).dokumenti.isEmpty()) {
				   postojiDokument=1;
				}
			}
		}		
		
		if(postojiDokument==1) {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			if (sel != null){
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
				Object parent = parentNode.getUserObject();
				if(o instanceof Dokument){
					Dokument dokumentZaBrisati = (Dokument) o;
					Projekat projekatRoditelj =(Projekat) parent;
					/*
					 * ako obrisemo dokument koji je u vlasnistvu nekog projekta mi biramo novi maticni dokument od referencirajucih inace referenca se samo brise
					 * */
					if(projekatRoditelj == dokumentZaBrisati.getMaticniProjekat()) {
						
						for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
							if(item != dokumentZaBrisati.getMaticniProjekat() && item.getDokumenti().contains(dokumentZaBrisati))
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
							//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
							//jer nam i ne treba
							izbor=(String) JOptionPane.showInputDialog(null, "Izaberi projekat koji ce biti maticni ovom dokumentu od referenci:",
							        "Brisanje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
							
							for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
								if(item.getNaziv().equals(izbor)) {
									dokumentZaBrisati.setMaticniProjekat(item);
									break;
								}
							}
						}
						
						
					}
					projekatRoditelj.removeDokumenti(dokumentZaBrisati);
				}else {
					JOptionPane.showMessageDialog(null, "Izbor za brisanje nije dokument.", null, JOptionPane.WARNING_MESSAGE );
					//ne prikazuje se kada se klikne WS i onda Delete->Project. To treba resiti.
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite dokument koji želite obrisati.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trenutno ne postoji nijedan dokument za brisanje.", null, JOptionPane.WARNING_MESSAGE );
		}	
	}
}