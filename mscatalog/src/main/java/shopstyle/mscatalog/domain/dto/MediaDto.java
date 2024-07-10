package shopstyle.mscatalog.domain.dto;

import lombok.*;
import shopstyle.mscatalog.domain.model.Sku;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MediaDto {

    private String imgUrl;

    private Sku sku;

}
