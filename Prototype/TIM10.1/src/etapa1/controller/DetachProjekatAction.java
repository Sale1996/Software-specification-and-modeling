/***********************************************************************
 * Module:  DetachProjekatAction.java
 * Author:  sale
 * Purpose: Defines the Class DetachProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;

/** @pdOid edc5778e-cf99-4f65-9d27-54fbd2bb2078 */
public class DetachProjekatAction extends AbstractAction {

	public DetachProjekatAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Projekat");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		// TODO Auto-generated method stub
		if(Singleton.getInstance().trenutniRadniProstor!=null){
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				if (o instanceof Projekat) {
					Projekat projekatZaPrekidDeljenja = (Projekat) o;
					for(RadniProstor item : projekatZaPrekidDeljenja.getDeljenURadnomProstoru()){
							izbori1.add(item.getNaziv());
					}
					//morali smo koristiti listu kako bi dodali imena
					//a pretvarali smo u niz stringova da bi dijalog mogao to podrzati
					izbori= new String[izbori1.size()];
					izbori1.toArray(izbori);
					izbor = (String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde deliti:",
					        "Deljenje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
				
					for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
						if(item.getNaziv().equals(izbor)){
							item.removeProjekti(projekatZaPrekidDeljenja);
							break;
						}
					}
				}
			}
		}
	}
}