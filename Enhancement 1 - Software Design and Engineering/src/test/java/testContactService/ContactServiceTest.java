package testContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

class ContactServiceTest {

	private ContactService service;

	@BeforeEach
	void createContactService() {
		this.service = new ContactService();
	}

	@Test
	@DisplayName("Test that we can add a Contact")
	void testAddContact() {
		Contact contact = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");
		service.addContact(contact);
		Assertions.assertEquals(service.getContact("0001"), contact);
	}

	@Test
	@DisplayName("Test that addContact generates sequential IDs when the caller does not supply one")
	void testAddContactGeneratesSequentialIds() {
		service.addContact("John", "Smith", "5731234567", "11 Broadway St, Springfield MO");
		service.addContact("Cheyenne", "Miller", "5731234567", "123 Lauren Ln, Naylor MO");

		Assertions.assertEquals("John", service.getContact("1").getFirstName());
		Assertions.assertEquals("Cheyenne", service.getContact("2").getFirstName());
	}

	@Test
	@DisplayName("Test that the generated-ID addContact still validates its fields")
	void testAddContactGeneratedIdValidatesFields() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addContact("John", "Smith", "not-a-phone", "11 Broadway St, Springfield MO");
		});
	}

	@Test
	@DisplayName("Test that an exception is thrown when we try to add two Contacts with the same ID")
	void testAddContactIdNotUnique() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");
		Contact contact2 = new Contact("0001", "Cheyenne", "Miller", "5731234567", "123 Lauren Ln, Naylor MO");

		service.addContact(contact1);
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(contact2);
		});
	}

	@Test
	@DisplayName("Test that we can delete a contact and that the correct one is deleted")
	void testDeleteContact() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");
		Contact contact2 = new Contact("0002", "Cheyenne", "Miller", "5731234567", "123 Lauren Ln, Naylor MO");

		service.addContact(contact1);
		service.addContact(contact2);

		service.deleteContact("0001");

		assertThrows(IllegalArgumentException.class, () -> {
			service.getContact("0001");
		});
		Assertions.assertEquals(service.getContact("0002"), contact2);
	}

	@Test
	@DisplayName("Test that an IllegalArgumentException is thrown when we try to delete a nonexistant contact")
	void testDeleteContactThatDoesNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.deleteContact("0005");
		});
	}

	@Test
	@DisplayName("Test that we can update a contact's first name")
	void testUpdateContactFirstName() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");

		service.addContact(contact1);
		service.updateFirstName("0001", "Brad");

		Assertions.assertEquals(service.getContact("0001").getFirstName(), "Brad");
	}

	@Test
	@DisplayName("Test that an IllegalArgumentException is thrown when we try to update a nonexistant contact's first name")
	void testUpdateFirstNameContactNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("0005", "Ricky");
		});
	}

	@Test
	@DisplayName("Test that we can update a contact's last name")
	void testUpdateContactLastName() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");

		service.addContact(contact1);
		service.updateLastName("0001", "Jones");

		Assertions.assertEquals(service.getContact("0001").getLastName(), "Jones");
	}

	@Test
	@DisplayName("Test that an IllegalArgumentException is thrown when we try to update a nonexistant contact's last name")
	void testUpdateLastNameNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("0005", "Bobby");
		});
	}

	@Test
	@DisplayName("Test that we can update a contact's phone number")
	void testUpdateContactPhoneNumber() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");

		service.addContact(contact1);
		service.updatePhoneNumber("0001", "4171234567");

		Assertions.assertEquals(service.getContact("0001").getPhoneNumber(), "4171234567");
	}

	@Test
	@DisplayName("Test that an IllegalArgumentException is thrown when we try to update a nonexistant contact's phone numebr")
	void testUpdatePhoneNumberNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhoneNumber("0005", "4176861234");
		});
	}

	@Test
	@DisplayName("Test that we can update a contact's address")
	void testUpdateContactAddress() {
		Contact contact1 = new Contact("0001", "John", "Smith", "5731234567", "11 Broadway St, Springfield MO");

		service.addContact(contact1);
		service.updateAddress("0001", "103 Main St, Poplar Bluff MO");

		Assertions.assertEquals(service.getContact("0001").getAddress(), "103 Main St, Poplar Bluff MO");
	}

	@Test
	@DisplayName("Test that an IllegalArgumentException is thrown when we try to update a nonexistant contact's address")
	void testUpdateAddressNotExist() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("0005", "100 1st Street, New York, New York 10002");
		});
	}

}
