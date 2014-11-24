package com.akshay.myJavaCollections;

import java.util.*;

/*
 * http://en.wikiversity.org/wiki/Java_Collections_Overview
 * http://java67.blogspot.in/2012/12/difference-between-array-vs-arraylist-java.html
 * http://www.codeproject.com/Articles/566609/Difference-between-Comparator-and-Comparable-in-Ja
 * http://www.javabeat.net/what-is-transient-keyword-in-java/
 * http://howtodoinjava.com/2012/10/09/working-with-hashcode-and-equals-methods-in-java/
 */

public class Experimenting implements Comparable<Experimenting>{

	public static void main(String[] args){
		
		Comparator<Experimenting> myComparator = new Comparator<Experimenting>() {
			
			@Override
			public int compare(Experimenting o1, Experimenting o2) {
				return 0;
			}
		};
		
		int[] array = new int[10];
		List<Integer> list;
		ArrayList<Integer> arrayList;
		LinkedList<Integer> linkedList;
		Vector<Integer> vector;
		Stack<Integer> stack;
		Set<Integer> set;
		HashSet<Integer> hashSet;
		LinkedHashSet<Integer> linkedHashSet;
		SortedSet<Integer> sertedSet;
		NavigableSet<Integer> navigableSet;
		TreeSet<Integer> treeSet;
		//EnumSet<Integer> enumSet;
		Queue<Integer> queue;
		PriorityQueue<Integer> priorityQueue;
		Deque<Integer> deque;
		ArrayDeque<Integer> arrayDeque;
		Map<Integer,Integer> map;
		HashMap<Integer, Integer> hashMap;
		SortedMap<Integer, Integer> sortedMap;
		NavigableMap<Integer, Integer> navigableMap;
		TreeMap<Integer, Integer> treeMap;
	}

	@Override
	public int compareTo(Experimenting o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
