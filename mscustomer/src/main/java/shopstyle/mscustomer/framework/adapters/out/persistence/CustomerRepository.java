package shopstyle.mscustomer.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscustomer.domain.entity.Customer;

import java.util.Optional;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByFirstName(String firstName);


}