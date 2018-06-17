/***********************************************************************
 * Module:  RemoveStranicaCommand.java
 * Author:  Leonidas
 * Purpose: Defines the Class RemoveStranicaCommand
 ***********************************************************************/

package etapa2.controller;

import etapa1.model.Dokument;
import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;

/** @pdOid 137a79f9-541f-4e06-80fe-12d5cb300440 */
public class RemoveStranicaCommand extends Command {
	   /** @pdOid 3cf20db2-74bb-4701-a949-734c6280b5fd */
	   private Stranica stranica;
	   /** @pdOid 9bbfbdf9-f141-488d-98e8-a8c4adde465e */
	   private Dokument dokument;
	   /** @pdOid f2d39e68-818c-4720-9375-ea7f7d1c7c6e */
	   private Stranica deljenaStranica;


   public RemoveStranicaCommand(Stranica stranica, Dokument dokument, Stranica deljenaStranica) {
	super();
	this.stranica = stranica;
	this.dokument = dokument;
	this.deljenaStranica = deljenaStranica;
}

   /** @pdOid 81dc251a-6b51-438b-935c-865696a203c8 */
   public void ddo() {
      // TODO: implement
	   Singleton.getInstance().getComandManager().getKomande().push(this);
   }
   
   /** @pdOid 26fcdf0e-db9d-40f0-815f-ffdb754d97e2 */
   public void undo() {
      // TODO: implement
	   if(deljenaStranica!=null)
		   deljenaStranica.setMaticniDokument(dokument);
	   dokument.addStranice(stranica); 
   }

public Stranica getStranica() {
	return stranica;
}

public void setStranica(Stranica stranica) {
	this.stranica = stranica;
}

public Dokument getDokument() {
	return dokument;
}

public void setDokument(Dokument dokument) {
	this.dokument = dokument;
}


}