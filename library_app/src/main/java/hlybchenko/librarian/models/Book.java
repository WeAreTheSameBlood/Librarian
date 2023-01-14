package hlybchenko.librarian.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;



    @ManyToOne
    @JoinColumn(name = "person_id",referencedColumnName = "id")
    private Person owner;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 3, max = 150, message = "Invalid book name size")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "This field cannot be empty")
    @Size(min = 3, max = 150, message = "Invalid author name size")
    @Column(name = "author")
    private String author;

    @NotNull(message = "This field cannot be empty")
    @Min(value = 1000, message = "The year of publication of the book cannot be less than 1000")
    @Column(name = "year")
    private Integer year;

    public Book(Person owner, String name, String author, Integer year) {
        this.owner = owner;
        this.name = name;
        this.author = author;
        this.year = year;
    }
}