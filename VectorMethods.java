package ThridAssigment;
import java.util.*;
public class VectorMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Vector<Integer>v1=new Vector();
Vector<Integer>v2=new Vector(10);
Vector<Integer>v3=new Vector(v1);
v1.add(12);
v1.add(14);
v1.add(90);
v1.add(30);
v2.add(34);
v2.add(50);
v1.addElement(2);
System.out.println(v1);
v1.add(3,13);
v1.remove(0);
v1.removeElement(v2);
System.out.println(v2);
System.out.println(v2.isEmpty());
System.out.println(v1.capacity());
System.out.println(v2.capacity());
System.out.println(v1.indexOf(v3));
System.out.println(v1.contains(12));
System.out.println(v1.lastIndexOf(90));
System.out.println(v3.indexOf(10));
v2.clear();
System.out.println(v2);
Object [] arr=v1.toArray();
for(Object i: arr) {
	System.out.println(i);
}
	}

}
