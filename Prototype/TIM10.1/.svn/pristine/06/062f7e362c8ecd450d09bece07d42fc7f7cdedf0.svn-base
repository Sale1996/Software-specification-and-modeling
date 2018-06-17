/***********************************************************************
 * Module:  Singleton.java
 * Author:  sale
 * Purpose: Defines the Class Singleton
 ***********************************************************************/

package etapa1.ostalo;

import java.io.File;
import java.util.Observable;

import etapa1.model.Dokument;
import etapa1.model.Projekat;
import etapa1.model.RadniProstor;
import etapa1.model.events.EventAddRadniProstor;
import etapa1.model.events.EventCloseRadniProstor;
import etapa1.model.events.EventOpenRadniProstor;
import etapa1.model.events.EventRemoveRadniProstor;
import etapa2.controller.CommandManager;

/** @pdOid ed97d4c5-6289-4b49-85a0-02a1d08227f5 */
public class Singleton extends Observable {
   /** @pdOid e99398bf-4da3-4042-aebd-705e289c0763 */
   private static Singleton instance;
   /** @pdOid aaf19924-221e-4252-bd3a-af577cb67dd6 */
   public RadniProstor trenutniRadniProstor;
   /** @pdOid 57fae4c4-1e92-4ac8-9f68-ab061a90e5fd */
   private static CommandManager comandManager;
   
   /** @pdRoleInfo migr=no name=Singleton assc=association1 mult=0..1 */
   public Singleton singletonB;
   /** @pdRoleInfo migr=no name=Dokument assc=association2 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Dokument> slobodniDokumenti;
   /** @pdRoleInfo migr=no name=Projekat assc=association3 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<Projekat> slobodniProjekti;
   /** @pdRoleInfo migr=no name=RadniProstor assc=association4 coll=java.util.List impl=java.util.ArrayList mult=0..* */
   public java.util.List<RadniProstor> radniProstori;
   
   /** @pdOid 53e07437-fffd-4f5f-8b9a-1dc86d946bf4 */
   public static Singleton getInstance() {
	   if (instance == null){
			instance = new Singleton();
			comandManager=new CommandManager();
		}
     return instance;
   }
   
   /** @pdOid 90e1f3b7-249d-4245-b5b0-5c12aa92a68b */
   public void openRadniProstor(RadniProstor radniProstor) {
	   this.trenutniRadniProstor= radniProstor;
	   setChanged();
	   EventOpenRadniProstor event = new EventOpenRadniProstor(radniProstor);
	   notifyObservers(event);
      // TODO: implement
   }
   
   /** @pdOid 31c71169-4b77-4dbb-8d79-f0fffc8c8544 */
   public void closeRadniProstor() {
	   this.trenutniRadniProstor=null;
	   setChanged();
	   EventCloseRadniProstor event = new EventCloseRadniProstor(trenutniRadniProstor);
	   notifyObservers(event);
      // TODO: implement
   }
   
   
   public void dodajRadniProstor(RadniProstor radniProstor1){
	   this.trenutniRadniProstor= radniProstor1;
	   addRadniProstori(radniProstor1);
	   setChanged();
	   EventAddRadniProstor event = new EventAddRadniProstor(radniProstor1);
	   notifyObservers(event);
	   
	   
   }
   
   public void obrisiRadniProstor(RadniProstor radniProstor1){
	   this.trenutniRadniProstor = null;
	   setChanged();
	   EventRemoveRadniProstor event = new EventRemoveRadniProstor(radniProstor1);
	   notifyObservers(event);
   }
   
   
   
   //rad sa listom
   
   /** @pdGenerated default getter */
   public java.util.List<Dokument> getSlobodniDokumenti() {
      if (slobodniDokumenti == null)
         slobodniDokumenti = new java.util.ArrayList<Dokument>();
      return slobodniDokumenti;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSlobodniDokumenti() {
      if (slobodniDokumenti == null)
         slobodniDokumenti = new java.util.ArrayList<Dokument>();
      return slobodniDokumenti.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSlobodniDokumenti */
   public void setSlobodniDokumenti(java.util.List<Dokument> newSlobodniDokumenti) {
      removeAllSlobodniDokumenti();
      for (java.util.Iterator iter = newSlobodniDokumenti.iterator(); iter.hasNext();)
         addSlobodniDokumenti((Dokument)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newDokument */
   public void addSlobodniDokumenti(Dokument newDokument) {
      if (newDokument == null)
         return;
      if (this.slobodniDokumenti == null)
         this.slobodniDokumenti = new java.util.ArrayList<Dokument>();
      if (!this.slobodniDokumenti.contains(newDokument))
         this.slobodniDokumenti.add(newDokument);
   }
   
   /** @pdGenerated default remove
     * @param oldDokument */
   public void removeSlobodniDokumenti(Dokument oldDokument) {
      if (oldDokument == null)
         return;
      if (this.slobodniDokumenti != null)
         if (this.slobodniDokumenti.contains(oldDokument))
            this.slobodniDokumenti.remove(oldDokument);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSlobodniDokumenti() {
      if (slobodniDokumenti != null)
         slobodniDokumenti.clear();
   }
   /** @pdGenerated default getter */
   public java.util.List<Projekat> getSlobodniProjekti() {
      if (slobodniProjekti == null)
         slobodniProjekti = new java.util.ArrayList<Projekat>();
      return slobodniProjekti;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorSlobodniProjekti() {
      if (slobodniProjekti == null)
         slobodniProjekti = new java.util.ArrayList<Projekat>();
      return slobodniProjekti.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newSlobodniProjekti */
   public void setSlobodniProjekti(java.util.List<Projekat> newSlobodniProjekti) {
      removeAllSlobodniProjekti();
      for (java.util.Iterator iter = newSlobodniProjekti.iterator(); iter.hasNext();)
         addSlobodniProjekti((Projekat)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProjekat */
   public void addSlobodniProjekti(Projekat newProjekat) {
      if (newProjekat == null)
         return;
      if (this.slobodniProjekti == null)
         this.slobodniProjekti = new java.util.ArrayList<Projekat>();
      if (!this.slobodniProjekti.contains(newProjekat))
         this.slobodniProjekti.add(newProjekat);
   }
   
   /** @pdGenerated default remove
     * @param oldProjekat */
   public void removeSlobodniProjekti(Projekat oldProjekat) {
      if (oldProjekat == null)
         return;
      if (this.slobodniProjekti != null)
         if (this.slobodniProjekti.contains(oldProjekat))
            this.slobodniProjekti.remove(oldProjekat);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllSlobodniProjekti() {
      if (slobodniProjekti != null)
         slobodniProjekti.clear();
   }
   

   /** @pdGenerated default getter */
   public java.util.List<RadniProstor> getRadniProstori() {
      if (radniProstori == null)
         radniProstori = new java.util.ArrayList<RadniProstor>();
      return radniProstori;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorRadniProstori() {
      if (radniProstori == null)
         radniProstori = new java.util.ArrayList<RadniProstor>();
      return radniProstori.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newRadniProstori */
   public void setRadniProstori(java.util.List<RadniProstor> newRadniProstori) {
      removeAllRadniProstori();
      for (java.util.Iterator iter = newRadniProstori.iterator(); iter.hasNext();)
         addRadniProstori((RadniProstor)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newRadniProstor */
   public void addRadniProstori(RadniProstor newRadniProstor) {
      if (newRadniProstor == null)
         return;
      if (this.radniProstori == null)
         this.radniProstori = new java.util.ArrayList<RadniProstor>();
      if (!this.radniProstori.contains(newRadniProstor))
         this.radniProstori.add(newRadniProstor);
   }
   
   /** @pdGenerated default remove
     * @param oldRadniProstor */
   public void removeRadniProstori(RadniProstor oldRadniProstor) {
      if (oldRadniProstor == null)
         return;
      if (this.radniProstori != null)
         if (this.radniProstori.contains(oldRadniProstor))
            this.radniProstori.remove(oldRadniProstor);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllRadniProstori() {
      if (radniProstori != null)
         radniProstori.clear();
   }
public CommandManager getComandManager() {
	return comandManager;
}

public void setComandManager(CommandManager comandManager) {
	this.comandManager = comandManager;
}

}