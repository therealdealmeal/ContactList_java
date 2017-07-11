/**
 * One object of this class represents the information of
 * all of the people information in the contact list.
 */

package test;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ContactList implements Serializable{
	
	private static final int MAX_CONTACTS = 1000;
	private Contact[] contacts;
	private int numOfContacts;
	private int availableIndex;
	
	/**
	 * Constructs a list for numberOfContacts of type contact(object).	
	 * - DA
	 */
	public ContactList() {
		contacts = new Contact[MAX_CONTACTS]; // Allocates numberOfContacts of elements in array
	}
	
	/**
	 * Re-Count number of Contacts stored in the list after loading the file in disk
	 * to get the value for numOfContacts
	 * - DA
	 */
	public void numberOfContacts() {
		for(int k = 0; k < MAX_CONTACTS; k++)
			if(contacts[k] != null)
				numOfContacts++;
	}

	/**
	 * Adds contact to the list if array is not full
	 * -DA
	 */
	public void addContactToList(Contact contactObject) {
		
		int lengthOfLastName;
		lengthOfLastName = contactObject.getLastName().length();
		
		if( (lengthOfLastName != 0) && (checkIndexesUsed() == true) ) { // check the availability of the array & last name length
			contacts[availableIndex] = contactObject;
			numOfContacts++;
			System.out.println("\nContact information saved in the list! \n");
			}
		else if ((checkIndexesUsed() == false)) // only if the array is full
			System.out.println("\nContact List is full! Can't add more contacts...\n");
	}
	
	/**
	 * Method will check how many contacts stored in the list, if it's full user can't add more contact. 
	 * -DA
	 */
	public boolean checkIndexesUsed() {
		boolean condition;
		condition = false;
		
		for(int k = 0; k < MAX_CONTACTS; k++)
			if(contacts[k] == null || contacts[k].getLastName() == "zz-anonymous") {
				availableIndex = k;
				condition = true;
				break;
			}
	    return condition;
	}
	
	/**
	 * Prints the whole contact list of objects stored in the array. 
	 * - DA
	 */
	public void printContactList() {
		
		String formatedString;
		formatedString = "";
		
		sortArray();
		
		System.out.println("\nContact List: \n");
		for(int k = 0; k < numOfContacts; k++)
			formatedString += contacts[k] + "\n";
		
		System.out.println(formatedString);
		
	}
	/**
	 * Asks the user for lastName of person to locate in the contact list,
	 * print a string of all within contact list with given last name from user.
	 * - DA
	 */
	public void retrieveInformation() {
		
		Scanner userLastNameInput;
		userLastNameInput = new Scanner(System.in);
		
		String lastNameSearch, informationGivenLastName, printInfo = "";
		int validity = numOfContacts - 1 ,lastNameFound = 0, lastNameNotFound = 0;
		
		
		System.out.print("\nLast Name? ");
		lastNameSearch = userLastNameInput.nextLine();
		System.out.println();
		informationGivenLastName = "";
		
		sortArray(); // Sort the array first before printing
		
		for(int k = 0; k < numOfContacts; k++)
			if(contacts[k].getLastName().compareToIgnoreCase(lastNameSearch) == 0) {
				printInfo += (contacts[k].toString()) + "\n";
				lastNameFound = 1;
			}
			else if (lastNameFound != 1)
				lastNameNotFound = 1;
		
		if(lastNameFound > 0)
			System.out.println(printInfo);
		else if(lastNameNotFound > 0)
			System.out.println("Sorry there's no " + lastNameSearch + " in contact list.\n");
	}
	
	/**
	 * Sort the array in an ascending order using compareTo() in class Contacts
	 * given contact's last name 
	 * - DA & EY
	 */
	public void sortArray() {
		setDefault(); // set empty elements to default for sorting purposes
		Arrays.sort(contacts);
		setDefaultToNull(); // set default elements back to null

	}
	
	/**
	 * Set empty element to default information for sorting purpose
	 * - DA
	 */
	public void setDefault() {
		
		for(int k = numOfContacts; k < MAX_CONTACTS; k++) {
			if(contacts[k] == null)
				contacts[k] = new Contact();
		}
	}
	
	/**
	 * Set default element back to null
	 * - DA
	 */
	public void setDefaultToNull() {
		
		for(int k = numOfContacts; k < MAX_CONTACTS; k++) {
			if(contacts[k].getLastName() == "zz-anonymous")
				contacts[k] = null;
		}
	}
	
	/**
	 * Asking user if they really want to quit the program.
	 * If yes return true, if not return false to exitAndSave()
	 * - DA
	 */
	public boolean areYouSure() {
		
		Scanner userInput;
		userInput = new Scanner(System.in);
		
		char userOption;
		boolean condition;
		
		System.out.print("\nAre you sure you want to exit (Y/N)? ");
		userOption = userInput.next().charAt(0);
		
		if(userOption == 'Y' || userOption == 'y' ) {
			condition = true;
		}
		else if(userOption == 'N' || userOption == 'n')
			condition = false;
		else {
			System.out.println("\nPlease enter Y/N for next time...\n");
			condition = false;
		}

		return condition;
	}
	
	/**
	 * User exits from the program and contact list is saved in disk
	 * - DA
	 */
	public int exitAndSave() {
		
		int condition;
		condition = 0;
		boolean userValidity;
		
		userValidity = areYouSure();
		
		if(userValidity == true) {
			FileOutputStream outFile;
			ObjectOutputStream outObject;
			
			try {
				outFile = new FileOutputStream ("contact list");
				outObject = new ObjectOutputStream(outFile);
				outObject.writeObject(contacts);
				outFile.close();
				outObject.close();
			} catch (IOException ioe) {
				System.out.println("Error writing object(s) to the file: " + ioe.getMessage());
			}
			condition = 4;
			System.out.println("\nSee you soon!");
		}
		return condition;
	}
	
	/**
	 * Load previously saved contact list in disk
	 * - DA
	 */
	public void loadSavedFile() {
		FileInputStream inFile;
	    ObjectInputStream inObject;

	    try {
	        inFile = new FileInputStream("contact list");      
	        inObject = new ObjectInputStream(inFile);
	        contacts = (Contact[])inObject.readObject();
	        inFile.close();
	        inObject.close(); 
	        
	        // re-count number of contacts stored in the list to variable numOfContacts
	        numberOfContacts();
	        
	        System.out.println("There are " + numOfContacts + " contacts loaded to the list!\n");
	        
	        
	    } catch(IOException ioe)  {
	       System.out.println ("There are " + numOfContacts + " contacts saved in the disk… Let’s start a new one!\n");
	    } catch (ClassNotFoundException cnfe)  {
	       System.out.println ("Error in casting to Contact: " + cnfe);
	    }                      
	}
}