package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import shopstyle.mscatalog.domain.model.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Object> getActiveInCategory(Boolean active);

    Optional<Object> getParentInCategory(Long parent);
}
