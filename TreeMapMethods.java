package ThridAssigment;
import java.util.*;
public class TreeMapMethods {

	public static void main(String[] args) {
		TreeMap<Integer, String> tm1 = new TreeMap<>();
        TreeMap<Integer, String> tm2 = new TreeMap<>(tm1);
        TreeMap<Integer, String> tm3 = new TreeMap<>(Comparator.reverseOrder());

        tm1.put(1, "Red");
        tm1.put(2, "Blue");
        tm1.put(3, "Green");

        System.out.println(tm1.get(2));
        System.out.println(tm1.firstKey());
        System.out.println(tm1.lastKey());
        System.out.println(tm1.higherKey(1));
        System.out.println(tm1.lowerKey(3));

        tm1.pollFirstEntry();
        tm1.pollLastEntry();

        System.out.println(tm1.size());
        System.out.println(tm1.isEmpty());
        System.out.println(tm1.containsKey(2));
        System.out.println(tm1.containsValue("Red"));
        System.out.println(tm1.keySet());
        System.out.println(tm1.values());
        System.out.println(tm1.entrySet());

        tm1.clear();
    	}

}
