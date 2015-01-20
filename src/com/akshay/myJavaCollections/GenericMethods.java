package com.akshay.myJavaCollections;

import java.util.ArrayList;
import java.util.List;

public class GenericMethods {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> l1 = new ArrayList<String>();
    	l1.add("One");
    	l1.add("Two");
		List<String> l2 = new ArrayList<String>();
		l2.add("Three");
		l2.add("Four");
		List<String> l3 = null;
		List<Integer> l4 = new ArrayList<Integer>();
		l4.add(1);
		l4.add(2);
		List<Integer> l5 = new ArrayList<Integer>();
		l5.add(3);
		l5.add(4);
		List<Integer> l6 = null;
		printList(l1);
		printList(l4);
		printList(combineList(l1, l2));
		printList(combineList(l1, l3));
		printList(combineList(l4, l5));
		printList(combineList(l4, l6));

	}
	
	public static <E> boolean isListNull(List<E> listOfObjects) {
		if (null != listOfObjects && listOfObjects.size() != 0)
			return false;
		return true;
	}
	
	public static <E> List<E> combineList(List<E> list1, List<E> list2) {
		if (isListNull(list1) && !isListNull(list2))
			return list2;
		else if (isListNull(list2) && !isListNull(list1))
			return list1;
		else if (isListNull(list1) && isListNull(list2))
			return null;
		else {
			List<E> fList = new ArrayList<E>();
			for (int i = 0; i < list1.size(); i++)
				fList.add(list1.get(i));
			for (int i = 0; i < list2.size(); i++)
				fList.add(list2.get(i));
			return fList;
		}
	}
	
	private static <E> void printList(List<E> l1) {
		for (E element: l1) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
