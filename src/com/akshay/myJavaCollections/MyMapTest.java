package com.akshay.myJavaCollections;

import java.util.HashMap;
import java.util.Map;

public class MyMapTest {

	public static void main(String[] args) {
		// Standard Map
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    map.put("Lars", 1);
	    map.put("Lars", 2);
	    map.put("Lars", 1);
	    System.out.println(map.get("Lars"));

	    for (int i = 0; i < 100; i++) {
	      map.put(String.valueOf(i), i);
	    }
	    System.out.println(map.size());

	    System.out.println(map.get("51"));
	    map.keySet();
	     
	    // MyMap
	    MyMap<String, Integer> map2 = new MyMap<String, Integer>();
	    map2.put("Lars", 1);
	    map2.put("Lars", 2);
	    map2.put("Lars", 1);
	    System.out.println(map2.get("Lars"));
	    for (int i = 0; i < 100; i++) {
	      map2.put(String.valueOf(i), i);
	    }
	    
	    System.out.println(map.size());
	    System.out.println(map.get("51"));
	}
	
}
