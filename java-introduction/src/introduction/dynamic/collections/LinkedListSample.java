package introduction.dynamic.collections;

import java.util.LinkedList;

public class LinkedListSample {

	
	
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		
		list.add("giovana");
		list.add("lorena");
		list.add("eduardo");
		
		for (String s : list) {
			System.out.println(s);
		}
		
		list.forEach(s -> System.out.println(s));
		
		
		list.forEach(System.out::println);
	}
}
