package shopstyle.mscatalog.framework.adapters.in.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscatalog.application.service.CategoryServiceImpl;
import shopstyle.mscatalog.domain.dto.CategoryDto;
import shopstyle.mscatalog.domain.dto.ProductDto;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/category")
public class CategoryController {

    private final CategoryServiceImpl serviceImpl;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(serviceImpl.createCategory(categoryDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAllCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(serviceImpl.findAllCategory(categoryDto), HttpStatus.OK);
    }

    @GetMapping("/id/products")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable Long id, @RequestBody CategoryDto categoryDto, @RequestBody ProductDto productDto) {
        return new ResponseEntity<>(serviceImpl.findCategoryById(id, categoryDto, productDto), HttpStatus.OK);
    }

    @PutMapping("/id")
    public ResponseEntity<CategoryDto> updateProductById(@PathVariable Long id, @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(serviceImpl.updateProductById(id, categoryDto), HttpStatus.OK);
    }

    @DeleteMapping("/id")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        serviceImpl.deleteCategoryById(id);
        return new ResponseEntity<>("Category deleted Successfully", HttpStatus.OK);
    }

}