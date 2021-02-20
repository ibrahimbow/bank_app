package ibrahimcode.be.services.implementation;

import ibrahimcode.be.data.CustomerDao;
import ibrahimcode.be.models.Customer;
import ibrahimcode.be.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("mockService")
public class CustomerServiceImpl  implements CustomerService {


    private CustomerDao customerDaoImpl;

    @Autowired
    public void setCustomerDaoImpl(CustomerDao customerDaoImpl) {
        this.customerDaoImpl = customerDaoImpl;
    }


    @Override
    public void addCustomer(Customer customer) {
        this.customerDaoImpl.createNewCurrentAccount(customer);
    }


    @Override
    public Customer getCustomer(int id) {
        return this.customerDaoImpl.getCustomerInfo(id);
    }

    @Override
    public void openNewCurrentAccount(int id, double initialCredit) {

        this.customerDaoImpl.openNewCurrentAccount(id,initialCredit);

    }

    @Override
    public List<Customer> showAllCustomers() {
        return this.customerDaoImpl.getAllCustomers();
    }
}
