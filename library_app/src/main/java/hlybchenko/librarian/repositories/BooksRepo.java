package hlybchenko.librarian.repositories;

import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Book, Integer> {
    List<Book> findAllByOwner_Id(int owner_id);
}
