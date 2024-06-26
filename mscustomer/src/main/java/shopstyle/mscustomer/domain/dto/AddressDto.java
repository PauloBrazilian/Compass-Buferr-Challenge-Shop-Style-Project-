package shopstyle.mscustomer.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    @NotBlank(message = "The state is null")
    @Pattern(regexp = "^[SP]{2}$", message = "Only the SP is valid")
    private String state;

    @NotBlank(message = "The city is null")
    private String city;

    @NotBlank(message = "The district is null")
    private String district;

    @NotBlank(message = "The street is null")
    private String street;

    @NotBlank(message = "The number is null")
    private String number;

    @NotBlank(message = "The cep is null")
    @Pattern(regexp = "\\d{2}\\.\\d{3}-\\d{3}", message = "Invalid CEP format. It should be xx.xxx-xxx")
    private String cep;

    private String complement;

    @NotBlank(message = "The customer is null")
    private CustomerDto customer;

}
