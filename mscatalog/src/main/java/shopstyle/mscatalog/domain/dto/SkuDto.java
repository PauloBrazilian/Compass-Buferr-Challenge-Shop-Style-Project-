package shopstyle.mscatalog.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.*;
import shopstyle.mscatalog.domain.model.Product;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SkuDto {

    @Positive(message = "Only value positive")
    @NotBlank
    private BigDecimal price;

    @Positive(message = "Only value positive")
    @NotBlank
    private Long quantity;

    @NotBlank
    private String color;

    @Positive(message = "Only value positive")
    @NotBlank
    private Long size;

    @Positive(message = "Only value positive")
    @NotBlank
    private Long height;

    @Positive(message = "Only value positive")
    @NotBlank
    private Long width;

    @Positive(message = "Only value positive")
    @NotBlank
    private ProductDto productDto;


}
