package shopstyle.mscatalog.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.in.ProductService;
import shopstyle.mscatalog.application.service.strategy.CategoryStrategyImpl;
import shopstyle.mscatalog.domain.dto.ProductDto;
import shopstyle.mscatalog.domain.mapper.ClassMapper;
import shopstyle.mscatalog.domain.model.Category;
import shopstyle.mscatalog.framework.adapters.out.persistence.CategoryRepository;
import shopstyle.mscatalog.framework.adapters.out.persistence.ProductRepository;
import shopstyle.mscatalog.framework.exception.CategoryNotFoundException;
import shopstyle.mscatalog.framework.exception.ProductNotFoundException;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private CategoryStrategyImpl strategy;
    private CategoryRepository categoryRepository;
    private final ProductRepository repository;
    private final ClassMapper mapper;


    @Override
    public ProductDto createProduct(ProductDto productDto) {
        var product = mapper.dtoToProduct(productDto);
        product.setCategory(verificationCategory(product.getCategory()));
        repository.save(product);
        return mapper.productToDto(product);
    }

    @Override
    public List<ProductDto> findAllProducts(ProductDto productDto) {
        return repository.findAll().stream().map(mapper::productToDto).toList();
    }

    @Override
    public ProductDto findProductById(Long id) {
        var product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        return mapper.productToDto(product);
    }

    @Override
    public ProductDto updateProductById(Long id, ProductDto productDto) {
        var product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        mapper.updateProductToDto(productDto, product);
        var savedProduct = repository.save(product);
        return mapper.productToDto(savedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        var product = repository.findById(id).orElseThrow(ProductNotFoundException::new);
        repository.deleteById(product.getId());
    }

    private Category verificationCategory(Category category){
        var response = categoryRepository.findById(category.getId()).orElseThrow(CategoryNotFoundException::new);
        strategy.onActive(response.getActive());
        strategy.existsParentInCategory(response);
        return response;
    }


}
