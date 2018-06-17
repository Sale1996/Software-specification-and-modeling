/***********************************************************************
 * Module:  AddElementCommand.java
 * Author:  sale
 * Purpose: Defines the Class AddElementCommand
 ***********************************************************************/

package etapa3.controller;

import java.util.*;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;
import etapa3.model.AbstractElement;
import etapa3.model.Slot;

/** @pdOid f9d773d5-72a8-44ee-a69a-375c26d1246d */
public class AddElementCommand extends etapa2.controller.Command {
	private AbstractElement element;
	private Slot slot;
	   
	public AddElementCommand(AbstractElement element, Slot slot) {
		super();
		this.slot = slot;
		this.element = element;
	}
	
	 /** @pdOid 0409a514-024f-4683-9e10-d437e118a4f1 */
	public void ddo() {
	      // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this);

	   }
	   
	   /** @pdOid ba4c7a3e-b3b4-496c-93cb-f5b816d4d18c */
	public void undo() {
	      // TODO: implement
		   slot.removeElement(element); 

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