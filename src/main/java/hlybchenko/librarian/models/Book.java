package hlybchenko.librarian.models;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class Book {
    private int book_id;
    private Integer person_id;
    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 3, max = 150, message = "Invalid book name size")
    private String name;
    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 3, max = 150, message = "Invalid author name size")
    private String author;
    @NotNull(message = "This field cannot be empty")
    @Min(value = 1000, message = "The year of publication of the book cannot be less than 1000")
    private Integer year;
}