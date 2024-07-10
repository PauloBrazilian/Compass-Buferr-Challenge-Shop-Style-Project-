package shopstyle.mscatalog.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sku {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private Long quantity;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "SIZE")
    private Long size;

    @Column(name = "HEIGHT")
    private Long height;

    @Column(name = "WIDTH")
    private Long width;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;
}