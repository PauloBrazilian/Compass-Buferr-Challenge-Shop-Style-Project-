package shopstyle.mscustomer.application.ports.in;

import shopstyle.mscustomer.domain.dto.AddressDto;

public interface AddressService {

    AddressDto createAddress(AddressDto addressDto);

    AddressDto updateAddress(Long id, AddressDto addressDto);

    void deleteAddressById(Long id);

}