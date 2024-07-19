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
    public void onActive(Boolean active) {
        var response = repository.findByActive(active);
        if (response.equals(true)){
        }else{
            throw new CategoryIsNotActiveException();
        }
    }

    @Override
    public void existsParentInCategory(Category parent) {
        var response = repository.findByParentIn(List.of(parent));
        if (!response.isEmpty()){
        }else {
            throw new CategoryIsParentExistsException();
        }
    }
}
