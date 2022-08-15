package hlybchenko.librarian.models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Person {
    private Integer id;
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z].",
    message = "Your full name should be in this format: Firstname Lastname Patronymic (William Gates H.)")
    private String name;
    @NotNull(message = "This field cannot be empty")
    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    private Integer yearOfBirth;
}