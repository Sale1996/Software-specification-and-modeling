/***********************************************************************
 * Module:  AddProjekatAction.java
 * Author:  ra168-2015
 * Purpose: Defines the Class AddProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa1.view.InputDialog;

/** @pdOid 3ffe927c-2225-41df-b180-dac25ed44fcb */
public class AddProjekatAction extends AbstractAction {


	public AddProjekatAction(){
		putValue(NAME,"Project");

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(Singleton.getInstance().trenutniRadniProstor!=null) {
			
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				
				if (o instanceof RadniProstor) {
					Projekat projekatNovi = new Projekat();

					RadniProstor maticniRadniProstor = (RadniProstor) o;
					
					InputDialog d = new InputDialog();
					d.setVisible(true);
					if(d.isStatus()) {
						
						int postojiIme=0;
						//provera da li ime vec postoji
						for(int i=0; i<Singleton.getInstance().trenutniRadniProstor.getProjekti().size(); i++) {
							if(Singleton.getInstance().trenutniRadniProstor.getProjekti().get(i).getNaziv().equals(d.getName()))
								postojiIme=1;
						}
							
						if(postojiIme!=1) {
							projekatNovi.setNaziv(d.getName());
							maticniRadniProstor.addProjekti(projekatNovi);
						}else {
							JOptionPane.showMessageDialog(null, "Projekat sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}

					}

					
				}else {
					JOptionPane.showMessageDialog(null, "Projekat se ne može dodati ovde. Dodajte ga na radni prostor.", null, JOptionPane.WARNING_MESSAGE );	
				}
			}else
				JOptionPane.showMessageDialog(null, "Izaberite radni prostor u koji želite dodati projekat.", null, JOptionPane.WARNING_MESSAGE );	
		}else {
			JOptionPane.showMessageDialog(null, "Nije moguce dodati projekat bez aktivnog radnog prostora.", null, JOptionPane.WARNING_MESSAGE );	
		}
	}
}