package shopstyle.mscustomer.domain.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDto {

    @CPF
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Invalid CPF format. It should be xxx.xxx.xxx-xx")
    private float cpf;

    @NotNull(message = "The firstName is null")
    @Size(min = 3, message = "FirstName should have at least 3 characters")
    private String firstName;

    @NotNull(message = "The LastName is null")
    @Size(min = 3, message = "LastName should have at least 3 characters")
    private String lastName;

    @Pattern(regexp = "Masculino|Feminino", message = "Sex must be either 'Masculino' or 'Feminino'")
    private String sex;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @Email(message = "Email should be in the format: xxxx@gmail.com")
    private String email;

    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotNull(message = "Active field must not be null")
    private Boolean active;

}
