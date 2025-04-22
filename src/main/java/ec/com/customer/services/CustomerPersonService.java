package ec.com.customer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.customer.repository.CustomerPersonRepository;
import ec.com.customer.repository.PersonRepository;
import ec.com.customer.services.entities.CustomerPerson;
import ec.com.customer.services.entities.Person;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerPersonService {

	private final CustomerPersonRepository customerPersonRepository;
	
	private final PersonRepository personRepository;
	
	public List<CustomerPerson> getCustomerPersons(){
		List<Person> list = personRepository.findAll();
		for (Person person : list) {
			System.out.println(">> " + person.getId());
		}
		return customerPersonRepository.findAll();
	}
	
}
