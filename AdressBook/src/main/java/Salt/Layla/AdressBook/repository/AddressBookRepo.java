package Salt.Layla.AdressBook.repository;

import Salt.Layla.AdressBook.Exceptions.NoContactFoundException;
import Salt.Layla.AdressBook.model.AddressBook;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AddressBookRepo {
    List<AddressBook> contacts = new ArrayList<>();

    public AddressBookRepo(){
        contacts.add(new AddressBook("Markona", "Vulgaria", "6969", "420",
                "City city", "County county", "Country country", "9999999999",
                "mySharona@whodidthissongagain.cough"));

    }

    public AddressBook addContactPerson(AddressBook addressBook) {
        contacts.add(addressBook);
        return addressBook;
    }
    public void updateContact(AddressBook addressBook, String name) {
        AddressBook existing = contacts.stream().filter(s -> s.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Contact not found"));
        int i = contacts.indexOf(existing);
        contacts.set(i, addressBook);}

    public List<AddressBook> showAllContacts() {
        return contacts;
    }

    public AddressBook searchByName(String name) throws NoContactFoundException {
        return contacts.stream().filter(contact -> contact.name().equals(name)).findFirst().orElseThrow(NoContactFoundException::new);
    }

        public AddressBook searchByStreet(String street) throws NoContactFoundException {
            return contacts.stream().filter(contact -> contact.street().equals(street)).findFirst().orElseThrow(NoContactFoundException::new);}

    public void removeContact(String name){
        contacts.removeIf(contact -> contact.name().equals(name));
    }
}


