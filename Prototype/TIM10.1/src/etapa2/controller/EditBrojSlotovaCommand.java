/***********************************************************************
 * Module:  EditBrojSlotovaCommand.java
 * Author:  sale
 * Purpose: Defines the Class EditBrojSlotovaCommand
 ***********************************************************************/

package etapa2.controller;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;

/** Komanda za menjanje slotova stranice
 * 
 * @pdOid 9e781cee-d410-459e-84aa-7f67679ccb72 */
public class EditBrojSlotovaCommand extends Command {
   /** @pdOid 69aa64f6-2d80-4c8a-8dfc-9de1b147fbb3 */
   private Stranica stranica;
   /** @pdOid b04845e3-3976-4cf3-a5aa-8d022d29ae59 */
   private int brojSlotova; //stari broj slotova!
   
   public EditBrojSlotovaCommand(Stranica stranica, int brojSlotova) {
	super();
	this.stranica = stranica;
	this.brojSlotova = brojSlotova;
}

/** @pdOid fb3970ce-f449-4b30-89d1-bdb6d0c59801 */
   public void ddo() {
      // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this); //ubacili smo da je izvresna ova komanda!

   }
   
   /** @pdOid 334e93e8-9aa1-4ee8-965f-e39167a79dbe */
   public void undo() {
      // TODO: implement
	   stranica.setBrojSlotova(brojSlotova); //vracamo staru vrednost!
   }

}