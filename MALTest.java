import java.util.*;
class MyArrayList {
	private int logicalSize;
	private Object [] contents;

	public MyArrayList() {
		this.logicalSize = 0;
		this.contents = new Object [logicalSize];
	}
	public MyArrayList(Object [] inputArray) {
		logicalSize = inputArray.length;
		this.contents = inputArray;
	}
	public Object [] toArray() {
		return this.contents;
	}
	public int add(int index, Object addition) {
		if (index < 0 || index > logicalSize)
			return -1;
		Object [] tempContents = new Object [this.logicalSize + 1];
		for(int i = 0; i < index; i++) {
			tempContents[i] = this.contents[i];
		}
		tempContents[index] = addition;
		for(int i = index + 1; i < tempContents.length; i++) {
			tempContents[i] = this.contents[i-1];
		}
		this.contents = tempContents;
		logicalSize++;
		return index;
	}
	public Object remove(int index) {
		if (index < 0 || index > logicalSize)
			return null;
		Object [] tempContents = new Object [this.logicalSize - 1];
		for(int i = 0; i < index; i++) {
			tempContents[i] = this.contents[i];
		}
		for(int i = index; i < tempContents.length; i++) {
			tempContents[i] = this.contents[i+1];
		}
		Object tempObject = this.contents[index];
		this.contents = tempContents;
		logicalSize--;
		return tempObject;
	}
	public int indexOf(Object compare) {
		for(int i = 0; i < this.logicalSize; i++) {
			if (this.contents[i].equals(compare)) {
				return i;
			}
		}
		return -1;
	}
	public String toString() {
		String str = "";
		str += "[";
		for(int i = 0; i < this.logicalSize; i++) {
			str += this.contents[i].toString();
			if(i != this.logicalSize-1)
				str += ", ";
		}
		str += "]";
		return str;
	}
}
public class MALTest {
	public static void main(String[] args) {
		Object [] testarray = {1,"2",new Date(),"4","5","4","3","2","1"};
		//Test MyArrayList
		MyArrayList m = new MyArrayList(testarray);
		//Against the actual ArrayList object
		ArrayList<Object> al = new ArrayList<Object>(Arrays.asList(testarray));
		System.out.println(m);
		System.out.println(al);
		m.remove(3);
		al.remove(3);
		System.out.println(m);
		System.out.println(al);
		m.add(4, "Addition");
		al.add(4,"Addition");
		System.out.println(m);
		System.out.println(al);
		System.out.println(m.indexOf("2"));
		System.out.println(al.indexOf("2"));

	}
}