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
import shopstyle.mscustomer.application.service.AddressServiceImpl;
import shopstyle.mscustomer.domain.dto.AddressDto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressControllerTest {

    @Mock
    private AddressServiceImpl service;

    @InjectMocks
    private AddressController controller;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Order(1)
    @Nested
    class createAddress {

        @Test
        void shouldCreateAddressWithSuccess() {
            var addressDto = new AddressDto(
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "499",
                    "12.123-123",
                    "",
                    1L
            );

            when(service.createAddress(addressDto)).thenReturn(addressDto);

            var response = controller.createAddress(addressDto);

            assertEquals(HttpStatus.CREATED, response.getStatusCode());
            assertEquals(addressDto, response.getBody());

        }

    }

    @Order(2)
    @Nested
    class updateAddress {

        @Test
        void shouldUpdateAddressWithSuccess() {
            var addressDto = new AddressDto(
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "499",
                    "12.123-123",
                    "",
                    1L
            );

            when(service.updateAddress(1L, addressDto)).thenReturn(addressDto);

            var response = controller.updateAddress(1L, addressDto);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(addressDto, response.getBody());
        }

    }

    @Order(1)
    @Nested
    class deleteAddress {

        @Test
        void shouldDeleteAddressByIdWithSuccess() {

            doNothing().when(service).deleteAddressById(1L);

            var response = controller.deleteAddressById(1L);

            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals("Delete Address with Success", response.getBody());

        }

    }

}