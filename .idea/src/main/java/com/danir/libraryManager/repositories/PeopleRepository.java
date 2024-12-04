package com.danir.libraryManager.repositories;

import com.danir.libraryManager.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByFullName(String fullName);
    @Query("SELECT p FROM Person p WHERE LOWER(p.fullName) = LOWER(:fullName)")
    Optional<Person> findByFullNameIgnoreCase(@Param("fullName") String fullName);
}
