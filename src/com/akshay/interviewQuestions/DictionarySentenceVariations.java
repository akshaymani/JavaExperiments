package com.akshay.interviewQuestions;

import java.util.ArrayList;

public class DictionarySentenceVariations {

	public static class Trie {
		char c;
		char[] arr;
		
		public Trie(char ch) {
			this.c = ch;
			this.arr = new char[]{'a','b','c','d','e','f', 'g', 'h', 'i', 'j', 'k'}; // rest of the chars
		}
	}
	
	public static class Sentences {
		ArrayList<String> strings;
		
		public Sentences() {
			this.strings = new ArrayList<String>();
		}
		
		public void addString(String a) {
			this.strings.add(a);
		}
		
		public static Sentences copySentences(Sentences str) {
			Sentences str2 = new Sentences();
			for (int i = 0; i < str.strings.size(); i++) {
				str2.strings.add(str.strings.get(i));
			}
			return str2;
		}

		public void printString() {
			for (int i = 0; i < strings.size(); i++) {
				System.out.print(strings.get(i) + " ");
			}
			System.out.println();
		}
		
	}
	
	public static String[] dicts = new String[] {"ho","how","are","you","ware","arey","ou"};
	
	public static void main(String[] args) {
		
		String line = "howareyou";
		Trie t = null;
		ArrayList<Sentences> allPosibilities = new ArrayList<Sentences>(); 
		findSentences(line,t,allPosibilities);
		
		for (int i = 0; i < allPosibilities.size(); i++) {
			allPosibilities.get(i).printString();
		}
	}
	
	private static void findSentences(String line,
			Trie t, ArrayList<Sentences> allPosibilities) {
		Sentences s = new Sentences();
		computeSentences(line,"",t,allPosibilities,s);
	}

	private static void computeSentences(String line, String prefix,
			Trie t, ArrayList<Sentences> allPosibilities, Sentences sentences) {
		if (line.length() == 0) {
			allPosibilities.add(sentences);
			return;
		}
		// searching for prefix and line is left part to the right
		StringBuilder sBuilder = new StringBuilder(prefix);
		String tempLine = "";
		for (int i = 0; i < line.length(); i++) {
			prefix = sBuilder.append(Character.toString(line.charAt(i))).toString();
			tempLine = line.substring(i+1);
			if (isPresent(prefix, t)) {
				// add this word to sentences and prefix = "";
				Sentences tempSentence = Sentences.copySentences(sentences);
				tempSentence.strings.add(prefix);
				computeSentences(tempLine,"",t,allPosibilities,tempSentence);
			}			
		}
	}

	public static boolean isPresent(String word, Trie T) {
		for (int i = 0; i < dicts.length; i++) {
			if (word.equals(dicts[i])) {
				return true;
			}
		}
		return false;
	}


}
