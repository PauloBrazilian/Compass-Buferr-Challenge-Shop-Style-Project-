package shopstyle.mscustomer.application.service.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;

@AllArgsConstructor
@Service
public class FindAddress {

    private final CustomerRepository customerRepository;

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }
}
