/***********************************************************************
 * Module:  EditIndexStranicaCommand.java
 * Author:  Leonidas
 * Purpose: Defines the Class EditIndexStranicaCommand
 ***********************************************************************/

package etapa2.controller;

import etapa1.ostalo.Singleton;
import etapa2.model.Stranica;

/** Komanda za menjanje indexa stranice
 * 
 * @pdOid 72acfb3e-f195-4f8d-9d20-f7f4fe4c33e8 */
public class EditIndexStranicaCommand extends Command {
   /** @pdOid ceafe4e1-c9e0-485d-8ac8-fe7ad98544e4 */
   private Stranica stranica;
   /** @pdOid 2bb1dd91-4051-4fd8-9575-2f65fa8c4d5a */
   private int index; //stari index
   
   /** @pdOid 33d855ee-f709-4404-afd1-b427d52dcde2 */
   public void ddo() {
      // TODO: implement
		Singleton.getInstance().getComandManager().getKomande().push(this); //ubacili smo da je izvresna ova komanda!

   }
   
   /** @pdOid 9313f014-9e2a-4bc4-b117-4d7b08068953 */
   public void undo() {
      // TODO: implement
	   stranica.setRedniBrojIndeksa(index);
   }

public EditIndexStranicaCommand(Stranica stranica, int index) {
	super();
	this.stranica = stranica;
	this.index = index;
}

}