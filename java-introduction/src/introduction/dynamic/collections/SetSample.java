package introduction.dynamic.collections;

import java.util.HashSet;

public class SetSample {

	
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		set.add("arthur");
		set.add("roberto");
		
		set.forEach(s -> System.out.println(s));
	}
}
