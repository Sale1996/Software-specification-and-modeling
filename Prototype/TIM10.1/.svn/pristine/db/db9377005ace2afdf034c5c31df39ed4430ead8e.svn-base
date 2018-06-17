/***********************************************************************
 * Module:  RadniProstorView.java
 * Author:  ra168-2015
 * Purpose: Defines the Class RadniProstorView
 ***********************************************************************/

package etapa1.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import etapa1.model.Projekat;
import etapa1.model.events.AbstractEvent;
import etapa1.model.events.EventAddProjekat;
import etapa1.model.events.EventEditImeRadniProstor;
import etapa1.ostalo.Singleton;

/** @pdOid 40f2a3bc-5139-43c8-adec-ceabd045a5af */
public class RadniProstorView extends JPanel implements Observer {
	JLabel imeWs;
	JLabel projektiWs;
	JLabel projektiWsNabroj;
	
	public RadniProstorView() {
		// TODO Auto-generated constructor stub
		Singleton.getInstance().trenutniRadniProstor.addObserver(this); // osluskujemo ovog lika

		imeWs= new JLabel("Ime: "+Singleton.getInstance().trenutniRadniProstor.getNaziv());
		imeWs.setFont(new Font("Serif", Font.PLAIN, 30));
	    projektiWs=new JLabel("    Projekti: ");
		projektiWs.setFont(new Font("Serif", Font.PLAIN, 30));
		projektiWsNabroj=new JLabel();
		//this.setLayout(new BorderLayout());
		this.add(imeWs);
		this.add(projektiWs);
		this.add(projektiWsNabroj);
		revalidate();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		AbstractEvent event = (AbstractEvent) arg1;
		if(event instanceof EventAddProjekat){
			EventAddProjekat event1= (EventAddProjekat) event;
			Projekat projekat = event1.getProjekat();
			ProjekatView projekatView = new ProjekatView(projekat.getNaziv());
			projekat.addObserver(projekatView);//ovde smo stavili da projekatView prisluskuje ovaj dodat dokument
			//i kada bi dodali neku stranicu u taj projekat onda ce taj ProjekatView to videti!
			GlavniProzor.getInstance().getProjektiView().add(projekatView);
			projektiWsNabroj.setText(projektiWsNabroj.getText() + " " + projekat.getNaziv());
			revalidate();
		}else if(event instanceof EventEditImeRadniProstor){
			EventEditImeRadniProstor event1= (EventEditImeRadniProstor) event;
			imeWs.setText("Ime: "+event1.getRadnProstor().getNaziv());
			revalidate();
		}
		
		
	}
}