package ibrahimcode.be.services;

import ibrahimcode.be.models.Customer;

import java.util.List;


public interface CustomerService {

    void addCustomer(Customer customer);
    Customer getCustomer(int id);
    void addCustomers(List<Customer> customer);
    List<Customer> showAllCustomers();
}
