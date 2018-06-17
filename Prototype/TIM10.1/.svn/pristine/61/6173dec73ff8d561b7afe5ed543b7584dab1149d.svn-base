/***********************************************************************
 * Module:  Slot.java
 * Author:  sale
 * Purpose: Defines the Class Slot
 ***********************************************************************/

package etapa3.model;

import java.util.Observable;

import etapa2.model.Stranica;
import etapa3.model.events.EventAddElement;
import etapa3.model.events.EventRemoveElement;

/** Kada kreiramo novi slot, creator polje se instancira na new TextCreator, 
 * dok ako bi imali vise "plugina" onda bi stavili dijalog da biramo koji hocemo Creator da napravimo..
 * i onda kada smo to uradili , u akciji dodavanja novog elementa u slotu, mi cemo uzeti creator iz tog slota (koji ce biti u ovom slucaju textCreator)
 * napravicemo novi element tako sto cemo uzeti creator.create() i tu napraviti element i onda taj element samo ubaciti u slot!!
 * 
 * @pdOid b311d17e-37c3-40dc-9ff5-cadc5e28f285 */
public class Slot extends Observable {
   /** @pdOid cff63091-2b5b-4a44-9b95-aad4a2ed8047 */
   private Stranica maticnaStranica;
   /** @pdOid 7cd8d84a-c481-4a7a-87fd-e3fa7dd72626 */
   private Creator creator;
   
   /** @pdRoleInfo migr=no name=AbstractElement assc=association3 mult=1..1 type=Composition */
   public AbstractElement abstractElement;  
   /** @pdRoleInfo migr=no name=Stranica assc=association2 coll=java.util.List impl=java.util.ArrayList mult=1..* side=A */
   public java.util.List<Stranica> sadrzanUStranicama;
   
   public Slot() {
		super();
		creator = new TextCreator();
	}
   
   /** @pdOid 317f99c3-a14a-4ce1-a9fc-10746e0e6e09 */
   public void shareSlot() {
      // TODO: implement
   }
   
   /** @pdOid 01b82350-d0f0-4846-916f-3af5c6bf7374 */
   public void detachSlot() {
      // TODO: implement
   }
   
   /** @param element
    * @pdOid b1573533-3433-4237-8475-9b08b52e1eb8 */
   public void addElement(AbstractElement element) {
      // TODO: implement
	   this.abstractElement = element;
	   setChanged();
	   EventAddElement event= new EventAddElement(element,this);
	   notifyObservers(event);
   }
   
   /** @param element
    * @pdOid 39c64fb3-b2a2-4a8f-8264-f4336586839f */
   public void removeElement(AbstractElement element) {
	   this.abstractElement=null;
	   setChanged();
	   EventRemoveElement event = new EventRemoveElement(element, this);
	   notifyObservers(event);
	   // TODO: implement
	   
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Stranica> getSadrzanUStranicama() {
      if (sadrzanUStranicama == null)
         sadrzanUStranicama = new java.util.ArrayList<Stranica>();
      return sadrzanUStranicama;
   }
   
  

/** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSadrzanUStranicama() {
      if (sadrzanUStranicama == null)
         sadrzanUStranicama = new java.util.ArrayList<Stranica>();
      return sadrzanUStranicama.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSadrzanUStranicama */
   public void setSadrzanUStranicama(java.util.List<Stranica> newSadrzanUStranicama) {
      removeAllSadrzanUStranicama();
      for (java.util.Iterator iter = newSadrzanUStranicama.iterator(); iter.hasNext();)
         addSadrzanUStranicama((Stranica)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStranica */
   public void addSadrzanUStranicama(Stranica newStranica) {
      if (newStranica == null)
         return;
      if (this.sadrzanUStranicama == null)
         this.sadrzanUStranicama = new java.util.ArrayList<Stranica>();
      if (!this.sadrzanUStranicama.contains(newStranica))
      {
         this.sadrzanUStranicama.add(newStranica);
         newStranica.addSlotovi(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStranica */
   public void removeSadrzanUStranicama(Stranica oldStranica) {
      if (oldStranica == null)
         return;
      if (this.sadrzanUStranicama != null)
         if (this.sadrzanUStranicama.contains(oldStranica))
         {
            this.sadrzanUStranicama.remove(oldStranica);
            oldStranica.removeSlotovi(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSadrzanUStranicama() {
      if (sadrzanUStranicama != null)
      {
         Stranica oldStranica;
         for (java.util.Iterator iter = getIteratorSadrzanUStranicama(); iter.hasNext();)
         {
            oldStranica = (Stranica)iter.next();
            iter.remove();
            oldStranica.removeSlotovi(this);
         }
      }
   }

public Stranica getMaticnaStranica() {
	return maticnaStranica;
}

public void setMaticnaStranica(Stranica maticnaStranica) {
	this.maticnaStranica = maticnaStranica;
}

public Creator getCreator() {
	return creator;
}

public void setCreator(Creator creator) {
	this.creator = creator;
}

public AbstractElement getAbstractElement() {
	return abstractElement;
}

public void setAbstractElement(AbstractElement abstractElement) {
	this.abstractElement = abstractElement;
}



}