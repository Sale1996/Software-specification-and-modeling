/***********************************************************************
 * Module:  EventRemoveStranica.java
 * Author:  SALE
 * Purpose: Defines the Class EventRemoveStranica
 ***********************************************************************/

package etapa2.model.events;

import etapa1.model.Dokument;
import etapa2.model.Stranica;

/** @pdOid aa9e4fdc-116c-4ff0-b243-6fba4b0a1f36 */
public class EventRemoveStranica extends EventNadStranicom {
	/** @pdOid bb33d2da-764f-4e07-bba5-995c5d558a3d */

   private Dokument dokument;

   public EventRemoveStranica(Stranica stranica,Dokument dokument) {
		super(stranica);
		this.dokument = dokument;
		// TODO Auto-generated constructor stub
	}

public Dokument getDokument() {
	return dokument;
}

public void setDokument(Dokument dokument) {
	this.dokument = dokument;
}


}