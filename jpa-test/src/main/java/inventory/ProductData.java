package inventory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

@Entity
@Table(name = "products", uniqueConstraints = {@UniqueConstraint(columnNames = "name")})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String name;
    @Column
    private String description;
    @Column
    @OneToMany
    @JoinTable(
            name = "product_categories",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "category_id")}
    )
    private List<ProductCategoryData> productCategories;
    @Column
    private float originalAmount;
    @Column
    private float discountedAmount;
    @Column
    private int quantity;
    //Images are string with the resource located on S3
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productImages")
    private List<String> productImages;

}
