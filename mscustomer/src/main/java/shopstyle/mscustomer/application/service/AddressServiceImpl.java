package shopstyle.mscustomer.application.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.application.ports.in.AddressService;
import shopstyle.mscustomer.application.service.strategy.FindCustomer;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.domain.entity.Address;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.framework.adapters.out.persistence.AddressRepository;
import shopstyle.mscustomer.framework.exception.AddressNotFoundException;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    private final FindCustomer findCustomer;

    private final ClassMapper mapper;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        var customer = findCustomer.findCustomerById(addressDto.getCustomerId());
        var address = mapper.dtoToAddress(addressDto);
        address.setCustomer(customer);
        repository.save(address);
        return mapper.addressToDto(address);
    }

    @Override
    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        var address = repository.findById(id).orElseThrow(AddressNotFoundException::new);
        mapper.updateAddressToDto(addressDto, address);
        Address updatedAddress = repository.save(address);
        return mapper.addressToDto(updatedAddress);
    }

    @Override
    public void deleteAddressById(Long id) {
        var address = repository.findById(id).orElseThrow(AddressNotFoundException::new);
        repository.deleteById(address.getId());
    }
}