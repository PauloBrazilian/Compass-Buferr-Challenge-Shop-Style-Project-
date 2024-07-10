package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscatalog.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
