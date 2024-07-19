package shopstyle.mscatalog.application.ports.out;

import shopstyle.mscatalog.domain.model.Category;

public interface CategoryStrategy {

    void onActive(Boolean active);

    void existsParentInCategory(Category parent);

}
