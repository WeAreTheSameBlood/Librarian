package hlybchenko.librarian.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z].",
    message = "Your full name should be in this format: Firstname Lastname Patronymic (William Gates H.)")
    @Column(name = "name")
    private String name;

    @NotNull(message = "This field cannot be empty")
    @Min(value = 1900, message = "Year of birth should be greater than 1900")
    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @OneToMany(mappedBy = "owner")
    private List<Book> books;

    public Person(String name, Integer yearOfBirth, List<Book> books) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.books = books;
    }
}