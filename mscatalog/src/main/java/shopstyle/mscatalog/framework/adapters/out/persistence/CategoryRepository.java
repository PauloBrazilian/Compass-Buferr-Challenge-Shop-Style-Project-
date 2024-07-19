package shopstyle.mscatalog.framework.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shopstyle.mscatalog.domain.model.Category;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByActive(Boolean active);

    List<Category> findByParentIn(List<Category> parent);

}