package shopstyle.mscatalog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ParentDto {

    @NotBlank
    private String parentName;

    @NotBlank
    private Boolean parentActive;
}
