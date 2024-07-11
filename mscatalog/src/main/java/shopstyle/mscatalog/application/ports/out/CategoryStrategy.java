package shopstyle.mscatalog.application.ports.out;

import shopstyle.mscatalog.domain.model.Category;

public interface CategoryStrategy {

    Category findCategoryById(Long id);

    Category onActive(Boolean active);

    Category existsParentInCategory(Category parent);

}
