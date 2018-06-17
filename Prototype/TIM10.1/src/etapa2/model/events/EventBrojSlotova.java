/***********************************************************************
 * Module:  EventBrojSlotova.java
 * Author:  ra215-2015
 * Purpose: Defines the Class EventBrojSlotova
 ***********************************************************************/

package etapa2.model.events;

import java.util.*;

import etapa2.model.Stranica;

/** Event klasa koja nam sluzi kao dobavljac informacije kojoj stranici je koliko broj slotova dodat
 * 
 * @pdOid 02cd1dde-3378-4d5f-a6f7-064885ad3592 */
public class EventBrojSlotova extends EventNadStranicom {
   public EventBrojSlotova(Stranica stranica,int brojSlota) {
		super(stranica);
		// TODO Auto-generated constructor stub
		this.brojSlota=brojSlota;
	}

/** @pdOid f4b82f29-0342-45c8-9816-e1e59959fe7f */
   private int brojSlota;

}