/***********************************************************************
 * Module:  ShareProjekatAction.java
 * Author:  ra168-2015
 * Purpose: Defines the Class ShareProjekatAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Single;

import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;

/** @pdOid d76e71a3-5dc0-4698-849f-6fa056585398 */
public class ShareProjekatAction extends AbstractAction {

	public ShareProjekatAction() {
		// TODO Auto-generated constructor stub
	putValue(NAME, "Projekat");
}

@Override
public void actionPerformed(ActionEvent arg0) {
	String[] izbori;
	ArrayList<String> izbori1=new ArrayList<String>();
	String izbor;
		//Ovde ima bug kad se deli projekat pojavi se samo ispod kao dokument.
		if(Singleton.getInstance().trenutniRadniProstor != null && Singleton.getInstance().radniProstori.size()>1){
			DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor
					.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
			
			Object o = null;
			if (sel != null) {
				o = sel.getUserObject();
			}
			
			if (sel != null){
				
				
				if (o instanceof Projekat) {
					Projekat projekatZaDeliti = (Projekat) o;
					for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
						if(item != projekatZaDeliti.getMaticniRP())
							izbori1.add(item.getNaziv());
					}
					//morali smo koristiti listu kako bi dodali imena
					//a pretvarali smo u niz stringova da bi dijalog mogao to podrzati
					izbori= new String[izbori1.size()];
					izbori1.toArray(izbori);
					izbor = (String) JOptionPane.showInputDialog(null, "Izaberi radni prostor gde deliti:",
					        "Deljenje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice	
				
					//SADA KADA SMO IZABRALI KOME DA DELIMO VRSIMO DELJENJE!
					for(RadniProstor item : Singleton.getInstance().getRadniProstori()){
						if(item.getNaziv().equals(izbor))
							item.addProjekti(projekatZaDeliti);
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite sta zelite da podelite.", null, JOptionPane.WARNING_MESSAGE );
			}
		}	
	}
}
