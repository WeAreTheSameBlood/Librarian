package hlybchenko.librarian.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private int id;
    private String name;
    private int yearOfBirth;
}