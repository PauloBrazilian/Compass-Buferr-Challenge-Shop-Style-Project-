package shopstyle.mscatalog.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscatalog.application.ports.in.SkuService;
import shopstyle.mscatalog.domain.dto.SkuDto;
import shopstyle.mscatalog.domain.mapper.ClassMapper;
import shopstyle.mscatalog.framework.adapters.out.persistence.SkuRepository;

@AllArgsConstructor
@Service
public class SkuServiceImpl implements SkuService{

    private final SkuRepository repository;
    private final ClassMapper mapper;


    @Override
    public SkuDto createSku(SkuDto skuDto) {
        return null;
    }

    @Override
    public SkuDto updateSkuById(Long id, SkuDto skuDto) {
        return null;
    }

    @Override
    public void deleteSkuById(Long id) {

    }
}
