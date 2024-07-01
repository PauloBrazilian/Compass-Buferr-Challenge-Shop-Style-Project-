package shopstyle.mscustomer.domain.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressDtoTest {


    @Test
    void getState() {
        AddressDto addressDto = new AddressDto();
        String state = "SP";
        addressDto.setState(state);
        assertEquals(state, addressDto.getState());
    }

    @Test
    void getCity() {
        AddressDto addressDto = new AddressDto();
        String city = "São Paulo";
        addressDto.setCity(city);
        assertEquals(city, addressDto.getCity());
    }

    @Test
    void getDistrict() {
        AddressDto addressDto = new AddressDto();
        String district = "Centro";
        addressDto.setDistrict(district);
        assertEquals(district, addressDto.getDistrict());
    }

    @Test
    void getStreet() {
        AddressDto addressDto = new AddressDto();
        String street = "Rua das Flores";
        addressDto.setStreet(street);
        assertEquals(street, addressDto.getStreet());
    }

    @Test
    void getNumber() {
        AddressDto addressDto = new AddressDto();
        String number = "123";
        addressDto.setNumber(number);
        assertEquals(number, addressDto.getNumber());
    }

    @Test
    void getCep() {
        AddressDto addressDto = new AddressDto();
        String cep = "12.345-678";
        addressDto.setCep(cep);
        assertEquals(cep, addressDto.getCep());
    }

    @Test
    void getComplement() {
        AddressDto addressDto = new AddressDto();
        String complement = "Apto 101";
        addressDto.setComplement(complement);
        assertEquals(complement, addressDto.getComplement());
    }

    @Test
    void getCustomerId() {
        AddressDto addressDto = new AddressDto();
        Long customerId = 1L;
        addressDto.setCustomerId(customerId);
        assertEquals(customerId, addressDto.getCustomerId());
    }

    @Test
    void setState() {
        AddressDto addressDto = new AddressDto();
        String state = "SP";
        addressDto.setState(state);
        assertEquals(state, addressDto.getState());
    }

    @Test
    void setCity() {
        AddressDto addressDto = new AddressDto();
        String city = "São Paulo";
        addressDto.setCity(city);
        assertEquals(city, addressDto.getCity());
    }

    @Test
    void setDistrict() {
        AddressDto addressDto = new AddressDto();
        String district = "Centro";
        addressDto.setDistrict(district);
        assertEquals(district, addressDto.getDistrict());
    }

    @Test
    void setStreet() {
        AddressDto addressDto = new AddressDto();
        String street = "Rua das Flores";
        addressDto.setStreet(street);
        assertEquals(street, addressDto.getStreet());
    }

    @Test
    void setNumber() {
        AddressDto addressDto = new AddressDto();
        String number = "123";
        addressDto.setNumber(number);
        assertEquals(number, addressDto.getNumber());
    }

    @Test
    void setCep() {
        AddressDto addressDto = new AddressDto();
        String cep = "12.345-678";
        addressDto.setCep(cep);
        assertEquals(cep, addressDto.getCep());
    }

    @Test
    void setComplement() {
        AddressDto addressDto = new AddressDto();
        String complement = "Apto 101";
        addressDto.setComplement(complement);
        assertEquals(complement, addressDto.getComplement());
    }

    @Test
    void setCustomerId() {
        AddressDto addressDto = new AddressDto();
        Long customerId = 1L;
        addressDto.setCustomerId(customerId);
        assertEquals(customerId, addressDto.getCustomerId());
    }

    @Test
    void testToString() {
        AddressDto addressDto = new AddressDto();
        addressDto.setState("SP");
        addressDto.setCity("São Paulo");
        addressDto.setDistrict("Centro");
        addressDto.setStreet("Rua das Flores");
        addressDto.setNumber("123");
        addressDto.setCep("12.345-678");
        addressDto.setComplement("Apto 101");
        addressDto.setCustomerId(1L);

        String expected = "AddressDto{" +
                "state='" + addressDto.getState() + '\'' +
                ", city='" + addressDto.getCity() + '\'' +
                ", district='" + addressDto.getDistrict() + '\'' +
                ", street='" + addressDto.getStreet() + '\'' +
                ", number='" + addressDto.getNumber() + '\'' +
                ", cep='" + addressDto.getCep() + '\'' +
                ", complement='" + addressDto.getComplement() + '\'' +
                ", customerId=" + addressDto.getCustomerId() +
                '}';

        assertEquals(expected, addressDto.toString());
    }

    @Test
    void builder() {
        AddressDto addressDto = AddressDto.builder()
                .state("SP")
                .city("São Paulo")
                .district("Centro")
                .street("Rua das Flores")
                .number("123")
                .cep("12.345-678")
                .complement("Apto 101")
                .customerId(1L)
                .build();

        assertEquals("SP", addressDto.getState());
        assertEquals("São Paulo", addressDto.getCity());
        assertEquals("Centro", addressDto.getDistrict());
        assertEquals("Rua das Flores", addressDto.getStreet());
        assertEquals("123", addressDto.getNumber());
        assertEquals("12.345-678", addressDto.getCep());
        assertEquals("Apto 101", addressDto.getComplement());
        assertEquals(1L, addressDto.getCustomerId());
    }
}