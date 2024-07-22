package shopstyle.mscatalog.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "ACTIVE")
    private Boolean active;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

}