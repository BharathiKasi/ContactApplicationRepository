package contact_application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserContactOperationClass {

	int i;
	String name;
	int length;
	Long phoneNo;
	String addres = "";
	String emailvalidator = "^[a-zA-z]+[a-zA-z0-9-!#.$%&*+?><_]+@+([a-zA-z0-9])+\\.[a-zA-z]{2,4}$";
	List<Long> phone;
	List<String> email;
	ContactClass contclass1;
	Scanner sc = new Scanner(System.in);

	public ContactClass getContactFromUser() {
		name = nameCheck();

		if (name == null) {
			return null;
		}

		phone = gettingPhoneNumber();
		if (phone.isEmpty()) {
			return null;
		}

		email = getMailIdFromUser();
		if (email.isEmpty()) {
			return null;
		}
		addres = addresCheck();
		if (addres == null) {
			return null;
		}

		return createContactObject(name, phone, email, addres);

	}

	public String nameCheck() {

		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("enter your name");
			}
			name = sc.next();
			int length = name.length();
			if (length >= 3) {
				sc.nextLine();
				return name;
			}
			System.out.println("please enter the valid name--(name should atleast three character)");
			continue;
		}

		System.out.println("your maximum try is finished");
		return null;
	}

	public List<Long> gettingPhoneNumber() {
		phone = new ArrayList<Long>();
		numberCheck();
		return phone;
	}

	public void numberCheck() {

		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("plese enter the phone number");
			}
			try {
				phoneNo = sc.nextLong();
				String length = Long.toString(phoneNo);
				if (length.length() != 10) {
					System.out.println(4 - i + " chance  you have");
					System.out.println("phone number should be exactly 10 digit");
					System.out.println("please enter the valid phone number");
					continue;
				}
				phone.add(phoneNo);
				addExtranNumber();
				return;
			}
			/*
			 * else { if(phone.contains(phoneNo)) {
			 * System.out.println("this number is already exist"); continue; } else {
			 * phone.add(phoneNo); addExtranNumber(); return; } } }
			 */

			catch (Exception e) {
				sc.nextLine();
				System.out.println("you input is mismatched so please try again later");
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return;
				} else {
					System.out.println(4 - i + " chance  you have");
					System.out.println("please enter valid phone number");
					continue;
				}
			}
		}

		System.out.println("your maximum try is finished");
		return;
	}

	public void addExtranNumber() {
		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("Enter your choice");
			}

			try {
				int extraNumber = 0;
				System.out.println("Do you want add one more number");
				System.out.println("1.Yes");
				System.out.println("2.No");

				extraNumber = sc.nextInt();
				if (extraNumber > 2 || extraNumber < 1) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return;
					}
					System.out.println(4 - i + "  you have  chance  to try");
					System.out.println("plese enter the valid choice");
					continue;
				}
				switch (extraNumber) {
				case 1:
					System.out.println("please enter your alter number");
					numberCheck();
					return;
				case 2:
					return;
				default:
					System.out.println(" your entered invalid options");
					return;
				}
			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return;
				}
				System.out.println("your input is mismatch ");
				System.out.println(4 - i + "  chance you have");
				continue;
			}

		}
		return;
	}

	public List<String> getMailIdFromUser() {
		email = new ArrayList<String>();
		emailCheck();
		return email;
	}

	public void emailCheck() {
		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("please enter the mail id");
			}
			try {
				String email_id = sc.next();
				if (email_id.matches(emailvalidator)) {
					if (email.contains(email_id)) {
						System.out.println("this mail id alredy exixt");
						continue;
					} else {
						email.add(email_id);
						multipleEmailIdGetting();
						return;
					}

				} else {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return;
					}

					System.out.println("please enter the valid email_id");
					continue;
				}

			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return;
				}
				System.out.println(4 - i + "  chance you have to try");
				System.out.println("input is mismatch");
				continue;

			}

		}
	}

	public void multipleEmailIdGetting() {
		for (i = 1; i <= 4; i++) {
			System.out.println("do you want add one more email id");
			System.out.println("1. Yes");
			System.out.println("2.No");
			System.out.println("enter your choice");
			try {
				int alteremailId = sc.nextInt();
				sc.nextLine();
				if (alteremailId > 2 || alteremailId < 1) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return;
					}
					System.out.println(4 - i + "  you have  chance  to try");
					System.out.println("plese enter the valid choice");
					continue;
				}

				switch (alteremailId) {

				case 1:
					emailCheck();
					return;

				case 2:
					return;

				default:
					System.out.println("your selected invalid option");
					break;
				}
			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return;
				}
				System.out.println("your input is mismatch ");
				System.out.println(4 - i + "  chance you have");
				continue;

			}
		}

	}

	public String addresCheck() {

		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("please enter  city");
			}
			addres = sc.next();
			if (addres.length() == 0) {
				System.out.println("please enter the valid city name");
				continue;
			}
			return addres;

		}
		System.out.println("sorry your maximum try is finished");
		return null;

	}

	public ContactClass createContactObject(String name, List<Long> phone2, List<String> email_id, String addres) {
		contclass1 = new ContactClass();
		contclass1.setName(name);
		contclass1.setPhoneNo(phone2);
		// contclass1.setAlterPhoneNumber(alterPhoneNumber);
		contclass1.setEmailId(email_id);
		// contclass1.setAlterEmailId(alterEmail_id);
		contclass1.setAddress(addres);
		// phone = null;
		// email = null;
		System.out.println("you contact has been added");
		return contclass1;
	}

	public int modifyUserContact(int length, List<ContactClass> list) {
		int listPosition;
		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("please enter the serial number of contact which you want to modify");
			}
			try {
				this.length = length;
				listPosition = 0;
				System.out.println("\n");

				listPosition = sc.nextInt();

				if (listPosition >= length || listPosition < 0) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return 0;
					}
					System.out.println(4 - i + "  chance you have");
					System.out.println("please entered valid serial number ");
					continue;
				}

				System.out.println("|---------------------------------------------------------|");
				System.out.println("|                                                         |");
				System.out.println("\n");
				System.out.println("           which you want to change select                ");
				System.out.println("                  1.Name                                  ");
				System.out.println("                  2.phoneNo                               ");
				System.out.println("                  3.emailId                               ");
				System.out.println("                  4.address                               ");
				System.out.println("\n");
				System.out.println("\n");
				int i = choose1(listPosition, list);
				if (i == 0) {
					return i;
				}

				return i;

			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return 0;
				}
				System.out.println("input is mismatch");
				System.out.println(4 - i + " chance you have");
				continue;
			}
		}
		return 0;
	}

	public int choose1(int listPosition, List<ContactClass> list) {

		int position = 0;
		int j;

		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("please enter your choice");
			}
			try {

				position = sc.nextInt();
				sc.nextLine();
				if (position < 1 || position > 4) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return 0;
					}
					System.out.println(4 - i + "  chance you have");
					System.out.println("please enter the valid choice between 1 to 4 ");
					continue;
				}
				switch (position) {
				case 1:
					j = nameModification(listPosition, list);
					if (j == 0) {
						System.out.println(" name is not modified please try again later");
						return 0;
					} else {
						System.out.println("your name is modified varify below");
						return 1;
					}

				case 2:
					j = phoneNumberModification(listPosition, list);
					if (j == 0) {
						System.out.println("phone number is not modified plese try later");
						return 0;
					} else {
						System.out.println("your number is modified please verify below");
						return 1;
					}
				case 3:
					j = emailModification(listPosition, list);
					if (j == 0) {
						System.out.println("email is not modified please try later");
						return 0;
					} else {
						System.out.println("your email is modified please verify below");
						return 1;
					}
				case 4:
					j = addressModification(listPosition, list);
					if (j == 0) {
						System.out.println(" address is not modified please try again later");
						return 0;
					} else {
						System.out.println("your email is modified please verify below");
						return 1;
					}
				}
			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return 0;
				}
				System.out.println("input is mismatched ");
				System.out.println(4 - i + " chance you have");
				System.out.println("please enter the valid choice between 1 to 4 ");
				continue;
			}
		}
		return 0;
	}

	public int nameModification(int listPosition, List<ContactClass> list) {
		int j = 0;
		for (i = 1; i <= 3; i++) {

			if (i == 1) {
				System.out.println("please enter your name");
			}
			name = sc.next();
			int length = name.length();
			if (length < 3) {
				System.out.println("please enter valid name it should be minimum of three characteres");
				continue;
			} else {
				ContactClass o = list.get(listPosition);
				o.setName(name);
				j++;
				return j;
			}
		}
		return j;
	}

	public int phoneNumberModification(int listPosition, List<ContactClass> list) {

		int j = 0;
		System.out.println(list.get(listPosition));
		ContactClass obj = list.get(listPosition);
		phone = obj.getPhoneNO();
		int length = phone.size();
		int index = gettingNumberIndexFromUser(length);
		if (index < 0 || index > length) {
			return 0;
		}
		phoneNo = gettingNumberFromUser();
		if (phoneNo == 0) {
			return 0;
		}
		phone.set(index, phoneNo);
		j++;
		return j;
	}

	public int gettingNumberIndexFromUser(int length) {
		int index = 0;
		for (i = 1; i <= 4; i++) {
			try {
				if (i == 1) {
					System.out.println("please enter the index position");
					System.out.println("index is start from o to n-1");
				}
				index = sc.nextInt();
				if (index >= length || index < 0) {
					System.out.println("please enter the valid index");
					System.out.println(4 - i + "  chance you have");
					System.out.println("please enter the valid in");
					continue;
				}
				return index;

			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished ");
					return 0;
				}
				System.out.println("input is mismatched");
				System.out.println(4 - i + "  chance you have");
				continue;
			}
		}
		return 0;
	}

	public long gettingNumberFromUser() {
		for (i = 1; i <= 4; i++) {
			try {
				if (i == 1) {
					System.out.println("please enter the number");
				}
				phoneNo = sc.nextLong();
				String array = Long.toString(phoneNo);
				int length2 = array.length();
				if (length2 < 10 || length2 > 10) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return 0;
					}
					System.out.println("please entered valid number ");
					System.out.println(4 - i + "  chance you have");
					continue;
				}
				return phoneNo;

			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return 0;
				}
				System.out.println(" input is mismatched  ");
				System.out.println(4 - i + " chance you have");
				System.out.println("please enter the valid number");
				continue;
			}
		}
		return 0;
	}

	public int emailModification(int listPosition, List<ContactClass> list) {
		int j = 0;
		System.out.println(list.get(listPosition));
		ContactClass obj = list.get(listPosition);
		email = obj.getMailId();
		int length = email.size();
		int index = gettingEamilIndexFromUser(length);
		if (index < 0 || index > length) {
			return 0;
		}
		String s = gettingEmailFromUser();
		if (s.equals(null)) {
			return 0;
		}
		email.set(index, s);
		j++;
		return j;

	}

	public int gettingEamilIndexFromUser(int length) {

		int index;
		for (i = 1; i <= 4; i++) {
			try {
				if (i == 1) {
					System.out.println("please enter the index position");
					System.out.println("index is start from o to n-1");
				}
				index = sc.nextInt();
				if (index > length || index < 0) {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return 0;
					}

					System.out.println("please eneter the valid index ");
					System.out.println(4 - i + "  chance you have");
					continue;
				}
				return index;
			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return 0;
				}
				System.out.println("input is mismatched");
				System.out.println(4 - i + "chance you have");
				System.out.println("please enter valid index");
				continue;

			}
		}
		return 0;
	}

	public String gettingEmailFromUser() {
		for (i = 1; i <= 4; i++) {
			try {
				if (i == 1) {
					System.out.println("please enter the mail id");
				}
				String email_id = sc.next();
				if (email_id.matches(emailvalidator)) {
					return email_id;
				} else {
					if (i == 4) {
						System.out.println("your maximum try is finished");
						return null;
					}
					System.out.println("please enter valid  mailId");
					System.out.println(4 - i + " chance you have");
					continue;
				}

			}

			catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return null;
				}
				System.out.println(" input is mismatched");
				System.out.println(4 - i + " chance you have");
				continue;
			}
		}
		return null;
	}

	public int addressModification(int listPostion, List<ContactClass> list) {
		int j = 0;
		ContactClass o = list.get(listPostion);
		for (i = 1; i <= 3; i++) {
			System.out.println("please enter the city ");
			String address = sc.next();
			if (address.isEmpty()) {

				System.out.println("please enter the valid city");
				continue;
			} else {
				o.setAddress(address);
				j++;
				return j;
			}
		}
		System.out.println("sorry your maximum try is finished");
		return j;
	}

	public int deleteUserContact(List<ContactClass> list) {
		for (i = 1; i <= 4; i++) {
			if (i == 1) {
				System.out.println("please enter serial number  which you want to delete from the contact");
			}
			try {
				int listposition = sc.nextInt();
				if (listposition >= list.size() || listposition < 0) {
					if (i == 4) {
						System.out.println(" your  maximum try is finished  ");
						return 0;
					}
					System.out.println("please entered the valid serial number");
					System.out.println(4-i+"  chance you have");
					continue;
				} else {
					list.remove(listposition);
					System.out.println("your contact is deleted from the contact list");
					return 1;

				}

			} catch (Exception e) {
				sc.nextLine();
				if (i == 4) {
					System.out.println("your maximum try is finished");
					return 0;
				}
				System.out.println("input is mismatch");
				System.out.println(4 - i + "  chance you have");
				System.out.println("please enter the valid serial number");
				continue;
			}
		}

		return 0;
	}
}
