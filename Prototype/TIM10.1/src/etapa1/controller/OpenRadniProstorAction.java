/***********************************************************************
 * Module:  OpenRadniProstorAction.java
 * Author:  sale
 * Purpose: Defines the Class OpenRadniProstorAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;

/** @pdOid 368ffb93-dfb3-41b1-ab4b-1b6119f98a83 */
public class OpenRadniProstorAction extends AbstractAction {
	public OpenRadniProstorAction() {
		putValue(NAME,"Otvori radni prostor");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		/*
		 * kako je ovo radjeno prvo smo napravili praznu listu stringa izbori
		 * pa smo onda napravili array listu jer kada idemo kroz foreach jedino tako mozemo lepo ubacivati u listu
		 * e sada kada smo ubacili sve radne prostre tj njihove nazive u tu listu 
		 * tu listu konvertujemo u niz stringova i taj niz ubacujemo u dijalog koji generise izbor korisniku sta ce da izabere 
		 * od radnih prostora 
		 * i kada je izabrao prolazimo jos jednom kroz tu listu i tu nalazimo sta je izabrao i taj radni prostor otvaramo!
		 * */
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		if(Singleton.getInstance().radniProstori!=null) {
			if(Singleton.getInstance().trenutniRadniProstor == null){
				for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
						izbori1.add(item.getNaziv());
				}
				izbori= new String[izbori1.size()];
				izbori1.toArray(izbori);
				izbor = (String) JOptionPane.showInputDialog(null, "Izaberi radni prostor za otvaranje:",
				        "Otvaranje radnog prostora", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
				
				for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
					if(item.getNaziv().equals(izbor))
						Singleton.getInstance().openRadniProstor(item);
				}
			}
		}
	}
}