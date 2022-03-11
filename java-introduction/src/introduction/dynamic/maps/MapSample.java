package introduction.dynamic.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class MapSample {

	
	public static void main(String[] args) {
		
		HashMap<String,String> map = new HashMap<String, String>();
		
		map.put("983.352.098-90", "Kenyo");
		map.put("983.352.098-91", "Mauri");
		map.put("983.352.098-92", "joice");
		map.put("983.352.098-93", "michele");
		map.put("983.352.098-94", "betania");
		map.put("983.352.098-95", "jefferson");
			
		
		for (Entry<String, String> pair : map.entrySet()) {
			System.out.println(pair.getKey() + " " + pair.getValue());
		}
		
		System.out.println("-------------");
		
		System.out.println(map.get("983.352.098-93"));
		
		
		HashMap<String,int[]> cities = new HashMap<String, int[]>();
		
		
		String goiania = "goiania";
		int[] tmp = {29, 34};
		
		cities.put(goiania, tmp);
		cities.put(goiania, new int[]{-2, 33});
		
		
		
		ArrayList<Object> casaDaSogra = new ArrayList<Object>();
		casaDaSogra.add(new Scanner(System.in));
		casaDaSogra.add("qq coisa");
		casaDaSogra.add(1);
		
		
		
	}
}
