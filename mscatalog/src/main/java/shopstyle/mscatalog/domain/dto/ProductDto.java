package shopstyle.mscatalog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotBlank(message = "The name cannot be empty")
    @Size(min = 4, message = "name should have at least 4 characters")
    private String name;

    @NotBlank(message = "The description cannot be empty")
    @Size(min = 3, message = "The description should have at least 4 characters")
    private String description;

    @NotBlank(message = "The brand cannot be empty")
    @Size(min = 3, message = "The brand should have at least 4 characters")
    private String brand;

    private String material;

    @NotBlank(message = "The active must be true or false")
    private Boolean active;

    @NotBlank(message = "The categoryId is invalid")
    private Long categoryId;

}