package ec.com.customer.services.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Person {

	private String name;
	private String gender;
	private int age;

	@Column(nullable = false, unique = true)
	private String identification;
	private String address;
	private String phone;

}
