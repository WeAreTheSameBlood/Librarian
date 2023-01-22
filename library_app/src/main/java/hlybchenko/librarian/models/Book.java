package hlybchenko.librarian.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

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
    @Column(name = "year")
    private Integer year;

    @Column(name = "date_time_bind")
    private Timestamp dateTimeBind;

    public Book(Person owner, String name, String author, Integer year, Timestamp dateTimeBind) {
        this.owner = owner;
        this.name = name;
        this.author = author;
        this.year = year;
        this.dateTimeBind = dateTimeBind;
    }
}