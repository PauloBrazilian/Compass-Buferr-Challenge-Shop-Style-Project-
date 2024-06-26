package shopstyle.mscustomer.framework.adapters.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscustomer.application.service.AddressServiceIMPL;
import shopstyle.mscustomer.domain.dto.AddressDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AddressController {

    private AddressServiceIMPL serviceIMPL;

    @PostMapping
    public ResponseEntity<AddressDto> createAddress(@RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(serviceIMPL.createAddress(addressDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<AddressDto> updateAddress(@PathVariable Long id, @RequestBody AddressDto addressDto) {
        return new ResponseEntity<>(serviceIMPL.updateAddress(id, addressDto), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteAddressById(@PathVariable Long id) {
        serviceIMPL.deleteAddressById(id);
        return new ResponseEntity<>("Delete Address with Success", HttpStatus.OK);
    }

}
