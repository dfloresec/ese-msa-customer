package ec.com.customer.controler;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@PostMapping
	public CustomerPerson createCustomer(@RequestBody CustomerPerson person) {
		return customerPersonService.saveCustomerPersons(person);
	}

	@GetMapping
	public ResponseEntity<List<CustomerPerson>> getCustomers() {
		List<CustomerPerson> list = customerPersonService.getCustomerPersons();
		return ResponseEntity.ok(list);
	}

	@GetMapping("/{id}")
	public CustomerPerson getCustomerById(@PathVariable("id") Long id) {
		return customerPersonService.getCustomerPersonsForId(id);
	}

	@PutMapping("/{id}")
	public CustomerPerson updatePerson(@PathVariable("id") Long id, @RequestBody CustomerPerson personDetails) {
		CustomerPerson person = customerPersonService.getCustomerPersonsForId(id);
		person.setPassword(personDetails.getPassword());

		person.setName(personDetails.getName());
		person.setGender(personDetails.getGender());
		person.setAge(personDetails.getAge());
		person.setIdentification(personDetails.getIdentification());
		person.setAddress(personDetails.getAddress());
		person.setPhone(personDetails.getPhone());
		return customerPersonService.saveCustomerPersons(person);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable("id") Long id) {
		CustomerPerson person = customerPersonService.getCustomerPersonsForId(id);
		person.setState(false);
		customerPersonService.saveCustomerPersons(person);
		return ResponseEntity.ok().build();
	}

}
