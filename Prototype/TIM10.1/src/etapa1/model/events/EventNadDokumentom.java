/***********************************************************************
 * Module:  EventNadDokumentom.java
 * Author:  SALE
 * Purpose: Defines the Class EventNadDokumentom
 ***********************************************************************/

package etapa1.model.events;

import etapa1.model.Dokument;

/** @pdOid 9c3e63f1-63d6-4aa2-bf6c-801a622bcd6d */
public class EventNadDokumentom  extends AbstractEvent{
   /** @pdOid 24d989a5-f301-424b-9bc5-6ac159c8a2a7 */
   protected Dokument dokument;

public Dokument getDokument() {
	return dokument;
}

public void setDokument(Dokument dokument) {
	this.dokument = dokument;
}

public EventNadDokumentom(Dokument dokument) {
	super();
	this.dokument = dokument;
}
   

}