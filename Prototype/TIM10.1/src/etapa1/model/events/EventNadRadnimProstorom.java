/***********************************************************************
 * Module:  EventNadRadnimProstorom.java
 * Author:  SALE
 * Purpose: Defines the Class EventNadRadnimProstorom
 ***********************************************************************/

package etapa1.model.events;

import etapa1.model.RadniProstor;

/** @pdOid e7452040-f169-4d4e-b6d6-52936da39bfc */
public class EventNadRadnimProstorom extends AbstractEvent {
   /** @pdOid ac5669e8-67cf-4f7f-bb7f-0a8e034ad9d4 */
   protected RadniProstor radniProstor;

public EventNadRadnimProstorom(RadniProstor radniProstor) {
	super();
	this.radniProstor = radniProstor;
}

public RadniProstor getRadniProstor() {
	return radniProstor;
}

public void setRadniProstor(RadniProstor radniProstor) {
	this.radniProstor = radniProstor;
}
   

}