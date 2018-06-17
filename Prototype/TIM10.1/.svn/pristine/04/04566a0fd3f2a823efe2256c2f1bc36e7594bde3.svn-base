/***********************************************************************
 * Module:  EditVelicinaStranicaAction.java
 * Author:  ra35-2015
 * Purpose: Defines the Class EditVelicinaStranicaAction
 ***********************************************************************/

package etapa2.controller;

import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

/** @pdOid d4e040c2-276a-4804-ba8d-2dc3a6171b4d */
public class EditVelicinaStranicaAction extends AbstractAction {
	public EditVelicinaStranicaAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME, "Veličine stranice");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
				.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		if(sel != null) {
			int duzina;
			int sirina;
			Object o = sel.getUserObject();
			if(o instanceof Stranica) {
				Stranica s = (Stranica)o;
				try {
					duzina = Integer.parseInt(JOptionPane.showInputDialog("Unesi dužinu stranice:"));
					sirina = Integer.parseInt(JOptionPane.showInputDialog("Unesi širinu stranice:"));
					int staraDuzina = s.getDuzina();
					int staraSirina = s.getSirina();
					s.setDimenzija(duzina, sirina);
					EditVelicinaStranicaCommand komanda = new EditVelicinaStranicaCommand(s, staraDuzina, staraSirina);
					komanda.ddo();
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Unos duzine i sirine mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
				}
			}
		}
	}
}