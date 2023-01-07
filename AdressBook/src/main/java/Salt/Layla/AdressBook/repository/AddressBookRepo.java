package Salt.Layla.AdressBook.repository;

import Salt.Layla.AdressBook.model.Address;
import Salt.Layla.AdressBook.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AddressBookRepo {
    Map<Person, Address> contacts = new ConcurrentHashMap<>();

    public Collection<Person> addContactPerson(Person p, Address a) {
        contacts.put(p, a);
        return Collections.unmodifiableCollection(contacts.keySet());
    }
    public void removeContact(Person p) {
        if (contacts.containsValue(p))
        {contacts.remove(p);}
    }

    public Collection<Person> showAllContacts() {
        return Collections.unmodifiableCollection(this.contacts.keySet());
    }

    public boolean searchContact(Person p, Address a) {
        if (this.contacts.containsValue(p)) {
            return this.contacts.containsValue(p);
        } else {
            return this.contacts.containsValue(a);
        }
    }
}


