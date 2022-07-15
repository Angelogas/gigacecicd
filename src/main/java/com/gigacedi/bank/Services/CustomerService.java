package com.gigacedi.bank.Services;

import com.gigacedi.bank.Resources.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Customer getCustomer(long id);

    void saveCustomer(Customer theCustomer);
    void updateCustomer (Customer theCustomer);
    Customer findCustomer(Customer customer);

    void deleteCustomer(Customer customer);
    void deleteCustomerById(long id);
}
