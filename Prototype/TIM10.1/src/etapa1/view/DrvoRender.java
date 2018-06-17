package etapa1.view;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa2.model.Stranica;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;

public class DrvoRender extends DefaultTreeCellRenderer{

	private ImageIcon wsIcon=new ImageIcon("Ikonice/workspace.png");
	private ImageIcon projectIcon=new ImageIcon("Ikonice/project.png");
	private ImageIcon documentIcon=new ImageIcon("Ikonice/document.png");
	private ImageIcon pageIcon=new ImageIcon("Ikonice/page.png");
	private ImageIcon documentShareIcon = new ImageIcon("DetatchIkonice/documentShortcut.png");
	private ImageIcon projectShareIcon = new ImageIcon("DetatchIkonice/projectShortcut.png");
	private ImageIcon pageShareIcon = new ImageIcon("DetatchIkonice/pageShortcut.png");
	private ImageIcon slotIcon=new ImageIcon("Ikonice/tabela.png");
	private ImageIcon slotShareIcon = new ImageIcon("DetatchIkonice/tabela.png");
	private ImageIcon elementIcon  = new ImageIcon("Ikonice/text.png");
	
	public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf,
			int row, boolean hasFocus) {
		
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

		DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
		DefaultMutableTreeNode ParentNode = (DefaultMutableTreeNode) node.getParent();
		Object o = node.getUserObject();
		Object parentO=null;
		if(ParentNode!=null)
			parentO = ParentNode.getUserObject();
		
		if(o instanceof RadniProstor){
			RadniProstor radniProstor= (RadniProstor) o;
			setText(radniProstor.getNaziv());
			setIcon(wsIcon);
			
		}else if(o instanceof Projekat){
			Projekat projekat = (Projekat) o;
			RadniProstor roditelj = (RadniProstor) parentO;
			setText(projekat.getNaziv());
			
			if(roditelj != projekat.getMaticniRP())
				setIcon(projectShareIcon);
			else
				setIcon(projectIcon);
		}else if(o instanceof Dokument){
			Dokument dokument = (Dokument) o;
			Projekat roditelj = (Projekat) parentO;
			setText(dokument.getNaziv());

			if(roditelj != dokument.getMaticniProjekat())
				setIcon(documentShareIcon);
			else
				setIcon(documentIcon);
			
		}else if(o instanceof Stranica){
			Stranica stranica = (Stranica) o;
			Dokument roditelj = (Dokument) parentO;
			setText(stranica.getNaziv());
			
			if(roditelj != stranica.getMaticniDokument())
				setIcon(pageShareIcon);
			else
				setIcon(pageIcon);
		}else if(o instanceof Slot) {
			Stranica roditelj = (Stranica) parentO;
			Slot slot = (Slot) o;
			if(roditelj != slot.getMaticnaStranica())
				setIcon(slotShareIcon);
			else
				setIcon(slotIcon);
		}else if(o instanceof AbstractElement){
			setIcon(elementIcon);
		}
		
		return this;
		
	}
}
