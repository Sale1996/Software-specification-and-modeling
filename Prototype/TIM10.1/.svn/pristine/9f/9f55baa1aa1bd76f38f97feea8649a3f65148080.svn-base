package etapa1.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.zip.InflaterInputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.ostalo.Singleton;

public class OpenDokumentAction extends AbstractAction {
	public OpenDokumentAction () {
		putValue(NAME, "Open Dokument");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] izbori;
		ArrayList<String> izbori1=new ArrayList<String>();
		String izbor;
		if(Singleton.getInstance().radniProstori.size()>0) {
			int postojiDok = 0;
			for(RadniProstor rp : Singleton.getInstance().getRadniProstori()) {
				if(rp.getProjekti().size() > 0) {
					postojiDok++;
				}
			}
			if(postojiDok != 0) {
				JFileChooser choose = new JFileChooser();
				choose.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
				choose.showOpenDialog(null);
				File open = choose.getSelectedFile().getAbsoluteFile();
				try {
					ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new InflaterInputStream(new FileInputStream(open))));
					try {
						Dokument d = (Dokument)in.readObject();
						
						int postojiIme = 0;
						for(RadniProstor rp : Singleton.getInstance().getRadniProstori()) {
							for(Projekat proj : rp.getProjekti()) {
								izbori1.add(proj.getNaziv());
								for(Dokument dok : proj.getDokumenti()) {
									if(dok.getNaziv().equals(d.getNaziv())) {
										postojiIme=1;
										break;
									}
								}
							}
						}
						if(postojiIme == 0) {
							izbori= new String[izbori1.size()];
							izbori1.toArray(izbori);
							izbor = (String) JOptionPane.showInputDialog(null, "Izaberi dokument gde otvoriti:",
							        "Otvaranje", JOptionPane.QUESTION_MESSAGE, null,izbori,izbori[0]); // Initial choice
							d.setMaticniProjekat(null);
							for(RadniProstor rp : Singleton.getInstance().getRadniProstori()){
								for(Projekat proj : rp.getProjekti()){
									if(proj.getNaziv().equals(izbor)) {
										proj.addDokumenti(d);
									}
								}
							}
						}else {
							JOptionPane.showMessageDialog(null, "Dokument sa imenom "+d.getNaziv()+" vec postoji u projektu", null, JOptionPane.WARNING_MESSAGE );
						}
					}finally {
						in.close();
					}
				}catch (ClassNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Klasa nije pronađena.", null, JOptionPane.ERROR_MESSAGE);
				}catch (FileNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Fajl za otvaranje dokumenta nije pronađen.", null, JOptionPane.ERROR_MESSAGE);
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Greška pri otvaranju dokumenta.", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Ne možete dodati dokument ako nema projekata.", null, JOptionPane.WARNING_MESSAGE);
			}	
		}else {
			JOptionPane.showMessageDialog(null, "Ne možete dodati projekat ako nema radnih prostora.", null, JOptionPane.WARNING_MESSAGE);
		}
	}
}