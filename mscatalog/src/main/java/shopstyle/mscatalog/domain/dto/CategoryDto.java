package shopstyle.mscatalog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank
    private String name;

    @NotBlank
    private Boolean active;

    private CategoryDto parent;

}
