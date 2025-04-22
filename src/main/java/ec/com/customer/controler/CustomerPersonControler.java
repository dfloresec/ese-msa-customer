package ec.com.customer.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.customer.services.CustomerPersonService;
import ec.com.customer.services.entities.CustomerPerson;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class CustomerPersonControler {

	private final CustomerPersonService customerPersonService;

	@GetMapping
	public ResponseEntity<List<CustomerPerson>> getAllPersons() {
		System.out.println("Inicia");
		List<CustomerPerson> list = customerPersonService.getCustomerPersons();
		for (CustomerPerson customerPerson : list) {
			System.out.println(">> " + customerPerson.getId());
		}
		System.out.println("Fin");
		return ResponseEntity.ok(list);
	}

//	@GetMapping("/{id}")
//	public CustomerPerson getPersonById(@PathVariable Long id) {
//		return personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));
//	}

//	@PostMapping
//	public CustomerPerson createPerson(@RequestBody CustomerPerson person) {
//		return customerPersonRepository.save(person);
//	}

//	@PutMapping("/{id}")
//	public CustomerPerson updatePerson(@PathVariable Long id, @RequestBody CustomerPerson personDetails) {
//		CustomerPerson person = personRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Person not found"));
//		person.setName(personDetails.getName());
//		person.setEmail(personDetails.getEmail());
//		return personRepository.save(person);
//	}
//
//	@DeleteMapping("/{id}")
//	public ResponseEntity<?> deletePerson(@PathVariable Long id) {
//		CustomerPerson person = personRepository.findById(id)
//				.orElseThrow(() -> new ResourceNotFoundException("Person not found"));
//		personRepository.delete(person);
//		return ResponseEntity.ok().build();
//	}
}
