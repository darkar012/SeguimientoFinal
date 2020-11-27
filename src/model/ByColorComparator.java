package model;

import java.util.Comparator;

public class ByColorComparator implements Comparator<Counter>{

	public ByColorComparator() {
		
	}
	public int compare(Counter o1, Counter o2) {
		// TODO Auto-generated method stub
		return o1.getColor()-o2.getColor();
	}
}
