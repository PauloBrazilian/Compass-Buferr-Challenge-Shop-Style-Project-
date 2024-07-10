package shopstyle.mscatalog.application.ports.in;

import shopstyle.mscatalog.domain.dto.SkuDto;

public interface SkuService {

    SkuDto createSku(SkuDto skuDto);

    SkuDto updateSkuById(Long id, SkuDto skuDto);

    void deleteSkuById(Long id);

}