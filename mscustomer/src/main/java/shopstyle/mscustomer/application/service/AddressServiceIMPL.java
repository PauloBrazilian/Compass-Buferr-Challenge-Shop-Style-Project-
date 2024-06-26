package shopstyle.mscustomer.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.application.ports.in.AddressService;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.framework.adapters.out.persistence.AddressRepository;

@RequiredArgsConstructor
@Service
public class AddressServiceIMPL implements AddressService {

    private final AddressRepository repository;

    private final ClassMapper mapper;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        return null;
    }

    @Override
    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        return null;
    }

    @Override
    public void deleteAddressById(Long id) {

    }
}
