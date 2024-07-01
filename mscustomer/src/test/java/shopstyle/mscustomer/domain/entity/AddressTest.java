package shopstyle.mscustomer.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AddressTest {

    @Test
    void testGetAndSetId() {
        Address address = new Address();
        Long id = 1L;
        address.setId(id);
        assertEquals(id, address.getId());
    }

    @Test
    void testGetAndSetState() {
        Address address = new Address();
        String state = "SP";
        address.setState(state);
        assertEquals(state, address.getState());
    }

    @Test
    void testGetAndSetCity() {
        Address address = new Address();
        String city = "São Paulo";
        address.setCity(city);
        assertEquals(city, address.getCity());
    }

    @Test
    void testGetAndSetDistrict() {
        Address address = new Address();
        String district = "Centro";
        address.setDistrict(district);
        assertEquals(district, address.getDistrict());
    }

    @Test
    void testGetAndSetStreet() {
        Address address = new Address();
        String street = "Rua das Flores";
        address.setStreet(street);
        assertEquals(street, address.getStreet());
    }

    @Test
    void testGetAndSetNumber() {
        Address address = new Address();
        String number = "123";
        address.setNumber(number);
        assertEquals(number, address.getNumber());
    }

    @Test
    void testGetAndSetCep() {
        Address address = new Address();
        String cep = "12.345-678";
        address.setCep(cep);
        assertEquals(cep, address.getCep());
    }

    @Test
    void testGetAndSetComplement() {
        Address address = new Address();
        String complement = "Apto 101";
        address.setComplement(complement);
        assertEquals(complement, address.getComplement());
    }

    @Test
    void testGetAndSetCustomer() {
        Address address = new Address();
        Customer customer = new Customer();
        customer.setId(1L);
        address.setCustomer(customer);
        assertEquals(customer, address.getCustomer());
    }

    @Test
    void testToString() {Address address = new Address();
        address.setId(1L);
        address.setState("SP");
        address.setCity("São Paulo");
        address.setDistrict("Centro");
        address.setStreet("Rua das Flores");
        address.setNumber("123");
        address.setCep("12.345-678");
        address.setComplement("Apto 101");

        Customer customer = new Customer();
        customer.setId(1L);
        address.setCustomer(customer);

        String expected = "Address{" +
                "id=" + address.getId() +
                ", state='" + address.getState() + '\'' +
                ", city='" + address.getCity() + '\'' +
                ", district='" + address.getDistrict() + '\'' +
                ", street='" + address.getStreet() + '\'' +
                ", number='" + address.getNumber() + '\'' +
                ", cep='" + address.getCep() + '\'' +
                ", complement='" + address.getComplement() + '\'' +
                ", customer=" + customer +
                '}';

        assertEquals(expected, address.toString());
    }
}