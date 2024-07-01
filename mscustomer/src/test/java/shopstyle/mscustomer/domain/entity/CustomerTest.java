package shopstyle.mscustomer.domain.entity;

import org.junit.jupiter.api.Test;
import shopstyle.mscustomer.domain.util.GenderEnum;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void getId() {
        Customer customer = new Customer();
        Long id = 1L;
        customer.setId(id);
        assertEquals(id, customer.getId());
    }

    @Test
    void getCpf() {
        Customer customer = new Customer();
        String cpf = "123.456.789-00";
        customer.setCpf(cpf);
        assertEquals(cpf, customer.getCpf());
    }

    @Test
    void getFirstName() {
        Customer customer = new Customer();
        String firstName = "John";
        customer.setFirstName(firstName);
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    void getLastName() {
        Customer customer = new Customer();
        String lastName = "Doe";
        customer.setLastName(lastName);
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void getSex() {
        Customer customer = new Customer();
        GenderEnum sex = GenderEnum.FEMININO;
        customer.setSex(sex);
        assertEquals(sex, customer.getSex());
    }

    @Test
    void getBirthdate() {
        Customer customer = new Customer();
        LocalDate birthdate = LocalDate.of(1990, 1, 1);
        customer.setBirthdate(birthdate);
        assertEquals(birthdate, customer.getBirthdate());
    }

    @Test
    void getEmail() {
        Customer customer = new Customer();
        String email = "john.doe@example.com";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    @Test
    void getPassword() {
        Customer customer = new Customer();
        String password = "password123";
        customer.setPassword(password);
        assertEquals(password, customer.getPassword());
    }

    @Test
    void getActive() {
        Customer customer = new Customer();
        Boolean active = true;
        customer.setActive(active);
        assertEquals(active, customer.getActive());
    }

    @Test
    void setId() {
        Customer customer = new Customer();
        Long id = 1L;
        customer.setId(id);
        assertEquals(id, customer.getId());
    }

    @Test
    void setCpf() {
        Customer customer = new Customer();
        String cpf = "123.456.789-00";
        customer.setCpf(cpf);
        assertEquals(cpf, customer.getCpf());
    }

    @Test
    void setFirstName() {
        Customer customer = new Customer();
        String firstName = "John";
        customer.setFirstName(firstName);
        assertEquals(firstName, customer.getFirstName());
    }

    @Test
    void setLastName() {
        Customer customer = new Customer();
        String lastName = "Doe";
        customer.setLastName(lastName);
        assertEquals(lastName, customer.getLastName());
    }

    @Test
    void setSex() {
        Customer customer = new Customer();
        GenderEnum sex = GenderEnum.MASCULINO;
        customer.setSex(sex);
        assertEquals(sex, customer.getSex());
    }

    @Test
    void setBirthdate() {
        Customer customer = new Customer();
        LocalDate birthdate = LocalDate.of(1990, 1, 1);
        customer.setBirthdate(birthdate);
        assertEquals(birthdate, customer.getBirthdate());
    }

    @Test
    void setEmail() {
        Customer customer = new Customer();
        String email = "john.doe@example.com";
        customer.setEmail(email);
        assertEquals(email, customer.getEmail());
    }

    @Test
    void setPassword() {
        Customer customer = new Customer();
        String password = "password123";
        customer.setPassword(password);
        assertEquals(password, customer.getPassword());
    }

    @Test
    void setActive() {
        Customer customer = new Customer();
        Boolean active = true;
        customer.setActive(active);
        assertEquals(active, customer.getActive());
    }

    @Test
    void testToString() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setCpf("123.456.789-00");
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setSex(GenderEnum.MASCULINO);
        customer.setBirthdate(LocalDate.of(1990, 1, 1));
        customer.setEmail("john.doe@example.com");
        customer.setPassword("password123");
        customer.setActive(true);

        String expected = "Customer{" +
                "id=" + customer.getId() +
                ", cpf='" + customer.getCpf() + '\'' +
                ", firstName='" + customer.getFirstName() + '\'' +
                ", lastName='" + customer.getLastName() + '\'' +
                ", sex='" + customer.getSex() + '\'' +
                ", birthdate='" + customer.getBirthdate() + '\'' +
                ", email='" + customer.getEmail() + '\'' +
                ", password='" + customer.getPassword() + '\'' +
                ", active=" + customer.getActive() +
                '}';

        assertEquals(expected, customer.toString());
    }
}