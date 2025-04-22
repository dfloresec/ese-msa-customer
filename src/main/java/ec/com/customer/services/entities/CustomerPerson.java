package ec.com.customer.services.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerPerson extends Person {

	@Column(unique = true)
	private String clienteid;

	private String password;

	private Boolean state;

}
