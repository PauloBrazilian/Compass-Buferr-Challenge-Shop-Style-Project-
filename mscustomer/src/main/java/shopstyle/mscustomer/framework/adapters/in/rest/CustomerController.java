package shopstyle.mscustomer.framework.adapters.in.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscustomer.application.service.CustomerServiceImpl;
import shopstyle.mscustomer.domain.dto.CustomerDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class CustomerController {

    private CustomerServiceImpl serviceIMPL;

    @GetMapping
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable float id) {
        return new ResponseEntity<>(serviceIMPL.findCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(serviceIMPL.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable float id, @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(serviceIMPL.updateCustomer(id, customerDto), HttpStatus.OK);
    }
}
