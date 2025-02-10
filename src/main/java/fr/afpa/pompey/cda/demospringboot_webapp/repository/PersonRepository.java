package fr.afpa.pompey.cda.demospringboot_webapp.repository;


import fr.afpa.pompey.cda.demospringboot_webapp.config.CustomProperties;
import fr.afpa.pompey.cda.demospringboot_webapp.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class PersonRepository {

    @Autowired
    private CustomProperties properties;

    public Iterable<Person> getPersons() {
        String baseURL = properties.getApiUrl();
        String getPersonsURL = baseURL + "/persons";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Iterable<Person>> response = restTemplate.exchange(getPersonsURL, HttpMethod.GET, null, new ParameterizedTypeReference<>() {}
        );

        log.debug("Get Persons call" + response.getStatusCode());
        return response.getBody();
    }

    public Person getPerson(Integer id) {

        String baseApiUrl = properties.getApiUrl();
        String getPersonsURL = baseApiUrl + "/person/" + id;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person> response = restTemplate.exchange(getPersonsURL, HttpMethod.GET, null, Person.class
        );
        log.debug("Get Person call" + response.getStatusCode());
        return response.getBody();

    }

    public Person createPerson(Person person) {
        String baseApiUrl = properties.getApiUrl();
        String createPersonURL = baseApiUrl + "/person";
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(createPersonURL, HttpMethod.POST, request, Person.class);

        log.debug("Create Person call" + response.getStatusCode());
        return response.getBody();

    }

    public Person updatePerson(Person person) {
        String baseApiUrl = properties.getApiUrl();
        String updatePersonURL = baseApiUrl + "/person/" + person.getId();
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<Person> request = new HttpEntity<>(person);
        ResponseEntity<Person> response = restTemplate.exchange(updatePersonURL, HttpMethod.PUT, request, Person.class);
        log.debug("Update Person call" + response.getStatusCode());
        return response.getBody();
    }

    public void deletePerson(Integer id) {
        String baseApiUrl = properties.getApiUrl();
        String deletePersonURL = baseApiUrl + "/person/" + id;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Void> response = restTemplate.exchange(deletePersonURL, HttpMethod.DELETE, null, Void.class);
        log.debug("Delete Person call" + response.getStatusCode());
    }
}
