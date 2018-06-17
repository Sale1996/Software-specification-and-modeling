/***********************************************************************
 * Module:  DesniPanel.java
 * Author:  ra168-2015
 * Purpose: Defines the Class DesniPanel
 ***********************************************************************/

package etapa1.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/** @pdOid 1e4c2ecb-a208-46d1-9e5c-637232241eb8 */
public class DesniPanel extends JPanel implements Observer, ActionListener {
	
	private JPanel desniPanel;

	
	public DesniPanel(){
		desniPanel= new JPanel();
		desniPanel.setLayout(new BorderLayout());
		desniPanel.setPreferredSize(new Dimension(250,400));
		validate();
		
	};
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}		
		public void desniPanelAdd(){
			
			
			JLabel lab = new JLabel("Write the name of workspace:");			
			lab.setPreferredSize(new Dimension(200,50));
			JTextField text = new JTextField();
			text.setPreferredSize(new Dimension(200,20));
			
			// Butoni
			
			JButton dodaj = new JButton("Add");
			JButton zatvori = new JButton("Close");
			
			// Panel
					
			desniPanel.add(lab);
			desniPanel.add(text);
			desniPanel.add(dodaj);
			desniPanel.add(zatvori);
			
			zatvori.addActionListener(this);			
				
			}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			desniPanel.setVisible(false);
		
		}

					
			
		}
		
