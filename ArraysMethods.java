package ThridAssigment;
import java.util.*;

public class ArraysMethods {

    public static void main(String[] args) {

        // 🔹 Constructors
        ArrayList<Integer> al1 = new ArrayList<>();               
        ArrayList<Integer> al2 = new ArrayList<>(10);             
        ArrayList<Integer> al3 = new ArrayList<>(al1);             

        // 🔹 add()
        al1.add(10);
        al1.add(20);
        al1.add(30);

        // 🔹 add(index, element)
        al1.add(1, 15);

        // 🔹 addAll()
        al2.addAll(al1);

        // 🔹 get()
        System.out.println(al1.get(0));

        // 🔹 set()
        al1.set(0, 100);

        // 🔹 remove(index)
        al1.remove(1);

        // 🔹 remove(object)
        al1.remove(Integer.valueOf(30));

        // 🔹 size()
        System.out.println(al1.size());

        // 🔹 isEmpty()
        System.out.println(al1.isEmpty());

        // 🔹 contains()
        System.out.println(al1.contains(100));

        // 🔹 indexOf()
        System.out.println(al1.indexOf(100));

        // 🔹 lastIndexOf()
        al1.add(100);
        System.out.println(al1.lastIndexOf(100));

        // 🔹 toArray()
        Object[] arr = al1.toArray();

        // 🔹 clone()
        ArrayList<Integer> al4 = (ArrayList<Integer>) al1.clone();

        // 🔹 clear()
        al3.clear();

        // 🔹 forEach()
        al1.forEach(i -> System.out.println(i));
        Object[] arr2=al1.toArray();
        for(Object i:arr) {
        	System.out.println(i);
        }
        
    }
}
