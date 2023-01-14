package hlybchenko.librarian.services;

import hlybchenko.librarian.models.Person;
import hlybchenko.librarian.repositories.PeopleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PeopleService {

    private final PeopleRepo peopleRepo;

    @Autowired
    public PeopleService(PeopleRepo peopleRepo) {
        this.peopleRepo = peopleRepo;
    }

    public List<Person> findAll() {
        return peopleRepo.findAll();
    }

    public Person show(int person_id) {
        return peopleRepo.findById(person_id).orElse(null);
    }

    @Transactional
    public void save(Person newPrson) {
        peopleRepo.save(newPrson);
    }

    @Transactional
    public void update(int person_id, Person updatePerson) {
        updatePerson.setId(person_id);
        peopleRepo.save(updatePerson);
    }

    @Transactional
    public void delete(int person_id) {
        peopleRepo.deleteById(person_id);
    }
}
