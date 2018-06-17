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

import org.omg.PortableServer.ServantRetentionPolicyValue;

import etapa1.model.Dokument;
import etapa1.view.GlavniProzor;

public class SaveDokumentAction extends AbstractAction {
	public SaveDokumentAction() {
		putValue(NAME, "Save Dokument");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		DefaultMutableTreeNode sel = (DefaultMutableTreeNode) GlavniProzor.getInstance().getPanelDrvo().getTree().getLastSelectedPathComponent();
		Object o = null;
		if(sel != null) {
			o = sel.getUserObject();
			if(o instanceof Dokument) {
				JFileChooser choose = new JFileChooser();
				choose.setFileSelectionMode(JFileChooser.SAVE_DIALOG); 
				choose.showSaveDialog(null);
				File save = new File(choose.getSelectedFile().getAbsolutePath(),((Dokument) o).getNaziv()+ ".dok");
				try {
					ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new DeflaterOutputStream(new FileOutputStream(save))));
					try {
						out.writeObject((Dokument)o);
					} finally {
						out.close();
					}
					JOptionPane.showMessageDialog(null, "Uspesno sačuvan dokument", null, JOptionPane.INFORMATION_MESSAGE);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Fajl za čuvanje dokumenta nije pronađen", null, JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Greška pri čuvanju dokumenta", null, JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Izaberite dokument koji želite da sačuvate.", null, JOptionPane.WARNING_MESSAGE );
			}
		}
	}

}
