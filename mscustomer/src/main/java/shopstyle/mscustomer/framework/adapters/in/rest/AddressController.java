package shopstyle.mscustomer.framework.adapters.in.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscustomer.application.service.AddressServiceImpl;
import shopstyle.mscustomer.domain.dto.AddressDto;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/address")
public class AddressController {

    private AddressServiceImpl serviceIMPL;

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(serviceIMPL.createAddress(addressDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(serviceIMPL.updateAddress(id, addressDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
        serviceIMPL.deleteAddressById(id);
        return new ResponseEntity<>("Delete Address with Success", HttpStatus.OK);
    }

}
