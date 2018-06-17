/***********************************************************************
 * Module:  OpenSlobodniDokumentAction.java
 * Author:  sale
 * Purpose: Defines the Class OpenSlobodniDokumentAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.ostalo.Singleton;

/** @pdOid 010089cb-5e63-4b2a-80fe-da1522691b83 */
public class OpenSlobodniDokumentAction extends AbstractAction {
	public OpenSlobodniDokumentAction() {
		putValue(NAME,"Slobodni dokument");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		/*
		 * kako ce da funkcioniste :
		 * prvo korisnik ce da izabere dokument koji hoce da ubaci iz liste 
		 * slobodnih dokumenta pa onda bira kojem projektu ce to ubaciti pa 
		 * onda brisemo taj dokument iz one liste i ubacujemo ga u projekat
		 * 
		 * */
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		String izbor2;
		if(Singleton.getInstance().slobodniDokumenti!=null) { //ako ima dokumenata u toj listi onda moze dalje
			if(Singleton.getInstance().trenutniRadniProstor != null && Singleton.getInstance().trenutniRadniProstor.getProjekti().size()!=0){ //ako psotoji radni prostor i projekata u njemu moze dalje
				for(Dokument item : Singleton.getInstance().getSlobodniDokumenti()){
						izbori1.add(item.getNaziv());
				}
				izbori= new String[izbori1.size()];
				izbori1.toArray(izbori);
				izbor = (String) JOptionPane.showInputDialog(null, "Izaberi dokument iz liste slobodnih dokumenata za otvaranje:",
				        "Otvaranje dokumenta", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
				
				//SADA IMAMO IME DOKUMENTA IZ TE LISTE I SADA GLEDAMO IME PROJEKTA KOME OCEMO DA UBACIMO!
				izbori1.clear();
				izbori=null;
				for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
					izbori1.add(item.getNaziv());
				}
				izbori= new String[izbori1.size()];
				izbori1.toArray(izbori);
				izbor2 = (String) JOptionPane.showInputDialog(null, "Izaberi projekat kome ces dodeliti slobodni dokument:",
				        "Biranje projekta", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
		
				//SADA IMAMO oba imena i dovoljno je da ubacimo jedan u drugi
				if(izbor != null && izbor2!=null){
					Projekat projekatGdeUbacujemo=null;
					Dokument slobodniDokument=null;
					for(Dokument item : Singleton.getInstance().getSlobodniDokumenti()){
						if(item.getNaziv()==izbor)
							slobodniDokument=item;
					}
					for(Projekat item : Singleton.getInstance().trenutniRadniProstor.getProjekti()){
						if(item.getNaziv()==izbor2)
							projekatGdeUbacujemo=item;
					}
					slobodniDokument.setMaticniProjekat(projekatGdeUbacujemo);
					projekatGdeUbacujemo.addDokumenti(slobodniDokument);
					Singleton.getInstance().getSlobodniDokumenti().remove(slobodniDokument);
				}
			}
		}
	}
}