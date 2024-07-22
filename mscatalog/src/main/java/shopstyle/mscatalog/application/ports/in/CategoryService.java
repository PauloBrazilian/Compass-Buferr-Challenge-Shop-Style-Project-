package shopstyle.mscatalog.application.ports.in;

import shopstyle.mscatalog.domain.dto.CategoryDto;
import shopstyle.mscatalog.domain.dto.ProductDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    List<CategoryDto> findAllCategory(CategoryDto categoryDto);

    CategoryDto findCategoryById(Long id, CategoryDto categoryDto, ProductDto productDto);

    CategoryDto updateProductById(Long id, CategoryDto categoryDto);

    void deleteCategoryById(Long id);

}