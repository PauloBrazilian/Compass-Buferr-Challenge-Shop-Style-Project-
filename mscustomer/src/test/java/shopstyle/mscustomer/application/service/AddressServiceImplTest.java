package shopstyle.mscustomer.application.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import shopstyle.mscustomer.application.service.strategy.FindCustomer;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.domain.entity.Address;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.enums.GenderEnum;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.framework.adapters.out.persistence.AddressRepository;
import shopstyle.mscustomer.framework.exception.AddressNotFoundException;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressServiceImplTest {

    @Mock
    private AddressRepository repository;

    @Mock
    private FindCustomer findCustomer;

    @Mock
    private ClassMapper mapper;

    private AddressServiceImpl service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        this.service = new AddressServiceImpl(repository, findCustomer, mapper);
    }

    @Nested
    @Order(1)
    class createAddress {

        @Test
        void shouldCreateAddressWithSuccess() {
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

            var address = new Address(
                    1L,
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "499",
                    "12.123-123",
                    "",
                    customer
            );


            when(mapper.dtoToAddress(addressDto)).thenReturn(address);
            when(findCustomer.findCustomerById(1L)).thenReturn(customer);
            when(repository.save(address)).thenReturn(address);
            when(mapper.addressToDto(address)).thenReturn(addressDto);

            var createAddressDto = service.createAddress(addressDto);

            verify(findCustomer, times(1)).findCustomerById(1L);
            verify(repository, times(1)).save(address);
            verify(mapper, times(1)).addressToDto(address);

            Assertions.assertEquals(addressDto, createAddressDto, "Create with Success");
        }

        @Test
        void shouldThrowCreateAddressNotFoundException() {

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

            when(findCustomer.findCustomerById(1L)).thenThrow(new CustomerNotFoundException());

            Assertions.assertThrows(CustomerNotFoundException.class, () -> {
                service.createAddress(addressDto);
            });

            verify(findCustomer, times(1)).findCustomerById(1L);
            verify(mapper, times(0)).dtoToAddress(any(AddressDto.class));
            verify(repository, times(0)).save(any(Address.class));
            verify(mapper, times(0)).addressToDto(any(Address.class));

        }

    }

    @Nested
    @Order(2)
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

            var existingAddress = new Address(
                    1L,
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "499",
                    "12.123-123",
                    "",
                    new Customer()
            );

            var updatedAddress = new Address(
                    1L,
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "404",
                    "12.123-123",
                    "",
                    new Customer()
            );

            when(repository.findById(1L)).thenReturn(Optional.of(existingAddress));
            doNothing().when(mapper).updateAddressToDto(addressDto, existingAddress);
            when(repository.save(existingAddress)).thenReturn(updatedAddress);
            when(mapper.addressToDto(updatedAddress)).thenReturn(addressDto);

            var result = service.updateAddress(1L, addressDto);

            verify(repository, times(1)).findById(1L);
            verify(mapper, times(1)).updateAddressToDto(addressDto, existingAddress);
            verify(repository, times(1)).save(existingAddress);
            verify(mapper, times(1)).addressToDto(updatedAddress);

            Assertions.assertEquals(addressDto, result, "Address should be updated successfully");
        }

        @Test
        void shouldThrowAddressNotFoundException() {

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

            when(repository.findById(1L)).thenReturn(Optional.empty());

            Assertions.assertThrows(AddressNotFoundException.class, () -> {
                service.updateAddress(1L, addressDto);
            });

            verify(repository, times(1)).findById(1L);
            verify(mapper, times(0)).updateAddressToDto(any(AddressDto.class), any(Address.class));
            verify(repository, times(0)).save(any(Address.class));
            verify(mapper, times(0)).addressToDto(any(Address.class));
        }

    }

    @Nested
    @Order(3)
    class deleteAddress {

        @Test
        void shouldDeleteAddressByIdWithSuccess() {

            var address = new Address(
                    1L,
                    "SP",
                    "Taquaritinga",
                    "Distrito SP",
                    "Rua dos Passaros",
                    "499",
                    "12.123-123",
                    "",
                    new Customer()
            );

            when(repository.findById(1L)).thenReturn(Optional.of(address));

            service.deleteAddressById(1L);

            verify(repository, times(1)).findById(1L);
            verify(repository, times(1)).deleteById(1L);

            Assertions.assertEquals(1L, 1L, "Delete with Success");

        }

        @Test
        void shouldThrowAddressNotFoundException() {
            when(repository.findById(1L)).thenReturn(Optional.empty());

            Assertions.assertThrows(AddressNotFoundException.class, () -> {
                service.deleteAddressById(1L);
            });

            verify(repository, times(1)).findById(1L);
            verify(repository, times(0)).deleteById(anyLong());

        }

    }

}