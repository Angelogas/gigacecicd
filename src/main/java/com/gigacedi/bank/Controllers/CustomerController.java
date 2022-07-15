package com.gigacedi.bank.Controllers;


import com.gigacedi.bank.ExceptionHandlers.CustomerAllException;
import com.gigacedi.bank.Resources.Customer;
import com.gigacedi.bank.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping ("/customers")
    public List<Customer> getAllCustomers () {
        return customerService.getAllCustomers();
    }

    @GetMapping ("/customers/{customerId}")
    public Customer getCustomer (@PathVariable int customerId) {
        Customer theCustomer;
        if (customerId ==0 || customerId >= customerService.getAllCustomers().size()) {
            throw new CustomerAllException(new NullPointerException());
        } else {
            theCustomer = customerService.getCustomer(customerId);
        }
        return theCustomer;
    }

    @PostMapping("/customers/save")
    public Customer addCustomer (@RequestBody Customer theCustomer) {

        customerService.saveCustomer(theCustomer);
        return theCustomer;
    }

    @PutMapping ("customers/update")
    public Customer updateCustomer (@RequestBody Customer theCustomer) {
        customerService.updateCustomer (theCustomer);
        return theCustomer;
    }

    @DeleteMapping ("customers/delete")
    public String deleteCustomer (@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
        return "Deleted customer";
    }

    @DeleteMapping ("/customers/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomerById(id);
        return "Customer deleted";
    }

}
