package com.akshay.interviewQuestions;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MemLeak {
    public final String key;
    
    public MemLeak(String key) {
        this.key =key;
    }
    
    public static void main(String args[]) {
        try {
            Map map = System.getProperties();
            Set<Object> keys = map.keySet();
            
            Scanner userInput = new Scanner(System.in);
            userInput.hasNext();
            
            
            for (Object key: keys) {
            	System.out.println("Key: " + key.toString() + " Value: " + map.get(key));
            }
            
            for(;;) {
                map.put(new MemLeak("key"), "value");
            }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}