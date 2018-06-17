/***********************************************************************
 * Module:  RemoveElementCommand.java
 * Author:  sale
 * Purpose: Defines the Class RemoveElementCommand
 ***********************************************************************/

package etapa3.controller;

import java.util.*;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;

/** @pdOid 11af28c3-11b0-485f-a37b-fe401a761f1d */
public class RemoveElementCommand extends etapa2.controller.Command {
	private Slot slot;
	private AbstractElement element;

	public RemoveElementCommand(AbstractElement element, Slot slot) {
		super();
		this.element = element;
		this.slot = slot;
	}


	/** @pdOid c713888f-fa95-4176-b14b-89cc95d0baa9 */
	public void ddo() {
	   // TODO: implement
		   Singleton.getInstance().getComandManager().getKomande().push(this);

	}

	/** @pdOid 5477f42d-ff08-4315-bda3-ab6073167c66 */
	public void undo() {
	   // TODO: implement
		   slot.addElement(element);
	}

	public Slot getSlot() {
		return slot;
	}

	public void setSlot(Slot slot) {
		this.slot = slot;
	}


	public AbstractElement getElement() {
		return element;
	}


	public void setElement(AbstractElement element) {
		this.element = element;
	}

}