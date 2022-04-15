import com.autumncode.hibernate.util.SessionUtil;
import inventory.ProductCategoryData;
import inventory.ProductData;
import inventory.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.testng.annotations.Test;

public class InventoryTest {


    @Test
    public void should_create_product_category() {
        try (Session session = SessionUtil.getSession()) {
            Transaction tx = session.beginTransaction();
            User owner = new User("test user", "camilogo1200@gmail.com");

            ProductCategoryData pc = new ProductCategoryData("product Category 1", owner);

            ProductData product = new ProductData();


            session.save(owner);
            session.save(pc);

            tx.commit();
        }
    }

}
