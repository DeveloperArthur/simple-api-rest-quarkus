package org.acme.service;

import org.acme.model.Customer;
import org.acme.repository.CustomerRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll().list();
    }

    public void saveCustomer(Customer customer){
        customerRepository.persist(customer);
    }
}
