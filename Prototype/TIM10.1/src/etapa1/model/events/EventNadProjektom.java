/***********************************************************************
 * Module:  EventNadProjektom.java
 * Author:  SALE
 * Purpose: Defines the Class EventNadProjektom
 ***********************************************************************/

package etapa1.model.events;

import etapa1.model.Projekat;

/** @pdOid 72819229-6662-4b2b-86c8-0aa8e9bb2de9 */
public class EventNadProjektom extends AbstractEvent {
   /** @pdOid 7105c38e-1104-4116-89b1-cad83bdb18f7 */
   protected Projekat projekat;

public Projekat getProjekat() {
	return projekat;
}

public void setProjekat(Projekat projekat) {
	this.projekat = projekat;
}

public EventNadProjektom(Projekat projekat) {
	super();
	this.projekat = projekat;
}
   
   

}