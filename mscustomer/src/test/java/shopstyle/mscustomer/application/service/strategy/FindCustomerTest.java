package shopstyle.mscustomer.application.service.strategy;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.enums.GenderEnum;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FindCustomerTest {

    @Mock
    private CustomerRepository repository;

    private FindCustomer findCustomer;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
        this.findCustomer = new FindCustomer(repository);
    }

    @Nested
    class findCustomer{

        @Order(1)
        @Test
        void shouldFindCustomerByIdWithSuccess() {

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

            Customer foundCustomer = findCustomer.findCustomerById(1L);

            verify(repository, times(1)).findById(1L);

            Assertions.assertEquals(customer, foundCustomer, "Customer should be found successfully");

        }

        @Order(2)
        @Test
        void shouldThrowCustomerNotFoundExceptionWhenCustomerNotFound() {
            when(repository.findById(1L)).thenReturn(Optional.empty());

            Assertions.assertThrows(CustomerNotFoundException.class, () -> {
                findCustomer.findCustomerById(1L);
            });

            verify(repository, times(1)).findById(1L);
        }

    }


}