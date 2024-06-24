package shopstyle.mscustomer.domain.payload;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import shopstyle.mscustomer.domain.model.Customer;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto {

    @NotNull(message = "The state is null")
    private String state;

    @NotNull(message = "The city is null")
    private String city;

    @NotNull(message = "The district is null")
    private String district;

    @NotNull(message = "The street is null")
    private String street;

    @NotNull(message = "The number is null")
    private String number;

    @NotNull(message = "The cep is null")
    @Pattern(regexp = "SP", message = "Only the SP")
    private String cep;
    
    private String complement;

    @NotNull(message = "The customer is null")
    private Customer customer;

}
