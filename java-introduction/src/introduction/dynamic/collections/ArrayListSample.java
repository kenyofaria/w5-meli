package introduction.dynamic.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListSample {

	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("vitor");
		arrayList.add("helena");
		arrayList.add("adriana");
		arrayList.add("kenyo");
		
		System.out.println("--------------------- usando for");
		for(int i=0; i<arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
		System.out.println("--------------------- usando foreach");
		for(String s: arrayList) {
			System.out.println(s);
		}
		arrayList.forEach(s -> System.out.println(s));
		
		
		System.out.println("--------------------- usando iterator");
		Iterator<String> iterator = arrayList.iterator();	
		do {
			System.out.println(iterator.next());	
		}
		while(iterator.hasNext());
		
		
		System.out.println(arrayList.contains("kenyo"));
		
		arrayList.remove("adriana");
		
		System.out.println(Arrays.toString(arrayList.toArray()));
		

	}
}
