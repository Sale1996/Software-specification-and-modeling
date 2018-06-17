/***********************************************************************
 * Module:  AddStranicaAction.java
 * Author:  Leonidas
 * Purpose: Defines the Class AddStranicaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;
import etapa2.view.InputStranicaDialog;

/** @pdOid 841fc2c2-6044-47cc-a119-bc4fdd3ffd54 */
public class AddStranicaAction extends AbstractAction {

	public AddStranicaAction(){
		putValue(NAME,"Stranica");
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
				
				
				if (o instanceof Dokument) {
					Stranica novaStranica = new Stranica();
					Dokument maticniDokument = (Dokument) o;
					InputStranicaDialog d = new InputStranicaDialog();
					d.setVisible(true);
					if(d.isStatus()) {
						int postojiIme=0;
						//provera da li ime vec postoji
						for(int i=0; i<maticniDokument.getStranice().size(); i++) {
							if(maticniDokument.getStranice().get(i).getNaziv().equals(d.getName()))
								postojiIme=1;
						}
						//ako je korisnik uspesno uneo formu
						//mi ubacujemo ove atribute u novu stranicu
						if(postojiIme!=1) {
							novaStranica.setNaziv(d.getName());
							
							
							try{
							    int yourNumber = Integer.parseInt(d.getDuzina());
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Unos indeksa, duzine, sirine i broja slotova stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
							}
							novaStranica.setDuzina(Integer.parseInt(d.getDuzina()));
							
							try{
							    int yourNumber = Integer.parseInt(d.getSirina());
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Unos indeksa, duzine, sirine i broja slotova stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
							}
							novaStranica.setSirina(Integer.parseInt(d.getSirina()));
							
							try{
							    int yourNumber = Integer.parseInt(d.getBrojSlotova1());
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Unos indeksa, duzine, sirine i broja slotova stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
							}
							novaStranica.setBrojSlotova(Integer.parseInt(d.getBrojSlotova1()));
							
							try{
							    int yourNumber = Integer.parseInt(d.getBrojSlotova1());
							}catch (NumberFormatException ex) {
								JOptionPane.showMessageDialog(null, "Unos indeksa, duzine, sirine i broja slotova stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
							}
							novaStranica.setRedniBrojIndeksa(Integer.parseInt(d.getBrojIndeksaStranice1()));
							
							novaStranica.setPraviloRasporedaSlotova(d.getRasporedSlotova1());
							maticniDokument.addStranice(novaStranica);
							AddStranicaCommand komanda = new AddStranicaCommand(novaStranica, maticniDokument);
							komanda.ddo();//ubacili smo komandu u stek naredbi za undo !
						}else {
							JOptionPane.showMessageDialog(null, "Stranica sa unetim imenom vec postoji u maticnom dokumentu. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
						}

					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Stranica se ne može dodati ovde. Dodajte je na dokument.", null, JOptionPane.WARNING_MESSAGE );	
				}
			
			}else
				JOptionPane.showMessageDialog(null, "Izaberite dokument u koji želite dodati stranicu.", null, JOptionPane.WARNING_MESSAGE );	
		}else {
			JOptionPane.showMessageDialog(null, "Nije moguce dodati stranicu bez aktivnog radnog prostora.", null, JOptionPane.WARNING_MESSAGE );
		}
	}
}