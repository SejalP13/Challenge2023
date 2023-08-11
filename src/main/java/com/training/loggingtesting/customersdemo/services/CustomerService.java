package com.training.loggingtesting.customersdemo.services;


import com.training.loggingtesting.customersdemo.Customer;
import com.training.loggingtesting.customersdemo.exception.CustomerExistsException;
import com.training.loggingtesting.customersdemo.exception.CustomerNotFoundException;
import com.training.loggingtesting.customersdemo.repos.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repository;
    // Add Customer.
    public Customer addCustomer(Customer customer) throws CustomerExistsException {
        if(repository.existsById(customer.getId()))
            throw new CustomerExistsException("Employee with "+customer.getId()+"already exists");
//        long count = this.repository.count();
//        customer.setId(count+1);
        Customer savedCustomer = repository.save(customer);
        //System.out.printf("There are now %d customers\n", repository.count());
        return  savedCustomer;
    }
    // Get all customers.
    public List<Customer> displayCustomers()
    {
        return this.repository.findAll();
    }
    public Customer getCustomerById(String cust_id) throws CustomerNotFoundException {
        return repository.findById(cust_id)
                .orElseThrow(()->new CustomerNotFoundException("employee with "+cust_id+" does not exist"));
    }

    public List<Customer> getAllCustomersByGender(String gender) {
        return this.repository.findByGender(gender);
    }

    public void deleteCustomer(String cus_Id) throws CustomerNotFoundException {

        if(repository.existsById(cus_Id))
            throw new CustomerNotFoundException("employee with "+cus_Id+" does not exist");
        repository.deleteById(cus_Id);
    }
}
