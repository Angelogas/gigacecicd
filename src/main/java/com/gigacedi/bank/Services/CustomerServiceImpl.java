package com.gigacedi.bank.Services;

import com.gigacedi.bank.ExceptionHandlers.CustomerAllException;
import com.gigacedi.bank.ExceptionHandlers.CustomerAlreadyExistException;
import com.gigacedi.bank.Repositories.CustomerRepository;
import com.gigacedi.bank.Resources.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }

    public Customer getCustomer(long theId) {

        return customerRepository.getById(theId);

    }

    public void saveCustomer(Customer theCustomer) {


        Optional<Customer> customer = Optional.ofNullable(findCustomer(theCustomer));

        if (customer.isEmpty()) {
            theCustomer.setId(0L);
            customerRepository.save(theCustomer);
        } else {
            throw new CustomerAlreadyExistException();
        }
    }

    public void updateCustomer(Customer theCustomer) {

        Customer customer = findCustomer(theCustomer);
        long id = customer.getId();
        if (id != theCustomer.getId()) {
            throw new CustomerAllException(customer.getFirstName(),customer.getFirstName());
        }
        try {
            customer.setId(id);
            customerRepository.save(customer);
        }catch (NullPointerException e) {
            throw new CustomerAllException(new NullPointerException());
        }catch (RuntimeException e) {
            throw new CustomerAllException(new IllegalArgumentException());
        }
    }

    public void deleteCustomer(Customer theCustomer) {

        try {
            Customer customer = findCustomer(theCustomer);
            customerRepository.delete(customer);

        } catch (NullPointerException exc) {
            throw new CustomerAllException(exc);
        }
        catch (RuntimeException e) {
            throw new CustomerAllException(new IllegalArgumentException());
        }
    }

    public void deleteCustomerById(long id) {

        try {
            Optional<Customer> customer = customerRepository.findById(id);
            customerRepository.delete(customer.get());
        } catch (NullPointerException exc) {
            throw new CustomerAllException(exc);
        }

    }

    public Customer findCustomer(Customer customer) {
        return customerRepository.findCustomerByFirstNameAndLastName(customer.getFirstName(),customer.getLastName());
    }
}
