/***********************************************************************
 * Module:  AddSlotCommand.java
 * Author:  sale
 * Purpose: Defines the Class AddSlotCommand
 ***********************************************************************/

package etapa3.controller;

import java.util.*;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;
import etapa3.model.Slot;

public class AddSlotCommand extends etapa2.controller.Command {
	   private Stranica stranica;
	   private Slot slot;
	   
	public AddSlotCommand(Slot slot, Stranica stranica) {
		super();
		this.slot = slot;
		this.stranica = stranica;
	}
	
	 /** @pdOid 0409a514-024f-4683-9e10-d437e118a4f1 */
	public void ddo() {
	      // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this);

	   }
	   
	   /** @pdOid ba4c7a3e-b3b4-496c-93cb-f5b816d4d18c */
	public void undo() {
	      // TODO: implement
		   stranica.removeSlotovi(slot); 

	   }

	public Stranica getStranica() {
		return stranica;
	}

	public void setStranica(Stranica stranica) {
		this.stranica = stranica;
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}
}