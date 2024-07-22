package shopstyle.mscatalog.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.in.CategoryService;
import shopstyle.mscatalog.domain.dto.CategoryDto;
import shopstyle.mscatalog.domain.dto.ProductDto;
import shopstyle.mscatalog.domain.mapper.ClassMapper;
import shopstyle.mscatalog.framework.adapters.out.persistence.CategoryRepository;
import shopstyle.mscatalog.framework.exception.CategoryNotFoundException;
import shopstyle.mscatalog.framework.exception.ProductNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository repository;
    private final ClassMapper mapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        var category = mapper.dtoToCategory(categoryDto);
        repository.save(category);
        return mapper.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> findAllCategory(CategoryDto categoryDto) {
        return repository.findAll().stream().map(mapper::categoryToDto).toList();
    }

    @Override
    public CategoryDto findCategoryById(Long id, CategoryDto categoryDto, ProductDto productDto) {
        return null;
    }

    @Override
    public CategoryDto updateProductById(Long id, CategoryDto categoryDto) {
        var category = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        mapper.updateCategoryToDto(categoryDto, category);
        var savedCategory = repository.save(category);
        return mapper.categoryToDto(savedCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        var product = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        repository.deleteById(product.getId());
    }
}
