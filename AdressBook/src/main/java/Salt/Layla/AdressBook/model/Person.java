package Salt.Layla.AdressBook.model;

import jakarta.validation.constraints.NotEmpty;

public record Person(
        @NotEmpty(message = "You need to input a name")
        String name
)
{

}
