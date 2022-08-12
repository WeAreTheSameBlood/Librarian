package hlybchenko.librarian.models;

import lombok.Data;

@Data
public class Book {
    private int book_id;
    private String name;
    private String author;
    private int year;
}
