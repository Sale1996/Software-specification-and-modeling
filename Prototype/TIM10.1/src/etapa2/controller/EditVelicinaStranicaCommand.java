/***********************************************************************
 * Module:  EditVelicinaStranicaCommand.java
 * Author:  ra35-2015
 * Purpose: Defines the Class EditVelicinaStranicaCommand
 ***********************************************************************/

package etapa2.controller;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;

/** @pdOid 408fc11b-2247-44b1-bb27-49a2f6e1cd7c */
public class EditVelicinaStranicaCommand extends Command {
   /** @pdOid 1928f249-f706-4245-83ab-17e0bc23e6be */
   private Stranica stranica;
   private int staraDuzina;
   private int staraSirina;
   public EditVelicinaStranicaCommand(Stranica stranica, int staraDuzina,
		int staraSirina) {
	super();
	this.stranica = stranica;
	this.staraDuzina = staraDuzina;
	this.staraSirina = staraSirina;
   }

	public void ddo() {
	   // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this); //ubacili smo da je izvresna ova komanda!
	}
	public void undo() {
	   // TODO: implement
		   stranica.setDimenzija(staraDuzina, staraSirina);
	}
}