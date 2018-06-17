/***********************************************************************
 * Module:  AbstractElement.java
 * Author:  Leonidas
 * Purpose: Defines the Class AbstractElement
 ***********************************************************************/

package etapa3.model;

import java.util.*;

import etapa3.controller.EditTextElementCommand;
import etapa3.model.events.EventEditTextElement;

/** @pdOid 98a4f435-54b0-4a33-92a3-77cf0046a5df */
public abstract class AbstractElement extends Observable {
   /** @pdRoleInfo migr=no name=Slot assc=association3 mult=1..1 side=A */
   public Slot slot;
		   
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