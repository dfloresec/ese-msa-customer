package ec.com.customer.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResourceNotFoundException {

	private String message;

}
