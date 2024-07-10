package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscatalog.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
