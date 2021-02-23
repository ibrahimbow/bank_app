package ibrahimcode.be.services;

import ibrahimcode.be.models.Customer;

import java.util.List;


public interface CustomerService {
    void addCustomer(Customer customer); // just in case we can use it for single customer to add
    Customer getCustomer(int id);
    void addCustomers(List<Customer> customer);
    List<Customer> showAllCustomers();
}
