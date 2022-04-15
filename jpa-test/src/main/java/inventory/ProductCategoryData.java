package inventory;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product_categories")
@ToString
@Data
public class ProductCategoryData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    private User owner;
    @ManyToMany(mappedBy = "productCategories")
    private List<ProductData> products;
    @Column
    private Date creation_date;
    @Column
    private Date last_update;
    @Column
    private boolean isDeleted;

    public ProductCategoryData(String name, User owner) {
        this.name = name;
        this.owner = owner;
        Date date = new Date();
        this.creation_date = date;
        this.last_update = date;
        this.isDeleted = false;
    }

    public ProductCategoryData() {
        Date date = new Date();
        this.creation_date = date;
        this.last_update = date;
        this.isDeleted = false;
    }
//
//    public ProductCategoryData(ProductCategory category) {
//        this.name = category.getName();
//        this.creation_date = category.getCreationDate();
//        this.last_update = category.getLastUpdate();
//        this.owner = category.getOwnerId();
//    }
//
//    public ProductCategoryData(String name, int owner, Date creation_date, Date last_update) {
//        this.name = name;
//        this.owner = owner;
//        this.creation_date = creation_date;
//        this.last_update = last_update;
//    }
//
//    public static ProductCategoryData fromModel(ProductCategory category) {
//        return new ProductCategoryData(category);
//    }
//
//
//    // TODO: Test mapper
//    public static ProductCategoryData from(ProductCategory productCategory) {
//        return new ProductCategoryData(productCategory.getName(), productCategory.getOwnerId(), productCategory.getCreationDate(), productCategory.getLastUpdate());
//    }
//
//    public ProductCategory toModel() {
//        return new ProductCategory(this.name, this.owner, this.creation_date, this.last_update);
//    }
}