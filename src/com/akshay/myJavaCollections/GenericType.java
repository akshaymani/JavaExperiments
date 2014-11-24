package com.akshay.myJavaCollections;

public class GenericType<T> {

	private T t;

	public T get(){
		return this.t;
	}

	public void set(T t1){
		this.t=t1;
	}

	public static void main(String args[]){
		GenericType<String> type = new GenericType<>();
		type.set("Pankaj"); //valid

		GenericType type1 = new GenericType(); //raw type
		type1.set("Pankaj"); //valid
		type1.set(10); //valid and autoboxing support
		
		System.out.println(type.get());
		
		System.out.println(type1.get());
	}
}
