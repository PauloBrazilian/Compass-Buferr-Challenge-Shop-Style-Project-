package shopstyle.mscustomer.framework.exception;

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
import shopstyle.mscustomer.application.service.AddressServiceImpl;
import shopstyle.mscustomer.application.service.CustomerServiceImpl;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.framework.adapters.in.rest.AddressController;
import shopstyle.mscustomer.framework.adapters.in.rest.CustomerController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @Mock
    private AddressServiceImpl addressService;

    @Mock
    private AddressController addressController;

    @Mock
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerController customerController;

    @InjectMocks
    private GlobalExceptionHandler handler;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Order(1)
    @Nested
    class customerExceptions {

        @Test
        void shouldDeleteAddressWithSuccess() {
        }

        @Test
        void returnGenderNotFoundException() {
        }

    }


    @Order(2)
    @Nested
    class addressExceptions {

        @Test
        void addressNotFoundException() {
        }

    }

}