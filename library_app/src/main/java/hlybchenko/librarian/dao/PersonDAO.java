package hlybchenko.librarian.dao;

import hlybchenko.librarian.models.Book;
import hlybchenko.librarian.models.Person;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class PersonDAO {

//    private final EntityManager entityManager;
//
//    @Autowired
//    public PersonDAO(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Transactional(readOnly = true)
//    public void getAllBooks(){
//        Session session = entityManager.unwrap(Session.class);
//
//        Set<Person> people = new HashSet<>(session.createQuery("select p from Person p LEFT JOIN FETCH p.books")
//                                    .getResultList());
//
//        for (Person person : people) {
//            System.out.println(person.getBooks());
//        }
//    }

//    private final JdbcTemplate jdbcTemplate;
//
//    @Autowired
//    public PersonDAO(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Person> index() {
//        return jdbcTemplate.query("SELECT * FROM person",
//                new BeanPropertyRowMapper<>(Person.class));
//    }
//
//    public Person show(int id) {
//        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[] {id},
//                new BeanPropertyRowMapper<>(Person.class))
//                .stream().findAny().orElse(null);
//    }
//
//    public void save (Person person) {
//        jdbcTemplate.update("INSERT INTO Person(name, yearofbirth) VALUES (?,?)",
//                person.getName(), person.getYearOfBirth());
//    }
//
//    public void update (int id, Person person) {
//        jdbcTemplate.update("UPDATE Person SET name=?, yearofbirth=? WHERE id=?",
//                person.getName(), person.getYearOfBirth(), id);
//    }
//
//    public void delete(int id) {
//        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
//    }
}