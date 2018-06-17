/***********************************************************************
 * Module:  OpenSlobodniProjekatAction.java
 * Author:  sale
 * Purpose: Defines the Class OpenSlobodniProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;

/** @pdOid fe010039-93b3-4c46-a0da-a35428eca192 */
public class OpenSlobodniProjekatAction extends AbstractAction {
	public OpenSlobodniProjekatAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Slobodni projekti");
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		/*
		 * kako ce da funkcioniste :
		 * prvo korisnik ce da izabere projekat koji hoce da ubaci iz liste 
		 * slobodnih projekata pa onda bira kojem radnom prostoru ce to ubaciti pa 
		 * onda brisemo taj projekat iz one liste i ubacujemo ga u radni prostor
		 * 
		 * */
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		String izbor2;
		if(Singleton.getInstance().slobodniProjekti!=null) { //ako ima projekata u toj listi onda moze dalje
			if(Singleton.getInstance().trenutniRadniProstor != null  || Singleton.getInstance().radniProstori.size()!=0){ //ako psotoji radni prostor i projekata u njemu moze dalje
				for(Projekat item : Singleton.getInstance().getSlobodniProjekti()){
						izbori1.add(item.getNaziv());
				}
				izbori= new String[izbori1.size()];
				izbori1.toArray(izbori);
				izbor = (String) JOptionPane.showInputDialog(null, "Izaberi projekat iz liste slobodnih projekta za otvaranje:",
				        "Otvaranje projekta", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
				
				//SADA IMAMO IME DOKUMENTA IZ TE LISTE I SADA GLEDAMO IME PROJEKTA KOME OCEMO DA UBACIMO!
				izbori1.clear();
				izbori=null;
				for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
					izbori1.add(item.getNaziv());
				}
				if(Singleton.getInstance().trenutniRadniProstor !=null)
					izbori1.add(Singleton.getInstance().trenutniRadniProstor.getNaziv());
				
				izbori= new String[izbori1.size()];
				izbori1.toArray(izbori);
				izbor2 = (String) JOptionPane.showInputDialog(null, "Izaberi radni prostor kome ces dodeliti slobodni projekat:",
				        "Biranje radnog prostora", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
		
				//SADA IMAMO oba imena i dovoljno je da ubacimo jedan u drugi
				if(izbor != null && izbor2!=null){
					RadniProstor radniProstorGdeUbacujemo=null;
					Projekat slobodniProjekat=null;
					for(Projekat item : Singleton.getInstance().getSlobodniProjekti()){
						if(item.getNaziv()==izbor)
							slobodniProjekat=item;
					}
					for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
						if(item.getNaziv()==izbor2)
							radniProstorGdeUbacujemo=item;
					}
					if(radniProstorGdeUbacujemo == null)
					{
						radniProstorGdeUbacujemo=Singleton.getInstance().trenutniRadniProstor;
					}
					slobodniProjekat.setMaticniRP(radniProstorGdeUbacujemo);
					radniProstorGdeUbacujemo.addProjekti(slobodniProjekat);
					Singleton.getInstance().getSlobodniProjekti().remove(slobodniProjekat);
				}
			}
		}
	}
}