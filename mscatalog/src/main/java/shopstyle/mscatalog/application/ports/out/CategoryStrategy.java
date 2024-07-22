package shopstyle.mscatalog.application.ports.out;

import shopstyle.mscatalog.domain.model.Category;

import java.util.List;

public interface CategoryStrategy {

    List<Category> onActive(Boolean active);

    List<Category> existsParentInCategory(Category parent);

}
