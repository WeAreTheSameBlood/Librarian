package hlybchenko.librarian.repositories;

import hlybchenko.librarian.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepo extends JpaRepository<Person, Integer> {
}
