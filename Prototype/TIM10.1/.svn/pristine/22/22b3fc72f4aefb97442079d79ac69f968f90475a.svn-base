/***********************************************************************
 * Module:  EditTextElementCommand.java
 * Author:  ra35-2015
 * Purpose: Defines the Class EditTextElementCommand
 ***********************************************************************/

package etapa3.controller;

import etapa1.ostalo.Singleton;
import etapa3.model.AbstractElement;
import etapa3.model.events.EventEditTextElement;

/** @pdOid 22d6e0f2-d1a9-4fd7-9594-39ae3a4f1f6b */
public class EditTextElementCommand extends etapa2.controller.Command {
   /** @pdOid adc70c58-475f-4cf0-8e3f-9c1f744c0a80 */
   private String stariText;
   /** @pdOid 0b26170c-7933-4041-bf67-42520552f6be */
   private AbstractElement element;
	public EditTextElementCommand(String stariText, AbstractElement element) {
		super();
		this.stariText = stariText;
		this.element = element;
	}
	public String getStaroIme() {
		return stariText;
	}
	public void setStaroIme(String staroIme) {
		this.stariText = staroIme;
	}
	public AbstractElement getElement() {
		return element;
	}
	public void setElement(AbstractElement element) {
		this.element = element;
	}
	
	  /** @pdOid 97f0b9eb-7042-48c1-a559-4f03d544008e */
	   public void ddo() {
	      // TODO: implement
		   Singleton.getInstance().getComandManager().getKomande().push(this);
	   }
	   
	   /** @pdOid 03c33302-e7b6-4195-bda3-fb7a18a4b77b */
	   public void undo() {
	      // TODO: implement
		   element.promeniText(stariText);
		  
	   }
}