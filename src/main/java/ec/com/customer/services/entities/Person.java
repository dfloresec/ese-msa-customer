package ec.com.customer.services.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@MappedSuperclass
@Data
public class Person {

	@NotBlank(message = "El campo name es requerido")
	private String name;
	@NotBlank(message = "El campo gender es requerido")
	private String gender;
	private int age;

	@Column(nullable = false, unique = true)
	@NotBlank(message = "El campo identification es requerido")
	@Pattern(regexp = "^\\d{10}$", message = "No cumple el formato")
	private String identification;
	private String address;
	@NotBlank(message = "El campo phone es requerido")
	private String phone;

}