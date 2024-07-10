package shopstyle.mscatalog.domain.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SecondaryTable(name = "parent")
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

    @Column(name = "PARENT_NAME", table = "parent")
    private String parentName;

    @Column(name = "PARENT_ACTIVE", table = "parent")
    private Boolean parentActive;

    @ManyToOne
    @JoinColumn(name = "PARENT_ID", table = "Parent")
    private Category parent;

}