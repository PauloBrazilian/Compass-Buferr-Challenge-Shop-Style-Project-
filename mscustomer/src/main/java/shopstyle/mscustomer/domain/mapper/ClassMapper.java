package shopstyle.mscustomer.domain.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import shopstyle.mscustomer.domain.dto.AddressDto;
import shopstyle.mscustomer.domain.dto.CustomerDto;
import shopstyle.mscustomer.domain.entity.Address;
import shopstyle.mscustomer.domain.entity.Customer;

@Mapper(componentModel = "spring")
public interface ClassMapper {

    CustomerDto customerToDto(Customer customer);

    Customer dtoToCustomer(CustomerDto customerDto);

    void updateCustomerToDto(CustomerDto customerDto, @MappingTarget Customer customer);

    @Mapping(target = "customerId", source = "customer")
    AddressDto addressToDto(Address address);

    @Mapping(target = "customer", ignore = true)
    Address dtoToAddress(AddressDto addressDto);

    void updateAddressToDto(AddressDto addressDto, @MappingTarget Address address);
}