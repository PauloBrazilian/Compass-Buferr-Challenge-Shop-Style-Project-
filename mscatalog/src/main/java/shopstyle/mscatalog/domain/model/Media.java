package shopstyle.mscatalog.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Media {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "IMAGE_URL")
    private String imgUrl;

    @ManyToOne(targetEntity = Sku.class)
    @JoinColumn(name = "SKU_ID")
    private Sku sku;

}