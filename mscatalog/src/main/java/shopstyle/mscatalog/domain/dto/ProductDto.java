package shopstyle.mscatalog.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @NotNull
    @NotBlank
    @JsonProperty("name")
    private String name;

    @NotNull
    @NotBlank
    @JsonProperty("description")
    private String description;

    @NotNull
    @NotBlank
    @JsonProperty("brand")
    private String brand;

    @JsonProperty("material")
    private String material;

    @NotNull
    @NotBlank
    @JsonProperty("active")
    private Boolean active;

    @NotNull
    @NotBlank
    @JsonProperty("categoryId")
    private Long categoryId;

}
