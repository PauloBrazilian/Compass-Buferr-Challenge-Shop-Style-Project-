package shopstyle.mscustomer.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscustomer.domain.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {


}