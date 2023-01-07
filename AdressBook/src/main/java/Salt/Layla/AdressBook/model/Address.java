package Salt.Layla.AdressBook.model;

import jakarta.validation.constraints.NotEmpty;

public record Address(
        @NotEmpty(message = "This field is required.")
        String street,
        @NotEmpty(message = "This field is required.")
        String houseNr,
        @NotEmpty(message = "This field is required.")
        String postalCode,
        @NotEmpty(message = "This field is required.")
        String city,
        @NotEmpty(message = "This field is required.")
        String municipality,
        @NotEmpty(message = "This field is required.")
        String country,
        String phoneNumber,
        String email
) {
}
