/***********************************************************************
 * Module:  ProjekatView.java
 * Author:  ra168-2015
 * Purpose: Defines the Class ProjekatView
 ***********************************************************************/

package etapa1.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import etapa1.model.Dokument;
import etapa1.model.events.AbstractEvent;
import etapa1.model.events.EventAddDokument;
import etapa1.model.events.EventEditImeDokument;
import etapa1.model.events.EventRemoveDokument;
import etapa2.view.StranicaView;
import etapa3.view.SlotView;

/** @pdOid cb0ba238-abb9-4e3b-bb36-6d520c658bdf */
public class ProjekatView extends JPanel implements Observer {

	JTabbedPane panelTab;
	String imePanela;

	public ProjekatView(String imePanela) {
		super();
		this.setSize(new Dimension(900, 800));
		//BoxLayout boxCenter=new BoxLayout(this, BoxLayout.Y_AXIS);
		//this.setLayout(boxCenter);
		this.imePanela = imePanela;
		panelTab= new JTabbedPane();
		//BoxLayout boxCenter1=new BoxLayout(panelTab, BoxLayout.Y_AXIS);
		this.setLayout(new BorderLayout());
		panelTab.setPreferredSize(new Dimension(500, 500));
		this.add(panelTab);
		revalidate();
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		AbstractEvent event = (AbstractEvent) arg1;
		if(event instanceof EventAddDokument){
			EventAddDokument event1 = (EventAddDokument) event;
			Dokument dokument = event1.getDokument();
			DokumentView dokumenView=null;
			//ovde proveravamo da li je dokument shareovan i ako jeste onda mu samo ubacimo panel koji vec postoji!
			if(dokument.getMaticniProjekat().getNaziv() == this.imePanela){
				dokumenView = new DokumentView(dokument.getNaziv());//ubacujemo ime iz razloga kako bi u glavnom prozoru mogli da razlikujemo panele!
				dokument.addObserver(dokumenView);
				dokument.addObserver(this);
				GlavniProzor.getInstance().getDokumentiView().add(dokumenView);
			}else{
				for(DokumentView item : GlavniProzor.getInstance().getDokumentiView()){
					if(item.getImePanelaDokumenta()==dokument.getNaziv()){
						dokumenView=new DokumentView(dokument.getNaziv());
						
						break;
					}
				}
			}
			panelTab.addTab(dokument.getNaziv(), dokumenView);
			revalidate();
		}else if(event instanceof EventEditImeDokument){
			EventEditImeDokument event1 = (EventEditImeDokument) event;
			for(int i=0;i<panelTab.getTabCount();i++){
				if(event1.getStaroIme()==panelTab.getTitleAt(i)){
					panelTab.setTitleAt(i, event1.getIme());
					panelTab.validate();
					this.revalidate();
					break;
				}
			}
			
		}else if(event instanceof EventRemoveDokument){
			EventRemoveDokument event1 = (EventRemoveDokument) event;
			int i;
			for(i=0;i<panelTab.getTabCount();i++){
				if(event1.getDokument().getNaziv()==panelTab.getTitleAt(i))
					break;
			}
			panelTab.removeTabAt(i);
			panelTab.validate();
			this.revalidate();
		}
		
	}
	public String getImePanela() {
		return imePanela;
	}
	public void setImePanela(String imePanela) {
		this.imePanela = imePanela;
	}
}