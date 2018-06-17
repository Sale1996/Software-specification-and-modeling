/***********************************************************************
 * Module:  Stablo.java
 * Author:  ra168-2015
 * Purpose: Defines the Class Stablo
 ***********************************************************************/

package etapa1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.model.events.AbstractEvent;
import etapa1.model.events.EventAddDokument;
import etapa1.model.events.EventAddProjekat;
import etapa1.model.events.EventAddRadniProstor;
import etapa1.model.events.EventCloseRadniProstor;
import etapa1.model.events.EventOpenRadniProstor;
import etapa1.model.events.EventPromenaImena;
import etapa1.model.events.EventRemoveDokument;
import etapa1.model.events.EventRemoveProjekat;
import etapa1.model.events.EventRemoveRadniProstor;
import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;
import etapa2.model.events.EventAddStranica;
import etapa2.model.events.EventRemoveStranica;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;
import etapa3.model.events.EventAddElement;
import etapa3.model.events.EventAddSlot;
import etapa3.model.events.EventRemoveElement;
import etapa3.model.events.EventRemoveSlot;

/** @pdOid 686d21b6-b16d-4aeb-b144-59116727f679 */
public class Stablo extends JPanel implements Observer {
	
	private DefaultMutableTreeNode rootNode;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private JPanel panStablo;
	EventAddDokument eventDodatDokumenat;
	DefaultMutableTreeNode sel;	

	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		AbstractEvent event = (AbstractEvent) arg1;
		if(event instanceof EventAddRadniProstor){
			//ako se doda novi radni prostor mi pravimo novi cvor drveta koji ce predstavlajti hijerarhiju radnog prostora
			EventAddRadniProstor eventDodatRP = (EventAddRadniProstor) event;
			rootNode = new DefaultMutableTreeNode(eventDodatRP.getRadniProstor());
			eventDodatRP.getRadniProstor().addObserver(this);//ovde smo dodali osluskivac !

			treeModel = new DefaultTreeModel(rootNode);
			treeModel.setAsksAllowsChildren(true);
			tree = new JTree(treeModel);
			tree.setCellRenderer(new DrvoRender());
		    tree.setBackground(new Color(232, 229, 227));
		    tree.addTreeSelectionListener(new SelectionListener());
		    panStablo.setLayout(new BorderLayout());
		    panStablo.removeAll();
		    panStablo.add(tree, BorderLayout.CENTER);
		    RadniProstorView rpView =new RadniProstorView();
		    GlavniProzor.getInstance().setRpView(rpView);
		    revalidate();
		}else if (event instanceof EventAddProjekat){
			EventAddProjekat eventDodatProjekat = (EventAddProjekat) event;
			eventDodatProjekat.getProjekat().addObserver(this); // osluskujemo projekta!
			DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(eventDodatProjekat.getProjekat());
			if(eventDodatProjekat.getRadniProstor() == eventDodatProjekat.getProjekat().getMaticniRP()){
				sel=nadjiCvor(rootNode, eventDodatProjekat.getRadniProstor());
				//sada proveravamo da li projekat ima nesto u sebi i ako ima dodajemo u cvor
				for(Dokument item22 : eventDodatProjekat.getProjekat().getDokumenti()) {
					DefaultMutableTreeNode dokumentNode = new DefaultMutableTreeNode(item22);
					for(Stranica item : item22.getStranice()){
				    	DefaultMutableTreeNode stranicaNode = new DefaultMutableTreeNode(item);
				    	for(Slot item1 : item.getSlotovi()){
				    		DefaultMutableTreeNode slotNode = new DefaultMutableTreeNode(item1);
				    		slotNode.add(new DefaultMutableTreeNode(item1.getAbstractElement()));
				    		stranicaNode.add(slotNode);
				    	}
				    	dokumentNode.add(stranicaNode);
				    }
					nNode.add(dokumentNode);
				}
				
				
				
				
				ubaciUDrvo(nNode);
			}
			
		}else if(event instanceof EventAddDokument){
			eventDodatDokumenat= (EventAddDokument) event;
			eventDodatDokumenat.getDokument().addObserver(this);
			DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(eventDodatDokumenat.getDokument());
			sel=nadjiCvor(rootNode, eventDodatDokumenat.getProjekat());
			Object parent1=null;
			if(sel!=null){
				DefaultMutableTreeNode parent =(DefaultMutableTreeNode) sel.getParent();
				if(parent!=null)
					parent1=parent.getUserObject();
			}
			//ovde pitamo da li je ovaj event pozvan kada je selektovan dokument ili projekat
			//ako je projekat sel ostaje selektovana komponenta tj taj projeakt i u njega ubacujemo dokument
			//ako nije menjamo sel na izabrani projekat gde hocemo da podelimo dokument
			if(sel.getUserObject() instanceof Dokument){
				Projekat projekatSelektovan = (Projekat) parent1;
					  for(Stranica item : eventDodatDokumenat.getDokument().getStranice()){
					    	DefaultMutableTreeNode stranicaNode = new DefaultMutableTreeNode(item);
					    	for(Slot item1 : item.getSlotovi()){
					    		DefaultMutableTreeNode slotNode = new DefaultMutableTreeNode(item1);
					    		if(item1.getAbstractElement()!=null)
					    			slotNode.add(new DefaultMutableTreeNode(item1.getAbstractElement()));
					    		stranicaNode.add(slotNode);
					    	}
					    	nNode.add(stranicaNode);
					   }
				
				
				sel = nadjiCvor(rootNode,eventDodatDokumenat.getProjekat());
				
			}else {
				for(Stranica item : eventDodatDokumenat.getDokument().getStranice()){
			    	DefaultMutableTreeNode stranicaNode = new DefaultMutableTreeNode(item);
			    	for(Slot item1 : item.getSlotovi()){
			    		DefaultMutableTreeNode slotNode = new DefaultMutableTreeNode(item1);
			    		slotNode.add(new DefaultMutableTreeNode(item1.getAbstractElement()));
			    		stranicaNode.add(slotNode);
			    	}
			    	nNode.add(stranicaNode);
			   }
				sel = nadjiCvor(rootNode,eventDodatDokumenat.getProjekat());

			}

			ubaciUDrvo(nNode);

		}else if(event instanceof EventAddStranica){
			EventAddStranica eventDodataStranica= (EventAddStranica)event;
			eventDodataStranica.getStranica().addObserver(this);
			DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(eventDodataStranica.getStranica());
			if(eventDodataStranica.getStranica().getMaticniDokument() != eventDodataStranica.getDokument()) {
				sel =nadjiCvor(rootNode,eventDodataStranica.getDokument());
				for(int i=0; i<sel.getChildCount();i++){
					DefaultMutableTreeNode result = (DefaultMutableTreeNode)sel.getChildAt(i);
					if(eventDodataStranica.getStranica() == (Stranica) result.getUserObject()) {
						sel = result;
						break;
					}
					
					
				}
				//sada u cvor dodajemo sve sto ono ima
				for(Slot item1 : eventDodataStranica.getStranica().getSlotovi()){
		    		DefaultMutableTreeNode slotNode = new DefaultMutableTreeNode(item1);
		    		if(item1.getAbstractElement()!=null)
		    			slotNode.add(new DefaultMutableTreeNode(item1.getAbstractElement()));
		    		nNode.add(slotNode);
		    	}
				
			}else{
				sel = nadjiCvor(rootNode,eventDodataStranica.getDokument());
			}
			ubaciUDrvo(nNode);
		}else if(event instanceof EventRemoveStranica){
			//sel=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			EventRemoveStranica event1= (EventRemoveStranica) event;
			sel = nadjiCvor(rootNode, event1.getStranica());
			if(event1.getStranica().getMaticniDokument() != event1.getDokument()) {
				sel=nadjiCvor(rootNode, event1.getDokument());
				for(int i=0; i<sel.getChildCount();i++) {
					DefaultMutableTreeNode result = (DefaultMutableTreeNode) sel.getChildAt(i);
					if(event1.getStranica() == (Stranica) result.getUserObject()) {
						sel=result;
						break;
					}
				}
			}
			izbaciIzDrva();

		}else if(event instanceof EventRemoveDokument){
			EventRemoveDokument event1 = (EventRemoveDokument) event;
			//ovde ako se desi slucaj da brisemo deljeni dokument prvo nalazimo cvor projekta kojem smo podelili taj dokument
			//nakon sto nadjemo taj cvor onda nalazimo taj deljeni dokument u tom cvoru i njega brisemo ! inace samo brisemo selektovn cvor
			if(event1.getDokument().getMaticniProjekat() != event1.getProjekat()) {
				sel =nadjiCvor(rootNode,event1.getProjekat());
				for(int i=0; i<sel.getChildCount();i++){
					DefaultMutableTreeNode result = (DefaultMutableTreeNode)sel.getChildAt(i);
					if(event1.getDokument() == (Dokument) result.getUserObject()) {
						sel = result;
						break;
					}
				}
				
			}else {
				sel=(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

			}
			izbaciIzDrva();
		}else if(event instanceof EventRemoveProjekat){
			EventRemoveProjekat event1= (EventRemoveProjekat) event;
			//ako je pozvano brisanje projekta iz maticnog projekta onda znamo da je on obrisan u svom random prostoru
			//i to moramo da refresujemo u drvetu
			//ali ako je obrisan podeljen neki, on je obrisan iz radnog prostora sto je u bazi podataka tako da nemao
			//sta da se brinemo oko drveta kako ce on tu izgledati!
			if(event1.getRadniProstor() == event1.getProjekat().getMaticniRP()){
				sel =(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
				izbaciIzDrva();
			}
		}else if(event instanceof EventRemoveRadniProstor){
			treeModel.setRoot(null);
			panStablo.removeAll();
			revalidate();
		}else if(event instanceof EventCloseRadniProstor){
			treeModel.setRoot(null);
			panStablo.removeAll();
			tree=null;
			revalidate();
		}else if(event instanceof EventOpenRadniProstor){
			EventOpenRadniProstor eventOtvorenRP = (EventOpenRadniProstor) event;
			rootNode = new DefaultMutableTreeNode(eventOtvorenRP.getRadniProstor());
			eventOtvorenRP.getRadniProstor().addObserver(this);//ovde smo dodali osluskivac !

			treeModel = new DefaultTreeModel(rootNode);
			treeModel.setAsksAllowsChildren(true);
			tree = new JTree(treeModel);
			tree.setCellRenderer(new DrvoRender());
		    tree.setBackground(new Color(232, 229, 227));
		    panStablo.add(tree, BorderLayout.CENTER);
		    
		    //sada punimo drvo sa starim vrednostima, znaci idemo lepo kroz sve projekte i sve dokumente i lepo ih dodajemo u cvorove i pravimo stablo
		    for(Projekat item : eventOtvorenRP.getRadniProstor().getProjekti()){
		    	DefaultMutableTreeNode projekatNode = new DefaultMutableTreeNode(item);
		    	for(Dokument item1 : item.getDokumenti()){
		    		DefaultMutableTreeNode dokumentNode = new DefaultMutableTreeNode(item1);
		    		projekatNode.add(dokumentNode);
		    	}
		    	rootNode.add(projekatNode);
		    }
		    treeModel.setRoot(rootNode);
		    tree.addTreeSelectionListener(new SelectionListener());
		    RadniProstorView rpView =new RadniProstorView();
		    GlavniProzor.getInstance().setRpView(rpView);
		    revalidate();
			
		}else if(event instanceof EventPromenaImena){
			sel =(DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			treeModel.nodeChanged(sel); //ovo kada promenimo ime moramo da naznacimo da se cvor promenio da ga osvezi kako treba vizuelno
			revalidate();
		}else if(event instanceof EventAddSlot){
			EventAddSlot eventDodatSlot= (EventAddSlot)event;
			eventDodatSlot.getSlot().addObserver(this);
			DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(eventDodatSlot.getSlot());
			if(eventDodatSlot.getSlot().getMaticnaStranica() != eventDodatSlot.getStranica()) {
				sel =nadjiCvor(rootNode,eventDodatSlot.getStranica());
				for(int i=0; i<sel.getChildCount();i++){
					DefaultMutableTreeNode result = (DefaultMutableTreeNode)sel.getChildAt(i);
					if(eventDodatSlot.getSlot() == (Slot) result.getUserObject()) {
						sel = result;
						break;
					}
				}
				if(eventDodatSlot.getSlot().getAbstractElement()!=null)
					nNode.add(new DefaultMutableTreeNode(eventDodatSlot.getSlot().getAbstractElement()));
				
			}else{
				sel = nadjiCvor(rootNode,eventDodatSlot.getStranica());
			}
			ubaciUDrvo(nNode);
		}else if(event instanceof EventRemoveSlot) {
			EventRemoveSlot event1= (EventRemoveSlot) event;
			sel = nadjiCvor(rootNode, event1.getSlot());
			if(event1.getSlot().getMaticnaStranica() != event1.getStranica()) {
				sel=nadjiCvor(rootNode, event1.getStranica());
				for(int i=0; i<sel.getChildCount();i++) {
					DefaultMutableTreeNode result = (DefaultMutableTreeNode) sel.getChildAt(i);
					if(event1.getSlot() == (Slot) result.getUserObject()) {
						sel=result;
						break;
					}
				}
			}
			izbaciIzDrva();
		}else if(event instanceof EventAddElement) {
			EventAddElement eventDodatElement= (EventAddElement)event;
			eventDodatElement.getElement().addObserver(this);
			DefaultMutableTreeNode nNode = new DefaultMutableTreeNode(eventDodatElement.getElement());
			
			sel = nadjiCvor(rootNode,eventDodatElement.getSlot());
			
			ubaciUDrvo(nNode);
		}else if(event instanceof EventRemoveElement) {
			EventRemoveElement event1= (EventRemoveElement) event;
			sel = nadjiCvor(rootNode, event1.getElement());
			
			izbaciIzDrva();
		}
	}
	
	public Stablo(){
		panStablo= new JPanel();
		Singleton.getInstance().addObserver(this);
		this.setLayout(new BorderLayout());
		this.add(panStablo, BorderLayout.CENTER);
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
	
	public void ubaciUDrvo(DefaultMutableTreeNode nNode){
		
		treeModel.insertNodeInto(nNode, sel, sel.getChildCount());
		tree.setSelectionPath(new TreePath(nNode.getPath()));
		tree.scrollPathToVisible(new TreePath(nNode.getPath()));
		revalidate();
	}
	
	public void izbaciIzDrva(){
		treeModel.removeNodeFromParent(sel);
		revalidate();

	}
	//pretraga kroz stablo da nadjemo cvor kome smo podelili neku od komponenti!!
	public DefaultMutableTreeNode nadjiCvor(DefaultMutableTreeNode cvor,Object gdeDodati){
		//ako je cvor tipa projekat pogledaj dal to to gdeDodati ako nije idi u njegovu decu i tako je za svaki tip
		if(cvor.getUserObject() instanceof Projekat){
			
			Projekat projekatZaTraziti = (Projekat) cvor.getUserObject();
			if(gdeDodati instanceof Projekat && projekatZaTraziti == (Projekat) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}else if(cvor.getUserObject() instanceof RadniProstor){
			RadniProstor radniProstorZaTraziti = (RadniProstor) cvor.getUserObject();
			if(gdeDodati instanceof RadniProstor && radniProstorZaTraziti == (RadniProstor) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}else if(cvor.getUserObject() instanceof Dokument){
			Dokument dokumentZaTraziti = (Dokument) cvor.getUserObject();
			if(gdeDodati instanceof Dokument && dokumentZaTraziti == (Dokument) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}else if(cvor.getUserObject() instanceof Stranica){
			Stranica stranizaZaTraziti = (Stranica) cvor.getUserObject();
			if(gdeDodati instanceof Stranica && stranizaZaTraziti == (Stranica) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}else if(cvor.getUserObject() instanceof Slot){
			Slot slotZaTraziti = (Slot) cvor.getUserObject();
			if(gdeDodati instanceof Slot && slotZaTraziti == (Slot) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}else if(cvor.getUserObject() instanceof AbstractElement){
			AbstractElement elementZaTraziti = (AbstractElement) cvor.getUserObject();
			if(gdeDodati instanceof AbstractElement && elementZaTraziti == (AbstractElement) gdeDodati)
				return cvor;
			else{
				for(int i=0; i<cvor.getChildCount();i++){
					DefaultMutableTreeNode result = nadjiCvor((DefaultMutableTreeNode)cvor.getChildAt(i),gdeDodati);
					if (result != null) {
		                return result;
		            }
				}
			}
		}
		
		return null;
	}
	
}