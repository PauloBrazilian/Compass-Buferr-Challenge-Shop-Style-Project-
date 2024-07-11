package shopstyle.mscatalog.application.service.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.out.CategoryStrategy;
import shopstyle.mscatalog.domain.model.Category;
import shopstyle.mscatalog.framework.adapters.out.persistence.CategoryRepository;

@AllArgsConstructor
@Service
public class CategoryStrategyImpl implements CategoryStrategy{

    private final CategoryRepository repository;

    @Override
    public Category findCategoryById(Long id) {
        return repository.findById(id).orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public Category onActive(Boolean active) {
        return repository.getActiveInCategory(active).orElseThrow(CategoryIsNotActiveException::new);
    }

    @Override
    public Category existsParentInCategory(Category parent) {
        return repository.getParentInCategory(parent.getId()).orElseThrow(CategoryIsParentExistsException::new);
    }
}