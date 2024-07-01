package shopstyle.mscustomer.domain.dto;

import org.junit.jupiter.api.Test;
import shopstyle.mscustomer.domain.util.GenderEnum;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDtoTest {

    @Test
    void getCpf() {
        CustomerDto customerDto = new CustomerDto();
        String cpf = "123.456.789-00";
        customerDto.setCpf(cpf);
        assertEquals(cpf, customerDto.getCpf());
    }

    @Test
    void getFirstName() {
        CustomerDto customerDto = new CustomerDto();
        String firstName = "John";
        customerDto.setFirstName(firstName);
        assertEquals(firstName, customerDto.getFirstName());
    }

    @Test
    void getLastName() {
        CustomerDto customerDto = new CustomerDto();
        String lastName = "Doe";
        customerDto.setLastName(lastName);
        assertEquals(lastName, customerDto.getLastName());
    }

    @Test
    void getSex() {
        CustomerDto customerDto = new CustomerDto();
        GenderEnum sex = GenderEnum.FEMININO;
        customerDto.setSex(sex);
        assertEquals(sex, customerDto.getSex());
    }

    @Test
    void getBirthdate() {
        CustomerDto customerDto = new CustomerDto();
        LocalDate birthdate = LocalDate.of(1990, 1, 1);
        customerDto.setBirthdate(birthdate);
        assertEquals(birthdate, customerDto.getBirthdate());
    }

    @Test
    void getEmail() {
        CustomerDto customerDto = new CustomerDto();
        String email = "john.doe@gmail.com";
        customerDto.setEmail(email);
        assertEquals(email, customerDto.getEmail());
    }

    @Test
    void getPassword() {
        CustomerDto customerDto = new CustomerDto();
        String password = "password123";
        customerDto.setPassword(password);
        assertEquals(password, customerDto.getPassword());
    }

    @Test
    void getActive() {
        CustomerDto customerDto = new CustomerDto();
        Boolean active = true;
        customerDto.setActive(active);
        assertEquals(active, customerDto.getActive());
    }

    @Test
    void setCpf() {
        CustomerDto customerDto = new CustomerDto();
        String cpf = "123.456.789-00";
        customerDto.setCpf(cpf);
        assertEquals(cpf, customerDto.getCpf());
    }

    @Test
    void setFirstName() {
        CustomerDto customerDto = new CustomerDto();
        String firstName = "John";
        customerDto.setFirstName(firstName);
        assertEquals(firstName, customerDto.getFirstName());
    }

    @Test
    void setLastName() {
        CustomerDto customerDto = new CustomerDto();
        String lastName = "Doe";
        customerDto.setLastName(lastName);
        assertEquals(lastName, customerDto.getLastName());
    }

    @Test
    void setSex() {
        CustomerDto customerDto = new CustomerDto();
        GenderEnum sex = GenderEnum.MASCULINO;
        customerDto.setSex(sex);
        assertEquals(sex, customerDto.getSex());
    }

    @Test
    void setBirthdate() {
        CustomerDto customerDto = new CustomerDto();
        LocalDate birthdate = LocalDate.of(1990, 1, 1);
        customerDto.setBirthdate(birthdate);
        assertEquals(birthdate, customerDto.getBirthdate());
    }

    @Test
    void setEmail() {
        CustomerDto customerDto = new CustomerDto();
        String email = "john.doe@gmail.com";
        customerDto.setEmail(email);
        assertEquals(email, customerDto.getEmail());
    }

    @Test
    void setPassword() {
        CustomerDto customerDto = new CustomerDto();
        String password = "password123";
        customerDto.setPassword(password);
        assertEquals(password, customerDto.getPassword());
    }

    @Test
    void setActive() {
        CustomerDto customerDto = new CustomerDto();
        Boolean active = true;
        customerDto.setActive(active);
        assertEquals(active, customerDto.getActive());
    }

    @Test
    void testToString() {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setCpf("123.456.789-00");
        customerDto.setFirstName("John");
        customerDto.setLastName("Doe");
        customerDto.setSex(GenderEnum.FEMININO);
        customerDto.setBirthdate(LocalDate.of(1990, 1, 1));
        customerDto.setEmail("john.doe@gmail.com");
        customerDto.setPassword("password123");
        customerDto.setActive(true);

        String expected = "CustomerDto{" +
                "cpf='" + customerDto.getCpf() + '\'' +
                ", firstName='" + customerDto.getFirstName() + '\'' +
                ", lastName='" + customerDto.getLastName() + '\'' +
                ", sex='" + customerDto.getSex() + '\'' +
                ", birthdate='" + customerDto.getBirthdate() + '\'' +
                ", email='" + customerDto.getEmail() + '\'' +
                ", password='" + customerDto.getPassword() + '\'' +
                ", active=" + customerDto.getActive() +
                '}';

        assertEquals(expected, customerDto.toString());
    }

    @Test
    void builder() {
        CustomerDto customerDto = CustomerDto.builder()
                .cpf("123.456.789-00")
                .firstName("John")
                .lastName("Doe")
                .sex(GenderEnum.MASCULINO)
                .birthdate(LocalDate.of(1990, 1, 1))
                .email("john.doe@gmail.com")
                .password("password123")
                .active(true)
                .build();

        assertEquals("123.456.789-00", customerDto.getCpf());
        assertEquals("John", customerDto.getFirstName());
        assertEquals("Doe", customerDto.getLastName());
        assertEquals(GenderEnum.MASCULINO, customerDto.getSex());
        assertEquals(LocalDate.of(1990, 1, 1), customerDto.getBirthdate());
        assertEquals("john.doe@gmail.com", customerDto.getEmail());
        assertEquals("password123", customerDto.getPassword());
        assertEquals(true, customerDto.getActive());
    }
}