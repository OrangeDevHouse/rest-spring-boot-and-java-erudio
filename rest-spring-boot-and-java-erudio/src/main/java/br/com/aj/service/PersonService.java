package br.com.aj.service;

import br.com.aj.model.Person;

import java.util.List;

public interface PersonService {

    Person findById(Long id);

    List<Person> findAll();

    Person save(Person person);

}
