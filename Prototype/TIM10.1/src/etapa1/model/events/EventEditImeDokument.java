/***********************************************************************
 * Module:  EventEditImeDokument.java
 * Author:  SALE
 * Purpose: Defines the Class EventEditImeDokument
 ***********************************************************************/

package etapa1.model.events;

import etapa1.model.Dokument;

/** @pdOid aaee737e-2408-4990-a7e7-587181109d26 */
public class EventEditImeDokument extends EventPromenaImena {
   public EventEditImeDokument(Dokument dokument1 ,String ime, String staroIme) {
		super(ime);
		dokument=dokument1;
		this.staroIme=staroIme;
		// TODO Auto-generated constructor stub
	}

/** @pdOid 67a4cfe9-4411-48ea-8f2d-700c98b105da */
   private Dokument dokument;
   private String staroIme;
public String getStaroIme() {
	return staroIme;
}
public void setStaroIme(String staroIme) {
	this.staroIme = staroIme;
}

}