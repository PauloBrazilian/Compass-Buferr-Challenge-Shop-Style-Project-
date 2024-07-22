package shopstyle.mscatalog.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank
    @Size(min = 4, message = "The name should have at least 4 characters")
    private String name;

    @NotBlank
    private Boolean active;

    @JsonProperty("children")
    private ParentDto parents;

}
