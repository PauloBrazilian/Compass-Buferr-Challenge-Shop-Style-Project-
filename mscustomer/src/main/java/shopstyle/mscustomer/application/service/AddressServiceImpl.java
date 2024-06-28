package shopstyle.mscustomer.application.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import shopstyle.mscustomer.application.ports.in.AddressService;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.domain.entity.Address;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.mapper.ClassMapper;
import shopstyle.mscustomer.framework.adapters.out.persistence.AddressRepository;
import shopstyle.mscustomer.framework.adapters.out.persistence.CustomerRepository;
import shopstyle.mscustomer.framework.exception.AddressNotFoundException;
import shopstyle.mscustomer.framework.exception.CustomerNotFoundException;

@AllArgsConstructor
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository repository;

    private final CustomerRepository customerRepository;

    private final ClassMapper mapper;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        var customer = findCustomerById(addressDto.getCustomerId());
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


    public Customer findCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }



}
