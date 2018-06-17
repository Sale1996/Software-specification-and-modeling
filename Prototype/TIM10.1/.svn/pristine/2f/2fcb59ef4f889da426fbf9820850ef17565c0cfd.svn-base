/***********************************************************************
 * Module:  TekstualniElement.java
 * Author:  sale
 * Purpose: Defines the Class TekstualniElement
 ***********************************************************************/

package etapa3.model;

import java.util.*;

import etapa3.model.events.EventEditTextElement;

/** @pdOid 3ae6a3bb-7154-451d-bf88-6e20043335b2 */
public class TekstualniElement extends AbstractElement {
	  String dataContext;

	   public String getDataContext() {
		  return dataContext;
	   }

	   public void promeniText(String dataContext){
		   EventEditTextElement event = new EventEditTextElement(this,slot,dataContext);   
		   this.dataContext = dataContext;
		   setChanged();
		   notifyObservers(event);

	   }
	   
	   public void setDataContext(String dataContext) {
		   
		   this.dataContext = dataContext;
	   }
}