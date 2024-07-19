package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopstyle.mscatalog.domain.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
