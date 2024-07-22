package shopstyle.mscatalog.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SecondaryTable(name = "Parent")
@Entity
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Column(name = "NAME", table = "parent")
    private String parentName;

    @Column(name = "ACTIVE", table = "parent")
    private Boolean parentActive;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "PARENT")
    private Category parent;

}