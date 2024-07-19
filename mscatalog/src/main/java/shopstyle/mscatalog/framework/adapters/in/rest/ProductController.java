package shopstyle.mscatalog.framework.adapters.in.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscatalog.application.service.ProductServiceImpl;
import shopstyle.mscatalog.domain.dto.ProductDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductServiceImpl serviceImpl;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts(ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.findAllProducts(productDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(Long id) {
        return new ResponseEntity<>(serviceImpl.findProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(Long id, ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.updateProductById(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(Long id) {
        serviceImpl.deleteProductById(id);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}