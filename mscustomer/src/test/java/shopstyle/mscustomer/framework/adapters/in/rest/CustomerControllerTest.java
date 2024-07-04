package shopstyle.mscustomer.framework.adapters.in.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import shopstyle.mscustomer.application.service.CustomerServiceImpl;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.domain.enums.GenderEnum;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerServiceImpl service;

    @InjectMocks
    private CustomerController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Order(1)
    @Nested
    class createCustomer {

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

            when(service.createCustomer(customerDto)).thenReturn(customerDto);

            var response = controller.createCustomer(customerDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(customerDto, response.getBody());

        }

    }

    @Order(2)
    @Nested
    class findCustomer {

        @Test
        void shouldFindCustomerWithSuccess() {

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

            when(service.findCustomerById(1L)).thenReturn(customerDto);

            ResponseEntity<CustomerDto> response = controller.findCustomerById(1L);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(customerDto, response.getBody());
        }

    }

    @Order(3)
    @Nested
    class udpateCustomer {

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

            when(service.updateCustomer(1L, customerDto)).thenReturn(customerDto);

            ResponseEntity<CustomerDto> response = controller.updateCustomer(1L, customerDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(customerDto, response.getBody());
        }

    }


}