package hlybchenko.librarian.services;

import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import hlybchenko.librarian.repositories.BooksRepo;
import hlybchenko.librarian.repositories.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BooksService {

    private final BooksRepo booksRepo;
    private final PeopleRepo peopleRepo;

    @Autowired
    public BooksService(BooksRepo booksRepo, PeopleRepo peopleRepo) {
        this.booksRepo = booksRepo;
        this.peopleRepo = peopleRepo;
    }

    public List<Book> findAll() {
        return booksRepo.findAll();
    }

    public Book show(int book_id) {
        return booksRepo.findById(book_id).orElse(null);
    }

    @Transactional
    public void save(Book newBook) {
        booksRepo.save(newBook);
    }

    @Transactional
    public void update(int book_id, Book updateBook) {
        updateBook.setBook_id(book_id);
        booksRepo.save(updateBook);
    }

    @Transactional
    public void delete(int book_id) {
        booksRepo.deleteById(book_id);
    }

    @Transactional
    public void bind(int book_id, int person_id) {
        booksRepo.findById(book_id).orElse(null)
                .setOwner(peopleRepo.findById(person_id).orElse(null));
    }

    @Transactional
    public void unbind(int book_id) {
        booksRepo.findById(book_id).orElse(null).setOwner(null);
    }

    public Person getBookOwner(int book_id) {
        return booksRepo.findById(book_id).get().getOwner();
    }

    public List<Book> checkBindingOnPerson(int person_id) {
        return booksRepo.findAllByOwner_Id(person_id);
    }
}
