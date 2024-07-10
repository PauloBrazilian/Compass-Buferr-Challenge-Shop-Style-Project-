package shopstyle.mscatalog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotBlank
    private String brand;


    private String material;

    @NotBlank
    private Boolean active;

    @NotBlank
    private Long categoryId;


}
