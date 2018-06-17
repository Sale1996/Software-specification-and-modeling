package etapa1.controller;

import java.awt.event.ActionEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.zip.DeflaterOutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import etapa1.model.Projekat;
import etapa1.view.GlavniProzor;

public class SaveProjekatAction extends AbstractAction {
	public SaveProjekatAction() {
		putValue(NAME, "Save Projekat");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		Object o = null;
		if(sel != null) {
			o = sel.getUserObject();
			if(o instanceof Projekat) {
				JFileChooser choose = new JFileChooser();
				choose.setFileSelectionMode(JFileChooser.SAVE_DIALOG); 
				choose.showSaveDialog(null);
				File save = new File(choose.getSelectedFile().getAbsolutePath(),((Projekat) o).getNaziv()+ ".proj");
				try {
					ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new DeflaterOutputStream(new FileOutputStream(save))));
					try {
						out.writeObject((Projekat)o);
					} finally {
						out.close();
					}
					JOptionPane.showMessageDialog(null, "Uspesno sačuvan projekat", null, JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Fajl za čuvanje projekta nije pronađen", null, JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Greška pri čuvanju projekta", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite projekat koji želite da sačuvate.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
	}
}
