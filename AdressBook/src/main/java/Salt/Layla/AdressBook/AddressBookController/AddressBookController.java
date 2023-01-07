package Salt.Layla.AdressBook.AddressBookController;

import Salt.Layla.AdressBook.model.Address;
import Salt.Layla.AdressBook.model.Person;
import Salt.Layla.AdressBook.repository.AddressBookRepo;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    private final AddressBookRepo repo;

    public AddressBookController(AddressBookRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public Collection<Person> showAllContacts(){
        return repo.showAllContacts();
    }

    @GetMapping("/{p}")
    public boolean searchContact (@PathVariable Person p, Address a){
        return repo.searchContact(p, a);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Collection<Person> addContactPerson(@Valid @RequestBody Person p, Address a) {
        return repo.addContactPerson(p, a);
    }

    @DeleteMapping("/{p}")
public void removeContact(@PathVariable Person p){
        repo.removeContact(p);
}
}
