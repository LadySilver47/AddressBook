package Salt.Layla.AdressBook.AddressBookController;

import Salt.Layla.AdressBook.Exceptions.NoContactFoundException;
import Salt.Layla.AdressBook.model.AddressBook;
import Salt.Layla.AdressBook.repository.AddressBookRepo;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressBookController {

    private final AddressBookRepo repo;

    public AddressBookController(AddressBookRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<AddressBook> showAllContacts(){
        return repo.showAllContacts();
    }

    @GetMapping(value = "/{name}")
    public AddressBook searchByName (@PathVariable String name) throws NoContactFoundException {
        return repo.searchByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressBook addContactPerson(@Valid @RequestBody AddressBook addressBook) {
        return repo.addContactPerson(addressBook);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{name}")
    public void removeContact(@PathVariable String name){
        repo.removeContact(name);
}

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping({"/{name}"})
    public void updateContact(@RequestBody AddressBook addressBook, @PathVariable String name){
        repo.updateContact(addressBook, name);
}
}
