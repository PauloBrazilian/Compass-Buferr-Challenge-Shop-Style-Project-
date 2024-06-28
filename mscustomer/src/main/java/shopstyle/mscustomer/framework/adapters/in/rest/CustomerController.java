package shopstyle.mscustomer.framework.adapters.in.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shopstyle.mscustomer.application.service.CustomerServiceImpl;
import shopstyle.mscustomer.domain.dto.CustomerDto;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/customers")
public class CustomerController {

    private CustomerServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> findCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(service.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto) {
        return new ResponseEntity<>(service.updateCustomer(id, customerDto), HttpStatus.OK);
    }
}
