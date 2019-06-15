package contact_application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ContactObjectClass {

	ArrayList<ContactClass> list = new ArrayList<>();
	UserContactOperationClass operation=  new UserContactOperationClass();

	public static void main(String[] args) {
		ContactObjectClass obj = new ContactObjectClass();
		while (true) {
			obj.showMenu();
		}
	}

	public void showMenu() {

		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|---------------------welcome to contact application---------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|------------------you can perform the following operation---------------|");
		System.out.println("|                                                                        |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                          1.Add Contact                                 |");
		System.out.println("|                                                                        |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|                          2.View Contact                                |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|                          3.Modify Contact                              |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|                          4.Delete Contact                              |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("|                                                                        |");
		System.out.println("|                          5.Exit                                        |");
		System.out.println("|------------------------------------------------------------------------|");
		System.out.println("\n");
		choose();
		System.out.println("\n");
	
	}

	public void choose() {
		try {
			int i;
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();
			if (choice < 1 || choice > 5) {
				System.out.println("please enter the valid choice ");
				return;
			}
			switch (choice) {
			case 1:
				System.out.println("you choosen to add the contact");
				gettingDataFromUser();
				//return;
				System.out.println("\n");
				System.out.println("if you want to go back to show menu ");
				System.out.println("press 1");
				System.out.println("if you want to exit ");
				System.out.println("press 2");
				int no=sc.nextInt();
				if(no==1)
				{
					
				return;
				}
				else if(no==2)
				{
					System.exit(0);
				}
			case 2:
				System.out.println("your choosen to view the contact");
				showinDataToUser();
				//return;
				System.out.println("\n");
				System.out.println("if you want to go back to show menu ");
				System.out.println("press 1");
				System.out.println("if you want to exit ");
				System.out.println("press 2");
				 no=sc.nextInt();
				if(no==1)
				{
					
				return;
				}
				else if(no==2)
				{
					System.exit(0);
				}
			case 3:
				System.out.println("your choosen to modify the contact list");
				i = showinDataToUser();
				if (i == 0) {
					return;
				}
				int length = list.size();
				modificationToContact(length);
				//return;
				System.out.println("\n");
				System.out.println("if you want to go back to show menu ");
				System.out.println("press 1");
				System.out.println("if you want to exit ");
				System.out.println("press 2");
				 no=sc.nextInt();
				if(no==1)
				{
					
				return;
				}
				else if(no==2)
				{
					System.exit(0);
				}
				
			case 4:
				System.out.println("your selected to delete the contact");
				deleteFromUsercontact();
				//return ;
				System.out.println("\n");
				System.out.println("if you want to go back to show menu ");
				System.out.println("press 1");
				System.out.println("if you want to exit ");
				System.out.println("press 2");
				no=sc.nextInt();
				if(no==1)
				{
					
				return;
				}
				else if(no==2)
				{
					System.exit(0);
				}
			case 5:
				System.out.println("EXIT");
				System.exit(0);
			default:
				System.out.println("please enter the valid choice");
				return;

			}
		} catch (Exception e) {
			System.out.println("please enter the valid choice option  you got the following error  " );
			return;
		}

	}

	public void gettingDataFromUser() {

		ContactClass contactClass = operation.getContactFromUser();
		if (contactClass != null) {
			list.add(contactClass);
		} else {
			return;
		}
	}

	 int showinDataToUser() {
		int i = 0;
		if (list.isEmpty()) {
			System.out.println("list is empty");
		} else {
			NameComparator obj = new NameComparator();
			Collections.sort(list, obj);
			for (ContactClass o : list) {

				System.out.println(
						"|--------------------------------------------------------------------------------------------------------------------------|");
				System.out.println("\n");

				System.out.println(
						i + "  " + o.getName() + "  " + o.getPhoneNO() + " " + o.getMailId() + " " + o.getAddress());
				i++;

			}
		}
		return i;
	}

	public void modificationToContact(int length) {

		int i=operation.modifyUserContact(length, list);
		if(i==1)
		{
		showinDataToUser();
		}
		else
		{
			
			return;
			
		}
		
	}

	public void deleteFromUsercontact() {
		int i = showinDataToUser();
		if (i == 0) {
			return;
		}
		int i1=operation.deleteUserContact(list);
		if(i1==1)
		{
		showinDataToUser();
		
		}
		else
		{
			
		return;
		}
	}
}
