package contactService;

/**
 * A contact object that has a unique ID, first name, last name, phone number, and address.
 * <br>
 * For use by the ContactService class
 *
 * @author Dalton Young <dalton.young@snhu.edu>
 *
 */
public class Contact {
	/**
	 * A unique ID for the contact
	 */
	private String id;

	/**
	 * The contact's first name
	 */
	private String firstName;

	/**
	 * The contact's last name
	 */
	private String lastName;

	/**
	 * The contact's phone number
	 */
	private String phoneNumber;

	/**
	 * The contact's address
	 */
	private String address;

	/**
	 * Constructor. Returns a Contact object
	 *
	 * @param id Unique ID. Cannot be null or more than 10 characters
	 * @param firstName Contact's first name. Cannot be null or more than 10 characters
	 * @param lastName Contact's last name. Cannot be null or more than 10 characters
	 * @param phoneNumber Contact's phone number. Cannot be null, must be exactly 10 characters, and can only contain the digits 0-9
	 * @param address Contact's address. Cannot be null or more than 30 characters
	 */
	public Contact(String id, String firstName, String lastName, String phoneNumber, String address) {
		// Validate the parameters and throw an IllegalArgumentException if they are not valid
		if(id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		if(phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}

		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	/**
	 * Return the contact's ID
	 *
	 * @return Contact's unique ID
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Return the contact's first name
	 *
	 * @return The contact's first name
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Return the contact's last name
	 *
	 * @return The contact's last name
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Return the contact's phone number
	 *
	 * @return The contact's phone number
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * Return the contact's address
	 *
	 * @return The contact's address
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 * Set the contact's first name
	 *
	 * @param firstName Contact's first name. Cannot be null or more than 10 characters
	 */
	public void setFirstName(String firstName) {
		// Validate firstName and throw an IllegalArgument if it is invalid
		if(firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}

		this.firstName = firstName;
	}

	/**
	 * Set the contact's last name
	 *
	 * @param lastName Contact's last name. Cannot be null or more than 10 characters
	 */
	public void setLastName(String lastName) {
		// Validate lastName and throw an IllegalArgument if it is invalid
		if(lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}

		this.lastName = lastName;
	}

	/**
	 * Set the contact's phone number
	 *
	 * @param phoneNumber Contact's phone number. Cannot be null, must be exactly 10 characters, and can only contain the digits 0-9
	 */
	public void setPhoneNumber(String phoneNumber) {
		// Validate phoneNumber and throw an IllegalArgument if it is invalid
		if(phoneNumber == null || phoneNumber.length() != 10 || !phoneNumber.matches("[0-9]+")) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}

		this.phoneNumber = phoneNumber;
	}

	/**
	 * Set the contact's address
	 *
	 * @param address Contact's address. Cannot be null or more than 30 characters
	 */
	public void setAddress(String address) {
		// Validate address and throw an IllegalArgument if it is invalid
		if(address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid Address");
		}

		this.address = address;
	}
}
