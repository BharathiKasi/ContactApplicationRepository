package contact_application;

import java.util.Comparator;

public class NameComparator implements Comparator<ContactClass>{

	public int compare(ContactClass o1, ContactClass o2) {
		// TODO Auto-generated method stub
		ContactClass object1=o1;
		ContactClass object2=o2;
		return object1.getName().compareTo(object2.getName());
	}

}
