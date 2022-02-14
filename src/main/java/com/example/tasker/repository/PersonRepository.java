package com.example.tasker.repository;

import com.example.tasker.model.Person;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    @Query(value = "INSERT INTO person(name) VALUES(:name)", nativeQuery = true)
    @Modifying
    @Transactional
    void addNewPerson(@Param("name") String username);

    @Query(value = "SELECT * FROM person WHERE id = :id", nativeQuery = true)
    Optional<Person> personById(@Param("id") Long author_id);
}
