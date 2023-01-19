package org.acme.controller;

import org.acme.model.Customer;
import org.acme.service.CustomerService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.List;

@Path("/api")
public class CustomerController {

    @Inject
    private CustomerService customerService;

    @GET
    public List<Customer> getCustomers(){
        List<Customer> customers = new ArrayList<Customer>();
        try {
            customers = customerService.getCustomers();
        } catch (Exception e){
            e.printStackTrace();
        }
        return customers;
    }

    @POST
    @Transactional //como estamos utilizando quarkus e esse metodo
    // vai fazer uma alteração no estado do banco de dados
    // pois irá inserir uma informação nova
    // devemos utilizar essa anotação @Transactional
    public void saveCustomer(Customer customer){
        customerService.saveCustomer(customer);
    }
}
