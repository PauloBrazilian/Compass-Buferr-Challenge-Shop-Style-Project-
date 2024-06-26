package shopstyle.mscustomer.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.application.ports.in.CustomerService;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final ClassMapper mapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository, ClassMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public CustomerDto findCustomerById(float id) {
        return null;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto updateCustomer(float id, CustomerDto customerDto) {
        return null;
    }
}
