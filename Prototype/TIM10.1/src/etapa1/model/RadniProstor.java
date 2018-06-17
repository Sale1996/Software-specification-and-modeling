/***********************************************************************
 * Module:  RadniProstor.java
 * Author:  sale
 * Purpose: Defines the Class RadniProstor
 ***********************************************************************/

package etapa1.model;

import java.io.Serializable;

import etapa1.model.events.EventAddProjekat;
import etapa1.model.events.EventEditImeRadniProstor;
import etapa1.model.events.EventRemoveProjekat;

/** @pdOid 8059edc1-1ad6-434f-95c3-1d741fe2abd4 */
public class RadniProstor extends Komponenta {
   /** @pdRoleInfo migr=no name=Projekat assc=association5 coll=java.util.List impl=java.util.ArrayList mult=0..* type=Aggregation */
   public java.util.List<Projekat> Projekti;
   
   /** @param noviNaziv
    * @pdOid 3b7512ce-dae9-480b-a5dd-339962bf9c40 */
   public void promenaImena(String noviNaziv) {
      // TODO: implement
	   this.naziv=noviNaziv;
	   setChanged();
	   EventEditImeRadniProstor event = new EventEditImeRadniProstor(this,noviNaziv);
	   notifyObservers(event);
	   
   }
   
   
   /** @pdGenerated default getter */
   public java.util.List<Projekat> getProjekti() {
      if (Projekti == null)
         Projekti = new java.util.ArrayList<Projekat>();
      return Projekti;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProjekti() {
      if (Projekti == null)
         Projekti = new java.util.ArrayList<Projekat>();
      return Projekti.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProjekti */
   public void setProjekti(java.util.List<Projekat> newProjekti) {
      removeAllProjekti();
      for (java.util.Iterator iter = newProjekti.iterator(); iter.hasNext();)
         addProjekti((Projekat)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProjekat */
   public void addProjekti(Projekat newProjekat) {
      if (newProjekat == null)
         return;
      if (this.Projekti == null)
         this.Projekti = new java.util.ArrayList<Projekat>();
      if (!this.Projekti.contains(newProjekat))
      {
    	  this.Projekti.add(newProjekat);
    	  if(newProjekat.getMaticniRP()==null){
    		  newProjekat.setMaticniRP(this); //dodela maticnog radnog prostora ovom projektu da je ovaj radni prsotor
          
    	  }else{
    		  newProjekat.addDeljenURadnomProstoru(this);
    	  }
    	  setChanged();
          EventAddProjekat event = new EventAddProjekat(this,newProjekat);
   	   	  notifyObservers(event);

      }
   }
   
   /** @pdGenerated default remove
     * @param oldProjekat */
   public void removeProjekti(Projekat oldProjekat) {
      if (oldProjekat == null)
         return;
      if (this.Projekti != null)
         if (this.Projekti.contains(oldProjekat))
         {
            this.Projekti.remove(oldProjekat);
            if(oldProjekat.getMaticniRP() != this)
            	oldProjekat.removeDeljenURadnomProstoru(this); //u slucaju brisanaj deljenogo ovo radimo
            setChanged();
            EventRemoveProjekat event = new EventRemoveProjekat(oldProjekat,this);
            notifyObservers(event);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProjekti() {
      if (Projekti != null)
      {
         Projekat oldProjekat;
         for (java.util.Iterator iter = getIteratorProjekti(); iter.hasNext();)
         {
            oldProjekat = (Projekat)iter.next();
            iter.remove();
            oldProjekat.removeDeljenURadnomProstoru(this);
         }
      }
   }

}