package shopstyle.mscustomer.application.ports.in;

import shopstyle.mscustomer.domain.dto.CustomerDto;

public interface CustomerService {

    public CustomerDto findCustomerById(Long id);

    public CustomerDto createCustomer(CustomerDto customerDto);

    public CustomerDto updateCustomer(Long id, CustomerDto customerDto);

}
