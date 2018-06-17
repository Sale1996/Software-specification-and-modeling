/***********************************************************************
 * Module:  EventEditImeRadniProstor.java
 * Author:  SALE
 * Purpose: Defines the Class EventEditImeRadniProstor
 ***********************************************************************/

package etapa1.model.events;

import etapa1.model.RadniProstor;

/** @pdOid 63a8e1e5-7a63-4c56-8c19-c3f211cbf78a */
public class EventEditImeRadniProstor extends EventPromenaImena {
   /** @pdOid 0afcedab-9e9e-4f06-a617-57fcc77097bb */
   private RadniProstor radnProstor;

public EventEditImeRadniProstor(RadniProstor radnProstor, String ime) {
	super(ime);
	this.radnProstor = radnProstor;
}

public RadniProstor getRadnProstor() {
	return radnProstor;
}

public void setRadnProstor(RadniProstor radnProstor) {
	this.radnProstor = radnProstor;
}

}