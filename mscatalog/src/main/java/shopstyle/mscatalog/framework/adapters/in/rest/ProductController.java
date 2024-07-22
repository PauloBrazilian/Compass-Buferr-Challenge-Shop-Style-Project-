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
@RequestMapping("/v1/product")
public class ProductController {

    private final ProductServiceImpl serviceImpl;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.createProduct(productDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProducts(@RequestBody ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.findAllProducts(productDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable Long id) {
        return new ResponseEntity<>(serviceImpl.findProductById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable Long id, @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.updateProductById(id, productDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        serviceImpl.deleteProductById(id);
        return new ResponseEntity<>("Product deleted Successfully", HttpStatus.OK);
    }

}