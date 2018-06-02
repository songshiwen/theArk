/* Lösungsversuch Aufgabe 1 Assignment 2
 * Einlesen der Datei in doppelt verkette Liste
 * Noch nicht Final! 
 * Aktuelle Probleme: Ersten beiden Elemente null
 * writeList() dokumentiert Einlesevorgang, bzw gibt die Liste in der Konsole aus
 */
package org.mytuc.dstruc.group12;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class AnimalBoarding { 


    ListElement startElem = new ListElement(null); /* Kopfelement der doppelt verkettenen Liste */
    ListElement tailElem = new ListElement(null);  /* Schwanz der Kette */

    public AnimalBoarding() { 
        startElem.setNextElem(tailElem); 
        tailElem.setPrevElem(startElem); 
    } 

    public void addLast(Object o){ 
        ListElement newElem = new ListElement(o); 
        ListElement lastElem = getLastElem(); 
        lastElem.setNextElem(newElem); 
        newElem.setPrevElem(lastElem); 
    } 

    public void insertAfter(Object prevItem, Object newItem) { 
        ListElement newElem, nextElem = null, pointerElem; 
        pointerElem = startElem.getNextElem(); 
        while(pointerElem != null && !pointerElem.getObj().equals(prevItem)){ 
            pointerElem = pointerElem.getNextElem(); 
        } 
        newElem = new ListElement(newItem); 
        if(pointerElem != null){ 
            nextElem = pointerElem.getNextElem(); 
            pointerElem.setNextElem(newElem); 
            newElem.setNextElem(nextElem); 
            newElem.setPrevElem(pointerElem); 
        } 
        if(nextElem != null) 
            nextElem.setPrevElem(newElem); 
    } 
     
    public void insertBefore(Object insertItem, Object newItem){ 
        ListElement newElem, pointerElem; 
        newElem = new ListElement(newItem); 
        pointerElem = startElem.getNextElem(); 
        while(pointerElem != null){ 
            if(pointerElem.getObj().equals(insertItem)){ 
                newElem.setPrevElem(pointerElem.getPrevElem()); 
                pointerElem.getPrevElem().setNextElem(newElem); 
                pointerElem.setPrevElem(newElem); 
                newElem.setNextElem(pointerElem); 
                break; 
            } 
            pointerElem = pointerElem.getNextElem(); 
        } 
    } 

    public void delete(Object o){ 
        ListElement le = startElem; 
        while (le.getNextElem() != null && !le.getObj().equals(o)){ 
            if(le.getNextElem().getObj().equals(o)){ 
                if(le.getNextElem().getNextElem()!=null){ 
                    le.setNextElem(le.getNextElem().getNextElem()); 
                    le.getNextElem().setPrevElem(le); 
                }else{ 
                    le.setNextElem(null); 
                    break; 
                } 
            } 
            le = le.getNextElem(); 
        } 
    } 
     

    public boolean find(Object o){ 
        ListElement le = startElem; 
        while (le != null){ 
            if(le.getObj().equals(o)) 
            return true; 
            le = le.nextElem; 
        } 
        return false; 
    } 
     

    public ListElement getFirstElem() { 
        return startElem; 
    } 

    public ListElement getLastElem() { 
        ListElement le = startElem; 
        while(le.getNextElem() != null){ 
            le = le.getNextElem(); 
        } 
        return le; 
    } 

    public void writeList() { 
        ListElement le = startElem; 
        while(le != null){ 
            System.out.println(le.getObj()); 
            le = le.getNextElem(); 
        } 
    } 
    
    
    public static void main(String[] args) throws IOException  { 
        AnimalBoarding list = new AnimalBoarding();
        Scanner diskScanner = new Scanner(new File ("tierliste.txt"));
    	 while (diskScanner.hasNext()) {
    		list.addLast (diskScanner.nextLine());
    		
    	}
    	 diskScanner.close(); 
        
    	// list.addLast ("Pferd;Axel;m;150;100"); // Test zum manuellen einfügen in Liste
    
       
    	
        // System.out.println("erstes Element: " + list.getFirstElem().getObj()); 
       // System.out.println("letztes Element: " + list.getLastElem().getObj()); 
       // System.out.println("vorletztes Element: " + list.getLastElem().getPrevElem().getObj()); 
        list.writeList(); 
    } 
} 

class ListElement { 


    Object obj; 

    ListElement nextElem, prevElem; 

    public ListElement(Object obj) { 
        this.obj = obj; 
        nextElem = null; 
    } 

    public void setNextElem(ListElement nextElem) { 
        this.nextElem = nextElem; 
    } 
     
    public void setPrevElem(ListElement prevElem) { 
        this.prevElem = prevElem; 
    } 

    public ListElement getNextElem() { 
        return nextElem; 
    } 
     
    public ListElement getPrevElem() { 
        return this.prevElem; 
    } 

    public Object getObj() { 
        return obj; 
    } 
} 
