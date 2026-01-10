package ThridAssigment;
import java.util.*;
public class HasTableMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(20);
        Hashtable<Integer, String> ht3 = new Hashtable<>(ht1);

        ht1.put(1, "Apple");
        ht1.put(2, "Banana");
        ht1.put(3, "Mango");

        System.out.println(ht1.get(1));
        System.out.println(ht1.containsKey(2));
        System.out.println(ht1.containsValue("Mango"));
        System.out.println(ht1.size());
        System.out.println(ht1.isEmpty());

        ht1.remove(3);
        ht1.replace(2, "Banana", "Orange");
        ht1.putIfAbsent(4, "Grapes");

        System.out.println(ht1.keys());
        System.out.println(ht1.elements());
        System.out.println(ht1.entrySet());
        System.out.println(ht1.keySet());
        System.out.println(ht1.values());

        ht1.clear();
        System.out.println(ht1.equals(ht2));
	}

}
