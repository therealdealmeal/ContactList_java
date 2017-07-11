/**
 * Test class for Contact and ContactList.
 */

package test;

import java.util.Scanner;

public class TestContactAndContactList {
	public static void main(String arg[]) {
		
		// Construct new empty list
		ContactList theList;
		theList = new ContactList();
		
		// Load Previous saved file in disk if available
		theList.loadSavedFile(); // USE CASE 5
		
		// Loop the menu until the user exits - DA
		int whileCounter;

		 do {
			 whileCounter = userMenu(theList);
	     } while (whileCounter < 4);
	}
	
	/**
	 * Creates menu for user interaction
	 * - AD & DA
	 */
	public static int userMenu(ContactList theList) {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		String menu;
		char userOption;
		int condition = 0;
		
		Contact newContact;
		
		menu = "Options:" + "\n" + "   1)Enter a new contact" + "\n" + "   2)Retrieve a person by last name" + 
				"\n" + "   3)Print contact list" + "\n"  + "   4)Exit" + "\n" + "Choose an option: ";
		
		System.out.print(menu);
		userOption = userInput.next().charAt(0);
		
		if( (userOption < '0') || (userOption > '4') ) {
			System.out.println("\nThe options are between 1 - 4, please choose wisely...\n");
			condition = 0;
		}
	
		switch (userOption) {
		       case '1':
		    	        newContact = createNewContact(); // creates new object every time called
		    	        condition = newContact.newUserInput(); // user input values to object
		    	        theList.addContactToList(newContact); // USE CASE 1
		    	        break;
		       case '2':
		    	        theList.retrieveInformation(); // USE CASE 3
		    	        condition = 2;
		    	        break;
		       case '3':
		    	        theList.printContactList(); // USE CASE 2 make sure this is sorted
		    	        condition = 3;
		    	        break;
		       case '4':
		    	        condition = theList.exitAndSave(); // USE CASE 4
		    	        break;
		}
		return condition;
	}
	
	/**
	 * Creates new contact every time the method is called
	 * - DA
	 */
	public static Contact createNewContact() {
		// Construct new object every time called
		Contact newContact;
		newContact = new Contact();
		
		return newContact;
	}
}

/* -----------------------------------------------paste of run1------------------------------------------------------------
There are 0 contacts saved in the disk… Let’s start a new one!

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Leslie
Last Name? Martinez
Address (Street Address, City, State, Zip-Code) (leave blank for no address)? 1669 Clarkspur Lane, San Jose, CA, 95129
Email Address? Leslie.Martinez@aol.com
Phone Number (must be in this format: XXX-XXX-XXXX)? 408-807-3742
Any Notes? Office number  321-123-1422

Contact information saved in the list! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: test

The options are between 1 - 4, please choose wisely...

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Eliezer
Last Name? Yessoufou
Address (Street Address, City, State, Zip-Code) (leave blank for no address)? 1180 Lochinvar Ave, Sunnyvale, CA, 94087
Email Address? asd

Please enter a valid email address! (leave blank if no email)

Email Address? eli@gmail.com
Phone Number (must be in this format: XXX-XXX-XXXX)? 408-674-7845
Any Notes? Office number  267-575-8843

Contact information saved in the list! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Cheriffatou
Last Name? 

Please enter a last name! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Diaz
Last Name? Agasatya
Address (Street Address, City, State, Zip-Code) (leave blank for no address)? 2223 19th Ave, San Francisco, CA, 94116
Email Address? diazagasatya@gmail.com
Phone Number (must be in this format: XXX-XXX-XXXX)? 123

Please enter a valid phone number! (leave blank if no phone number)

Phone Number (must be in this format: XXX-XXX-XXXX)? 415-254-6905
Any Notes? He is also a C++ programmer

Contact information saved in the list! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Scooter
Last Name? Beard
Address (Street Address, City, State, Zip-Code) (leave blank for no address)?  1376 Scottsdale Road, Pleasant Hill, CA, 94523
Email Address? scooterbeard@gmail.com
Phone Number (must be in this format: XXX-XXX-XXXX)? 425-323-1290
Any Notes? Ruby programmer

Contact information saved in the list! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 3

Contact List: 

Name: Diaz Agasatya
Address: 2223 19th Ave, San Francisco, CA, 94116
Email Address: diazagasatya@gmail.com
Phone Number: 415-254-6905
Notes: He is also a C++ programmer

Name: Scooter Beard
Address:  1376 Scottsdale Road, Pleasant Hill, CA, 94523
Email Address: scooterbeard@gmail.com
Phone Number: 425-323-1290
Notes: Ruby programmer

Name: Leslie Martinez
Address: 1669 Clarkspur Lane, San Jose, CA, 95129
Email Address: Leslie.Martinez@aol.com
Phone Number: 408-807-3742
Notes: Office number  321-123-1422

Name: Eliezer Yessoufou
Address: 1180 Lochinvar Ave, Sunnyvale, CA, 94087
Email Address: eli@gmail.com
Phone Number: 408-674-7845
Notes: Office number  267-575-8843


Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 2

Last Name? Haight

Sorry there's no Haight in contact list.

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 2

Last Name? Martinez

Name: Leslie Martinez
Address: 1669 Clarkspur Lane, San Jose, CA, 95129
Email Address: Leslie.Martinez@aol.com
Phone Number: 408-807-3742
Notes: Office number  321-123-1422


Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 4

Are you sure you want to exit (Y/N)? 421

Please enter Y/N for next time...

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 4

Are you sure you want to exit (Y/N)? y

See you soon!

/* -----------------------------------------------paste of run2------------------------------------------------------------
There are 4 contacts loaded to the list!

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 1

First Name? Cheriffatou
Last Name? Yessoufou
Address (Street Address, City, State, Zip-Code) (leave blank for no address)? 1255 San Tomas Aquino Rd, San Jose, CA,  95116
Email Address? cyessoufou@gmail.com
Phone Number (must be in this format: XXX-XXX-XXXX)? 
Any Notes? Office number  123-421-3231

Contact information saved in the list! 

Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 2

Last Name? Yessoufou

Name: Cheriffatou Yessoufou
Address: 1255 San Tomas Aquino Rd, San Jose, CA,  95116
Email Address: cyessoufou@gmail.com
Phone Number: 
Notes: Office number  123-421-3231

Name: Eliezer Yessoufou
Address: 1180 Lochinvar Ave, Sunnyvale, CA, 94087
Email Address: eli@gmail.com
Phone Number: 408-674-7845
Notes: Office number  267-575-8843


Options:
   1)Enter a new contact
   2)Retrieve a person by last name
   3)Print contact list
   4)Exit
Choose an option: 4

Are you sure you want to exit (Y/N)? Y

See you soon!
----------------------------------------------------end of run2--------------------------------------------------------- */

