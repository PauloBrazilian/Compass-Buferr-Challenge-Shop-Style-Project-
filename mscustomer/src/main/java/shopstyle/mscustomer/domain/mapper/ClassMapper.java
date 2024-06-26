package shopstyle.mscustomer.domain.mapper;

import org.mapstruct.Mapper;
import shopstyle.mscustomer.domain.entity.Address;
import shopstyle.mscustomer.domain.entity.Customer;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.domain.dto.CustomerDto;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(CustomerDto customerDto);

    AddressDto addressToDto(Address address);

    Address dtoToAddress(AddressDto addressDto);

}