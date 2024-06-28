package shopstyle.mscustomer.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.application.ports.in.CustomerService;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.domain.util.GenderEnum;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;
import shopstyle.mscustomer.framework.exception.GenderNotFoundException;

import java.util.EnumSet;

@AllArgsConstructor
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final ClassMapper mapper;

    @Override
    public CustomerDto findCustomerById(Long id) {
        var customer = repository.findById(id).orElseThrow(
                CustomerNotFoundException::new);
        return mapper.customerToDto(customer);
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        if (customerDto.getSex() == null || !EnumSet.of(GenderEnum.MASCULINO, GenderEnum.FEMININO).contains(customerDto.getSex())) {
            throw new GenderNotFoundException();
        }

        var customer = mapper.dtoToCustomer(customerDto);
        repository.save(customer);
        return mapper.customerToDto(customer);
    }

    @Override
    public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
        var customer = repository.findById(id).orElseThrow(CustomerNotFoundException::new);
        mapper.updateCustomerToDto(customerDto, customer);
        Customer updatedCustomer = repository.save(customer);
        return mapper.customerToDto(updatedCustomer);
    }
}
