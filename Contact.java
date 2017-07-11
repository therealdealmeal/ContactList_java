/**
 * One object of this class represents the contact
 * information of one person.
 */
package test;

import java.util.Scanner;
import java.io.*;

public class Contact implements Serializable,  Comparable <Contact> {
	
	private static String DEFAULT_INFO = "zz-anonymous";
	private String firstName;
	private String lastName;
	private String streetAddress;
	private String emailAddress;
	private String phoneNumber;
	private String notes;
	private String contactString;
	private static int id;

	/**
	 * Constructs a contact without parameters.
	 * - DA
	 */
	public Contact() {
		firstName = DEFAULT_INFO;
		lastName = DEFAULT_INFO;
		streetAddress = DEFAULT_INFO;
		emailAddress = DEFAULT_INFO;
		phoneNumber = DEFAULT_INFO;
		notes = DEFAULT_INFO;	
		
		formatValues();
	}
	
	/**
	 * Returns lastName as string value of a given object
	 * - DA
	 */
	public String getLastName() {
		String getLastName;
		getLastName = lastName;
		
		return getLastName;
	}
	
	/**
	 * Returns firstName as string value of a given object
	 * - DA
	 */
	public String getFirstName() {
		String getFirstName;
		getFirstName = firstName;
		
		return getFirstName;
	}
	
	/**
	 * Print formated string of an object
	 * - DA
	 */
	public String toString() {
		return contactString;
	}
	
	/**
	 * Method will pass values into an object.
	 * userInput will continue to method userInputTwo
	 * if lastName > 0.
	 * - AD 
	 */
	public int newUserInput() {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		//Prompting user with questions and inputs to store values
		System.out.print("\nFirst Name? ");
		firstName = userInput.nextLine();
		
		boolean lastNameValidity, emailValidity, phoneNumberValidity;
		int condition = 1;
		lastNameValidity = checksLastName();
		
		
		if (lastNameValidity == true) {
			System.out.print("Address (Street Address, City, State, Zip-Code) (leave blank for no address)? ");
			streetAddress = userInput.nextLine();
			emailValidity = validateEmail();
			
			if (emailValidity == true) {
				phoneNumberValidity = validatePhoneNumber();
				
				if (phoneNumberValidity == true) {
				
					System.out.print("Any Notes? ");
					notes = userInput.nextLine();
					
					id = id + 1;
					
					// Format the values
					formatValues();
					
					condition = 1;
				}
			}
		}
		return condition;
	}
	
	/**
	 * Method will ask and check that the user inputs a last name.
	 * - AD 
	 */
	public boolean checksLastName() {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		boolean condition;
		condition = true;
		
		System.out.print("Last Name? ");
		lastName = userInput.nextLine();
		
		// Exception course if last name is not entered
		if (lastName.length() == 0) {
			System.out.println("\nPlease enter a last name! \n");
			condition = false;
		}
		return condition;
	}
	
	/**
	 * Validates the email address and asks to re-enter
	 * - AD
	 */
	public boolean validateEmail() {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		// Regular express validator email.
		String emailregex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";		
		
		System.out.print("Email Address? ");
		emailAddress = userInput.nextLine();
		
		boolean isValid;
		
		if (emailAddress.trim().length() == 0) {
			isValid = true;
			return isValid;
		}
		// Validates the email address that was input.
		isValid = emailAddress.matches(emailregex);
		
		// Exception course if email address is invalid.
		if (isValid == false) {
			System.out.println("\nPlease enter a valid email address! (leave blank if no email)\n");
			return validateEmail();
		}
		return isValid;
	}
	
	/**
	 * Validates the phone number and asks to re-enter
	 * - AD
	 */
	public boolean validatePhoneNumber() {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		// Regular express validator email.
		String phoneregex = "\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}";		
		
		System.out.print("Phone Number (must be in this format: XXX-XXX-XXXX)? ");
		phoneNumber = userInput.nextLine();
		
		boolean isValid;
		
		if (phoneNumber.trim().length() == 0) {
			isValid = true;
			return isValid;
		}
		
		// Validates the email address that was input.
		isValid = phoneNumber.matches(phoneregex);
		
		// Exception course if email address is invalid.
		if (isValid == false) {
			System.out.println("\nPlease enter a valid phone number! (leave blank if no phone number)\n");
			return validatePhoneNumber();
		}
		return isValid;
	}
	
	/**
	 * Formats the values in an object to make it printable 
	 * - DA
	 */
	public void formatValues() {
		contactString = "Name: " + firstName + " " + lastName + "\n" + "Address: " + streetAddress + "\n"
				+ "Email Address: " + emailAddress + "\n" + "Phone Number: " + phoneNumber + "\n" 
				+ "Notes: " + notes + "\n";
	}

	/**
	 * Returns a number < 0 if the object that calls the method is less
	 * than the other, returns > 0 if the object that calls it is greater
	 * than other, and it returns 0 if they're equal 
	 * - DA & EY
	 */
	public int compareTo(Contact nextContact) {
      
		int comparison;
      
      if(this == null || nextContact == null)
    	  comparison = 0;
      else if((this.getLastName().compareToIgnoreCase(nextContact.getLastName()) == 0))
    	  comparison = this.getFirstName().compareToIgnoreCase(nextContact.getFirstName());
      else
    	  comparison = this.getLastName().compareToIgnoreCase(nextContact.getLastName());
      

      return comparison;
	}

}