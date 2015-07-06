package my.pattern.adapter;

import java.util.ArrayList;
import java.util.Enumeration;

public class ArrayListIterator implements Enumeration {
	
	private ArrayList arrayList;
	
	public ArrayListIterator(ArrayList a) {
		this.arrayList = a;
	}

	@Override
	public boolean hasMoreElements() {
		// TODO Auto-generated method stub
		return arrayList.iterator().hasNext();
	}

	@Override
	public Object nextElement() {
		// TODO Auto-generated method stub
		return arrayList.iterator().next();
	}
	
}
