package ec.com.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.com.customer.services.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
