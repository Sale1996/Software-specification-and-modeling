/***********************************************************************
 * Module:  EventNadSlotom.java
 * Author:  sale
 * Purpose: Defines the Class EventNadSlotom
 ***********************************************************************/

package etapa3.model.events;

import etapa2.model.Stranica;
import etapa3.model.Slot;

/** @pdOid e6a4ce79-27a9-41c1-9378-305e5ec9f3d8 */
public class EventNadSlotom extends etapa1.model.events.AbstractEvent {
   /** @pdOid b933f0f1-90b7-4f89-a935-a8383f521945 */
   protected Slot slot;
   /** @pdOid d7caf51f-9cfe-4864-9496-4cb95c842117 */
   protected Stranica stranica;
public EventNadSlotom(Slot slot, Stranica stranica) {
	super();
	this.slot = slot;
	this.stranica = stranica;
}
public Slot getSlot() {
	return slot;
}
public void setSlot(Slot slot) {
	this.slot = slot;
}
public Stranica getStranica() {
	return stranica;
}
public void setStranica(Stranica stranica) {
	this.stranica = stranica;
}
   

}