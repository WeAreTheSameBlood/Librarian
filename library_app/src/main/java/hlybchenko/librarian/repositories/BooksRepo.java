package hlybchenko.librarian.repositories;

import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import org.apache.logging.log4j.message.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BooksRepo extends JpaRepository<Book, Integer> {

    List<Book> findAllByOwner_Id(int owner_id);
}
