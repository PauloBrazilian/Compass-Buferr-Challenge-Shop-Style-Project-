package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscatalog.domain.model.Sku;

public interface SkuRepository extends JpaRepository<Sku, Long> {
}
