/***********************************************************************
 * Module:  EditImeStranicaAction.java
 * Author:  ra35-2015
 * Purpose: Defines the Class EditImeStranicaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import org.omg.PortableServer.ServantRetentionPolicyValue;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

/** @pdOid 619ea9f9-1ab3-4a1a-aa3e-4efcc0a41362 */
public class EditImeStranicaAction extends AbstractAction {
	public EditImeStranicaAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Ime stranice");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
				.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		if(sel != null) {
			String ime;
			Object o = sel.getUserObject();
			if(o instanceof Stranica) {
				Stranica s = (Stranica)o;
				int imePostiji = 0;
				ime = JOptionPane.showInputDialog("Unesi ime stranice:");
				for(RadniProstor rp : Singleton.getInstance().getRadniProstori()) {
					for(Projekat proj : rp.getProjekti()) {
						for(Dokument dok : proj.getDokumenti()) {
							for(Stranica str : dok.getStranice()) {
								if(str.getNaziv().equals(ime)) {
									imePostiji = 1;
									break;
								}
							}
						}
					}
				}
				if(imePostiji == 0) {
					String staroIme = s.getNaziv();
					s.promenaImena(ime);
					EditImeStranicaCommand komanda = new EditImeStranicaCommand(s,staroIme,ime);
					komanda.ddo();
				}else {
					JOptionPane.showMessageDialog(null, "Stranica sa unetim imenom vec postoji. Unesite drugacije ime.", null, JOptionPane.WARNING_MESSAGE );
				}
			}
		}
		
	}
}