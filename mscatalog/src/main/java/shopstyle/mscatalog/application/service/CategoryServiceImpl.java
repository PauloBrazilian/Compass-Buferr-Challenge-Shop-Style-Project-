package shopstyle.mscatalog.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.in.CategoryService;
import shopstyle.mscatalog.domain.dto.CategoryDto;
import shopstyle.mscatalog.domain.dto.ProductDto;
import shopstyle.mscatalog.domain.mapper.ClassMapper;
import shopstyle.mscatalog.framework.adapters.out.persistence.CategoryRepository;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;
    private final ClassMapper mapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findAllCategory(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto findCategoryById(Long id, CategoryDto categoryDto, ProductDto productDto) {
        return null;
    }

    @Override
    public CategoryDto updateProductById(Long id, CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
