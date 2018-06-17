/***********************************************************************
 * Module:  CompositeElement.java
 * Author:  sale
 * Purpose: Defines the Class CompositeElement
 ***********************************************************************/

package etapa3.model;

import java.util.*;

/** @pdOid 713c792b-cb2b-42d9-8efb-c389e70c6d46 */
public class CompositeElement extends AbstractElement {
   /** @pdRoleInfo migr=no name=AbstractElement assc=association4 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<AbstractElement> elements;
   
   /** @pdOid adad7092-d673-4608-bd1e-49231e227384 */
   public void add() {
      // TODO: implement
   }
   
   /** @pdOid e961303d-7b72-466c-afca-78bf4316260d */
   public void remove() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<AbstractElement> getElements() {
      if (elements == null)
         elements = new java.util.HashSet<AbstractElement>();
      return elements;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorElements() {
      if (elements == null)
         elements = new java.util.HashSet<AbstractElement>();
      return elements.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newElements */
   public void setElements(java.util.Collection<AbstractElement> newElements) {
      removeAllElements();
      for (java.util.Iterator iter = newElements.iterator(); iter.hasNext();)
         addElements((AbstractElement)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newAbstractElement */
   public void addElements(AbstractElement newAbstractElement) {
      if (newAbstractElement == null)
         return;
      if (this.elements == null)
         this.elements = new java.util.HashSet<AbstractElement>();
      if (!this.elements.contains(newAbstractElement))
         this.elements.add(newAbstractElement);
   }
   
   /** @pdGenerated default remove
     * @param oldAbstractElement */
   public void removeElements(AbstractElement oldAbstractElement) {
      if (oldAbstractElement == null)
         return;
      if (this.elements != null)
         if (this.elements.contains(oldAbstractElement))
            this.elements.remove(oldAbstractElement);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
   }

}