package shopstyle.mscustomer.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @CPF(message = "Invalid CPF format. It should be xxx.xxx.xxx-xx")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "Invalid CPF format. It should be xxx.xxx.xxx-xx")
    private Long cpf;

    @NotBlank(message = "The firstName is null")
    @Size(min = 4, message = "FirstName should have at least 4 characters")
    private String firstName;

    @NotBlank(message = "The LastName is null")
    @Size(min = 4, message = "LastName should have at least 4 characters")
    private String lastName;

    @NotBlank(message = "Sex must be either 'Masculino' or 'Feminino'")
    private String sex;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthdate;

    @Email(message = "Email should be in the format: xxxx@gmail.com")
    @Pattern(regexp = "\\w.@gmail.com", message = "Invalid Email format. It should be xxx@gmail.com")
    private String email;

    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    @NotBlank(message = "Active field must not be null")
    private Boolean active;

}
