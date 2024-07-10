package shopstyle.mscatalog.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import shopstyle.mscatalog.domain.dto.CategoryDto;
import shopstyle.mscatalog.domain.dto.MediaDto;
import shopstyle.mscatalog.domain.dto.ProductDto;
import shopstyle.mscatalog.domain.dto.SkuDto;
import shopstyle.mscatalog.domain.model.Category;
import shopstyle.mscatalog.domain.model.Media;
import shopstyle.mscatalog.domain.model.Product;
import shopstyle.mscatalog.domain.model.Sku;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    CategoryDto categoryToDto(Category category);
    Category dtoToCategory(CategoryDto categoryDto);
    void updateCategoryToDto(CategoryDto categoryDto, @MappingTarget Category category);

    MediaDto mediaToDto(Media media);
    Media dtoToMedia(MediaDto mediaDto);

    @Mapping(target = "categoryId", source = "id")
    ProductDto productToDto(Product product);
    @Mapping(target = "id", source = "categoryId")
    Product dtoToProduct(ProductDto productDto);
    void updateProductToDto(ProductDto productDto, @MappingTarget Product product);

    SkuDto skuToDto(Sku sku);
    Sku dtoToSku(SkuDto skuDto);
    void updateSkuToDto(SkuDto skuDto, @MappingTarget Sku sku);

}
