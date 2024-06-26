package shopstyle.mscustomer.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Customer {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CPF", unique = true)
    @CPF(message = "Invalid CPF")
    private String cpf;

    @Column(name = "FIRST_NAME")
    @Size(min = 3,max = 50, message = "Nome deve ter entre {min} e {max} caracteres")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "SEX")
    private String sex;

    @Column(name = "BIRTHDATE")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate birthdate;

    @Column(name = "EMAIL", unique = true)
    @Email(message = "Invalid Email")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE")
    private Boolean active;

}