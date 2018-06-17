/***********************************************************************
 * Module:  RemoveSlotCommand.java
 * Author:  sale
 * Purpose: Defines the Class RemoveSlotCommand
 ***********************************************************************/

package etapa3.controller;

import java.util.*;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;
import etapa3.model.Slot;

/** @pdOid 682d58ab-cf8a-484c-a250-655607fb0851 */
public class RemoveSlotCommand extends etapa2.controller.Command {
	   /** @pdOid 3cf20db2-74bb-4701-a949-734c6280b5fd */
	   private Stranica stranica;
	   /** @pdOid 9bbfbdf9-f141-488d-98e8-a8c4adde465e */
	   private Slot slot;
	   /** @pdOid 80ec0fe1-a51e-472f-aee0-428e9dfdd696 */
	   private Slot deljeniSlot;


public RemoveSlotCommand(Slot slot, Stranica stranica, Slot deljeniSlot) {
	super();
	this.stranica = stranica;
	this.slot = slot;
	this.deljeniSlot = slot;
}


/** @pdOid c713888f-fa95-4176-b14b-89cc95d0baa9 */
public void ddo() {
   // TODO: implement
	   Singleton.getInstance().getComandManager().getKomande().push(this);

}

/** @pdOid 5477f42d-ff08-4315-bda3-ab6073167c66 */
public void undo() {
   // TODO: implement
	if(deljeniSlot !=null)
		deljeniSlot.setMaticnaStranica(stranica);
	   stranica.addSlotovi(slot);

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