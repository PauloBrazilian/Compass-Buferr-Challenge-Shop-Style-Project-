package shopstyle.mscatalog.application.service.strategy;

import org.springframework.stereotype.Service;
import shopstyle.mscatalog.domain.model.Category;

@Service
public class CategoryStrategyImpl {
    

    if (categoryRepository.exists(Category)) {
        if (Category.getActive() == true) {
            if (categoryRepository.exists(Category.getParent)) {
                return categoryRepository.existsById(id);
            } else {
                throw new RuntimeException("Category have exists Parent, Only category not parents is save");
            }
        } else {
            throw new RuntimeException("Cateogory is not active");
        }
    } else {
        throw new RuntimeException("Categody Not Found");
    }



}
