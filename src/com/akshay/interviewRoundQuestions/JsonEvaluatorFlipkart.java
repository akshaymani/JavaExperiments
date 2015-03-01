package com.akshay.interviewRoundQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class JsonEvaluatorFlipkart<T> {
	
	public static void main(String[] args) {
		ArrayList<String> listOfExpressions = new ArrayList<String>();
		listOfExpressions.add("a>b = 1");
		listOfExpressions.add("a>b = 2");
		listOfExpressions.add("a>c>d = 3");
		listOfExpressions.add("a>c>e = 4");
		listOfExpressions.add("g>f = 4");
		//listOfExpressions.add("a>b>d = 5");
		
		/*String[] temp = listOfExpressions.get(2).split("=")[0].trim().split(">");
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i] + " -> ");
		}
		System.out.println("null");*/
		
		// O(nlog(n))
		HashMap<String,ArrayList<Object>> keyToValMap = findValues(listOfExpressions);
		
		/*Set<String> keys = keyToValMap.keySet();
		for (String key: keys) {
			System.out.print("Key: " + key + " ");
			ArrayList<Object> list = keyToValMap.get(key);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + " ");
			}
			System.out.println();
		}*/
		
		try {
			// O(n*maxLengthOfExpression*log(no of leaf nodes))
			HashMap<String,ArrayList<String>> parentToChildRelationship = 
					evaluatePaths(listOfExpressions,keyToValMap);
			
			/*Set<String> keys = parentToChildRelationship.keySet();
			for (String key: keys) {
				System.out.print("Parent: " + key);
				ArrayList<String> children = parentToChildRelationship.get(key);
				System.out.print(" Children: ");
				for (int i = 0; i < children.size(); i++) {
					System.out.print(children.get(i) + " ");
				}
				System.out.println();
			}*/
			
			// so now I have the leaf nodes as well as the child to immediate parent relationship
			
			// and now I have to find the parents which are not children of any other parent
			// O(n*n) where n = parentToChildRelationship.size()
			ArrayList<String> topParents = findTopParents(parentToChildRelationship);
			/*for (int i = 0; i < topParents.size(); i++) {
				System.out.print(topParents.get(i) + " ");
			}
			System.out.println();*/
			printJSONData(topParents,parentToChildRelationship,keyToValMap);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failure in Evaluating Expressions");
		}
	}

	private static void printJSONData(ArrayList<String> topParents,
			HashMap<String, ArrayList<String>> parentToChildRelationship,
			HashMap<String, ArrayList<Object>> keyToValMap) {
		
		System.out.println("{");
		for (int i = 0; i < topParents.size(); i++) {
			// have to write a recursive function till further entries cannot be there
			String parent = topParents.get(i);
			recursivelyPrintParentAndChildren(parent,parentToChildRelationship,keyToValMap);
			if (i+1 < topParents.size()) {
				System.out.print(",");
			}
		}
		System.out.println("}");
		
	}

	private static void recursivelyPrintParentAndChildren(String parent,
			HashMap<String, ArrayList<String>> parentToChildRelationship,
			HashMap<String, ArrayList<Object>> keyToValMap) {
		/*if (keyToValMap.containsKey(parent)) {
			System.out.println("\"" + parent + "\"" + " : {");
			ArrayList<Object> vals = keyToValMap.get(parent);
			if (vals.size() > 1) {
				System.out.print("[");
				for (int j = 0; j < vals.size(); j++) {
					System.out.print(vals.get(j));
				}
				System.out.println("]");
			}
			else {
				System.out.println(vals.get(0));
			}
			return;
		}*/
		System.out.println("\"" + parent + "\"" + " : {");
		ArrayList<String> children = parentToChildRelationship.get(parent);
		for (int i = 0; i < children.size(); i++) {
			if (keyToValMap.containsKey(children.get(i))) {
				System.out.print("\"" + children.get(i) + "\" : ");
				ArrayList<Object> vals = keyToValMap.get(children.get(i));
				if (vals.size() > 1) {
					System.out.print("[");
					for (int j = 0; j < vals.size(); j++) {
						System.out.print(vals.get(j));
						if (j+1 < vals.size()) {
							System.out.print(",");
						}
					}
					System.out.println("]");
				}
				else {
					System.out.println(vals.get(0));
				}
			}
			else {
				recursivelyPrintParentAndChildren(children.get(i), parentToChildRelationship, keyToValMap);
			}
			
			if (i+1 <children.size()) {
				System.out.println(",");
			}
		}
		
		System.out.println("}");
		return;
	}

	private static ArrayList<String> findTopParents(
			HashMap<String, ArrayList<String>> parentToChildRelationship) {
		ArrayList<String> topParents = new ArrayList<String>();
		Set<String> setOfParents = parentToChildRelationship.keySet();
		for (String key: setOfParents) {
			boolean flag = true; // true implies its a topParent
			for (String parent: setOfParents) {
				if (!key.equals(parent)) {
					ArrayList<String> children = parentToChildRelationship.get(parent);
					if (children.contains(key)) {
						flag = false;
						break;
					}
				}
			}
			if (flag == true) {
				topParents.add(key);
			}
		}
		return topParents;
	}

	private static HashMap<String, ArrayList<String>> evaluatePaths(
			ArrayList<String> listOfExpressions,
			HashMap<String, ArrayList<Object>> keyToValMap) throws Exception {
		
		int lengthOfExpressionList = listOfExpressions.size();
		
		HashMap<String,ArrayList<String>> parentToChildRelationship = 
				new HashMap<String,ArrayList<String>>();
		
		Set<String> keysToLeafNodes = keyToValMap.keySet();
		
		for (int i = 0; i < lengthOfExpressionList; i++) {
			String[] temp = listOfExpressions.get(i).split("=")[0].trim().split(">");
			for (int j = 0; j < temp.length - 1; j++) {
				// keys in keyToValMap cannot have children as they are the leafs
				if (keysToLeafNodes.contains(temp[j].trim())) {
					Exception e = new Exception("List Of Expressions is Invalid");
					throw e;
				}
					
				if (parentToChildRelationship.containsKey(temp[j].trim())) {
					ArrayList<String> listOfChildren = parentToChildRelationship.get(temp[j].trim());
					if (listOfChildren == null) {
						listOfChildren = new ArrayList<String>();
					}
					if (!listOfChildren.contains(temp[j+1]))
						listOfChildren.add(temp[j+1].trim());
				}
				else {
					ArrayList<String> listOfChildren = new ArrayList<String>();
					listOfChildren.add(temp[j+1].trim());
					parentToChildRelationship.put(temp[j].trim(), listOfChildren);
				}
			}
		}
		
		return parentToChildRelationship;
	}

	private static HashMap<String, ArrayList<Object>> findValues(
			ArrayList<String> listOfExpressions) {
		
		int lengthOfExpressionList = listOfExpressions.size();
		
		HashMap<String,ArrayList<Object>> keyToValMap = new HashMap<String,ArrayList<Object>>();
		
		for (int i = 0; i < lengthOfExpressionList; i++) {
			String[] temp = listOfExpressions.get(i).split(">");
			String lastStr = temp[temp.length-1];
			String key = lastStr.split("=")[0];
			String val = lastStr.split("=")[1];
			if (keyToValMap.containsKey(key.trim())) {
				ArrayList<Object> listOfVals = keyToValMap.get(key.trim());
				if (listOfVals == null) {
					listOfVals = new ArrayList<Object>();
				}
				listOfVals.add(val.trim());
			}
			else {
				ArrayList<Object> listOfVals = new ArrayList<Object>();
				listOfVals.add(val.trim());
				keyToValMap.put(key.trim(), listOfVals);
			}
		}
		
		return keyToValMap;
	}

}
