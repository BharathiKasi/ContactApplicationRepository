package contact_application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactClass  {
	
	private String name;
	private List<Long> phoneNo;
	//private long alterNumber;
	private List<String> email_id;
	//private String alterEmail_id;
	private String addres="";
	
	
	 void setName(String name) {
		this.name = name;
	}
	 void setPhoneNo(List<Long>phoneNo)
	{
		this.phoneNo=phoneNo;
	}
	/*public void setAlterPhoneNumber(long alterPhoneNumber)
	{
		this.alterNumber=alterPhoneNumber;
	}*/
	  void setEmailId(List<String> email_id)
	{
		this.email_id=email_id;
	}
	/*public void setAlterEmailId(String alterEmail_id)
	{
		this.alterEmail_id=alterEmail_id;
	}*/
	 void setAddress(String address)
	{
		this.addres=address;
	}

	 String getName() {
		return name;
	}

	 List<Long> getPhoneNO() {
		return phoneNo;
	}
	/*public long getAlterPhoneNo()
	{
		return alterNumber;
	}*/

	 List<String>  getMailId() {
		return email_id;
	}
	/*public String getAlterEmailId()
	{
		return alterEmail_id;
	}*/
     String getAddress()
    {
    	return addres;
    }
    
    public String toString()
    {
    	
    	return name+" "+phoneNo+" "+email_id+" "+addres;
    }
	
}
