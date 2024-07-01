package shopstyle.mscustomer.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import shopstyle.mscustomer.application.ports.in.CustomerService;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.domain.util.GenderEnum;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;
import shopstyle.mscustomer.framework.exception.GenderNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @Mock
    private ClassMapper mapper;

    @InjectMocks
    private CustomerServiceImpl service;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void findCustomerById() throws CustomerNotFoundException {
    }

    @Test
    void findCustomerById_notFound() {
    }

    @Test
    void createCustomer() {
    }

    @Test
    void createCustomer_invalidGender() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setSex(null);

        assertThrows(GenderNotFoundException.class, () -> service.createCustomer(customerDto));

        verifyNoMoreInteractions(repository);
        verifyNoMoreInteractions(mapper);
    }

    @Test
    void updateCustomer(){
    }

    @Test
    void updateCustomer_notFound() {
    }
}