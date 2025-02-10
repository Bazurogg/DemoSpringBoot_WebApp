package fr.afpa.pompey.cda.demospringboot_webapp.service;

import fr.afpa.pompey.cda.demospringboot_webapp.model.Person;
import fr.afpa.pompey.cda.demospringboot_webapp.repository.PersonRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person getPersonById(Integer id) {
        return personRepository.getPerson(id);
    }

    public Iterable<Person> getAllPersons() {
        return personRepository.getPersons();
    }

    public void deletePerson(final Integer id) {
        personRepository.deletePerson(id);
    }

    public Person savePerson(Person person) {
        Person saved;
        person.setLastName(person.getLastName().toUpperCase());

        if (person.getId() == null) {
            saved = personRepository.createPerson(person);

        }else {
            saved = personRepository.updatePerson(person);
        }
        return saved;
    }

}
