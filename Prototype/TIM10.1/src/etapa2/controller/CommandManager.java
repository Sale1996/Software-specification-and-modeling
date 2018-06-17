/***********************************************************************
 * Module:  CommandManager.java
 * Author:  SALE
 * Purpose: Defines the Class CommandManager
 ***********************************************************************/

package etapa2.controller;

import java.util.ArrayDeque;
import java.util.Deque;

/** on sadrzi sve comande koje su se do sada izvrsile u nekoj listi komandi i kada uradimo do dodaje se nova komanda u tu listu a kada uradimo undo onda se brise iz te liste zadnja komanda
 * 
 * @pdOid cf9be515-4ab5-455c-bd95-4dc99bb7b1ef */
public class CommandManager {
   /** @pdRoleInfo migr=no name=Command assc=association1 coll=java.util.Collection impl=java.util.Stack mult=0..* type=Composition */
   //public java.util.Collection<Command> komande;
   private Deque<Command> komande;
   public CommandManager() {
	// TODO Auto-generated constructor stub
	   komande = new ArrayDeque<Command>();
   }
   
public Deque<Command> getKomande() {
	return komande;
}
public void setKomande(Deque<Command> komande) {
	this.komande = komande;
}
   
   
  
   /** @pdOid 92e153aa-2f15-429f-92f0-4da2560263ce */
 /*  public int addCommand() {
	   // TODO: implement
      return 0;
   }
   
   /** @pdOid 71f594fe-4391-421b-a58c-be1c23a58984 */
  /* public int removeCommand() {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
 /*  public java.util.Collection<Command> getKomande() {
      if (Komande == null)
         Komande = new java.util.Stack<Command>();
      return Komande;
   }
   
   /** @pdGenerated default iterator getter */
 /*  public java.util.Iterator getIteratorKomande() {
      if (Komande == null)
         Komande = new java.util.Stack<Command>();
      return Komande.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newKomande */
 /*  public void setKomande(java.util.Collection<Command> newKomande) {
      removeAllKomande();
      for (java.util.Iterator iter = newKomande.iterator(); iter.hasNext();)
         addKomande((Command)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newCommand */
 /*  public void addKomande(Command newCommand) {
      if (newCommand == null)
         return;
      if (this.Komande == null)
         this.Komande = new java.util.Stack<Command>();
      if (!this.Komande.contains(newCommand))
         this.Komande.add(newCommand);
   }
   
   /** @pdGenerated default remove
     * @param oldCommand */
 /*  public void removeKomande(Command oldCommand) {
      if (oldCommand == null)
         return;
      if (this.Komande != null)
         if (this.Komande.contains(oldCommand))
            this.Komande.remove(oldCommand);
   }
   
   /** @pdGenerated default removeAll */
 /*  public void removeAllKomande() {
      if (Komande != null)
         Komande.clear();
   }*/

}