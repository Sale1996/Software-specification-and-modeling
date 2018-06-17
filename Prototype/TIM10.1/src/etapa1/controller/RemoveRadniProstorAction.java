/***********************************************************************
 * Module:  RemoveRadniProstorAction.java
 * Author:  sale
 * Purpose: Defines the Class RemoveRadniProstorAction
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

/** @pdOid f768ffc7-c8ba-4c7e-8538-c226b95debf3 */
public class RemoveRadniProstorAction extends AbstractAction {

	public RemoveRadniProstorAction(){
		putValue(NAME,"RadniProstor");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		// TODO Auto-generated method stub
		if(Singleton.getInstance().trenutniRadniProstor!=null) {
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				if(o instanceof RadniProstor){
					RadniProstor radniProstorZaBrisati = (RadniProstor) o;
					/*
					 * Sada trebamo da proverimo da li radni prostor ima projekte i ako ima, da li su ti projekti deljeni
					 * Ako jesu onda im biramo novi maticni radni prostor, ako nisu samo ih ubacujemo u listu slobodnih projekata!
					 * I TO RADIMO SAMO TAMO GDE JE MATICNI radi prostor projekta  == NASEM radnom prostoru
					 * TAKO DA DELJENJI PROJEKTI SAMO SE BRISU CAOO ZDRAVO
					 * */
					for(Projekat item1 : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
						if(item1.getMaticniRP()==radniProstorZaBrisati){
							//znaci oho ovo je maticni projekat tog dokumenta ajde da vidimo dal je on deljen negde i da mu prebacimo
							//maticni projekat i obrisemo ga
							for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
								if(item != item1.getMaticniRP() && item.getProjekti().contains(item1))
									izbori1.add(item.getNaziv());
							}
							izbori = new String[izbori1.size()];
							izbori1.toArray(izbori);
							if(izbori1.size()!=0){ //u slucaju ako brisemo maticni i ako nemamo reference na taj projekat ova lsita ce biti prazna
								//pa da se ne bi desio exeption u inputdijalogu i for petlji mi to preskacemo 
								//jer nam i ne treba
								String naslov="Brisanje projekta " + item1.getNaziv();
								izbor=(String) JOptionPane.showInputDialog(null, "Izaberi radni prostor koji ce biti maticni ovom projektu od referenci:",
										naslov, JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
								
								for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
									if(item.getNaziv().equals(izbor)) {
										item1.setMaticniRP(item);
										item.removeProjekti(item1);
										break;
									}
								}
								//posto smo mu stavili novi maticni projekat mi nemamo sta vise da radimo tu to je to
							}else{
								//AKO OVDE ZAPRAVO NEMAMO NIJEDAN ZA DELJEN PROJEKAT ONDA MORMO DOKUMENT UBACITI U LISTU SLOBODNIH DOKUMENTA
								Singleton.getInstance().getSlobodniProjekti().add(item1);
							}
						}
					}
					Singleton.getInstance().obrisiRadniProstor(radniProstorZaBrisati);
				}else {
					JOptionPane.showMessageDialog(null, "Izbor za brisanje nije radni prostor.", null, JOptionPane.WARNING_MESSAGE );
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite radni prostor koji želite obrisati.", null, JOptionPane.WARNING_MESSAGE );
			}
		}else {
			JOptionPane.showMessageDialog(null, "Trenutno ne postoji nijedan radni prostor za brisanje.", null, JOptionPane.WARNING_MESSAGE );
		}		
	}
}