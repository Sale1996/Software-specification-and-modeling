/***********************************************************************
 * Module:  RemoveProjekatAction.java
 * Author:  sale
 * Purpose: Defines the Class RemoveProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;

/** @pdOid 350f4cee-8cba-4c1e-a7b1-5ec4a494379d */
public class RemoveProjekatAction extends AbstractAction {

	public RemoveProjekatAction(){
		putValue(NAME,"Projekat");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		// TODO Auto-generated method stub
		if(Singleton.getInstance().trenutniRadniProstor.Projekti != null && !Singleton.getInstance().trenutniRadniProstor.Projekti.isEmpty()) {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) sel.getParent();				
				Object parent = parentNode.getUserObject();
				if(o instanceof Projekat){
					Projekat projekatZaBrisati = (Projekat) o;
					RadniProstor radniProstorRoditelj = (RadniProstor) parent;
					/*
					 * ako obrisemo dokument koji je u vlasnistvu nekog projekta mi biramo novi maticni dokument od referencirajucih inace referenca se samo brise
					 * */
					if(radniProstorRoditelj == projekatZaBrisati.getMaticniRP()) {
						
						for(RadniProstor item : Singleton.getInstance().radniProstori){
							if(item != projekatZaBrisati.getMaticniRP() && item.getProjekti().contains(projekatZaBrisati))
								izbori1.add(item.getNaziv());
						}
						izbori = new String[izbori1.size()];
						izbori1.toArray(izbori);
						if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
							//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
							//jer nam i ne treba
							izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor koji ce biti maticni ovom projektu od referenci:",
							        "Brisanje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
							
							for(RadniProstor item : Singleton.getInstance().radniProstori){
								if(item.getNaziv().equals(izbor)) {
									projekatZaBrisati.setMaticniRP(item);
									break;
								}
							}
						}
						
						
					}
					
					/*
					 * Sada trebamo da proverimo da li projekat ima dokumente i ako ima, da li su ti dokmenti deljeni
					 * Ako jesu onda im biramo novi maticni projekat, ako nisu samo ih ubacujemo u listu slobodnih dokumenata!
					 * I TO RADIMO SAMO TAMO GDE JE MATICNI PROJEKAT DOKUMENTA == NASEM PROJEKUT
					 * TAKO DA DELJENJI PROJEKTI SAMO SE BRISU CAOO ZDRAVO
					 * */
					for(Dokument item1 : projekatZaBrisati.getDokumenti()){
						if(item1.getMaticniProjekat()==projekatZaBrisati){
							//znaci oho ovo je maticni projekat tog dokumenta ajde da vidimo dal je on deljen negde i da mu prebacimo
							//maticni projekat i obrisemo ga
							for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
								if(item != item1.getMaticniProjekat() && item.getDokumenti().contains(item1))
									izbori1.add(item.getNaziv());
							}
							izbori = new String[izbori1.size()];
							izbori1.toArray(izbori);
							if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
								//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
								//jer nam i ne treba
								String naslov="Brisanje dokumenta " + item1.getNaziv();

								izbor=(String) JOptionPane.showInputDialog(null, "Izaberi projekat koji ce biti maticni ovom dokumentu od referenci:",
										naslov, JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
								
								for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
									if(item.getNaziv().equals(izbor)) {
										item1.setMaticniProjekat(item);
										item.removeDokumenti(item1);
										break;
									}
								}
								izbori1.clear();
								//posto smo mu stavili novi maticni projekat mi nemamo sta vise da radimo tu to je to
							}else{
								//AKO OVDE ZAPRAVO NEMAMO NIJEDAN ZA DELJEN PROJEKAT ONDA MORMO DOKUMENT UBACITI U LISTU SLOBODNIH DOKUMENTA
								Singleton.getInstance().getSlobodniDokumenti().add(item1);
							}
						}
					}
					radniProstorRoditelj.removeProjekti(projekatZaBrisati);
				}else {
					JOptionPane.showMessageDialog(null, "Izbor za brisanje nije projekat.", null, JOptionPane.WARNING_MESSAGE );
					//ne prikazuje se kada se klikne WS i onda Delete->Project. To treba resiti.
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite projekat koji želite obrisati.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trenutno ne postoji nijedan projekat za brisanje.", null, JOptionPane.WARNING_MESSAGE );
		}
	}
}