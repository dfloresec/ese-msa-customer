package ec.com.customer.controler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import ec.com.customer.services.CustomerPersonService;
import ec.com.customer.services.entities.CustomerPerson;

@ExtendWith(MockitoExtension.class)
class CustomerPersonControlerTest {

	@InjectMocks
	private CustomerPersonControler customerPersonController;

	@Mock
	private CustomerPersonService customerPersonService;

	@Test
	void testCreateCustomer() {
		CustomerPerson mockPerson = new CustomerPerson();
		mockPerson.setName("John Doe");

		when(customerPersonService.saveCustomerPersons(any())).thenReturn(mockPerson);

		CustomerPerson result = customerPersonController.createCustomer(mockPerson);

		assertNotNull(result);
		assertEquals("John Doe", result.getName());
		verify(customerPersonService, times(1)).saveCustomerPersons(mockPerson);
	}

	@Test
	void testGetCustomers() {
		CustomerPerson mockPerson1 = new CustomerPerson();
		CustomerPerson mockPerson2 = new CustomerPerson();
		List<CustomerPerson> mockList = Arrays.asList(mockPerson1, mockPerson2);

		when(customerPersonService.getCustomerPersons()).thenReturn(mockList);

		ResponseEntity<List<CustomerPerson>> response = customerPersonController.getCustomers();

		assertNotNull(response);
		assertEquals(2, response.getBody().size());
		verify(customerPersonService, times(1)).getCustomerPersons();
	}

	@Test
	void testGetCustomerById() {
		CustomerPerson mockPerson = new CustomerPerson();
		mockPerson.setId(1L);

		when(customerPersonService.getCustomerPersonsForId(1L)).thenReturn(mockPerson);

		CustomerPerson result = customerPersonController.getCustomerById(1L);

		assertNotNull(result);
		assertEquals(1L, result.getId());
		verify(customerPersonService, times(1)).getCustomerPersonsForId(1L);
	}

	@Test
	void testUpdatePerson() {
		CustomerPerson existingPerson = new CustomerPerson();
		existingPerson.setId(1L);
		existingPerson.setName("Old Name");

		CustomerPerson updatedDetails = new CustomerPerson();
		updatedDetails.setName("New Name");

		when(customerPersonService.getCustomerPersonsForId(1L)).thenReturn(existingPerson);
		when(customerPersonService.saveCustomerPersons(any())).thenReturn(existingPerson);

		CustomerPerson result = customerPersonController.updatePerson(1L, updatedDetails);

		assertNotNull(result);
		assertEquals("New Name", result.getName());
		verify(customerPersonService, times(1)).getCustomerPersonsForId(1L);
		verify(customerPersonService, times(1)).saveCustomerPersons(existingPerson);
	}

	@Test
	void testDeletePerson() {
		CustomerPerson mockPerson = new CustomerPerson();
		mockPerson.setId(1L);
		mockPerson.setState(true);

		when(customerPersonService.getCustomerPersonsForId(1L)).thenReturn(mockPerson);

		ResponseEntity<?> response = customerPersonController.deletePerson(1L);

		assertNotNull(response);
		verify(customerPersonService, times(1)).getCustomerPersonsForId(1L);
		verify(customerPersonService, times(1)).saveCustomerPersons(mockPerson);
		assertFalse(mockPerson.isState());

	}
}
