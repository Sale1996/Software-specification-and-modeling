/***********************************************************************
 * Module:  AddRadniProstorAction.java
 * Author:  sale
 * Purpose: Defines the Class AddRadniProstorAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.InputDialog;

/** @pdOid 4ba58419-4ceb-4126-8c56-bde1648d39af */
public class AddRadniProstorAction extends AbstractAction {
	
	public AddRadniProstorAction(){
		putValue(NAME,"Workspace");
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
		
		
		if(Singleton.getInstance().trenutniRadniProstor==null) {
			RadniProstor radniProstorZaDodati = new RadniProstor();
			InputDialog d = new InputDialog();
			d.setVisible(true);
			if(d.isStatus()) {
				
				int postojiIme=0;
				//provera da li ime vec postoji
				if(Singleton.getInstance().radniProstori!=null) {
					for(int i=0; i<Singleton.getInstance().radniProstori.size(); i++) {
						if(Singleton.getInstance().radniProstori.get(i).getNaziv().equals(d.getName()))
							postojiIme=1;
					}
				}
				
				if(postojiIme!=1) {
					radniProstorZaDodati.setNaziv(d.getName());
					Singleton.getInstance().dodajRadniProstor(radniProstorZaDodati);
				}else {
					JOptionPane.showMessageDialog(null, "Radni prostor sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );

				}
			}

		}
		else {
			JOptionPane.showMessageDialog(null, "Neuspešno dodavanje novog radnog prostora."
					+ " Trenutni radni prostor mora biti zatvoren kako bi se novi dodao. ", null, JOptionPane.WARNING_MESSAGE );				
		}
	}
}