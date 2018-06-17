/***********************************************************************
 * Module:  EventNadElementom.java
 * Author:  sale
 * Purpose: Defines the Class EventNadElementom
 ***********************************************************************/

package etapa3.model.events;

import etapa3.model.AbstractElement;
import etapa3.model.Slot;


/** @pdOid 0538d097-449e-4949-8ae3-ed1dca365ade */
public class EventNadElementom extends etapa1.model.events.AbstractEvent {
   /** @pdOid e9e0a388-41b6-4953-9c12-ab9d4482bf97 */
   protected AbstractElement element;
   /** @pdOid 2a0e58df-9973-4be4-9e8f-8637e4acc594 */
   protected Slot slot;
public EventNadElementom(AbstractElement element, Slot slot) {
	super();
	this.element = element;
	this.slot = slot;
}
public AbstractElement getElement() {
	return element;
}
public void setElement(AbstractElement element) {
	this.element = element;
}
public Slot getSlot() {
	return slot;
}
public void setSlot(Slot slot) {
	this.slot = slot;
}

}