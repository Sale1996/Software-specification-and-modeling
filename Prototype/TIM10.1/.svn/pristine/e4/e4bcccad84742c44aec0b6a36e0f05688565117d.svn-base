/***********************************************************************
 * Module:  CloseRadniProstorAction.java
 * Author:  sale
 * Purpose: Defines the Class CloseRadniProstorAction
 ***********************************************************************/

package etapa1.controller;

import java.awt.event.ActionEvent;
import java.util.*;

import javax.swing.AbstractAction;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;
import etapa1.view.GlavniProzor;

/** @pdOid b89c1dd6-98a1-4419-abe4-1a7b978d4df9 */
public class CloseRadniProstorAction extends AbstractAction {
	public CloseRadniProstorAction() {
		// TODO Auto-generated constructor stub
		putValue(NAME,"Zatvori radni prostor");
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
				if(o instanceof RadniProstor){
					Singleton.getInstance().closeRadniProstor();
				}
			}
		 }
		
	}
}