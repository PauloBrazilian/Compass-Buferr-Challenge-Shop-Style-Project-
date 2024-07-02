package shopstyle.mscustomer.application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.domain.util.GenderEnum;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;
import shopstyle.mscustomer.framework.exception.GenderNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImplTest {

    @Mock
    private CustomerRepository repository;

    @Mock
    private ClassMapper mapper;

    private CustomerServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.service = new CustomerServiceImpl(repository, mapper);
    }

    @Test
    void shouldFindCustomerByIdWithSuccess() {
        CustomerDto customerDto = new CustomerDto(
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Customer customer = new Customer(
                1L,
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        when(repository.findById(1L)).thenReturn(Optional.of(customer));
        when(mapper.customerToDto(customer)).thenReturn(customerDto);

        CustomerDto foundCustomerDto = service.findCustomerById(1L);

        verify(repository, times(1)).findById(1L);
        verify(mapper, times(1)).customerToDto(customer);

        Assertions.assertEquals(customerDto, foundCustomerDto, "Find customer with Success");
    }

    @Test
    void shouldThrowCustomerNotFoundException() {
        Long invalidId = 99L;

        when(repository.findById(invalidId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> service.findCustomerById(invalidId));

        verify(repository, times(1)).findById(invalidId);
        verify(mapper, never()).customerToDto(any());
    }

    @Test
    void shouldCreateCustomerWithSuccess() {
        CustomerDto customerDto = new CustomerDto(
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Customer customer = new Customer(
                1L,
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        when(mapper.dtoToCustomer(customerDto)).thenReturn(customer);
        when(repository.save(customer)).thenReturn(customer);
        when(mapper.customerToDto(customer)).thenReturn(customerDto);

        CustomerDto createdCustomerDto = service.createCustomer(customerDto);

        verify(mapper, times(1)).dtoToCustomer(customerDto);
        verify(repository, times(1)).save(customer);
        verify(mapper, times(1)).customerToDto(customer);

        Assertions.assertEquals(customerDto, createdCustomerDto, "Create with Success");
    }

    @Test
    void shouldThrowGenderNotFoundException() {
        CustomerDto customerDto = new CustomerDto(
                "123.456.789-10",
                "Paulo",
                "Cruz",
                null,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Assertions.assertThrows(GenderNotFoundException.class, () -> service.createCustomer(customerDto));

        verify(mapper, never()).dtoToCustomer(any());
        verify(repository, never()).save(any());
        verify(mapper, never()).customerToDto(any());
    }


    @Test
    void shouldUpdateCustomerWithSuccess() {
        CustomerDto customerDto = new CustomerDto(
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Customer customer = new Customer(
                1L,
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Customer updatedCustomer = new Customer(
                1L,
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "87654321",
                true
        );

        when(repository.findById(1L)).thenReturn(Optional.of(customer));
        doNothing().when(mapper).updateCustomerToDto(customerDto, customer);
        when(repository.save(customer)).thenReturn(updatedCustomer);
        when(mapper.customerToDto(updatedCustomer)).thenReturn(customerDto);

        CustomerDto updatedCustomerDto = service.updateCustomer(1L, customerDto);

        verify(repository, times(1)).findById(1L);
        verify(mapper, times(1)).updateCustomerToDto(customerDto, customer);
        verify(repository, times(1)).save(customer);
        verify(mapper, times(1)).customerToDto(updatedCustomer);

        Assertions.assertEquals(customerDto, updatedCustomerDto, "Update customer with Success");
    }

    @Test
    void shouldThrowCustomerNotFoundExceptionWhenUpdating() {
        CustomerDto customerDto = new CustomerDto(
                "123.456.789-10",
                "Paulo",
                "Cruz",
                GenderEnum.MASCULINO,
                LocalDate.of(2004, 4, 16),
                "paulo@gmail.com",
                "1235678",
                true
        );

        Long invalidId = 99L;

        when(repository.findById(invalidId)).thenReturn(Optional.empty());

        Assertions.assertThrows(CustomerNotFoundException.class, () -> service.updateCustomer(invalidId, customerDto));

        verify(repository, times(1)).findById(invalidId);
        verify(mapper, never()).updateCustomerToDto(any(), any());
        verify(repository, never()).save(any());
        verify(mapper, never()).customerToDto(any());
    }
}