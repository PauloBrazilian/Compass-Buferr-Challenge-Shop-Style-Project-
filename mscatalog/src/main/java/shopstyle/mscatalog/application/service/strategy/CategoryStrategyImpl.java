package shopstyle.mscatalog.application.service.strategy;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.out.CategoryStrategy;
import shopstyle.mscatalog.domain.model.Category;
import shopstyle.mscatalog.framework.adapters.out.persistence.CategoryRepository;
import shopstyle.mscatalog.framework.exception.CategoryIsNotActiveException;
import shopstyle.mscatalog.framework.exception.CategoryIsParentExistsException;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryStrategyImpl implements CategoryStrategy {

    private final CategoryRepository repository;

    @Override
    public List<Category> onActive(Boolean active) {
        var response = repository.findByActive(active);
        if (response.equals(true)){
            return response;
        }else{
            throw new CategoryIsNotActiveException();
        }
    }

    @Override
    public List<Category> existsParentInCategory(Category parent) {
        var response = repository.findByParentIn(List.of(parent));
        if (response.isEmpty()){
            return response;
        }else {
            throw new CategoryIsParentExistsException();
        }
    }
}
