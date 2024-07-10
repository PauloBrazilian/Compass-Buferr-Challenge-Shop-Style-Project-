package shopstyle.mscatalog.application.ports.in;

import shopstyle.mscatalog.domain.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto productDto);

    List<ProductDto> findAllProducts(ProductDto productDto);

    ProductDto findProductById(Long id);

    ProductDto updateProductById(Long id, ProductDto productDto);

    void deleteProductById(Long id);

}
