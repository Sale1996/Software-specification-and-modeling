package etapa2.controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;
import etapa2.model.Stranica;

public class EditIndexStranicaAction extends AbstractAction{
	public EditIndexStranicaAction() {
		putValue(NAME, "index stranice");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode)GlavniProzor.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		DefaultMutableTreeNode parent= null;
		Object roditelj=null;
		if(sel!=null){
			parent=(DefaultMutableTreeNode) sel.getParent();
			if(parent!=null)
				roditelj=parent.getUserObject();
		}
		
		if(sel != null) {
			Object o = sel.getUserObject();
			if(o instanceof Stranica) {
				Stranica s = (Stranica)o;
				int index;
				try {
					index = Integer.parseInt(JOptionPane.showInputDialog("Unesi index:"));
					EditIndexStranicaCommand komanda= new EditIndexStranicaCommand(s, index);
					komanda.ddo();
					s.setRedniBrojIndeksa(index);
					
				
						
					
					
					
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Unos indexa stranice mora biti celobrojan.", null, JOptionPane.WARNING_MESSAGE );
				}
			}
		}
		
	}
}
