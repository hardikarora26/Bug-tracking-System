package com.omung.bughound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class App {

 ArrayList<Integer> arr= new ArrayList<Integer>();
 
 public App(){
  
  arr.add(1);
  arr.add(4);
  arr.add(1);
  arr.add(2);
  arr.add(4);
  arr.add(4);
  arr.add(4);
  arr.add(4);
  }
 
 public void abc(){
  Iterator<Integer> it= arr.iterator();
  Map<Integer,Set<Integer>> map=new HashMap<Integer, Set<Integer>>(); 
  Set<Integer> setA= new HashSet<Integer>();
  while(it.hasNext())  {
   int value= (int) it.next();
   if(map.containsKey(value)){
  setA= map.get(value);
    setA.add(value); 
   }
   
   else{
    setA.add(value);
    map.put(value, setA);
   }
        }
  System.out.println(map);
 }
}

