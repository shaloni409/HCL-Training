package ThridAssigment;
import java.util.*;
public class HashMapMethods {

	public static void main(String[] args) {

        HashMap<Integer, String> hm1 = new HashMap<>();
        HashMap<Integer, String> hm2 = new HashMap<>(20);
        HashMap<Integer, String> hm3 = new HashMap<>(hm1);

        hm1.put(1, "Java");
        hm1.put(2, "Python");
        hm1.put(3, "C++");
        System.out.println(hm1.get(2));

        System.out.println(hm1.containsKey(1));
        System.out.println(hm1.containsValue("Java"));
        System.out.println(hm1.size());

        System.out.println(hm1.isEmpty());
        hm1.remove(3);
        hm1.replace(2, "Python", "Django");
        hm1.putIfAbsent(4, "Go");
        System.out.println(hm1.keySet());
        System.out.println(hm1.values());

        System.out.println(hm1.entrySet());
        hm1.forEach((k, v) -> System.out.println(k + " = " + v));
        hm1.clear();

        System.out.println(hm1.equals(hm2));
        System.out.println(hm1.hashCode());
    }
}

	
