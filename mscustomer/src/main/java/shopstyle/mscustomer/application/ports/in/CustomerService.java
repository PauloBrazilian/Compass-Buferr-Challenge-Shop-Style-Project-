package shopstyle.mscustomer.application.ports.in;

import shopstyle.mscustomer.domain.dto.CustomerDto;

public interface CustomerService {

    CustomerDto findCustomerById(Long id);

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

}
