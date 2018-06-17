/***********************************************************************
 * Module:  EditImeStranicaCommand.java
 * Author:  ra35-2015
 * Purpose: Defines the Class EditImeStranicaCommand
 ***********************************************************************/

package etapa2.controller;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;

/** @pdOid 984b869c-feae-4143-a447-577162afc459 */
public class EditImeStranicaCommand extends Command {
   /** @pdOid 0639da14-732f-4e66-99e0-0bae571bf5d5 */
   private Stranica stranica;
   private String staroIme;
public EditImeStranicaCommand(Stranica stranica, String staroIme, String novoIme) {
	super();
	this.stranica = stranica;
	this.staroIme = staroIme;
}
   
	public void ddo() {
	   // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this); //ubacili smo da je izvresna ova komanda!
	}
	public void undo() {
	   // TODO: implement
		   stranica.promenaImena(staroIme);
	}

}