/***********************************************************************
 * Module:  Projekat.java
 * Author:  sale
 * Purpose: Defines the Class Projekat
 ***********************************************************************/

package etapa1.model;

import java.io.Serializable;

import etapa1.model.events.EventAddDokument;
import etapa1.model.events.EventEditImeProjekat;
import etapa1.model.events.EventEditImeRadniProstor;
import etapa1.model.events.EventRemoveDokument;

/** @pdOid e8952809-6fa8-4994-a48a-f0c142f24f0d */
public class Projekat extends Komponenta {
   /** @pdOid 2bbb5c38-2453-4df1-9d9a-83d17c5e27e8 */
   private RadniProstor maticniRP;
   
   /** @pdRoleInfo migr=no name=Dokument assc=association6 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Aggregation */
   public java.util.List<Dokument> dokumenti;
   /** @pdRoleInfo migr=no name=RadniProstor assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* side=A */
   public java.util.List<RadniProstor> deljenURadnomProstoru;
   
   /** @param projekat
    * @pdOid c1339c15-ee19-4254-9b5d-0a1ccc182ef3 */
   public void shareProjekat(Projekat projekat) {
      // TODO: implement
   }
   
   /** @param projekat
    * @pdOid 16c41aa5-768d-415c-80df-d43c7f464e67 */
   public void detachProjekat(Projekat projekat) {
      // TODO: implement
   }
   
   /** @param noviNaziv
    * @pdOid 785ec445-2bb4-4932-901d-627da290328b */
   public void promenaImena(String noviNaziv) {
      // TODO: implement
	   this.naziv=noviNaziv;
	   setChanged();
	   EventEditImeProjekat event = new EventEditImeProjekat(this,noviNaziv);
	   notifyObservers(event);
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Dokument> getDokumenti() {
      if (dokumenti == null)
         dokumenti = new java.util.ArrayList<Dokument>();
      return dokumenti;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDokumenti() {
      if (dokumenti == null)
         dokumenti = new java.util.ArrayList<Dokument>();
      return dokumenti.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDokumenti */
   public void setDokumenti(java.util.List<Dokument> newDokumenti) {
      removeAllDokumenti();
      for (java.util.Iterator iter = newDokumenti.iterator(); iter.hasNext();)
         addDokumenti((Dokument)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDokument */
   public void addDokumenti(Dokument newDokument) {
      if (newDokument == null)
         return;
      if (this.dokumenti == null)
         this.dokumenti = new java.util.ArrayList<Dokument>();
      if (!this.dokumenti.contains(newDokument))
      {
         this.dokumenti.add(newDokument);
         if(newDokument.getMaticniProjekat() == null)
        	 newDokument.setMaticniProjekat(this);
         else
        	 newDokument.addDeljenUProjektima(this);
         setChanged();
         EventAddDokument event = new EventAddDokument(this,newDokument);
         notifyObservers(event);
      }
   }
   
   /** @pdGenerated default remove
     * @param oldDokument */
   public void removeDokumenti(Dokument oldDokument) {
      if (oldDokument == null)
         return;
      if (this.dokumenti != null)
         if (this.dokumenti.contains(oldDokument))
         {
            this.dokumenti.remove(oldDokument);
            if(oldDokument.getMaticniProjekat() != this)
            	oldDokument.removeDeljenUProjektima(this);
            setChanged();
            EventRemoveDokument event = new EventRemoveDokument(oldDokument,this);
            notifyObservers(event);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDokumenti() {
      if (dokumenti != null)
      {
         Dokument oldDokument;
         for (java.util.Iterator iter = getIteratorDokumenti(); iter.hasNext();)
         {
            oldDokument = (Dokument)iter.next();
            iter.remove();
            oldDokument.removeDeljenUProjektima(this);
         }
      }
   }
   /** @pdGenerated default getter */
   public java.util.List<RadniProstor> getDeljenURadnomProstoru() {
      if (deljenURadnomProstoru == null)
         deljenURadnomProstoru = new java.util.ArrayList<RadniProstor>();
      return deljenURadnomProstoru;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorDeljenURadnomProstoru() {
      if (deljenURadnomProstoru == null)
         deljenURadnomProstoru = new java.util.ArrayList<RadniProstor>();
      return deljenURadnomProstoru.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newDeljenURadnomProstoru */
   public void setDeljenURadnomProstoru(java.util.List<RadniProstor> newDeljenURadnomProstoru) {
      removeAllDeljenURadnomProstoru();
      for (java.util.Iterator iter = newDeljenURadnomProstoru.iterator(); iter.hasNext();)
         addDeljenURadnomProstoru((RadniProstor)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRadniProstor */
   public void addDeljenURadnomProstoru(RadniProstor newRadniProstor) {
      if (newRadniProstor == null)
         return;
      if (this.deljenURadnomProstoru == null)
         this.deljenURadnomProstoru = new java.util.ArrayList<RadniProstor>();
      if (!this.deljenURadnomProstoru.contains(newRadniProstor))
      {
         this.deljenURadnomProstoru.add(newRadniProstor);
         newRadniProstor.addProjekti(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldRadniProstor */
   public void removeDeljenURadnomProstoru(RadniProstor oldRadniProstor) {
      if (oldRadniProstor == null)
         return;
      if (this.deljenURadnomProstoru != null)
         if (this.deljenURadnomProstoru.contains(oldRadniProstor))
         {
            this.deljenURadnomProstoru.remove(oldRadniProstor);
            oldRadniProstor.removeProjekti(this);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllDeljenURadnomProstoru() {
      if (deljenURadnomProstoru != null)
      {
         RadniProstor oldRadniProstor;
         for (java.util.Iterator iter = getIteratorDeljenURadnomProstoru(); iter.hasNext();)
         {
            oldRadniProstor = (RadniProstor)iter.next();
            iter.remove();
            oldRadniProstor.removeProjekti(this);
         }
      }
   }

public RadniProstor getMaticniRP() {
	return maticniRP;
}

public void setMaticniRP(RadniProstor maticniRP) {
	this.maticniRP = maticniRP;
}

}