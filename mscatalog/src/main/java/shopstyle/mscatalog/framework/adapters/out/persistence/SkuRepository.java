package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopstyle.mscatalog.domain.model.Sku;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
}
