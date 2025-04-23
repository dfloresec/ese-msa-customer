package ec.com.customer.services;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.com.customer.exception.ResourceNotFoundException;
import ec.com.customer.repository.CustomerPersonRepository;
import ec.com.customer.services.entities.CustomerPerson;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerPersonService {

	private final CustomerPersonRepository customerPersonRepository;

	public List<CustomerPerson> getCustomerPersons() {
		return customerPersonRepository.findByStateTrue();
	}

	public CustomerPerson getCustomerPersonsForId(Long id) {
		return customerPersonRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada"));
	}

	public CustomerPerson saveCustomerPersons(CustomerPerson customerPerson) {
		return customerPersonRepository.save(customerPerson);
	}

}
