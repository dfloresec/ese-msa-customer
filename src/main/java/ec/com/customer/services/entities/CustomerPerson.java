package ec.com.customer.services.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(schema = "customer")
@Getter
@Setter
public class CustomerPerson extends Person {

//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long clienteid;

  private String password;

  private Boolean state;

}
