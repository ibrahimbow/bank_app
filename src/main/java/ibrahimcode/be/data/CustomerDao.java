package ibrahimcode.be.data;

import ibrahimcode.be.models.Customer;

import java.util.List;

public interface CustomerDao {
    boolean createNewAccount(Customer customer);
    Customer getCustomerInfo(int id);
    List<Customer> getAllCustomers();
}
